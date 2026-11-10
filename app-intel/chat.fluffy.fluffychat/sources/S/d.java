package S;

import Y.h;
import Y.k;
import android.location.LocationRequest;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final int f8098a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8099b;

    /* renamed from: c, reason: collision with root package name */
    public final long f8100c;

    /* renamed from: d, reason: collision with root package name */
    public final long f8101d;

    /* renamed from: e, reason: collision with root package name */
    public final int f8102e;

    /* renamed from: f, reason: collision with root package name */
    public final float f8103f;

    /* renamed from: g, reason: collision with root package name */
    public final long f8104g;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static Class f8105a;

        /* renamed from: b, reason: collision with root package name */
        public static Method f8106b;

        /* renamed from: c, reason: collision with root package name */
        public static Method f8107c;

        /* renamed from: d, reason: collision with root package name */
        public static Method f8108d;

        /* renamed from: e, reason: collision with root package name */
        public static Method f8109e;

        /* renamed from: f, reason: collision with root package name */
        public static Method f8110f;

        public static Object a(d dVar, String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            try {
                if (f8105a == null) {
                    f8105a = Class.forName("android.location.LocationRequest");
                }
                Method method = f8106b;
                Class cls = Long.TYPE;
                if (method == null) {
                    Method declaredMethod = f8105a.getDeclaredMethod("createFromDeprecatedProvider", String.class, cls, Float.TYPE, Boolean.TYPE);
                    f8106b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                Object objInvoke = f8106b.invoke(null, str, Long.valueOf(dVar.b()), Float.valueOf(dVar.e()), Boolean.FALSE);
                if (objInvoke == null) {
                    return null;
                }
                Method method2 = f8107c;
                Class cls2 = Integer.TYPE;
                if (method2 == null) {
                    Method declaredMethod2 = f8105a.getDeclaredMethod("setQuality", cls2);
                    f8107c = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                }
                f8107c.invoke(objInvoke, Integer.valueOf(dVar.g()));
                if (f8108d == null) {
                    Method declaredMethod3 = f8105a.getDeclaredMethod("setFastestInterval", cls);
                    f8108d = declaredMethod3;
                    declaredMethod3.setAccessible(true);
                }
                f8108d.invoke(objInvoke, Long.valueOf(dVar.f()));
                if (dVar.d() < Integer.MAX_VALUE) {
                    if (f8109e == null) {
                        Method declaredMethod4 = f8105a.getDeclaredMethod("setNumUpdates", cls2);
                        f8109e = declaredMethod4;
                        declaredMethod4.setAccessible(true);
                    }
                    f8109e.invoke(objInvoke, Integer.valueOf(dVar.d()));
                }
                if (dVar.a() < Long.MAX_VALUE) {
                    if (f8110f == null) {
                        Method declaredMethod5 = f8105a.getDeclaredMethod("setExpireIn", cls);
                        f8110f = declaredMethod5;
                        declaredMethod5.setAccessible(true);
                    }
                    f8110f.invoke(objInvoke, Long.valueOf(dVar.a()));
                }
                return objInvoke;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }
    }

    public static class b {
        public static LocationRequest a(d dVar) {
            return new LocationRequest.Builder(dVar.b()).setQuality(dVar.g()).setMinUpdateIntervalMillis(dVar.f()).setDurationMillis(dVar.a()).setMaxUpdates(dVar.d()).setMinUpdateDistanceMeters(dVar.e()).setMaxUpdateDelayMillis(dVar.c()).build();
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public long f8111a;

        /* renamed from: b, reason: collision with root package name */
        public int f8112b;

        /* renamed from: c, reason: collision with root package name */
        public long f8113c;

        /* renamed from: d, reason: collision with root package name */
        public int f8114d;

        /* renamed from: e, reason: collision with root package name */
        public long f8115e;

        /* renamed from: f, reason: collision with root package name */
        public float f8116f;

        /* renamed from: g, reason: collision with root package name */
        public long f8117g;

        public c(long j7) {
            b(j7);
            this.f8112b = 102;
            this.f8113c = Long.MAX_VALUE;
            this.f8114d = Integer.MAX_VALUE;
            this.f8115e = -1L;
            this.f8116f = 0.0f;
            this.f8117g = 0L;
        }

        public d a() {
            h.l((this.f8111a == Long.MAX_VALUE && this.f8115e == -1) ? false : true, "passive location requests must have an explicit minimum update interval");
            long j7 = this.f8111a;
            return new d(j7, this.f8112b, this.f8113c, this.f8114d, Math.min(this.f8115e, j7), this.f8116f, this.f8117g);
        }

        public c b(long j7) {
            this.f8111a = h.f(j7, 0L, Long.MAX_VALUE, "intervalMillis");
            return this;
        }

        public c c(float f7) {
            this.f8116f = f7;
            this.f8116f = h.d(f7, 0.0f, Float.MAX_VALUE, "minUpdateDistanceMeters");
            return this;
        }

        public c d(long j7) {
            this.f8115e = h.f(j7, 0L, Long.MAX_VALUE, "minUpdateIntervalMillis");
            return this;
        }

        public c e(int i7) {
            h.b(i7 == 104 || i7 == 102 || i7 == 100, "quality must be a defined QUALITY constant, not %d", Integer.valueOf(i7));
            this.f8112b = i7;
            return this;
        }
    }

    public d(long j7, int i7, long j8, int i8, long j9, float f7, long j10) {
        this.f8099b = j7;
        this.f8098a = i7;
        this.f8100c = j9;
        this.f8101d = j8;
        this.f8102e = i8;
        this.f8103f = f7;
        this.f8104g = j10;
    }

    public long a() {
        return this.f8101d;
    }

    public long b() {
        return this.f8099b;
    }

    public long c() {
        return this.f8104g;
    }

    public int d() {
        return this.f8102e;
    }

    public float e() {
        return this.f8103f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f8098a == dVar.f8098a && this.f8099b == dVar.f8099b && this.f8100c == dVar.f8100c && this.f8101d == dVar.f8101d && this.f8102e == dVar.f8102e && Float.compare(dVar.f8103f, this.f8103f) == 0 && this.f8104g == dVar.f8104g;
    }

    public long f() {
        long j7 = this.f8100c;
        return j7 == -1 ? this.f8099b : j7;
    }

    public int g() {
        return this.f8098a;
    }

    public LocationRequest h() {
        return b.a(this);
    }

    public int hashCode() {
        int i7 = this.f8098a * 31;
        long j7 = this.f8099b;
        int i8 = (i7 + ((int) (j7 ^ (j7 >>> 32)))) * 31;
        long j8 = this.f8100c;
        return i8 + ((int) (j8 ^ (j8 >>> 32)));
    }

    public LocationRequest i(String str) {
        return Build.VERSION.SDK_INT >= 31 ? h() : S.c.a(a.a(this, str));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        if (this.f8099b != Long.MAX_VALUE) {
            sb.append("@");
            k.b(this.f8099b, sb);
            int i7 = this.f8098a;
            if (i7 == 100) {
                sb.append(" HIGH_ACCURACY");
            } else if (i7 == 102) {
                sb.append(" BALANCED");
            } else if (i7 == 104) {
                sb.append(" LOW_POWER");
            }
        } else {
            sb.append("PASSIVE");
        }
        if (this.f8101d != Long.MAX_VALUE) {
            sb.append(", duration=");
            k.b(this.f8101d, sb);
        }
        if (this.f8102e != Integer.MAX_VALUE) {
            sb.append(", maxUpdates=");
            sb.append(this.f8102e);
        }
        long j7 = this.f8100c;
        if (j7 != -1 && j7 < this.f8099b) {
            sb.append(", minUpdateInterval=");
            k.b(this.f8100c, sb);
        }
        if (this.f8103f > 0.0d) {
            sb.append(", minUpdateDistance=");
            sb.append(this.f8103f);
        }
        if (this.f8104g / 2 > this.f8099b) {
            sb.append(", maxUpdateDelay=");
            k.b(this.f8104g, sb);
        }
        sb.append(']');
        return sb.toString();
    }
}
