package F5;

import M5.m;
import java.io.Serializable;
import z5.AbstractC1869c;
import z5.C1878l;

/* loaded from: classes.dex */
public final class c extends AbstractC1869c implements a, Serializable {

    /* renamed from: m, reason: collision with root package name */
    public final Enum[] f2737m;

    public c(Enum[] enumArr) {
        m.e(enumArr, "entries");
        this.f2737m = enumArr;
    }

    @Override // z5.AbstractC1868b, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Enum) {
            return i((Enum) obj);
        }
        return false;
    }

    @Override // z5.AbstractC1868b
    public int g() {
        return this.f2737m.length;
    }

    public boolean i(Enum r32) {
        m.e(r32, "element");
        return ((Enum) C1878l.A(this.f2737m, r32.ordinal())) == r32;
    }

    @Override // z5.AbstractC1869c, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Enum) {
            return k((Enum) obj);
        }
        return -1;
    }

    @Override // z5.AbstractC1869c, java.util.List
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Enum get(int i7) {
        AbstractC1869c.f24160l.b(i7, this.f2737m.length);
        return this.f2737m[i7];
    }

    public int k(Enum r32) {
        m.e(r32, "element");
        int iOrdinal = r32.ordinal();
        if (((Enum) C1878l.A(this.f2737m, iOrdinal)) == r32) {
            return iOrdinal;
        }
        return -1;
    }

    public int l(Enum r22) {
        m.e(r22, "element");
        return k(r22);
    }

    @Override // z5.AbstractC1869c, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return l((Enum) obj);
        }
        return -1;
    }
}
