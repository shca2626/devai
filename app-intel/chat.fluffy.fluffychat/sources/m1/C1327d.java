package m1;

import E0.E;
import g1.C1085o;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: m1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1327d extends AbstractC1328e {

    /* renamed from: b, reason: collision with root package name */
    public long f19718b;

    /* renamed from: c, reason: collision with root package name */
    public long[] f19719c;

    /* renamed from: d, reason: collision with root package name */
    public long[] f19720d;

    public C1327d() {
        super(new C1085o());
        this.f19718b = -9223372036854775807L;
        this.f19719c = new long[0];
        this.f19720d = new long[0];
    }

    public static Boolean g(E e7) {
        return Boolean.valueOf(e7.Q() == 1);
    }

    public static Object h(E e7, int i7) {
        if (i7 == 0) {
            return j(e7);
        }
        if (i7 == 1) {
            return g(e7);
        }
        if (i7 == 2) {
            return n(e7);
        }
        if (i7 == 3) {
            return l(e7);
        }
        if (i7 == 8) {
            return k(e7);
        }
        if (i7 == 10) {
            return m(e7);
        }
        if (i7 != 11) {
            return null;
        }
        return i(e7);
    }

    public static Date i(E e7) {
        Date date = new Date((long) j(e7).doubleValue());
        e7.g0(2);
        return date;
    }

    public static Double j(E e7) {
        return Double.valueOf(Double.longBitsToDouble(e7.J()));
    }

    public static HashMap k(E e7) {
        int iU = e7.U();
        HashMap map = new HashMap(iU);
        for (int i7 = 0; i7 < iU; i7++) {
            String strN = n(e7);
            Object objH = h(e7, o(e7));
            if (objH != null) {
                map.put(strN, objH);
            }
        }
        return map;
    }

    public static HashMap l(E e7) {
        HashMap map = new HashMap();
        while (true) {
            String strN = n(e7);
            int iO = o(e7);
            if (iO == 9) {
                return map;
            }
            Object objH = h(e7, iO);
            if (objH != null) {
                map.put(strN, objH);
            }
        }
    }

    public static ArrayList m(E e7) {
        int iU = e7.U();
        ArrayList arrayList = new ArrayList(iU);
        for (int i7 = 0; i7 < iU; i7++) {
            Object objH = h(e7, o(e7));
            if (objH != null) {
                arrayList.add(objH);
            }
        }
        return arrayList;
    }

    public static String n(E e7) {
        int iY = e7.Y();
        int iG = e7.g();
        e7.g0(iY);
        return new String(e7.f(), iG, iY);
    }

    public static int o(E e7) {
        return e7.Q();
    }

    @Override // m1.AbstractC1328e
    public boolean b(E e7) {
        return true;
    }

    @Override // m1.AbstractC1328e
    public boolean c(E e7, long j7) {
        if (o(e7) != 2 || !"onMetaData".equals(n(e7)) || e7.a() == 0 || o(e7) != 8) {
            return false;
        }
        HashMap mapK = k(e7);
        Object obj = mapK.get("duration");
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (dDoubleValue > 0.0d) {
                this.f19718b = (long) (dDoubleValue * 1000000.0d);
            }
        }
        Object obj2 = mapK.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.f19719c = new long[size];
                this.f19720d = new long[size];
                for (int i7 = 0; i7 < size; i7++) {
                    Object obj5 = list.get(i7);
                    Object obj6 = list2.get(i7);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        this.f19719c = new long[0];
                        this.f19720d = new long[0];
                        break;
                    }
                    this.f19719c[i7] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                    this.f19720d[i7] = ((Double) obj5).longValue();
                }
            }
        }
        return false;
    }

    public long d() {
        return this.f19718b;
    }

    public long[] e() {
        return this.f19720d;
    }

    public long[] f() {
        return this.f19719c;
    }
}
