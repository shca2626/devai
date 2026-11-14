package q3;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import t3.AbstractC1629b;
import t3.C1630c;

/* renamed from: q3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1495b {

    /* renamed from: a, reason: collision with root package name */
    public final ECPrivateKey f21422a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f21423b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f21424c;

    /* renamed from: d, reason: collision with root package name */
    public final int f21425d;

    /* renamed from: q3.b$b, reason: collision with other inner class name */
    public static final class C0256b {

        /* renamed from: a, reason: collision with root package name */
        public ECPrivateKey f21426a = null;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f21427b = null;

        /* renamed from: c, reason: collision with root package name */
        public byte[] f21428c = null;

        /* renamed from: d, reason: collision with root package name */
        public int f21429d = 4096;

        public C1495b e() {
            return new C1495b(this);
        }

        public C0256b f(byte[] bArr) {
            this.f21428c = (byte[]) bArr.clone();
            return this;
        }

        public C0256b g(ECPrivateKey eCPrivateKey) {
            this.f21426a = eCPrivateKey;
            return this;
        }

        public C0256b h(ECPublicKey eCPublicKey) {
            this.f21427b = AbstractC1629b.n(AbstractC1494a.f21421f, AbstractC1494a.f21420e, eCPublicKey.getW());
            return this;
        }
    }

    public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr2 != null) {
            throw new GeneralSecurityException("contextInfo must be null because it is unused");
        }
        if (bArr.length < 103) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (bArr.length > 4096) {
            throw new GeneralSecurityException("ciphertext too long");
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byte[] bArr3 = new byte[16];
        byteBufferWrap.get(bArr3);
        int i7 = byteBufferWrap.getInt();
        if (i7 > this.f21425d || i7 < bArr.length - 86) {
            throw new GeneralSecurityException("invalid record size: " + i7);
        }
        byte b7 = byteBufferWrap.get();
        if (b7 != 65) {
            throw new GeneralSecurityException("invalid ephemeral public key size: " + ((int) b7));
        }
        byte[] bArr4 = new byte[65];
        byteBufferWrap.get(bArr4);
        ECPoint eCPointL = AbstractC1629b.l(AbstractC1494a.f21421f, AbstractC1494a.f21420e, bArr4);
        byte[] bArr5 = new byte[bArr.length - 86];
        byteBufferWrap.get(bArr5);
        byte[] bArrB = AbstractC1496c.b(AbstractC1629b.a(this.f21422a, eCPointL), this.f21424c, this.f21423b, bArr4);
        return b(AbstractC1496c.a(bArrB, bArr3), AbstractC1496c.c(bArrB, bArr3), bArr5);
    }

    public final byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        Cipher cipher = (Cipher) C1630c.f22566b.a("AES/GCM/NoPadding");
        cipher.init(2, new SecretKeySpec(bArr, "AES"), new GCMParameterSpec(128, bArr2));
        byte[] bArrDoFinal = cipher.doFinal(bArr3);
        if (bArrDoFinal.length == 0) {
            throw new GeneralSecurityException("decryption failed");
        }
        int length = bArrDoFinal.length - 1;
        while (length > 0 && bArrDoFinal[length] == 0) {
            length--;
        }
        if (bArrDoFinal[length] == 2) {
            return Arrays.copyOf(bArrDoFinal, length);
        }
        throw new GeneralSecurityException("decryption failed");
    }

    public C1495b(C0256b c0256b) {
        if (c0256b.f21426a == null) {
            throw new IllegalArgumentException("must set recipient's private key with Builder.withRecipientPrivateKey");
        }
        this.f21422a = c0256b.f21426a;
        if (c0256b.f21427b == null || c0256b.f21427b.length != 65) {
            throw new IllegalArgumentException("recipient public key must have 65 bytes");
        }
        this.f21423b = c0256b.f21427b;
        if (c0256b.f21428c == null) {
            throw new IllegalArgumentException("must set auth secret with Builder.withAuthSecret");
        }
        if (c0256b.f21428c.length != 16) {
            throw new IllegalArgumentException("auth secret must have 16 bytes");
        }
        this.f21424c = c0256b.f21428c;
        if (c0256b.f21429d < 18 || c0256b.f21429d > 4096) {
            throw new IllegalArgumentException(String.format("invalid record size (%s); must be a number between [%s, %s]", Integer.valueOf(c0256b.f21429d), 103, 4096));
        }
        this.f21425d = c0256b.f21429d;
    }
}
