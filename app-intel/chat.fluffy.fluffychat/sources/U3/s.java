package U3;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonPointer;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final J3.a f8443a;

    /* renamed from: b, reason: collision with root package name */
    public final m f8444b = new m();

    /* renamed from: c, reason: collision with root package name */
    public final StringBuilder f8445c = new StringBuilder();

    public s(J3.a aVar) {
        this.f8443a = aVar;
    }

    public static int g(J3.a aVar, int i7, int i8) {
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            if (aVar.c(i7 + i10)) {
                i9 |= 1 << ((i8 - i10) - 1);
            }
        }
        return i9;
    }

    public String a(StringBuilder sb, int i7) throws D3.j, D3.f {
        String str = null;
        while (true) {
            o oVarC = c(i7, str);
            String strA = r.a(oVarC.b());
            if (strA != null) {
                sb.append(strA);
            }
            String strValueOf = oVarC.d() ? String.valueOf(oVarC.c()) : null;
            if (i7 == oVarC.a()) {
                return sb.toString();
            }
            i7 = oVarC.a();
            str = strValueOf;
        }
    }

    public final n b(int i7) {
        char c7;
        int iF = f(i7, 5);
        if (iF == 15) {
            return new n(i7 + 5, '$');
        }
        if (iF >= 5 && iF < 15) {
            return new n(i7 + 5, (char) (iF + 43));
        }
        int iF2 = f(i7, 6);
        if (iF2 >= 32 && iF2 < 58) {
            return new n(i7 + 6, (char) (iF2 + 33));
        }
        switch (iF2) {
            case 58:
                c7 = '*';
                break;
            case 59:
                c7 = ',';
                break;
            case 60:
                c7 = '-';
                break;
            case 61:
                c7 = '.';
                break;
            case 62:
                c7 = JsonPointer.SEPARATOR;
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: " + iF2);
        }
        return new n(i7 + 6, c7);
    }

    public o c(int i7, String str) throws D3.f {
        this.f8445c.setLength(0);
        if (str != null) {
            this.f8445c.append(str);
        }
        this.f8444b.h(i7);
        o oVarO = o();
        return (oVarO == null || !oVarO.d()) ? new o(this.f8444b.a(), this.f8445c.toString()) : new o(this.f8444b.a(), this.f8445c.toString(), oVarO.c());
    }

    public final n d(int i7) throws D3.f {
        int iF = f(i7, 5);
        if (iF == 15) {
            return new n(i7 + 5, '$');
        }
        char c7 = '+';
        if (iF >= 5 && iF < 15) {
            return new n(i7 + 5, (char) (iF + 43));
        }
        int iF2 = f(i7, 7);
        if (iF2 >= 64 && iF2 < 90) {
            return new n(i7 + 7, (char) (iF2 + 1));
        }
        if (iF2 >= 90 && iF2 < 116) {
            return new n(i7 + 7, (char) (iF2 + 7));
        }
        switch (f(i7, 8)) {
            case 232:
                c7 = '!';
                break;
            case 233:
                c7 = JsonFactory.DEFAULT_QUOTE_CHAR;
                break;
            case 234:
                c7 = '%';
                break;
            case 235:
                c7 = '&';
                break;
            case 236:
                c7 = '\'';
                break;
            case 237:
                c7 = '(';
                break;
            case 238:
                c7 = ')';
                break;
            case 239:
                c7 = '*';
                break;
            case 240:
                break;
            case 241:
                c7 = ',';
                break;
            case 242:
                c7 = '-';
                break;
            case 243:
                c7 = '.';
                break;
            case 244:
                c7 = JsonPointer.SEPARATOR;
                break;
            case 245:
                c7 = ':';
                break;
            case 246:
                c7 = ';';
                break;
            case 247:
                c7 = '<';
                break;
            case 248:
                c7 = '=';
                break;
            case 249:
                c7 = '>';
                break;
            case 250:
                c7 = '?';
                break;
            case 251:
                c7 = '_';
                break;
            case 252:
                c7 = ' ';
                break;
            default:
                throw D3.f.a();
        }
        return new n(i7 + 8, c7);
    }

    public final p e(int i7) {
        int i8 = i7 + 7;
        if (i8 > this.f8443a.k()) {
            int iF = f(i7, 4);
            return iF == 0 ? new p(this.f8443a.k(), 10, 10) : new p(this.f8443a.k(), iF - 1, 10);
        }
        int iF2 = f(i7, 7) - 8;
        return new p(i8, iF2 / 11, iF2 % 11);
    }

    public int f(int i7, int i8) {
        return g(this.f8443a, i7, i8);
    }

    public final boolean h(int i7) {
        int i8 = i7 + 3;
        if (i8 > this.f8443a.k()) {
            return false;
        }
        while (i7 < i8) {
            if (this.f8443a.c(i7)) {
                return false;
            }
            i7++;
        }
        return true;
    }

    public final boolean i(int i7) {
        int i8;
        if (i7 + 1 > this.f8443a.k()) {
            return false;
        }
        for (int i9 = 0; i9 < 5 && (i8 = i9 + i7) < this.f8443a.k(); i9++) {
            if (i9 == 2) {
                if (!this.f8443a.c(i7 + 2)) {
                    return false;
                }
            } else if (this.f8443a.c(i8)) {
                return false;
            }
        }
        return true;
    }

    public final boolean j(int i7) {
        int i8;
        if (i7 + 1 > this.f8443a.k()) {
            return false;
        }
        for (int i9 = 0; i9 < 4 && (i8 = i9 + i7) < this.f8443a.k(); i9++) {
            if (this.f8443a.c(i8)) {
                return false;
            }
        }
        return true;
    }

    public final boolean k(int i7) {
        int iF;
        if (i7 + 5 > this.f8443a.k()) {
            return false;
        }
        int iF2 = f(i7, 5);
        if (iF2 < 5 || iF2 >= 16) {
            return i7 + 6 <= this.f8443a.k() && (iF = f(i7, 6)) >= 16 && iF < 63;
        }
        return true;
    }

    public final boolean l(int i7) {
        int iF;
        if (i7 + 5 > this.f8443a.k()) {
            return false;
        }
        int iF2 = f(i7, 5);
        if (iF2 >= 5 && iF2 < 16) {
            return true;
        }
        if (i7 + 7 > this.f8443a.k()) {
            return false;
        }
        int iF3 = f(i7, 7);
        if (iF3 < 64 || iF3 >= 116) {
            return i7 + 8 <= this.f8443a.k() && (iF = f(i7, 8)) >= 232 && iF < 253;
        }
        return true;
    }

    public final boolean m(int i7) {
        if (i7 + 7 > this.f8443a.k()) {
            return i7 + 4 <= this.f8443a.k();
        }
        int i8 = i7;
        while (true) {
            int i9 = i7 + 3;
            if (i8 >= i9) {
                return this.f8443a.c(i9);
            }
            if (this.f8443a.c(i8)) {
                return true;
            }
            i8++;
        }
    }

    public final l n() {
        while (k(this.f8444b.a())) {
            n nVarB = b(this.f8444b.a());
            this.f8444b.h(nVarB.a());
            if (nVarB.c()) {
                return new l(new o(this.f8444b.a(), this.f8445c.toString()), true);
            }
            this.f8445c.append(nVarB.b());
        }
        if (h(this.f8444b.a())) {
            this.f8444b.b(3);
            this.f8444b.g();
        } else if (i(this.f8444b.a())) {
            if (this.f8444b.a() + 5 < this.f8443a.k()) {
                this.f8444b.b(5);
            } else {
                this.f8444b.h(this.f8443a.k());
            }
            this.f8444b.f();
        }
        return new l();
    }

    public final o o() throws D3.f {
        l lVarQ;
        boolean zB;
        do {
            int iA = this.f8444b.a();
            if (this.f8444b.c()) {
                lVarQ = n();
                zB = lVarQ.b();
            } else if (this.f8444b.d()) {
                lVarQ = p();
                zB = lVarQ.b();
            } else {
                lVarQ = q();
                zB = lVarQ.b();
            }
            if (iA == this.f8444b.a() && !zB) {
                break;
            }
        } while (!zB);
        return lVarQ.a();
    }

    public final l p() throws D3.f {
        while (l(this.f8444b.a())) {
            n nVarD = d(this.f8444b.a());
            this.f8444b.h(nVarD.a());
            if (nVarD.c()) {
                return new l(new o(this.f8444b.a(), this.f8445c.toString()), true);
            }
            this.f8445c.append(nVarD.b());
        }
        if (h(this.f8444b.a())) {
            this.f8444b.b(3);
            this.f8444b.g();
        } else if (i(this.f8444b.a())) {
            if (this.f8444b.a() + 5 < this.f8443a.k()) {
                this.f8444b.b(5);
            } else {
                this.f8444b.h(this.f8443a.k());
            }
            this.f8444b.e();
        }
        return new l();
    }

    public final l q() {
        while (m(this.f8444b.a())) {
            p pVarE = e(this.f8444b.a());
            this.f8444b.h(pVarE.a());
            if (pVarE.d()) {
                return new l(pVarE.e() ? new o(this.f8444b.a(), this.f8445c.toString()) : new o(this.f8444b.a(), this.f8445c.toString(), pVarE.c()), true);
            }
            this.f8445c.append(pVarE.b());
            if (pVarE.e()) {
                return new l(new o(this.f8444b.a(), this.f8445c.toString()), true);
            }
            this.f8445c.append(pVarE.c());
        }
        if (j(this.f8444b.a())) {
            this.f8444b.e();
            this.f8444b.b(4);
        }
        return new l();
    }
}
