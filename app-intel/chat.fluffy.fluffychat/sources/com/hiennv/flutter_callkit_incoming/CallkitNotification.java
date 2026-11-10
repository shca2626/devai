package com.hiennv.flutter_callkit_incoming;

import android.app.Notification;

/* loaded from: classes.dex */
public final class CallkitNotification {
    private final int id;
    private final Notification notification;

    public CallkitNotification(int i7, Notification notification) {
        M5.m.e(notification, "notification");
        this.id = i7;
        this.notification = notification;
    }

    public static /* synthetic */ CallkitNotification copy$default(CallkitNotification callkitNotification, int i7, Notification notification, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i7 = callkitNotification.id;
        }
        if ((i8 & 2) != 0) {
            notification = callkitNotification.notification;
        }
        return callkitNotification.copy(i7, notification);
    }

    public final int component1() {
        return this.id;
    }

    public final Notification component2() {
        return this.notification;
    }

    public final CallkitNotification copy(int i7, Notification notification) {
        M5.m.e(notification, "notification");
        return new CallkitNotification(i7, notification);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallkitNotification)) {
            return false;
        }
        CallkitNotification callkitNotification = (CallkitNotification) obj;
        return this.id == callkitNotification.id && M5.m.a(this.notification, callkitNotification.notification);
    }

    public final int getId() {
        return this.id;
    }

    public final Notification getNotification() {
        return this.notification;
    }

    public int hashCode() {
        return (Integer.hashCode(this.id) * 31) + this.notification.hashCode();
    }

    public String toString() {
        return "CallkitNotification(id=" + this.id + ", notification=" + this.notification + ')';
    }
}
