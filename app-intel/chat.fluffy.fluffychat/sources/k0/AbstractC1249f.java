package k0;

import M5.m;
import java.util.Map;
import z5.C1866G;

/* renamed from: k0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1249f {

    /* renamed from: k0.f$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f18820a;

        public a(String str) {
            m.e(str, "name");
            this.f18820a = str;
        }

        public final String a() {
            return this.f18820a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return m.a(this.f18820a, ((a) obj).f18820a);
            }
            return false;
        }

        public int hashCode() {
            return this.f18820a.hashCode();
        }

        public String toString() {
            return this.f18820a;
        }
    }

    /* renamed from: k0.f$b */
    public static final class b {
    }

    public abstract Map a();

    public abstract Object b(a aVar);

    public final C1246c c() {
        return new C1246c(C1866G.u(a()), false);
    }

    public final AbstractC1249f d() {
        return new C1246c(C1866G.u(a()), true);
    }
}
