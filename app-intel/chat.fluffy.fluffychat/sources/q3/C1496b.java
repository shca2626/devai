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
import t3.AbstractC1630b;
import t3.C1631c;

/* renamed from: q3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1496b {

    /* renamed from: a, reason: collision with root package name */
    public final ECPrivateKey f21416a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f21417b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f21418c;

    /* renamed from: d, reason: collision with root package name */
    public final int f21419d;

    /* renamed from: q3.b$b, reason: collision with other inner class name */
    public static final class C0256b {

        /* renamed from: a, reason: collision with root package name */
        public ECPrivateKey f21420a = null;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f21421b = null;

        /* renamed from: c, reason: collision with root package name */
        public byte[] f21422c = null;

        /* renamed from: d, reason: collision with root package name */
        public int f21423d = 4096;

        public C1496b e() {
            return new C1496b(this);
        }

        public C0256b f(byte[] bArr) {
            this.f21422c = (byte[]) bArr.clone();
            return this;
        }

        public C0256b g(ECPrivateKey eCPrivateKey) {
            this.f21420a = eCPrivateKey;
            return this;
        }

        public C0256b h(ECPublicKey eCPublicKey) {
            this.f21421b = AbstractC1630b.n(AbstractC1495a.f21415f, AbstractC1495a.f21414e, eCPublicKey.getW());
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
        if (i7 > this.f21419d || i7 < bArr.length - 86) {
            throw new GeneralSecurityException("invalid record size: " + i7);
        }
        byte b7 = byteBufferWrap.get();
        if (b7 != 65) {
            throw new GeneralSecurityException("invalid ephemeral public key size: " + ((int) b7));
        }
        byte[] bArr4 = new byte[65];
        byteBufferWrap.get(bArr4);
        ECPoint eCPointL = AbstractC1630b.l(AbstractC1495a.f21415f, AbstractC1495a.f21414e, bArr4);
        byte[] bArr5 = new byte[bArr.length - 86];
        byteBufferWrap.get(bArr5);
        byte[] bArrB = AbstractC1497c.b(AbstractC1630b.a(this.f21416a, eCPointL), this.f21418c, this.f21417b, bArr4);
        return b(AbstractC1497c.a(bArrB, bArr3), AbstractC1497c.c(bArrB, bArr3), bArr5);
    }

    public final byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        Cipher cipher = (Cipher) C1631c.f22560b.a("AES/GCM/NoPadding");
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

    public C1496b(C0256b c0256b) {
        if (c0256b.f21420a == null) {
            throw new IllegalArgumentException("must set recipient's private key with Builder.withRecipientPrivateKey");
        }
        this.f21416a = c0256b.f21420a;
        if (c0256b.f21421b == null || c0256b.f21421b.length != 65) {
            throw new IllegalArgumentException("recipient public key must have 65 bytes");
        }
        this.f21417b = c0256b.f21421b;
        if (c0256b.f21422c == null) {
            throw new IllegalArgumentException("must set auth secret with Builder.withAuthSecret");
        }
        if (c0256b.f21422c.length != 16) {
            throw new IllegalArgumentException("auth secret must have 16 bytes");
        }
        this.f21418c = c0256b.f21422c;
        if (c0256b.f21423d < 18 || c0256b.f21423d > 4096) {
            throw new IllegalArgumentException(String.format("invalid record size (%s); must be a number between [%s, %s]", Integer.valueOf(c0256b.f21423d), 103, 4096));
        }
        this.f21419d = c0256b.f21423d;
    }
}
