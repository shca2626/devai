package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class a implements h.a {

    /* renamed from: a, reason: collision with root package name */
    public Y.e f13305a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f13306b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f13307c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0122a f13308d;

    /* renamed from: e, reason: collision with root package name */
    public Runnable f13309e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f13310f;

    /* renamed from: g, reason: collision with root package name */
    public final h f13311g;

    /* renamed from: h, reason: collision with root package name */
    public int f13312h;

    /* renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    public interface InterfaceC0122a {
        void a(int i7, int i8);

        void b(b bVar);

        void c(int i7, int i8, Object obj);

        void d(b bVar);

        RecyclerView.C e(int i7);

        void f(int i7, int i8);

        void g(int i7, int i8);

        void h(int i7, int i8);
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f13313a;

        /* renamed from: b, reason: collision with root package name */
        public int f13314b;

        /* renamed from: c, reason: collision with root package name */
        public Object f13315c;

        /* renamed from: d, reason: collision with root package name */
        public int f13316d;

        public b(int i7, int i8, int i9, Object obj) {
            this.f13313a = i7;
            this.f13314b = i8;
            this.f13316d = i9;
            this.f13315c = obj;
        }

        public String a() {
            int i7 = this.f13313a;
            return i7 != 1 ? i7 != 2 ? i7 != 4 ? i7 != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i7 = this.f13313a;
            if (i7 != bVar.f13313a) {
                return false;
            }
            if (i7 == 8 && Math.abs(this.f13316d - this.f13314b) == 1 && this.f13316d == bVar.f13314b && this.f13314b == bVar.f13316d) {
                return true;
            }
            if (this.f13316d != bVar.f13316d || this.f13314b != bVar.f13314b) {
                return false;
            }
            Object obj2 = this.f13315c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f13315c)) {
                    return false;
                }
            } else if (bVar.f13315c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f13313a * 31) + this.f13314b) * 31) + this.f13316d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f13314b + "c:" + this.f13316d + ",p:" + this.f13315c + "]";
        }
    }

    public a(InterfaceC0122a interfaceC0122a) {
        this(interfaceC0122a, false);
    }

    @Override // androidx.recyclerview.widget.h.a
    public void a(b bVar) {
        if (this.f13310f) {
            return;
        }
        bVar.f13315c = null;
        this.f13305a.a(bVar);
    }

    @Override // androidx.recyclerview.widget.h.a
    public b b(int i7, int i8, int i9, Object obj) {
        b bVar = (b) this.f13305a.b();
        if (bVar == null) {
            return new b(i7, i8, i9, obj);
        }
        bVar.f13313a = i7;
        bVar.f13314b = i8;
        bVar.f13316d = i9;
        bVar.f13315c = obj;
        return bVar;
    }

    public final void c(b bVar) {
        r(bVar);
    }

    public final void d(b bVar) {
        r(bVar);
    }

    public int e(int i7) {
        int size = this.f13306b.size();
        for (int i8 = 0; i8 < size; i8++) {
            b bVar = (b) this.f13306b.get(i8);
            int i9 = bVar.f13313a;
            if (i9 != 1) {
                if (i9 == 2) {
                    int i10 = bVar.f13314b;
                    if (i10 <= i7) {
                        int i11 = bVar.f13316d;
                        if (i10 + i11 > i7) {
                            return -1;
                        }
                        i7 -= i11;
                    } else {
                        continue;
                    }
                } else if (i9 == 8) {
                    int i12 = bVar.f13314b;
                    if (i12 == i7) {
                        i7 = bVar.f13316d;
                    } else {
                        if (i12 < i7) {
                            i7--;
                        }
                        if (bVar.f13316d <= i7) {
                            i7++;
                        }
                    }
                }
            } else if (bVar.f13314b <= i7) {
                i7 += bVar.f13316d;
            }
        }
        return i7;
    }

    public final void f(b bVar) {
        boolean z7;
        char c7;
        int i7 = bVar.f13314b;
        int i8 = bVar.f13316d + i7;
        char c8 = 65535;
        int i9 = i7;
        int i10 = 0;
        while (i9 < i8) {
            if (this.f13308d.e(i9) != null || h(i9)) {
                if (c8 == 0) {
                    k(b(2, i7, i10, null));
                    z7 = true;
                } else {
                    z7 = false;
                }
                c7 = 1;
            } else {
                if (c8 == 1) {
                    r(b(2, i7, i10, null));
                    z7 = true;
                } else {
                    z7 = false;
                }
                c7 = 0;
            }
            if (z7) {
                i9 -= i10;
                i8 -= i10;
                i10 = 1;
            } else {
                i10++;
            }
            i9++;
            c8 = c7;
        }
        if (i10 != bVar.f13316d) {
            a(bVar);
            bVar = b(2, i7, i10, null);
        }
        if (c8 == 0) {
            k(bVar);
        } else {
            r(bVar);
        }
    }

    public final void g(b bVar) {
        int i7 = bVar.f13314b;
        int i8 = bVar.f13316d + i7;
        int i9 = 0;
        boolean z7 = -1;
        int i10 = i7;
        while (i7 < i8) {
            if (this.f13308d.e(i7) != null || h(i7)) {
                if (!z7) {
                    k(b(4, i10, i9, bVar.f13315c));
                    i10 = i7;
                    i9 = 0;
                }
                z7 = true;
            } else {
                if (z7) {
                    r(b(4, i10, i9, bVar.f13315c));
                    i10 = i7;
                    i9 = 0;
                }
                z7 = false;
            }
            i9++;
            i7++;
        }
        if (i9 != bVar.f13316d) {
            Object obj = bVar.f13315c;
            a(bVar);
            bVar = b(4, i10, i9, obj);
        }
        if (z7) {
            r(bVar);
        } else {
            k(bVar);
        }
    }

    public final boolean h(int i7) {
        int size = this.f13307c.size();
        for (int i8 = 0; i8 < size; i8++) {
            b bVar = (b) this.f13307c.get(i8);
            int i9 = bVar.f13313a;
            if (i9 == 8) {
                if (n(bVar.f13316d, i8 + 1) == i7) {
                    return true;
                }
            } else if (i9 == 1) {
                int i10 = bVar.f13314b;
                int i11 = bVar.f13316d + i10;
                while (i10 < i11) {
                    if (n(i10, i8 + 1) == i7) {
                        return true;
                    }
                    i10++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public void i() {
        int size = this.f13307c.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.f13308d.d((b) this.f13307c.get(i7));
        }
        t(this.f13307c);
        this.f13312h = 0;
    }

    public void j() {
        i();
        int size = this.f13306b.size();
        for (int i7 = 0; i7 < size; i7++) {
            b bVar = (b) this.f13306b.get(i7);
            int i8 = bVar.f13313a;
            if (i8 == 1) {
                this.f13308d.d(bVar);
                this.f13308d.g(bVar.f13314b, bVar.f13316d);
            } else if (i8 == 2) {
                this.f13308d.d(bVar);
                this.f13308d.h(bVar.f13314b, bVar.f13316d);
            } else if (i8 == 4) {
                this.f13308d.d(bVar);
                this.f13308d.c(bVar.f13314b, bVar.f13316d, bVar.f13315c);
            } else if (i8 == 8) {
                this.f13308d.d(bVar);
                this.f13308d.a(bVar.f13314b, bVar.f13316d);
            }
            Runnable runnable = this.f13309e;
            if (runnable != null) {
                runnable.run();
            }
        }
        t(this.f13306b);
        this.f13312h = 0;
    }

    public final void k(b bVar) {
        int i7;
        int i8 = bVar.f13313a;
        if (i8 == 1 || i8 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iV = v(bVar.f13314b, i8);
        int i9 = bVar.f13314b;
        int i10 = bVar.f13313a;
        if (i10 == 2) {
            i7 = 0;
        } else {
            if (i10 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i7 = 1;
        }
        int i11 = 1;
        for (int i12 = 1; i12 < bVar.f13316d; i12++) {
            int iV2 = v(bVar.f13314b + (i7 * i12), bVar.f13313a);
            int i13 = bVar.f13313a;
            if (i13 == 2 ? iV2 != iV : !(i13 == 4 && iV2 == iV + 1)) {
                b bVarB = b(i13, iV, i11, bVar.f13315c);
                l(bVarB, i9);
                a(bVarB);
                if (bVar.f13313a == 4) {
                    i9 += i11;
                }
                i11 = 1;
                iV = iV2;
            } else {
                i11++;
            }
        }
        Object obj = bVar.f13315c;
        a(bVar);
        if (i11 > 0) {
            b bVarB2 = b(bVar.f13313a, iV, i11, obj);
            l(bVarB2, i9);
            a(bVarB2);
        }
    }

    public void l(b bVar, int i7) {
        this.f13308d.b(bVar);
        int i8 = bVar.f13313a;
        if (i8 == 2) {
            this.f13308d.h(i7, bVar.f13316d);
        } else {
            if (i8 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f13308d.c(i7, bVar.f13316d, bVar.f13315c);
        }
    }

    public int m(int i7) {
        return n(i7, 0);
    }

    public int n(int i7, int i8) {
        int size = this.f13307c.size();
        while (i8 < size) {
            b bVar = (b) this.f13307c.get(i8);
            int i9 = bVar.f13313a;
            if (i9 == 8) {
                int i10 = bVar.f13314b;
                if (i10 == i7) {
                    i7 = bVar.f13316d;
                } else {
                    if (i10 < i7) {
                        i7--;
                    }
                    if (bVar.f13316d <= i7) {
                        i7++;
                    }
                }
            } else {
                int i11 = bVar.f13314b;
                if (i11 > i7) {
                    continue;
                } else if (i9 == 2) {
                    int i12 = bVar.f13316d;
                    if (i7 < i11 + i12) {
                        return -1;
                    }
                    i7 -= i12;
                } else if (i9 == 1) {
                    i7 += bVar.f13316d;
                }
            }
            i8++;
        }
        return i7;
    }

    public boolean o(int i7) {
        return (i7 & this.f13312h) != 0;
    }

    public boolean p() {
        return this.f13306b.size() > 0;
    }

    public boolean q() {
        return (this.f13307c.isEmpty() || this.f13306b.isEmpty()) ? false : true;
    }

    public final void r(b bVar) {
        this.f13307c.add(bVar);
        int i7 = bVar.f13313a;
        if (i7 == 1) {
            this.f13308d.g(bVar.f13314b, bVar.f13316d);
            return;
        }
        if (i7 == 2) {
            this.f13308d.f(bVar.f13314b, bVar.f13316d);
            return;
        }
        if (i7 == 4) {
            this.f13308d.c(bVar.f13314b, bVar.f13316d, bVar.f13315c);
        } else {
            if (i7 == 8) {
                this.f13308d.a(bVar.f13314b, bVar.f13316d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    public void s() {
        this.f13311g.b(this.f13306b);
        int size = this.f13306b.size();
        for (int i7 = 0; i7 < size; i7++) {
            b bVar = (b) this.f13306b.get(i7);
            int i8 = bVar.f13313a;
            if (i8 == 1) {
                c(bVar);
            } else if (i8 == 2) {
                f(bVar);
            } else if (i8 == 4) {
                g(bVar);
            } else if (i8 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f13309e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f13306b.clear();
    }

    public void t(List list) {
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            a((b) list.get(i7));
        }
        list.clear();
    }

    public void u() {
        t(this.f13306b);
        t(this.f13307c);
        this.f13312h = 0;
    }

    public final int v(int i7, int i8) {
        int i9;
        int i10;
        for (int size = this.f13307c.size() - 1; size >= 0; size--) {
            b bVar = (b) this.f13307c.get(size);
            int i11 = bVar.f13313a;
            if (i11 == 8) {
                int i12 = bVar.f13314b;
                int i13 = bVar.f13316d;
                if (i12 < i13) {
                    i10 = i12;
                    i9 = i13;
                } else {
                    i9 = i12;
                    i10 = i13;
                }
                if (i7 < i10 || i7 > i9) {
                    if (i7 < i12) {
                        if (i8 == 1) {
                            bVar.f13314b = i12 + 1;
                            bVar.f13316d = i13 + 1;
                        } else if (i8 == 2) {
                            bVar.f13314b = i12 - 1;
                            bVar.f13316d = i13 - 1;
                        }
                    }
                } else if (i10 == i12) {
                    if (i8 == 1) {
                        bVar.f13316d = i13 + 1;
                    } else if (i8 == 2) {
                        bVar.f13316d = i13 - 1;
                    }
                    i7++;
                } else {
                    if (i8 == 1) {
                        bVar.f13314b = i12 + 1;
                    } else if (i8 == 2) {
                        bVar.f13314b = i12 - 1;
                    }
                    i7--;
                }
            } else {
                int i14 = bVar.f13314b;
                if (i14 <= i7) {
                    if (i11 == 1) {
                        i7 -= bVar.f13316d;
                    } else if (i11 == 2) {
                        i7 += bVar.f13316d;
                    }
                } else if (i8 == 1) {
                    bVar.f13314b = i14 + 1;
                } else if (i8 == 2) {
                    bVar.f13314b = i14 - 1;
                }
            }
        }
        for (int size2 = this.f13307c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = (b) this.f13307c.get(size2);
            if (bVar2.f13313a == 8) {
                int i15 = bVar2.f13316d;
                if (i15 == bVar2.f13314b || i15 < 0) {
                    this.f13307c.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.f13316d <= 0) {
                this.f13307c.remove(size2);
                a(bVar2);
            }
        }
        return i7;
    }

    public a(InterfaceC0122a interfaceC0122a, boolean z7) {
        this.f13305a = new Y.f(30);
        this.f13306b = new ArrayList();
        this.f13307c = new ArrayList();
        this.f13312h = 0;
        this.f13308d = interfaceC0122a;
        this.f13310f = z7;
        this.f13311g = new h(this);
    }
}
