package O0;

import android.net.Uri;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class a implements G0.f {

    /* renamed from: a, reason: collision with root package name */
    public final G0.f f6482a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f6483b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f6484c;

    /* renamed from: d, reason: collision with root package name */
    public CipherInputStream f6485d;

    public a(G0.f fVar, byte[] bArr, byte[] bArr2) {
        this.f6482a = fVar;
        this.f6483b = bArr;
        this.f6484c = bArr2;
    }

    @Override // G0.f
    public void close() {
        if (this.f6485d != null) {
            this.f6485d = null;
            this.f6482a.close();
        }
    }

    public Cipher f() {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }

    @Override // G0.f
    public final void l(G0.x xVar) {
        j3.o.q(xVar);
        this.f6482a.l(xVar);
    }

    @Override // G0.f
    public final Map n() {
        return this.f6482a.n();
    }

    @Override // G0.f
    public final Uri r() {
        return this.f6482a.r();
    }

    @Override // B0.InterfaceC0309k
    public final int read(byte[] bArr, int i7, int i8) throws IOException {
        j3.o.q(this.f6485d);
        int i9 = this.f6485d.read(bArr, i7, i8);
        if (i9 < 0) {
            return -1;
        }
        return i9;
    }

    @Override // G0.f
    public final long s(G0.j jVar) throws InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            Cipher cipherF = f();
            try {
                cipherF.init(2, new SecretKeySpec(this.f6483b, "AES"), new IvParameterSpec(this.f6484c));
                G0.h hVar = new G0.h(this.f6482a, jVar);
                this.f6485d = new CipherInputStream(hVar, cipherF);
                hVar.d();
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e7) {
                throw new RuntimeException(e7);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e8) {
            throw new RuntimeException(e8);
        }
    }
}
