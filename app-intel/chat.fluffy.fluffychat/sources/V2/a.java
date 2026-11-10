package V2;

import android.os.Build;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f8611a = {O2.a.f6749l};

    /* renamed from: b, reason: collision with root package name */
    public static final c f8612b;

    /* renamed from: c, reason: collision with root package name */
    public static final c f8613c;

    /* renamed from: d, reason: collision with root package name */
    public static final Map f8614d;

    /* renamed from: e, reason: collision with root package name */
    public static final Map f8615e;

    /* renamed from: V2.a$a, reason: collision with other inner class name */
    public class C0072a implements c {
        @Override // V2.a.c
        public boolean a() {
            return true;
        }
    }

    public class b implements c {

        /* renamed from: a, reason: collision with root package name */
        public Long f8616a;

        @Override // V2.a.c
        public boolean a() throws NoSuchMethodException, SecurityException {
            if (this.f8616a == null) {
                try {
                    Method declaredMethod = Build.class.getDeclaredMethod("getLong", String.class);
                    declaredMethod.setAccessible(true);
                    Long l7 = (Long) declaredMethod.invoke(null, "ro.build.version.oneui");
                    l7.longValue();
                    this.f8616a = l7;
                } catch (Exception unused) {
                    this.f8616a = -1L;
                }
            }
            return this.f8616a.longValue() >= 40100;
        }
    }

    public interface c {
        boolean a();
    }

    static {
        C0072a c0072a = new C0072a();
        f8612b = c0072a;
        b bVar = new b();
        f8613c = bVar;
        HashMap map = new HashMap();
        map.put("fcnt", c0072a);
        map.put("google", c0072a);
        map.put("hmd global", c0072a);
        map.put("infinix", c0072a);
        map.put("infinix mobility limited", c0072a);
        map.put("itel", c0072a);
        map.put("kyocera", c0072a);
        map.put("lenovo", c0072a);
        map.put("lge", c0072a);
        map.put("motorola", c0072a);
        map.put("nothing", c0072a);
        map.put("oneplus", c0072a);
        map.put("oppo", c0072a);
        map.put("realme", c0072a);
        map.put("robolectric", c0072a);
        map.put("samsung", bVar);
        map.put("sharp", c0072a);
        map.put("sony", c0072a);
        map.put("tcl", c0072a);
        map.put("tecno", c0072a);
        map.put("tecno mobile limited", c0072a);
        map.put("vivo", c0072a);
        map.put("xiaomi", c0072a);
        f8614d = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("asus", c0072a);
        map2.put("jio", c0072a);
        f8615e = Collections.unmodifiableMap(map2);
    }

    public static boolean a() {
        if (Build.VERSION.SDK_INT < 31) {
            return false;
        }
        if (V.c.d()) {
            return true;
        }
        c cVar = (c) f8614d.get(Build.MANUFACTURER.toLowerCase());
        if (cVar == null) {
            cVar = (c) f8615e.get(Build.BRAND.toLowerCase());
        }
        return cVar != null && cVar.a();
    }
}
