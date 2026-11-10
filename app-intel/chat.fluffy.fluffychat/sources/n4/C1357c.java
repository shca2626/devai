package n4;

import M5.m;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import f.AbstractC1040d;
import x.C1759c;

/* renamed from: n4.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1357c implements InterfaceC1359e {

    /* renamed from: a, reason: collision with root package name */
    public final C1759c.e f20072a;

    /* renamed from: n4.c$a */
    public static final class a implements InterfaceC1358d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C1759c f20073a;

        public a(C1759c c1759c) {
            this.f20073a = c1759c;
        }

        @Override // n4.InterfaceC1358d
        public void a(Activity activity, AbstractC1040d abstractC1040d, Uri uri, String str, String str2) {
            m.e(activity, "activity");
            m.e(abstractC1040d, "launcher");
            m.e(uri, "url");
            m.e(str, "redirectHost");
            m.e(str2, "redirectPath");
            this.f20073a.b(activity, uri);
        }

        @Override // n4.InterfaceC1358d
        public void b(Activity activity, AbstractC1040d abstractC1040d, Uri uri, String str) {
            m.e(activity, "activity");
            m.e(abstractC1040d, "launcher");
            m.e(uri, "url");
            m.e(str, "redirectScheme");
            this.f20073a.b(activity, uri);
        }

        @Override // n4.InterfaceC1358d
        public Intent getIntent() {
            Intent intent = this.f20073a.f23428a;
            m.d(intent, "intent");
            return intent;
        }
    }

    public C1357c(C1759c.e eVar) {
        m.e(eVar, "b");
        this.f20072a = eVar;
    }

    @Override // n4.InterfaceC1359e
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1357c a(boolean z7) {
        this.f20072a.d(z7);
        return this;
    }

    @Override // n4.InterfaceC1359e
    public InterfaceC1358d build() {
        C1759c c1759cA = this.f20072a.a();
        m.d(c1759cA, "build(...)");
        return new a(c1759cA);
    }
}
