package B0;

import B0.x;
import E0.U;
import java.util.Arrays;
import java.util.List;
import k3.AbstractC1278v;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final a[] f1055a;

    /* renamed from: b, reason: collision with root package name */
    public final long f1056b;

    public y(a... aVarArr) {
        this(-9223372036854775807L, aVarArr);
    }

    public y a(a... aVarArr) {
        return aVarArr.length == 0 ? this : new y(this.f1056b, (a[]) U.U0(this.f1055a, aVarArr));
    }

    public y b(y yVar) {
        return yVar == null ? this : a(yVar.f1055a);
    }

    public y c(long j7) {
        return this.f1056b == j7 ? this : new y(j7, this.f1055a);
    }

    public final a d(a aVar, Class cls, j3.p pVar) {
        if (!cls.isAssignableFrom(aVar.getClass())) {
            return null;
        }
        a aVar2 = (a) cls.cast(aVar);
        if (pVar.apply(aVar2)) {
            return aVar2;
        }
        return null;
    }

    public a e(int i7) {
        return this.f1055a[i7];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && y.class == obj.getClass()) {
            y yVar = (y) obj;
            if (Arrays.equals(this.f1055a, yVar.f1055a) && this.f1056b == yVar.f1056b) {
                return true;
            }
        }
        return false;
    }

    public AbstractC1278v f(Class cls) {
        AbstractC1278v.a aVarO = AbstractC1278v.o();
        for (a aVar : this.f1055a) {
            if (cls.isAssignableFrom(aVar.getClass())) {
                aVarO.a((a) cls.cast(aVar));
            }
        }
        return aVarO.k();
    }

    public a g(Class cls) {
        return h(cls, j3.q.b());
    }

    public a h(Class cls, j3.p pVar) {
        for (a aVar : this.f1055a) {
            a aVarD = d(aVar, cls, pVar);
            if (aVarD != null) {
                return aVarD;
            }
        }
        return null;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f1055a) * 31) + o3.i.c(this.f1056b);
    }

    public AbstractC1278v i(Class cls, j3.p pVar) {
        AbstractC1278v.a aVarO = AbstractC1278v.o();
        for (a aVar : this.f1055a) {
            a aVarD = d(aVar, cls, pVar);
            if (aVarD != null) {
                aVarO.a(aVarD);
            }
        }
        return aVarO.k();
    }

    public int j() {
        return this.f1055a.length;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("entries=");
        sb.append(Arrays.toString(this.f1055a));
        if (this.f1056b == -9223372036854775807L) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + this.f1056b;
        }
        sb.append(str);
        return sb.toString();
    }

    public y(long j7, a... aVarArr) {
        this.f1056b = j7;
        this.f1055a = aVarArr;
    }

    public y(List list) {
        this((a[]) list.toArray(new a[0]));
    }

    public y(long j7, List list) {
        this(j7, (a[]) list.toArray(new a[0]));
    }

    public interface a {
        default s b() {
            return null;
        }

        default byte[] c() {
            return null;
        }

        default void a(x.b bVar) {
        }
    }
}
