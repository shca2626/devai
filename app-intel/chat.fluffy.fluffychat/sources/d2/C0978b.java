package d2;

import M5.m;
import android.graphics.Rect;

/* renamed from: d2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0978b {

    /* renamed from: a, reason: collision with root package name */
    public final int f15119a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15120b;

    /* renamed from: c, reason: collision with root package name */
    public final int f15121c;

    /* renamed from: d, reason: collision with root package name */
    public final int f15122d;

    public C0978b(int i7, int i8, int i9, int i10) {
        this.f15119a = i7;
        this.f15120b = i8;
        this.f15121c = i9;
        this.f15122d = i10;
        if (i7 > i9) {
            throw new IllegalArgumentException(("Left must be less than or equal to right, left: " + i7 + ", right: " + i9).toString());
        }
        if (i8 <= i10) {
            return;
        }
        throw new IllegalArgumentException(("top must be less than or equal to bottom, top: " + i8 + ", bottom: " + i10).toString());
    }

    public final int a() {
        return this.f15122d - this.f15120b;
    }

    public final int b() {
        return this.f15119a;
    }

    public final int c() {
        return this.f15120b;
    }

    public final int d() {
        return this.f15121c - this.f15119a;
    }

    public final boolean e() {
        return a() == 0 && d() == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!m.a(C0978b.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        m.c(obj, "null cannot be cast to non-null type androidx.window.core.Bounds");
        C0978b c0978b = (C0978b) obj;
        return this.f15119a == c0978b.f15119a && this.f15120b == c0978b.f15120b && this.f15121c == c0978b.f15121c && this.f15122d == c0978b.f15122d;
    }

    public final Rect f() {
        return new Rect(this.f15119a, this.f15120b, this.f15121c, this.f15122d);
    }

    public int hashCode() {
        return (((((this.f15119a * 31) + this.f15120b) * 31) + this.f15121c) * 31) + this.f15122d;
    }

    public String toString() {
        return C0978b.class.getSimpleName() + " { [" + this.f15119a + ',' + this.f15120b + ',' + this.f15121c + ',' + this.f15122d + "] }";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0978b(Rect rect) {
        this(rect.left, rect.top, rect.right, rect.bottom);
        m.e(rect, "rect");
    }
}
