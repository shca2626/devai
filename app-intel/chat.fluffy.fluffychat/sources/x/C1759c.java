package x;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.LocaleList;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import java.util.ArrayList;
import x.C1757a;

/* renamed from: x.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1759c {

    /* renamed from: a, reason: collision with root package name */
    public final Intent f23428a;

    /* renamed from: b, reason: collision with root package name */
    public final Bundle f23429b;

    /* renamed from: x.c$a */
    public static class a {
        public static ActivityOptions a() {
            return ActivityOptions.makeBasic();
        }
    }

    /* renamed from: x.c$b */
    public static class b {
        public static String a() {
            LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
            if (adjustedDefault.size() > 0) {
                return adjustedDefault.get(0).toLanguageTag();
            }
            return null;
        }
    }

    /* renamed from: x.c$c, reason: collision with other inner class name */
    public static class C0286c {
        public static void a(ActivityOptions activityOptions, boolean z7) {
            activityOptions.setShareIdentityEnabled(z7);
        }
    }

    /* renamed from: x.c$d */
    public static class d {
        public static void a(ActivityOptions activityOptions, boolean z7) {
            activityOptions.setAllowPassThroughOnTouchOutside(z7);
        }
    }

    /* renamed from: x.c$e */
    public static final class e {

        /* renamed from: c, reason: collision with root package name */
        public ArrayList f23432c;

        /* renamed from: d, reason: collision with root package name */
        public ActivityOptions f23433d;

        /* renamed from: e, reason: collision with root package name */
        public ArrayList f23434e;

        /* renamed from: f, reason: collision with root package name */
        public SparseArray f23435f;

        /* renamed from: g, reason: collision with root package name */
        public Bundle f23436g;

        /* renamed from: j, reason: collision with root package name */
        public boolean f23439j;

        /* renamed from: k, reason: collision with root package name */
        public ArrayList f23440k;

        /* renamed from: a, reason: collision with root package name */
        public final Intent f23430a = new Intent("android.intent.action.VIEW");

        /* renamed from: b, reason: collision with root package name */
        public final C1757a.C0285a f23431b = new C1757a.C0285a();

        /* renamed from: h, reason: collision with root package name */
        public int f23437h = 0;

        /* renamed from: i, reason: collision with root package name */
        public boolean f23438i = true;

        public C1759c a() {
            if (!this.f23430a.hasExtra("android.support.customtabs.extra.SESSION")) {
                e(null, null);
            }
            ArrayList<? extends Parcelable> arrayList = this.f23432c;
            if (arrayList != null) {
                this.f23430a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<? extends Parcelable> arrayList2 = this.f23434e;
            if (arrayList2 != null) {
                this.f23430a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f23430a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f23438i);
            this.f23430a.putExtras(this.f23431b.a().a());
            Bundle bundle = this.f23436g;
            if (bundle != null) {
                this.f23430a.putExtras(bundle);
            }
            if (this.f23435f != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f23435f);
                this.f23430a.putExtras(bundle2);
            }
            this.f23430a.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.f23437h);
            ArrayList arrayList3 = this.f23440k;
            if (arrayList3 != null && !arrayList3.isEmpty()) {
                this.f23430a.putParcelableArrayListExtra("androidx.browser.customtabs.extra.CUSTOM_CONTENT_ACTIONS", this.f23440k);
            }
            int i7 = Build.VERSION.SDK_INT;
            c();
            if (i7 >= 34) {
                f();
            }
            if (i7 >= 36) {
                b();
            }
            ActivityOptions activityOptions = this.f23433d;
            return new C1759c(this.f23430a, activityOptions != null ? activityOptions.toBundle() : null);
        }

        public final void b() {
            if (this.f23433d == null) {
                this.f23433d = a.a();
            }
            d.a(this.f23433d, C1759c.a(this.f23430a));
        }

        public final void c() {
            String strA = b.a();
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            Bundle bundleExtra = this.f23430a.hasExtra("com.android.browser.headers") ? this.f23430a.getBundleExtra("com.android.browser.headers") : new Bundle();
            if (bundleExtra.containsKey("Accept-Language")) {
                return;
            }
            bundleExtra.putString("Accept-Language", strA);
            this.f23430a.putExtra("com.android.browser.headers", bundleExtra);
        }

        public e d(boolean z7) {
            this.f23430a.putExtra("androidx.browser.customtabs.extra.ENABLE_EPHEMERAL_BROWSING", z7);
            return this;
        }

        public final void e(IBinder iBinder, PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            bundle.putBinder("android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.f23430a.putExtras(bundle);
        }

        public final void f() {
            if (this.f23433d == null) {
                this.f23433d = a.a();
            }
            C0286c.a(this.f23433d, this.f23439j);
        }

        public e g(boolean z7) {
            this.f23430a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", z7 ? 1 : 0);
            return this;
        }
    }

    public C1759c(Intent intent, Bundle bundle) {
        this.f23428a = intent;
        this.f23429b = bundle;
    }

    public static boolean a(Intent intent) {
        return !intent.getBooleanExtra("androidx.browser.customtabs.extra.DISABLE_BACKGROUND_INTERACTION", false);
    }

    public void b(Context context, Uri uri) {
        this.f23428a.setData(uri);
        L.b.m(context, this.f23428a, this.f23429b);
    }
}
