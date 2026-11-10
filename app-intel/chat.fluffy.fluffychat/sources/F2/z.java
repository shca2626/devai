package F2;

import java.util.Map;

/* loaded from: classes.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    public final i f2707a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2708b;

    /* renamed from: c, reason: collision with root package name */
    public final long f2709c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f2710d;

    public z(i iVar, long j7, long j8, boolean z7) {
        this.f2707a = iVar;
        this.f2708b = j7;
        this.f2709c = j8;
        this.f2710d = z7;
    }

    public static z e(Map map) {
        if (map == null) {
            return new z(i.best, 0L, 5000L, false);
        }
        Integer num = (Integer) map.get("accuracy");
        Integer num2 = (Integer) map.get("distanceFilter");
        Integer num3 = (Integer) map.get("timeInterval");
        Boolean bool = (Boolean) map.get("useMSLAltitude");
        i iVar = i.best;
        if (num != null) {
            int iIntValue = num.intValue();
            if (iIntValue == 0) {
                iVar = i.lowest;
            } else if (iIntValue == 1) {
                iVar = i.low;
            } else if (iIntValue == 2) {
                iVar = i.medium;
            } else if (iIntValue == 3) {
                iVar = i.high;
            } else if (iIntValue == 5) {
                iVar = i.bestForNavigation;
            }
        }
        return new z(iVar, num2 != null ? num2.intValue() : 0L, num3 != null ? num3.intValue() : 5000L, bool != null && bool.booleanValue());
    }

    public i a() {
        return this.f2707a;
    }

    public long b() {
        return this.f2708b;
    }

    public long c() {
        return this.f2709c;
    }

    public boolean d() {
        return this.f2710d;
    }
}
