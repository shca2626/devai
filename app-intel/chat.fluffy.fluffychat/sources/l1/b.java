package l1;

import g1.AbstractC1075e;
import g1.AbstractC1092w;
import g1.C1095z;
import g1.r;
import java.util.Objects;

/* loaded from: classes.dex */
public final class b extends AbstractC1075e {

    /* renamed from: l1.b$b, reason: collision with other inner class name */
    public static final class C0219b implements AbstractC1075e.f {

        /* renamed from: a, reason: collision with root package name */
        public final C1095z f19540a;

        /* renamed from: b, reason: collision with root package name */
        public final int f19541b;

        /* renamed from: c, reason: collision with root package name */
        public final AbstractC1092w.a f19542c;

        @Override // g1.AbstractC1075e.f
        public AbstractC1075e.C0173e a(r rVar, long j7) {
            long position = rVar.getPosition();
            long jC = c(rVar);
            long jI = rVar.i();
            rVar.k(Math.max(6, this.f19540a.f16155c));
            long jC2 = c(rVar);
            return (jC > j7 || jC2 <= j7) ? jC2 <= j7 ? AbstractC1075e.C0173e.f(jC2, rVar.i()) : AbstractC1075e.C0173e.d(jC, position) : AbstractC1075e.C0173e.e(jI);
        }

        public final long c(r rVar) {
            while (rVar.i() < rVar.getLength() - 6 && !AbstractC1092w.i(rVar, this.f19540a, this.f19541b, this.f19542c)) {
                rVar.k(1);
            }
            if (rVar.i() < rVar.getLength() - 6) {
                return this.f19542c.f16149a;
            }
            rVar.k((int) (rVar.getLength() - rVar.i()));
            return this.f19540a.f16162j;
        }

        public C0219b(C1095z c1095z, int i7) {
            this.f19540a = c1095z;
            this.f19541b = i7;
            this.f19542c = new AbstractC1092w.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(final C1095z c1095z, int i7, long j7, long j8) {
        super(new AbstractC1075e.d() { // from class: l1.a
            @Override // g1.AbstractC1075e.d
            public final long a(long j9) {
                return c1095z.i(j9);
            }
        }, new C0219b(c1095z, i7), c1095z.f(), 0L, c1095z.f16162j, j7, j8, c1095z.d(), Math.max(6, c1095z.f16155c));
        Objects.requireNonNull(c1095z);
    }
}
