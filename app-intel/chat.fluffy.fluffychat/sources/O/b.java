package O;

import android.graphics.Insets;
import android.graphics.Rect;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final b f6451e = new b(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f6452a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6453b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6454c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6455d;

    public static class a {
        public static Insets a(int i7, int i8, int i9, int i10) {
            return Insets.of(i7, i8, i9, i10);
        }
    }

    public b(int i7, int i8, int i9, int i10) {
        this.f6452a = i7;
        this.f6453b = i8;
        this.f6454c = i9;
        this.f6455d = i10;
    }

    public static b a(b bVar, b bVar2) {
        return b(Math.max(bVar.f6452a, bVar2.f6452a), Math.max(bVar.f6453b, bVar2.f6453b), Math.max(bVar.f6454c, bVar2.f6454c), Math.max(bVar.f6455d, bVar2.f6455d));
    }

    public static b b(int i7, int i8, int i9, int i10) {
        return (i7 == 0 && i8 == 0 && i9 == 0 && i10 == 0) ? f6451e : new b(i7, i8, i9, i10);
    }

    public static b c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static b d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return a.a(this.f6452a, this.f6453b, this.f6454c, this.f6455d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f6455d == bVar.f6455d && this.f6452a == bVar.f6452a && this.f6454c == bVar.f6454c && this.f6453b == bVar.f6453b;
    }

    public int hashCode() {
        return (((((this.f6452a * 31) + this.f6453b) * 31) + this.f6454c) * 31) + this.f6455d;
    }

    public String toString() {
        return "Insets{left=" + this.f6452a + ", top=" + this.f6453b + ", right=" + this.f6454c + ", bottom=" + this.f6455d + '}';
    }
}
