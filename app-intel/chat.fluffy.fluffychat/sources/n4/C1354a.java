package n4;

import M5.m;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import f.AbstractC1041d;
import w.C1722b;

/* renamed from: n4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1354a implements InterfaceC1358e {

    /* renamed from: a, reason: collision with root package name */
    public final C1722b.d f20069a;

    /* renamed from: n4.a$a, reason: collision with other inner class name */
    public static final class C0229a implements InterfaceC1357d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C1722b f20070a;

        public C0229a(C1722b c1722b) {
            this.f20070a = c1722b;
        }

        @Override // n4.InterfaceC1357d
        public void a(Activity activity, AbstractC1041d abstractC1041d, Uri uri, String str, String str2) {
            m.e(activity, "activity");
            m.e(abstractC1041d, "launcher");
            m.e(uri, "url");
            m.e(str, "redirectHost");
            m.e(str2, "redirectPath");
            this.f20070a.b(abstractC1041d, uri, str, str2);
        }

        @Override // n4.InterfaceC1357d
        public void b(Activity activity, AbstractC1041d abstractC1041d, Uri uri, String str) {
            m.e(activity, "activity");
            m.e(abstractC1041d, "launcher");
            m.e(uri, "url");
            m.e(str, "redirectScheme");
            this.f20070a.a(abstractC1041d, uri, str);
        }

        @Override // n4.InterfaceC1357d
        public Intent getIntent() {
            Intent intent = this.f20070a.f23250a;
            m.d(intent, "intent");
            return intent;
        }
    }

    public C1354a(C1722b.d dVar) {
        m.e(dVar, "b");
        this.f20069a = dVar;
    }

    @Override // n4.InterfaceC1358e
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1354a a(boolean z7) {
        this.f20069a.b(z7);
        return this;
    }

    @Override // n4.InterfaceC1358e
    public InterfaceC1357d build() {
        C1722b c1722bA = this.f20069a.a();
        m.d(c1722bA, "build(...)");
        return new C0229a(c1722bA);
    }
}
