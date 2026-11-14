package g1;

import B0.InterfaceC0310k;
import java.util.Arrays;

/* loaded from: classes.dex */
public interface V {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f15987a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f15988b;

        /* renamed from: c, reason: collision with root package name */
        public final int f15989c;

        /* renamed from: d, reason: collision with root package name */
        public final int f15990d;

        public a(int i7, byte[] bArr, int i8, int i9) {
            this.f15987a = i7;
            this.f15988b = bArr;
            this.f15989c = i8;
            this.f15990d = i9;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                a aVar = (a) obj;
                if (this.f15987a == aVar.f15987a && this.f15989c == aVar.f15989c && this.f15990d == aVar.f15990d && Arrays.equals(this.f15988b, aVar.f15988b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f15987a * 31) + Arrays.hashCode(this.f15988b)) * 31) + this.f15989c) * 31) + this.f15990d;
        }
    }

    default void a(E0.E e7, int i7) {
        f(e7, i7, 0);
    }

    int b(InterfaceC0310k interfaceC0310k, int i7, boolean z7, int i8);

    void c(B0.s sVar);

    void d(long j7, int i7, int i8, int i9, a aVar);

    void f(E0.E e7, int i7, int i8);

    default int g(InterfaceC0310k interfaceC0310k, int i7, boolean z7) {
        return b(interfaceC0310k, i7, z7, 0);
    }

    default void e(long j7) {
    }
}
