package n4;

import M5.m;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import z5.C1884o;
import z5.C1885p;

/* renamed from: n4.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1359f {
    public static final String a(Context context, String str) {
        m.e(context, "<this>");
        m.e(str, "packageName");
        try {
            return (Build.VERSION.SDK_INT >= 33 ? context.getPackageManager().getPackageInfo(str, PackageManager.PackageInfoFlags.of(0L)) : context.getPackageManager().getPackageInfo(str, 0)).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String b(Object obj) {
        m.e(obj, "<this>");
        return "flutter_web_auth_2";
    }

    public static final List c(Context context, Intent intent) {
        m.e(context, "<this>");
        m.e(intent, "intent");
        try {
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 131072);
            m.b(listQueryIntentActivities);
            ArrayList arrayList = new ArrayList(C1885p.o(listQueryIntentActivities, 10));
            Iterator<T> it = listQueryIntentActivities.iterator();
            while (it.hasNext()) {
                arrayList.add(((ResolveInfo) it.next()).activityInfo.packageName);
            }
            return arrayList;
        } catch (Exception unused) {
            return C1884o.i();
        }
    }
}
