package com.dexterous.flutterlocalnotifications.models;

import h.InterfaceC1117a;
import java.lang.reflect.Type;
import u3.AbstractC1653j;
import u3.InterfaceC1651h;
import u3.InterfaceC1652i;

@InterfaceC1117a
/* loaded from: classes.dex */
public enum ScheduleMode {
    alarmClock,
    exact,
    exactAllowWhileIdle,
    inexact,
    inexactAllowWhileIdle;

    public static class a implements InterfaceC1652i {
        @Override // u3.InterfaceC1652i
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ScheduleMode a(AbstractC1653j abstractC1653j, Type type, InterfaceC1651h interfaceC1651h) {
            try {
                return ScheduleMode.valueOf(abstractC1653j.j());
            } catch (Exception unused) {
                return abstractC1653j.f() ? ScheduleMode.exactAllowWhileIdle : ScheduleMode.exact;
            }
        }
    }

    public boolean useAlarmClock() {
        return this == alarmClock;
    }

    public boolean useAllowWhileIdle() {
        return this == exactAllowWhileIdle || this == inexactAllowWhileIdle;
    }

    public boolean useExactAlarm() {
        return this == exact || this == exactAllowWhileIdle;
    }
}
