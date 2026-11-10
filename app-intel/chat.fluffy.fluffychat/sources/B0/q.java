package B0;

import android.util.SparseBooleanArray;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final SparseBooleanArray f687a;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final SparseBooleanArray f688a = new SparseBooleanArray();

        /* renamed from: b, reason: collision with root package name */
        public boolean f689b;

        public b a(int i7) {
            j3.o.v(!this.f689b);
            this.f688a.append(i7, true);
            return this;
        }

        public b b(q qVar) {
            for (int i7 = 0; i7 < qVar.c(); i7++) {
                a(qVar.b(i7));
            }
            return this;
        }

        public b c(int... iArr) {
            for (int i7 : iArr) {
                a(i7);
            }
            return this;
        }

        public b d(int i7, boolean z7) {
            return z7 ? a(i7) : this;
        }

        public q e() {
            j3.o.v(!this.f689b);
            this.f689b = true;
            return new q(this.f688a);
        }
    }

    public boolean a(int i7) {
        return this.f687a.get(i7);
    }

    public int b(int i7) {
        j3.o.o(i7, c());
        return this.f687a.keyAt(i7);
    }

    public int c() {
        return this.f687a.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            return this.f687a.equals(((q) obj).f687a);
        }
        return false;
    }

    public int hashCode() {
        return this.f687a.hashCode();
    }

    public q(SparseBooleanArray sparseBooleanArray) {
        this.f687a = sparseBooleanArray;
    }
}
