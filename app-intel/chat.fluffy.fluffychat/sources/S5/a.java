package S5;

import M5.g;
import z5.AbstractC1863D;

/* loaded from: classes.dex */
public class a implements Iterable, N5.a {

    /* renamed from: o, reason: collision with root package name */
    public static final C0067a f8204o = new C0067a(null);

    /* renamed from: l, reason: collision with root package name */
    public final int f8205l;

    /* renamed from: m, reason: collision with root package name */
    public final int f8206m;

    /* renamed from: n, reason: collision with root package name */
    public final int f8207n;

    /* renamed from: S5.a$a, reason: collision with other inner class name */
    public static final class C0067a {
        public /* synthetic */ C0067a(g gVar) {
            this();
        }

        public final a a(int i7, int i8, int i9) {
            return new a(i7, i8, i9);
        }

        public C0067a() {
        }
    }

    public a(int i7, int i8, int i9) {
        if (i9 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i9 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f8205l = i7;
        this.f8206m = G5.c.b(i7, i8, i9);
        this.f8207n = i9;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        if (isEmpty() && ((a) obj).isEmpty()) {
            return true;
        }
        a aVar = (a) obj;
        return this.f8205l == aVar.f8205l && this.f8206m == aVar.f8206m && this.f8207n == aVar.f8207n;
    }

    public final int f() {
        return this.f8205l;
    }

    public final int g() {
        return this.f8206m;
    }

    public final int h() {
        return this.f8207n;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f8205l * 31) + this.f8206m) * 31) + this.f8207n;
    }

    @Override // java.lang.Iterable
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public AbstractC1863D iterator() {
        return new b(this.f8205l, this.f8206m, this.f8207n);
    }

    public boolean isEmpty() {
        return this.f8207n > 0 ? this.f8205l > this.f8206m : this.f8205l < this.f8206m;
    }

    public String toString() {
        StringBuilder sb;
        int i7;
        if (this.f8207n > 0) {
            sb = new StringBuilder();
            sb.append(this.f8205l);
            sb.append("..");
            sb.append(this.f8206m);
            sb.append(" step ");
            i7 = this.f8207n;
        } else {
            sb = new StringBuilder();
            sb.append(this.f8205l);
            sb.append(" downTo ");
            sb.append(this.f8206m);
            sb.append(" step ");
            i7 = -this.f8207n;
        }
        sb.append(i7);
        return sb.toString();
    }
}
