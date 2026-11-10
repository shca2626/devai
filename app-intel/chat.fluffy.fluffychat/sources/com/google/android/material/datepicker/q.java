package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class q {

    /* renamed from: c, reason: collision with root package name */
    public static final q f14573c = new q(null, null);

    /* renamed from: a, reason: collision with root package name */
    public final Long f14574a;

    /* renamed from: b, reason: collision with root package name */
    public final TimeZone f14575b;

    public q(Long l7, TimeZone timeZone) {
        this.f14574a = l7;
        this.f14575b = timeZone;
    }

    public static q c() {
        return f14573c;
    }

    public Calendar a() {
        return b(this.f14575b);
    }

    public Calendar b(TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l7 = this.f14574a;
        if (l7 != null) {
            calendar.setTimeInMillis(l7.longValue());
        }
        return calendar;
    }
}
