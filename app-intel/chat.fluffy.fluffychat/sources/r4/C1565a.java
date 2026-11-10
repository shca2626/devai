package r4;

import M5.m;
import android.content.Context;
import v4.C1686c;

/* renamed from: r4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1565a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f22157a;

    /* renamed from: b, reason: collision with root package name */
    public C1568d f22158b;

    public C1565a(Context context) {
        m.e(context, "context");
        this.f22157a = context;
    }

    public final void a(C1686c c1686c, L5.a aVar) {
        m.e(c1686c, "config");
        m.e(aVar, "onDone");
        if (!c1686c.j()) {
            aVar.d();
            return;
        }
        if (c1686c.g() != null && c1686c.g().getType() != 7) {
            b();
            aVar.d();
        } else {
            if (this.f22158b != null) {
                aVar.d();
                return;
            }
            C1568d c1568d = new C1568d(this.f22157a);
            this.f22158b = c1568d;
            m.b(c1568d);
            c1568d.e(new C0263a(aVar));
        }
    }

    public final void b() {
        C1568d c1568d = this.f22158b;
        if (c1568d != null) {
            c1568d.h();
        }
        this.f22158b = null;
    }

    /* renamed from: r4.a$a, reason: collision with other inner class name */
    public static final class C0263a implements InterfaceC1569e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ L5.a f22159a;

        public C0263a(L5.a aVar) {
            this.f22159a = aVar;
        }

        @Override // r4.InterfaceC1569e
        public void a() {
            this.f22159a.d();
        }

        @Override // r4.InterfaceC1569e
        public void c() {
            this.f22159a.d();
        }

        @Override // r4.InterfaceC1569e
        public void b() {
        }
    }
}
