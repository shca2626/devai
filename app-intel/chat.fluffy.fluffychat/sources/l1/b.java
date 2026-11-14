package l1;

import g1.AbstractC1076e;
import g1.AbstractC1093w;
import g1.C1096z;
import g1.r;
import java.util.Objects;

/* loaded from: classes.dex */
public final class b extends AbstractC1076e {

    /* renamed from: l1.b$b, reason: collision with other inner class name */
    public static final class C0219b implements AbstractC1076e.f {

        /* renamed from: a, reason: collision with root package name */
        public final C1096z f19539a;

        /* renamed from: b, reason: collision with root package name */
        public final int f19540b;

        /* renamed from: c, reason: collision with root package name */
        public final AbstractC1093w.a f19541c;

        @Override // g1.AbstractC1076e.f
        public AbstractC1076e.C0173e a(r rVar, long j7) {
            long position = rVar.getPosition();
            long jC = c(rVar);
            long jI = rVar.i();
            rVar.k(Math.max(6, this.f19539a.f16155c));
            long jC2 = c(rVar);
            return (jC > j7 || jC2 <= j7) ? jC2 <= j7 ? AbstractC1076e.C0173e.f(jC2, rVar.i()) : AbstractC1076e.C0173e.d(jC, position) : AbstractC1076e.C0173e.e(jI);
        }

        public final long c(r rVar) {
            while (rVar.i() < rVar.getLength() - 6 && !AbstractC1093w.i(rVar, this.f19539a, this.f19540b, this.f19541c)) {
                rVar.k(1);
            }
            if (rVar.i() < rVar.getLength() - 6) {
                return this.f19541c.f16149a;
            }
            rVar.k((int) (rVar.getLength() - rVar.i()));
            return this.f19539a.f16162j;
        }

        public C0219b(C1096z c1096z, int i7) {
            this.f19539a = c1096z;
            this.f19540b = i7;
            this.f19541c = new AbstractC1093w.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(final C1096z c1096z, int i7, long j7, long j8) {
        super(new AbstractC1076e.d() { // from class: l1.a
            @Override // g1.AbstractC1076e.d
            public final long a(long j9) {
                return c1096z.i(j9);
            }
        }, new C0219b(c1096z, i7), c1096z.f(), 0L, c1096z.f16162j, j7, j8, c1096z.d(), Math.max(6, c1096z.f16155c));
        Objects.requireNonNull(c1096z);
    }
}
