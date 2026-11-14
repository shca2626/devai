package org.unifiedpush.android.connector.internal;

import L5.l;
import M5.g;
import M5.m;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import org.unifiedpush.android.connector.internal.LinkActivity;
import y5.C1823s;
import z6.c;

/* loaded from: classes3.dex */
public final class LinkActivity extends Activity {

    /* renamed from: m, reason: collision with root package name */
    public static final a f20518m = new a(null);

    /* renamed from: n, reason: collision with root package name */
    public static l f20519n = new l() { // from class: B6.v
        @Override // L5.l
        public final Object a(Object obj) {
            return LinkActivity.c(((Boolean) obj).booleanValue());
        }
    };

    /* renamed from: l, reason: collision with root package name */
    public final c f20520l = new c(this);

    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        public final void a(l lVar) {
            m.e(lVar, "<set-?>");
            LinkActivity.f20519n = lVar;
        }

        public a() {
        }
    }

    public static final C1823s c(boolean z7) {
        return C1823s.f24020a;
    }

    public final void d(boolean z7) {
        f20519n.a(Boolean.valueOf(z7));
        finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i7, int i8, Intent intent) {
        d(this.f20520l.a(i7, i8, intent));
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f20520l.b()) {
            return;
        }
        d(false);
    }
}
