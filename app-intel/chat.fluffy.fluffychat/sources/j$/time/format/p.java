package j$.time.format;

import j$.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final DateTimeFormatter f18324a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f18325b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f18326c = true;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f18327d;

    public p(DateTimeFormatter dateTimeFormatter) {
        ArrayList arrayList = new ArrayList();
        this.f18327d = arrayList;
        this.f18324a = dateTimeFormatter;
        arrayList.add(new w());
    }

    public final boolean a(char c7, char c8) {
        if (this.f18325b) {
            return c7 == c8;
        }
        return b(c7, c8);
    }

    public final boolean g(CharSequence charSequence, int i7, CharSequence charSequence2, int i8, int i9) {
        if (i7 + i9 <= charSequence.length() && i8 + i9 <= charSequence2.length()) {
            if (this.f18325b) {
                for (int i10 = 0; i10 < i9; i10++) {
                    if (charSequence.charAt(i7 + i10) == charSequence2.charAt(i8 + i10)) {
                    }
                }
                return true;
            }
            for (int i11 = 0; i11 < i9; i11++) {
                char cCharAt = charSequence.charAt(i7 + i11);
                char cCharAt2 = charSequence2.charAt(i8 + i11);
                if (cCharAt == cCharAt2 || Character.toUpperCase(cCharAt) == Character.toUpperCase(cCharAt2) || Character.toLowerCase(cCharAt) == Character.toLowerCase(cCharAt2)) {
                }
            }
            return true;
        }
        return false;
    }

    public static boolean b(char c7, char c8) {
        return c7 == c8 || Character.toUpperCase(c7) == Character.toUpperCase(c8) || Character.toLowerCase(c7) == Character.toLowerCase(c8);
    }

    public final w c() {
        return (w) this.f18327d.get(r0.size() - 1);
    }

    public final Long d(j$.time.temporal.a aVar) {
        return (Long) ((HashMap) c().f18338a).get(aVar);
    }

    public final int f(j$.time.temporal.q qVar, long j7, int i7, int i8) {
        Objects.requireNonNull(qVar, "field");
        Long l7 = (Long) ((HashMap) c().f18338a).put(qVar, Long.valueOf(j7));
        return (l7 == null || l7.longValue() == j7) ? i8 : ~i7;
    }

    public final void e(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        c().f18339b = zoneId;
    }

    public final String toString() {
        return c().toString();
    }
}
