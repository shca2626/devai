package Q1;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

/* loaded from: classes.dex */
public abstract class t extends h {

    /* renamed from: c, reason: collision with root package name */
    public final OnBackInvokedDispatcher f7642c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7643d;

    /* renamed from: e, reason: collision with root package name */
    public final OnBackInvokedCallback f7644e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7645f;

    public static final class a implements OnBackAnimationCallback {
        public a() {
        }

        public void onBackCancelled() {
            t.this.a();
        }

        public void onBackInvoked() {
            t.this.b();
        }

        public void onBackProgressed(BackEvent backEvent) {
            M5.m.e(backEvent, "backEvent");
            t.this.c(p.a(backEvent));
        }

        public void onBackStarted(BackEvent backEvent) {
            M5.m.e(backEvent, "backEvent");
            t.this.d(p.a(backEvent));
        }
    }

    public /* synthetic */ t(OnBackInvokedDispatcher onBackInvokedDispatcher, int i7, M5.g gVar) {
        this(onBackInvokedDispatcher, i7);
    }

    public static final void o(t tVar) {
        tVar.b();
    }

    @Override // Q1.h
    public void j(boolean z7) {
        p(z7);
    }

    public final OnBackInvokedCallback n() {
        return j.i.a(new a());
    }

    public final void p(boolean z7) {
        if (z7 && !this.f7645f) {
            this.f7642c.registerOnBackInvokedCallback(this.f7643d, this.f7644e);
            this.f7645f = true;
        } else {
            if (z7 || !this.f7645f) {
                return;
            }
            this.f7642c.unregisterOnBackInvokedCallback(this.f7644e);
            this.f7645f = false;
        }
    }

    public t(OnBackInvokedDispatcher onBackInvokedDispatcher, int i7) {
        this.f7642c = onBackInvokedDispatcher;
        this.f7643d = i7;
        this.f7644e = Build.VERSION.SDK_INT == 33 ? new OnBackInvokedCallback() { // from class: Q1.s
            public final void onBackInvoked() {
                t.o(this.f7641a);
            }
        } : n();
    }
}
