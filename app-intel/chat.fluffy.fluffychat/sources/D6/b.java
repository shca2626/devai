package D6;

import M5.g;
import M5.m;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final a f1836c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f1837a;

    /* renamed from: b, reason: collision with root package name */
    public final KeyPair f1838b;

    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        public final byte[] a() {
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            return bArr;
        }

        public final KeyPair b() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
            keyPairGenerator.initialize(new ECGenParameterSpec("secp256r1"));
            KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
            m.d(keyPairGenerateKeyPair, "generateKeyPair(...)");
            return keyPairGenerateKeyPair;
        }

        public final b c() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
            return new b(a(), b());
        }

        public a() {
        }
    }

    public b(byte[] bArr, KeyPair keyPair) {
        m.e(bArr, "auth");
        m.e(keyPair, "keyPair");
        this.f1837a = bArr;
        this.f1838b = keyPair;
    }

    public final byte[] a() {
        return this.f1837a;
    }

    public final KeyPair b() {
        return this.f1838b;
    }

    public final A6.a c() {
        PublicKey publicKey = this.f1838b.getPublic();
        m.c(publicKey, "null cannot be cast to non-null type java.security.interfaces.ECPublicKey");
        return new A6.a(D6.a.d((ECPublicKey) publicKey), D6.a.b(this.f1837a));
    }
}
