package z1;

import B0.y;
import java.util.Objects;

/* renamed from: z1.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1838h implements y.a {

    /* renamed from: a, reason: collision with root package name */
    public final float f24064a;

    /* renamed from: b, reason: collision with root package name */
    public a f24065b;

    /* renamed from: c, reason: collision with root package name */
    public a f24066c;

    /* renamed from: z1.h$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f24067a;

        /* renamed from: b, reason: collision with root package name */
        public final int f24068b;

        /* renamed from: c, reason: collision with root package name */
        public final float f24069c;

        public a(int i7, int i8, float f7) {
            this.f24067a = i7;
            this.f24068b = i8;
            this.f24069c = f7;
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
            return this.f24067a == aVar.f24067a && this.f24068b == aVar.f24068b && Float.compare(this.f24069c, aVar.f24069c) == 0;
        }

        public int hashCode() {
            return (((this.f24067a * 31) + this.f24068b) * 31) + Float.hashCode(this.f24069c);
        }

        public String toString() {
            return "GainField{name=" + this.f24067a + ", originator=" + this.f24068b + ", gain=" + this.f24069c + '}';
        }
    }

    public C1838h(float f7, a aVar, a aVar2) {
        this.f24064a = f7;
        this.f24065b = aVar;
        this.f24066c = aVar2;
    }

    public static C1838h d(float f7, int i7, int i8) {
        a aVarB = a.b(i7);
        a aVarB2 = a.b(i8);
        if (f7 <= 0.0f && aVarB == null && aVarB2 == null) {
            return null;
        }
        return new C1838h(f7, aVarB, aVarB2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1838h)) {
            return false;
        }
        C1838h c1838h = (C1838h) obj;
        return Float.compare(this.f24064a, c1838h.f24064a) == 0 && Objects.equals(this.f24065b, c1838h.f24065b) && Objects.equals(this.f24066c, c1838h.f24066c);
    }

    public int hashCode() {
        int iHashCode = Float.hashCode(this.f24064a) * 31;
        a aVar = this.f24065b;
        int iHashCode2 = (iHashCode + (aVar != null ? aVar.hashCode() : 0)) * 31;
        a aVar2 = this.f24066c;
        return iHashCode2 + (aVar2 != null ? aVar2.hashCode() : 0);
    }

    public String toString() {
        return "ReplayGain Xing/Info: peak=" + this.f24064a + ", field 1=" + this.f24065b + ", field 2=" + this.f24066c;
    }
}
