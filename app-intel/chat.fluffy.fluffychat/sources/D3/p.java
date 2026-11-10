package D3;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public final float f1768a;

    /* renamed from: b, reason: collision with root package name */
    public final float f1769b;

    public p(float f7, float f8) {
        this.f1768a = f7;
        this.f1769b = f8;
    }

    public static float a(p pVar, p pVar2, p pVar3) {
        float f7 = pVar2.f1768a;
        float f8 = pVar2.f1769b;
        return ((pVar3.f1768a - f7) * (pVar.f1769b - f8)) - ((pVar3.f1769b - f8) * (pVar.f1768a - f7));
    }

    public static float b(p pVar, p pVar2) {
        return K3.a.a(pVar.f1768a, pVar.f1769b, pVar2.f1768a, pVar2.f1769b);
    }

    public static void e(p[] pVarArr) {
        p pVar;
        p pVar2;
        p pVar3;
        float fB = b(pVarArr[0], pVarArr[1]);
        float fB2 = b(pVarArr[1], pVarArr[2]);
        float fB3 = b(pVarArr[0], pVarArr[2]);
        if (fB2 >= fB && fB2 >= fB3) {
            pVar = pVarArr[0];
            pVar2 = pVarArr[1];
            pVar3 = pVarArr[2];
        } else if (fB3 < fB2 || fB3 < fB) {
            pVar = pVarArr[2];
            pVar2 = pVarArr[0];
            pVar3 = pVarArr[1];
        } else {
            pVar = pVarArr[1];
            pVar2 = pVarArr[0];
            pVar3 = pVarArr[2];
        }
        if (a(pVar2, pVar, pVar3) < 0.0f) {
            p pVar4 = pVar3;
            pVar3 = pVar2;
            pVar2 = pVar4;
        }
        pVarArr[0] = pVar2;
        pVarArr[1] = pVar;
        pVarArr[2] = pVar3;
    }

    public final float c() {
        return this.f1768a;
    }

    public final float d() {
        return this.f1769b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.f1768a == pVar.f1768a && this.f1769b == pVar.f1769b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f1768a) * 31) + Float.floatToIntBits(this.f1769b);
    }

    public final String toString() {
        return "(" + this.f1768a + ',' + this.f1769b + ')';
    }
}
