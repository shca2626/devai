package z1;

import B0.y;
import java.util.Objects;

/* renamed from: z1.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1837h implements y.a {

    /* renamed from: a, reason: collision with root package name */
    public final float f24070a;

    /* renamed from: b, reason: collision with root package name */
    public a f24071b;

    /* renamed from: c, reason: collision with root package name */
    public a f24072c;

    /* renamed from: z1.h$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f24073a;

        /* renamed from: b, reason: collision with root package name */
        public final int f24074b;

        /* renamed from: c, reason: collision with root package name */
        public final float f24075c;

        public a(int i7, int i8, float f7) {
            this.f24073a = i7;
            this.f24074b = i8;
            this.f24075c = f7;
        }

        public static a b(int i7) {
            int i8 = (i7 >> 13) & 7;
            if (i8 == 0) {
                return null;
            }
            return new a(i8, (i7 >> 10) & 7, ((i7 & 511) * ((i7 & 512) != 0 ? -1 : 1)) / 10.0f);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f24073a == aVar.f24073a && this.f24074b == aVar.f24074b && Float.compare(this.f24075c, aVar.f24075c) == 0;
        }

        public int hashCode() {
            return (((this.f24073a * 31) + this.f24074b) * 31) + Float.hashCode(this.f24075c);
        }

        public String toString() {
            return "GainField{name=" + this.f24073a + ", originator=" + this.f24074b + ", gain=" + this.f24075c + '}';
        }
    }

    public C1837h(float f7, a aVar, a aVar2) {
        this.f24070a = f7;
        this.f24071b = aVar;
        this.f24072c = aVar2;
    }

    public static C1837h d(float f7, int i7, int i8) {
        a aVarB = a.b(i7);
        a aVarB2 = a.b(i8);
        if (f7 <= 0.0f && aVarB == null && aVarB2 == null) {
            return null;
        }
        return new C1837h(f7, aVarB, aVarB2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1837h)) {
            return false;
        }
        C1837h c1837h = (C1837h) obj;
        return Float.compare(this.f24070a, c1837h.f24070a) == 0 && Objects.equals(this.f24071b, c1837h.f24071b) && Objects.equals(this.f24072c, c1837h.f24072c);
    }

    public int hashCode() {
        int iHashCode = Float.hashCode(this.f24070a) * 31;
        a aVar = this.f24071b;
        int iHashCode2 = (iHashCode + (aVar != null ? aVar.hashCode() : 0)) * 31;
        a aVar2 = this.f24072c;
        return iHashCode2 + (aVar2 != null ? aVar2.hashCode() : 0);
    }

    public String toString() {
        return "ReplayGain Xing/Info: peak=" + this.f24070a + ", field 1=" + this.f24071b + ", field 2=" + this.f24072c;
    }
}
