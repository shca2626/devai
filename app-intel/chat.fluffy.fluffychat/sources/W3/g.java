package W3;

import java.util.Formatter;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final c f8995a;

    /* renamed from: b, reason: collision with root package name */
    public final d[] f8996b;

    public g(c cVar) {
        this.f8995a = new c(cVar);
        this.f8996b = new d[(cVar.e() - cVar.g()) + 1];
    }

    public final c a() {
        return this.f8995a;
    }

    public final d b(int i7) {
        return this.f8996b[e(i7)];
    }

    public final d c(int i7) {
        d dVar;
        d dVar2;
        d dVarB = b(i7);
        if (dVarB != null) {
            return dVarB;
        }
        for (int i8 = 1; i8 < 5; i8++) {
            int iE = e(i7) - i8;
            if (iE >= 0 && (dVar2 = this.f8996b[iE]) != null) {
                return dVar2;
            }
            int iE2 = e(i7) + i8;
            d[] dVarArr = this.f8996b;
            if (iE2 < dVarArr.length && (dVar = dVarArr[iE2]) != null) {
                return dVar;
            }
        }
        return null;
    }

    public final d[] d() {
        return this.f8996b;
    }

    public final int e(int i7) {
        return i7 - this.f8995a.g();
    }

    public final void f(int i7, d dVar) {
        this.f8996b[e(i7)] = dVar;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        try {
            int i7 = 0;
            for (d dVar : this.f8996b) {
                if (dVar == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i7));
                    i7++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i7), Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                    i7++;
                }
            }
            String string = formatter.toString();
            formatter.close();
            return string;
        } catch (Throwable th) {
            try {
                formatter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
