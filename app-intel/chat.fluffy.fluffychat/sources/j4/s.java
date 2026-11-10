package j4;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import i4.t;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class s implements n {

    /* renamed from: a, reason: collision with root package name */
    public final String f18773a;

    /* renamed from: b, reason: collision with root package name */
    public final Cipher f18774b;

    /* renamed from: c, reason: collision with root package name */
    public final SecureRandom f18775c;

    /* renamed from: d, reason: collision with root package name */
    public final Key f18776d;

    public s(Context context, InterfaceC1241b interfaceC1241b, Cipher cipher, t tVar) {
        String strE = tVar.e();
        this.f18773a = strE;
        SecureRandom secureRandom = new SecureRandom();
        this.f18775c = secureRandom;
        SharedPreferences sharedPreferences = context.getSharedPreferences(strE, 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        String string = sharedPreferences.getString("AESVGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK", null);
        this.f18774b = d();
        if (string != null) {
            this.f18776d = interfaceC1241b.b(Base64.decode(string, 0), "AES");
            return;
        }
        byte[] bArr = new byte[16];
        secureRandom.nextBytes(bArr);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.f18776d = secretKeySpec;
        editorEdit.putString("AESVGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK", Base64.encodeToString(interfaceC1241b.a(secretKeySpec), 0));
        editorEdit.apply();
    }

    @Override // j4.n
    public byte[] a(byte[] bArr) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, InvalidAlgorithmParameterException {
        int iE = e();
        byte[] bArr2 = new byte[iE];
        this.f18775c.nextBytes(bArr2);
        this.f18774b.init(1, this.f18776d, f(bArr2));
        byte[] bArrDoFinal = this.f18774b.doFinal(bArr);
        byte[] bArr3 = new byte[bArrDoFinal.length + iE];
        System.arraycopy(bArr2, 0, bArr3, 0, iE);
        System.arraycopy(bArrDoFinal, 0, bArr3, iE, bArrDoFinal.length);
        return bArr3;
    }

    @Override // j4.n
    public byte[] b(byte[] bArr) throws InvalidKeyException, InvalidAlgorithmParameterException {
        int iE = e();
        byte[] bArr2 = new byte[iE];
        System.arraycopy(bArr, 0, bArr2, 0, iE);
        AlgorithmParameterSpec algorithmParameterSpecF = f(bArr2);
        int length = bArr.length - e();
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, iE, bArr3, 0, length);
        this.f18774b.init(2, this.f18776d, algorithmParameterSpecF);
        return this.f18774b.doFinal(bArr3);
    }

    @Override // j4.n
    public void c(Context context) {
        context.getSharedPreferences(this.f18773a, 0).edit().remove("AESVGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK").apply();
    }

    public Cipher d() {
        return Cipher.getInstance("AES/GCM/NoPadding");
    }

    public int e() {
        return 12;
    }

    public AlgorithmParameterSpec f(byte[] bArr) {
        return new GCMParameterSpec(128, bArr);
    }
}
