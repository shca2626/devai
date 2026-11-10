package j4;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import android.util.Log;
import i4.t;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* loaded from: classes.dex */
public class j implements InterfaceC1241b {

    /* renamed from: a, reason: collision with root package name */
    public final String f18752a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f18753b;

    /* renamed from: c, reason: collision with root package name */
    public final t f18754c;

    public j(Context context, t tVar) throws Exception {
        this.f18753b = context;
        this.f18754c = tVar;
        this.f18752a = f(context);
        g();
    }

    @Override // j4.InterfaceC1241b
    public byte[] a(Key key) {
        throw new UnsupportedOperationException("AES symmetric keys in AndroidKeyStore cannot wrap other keys");
    }

    @Override // j4.InterfaceC1241b
    public Key b(byte[] bArr, String str) {
        throw new UnsupportedOperationException("AES symmetric keys in AndroidKeyStore cannot unwrap other keys");
    }

    @Override // j4.InterfaceC1241b
    public void c() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        keyStore.deleteEntry(this.f18752a);
        this.f18753b.getSharedPreferences(this.f18754c.e(), 0).edit().remove("KeyStoreIV1").apply();
    }

    @Override // j4.InterfaceC1241b
    public Cipher d(Context context) throws Exception {
        g();
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        return i(context, keyStore.getKey(this.f18752a, null));
    }

    public final void e(KeyGenParameterSpec.Builder builder) {
        builder.setUserAuthenticationValidityDurationSeconds(-1);
    }

    public String f(Context context) {
        return context.getPackageName() + ".FlutterSecureStoragePluginKey" + this.f18754c.g();
    }

    public final void g() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        Key key = keyStore.getKey(this.f18752a, null);
        if (key == null) {
            h();
            return;
        }
        if (key instanceof SecretKey) {
            return;
        }
        Log.w("AESCipher23", "Alias " + this.f18752a + " holds a " + key.getClass().getSimpleName() + ", not a SecretKey, replacing it with a fresh symmetric key");
        keyStore.deleteEntry(this.f18752a);
        h();
    }

    public void h() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        boolean zJ = j();
        if (this.f18754c.f() && !zJ) {
            throw new Exception("BIOMETRIC_UNAVAILABLE: Biometric enforcement enabled but device has no PIN, pattern, password, or biometric enrolled. Cannot generate secure key.");
        }
        if (!zJ) {
            Log.w("AESCipher23", "Device has no PIN/biometric security. Generating key without user authentication requirement (enforceBiometrics=false).");
        }
        KeyGenParameterSpec.Builder keySize = new KeyGenParameterSpec.Builder(this.f18752a, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256);
        if (zJ) {
            keySize.setUserAuthenticationRequired(true);
            if (Build.VERSION.SDK_INT >= 30) {
                keySize.setUserAuthenticationParameters(0, this.f18754c.t() ? 2 : 3);
            } else {
                e(keySize);
            }
            keySize.setInvalidatedByBiometricEnrollment(true);
        } else {
            keySize.setUserAuthenticationRequired(false);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            keySize.setUnlockedDeviceRequired(true);
            if (k()) {
                keySize.setIsStrongBoxBacked(true);
                Log.d("AESCipher23", "StrongBox is available and enabled for biometric key");
            } else {
                Log.w("AESCipher23", "StrongBox requested but not available on this device. Using standard TEE.");
            }
        }
        try {
            keyGenerator.init(keySize.build());
            keyGenerator.generateKey();
        } catch (Exception e7) {
            int i7 = Build.VERSION.SDK_INT;
            if (i7 < 28 || !k()) {
                throw e7;
            }
            Log.w("AESCipher23", " Key generation failed with StrongBox. Retrying without StrongBox.", e7);
            KeyGenParameterSpec.Builder unlockedDeviceRequired = new KeyGenParameterSpec.Builder(this.f18752a, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).setUnlockedDeviceRequired(true);
            if (zJ) {
                unlockedDeviceRequired.setUserAuthenticationRequired(true);
                if (i7 >= 30) {
                    unlockedDeviceRequired.setUserAuthenticationParameters(0, this.f18754c.t() ? 2 : 3);
                } else {
                    e(unlockedDeviceRequired);
                }
                unlockedDeviceRequired.setInvalidatedByBiometricEnrollment(true);
            }
            keyGenerator.init(unlockedDeviceRequired.build());
            keyGenerator.generateKey();
            Log.d("AESCipher23", "Key generation succeeded without StrongBox");
        }
    }

    public Cipher i(Context context, Key key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        SharedPreferences sharedPreferences = context.getSharedPreferences(this.f18754c.e(), 0);
        String string = sharedPreferences.getString("KeyStoreIV1", null);
        if (string != null && r.f(sharedPreferences)) {
            cipher.init(2, key, new GCMParameterSpec(128, Base64.decode(string, 0)));
            return cipher;
        }
        cipher.init(1, key);
        byte[] iv = cipher.getIV();
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("KeyStoreIV1", Base64.encodeToString(iv, 0));
        editorEdit.apply();
        return cipher;
    }

    public boolean j() {
        KeyguardManager keyguardManager = (KeyguardManager) this.f18753b.getSystemService("keyguard");
        return keyguardManager != null && keyguardManager.isDeviceSecure();
    }

    public boolean k() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return this.f18753b.getPackageManager().hasSystemFeature("android.hardware.strongbox_keystore");
    }
}
