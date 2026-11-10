package j4;

import android.content.Context;
import android.content.res.Configuration;
import android.security.keystore.KeyGenParameterSpec;
import i4.t;
import java.io.IOException;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.util.Calendar;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes.dex */
public class k implements InterfaceC1241b {

    /* renamed from: a, reason: collision with root package name */
    public final String f18755a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f18756b;

    /* renamed from: c, reason: collision with root package name */
    public final t f18757c;

    public k(Context context, t tVar) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException {
        this.f18756b = context;
        this.f18757c = tVar;
        this.f18755a = context.getPackageName() + ".FlutterSecureStoragePluginKeyOAEP" + tVar.g();
        f(context);
    }

    @Override // j4.InterfaceC1241b
    public byte[] a(Key key) throws Exception {
        PublicKey publicKeyI = i();
        Cipher cipherJ = j();
        cipherJ.init(3, publicKeyI, g());
        return cipherJ.wrap(key);
    }

    @Override // j4.InterfaceC1241b
    public Key b(byte[] bArr, String str) throws Exception {
        PrivateKey privateKeyH = h();
        Cipher cipherJ = j();
        cipherJ.init(4, privateKeyH, g());
        return cipherJ.unwrap(bArr, str, 3);
    }

    @Override // j4.InterfaceC1241b
    public void c() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        keyStore.deleteEntry(this.f18755a);
    }

    @Override // j4.InterfaceC1241b
    public Cipher d(Context context) {
        return null;
    }

    public final void e(Context context) {
        Locale locale = Locale.getDefault();
        try {
            l(Locale.ENGLISH);
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 25);
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            keyPairGenerator.initialize(k(context, calendar, calendar2));
            keyPairGenerator.generateKeyPair();
        } finally {
            l(locale);
        }
    }

    public final void f(Context context) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        Key key = keyStore.getKey(this.f18755a, null);
        Certificate certificate = keyStore.getCertificate(this.f18755a);
        if (key == null || certificate == null) {
            e(context);
        }
    }

    public final AlgorithmParameterSpec g() {
        return new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
    }

    public final PrivateKey h() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        Key key = keyStore.getKey(this.f18755a, null);
        if (key != null) {
            if (key instanceof PrivateKey) {
                return (PrivateKey) key;
            }
            throw new Exception("Not an instance of a PrivateKey");
        }
        throw new Exception("No key found under alias: " + this.f18755a);
    }

    public final PublicKey i() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        Certificate certificate = keyStore.getCertificate(this.f18755a);
        if (certificate == null) {
            throw new Exception("No certificate found under alias: " + this.f18755a);
        }
        PublicKey publicKey = certificate.getPublicKey();
        if (publicKey != null) {
            return publicKey;
        }
        throw new Exception("No key found under alias: " + this.f18755a);
    }

    public final Cipher j() {
        return Cipher.getInstance("RSA/ECB/OAEPPadding", "AndroidKeyStoreBCWorkaround");
    }

    public final AlgorithmParameterSpec k(Context context, Calendar calendar, Calendar calendar2) {
        return new KeyGenParameterSpec.Builder(this.f18755a, 3).setCertificateSubject(new X500Principal("CN=" + this.f18755a)).setDigests("SHA-256").setBlockModes("ECB").setEncryptionPaddings("OAEPPadding").setCertificateSerialNumber(BigInteger.valueOf(1L)).setCertificateNotBefore(calendar.getTime()).setCertificateNotAfter(calendar2.getTime()).build();
    }

    public final void l(Locale locale) {
        Locale.setDefault(locale);
        Configuration configuration = this.f18756b.getResources().getConfiguration();
        configuration.setLocale(locale);
        this.f18756b.createConfigurationContext(configuration);
    }
}
