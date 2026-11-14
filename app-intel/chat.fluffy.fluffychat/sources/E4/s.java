package E4;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import z5.C1881l;

/* loaded from: classes.dex */
public final class s implements h5.n {

    /* renamed from: l, reason: collision with root package name */
    public Activity f2371l;

    /* renamed from: m, reason: collision with root package name */
    public r f2372m;

    public final D4.k a(Activity activity) {
        D4.k kVar;
        M5.m.e(activity, "activity");
        if (Build.VERSION.SDK_INT < 33) {
            return D4.k.f1820l;
        }
        if (d(activity, "android.permission.POST_NOTIFICATIONS")) {
            return D4.k.f1820l;
        }
        D4.k kVarC = c(activity, "android.permission.POST_NOTIFICATIONS");
        return (kVarC == null || kVarC != (kVar = D4.k.f1822n) || activity.shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS")) ? D4.k.f1821m : kVar;
    }

    public final void b() {
        this.f2371l = null;
        this.f2372m = null;
    }

    public final D4.k c(Context context, String str) {
        String string;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.NOTIFICATION_PERMISSION_STATUS", 0);
        if (sharedPreferences == null || (string = sharedPreferences.getString(str, null)) == null) {
            return null;
        }
        return D4.k.valueOf(string);
    }

    public final boolean d(Context context, String str) {
        return L.b.a(context, str) == 0;
    }

    public final void e(Activity activity, r rVar) {
        M5.m.e(activity, "activity");
        M5.m.e(rVar, "callback");
        if (Build.VERSION.SDK_INT < 33) {
            rVar.b(D4.k.f1820l);
            return;
        }
        this.f2371l = activity;
        this.f2372m = rVar;
        K.b.r(activity, new String[]{"android.permission.POST_NOTIFICATIONS"}, 100);
    }

    public final void f(Context context, String str, D4.k kVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.NOTIFICATION_PERMISSION_STATUS", 0);
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(str, kVar.toString());
        editorEdit.commit();
    }

    @Override // h5.n
    public boolean onRequestPermissionsResult(int i7, String[] strArr, int[] iArr) {
        M5.m.e(strArr, "permissions");
        M5.m.e(iArr, "grantResults");
        if (iArr.length == 0) {
            r rVar = this.f2372m;
            if (rVar != null) {
                rVar.a(new C4.c());
            }
            b();
            return false;
        }
        D4.k kVar = D4.k.f1821m;
        if (i7 != 100) {
            return false;
        }
        int iC = C1881l.C(strArr, "android.permission.POST_NOTIFICATIONS");
        if (iC < 0 || iArr[iC] != 0) {
            Activity activity = this.f2371l;
            if (activity != null && !activity.shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS")) {
                kVar = D4.k.f1822n;
            }
        } else {
            kVar = D4.k.f1820l;
        }
        Activity activity2 = this.f2371l;
        if (activity2 != null) {
            f(activity2, "android.permission.POST_NOTIFICATIONS", kVar);
        }
        r rVar2 = this.f2372m;
        if (rVar2 != null) {
            rVar2.b(kVar);
        }
        b();
        return true;
    }
}
