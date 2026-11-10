package c1;

import B0.A;
import G0.s;
import c1.k;
import c1.m;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes.dex */
public class j implements k {

    /* renamed from: a, reason: collision with root package name */
    public final int f13911a;

    public j() {
        this(-1);
    }

    @Override // c1.k
    public long a(k.c cVar) {
        if (e(cVar.f13920c)) {
            return -9223372036854775807L;
        }
        return Math.min((cVar.f13921d - 1) * 1000, 5000);
    }

    @Override // c1.k
    public k.b b(k.a aVar, k.c cVar) {
        if (!f(cVar.f13920c)) {
            return null;
        }
        if (aVar.a(1)) {
            return new k.b(1, 300000L);
        }
        if (aVar.a(2)) {
            return new k.b(2, 60000L);
        }
        return null;
    }

    @Override // c1.k
    public int d(int i7) {
        int i8 = this.f13911a;
        return i8 == -1 ? i7 == 7 ? 6 : 3 : i8;
    }

    public final boolean e(Throwable th) {
        while (th != null) {
            if (g(th)) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public boolean f(IOException iOException) {
        if (!(iOException instanceof s)) {
            return false;
        }
        int i7 = ((s) iOException).f3211o;
        return i7 == 403 || i7 == 404 || i7 == 410 || i7 == 416 || i7 == 500 || i7 == 503;
    }

    public final boolean g(Throwable th) {
        if ((th instanceof A) || (th instanceof FileNotFoundException) || (th instanceof G0.p) || (th instanceof m.h)) {
            return true;
        }
        return (th instanceof G0.g) && ((G0.g) th).f3136l == 2008;
    }

    public j(int i7) {
        this.f13911a = i7;
    }
}
