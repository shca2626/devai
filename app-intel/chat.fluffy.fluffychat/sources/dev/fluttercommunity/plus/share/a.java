package dev.fluttercommunity.plus.share;

import M5.g;
import M5.m;
import android.content.Context;
import android.content.Intent;
import h5.j;
import h5.l;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class a implements l {

    /* renamed from: o, reason: collision with root package name */
    public static final C0157a f15314o = new C0157a(null);

    /* renamed from: l, reason: collision with root package name */
    public final Context f15315l;

    /* renamed from: m, reason: collision with root package name */
    public j.d f15316m;

    /* renamed from: n, reason: collision with root package name */
    public AtomicBoolean f15317n;

    /* renamed from: dev.fluttercommunity.plus.share.a$a, reason: collision with other inner class name */
    public static final class C0157a {
        public /* synthetic */ C0157a(g gVar) {
            this();
        }

        public C0157a() {
        }
    }

    public a(Context context) {
        m.e(context, "context");
        this.f15315l = context;
        this.f15317n = new AtomicBoolean(true);
    }

    public final void a() {
        this.f15317n.set(true);
        this.f15316m = null;
    }

    public final void b(String str) {
        j.d dVar;
        if (!this.f15317n.compareAndSet(false, true) || (dVar = this.f15316m) == null) {
            return;
        }
        m.b(dVar);
        dVar.success(str);
        this.f15316m = null;
    }

    public final void c(j.d dVar) {
        m.e(dVar, "callback");
        if (this.f15317n.compareAndSet(true, false)) {
            SharePlusPendingIntent.f15312a.b("");
            this.f15317n.set(false);
            this.f15316m = dVar;
        } else {
            j.d dVar2 = this.f15316m;
            if (dVar2 != null) {
                dVar2.success("dev.fluttercommunity.plus/share/unavailable");
            }
            SharePlusPendingIntent.f15312a.b("");
            this.f15317n.set(false);
            this.f15316m = dVar;
        }
    }

    public final void d() {
        b("dev.fluttercommunity.plus/share/unavailable");
    }

    @Override // h5.l
    public boolean onActivityResult(int i7, int i8, Intent intent) {
        if (i7 != 22643) {
            return false;
        }
        b(SharePlusPendingIntent.f15312a.a());
        return true;
    }
}
