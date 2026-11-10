package com.dexterous.flutterlocalnotifications.models;

import h.InterfaceC1116a;
import java.lang.reflect.Type;
import u3.AbstractC1654j;
import u3.InterfaceC1652h;
import u3.InterfaceC1653i;

@InterfaceC1116a
/* loaded from: classes.dex */
public enum ScheduleMode {
    alarmClock,
    exact,
    exactAllowWhileIdle,
    inexact,
    inexactAllowWhileIdle;

    public static class a implements InterfaceC1653i {
        @Override // u3.InterfaceC1653i
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ScheduleMode a(AbstractC1654j abstractC1654j, Type type, InterfaceC1652h interfaceC1652h) {
            try {
                return ScheduleMode.valueOf(abstractC1654j.j());
            } catch (Exception unused) {
                return abstractC1654j.f() ? ScheduleMode.exactAllowWhileIdle : ScheduleMode.exact;
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
