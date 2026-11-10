package U3;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    public static final Map f8437a;

    /* renamed from: b, reason: collision with root package name */
    public static final Map f8438b;

    /* renamed from: c, reason: collision with root package name */
    public static final Map f8439c;

    /* renamed from: d, reason: collision with root package name */
    public static final Map f8440d;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f8441a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8442b;

        public a(boolean z7, int i7) {
            this.f8441a = z7;
            this.f8442b = i7;
        }

        public static a a(int i7) {
            return new a(false, i7);
        }

        public static a b(int i7) {
            return new a(true, i7);
        }
    }

    static {
        HashMap map = new HashMap();
        f8437a = map;
        map.put("00", a.a(18));
        map.put("01", a.a(14));
        map.put("02", a.a(14));
        map.put("10", a.b(20));
        map.put("11", a.a(6));
        map.put("12", a.a(6));
        map.put("13", a.a(6));
        map.put("15", a.a(6));
        map.put("17", a.a(6));
        map.put("20", a.a(2));
        map.put("21", a.b(20));
        map.put("22", a.b(29));
        map.put("30", a.b(8));
        map.put("37", a.b(8));
        for (int i7 = 90; i7 <= 99; i7++) {
            f8437a.put(String.valueOf(i7), a.b(30));
        }
        HashMap map2 = new HashMap();
        f8438b = map2;
        map2.put("240", a.b(30));
        map2.put("241", a.b(30));
        map2.put("242", a.b(6));
        map2.put("250", a.b(30));
        map2.put("251", a.b(30));
        map2.put("253", a.b(17));
        map2.put("254", a.b(20));
        map2.put("400", a.b(30));
        map2.put("401", a.b(30));
        map2.put("402", a.a(17));
        map2.put("403", a.b(30));
        map2.put("410", a.a(13));
        map2.put("411", a.a(13));
        map2.put("412", a.a(13));
        map2.put("413", a.a(13));
        map2.put("414", a.a(13));
        map2.put("420", a.b(20));
        map2.put("421", a.b(15));
        map2.put("422", a.a(3));
        map2.put("423", a.b(15));
        map2.put("424", a.a(3));
        map2.put("425", a.a(3));
        map2.put("426", a.a(3));
        f8439c = new HashMap();
        for (int i8 = 310; i8 <= 316; i8++) {
            f8439c.put(String.valueOf(i8), a.a(6));
        }
        for (int i9 = 320; i9 <= 336; i9++) {
            f8439c.put(String.valueOf(i9), a.a(6));
        }
        for (int i10 = 340; i10 <= 357; i10++) {
            f8439c.put(String.valueOf(i10), a.a(6));
        }
        for (int i11 = 360; i11 <= 369; i11++) {
            f8439c.put(String.valueOf(i11), a.a(6));
        }
        Map map3 = f8439c;
        map3.put("390", a.b(15));
        map3.put("391", a.b(18));
        map3.put("392", a.b(15));
        map3.put("393", a.b(18));
        map3.put("703", a.b(30));
        HashMap map4 = new HashMap();
        f8440d = map4;
        map4.put("7001", a.a(13));
        map4.put("7002", a.b(30));
        map4.put("7003", a.a(10));
        map4.put("8001", a.a(14));
        map4.put("8002", a.b(20));
        map4.put("8003", a.b(30));
        map4.put("8004", a.b(30));
        map4.put("8005", a.a(6));
        map4.put("8006", a.a(18));
        map4.put("8007", a.b(30));
        map4.put("8008", a.b(12));
        map4.put("8018", a.a(18));
        map4.put("8020", a.b(25));
        map4.put("8100", a.a(6));
        map4.put("8101", a.a(10));
        map4.put("8102", a.a(2));
        map4.put("8110", a.b(70));
        map4.put("8200", a.b(70));
    }

    public static String a(String str) throws D3.j {
        if (str.isEmpty()) {
            return null;
        }
        if (str.length() < 2) {
            throw D3.j.a();
        }
        a aVar = (a) f8437a.get(str.substring(0, 2));
        if (aVar != null) {
            return aVar.f8441a ? c(2, aVar.f8442b, str) : b(2, aVar.f8442b, str);
        }
        if (str.length() < 3) {
            throw D3.j.a();
        }
        String strSubstring = str.substring(0, 3);
        a aVar2 = (a) f8438b.get(strSubstring);
        if (aVar2 != null) {
            return aVar2.f8441a ? c(3, aVar2.f8442b, str) : b(3, aVar2.f8442b, str);
        }
        if (str.length() < 4) {
            throw D3.j.a();
        }
        a aVar3 = (a) f8439c.get(strSubstring);
        if (aVar3 != null) {
            return aVar3.f8441a ? c(4, aVar3.f8442b, str) : b(4, aVar3.f8442b, str);
        }
        a aVar4 = (a) f8440d.get(str.substring(0, 4));
        if (aVar4 != null) {
            return aVar4.f8441a ? c(4, aVar4.f8442b, str) : b(4, aVar4.f8442b, str);
        }
        throw D3.j.a();
    }

    public static String b(int i7, int i8, String str) throws D3.j {
        if (str.length() < i7) {
            throw D3.j.a();
        }
        String strSubstring = str.substring(0, i7);
        int i9 = i8 + i7;
        if (str.length() < i9) {
            throw D3.j.a();
        }
        String strSubstring2 = str.substring(i7, i9);
        String str2 = '(' + strSubstring + ')' + strSubstring2;
        String strA = a(str.substring(i9));
        if (strA == null) {
            return str2;
        }
        return str2 + strA;
    }

    public static String c(int i7, int i8, String str) throws D3.j {
        String strSubstring = str.substring(0, i7);
        int iMin = Math.min(str.length(), i8 + i7);
        String strSubstring2 = str.substring(i7, iMin);
        String str2 = '(' + strSubstring + ')' + strSubstring2;
        String strA = a(str.substring(iMin));
        if (strA == null) {
            return str2;
        }
        return str2 + strA;
    }
}
