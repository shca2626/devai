package w;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import f.AbstractC1040d;
import f.InterfaceC1038b;
import f.InterfaceC1039c;
import g.AbstractC1065a;
import w.AbstractC1724c;
import w.C1722a;

/* renamed from: w.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1723b {

    /* renamed from: a, reason: collision with root package name */
    public final Intent f23244a;

    /* renamed from: w.b$b, reason: collision with other inner class name */
    public static final class C0282b {

        /* renamed from: a, reason: collision with root package name */
        public final int f23245a;

        /* renamed from: b, reason: collision with root package name */
        public final Uri f23246b;

        public C0282b(int i7, Uri uri) {
            this.f23245a = i7;
            this.f23246b = uri;
        }
    }

    /* renamed from: w.b$d */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final Intent f23247a = new Intent("android.intent.action.VIEW");

        /* renamed from: b, reason: collision with root package name */
        public final C1722a.b f23248b = new C1722a.b();

        /* renamed from: c, reason: collision with root package name */
        public SparseArray f23249c;

        /* renamed from: d, reason: collision with root package name */
        public Bundle f23250d;

        /* JADX WARN: Multi-variable type inference failed */
        public C1723b a() {
            this.f23247a.putExtra("androidx.browser.auth.extra.LAUNCH_AUTH_TAB", true);
            AbstractC1724c abstractC1724c = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            if (!this.f23247a.hasExtra("android.support.customtabs.extra.SESSION")) {
                c(null, null);
            }
            this.f23247a.putExtras(this.f23248b.a().a());
            Bundle bundle = this.f23250d;
            if (bundle != null) {
                this.f23247a.putExtras(bundle);
            }
            if (this.f23249c != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f23249c);
                this.f23247a.putExtras(bundle2);
            }
            return new C1723b(this.f23247a, abstractC1724c, objArr2 == true ? 1 : 0);
        }

        public d b(boolean z7) {
            this.f23247a.putExtra("androidx.browser.customtabs.extra.ENABLE_EPHEMERAL_BROWSING", z7);
            return this;
        }

        public final void c(IBinder iBinder, PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            bundle.putBinder("android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.f23247a.putExtras(bundle);
        }
    }

    public static AbstractC1040d c(InterfaceC1039c interfaceC1039c, InterfaceC1038b interfaceC1038b) {
        return interfaceC1039c.x(new c(), interfaceC1038b);
    }

    public void a(AbstractC1040d abstractC1040d, Uri uri, String str) {
        this.f23244a.setData(uri);
        this.f23244a.putExtra("androidx.browser.auth.extra.REDIRECT_SCHEME", str);
        abstractC1040d.a(this.f23244a);
    }

    public void b(AbstractC1040d abstractC1040d, Uri uri, String str, String str2) {
        this.f23244a.setData(uri);
        this.f23244a.putExtra("androidx.browser.auth.extra.HTTPS_REDIRECT_HOST", str);
        this.f23244a.putExtra("androidx.browser.auth.extra.HTTPS_REDIRECT_PATH", str2);
        abstractC1040d.a(this.f23244a);
    }

    public C1723b(Intent intent, AbstractC1724c abstractC1724c, AbstractC1724c.a aVar) {
        this.f23244a = intent;
    }

    /* renamed from: w.b$c */
    public static class c extends AbstractC1065a {
        @Override // g.AbstractC1065a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C0282b c(int i7, Intent intent) {
            Uri data = null;
            if (i7 != -1) {
                if (i7 != 0 && i7 != 2 && i7 != 3) {
                    i7 = -2;
                }
            } else if (intent != null) {
                data = intent.getData();
            }
            return new C0282b(i7, data);
        }

        @Override // g.AbstractC1065a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(Context context, Intent intent) {
            return intent;
        }
    }
}
