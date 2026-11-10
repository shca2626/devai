package com.dexterous.flutterlocalnotifications;

import com.dexterous.flutterlocalnotifications.models.NotificationDetails;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class M implements Serializable {

    /* renamed from: l, reason: collision with root package name */
    public final NotificationDetails f14182l;

    /* renamed from: m, reason: collision with root package name */
    public final int f14183m;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList f14184n;

    public M(NotificationDetails notificationDetails, int i7, ArrayList arrayList) {
        this.f14182l = notificationDetails;
        this.f14183m = i7;
        this.f14184n = arrayList;
    }

    public String toString() {
        return "ForegroundServiceStartParameter{notificationData=" + this.f14182l + ", startMode=" + this.f14183m + ", foregroundServiceTypes=" + this.f14184n + '}';
    }
}
