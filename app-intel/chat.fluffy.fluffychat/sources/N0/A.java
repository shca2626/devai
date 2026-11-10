package N0;

import J0.G1;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public interface A {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f5783a;

        /* renamed from: b, reason: collision with root package name */
        public final String f5784b;

        /* renamed from: c, reason: collision with root package name */
        public final int f5785c;

        public a(byte[] bArr, String str, int i7) {
            this.f5783a = bArr;
            this.f5784b = str;
            this.f5785c = i7;
        }

        public byte[] a() {
            return this.f5783a;
        }

        public String b() {
            return this.f5784b;
        }
    }

    public interface b {
        void a(A a7, byte[] bArr, int i7, int i8, byte[] bArr2);
    }

    public interface c {
        A a(UUID uuid);
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f5786a;

        /* renamed from: b, reason: collision with root package name */
        public final String f5787b;

        public d(byte[] bArr, String str) {
            this.f5786a = bArr;
            this.f5787b = str;
        }

        public byte[] a() {
            return this.f5786a;
        }

        public String b() {
            return this.f5787b;
        }
    }

    Map a(byte[] bArr);

    d b();

    void c(b bVar);

    H0.b e(byte[] bArr);

    byte[] f();

    boolean g(byte[] bArr, String str);

    void h(byte[] bArr, byte[] bArr2);

    void i(byte[] bArr);

    byte[] j(byte[] bArr, byte[] bArr2);

    void k(byte[] bArr);

    a l(byte[] bArr, List list, int i7, HashMap map);

    int m();

    void release();

    default void d(byte[] bArr, G1 g12) {
    }
}
