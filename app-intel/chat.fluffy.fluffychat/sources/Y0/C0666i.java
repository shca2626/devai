package Y0;

import I0.C0362d1;
import java.util.List;
import k3.AbstractC1278v;

/* renamed from: Y0.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0666i implements f0 {

    /* renamed from: l, reason: collision with root package name */
    public final AbstractC1278v f9692l;

    /* renamed from: m, reason: collision with root package name */
    public long f9693m;

    /* renamed from: Y0.i$a */
    public static final class a implements f0 {

        /* renamed from: l, reason: collision with root package name */
        public final f0 f9694l;

        /* renamed from: m, reason: collision with root package name */
        public final AbstractC1278v f9695m;

        public a(f0 f0Var, List list) {
            this.f9694l = f0Var;
            this.f9695m = AbstractC1278v.r(list);
        }

        public AbstractC1278v a() {
            return this.f9695m;
        }

        @Override // Y0.f0
        public boolean b(C0362d1 c0362d1) {
            return this.f9694l.b(c0362d1);
        }

        @Override // Y0.f0
        public long c() {
            return this.f9694l.c();
        }

        @Override // Y0.f0
        public boolean d() {
            return this.f9694l.d();
        }

        @Override // Y0.f0
        public long g() {
            return this.f9694l.g();
        }

        @Override // Y0.f0
        public void h(long j7) {
            this.f9694l.h(j7);
        }
    }

    public C0666i(List list, List list2) {
        AbstractC1278v.a aVarO = AbstractC1278v.o();
        j3.o.d(list.size() == list2.size());
        for (int i7 = 0; i7 < list.size(); i7++) {
            aVarO.a(new a((f0) list.get(i7), (List) list2.get(i7)));
        }
        this.f9692l = aVarO.k();
        this.f9693m = -9223372036854775807L;
    }

    @Override // Y0.f0
    public boolean b(C0362d1 c0362d1) {
        boolean zB;
        boolean z7 = false;
        do {
            long jC = c();
            if (jC == Long.MIN_VALUE) {
                return z7;
            }
            zB = false;
            for (int i7 = 0; i7 < this.f9692l.size(); i7++) {
                long jC2 = ((a) this.f9692l.get(i7)).c();
                boolean z8 = jC2 != Long.MIN_VALUE && jC2 <= c0362d1.f3950a;
                if (jC2 == jC || z8) {
                    zB |= ((a) this.f9692l.get(i7)).b(c0362d1);
                }
            }
            z7 |= zB;
        } while (zB);
        return z7;
    }

    @Override // Y0.f0
    public long c() {
        long jMin = Long.MAX_VALUE;
        for (int i7 = 0; i7 < this.f9692l.size(); i7++) {
            long jC = ((a) this.f9692l.get(i7)).c();
            if (jC != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jC);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // Y0.f0
    public boolean d() {
        for (int i7 = 0; i7 < this.f9692l.size(); i7++) {
            if (((a) this.f9692l.get(i7)).d()) {
                return true;
            }
        }
        return false;
    }

    @Override // Y0.f0
    public long g() {
        long jMin = Long.MAX_VALUE;
        long jMin2 = Long.MAX_VALUE;
        for (int i7 = 0; i7 < this.f9692l.size(); i7++) {
            a aVar = (a) this.f9692l.get(i7);
            long jG = aVar.g();
            if ((aVar.a().contains(1) || aVar.a().contains(2) || aVar.a().contains(4)) && jG != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jG);
            }
            if (jG != Long.MIN_VALUE) {
                jMin2 = Math.min(jMin2, jG);
            }
        }
        if (jMin != Long.MAX_VALUE) {
            this.f9693m = jMin;
            return jMin;
        }
        if (jMin2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        long j7 = this.f9693m;
        return j7 != -9223372036854775807L ? j7 : jMin2;
    }

    @Override // Y0.f0
    public void h(long j7) {
        for (int i7 = 0; i7 < this.f9692l.size(); i7++) {
            ((a) this.f9692l.get(i7)).h(j7);
        }
    }
}
