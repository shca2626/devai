package E;

import D.i;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    public final e f1870b;

    /* renamed from: c, reason: collision with root package name */
    public final b f1871c;

    /* renamed from: d, reason: collision with root package name */
    public d f1872d;

    /* renamed from: g, reason: collision with root package name */
    public D.i f1875g;

    /* renamed from: a, reason: collision with root package name */
    public HashSet f1869a = null;

    /* renamed from: e, reason: collision with root package name */
    public int f1873e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f1874f = -1;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1876a;

        static {
            int[] iArr = new int[b.values().length];
            f1876a = iArr;
            try {
                iArr[b.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1876a[b.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1876a[b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1876a[b.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1876a[b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1876a[b.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1876a[b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1876a[b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1876a[b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public enum b {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public d(e eVar, b bVar) {
        this.f1870b = eVar;
        this.f1871c = bVar;
    }

    public boolean a(d dVar, int i7, int i8, boolean z7) {
        if (dVar == null) {
            k();
            return true;
        }
        if (!z7 && !j(dVar)) {
            return false;
        }
        this.f1872d = dVar;
        if (dVar.f1869a == null) {
            dVar.f1869a = new HashSet();
        }
        this.f1872d.f1869a.add(this);
        if (i7 > 0) {
            this.f1873e = i7;
        } else {
            this.f1873e = 0;
        }
        this.f1874f = i8;
        return true;
    }

    public int b() {
        d dVar;
        if (this.f1870b.M() == 8) {
            return 0;
        }
        return (this.f1874f <= -1 || (dVar = this.f1872d) == null || dVar.f1870b.M() != 8) ? this.f1873e : this.f1874f;
    }

    public final d c() {
        switch (a.f1876a[this.f1871c.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f1870b.f1891D;
            case 3:
                return this.f1870b.f1889B;
            case 4:
                return this.f1870b.f1892E;
            case 5:
                return this.f1870b.f1890C;
            default:
                throw new AssertionError(this.f1871c.name());
        }
    }

    public e d() {
        return this.f1870b;
    }

    public D.i e() {
        return this.f1875g;
    }

    public d f() {
        return this.f1872d;
    }

    public b g() {
        return this.f1871c;
    }

    public boolean h() {
        HashSet hashSet = this.f1869a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((d) it.next()).c().i()) {
                return true;
            }
        }
        return false;
    }

    public boolean i() {
        return this.f1872d != null;
    }

    public boolean j(d dVar) {
        if (dVar == null) {
            return false;
        }
        b bVarG = dVar.g();
        b bVar = this.f1871c;
        if (bVarG == bVar) {
            return bVar != b.BASELINE || (dVar.d().Q() && d().Q());
        }
        switch (a.f1876a[bVar.ordinal()]) {
            case 1:
                return (bVarG == b.BASELINE || bVarG == b.CENTER_X || bVarG == b.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z7 = bVarG == b.LEFT || bVarG == b.RIGHT;
                return dVar.d() instanceof g ? z7 || bVarG == b.CENTER_X : z7;
            case 4:
            case 5:
                boolean z8 = bVarG == b.TOP || bVarG == b.BOTTOM;
                return dVar.d() instanceof g ? z8 || bVarG == b.CENTER_Y : z8;
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f1871c.name());
        }
    }

    public void k() {
        HashSet hashSet;
        d dVar = this.f1872d;
        if (dVar != null && (hashSet = dVar.f1869a) != null) {
            hashSet.remove(this);
        }
        this.f1872d = null;
        this.f1873e = 0;
        this.f1874f = -1;
    }

    public void l(D.c cVar) {
        D.i iVar = this.f1875g;
        if (iVar == null) {
            this.f1875g = new D.i(i.a.UNRESTRICTED, null);
        } else {
            iVar.d();
        }
    }

    public String toString() {
        return this.f1870b.p() + ":" + this.f1871c.toString();
    }
}
