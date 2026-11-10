package n4;

import M5.m;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import f.AbstractC1040d;
import w.C1723b;

/* renamed from: n4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1355a implements InterfaceC1359e {

    /* renamed from: a, reason: collision with root package name */
    public final C1723b.d f20070a;

    /* renamed from: n4.a$a, reason: collision with other inner class name */
    public static final class C0229a implements InterfaceC1358d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C1723b f20071a;

        public C0229a(C1723b c1723b) {
            this.f20071a = c1723b;
        }

        @Override // n4.InterfaceC1358d
        public void a(Activity activity, AbstractC1040d abstractC1040d, Uri uri, String str, String str2) {
            m.e(activity, "activity");
            m.e(abstractC1040d, "launcher");
            m.e(uri, "url");
            m.e(str, "redirectHost");
            m.e(str2, "redirectPath");
            this.f20071a.b(abstractC1040d, uri, str, str2);
        }

        @Override // n4.InterfaceC1358d
        public void b(Activity activity, AbstractC1040d abstractC1040d, Uri uri, String str) {
            m.e(activity, "activity");
            m.e(abstractC1040d, "launcher");
            m.e(uri, "url");
            m.e(str, "redirectScheme");
            this.f20071a.a(abstractC1040d, uri, str);
        }

        @Override // n4.InterfaceC1358d
        public Intent getIntent() {
            Intent intent = this.f20071a.f23244a;
            m.d(intent, "intent");
            return intent;
        }
    }

    public C1355a(C1723b.d dVar) {
        m.e(dVar, "b");
        this.f20070a = dVar;
    }

    @Override // n4.InterfaceC1359e
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1355a a(boolean z7) {
        this.f20070a.b(z7);
        return this;
    }

    @Override // n4.InterfaceC1359e
    public InterfaceC1358d build() {
        C1723b c1723bA = this.f20070a.a();
        m.d(c1723bA, "build(...)");
        return new C0229a(c1723bA);
    }
}
