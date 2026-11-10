package g6;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.Log;
import h6.d;
import h6.e;
import h6.f;
import h6.g;
import h6.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import me.leolin.shortcutbadger.impl.AdwHomeBadger;
import me.leolin.shortcutbadger.impl.ApexHomeBadger;
import me.leolin.shortcutbadger.impl.DefaultBadger;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;
import me.leolin.shortcutbadger.impl.NovaHomeBadger;
import me.leolin.shortcutbadger.impl.SonyHomeBadger;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final List f16537a;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f16538b;

    /* renamed from: c, reason: collision with root package name */
    public static a f16539c;

    /* renamed from: d, reason: collision with root package name */
    public static ComponentName f16540d;

    static {
        LinkedList linkedList = new LinkedList();
        f16537a = linkedList;
        f16538b = new Object();
        linkedList.add(AdwHomeBadger.class);
        linkedList.add(ApexHomeBadger.class);
        linkedList.add(DefaultBadger.class);
        linkedList.add(NewHtcHomeBadger.class);
        linkedList.add(NovaHomeBadger.class);
        linkedList.add(SonyHomeBadger.class);
        linkedList.add(h6.a.class);
        linkedList.add(h6.c.class);
        linkedList.add(d.class);
        linkedList.add(e.class);
        linkedList.add(h.class);
        linkedList.add(f.class);
        linkedList.add(g.class);
        linkedList.add(h6.b.class);
    }

    public static boolean a(Context context, int i7) {
        try {
            b(context, i7);
            return true;
        } catch (b e7) {
            if (!Log.isLoggable("ShortcutBadger", 3)) {
                return false;
            }
            Log.d("ShortcutBadger", "Unable to execute badge", e7);
            return false;
        }
    }

    public static void b(Context context, int i7) throws b {
        if (f16539c == null && !c(context)) {
            throw new b("No default launcher available");
        }
        try {
            f16539c.b(context, f16540d, i7);
        } catch (Exception e7) {
            throw new b("Unable to execute badge", e7);
        }
    }

    public static boolean c(Context context) {
        a aVar;
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            Log.e("ShortcutBadger", "Unable to find launch intent for package " + context.getPackageName());
            return false;
        }
        f16540d = launchIntentForPackage.getComponent();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
        while (it.hasNext()) {
            String str = it.next().activityInfo.packageName;
            Iterator it2 = f16537a.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                try {
                    aVar = (a) ((Class) it2.next()).newInstance();
                } catch (Exception unused) {
                    aVar = null;
                }
                if (aVar != null && aVar.a().contains(str)) {
                    f16539c = aVar;
                    break;
                }
            }
            if (f16539c != null) {
                break;
            }
        }
        if (f16539c != null) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        if (str2.equalsIgnoreCase("ZUK")) {
            f16539c = new h();
            return true;
        }
        if (str2.equalsIgnoreCase("OPPO")) {
            f16539c = new d();
            return true;
        }
        if (str2.equalsIgnoreCase("VIVO")) {
            f16539c = new f();
            return true;
        }
        if (str2.equalsIgnoreCase("ZTE")) {
            f16539c = new g();
            return true;
        }
        f16539c = new DefaultBadger();
        return true;
    }

    public static boolean d(Context context) {
        return a(context, 0);
    }
}
