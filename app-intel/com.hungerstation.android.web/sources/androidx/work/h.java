package androidx.work;

import android.app.Notification;

/* loaded from: classes7.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private final int f12008a;

    /* renamed from: b, reason: collision with root package name */
    private final int f12009b;

    /* renamed from: c, reason: collision with root package name */
    private final Notification f12010c;

    public h(int i12, Notification notification, int i13) {
        this.f12008a = i12;
        this.f12010c = notification;
        this.f12009b = i13;
    }

    public int a() {
        return this.f12009b;
    }

    public Notification b() {
        return this.f12010c;
    }

    public int c() {
        return this.f12008a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f12008a == hVar.f12008a && this.f12009b == hVar.f12009b) {
            return this.f12010c.equals(hVar.f12010c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f12008a * 31) + this.f12009b) * 31) + this.f12010c.hashCode();
    }

    public String toString() {
        return "ForegroundInfo{mNotificationId=" + this.f12008a + ", mForegroundServiceType=" + this.f12009b + ", mNotification=" + this.f12010c + '}';
    }
}
