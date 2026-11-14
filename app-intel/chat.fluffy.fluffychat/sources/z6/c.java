package z6;

import M5.m;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final a f24211c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Activity f24212a;

    /* renamed from: b, reason: collision with root package name */
    public final int f24213b;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public static /* synthetic */ String b(a aVar, Context context, Intent intent, int i7, Object obj) {
            if ((i7 & 2) != 0) {
                intent = null;
            }
            return aVar.a(context, intent);
        }

        public final String a(Context context, Intent intent) {
            ActivityInfo activityInfo;
            m.e(context, "context");
            if (intent == null) {
                intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("unifiedpush://link"));
            }
            ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
            if (resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null) {
                return null;
            }
            return activityInfo.packageName;
        }

        public a() {
        }
    }

    public c(Activity activity) {
        m.e(activity, "activity");
        this.f24212a = activity;
        this.f24213b = S5.e.m(new S5.c(1, Integer.MAX_VALUE), Q5.c.f7685l);
    }

    public final boolean a(int i7, int i8, Intent intent) {
        String targetPackage;
        boolean z7 = i7 == this.f24213b;
        boolean z8 = i8 == -1;
        if (!z7 || !z8) {
            Log.d("UnifiedPush.Link", "The deep link hasn't been proceeded. isRequestCodeMatching=" + z7 + " isResultCodeOK=" + z8);
            return false;
        }
        Log.d("UnifiedPush.Link", "The deep link has correctly been proceeded");
        PendingIntent pendingIntent = null;
        if (Build.VERSION.SDK_INT >= 33) {
            if (intent != null) {
                pendingIntent = (PendingIntent) intent.getParcelableExtra("pi", PendingIntent.class);
            }
        } else if (intent != null) {
            pendingIntent = (PendingIntent) intent.getParcelableExtra("pi");
        }
        if (pendingIntent == null || (targetPackage = pendingIntent.getTargetPackage()) == null) {
            Log.d("UnifiedPush.Link", "Could not find creator of pending intent");
            return false;
        }
        Log.d("UnifiedPush.Link", "Using distributor " + targetPackage + '.');
        B6.d.f1155o.a(this.f24212a).r().A(targetPackage);
        return true;
    }

    public final boolean b() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("unifiedpush://link"));
        String strA = f24211c.a(this.f24212a, intent);
        if (strA == null) {
            Log.d("UnifiedPush.Link", "No activity found for deeplink");
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Found activity for ");
        sb.append(strA);
        sb.append(" default=");
        sb.append(!m.a(strA, "android"));
        Log.d("UnifiedPush.Link", sb.toString());
        this.f24212a.startActivityForResult(intent, this.f24213b);
        return true;
    }
}
