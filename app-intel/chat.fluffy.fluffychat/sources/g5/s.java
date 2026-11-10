package g5;

import android.os.Build;
import h5.j;

/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public final h5.j f16457a;

    /* renamed from: b, reason: collision with root package name */
    public b f16458b;

    /* renamed from: c, reason: collision with root package name */
    public final j.c f16459c;

    public class a implements j.c {
        public a() {
        }

        @Override // h5.j.c
        public void onMethodCall(h5.i iVar, j.d dVar) {
            if (s.this.f16458b == null) {
                U4.b.f("ScribeChannel", "No ScribeMethodHandler registered. Scribe call not handled.");
            }
            String str = iVar.f16895a;
            U4.b.f("ScribeChannel", "Received '" + str + "' message.");
            str.getClass();
            switch (str) {
                case "Scribe.isFeatureAvailable":
                    s.this.e(iVar, dVar);
                    break;
                case "Scribe.startStylusHandwriting":
                    s.this.h(iVar, dVar);
                    break;
                case "Scribe.isStylusHandwritingAvailable":
                    s.this.f(iVar, dVar);
                    break;
                default:
                    dVar.notImplemented();
                    break;
            }
        }
    }

    public interface b {
        void a();

        boolean b();

        boolean c();
    }

    public s(X4.a aVar) {
        a aVar2 = new a();
        this.f16459c = aVar2;
        h5.j jVar = new h5.j(aVar, "flutter/scribe", h5.f.f16894a);
        this.f16457a = jVar;
        jVar.e(aVar2);
    }

    public final void e(h5.i iVar, j.d dVar) {
        try {
            dVar.success(Boolean.valueOf(this.f16458b.c()));
        } catch (IllegalStateException e7) {
            dVar.error("error", e7.getMessage(), null);
        }
    }

    public final void f(h5.i iVar, j.d dVar) {
        if (Build.VERSION.SDK_INT < 34) {
            dVar.error("error", "Requires API level 34 or higher.", null);
            return;
        }
        try {
            dVar.success(Boolean.valueOf(this.f16458b.b()));
        } catch (IllegalStateException e7) {
            dVar.error("error", e7.getMessage(), null);
        }
    }

    public void g(b bVar) {
        this.f16458b = bVar;
    }

    public final void h(h5.i iVar, j.d dVar) {
        if (Build.VERSION.SDK_INT < 33) {
            dVar.error("error", "Requires API level 33 or higher.", null);
            return;
        }
        try {
            this.f16458b.a();
            dVar.success(null);
        } catch (IllegalStateException e7) {
            dVar.error("error", e7.getMessage(), null);
        }
    }
}
