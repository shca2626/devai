package k0;

import M5.m;
import java.util.Map;
import z5.C1863G;

/* renamed from: k0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1250f {

    /* renamed from: k0.f$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f18821a;

        public a(String str) {
            m.e(str, "name");
            this.f18821a = str;
        }

        public final String a() {
            return this.f18821a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return m.a(this.f18821a, ((a) obj).f18821a);
            }
            return false;
        }

        public int hashCode() {
            return this.f18821a.hashCode();
        }

        public String toString() {
            return this.f18821a;
        }
    }

    /* renamed from: k0.f$b */
    public static final class b {
    }

    public abstract Map a();

    public abstract Object b(a aVar);

    public final C1247c c() {
        return new C1247c(C1863G.u(a()), false);
    }

    public final AbstractC1250f d() {
        return new C1247c(C1863G.u(a()), true);
    }
}
