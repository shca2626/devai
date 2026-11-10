package Z;

import android.graphics.Point;
import android.view.RoundedCorner;

/* loaded from: classes.dex */
public final class P {

    /* renamed from: a, reason: collision with root package name */
    public final int f9954a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9955b;

    /* renamed from: c, reason: collision with root package name */
    public final Point f9956c;

    public P(int i7, int i8, int i9, int i10) {
        this.f9954a = i7;
        this.f9955b = i8;
        this.f9956c = new Point(i9, i10);
    }

    public static int c(int i7) {
        if (i7 == 0) {
            return 0;
        }
        int i8 = 1;
        if (i7 != 1) {
            i8 = 2;
            if (i7 != 2) {
                if (i7 == 3) {
                    return 3;
                }
                throw new IllegalArgumentException("Invalid position: " + i7);
            }
        }
        return i8;
    }

    public static P d(RoundedCorner roundedCorner) {
        if (roundedCorner != null) {
            return new P(c(roundedCorner.getPosition()), roundedCorner.getRadius(), roundedCorner.getCenter());
        }
        return null;
    }

    public final String a(int i7) {
        return i7 != 0 ? i7 != 1 ? i7 != 2 ? i7 != 3 ? "Invalid" : "BottomLeft" : "BottomRight" : "TopRight" : "TopLeft";
    }

    public int b() {
        return this.f9955b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof P) {
            P p7 = (P) obj;
            if (this.f9954a == p7.f9954a && this.f9955b == p7.f9955b && this.f9956c.equals(p7.f9956c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f9954a * 31) + this.f9955b) * 31) + this.f9956c.hashCode();
    }

    public String toString() {
        return "RoundedCornerCompat{position=" + a(this.f9954a) + ", radius=" + this.f9955b + ", center=" + this.f9956c + '}';
    }

    public P(int i7, int i8, Point point) {
        this(i7, i8, point.x, point.y);
    }
}
