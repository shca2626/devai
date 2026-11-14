package j4;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import i4.t;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class r implements n {

    /* renamed from: a, reason: collision with root package name */
    public final String f18768a;

    /* renamed from: d, reason: collision with root package name */
    public final Key f18771d;

    /* renamed from: c, reason: collision with root package name */
    public final SecureRandom f18770c = new SecureRandom();

    /* renamed from: b, reason: collision with root package name */
    public final Cipher f18769b = e();

    public r(Context context, InterfaceC1240b interfaceC1240b, Cipher cipher, t tVar) {
        this.f18768a = tVar.e();
        this.f18771d = g(context, cipher);
    }

    public static boolean f(SharedPreferences sharedPreferences) {
        return sharedPreferences.contains("BVGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK");
    }

    @Override // j4.n
    public byte[] a(byte[] bArr) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArrD = d(12);
        this.f18769b.init(1, this.f18771d, new GCMParameterSpec(128, bArrD));
        byte[] bArrDoFinal = this.f18769b.doFinal(bArr);
        byte[] bArr2 = new byte[bArrD.length + bArrDoFinal.length];
        System.arraycopy(bArrD, 0, bArr2, 0, bArrD.length);
        System.arraycopy(bArrDoFinal, 0, bArr2, bArrD.length, bArrDoFinal.length);
        return bArr2;
    }

    @Override // j4.n
    public byte[] b(byte[] bArr) throws InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArr2 = new byte[12];
        System.arraycopy(bArr, 0, bArr2, 0, 12);
        int length = bArr.length - 12;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, 12, bArr3, 0, length);
        this.f18769b.init(2, this.f18771d, new GCMParameterSpec(128, bArr2));
        return this.f18769b.doFinal(bArr3);
    }

    @Override // j4.n
    public void c(Context context) {
        context.getSharedPreferences(this.f18768a, 0).edit().remove("BVGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK").apply();
    }

    public byte[] d(int i7) {
        byte[] bArr = new byte[i7];
        this.f18770c.nextBytes(bArr);
        return bArr;
    }

    public Cipher e() {
        return Cipher.getInstance("AES/GCM/NoPadding");
    }

    public final SecretKey g(Context context, Cipher cipher) throws BadPaddingException, IllegalBlockSizeException {
        if (cipher == null) {
            cipher = e();
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(this.f18768a, 0);
        String string = sharedPreferences.getString("BVGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK", null);
        if (string != null) {
            return new SecretKeySpec(cipher.doFinal(Base64.decode(string, 0)), "AES");
        }
        byte[] bArrD = d(32);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArrD, "AES");
        byte[] bArrDoFinal = cipher.doFinal(bArrD);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("BVGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK", Base64.encodeToString(bArrDoFinal, 0));
        editorEdit.apply();
        return secretKeySpec;
    }
}
