package n4;

import M5.m;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import f.AbstractC1041d;
import x.C1758c;

/* renamed from: n4.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1356c implements InterfaceC1358e {

    /* renamed from: a, reason: collision with root package name */
    public final C1758c.e f20071a;

    /* renamed from: n4.c$a */
    public static final class a implements InterfaceC1357d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C1758c f20072a;

        public a(C1758c c1758c) {
            this.f20072a = c1758c;
        }

        @Override // n4.InterfaceC1357d
        public void a(Activity activity, AbstractC1041d abstractC1041d, Uri uri, String str, String str2) {
            m.e(activity, "activity");
            m.e(abstractC1041d, "launcher");
            m.e(uri, "url");
            m.e(str, "redirectHost");
            m.e(str2, "redirectPath");
            this.f20072a.b(activity, uri);
        }

        @Override // n4.InterfaceC1357d
        public void b(Activity activity, AbstractC1041d abstractC1041d, Uri uri, String str) {
            m.e(activity, "activity");
            m.e(abstractC1041d, "launcher");
            m.e(uri, "url");
            m.e(str, "redirectScheme");
            this.f20072a.b(activity, uri);
        }

        @Override // n4.InterfaceC1357d
        public Intent getIntent() {
            Intent intent = this.f20072a.f23434a;
            m.d(intent, "intent");
            return intent;
        }
    }

    public C1356c(C1758c.e eVar) {
        m.e(eVar, "b");
        this.f20071a = eVar;
    }

    @Override // n4.InterfaceC1358e
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1356c a(boolean z7) {
        this.f20071a.d(z7);
        return this;
    }

    @Override // n4.InterfaceC1358e
    public InterfaceC1357d build() {
        C1758c c1758cA = this.f20071a.a();
        m.d(c1758cA, "build(...)");
        return new a(c1758cA);
    }
}
