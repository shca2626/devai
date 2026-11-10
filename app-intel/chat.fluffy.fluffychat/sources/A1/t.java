package A1;

import E0.E;
import g1.M;
import java.util.ArrayList;
import java.util.List;
import v1.C1677c;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: d, reason: collision with root package name */
    public static final j3.s f201d = j3.s.d(':');

    /* renamed from: e, reason: collision with root package name */
    public static final j3.s f202e = j3.s.d('*');

    /* renamed from: a, reason: collision with root package name */
    public final List f203a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public int f204b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f205c;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f206a;

        /* renamed from: b, reason: collision with root package name */
        public final long f207b;

        /* renamed from: c, reason: collision with root package name */
        public final int f208c;

        public a(int i7, long j7, int i8) {
            this.f206a = i7;
            this.f207b = j7;
            this.f208c = i8;
        }
    }

    public static int b(String str) throws B0.A {
        str.getClass();
        switch (str) {
            case "SlowMotion_Data":
                return 2192;
            case "Super_SlowMotion_Edit_Data":
                return 2819;
            case "Super_SlowMotion_Data":
                return 2816;
            case "Super_SlowMotion_Deflickering_On":
                return 2820;
            case "Super_SlowMotion_BGM":
                return 2817;
            default:
                throw B0.A.a("Invalid SEF name", null);
        }
    }

    public static C1677c f(E e7, int i7) throws B0.A {
        ArrayList arrayList = new ArrayList();
        List listF = f202e.f(e7.N(i7));
        for (int i8 = 0; i8 < listF.size(); i8++) {
            List listF2 = f201d.f((CharSequence) listF.get(i8));
            if (listF2.size() != 3) {
                throw B0.A.a(null, null);
            }
            try {
                arrayList.add(new C1677c.a(Long.parseLong((String) listF2.get(0)), Long.parseLong((String) listF2.get(1)), 1 << (Integer.parseInt((String) listF2.get(2)) - 1)));
            } catch (NumberFormatException e8) {
                throw B0.A.a(null, e8);
            }
        }
        return new C1677c(arrayList);
    }

    public final void a(g1.r rVar, M m7) {
        E e7 = new E(8);
        rVar.readFully(e7.f(), 0, 8);
        this.f205c = e7.D() + 8;
        if (e7.z() != 1397048916) {
            m7.f15965a = 0L;
        } else {
            m7.f15965a = rVar.getPosition() - (this.f205c - 12);
            this.f204b = 2;
        }
    }

    public int c(g1.r rVar, M m7, List list) throws B0.A {
        int i7 = this.f204b;
        long j7 = 0;
        if (i7 == 0) {
            long length = rVar.getLength();
            if (length != -1 && length >= 8) {
                j7 = length - 8;
            }
            m7.f15965a = j7;
            this.f204b = 1;
        } else if (i7 == 1) {
            a(rVar, m7);
        } else if (i7 == 2) {
            d(rVar, m7);
        } else {
            if (i7 != 3) {
                throw new IllegalStateException();
            }
            e(rVar, list);
            m7.f15965a = 0L;
        }
        return 1;
    }

    public final void d(g1.r rVar, M m7) {
        long length = rVar.getLength();
        int i7 = this.f205c - 20;
        E e7 = new E(i7);
        rVar.readFully(e7.f(), 0, i7);
        for (int i8 = 0; i8 < i7 / 12; i8++) {
            e7.g0(2);
            short sF = e7.F();
            if (sF == 2192 || sF == 2816 || sF == 2817 || sF == 2819 || sF == 2820) {
                this.f203a.add(new a(sF, (length - this.f205c) - e7.D(), e7.D()));
            } else {
                e7.g0(8);
            }
        }
        if (this.f203a.isEmpty()) {
            m7.f15965a = 0L;
        } else {
            this.f204b = 3;
            m7.f15965a = ((a) this.f203a.get(0)).f207b;
        }
    }

    public final void e(g1.r rVar, List list) throws B0.A {
        long position = rVar.getPosition();
        int length = (int) ((rVar.getLength() - rVar.getPosition()) - this.f205c);
        E e7 = new E(length);
        rVar.readFully(e7.f(), 0, length);
        for (int i7 = 0; i7 < this.f203a.size(); i7++) {
            a aVar = (a) this.f203a.get(i7);
            e7.f0((int) (aVar.f207b - position));
            e7.g0(4);
            int iD = e7.D();
            int iB = b(e7.N(iD));
            int i8 = aVar.f208c - (iD + 8);
            if (iB == 2192) {
                list.add(f(e7, i8));
            } else if (iB != 2816 && iB != 2817 && iB != 2819 && iB != 2820) {
                throw new IllegalStateException();
            }
        }
    }

    public void g() {
        this.f203a.clear();
        this.f204b = 0;
    }
}
