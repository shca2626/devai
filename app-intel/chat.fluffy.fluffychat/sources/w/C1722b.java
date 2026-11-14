package w;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import f.AbstractC1041d;
import f.InterfaceC1039b;
import f.InterfaceC1040c;
import g.AbstractC1066a;
import w.AbstractC1723c;
import w.C1721a;

/* renamed from: w.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1722b {

    /* renamed from: a, reason: collision with root package name */
    public final Intent f23250a;

    /* renamed from: w.b$b, reason: collision with other inner class name */
    public static final class C0282b {

        /* renamed from: a, reason: collision with root package name */
        public final int f23251a;

        /* renamed from: b, reason: collision with root package name */
        public final Uri f23252b;

        public C0282b(int i7, Uri uri) {
            this.f23251a = i7;
            this.f23252b = uri;
        }
    }

    /* renamed from: w.b$d */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final Intent f23253a = new Intent("android.intent.action.VIEW");

        /* renamed from: b, reason: collision with root package name */
        public final C1721a.b f23254b = new C1721a.b();

        /* renamed from: c, reason: collision with root package name */
        public SparseArray f23255c;

        /* renamed from: d, reason: collision with root package name */
        public Bundle f23256d;

        /* JADX WARN: Multi-variable type inference failed */
        public C1722b a() {
            this.f23253a.putExtra("androidx.browser.auth.extra.LAUNCH_AUTH_TAB", true);
            AbstractC1723c abstractC1723c = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            if (!this.f23253a.hasExtra("android.support.customtabs.extra.SESSION")) {
                c(null, null);
            }
            this.f23253a.putExtras(this.f23254b.a().a());
            Bundle bundle = this.f23256d;
            if (bundle != null) {
                this.f23253a.putExtras(bundle);
            }
            if (this.f23255c != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f23255c);
                this.f23253a.putExtras(bundle2);
            }
            return new C1722b(this.f23253a, abstractC1723c, objArr2 == true ? 1 : 0);
        }

        public d b(boolean z7) {
            this.f23253a.putExtra("androidx.browser.customtabs.extra.ENABLE_EPHEMERAL_BROWSING", z7);
            return this;
        }

        public final void c(IBinder iBinder, PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            bundle.putBinder("android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.f23253a.putExtras(bundle);
        }
    }

    public static AbstractC1041d c(InterfaceC1040c interfaceC1040c, InterfaceC1039b interfaceC1039b) {
        return interfaceC1040c.x(new c(), interfaceC1039b);
    }

    public void a(AbstractC1041d abstractC1041d, Uri uri, String str) {
        this.f23250a.setData(uri);
        this.f23250a.putExtra("androidx.browser.auth.extra.REDIRECT_SCHEME", str);
        abstractC1041d.a(this.f23250a);
    }

    public void b(AbstractC1041d abstractC1041d, Uri uri, String str, String str2) {
        this.f23250a.setData(uri);
        this.f23250a.putExtra("androidx.browser.auth.extra.HTTPS_REDIRECT_HOST", str);
        this.f23250a.putExtra("androidx.browser.auth.extra.HTTPS_REDIRECT_PATH", str2);
        abstractC1041d.a(this.f23250a);
    }

    public C1722b(Intent intent, AbstractC1723c abstractC1723c, AbstractC1723c.a aVar) {
        this.f23250a = intent;
    }

    /* renamed from: w.b$c */
    public static class c extends AbstractC1066a {
        @Override // g.AbstractC1066a
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

        @Override // g.AbstractC1066a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(Context context, Intent intent) {
            return intent;
        }
    }
}
