package L;

import K.r;
import N.h;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class b {

    public static class a {
        public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i7) {
            return ((i7 & 4) == 0 || str != null) ? context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i7 & 1) : context.registerReceiver(broadcastReceiver, intentFilter, b.i(context), handler);
        }

        public static ComponentName b(Context context, Intent intent) {
            return context.startForegroundService(intent);
        }
    }

    /* renamed from: L.b$b, reason: collision with other inner class name */
    public static class C0048b {
        public static Executor a(Context context) {
            return context.getMainExecutor();
        }
    }

    public static class c {
        public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i7) {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i7);
        }
    }

    public static int a(Context context, String str) {
        Y.c.d(str, "permission must be non-null");
        return (Build.VERSION.SDK_INT >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) ? context.checkPermission(str, Process.myPid(), Process.myUid()) : r.g(context).a() ? 0 : -1;
    }

    public static int b(Context context, int i7) {
        return context.getColor(i7);
    }

    public static ColorStateList c(Context context, int i7) {
        return h.d(context.getResources(), i7, context.getTheme());
    }

    public static Drawable d(Context context, int i7) {
        return context.getDrawable(i7);
    }

    public static File[] e(Context context) {
        return context.getExternalCacheDirs();
    }

    public static File[] f(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    public static Executor g(Context context) {
        return Build.VERSION.SDK_INT >= 28 ? C0048b.a(context) : V.g.a(new Handler(context.getMainLooper()));
    }

    public static Object h(Context context, Class cls) {
        return context.getSystemService(cls);
    }

    public static String i(Context context) {
        String str = context.getApplicationContext().getPackageName() + ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
        if (g.b(context, str) == 0) {
            return str;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            str = context.getOpPackageName() + ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
            if (g.b(context, str) == 0) {
                return str;
            }
        }
        throw new RuntimeException("Permission " + str + " is required by your application to receive broadcasts, please add it to your manifest");
    }

    public static Intent j(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i7) {
        return k(context, broadcastReceiver, intentFilter, null, null, i7);
    }

    public static Intent k(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i7) {
        int i8 = i7 & 1;
        if (i8 != 0 && (i7 & 4) != 0) {
            throw new IllegalArgumentException("Cannot specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED");
        }
        if (i8 != 0) {
            i7 |= 2;
        }
        int i9 = i7;
        int i10 = i9 & 2;
        if (i10 == 0 && (i9 & 4) == 0) {
            throw new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
        }
        if (i10 != 0 && (i9 & 4) != 0) {
            throw new IllegalArgumentException("Cannot specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTED");
        }
        int i11 = Build.VERSION.SDK_INT;
        return i11 >= 33 ? c.a(context, broadcastReceiver, intentFilter, str, handler, i9) : i11 >= 26 ? a.a(context, broadcastReceiver, intentFilter, str, handler, i9) : ((i9 & 4) == 0 || str != null) ? context.registerReceiver(broadcastReceiver, intentFilter, str, handler) : context.registerReceiver(broadcastReceiver, intentFilter, i(context), handler);
    }

    public static boolean l(Context context, Intent[] intentArr, Bundle bundle) {
        context.startActivities(intentArr, bundle);
        return true;
    }

    public static void m(Context context, Intent intent, Bundle bundle) {
        context.startActivity(intent, bundle);
    }

    public static void n(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            a.b(context, intent);
        } else {
            context.startService(intent);
        }
    }
}
