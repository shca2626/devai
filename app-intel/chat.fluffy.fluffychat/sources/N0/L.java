package N0;

import java.util.List;
import k3.AbstractC1278v;

/* loaded from: classes.dex */
public final class L {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC1278v f5802a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC1278v f5803b;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final AbstractC1278v.a f5804a = AbstractC1278v.o();

        /* renamed from: b, reason: collision with root package name */
        public AbstractC1278v f5805b;

        public b c(Y0.A a7) {
            this.f5804a.a(a7);
            return this;
        }

        public L d() {
            return new L(this);
        }

        public b e(List list) {
            this.f5805b = AbstractC1278v.r(list);
            return this;
        }
    }

    public L(b bVar) {
        this.f5802a = bVar.f5804a.k();
        this.f5803b = bVar.f5805b;
    }
}
