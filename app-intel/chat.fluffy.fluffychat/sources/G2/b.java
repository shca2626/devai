package G2;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import h5.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class b implements n {

    /* renamed from: o, reason: collision with root package name */
    public static b f3256o;

    /* renamed from: l, reason: collision with root package name */
    public Activity f3257l;

    /* renamed from: m, reason: collision with root package name */
    public E2.a f3258m;

    /* renamed from: n, reason: collision with root package name */
    public c f3259n;

    public static synchronized b b() {
        try {
            if (f3256o == null) {
                f3256o = new b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f3256o;
    }

    public static List c(Context context) throws E2.c {
        boolean zB = f.b(context, "android.permission.ACCESS_FINE_LOCATION");
        boolean zB2 = f.b(context, "android.permission.ACCESS_COARSE_LOCATION");
        if (!zB && !zB2) {
            throw new E2.c();
        }
        ArrayList arrayList = new ArrayList();
        if (zB) {
            arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        }
        if (zB2) {
            arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        }
        return arrayList;
    }

    public static int f(Object[] objArr, Object obj) {
        return Arrays.asList(objArr).indexOf(obj);
    }

    public a a(Context context) {
        Iterator it = c(context).iterator();
        while (it.hasNext()) {
            if (L.b.a(context, (String) it.next()) == 0) {
                return Build.VERSION.SDK_INT < 29 ? a.always : !f.b(context, "android.permission.ACCESS_BACKGROUND_LOCATION") ? a.whileInUse : L.b.a(context, "android.permission.ACCESS_BACKGROUND_LOCATION") == 0 ? a.always : a.whileInUse;
            }
        }
        return a.denied;
    }

    public final boolean d(String[] strArr, int[] iArr) {
        int iF = f(strArr, "android.permission.ACCESS_BACKGROUND_LOCATION");
        return iF >= 0 && iArr[iF] == 0;
    }

    public boolean e(Context context) {
        a aVarA = a(context);
        return aVarA == a.whileInUse || aVarA == a.always;
    }

    public void g(Activity activity, c cVar, E2.a aVar) throws E2.c {
        if (activity == null) {
            aVar.a(E2.b.activityMissing);
            return;
        }
        int i7 = Build.VERSION.SDK_INT;
        List listC = c(activity);
        if (i7 >= 29 && f.b(activity, "android.permission.ACCESS_BACKGROUND_LOCATION") && a(activity) == a.whileInUse) {
            listC.add("android.permission.ACCESS_BACKGROUND_LOCATION");
        }
        this.f3258m = aVar;
        this.f3259n = cVar;
        this.f3257l = activity;
        K.b.r(activity, (String[]) listC.toArray(new String[0]), 109);
    }

    @Override // h5.n
    public boolean onRequestPermissionsResult(int i7, String[] strArr, int[] iArr) {
        if (i7 != 109) {
            return false;
        }
        Activity activity = this.f3257l;
        if (activity == null) {
            Log.e("Geolocator", "Trying to process permission result without an valid Activity instance");
            E2.a aVar = this.f3258m;
            if (aVar != null) {
                aVar.a(E2.b.activityMissing);
            }
            return false;
        }
        try {
            List<String> listC = c(activity);
            if (iArr.length == 0) {
                Log.i("Geolocator", "The grantResults array is empty. This can happen when the user cancels the permission request");
                return false;
            }
            a aVar2 = a.denied;
            char c7 = 65535;
            boolean z7 = false;
            boolean z8 = false;
            for (String str : listC) {
                int iF = f(strArr, str);
                if (iF >= 0) {
                    z7 = true;
                }
                if (iArr[iF] == 0) {
                    c7 = 0;
                }
                if (K.b.s(this.f3257l, str)) {
                    z8 = true;
                }
            }
            if (!z7) {
                Log.w("Geolocator", "Location permissions not part of permissions send to onRequestPermissionsResult method.");
                return false;
            }
            if (c7 == 0) {
                aVar2 = (Build.VERSION.SDK_INT < 29 || d(strArr, iArr)) ? a.always : a.whileInUse;
            } else if (!z8) {
                aVar2 = a.deniedForever;
            }
            c cVar = this.f3259n;
            if (cVar != null) {
                cVar.a(aVar2);
            }
            return true;
        } catch (E2.c unused) {
            E2.a aVar3 = this.f3258m;
            if (aVar3 != null) {
                aVar3.a(E2.b.permissionDefinitionsNotFound);
            }
            return false;
        }
    }
}
