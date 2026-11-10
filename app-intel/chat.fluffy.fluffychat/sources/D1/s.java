package D1;

import E0.InterfaceC0325k;
import java.util.Objects;
import k3.AbstractC1279v;

/* loaded from: classes.dex */
public interface s {

    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f1638a = new C0015a();

        /* renamed from: D1.s$a$a, reason: collision with other inner class name */
        public class C0015a implements a {
            @Override // D1.s.a
            public boolean b(B0.s sVar) {
                return false;
            }

            @Override // D1.s.a
            public int c(B0.s sVar) {
                return 1;
            }

            @Override // D1.s.a
            public s d(B0.s sVar) {
                throw new IllegalStateException("This SubtitleParser.Factory doesn't support any formats.");
            }
        }

        boolean b(B0.s sVar);

        int c(B0.s sVar);

        s d(B0.s sVar);
    }

    public static class b {

        /* renamed from: c, reason: collision with root package name */
        public static final b f1639c = new b(-9223372036854775807L, false);

        /* renamed from: a, reason: collision with root package name */
        public final long f1640a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f1641b;

        public b(long j7, boolean z7) {
            this.f1640a = j7;
            this.f1641b = z7;
        }

        public static b b() {
            return f1639c;
        }

        public static b c(long j7) {
            return new b(j7, true);
        }
    }

    void a(byte[] bArr, int i7, int i8, b bVar, InterfaceC0325k interfaceC0325k);

    default k b(byte[] bArr, int i7, int i8) {
        final AbstractC1279v.a aVarO = AbstractC1279v.o();
        b bVar = b.f1639c;
        Objects.requireNonNull(aVarO);
        a(bArr, i7, i8, bVar, new InterfaceC0325k() { // from class: D1.r
            @Override // E0.InterfaceC0325k
            public final void accept(Object obj) {
                aVarO.a((e) obj);
            }
        });
        return new g(aVarO.k());
    }

    int c();

    default void reset() {
    }
}
