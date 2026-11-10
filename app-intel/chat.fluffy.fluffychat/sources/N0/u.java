package N0;

import J0.G1;
import N0.InterfaceC0542m;
import N0.t;
import N0.u;
import android.os.Looper;

/* loaded from: classes.dex */
public interface u {

    /* renamed from: a, reason: collision with root package name */
    public static final u f5926a = new a();

    public interface b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f5927a = new b() { // from class: N0.v
            @Override // N0.u.b
            public final void release() {
                u.b.a();
            }
        };

        static /* synthetic */ void a() {
        }

        void release();
    }

    default b a(t.a aVar, B0.s sVar) {
        return b.f5927a;
    }

    void b(Looper looper, G1 g12);

    int c(B0.s sVar);

    InterfaceC0542m d(t.a aVar, B0.s sVar);

    default void h() {
    }

    default void release() {
    }

    public class a implements u {
        @Override // N0.u
        public int c(B0.s sVar) {
            return sVar.f763s != null ? 1 : 0;
        }

        @Override // N0.u
        public InterfaceC0542m d(t.a aVar, B0.s sVar) {
            if (sVar.f763s == null) {
                return null;
            }
            return new z(new InterfaceC0542m.a(new P(1), 6001));
        }

        @Override // N0.u
        public void b(Looper looper, G1 g12) {
        }
    }
}
