package K;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class b extends L.b {

    public static class a {
        public static boolean a(Activity activity, String str) {
            try {
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(activity.getApplication().getPackageManager(), str)).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return activity.shouldShowRequestPermissionRationale(str);
            }
        }
    }

    /* renamed from: K.b$b, reason: collision with other inner class name */
    public static class C0044b {
        public static boolean a(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    public interface c {
        void j(int i7);
    }

    public static /* synthetic */ void o(Activity activity) {
        if (activity.isFinishing() || d.i(activity)) {
            return;
        }
        activity.recreate();
    }

    public static void p(Activity activity) {
        activity.finishAffinity();
    }

    public static void q(final Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            new Handler(activity.getMainLooper()).post(new Runnable() { // from class: K.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.o(activity);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void r(Activity activity, String[] strArr, int i7) {
        HashSet hashSet = new HashSet();
        for (int i8 = 0; i8 < strArr.length; i8++) {
            if (TextUtils.isEmpty(strArr[i8])) {
                throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
            }
            if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i8], "android.permission.POST_NOTIFICATIONS")) {
                hashSet.add(Integer.valueOf(i8));
            }
        }
        int size = hashSet.size();
        String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i9 = 0;
            for (int i10 = 0; i10 < strArr.length; i10++) {
                if (!hashSet.contains(Integer.valueOf(i10))) {
                    strArr2[i9] = strArr[i10];
                    i9++;
                }
            }
        }
        if (activity instanceof c) {
            ((c) activity).j(i7);
        }
        activity.requestPermissions(strArr, i7);
    }

    public static boolean s(Activity activity, String str) {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return i7 >= 32 ? C0044b.a(activity, str) : i7 == 31 ? a.a(activity, str) : activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    public static void t(Activity activity, Intent intent, int i7, Bundle bundle) {
        activity.startActivityForResult(intent, i7, bundle);
    }

    public static void u(Activity activity, IntentSender intentSender, int i7, Intent intent, int i8, int i9, int i10, Bundle bundle) throws IntentSender.SendIntentException {
        activity.startIntentSenderForResult(intentSender, i7, intent, i8, i9, i10, bundle);
    }
}
