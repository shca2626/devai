package P2;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public long f7549a;

    /* renamed from: b, reason: collision with root package name */
    public long f7550b;

    /* renamed from: c, reason: collision with root package name */
    public TimeInterpolator f7551c;

    /* renamed from: d, reason: collision with root package name */
    public int f7552d;

    /* renamed from: e, reason: collision with root package name */
    public int f7553e;

    public d(long j7, long j8) {
        this.f7551c = null;
        this.f7552d = 0;
        this.f7553e = 1;
        this.f7549a = j7;
        this.f7550b = j8;
    }

    public static d a(ValueAnimator valueAnimator) {
        d dVar = new d(valueAnimator.getStartDelay(), valueAnimator.getDuration(), e(valueAnimator));
        dVar.f7552d = valueAnimator.getRepeatCount();
        dVar.f7553e = valueAnimator.getRepeatMode();
        return dVar;
    }

    public static TimeInterpolator e(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        return ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) ? a.f7543b : interpolator instanceof AccelerateInterpolator ? a.f7544c : interpolator instanceof DecelerateInterpolator ? a.f7545d : interpolator;
    }

    public long b() {
        return this.f7549a;
    }

    public long c() {
        return this.f7550b;
    }

    public TimeInterpolator d() {
        TimeInterpolator timeInterpolator = this.f7551c;
        return timeInterpolator != null ? timeInterpolator : a.f7543b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (b() == dVar.b() && c() == dVar.c() && f() == dVar.f() && g() == dVar.g()) {
            return d().getClass().equals(dVar.d().getClass());
        }
        return false;
    }

    public int f() {
        return this.f7552d;
    }

    public int g() {
        return this.f7553e;
    }

    public int hashCode() {
        return (((((((((int) (b() ^ (b() >>> 32))) * 31) + ((int) (c() ^ (c() >>> 32)))) * 31) + d().getClass().hashCode()) * 31) + f()) * 31) + g();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + b() + " duration: " + c() + " interpolator: " + d().getClass() + " repeatCount: " + f() + " repeatMode: " + g() + "}\n";
    }

    public d(long j7, long j8, TimeInterpolator timeInterpolator) {
        this.f7552d = 0;
        this.f7553e = 1;
        this.f7549a = j7;
        this.f7550b = j8;
        this.f7551c = timeInterpolator;
    }
}
