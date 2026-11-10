package com.hiennv.flutter_callkit_incoming;

import android.os.Bundle;

/* loaded from: classes.dex */
public interface CallkitEventCallback {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class CallEvent {
        private static final /* synthetic */ F5.a $ENTRIES;
        private static final /* synthetic */ CallEvent[] $VALUES;
        public static final CallEvent ACCEPT = new CallEvent("ACCEPT", 0);
        public static final CallEvent DECLINE = new CallEvent("DECLINE", 1);
        public static final CallEvent END = new CallEvent("END", 2);

        private static final /* synthetic */ CallEvent[] $values() {
            return new CallEvent[]{ACCEPT, DECLINE, END};
        }

        static {
            CallEvent[] callEventArr$values = $values();
            $VALUES = callEventArr$values;
            $ENTRIES = F5.b.a(callEventArr$values);
        }

        private CallEvent(String str, int i7) {
        }

        public static F5.a getEntries() {
            return $ENTRIES;
        }

        public static CallEvent valueOf(String str) {
            return (CallEvent) Enum.valueOf(CallEvent.class, str);
        }

        public static CallEvent[] values() {
            return (CallEvent[]) $VALUES.clone();
        }
    }

    void onCallEvent(CallEvent callEvent, Bundle bundle);
}
