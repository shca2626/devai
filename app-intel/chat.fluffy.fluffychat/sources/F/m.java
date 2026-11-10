package F;

import E.d;
import E.e;

/* loaded from: classes.dex */
public abstract class m implements d {

    /* renamed from: a, reason: collision with root package name */
    public int f2445a;

    /* renamed from: b, reason: collision with root package name */
    public E.e f2446b;

    /* renamed from: c, reason: collision with root package name */
    public k f2447c;

    /* renamed from: d, reason: collision with root package name */
    public e.b f2448d;

    /* renamed from: e, reason: collision with root package name */
    public g f2449e = new g(this);

    /* renamed from: f, reason: collision with root package name */
    public int f2450f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2451g = false;

    /* renamed from: h, reason: collision with root package name */
    public f f2452h = new f(this);

    /* renamed from: i, reason: collision with root package name */
    public f f2453i = new f(this);

    /* renamed from: j, reason: collision with root package name */
    public b f2454j = b.NONE;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2455a;

        static {
            int[] iArr = new int[d.b.values().length];
            f2455a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2455a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2455a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2455a[d.b.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2455a[d.b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum b {
        NONE,
        START,
        END,
        CENTER
    }

    public m(E.e eVar) {
        this.f2446b = eVar;
    }

    @Override // F.d
    public abstract void a(d dVar);

    public final void b(f fVar, f fVar2, int i7) {
        fVar.f2421l.add(fVar2);
        fVar.f2415f = i7;
        fVar2.f2420k.add(fVar);
    }

    public final void c(f fVar, f fVar2, int i7, g gVar) {
        fVar.f2421l.add(fVar2);
        fVar.f2421l.add(this.f2449e);
        fVar.f2417h = i7;
        fVar.f2418i = gVar;
        fVar2.f2420k.add(fVar);
        gVar.f2420k.add(fVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i7, int i8) {
        if (i8 == 0) {
            E.e eVar = this.f2446b;
            int i9 = eVar.f1944p;
            int iMax = Math.max(eVar.f1942o, i7);
            if (i9 > 0) {
                iMax = Math.min(i9, i7);
            }
            if (iMax != i7) {
                return iMax;
            }
        } else {
            E.e eVar2 = this.f2446b;
            int i10 = eVar2.f1950s;
            int iMax2 = Math.max(eVar2.f1948r, i7);
            if (i10 > 0) {
                iMax2 = Math.min(i10, i7);
            }
            if (iMax2 != i7) {
                return iMax2;
            }
        }
        return i7;
    }

    public final f h(E.d dVar) {
        E.d dVar2 = dVar.f1872d;
        if (dVar2 == null) {
            return null;
        }
        E.e eVar = dVar2.f1870b;
        int i7 = a.f2455a[dVar2.f1871c.ordinal()];
        if (i7 == 1) {
            return eVar.f1922e.f2452h;
        }
        if (i7 == 2) {
            return eVar.f1922e.f2453i;
        }
        if (i7 == 3) {
            return eVar.f1924f.f2452h;
        }
        if (i7 == 4) {
            return eVar.f1924f.f2442k;
        }
        if (i7 != 5) {
            return null;
        }
        return eVar.f1924f.f2453i;
    }

    public final f i(E.d dVar, int i7) {
        E.d dVar2 = dVar.f1872d;
        if (dVar2 == null) {
            return null;
        }
        E.e eVar = dVar2.f1870b;
        m mVar = i7 == 0 ? eVar.f1922e : eVar.f1924f;
        int i8 = a.f2455a[dVar2.f1871c.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 5) {
                        return null;
                    }
                }
            }
            return mVar.f2453i;
        }
        return mVar.f2452h;
    }

    public long j() {
        if (this.f2449e.f2419j) {
            return r0.f2416g;
        }
        return 0L;
    }

    public boolean k() {
        return this.f2451g;
    }

    public final void l(int i7, int i8) {
        int i9 = this.f2445a;
        if (i9 == 0) {
            this.f2449e.d(g(i8, i7));
            return;
        }
        if (i9 == 1) {
            this.f2449e.d(Math.min(g(this.f2449e.f2431m, i7), i8));
            return;
        }
        if (i9 == 2) {
            E.e eVarE = this.f2446b.E();
            if (eVarE != null) {
                if ((i7 == 0 ? eVarE.f1922e : eVarE.f1924f).f2449e.f2419j) {
                    E.e eVar = this.f2446b;
                    this.f2449e.d(g((int) ((r9.f2416g * (i7 == 0 ? eVar.f1946q : eVar.f1952t)) + 0.5f), i7));
                    return;
                }
                return;
            }
            return;
        }
        if (i9 != 3) {
            return;
        }
        E.e eVar2 = this.f2446b;
        m mVar = eVar2.f1922e;
        e.b bVar = mVar.f2448d;
        e.b bVar2 = e.b.MATCH_CONSTRAINT;
        if (bVar == bVar2 && mVar.f2445a == 3) {
            l lVar = eVar2.f1924f;
            if (lVar.f2448d == bVar2 && lVar.f2445a == 3) {
                return;
            }
        }
        if (i7 == 0) {
            mVar = eVar2.f1924f;
        }
        if (mVar.f2449e.f2419j) {
            float fR = eVar2.r();
            this.f2449e.d(i7 == 1 ? (int) ((mVar.f2449e.f2416g / fR) + 0.5f) : (int) ((fR * mVar.f2449e.f2416g) + 0.5f));
        }
    }

    public abstract boolean m();

    public void n(d dVar, E.d dVar2, E.d dVar3, int i7) {
        f fVarH = h(dVar2);
        f fVarH2 = h(dVar3);
        if (fVarH.f2419j && fVarH2.f2419j) {
            int iB = fVarH.f2416g + dVar2.b();
            int iB2 = fVarH2.f2416g - dVar3.b();
            int i8 = iB2 - iB;
            if (!this.f2449e.f2419j && this.f2448d == e.b.MATCH_CONSTRAINT) {
                l(i7, i8);
            }
            g gVar = this.f2449e;
            if (gVar.f2419j) {
                if (gVar.f2416g == i8) {
                    this.f2452h.d(iB);
                    this.f2453i.d(iB2);
                    return;
                }
                E.e eVar = this.f2446b;
                float fU = i7 == 0 ? eVar.u() : eVar.I();
                if (fVarH == fVarH2) {
                    iB = fVarH.f2416g;
                    iB2 = fVarH2.f2416g;
                    fU = 0.5f;
                }
                this.f2452h.d((int) (iB + 0.5f + (((iB2 - iB) - this.f2449e.f2416g) * fU)));
                this.f2453i.d(this.f2452h.f2416g + this.f2449e.f2416g);
            }
        }
    }

    public void o(d dVar) {
    }

    public void p(d dVar) {
    }
}
