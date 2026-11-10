package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes8.dex */
class q {

    /* renamed from: c, reason: collision with root package name */
    private static final q f22717c = new q(null, null);

    /* renamed from: a, reason: collision with root package name */
    private final Long f22718a;

    /* renamed from: b, reason: collision with root package name */
    private final TimeZone f22719b;

    private q(Long l12, TimeZone timeZone) {
        this.f22718a = l12;
        this.f22719b = timeZone;
    }

    static q c() {
        return f22717c;
    }

    Calendar a() {
        return b(this.f22719b);
    }

    Calendar b(TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l12 = this.f22718a;
        if (l12 != null) {
            calendar.setTimeInMillis(l12.longValue());
        }
        return calendar;
    }
}
