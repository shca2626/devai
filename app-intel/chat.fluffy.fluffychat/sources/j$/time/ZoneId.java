package j$.time;

import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes2.dex */
public abstract class ZoneId implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final Map f18200a;
    private static final long serialVersionUID = 8352817235686L;

    public abstract void P(DataOutput dataOutput);

    public abstract String q();

    public abstract j$.time.zone.f s();

    static {
        Map.Entry[] entryArr = {new AbstractMap.SimpleImmutableEntry("ACT", "Australia/Darwin"), new AbstractMap.SimpleImmutableEntry("AET", "Australia/Sydney"), new AbstractMap.SimpleImmutableEntry("AGT", "America/Argentina/Buenos_Aires"), new AbstractMap.SimpleImmutableEntry("ART", "Africa/Cairo"), new AbstractMap.SimpleImmutableEntry("AST", "America/Anchorage"), new AbstractMap.SimpleImmutableEntry("BET", "America/Sao_Paulo"), new AbstractMap.SimpleImmutableEntry("BST", "Asia/Dhaka"), new AbstractMap.SimpleImmutableEntry("CAT", "Africa/Harare"), new AbstractMap.SimpleImmutableEntry("CNT", "America/St_Johns"), new AbstractMap.SimpleImmutableEntry("CST", "America/Chicago"), new AbstractMap.SimpleImmutableEntry("CTT", "Asia/Shanghai"), new AbstractMap.SimpleImmutableEntry("EAT", "Africa/Addis_Ababa"), new AbstractMap.SimpleImmutableEntry("ECT", "Europe/Paris"), new AbstractMap.SimpleImmutableEntry("IET", "America/Indiana/Indianapolis"), new AbstractMap.SimpleImmutableEntry("IST", "Asia/Kolkata"), new AbstractMap.SimpleImmutableEntry("JST", "Asia/Tokyo"), new AbstractMap.SimpleImmutableEntry("MIT", "Pacific/Apia"), new AbstractMap.SimpleImmutableEntry("NET", "Asia/Yerevan"), new AbstractMap.SimpleImmutableEntry("NST", "Pacific/Auckland"), new AbstractMap.SimpleImmutableEntry("PLT", "Asia/Karachi"), new AbstractMap.SimpleImmutableEntry("PNT", "America/Phoenix"), new AbstractMap.SimpleImmutableEntry("PRT", "America/Puerto_Rico"), new AbstractMap.SimpleImmutableEntry("PST", "America/Los_Angeles"), new AbstractMap.SimpleImmutableEntry("SST", "Pacific/Guadalcanal"), new AbstractMap.SimpleImmutableEntry("VST", "Asia/Ho_Chi_Minh"), new AbstractMap.SimpleImmutableEntry("EST", "-05:00"), new AbstractMap.SimpleImmutableEntry("MST", "-07:00"), new AbstractMap.SimpleImmutableEntry("HST", "-10:00")};
        HashMap map = new HashMap(28);
        for (int i7 = 0; i7 < 28; i7++) {
            Map.Entry entry = entryArr[i7];
            Object key = entry.getKey();
            Objects.requireNonNull(key);
            Object value = entry.getValue();
            Objects.requireNonNull(value);
            if (map.put(key, value) != null) {
                throw new IllegalArgumentException("duplicate key: " + key);
            }
        }
        f18200a = Collections.unmodifiableMap(map);
    }

    public static ZoneId of(String str) {
        return A(str, true);
    }

    public static ZoneId F(String str, z zVar) {
        Objects.requireNonNull(str, "prefix");
        Objects.requireNonNull(zVar, "offset");
        if (str.isEmpty()) {
            return zVar;
        }
        if (!str.equals("GMT") && !str.equals("UTC") && !str.equals("UT")) {
            throw new IllegalArgumentException("prefix should be GMT, UTC or UT, is: ".concat(str));
        }
        if (zVar.f18425b != 0) {
            str = str.concat(zVar.f18426c);
        }
        return new A(str, new j$.time.zone.f(zVar));
    }

    public static ZoneId A(String str, boolean z7) {
        Objects.requireNonNull(str, "zoneId");
        if (str.length() <= 1 || str.startsWith("+") || str.startsWith("-")) {
            return z.V(str);
        }
        if (str.startsWith("UTC") || str.startsWith("GMT")) {
            return I(str, 3, z7);
        }
        if (str.startsWith("UT")) {
            return I(str, 2, z7);
        }
        return A.V(str, z7);
    }

    public static ZoneId I(String str, int i7, boolean z7) {
        String strSubstring = str.substring(0, i7);
        if (str.length() == i7) {
            return F(strSubstring, z.f18422f);
        }
        if (str.charAt(i7) != '+' && str.charAt(i7) != '-') {
            return A.V(str, z7);
        }
        try {
            z zVarV = z.V(str.substring(i7));
            if (zVarV == z.f18422f) {
                return F(strSubstring, zVarV);
            }
            return F(strSubstring, zVarV);
        } catch (c e7) {
            throw new c("Invalid ID for offset-based ZoneId: ".concat(str), e7);
        }
    }

    public ZoneId() {
        if (getClass() != z.class && getClass() != A.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZoneId) {
            return q().equals(((ZoneId) obj).q());
        }
        return false;
    }

    public int hashCode() {
        return q().hashCode();
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public String toString() {
        return q();
    }

    private Object writeReplace() {
        return new u((byte) 7, this);
    }
}
