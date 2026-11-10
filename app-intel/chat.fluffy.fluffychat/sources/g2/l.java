package g2;

import android.app.Activity;

/* loaded from: classes.dex */
public interface l {

    /* renamed from: a, reason: collision with root package name */
    public static final a f16210a = a.f16211a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f16211a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static L5.l f16212b = C0178a.f16213m;

        /* renamed from: g2.l$a$a, reason: collision with other inner class name */
        public static final class C0178a extends M5.n implements L5.l {

            /* renamed from: m, reason: collision with root package name */
            public static final C0178a f16213m = new C0178a();

            public C0178a() {
                super(1);
            }

            @Override // L5.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final l a(l lVar) {
                M5.m.e(lVar, "it");
                return lVar;
            }
        }

        public final l a() {
            return (l) f16212b.a(o.f16214b);
        }
    }

    static l b() {
        return f16210a.a();
    }

    k a(Activity activity);
}
