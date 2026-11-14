package u3;

import java.io.IOException;
import w3.AbstractC1735F;

/* renamed from: u3.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1653j {
    @Deprecated
    public AbstractC1653j() {
    }

    public boolean f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public C1650g g() {
        if (k()) {
            return (C1650g) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public C1656m h() {
        if (m()) {
            return (C1656m) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public C1658o i() {
        if (n()) {
            return (C1658o) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public String j() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean k() {
        return this instanceof C1650g;
    }

    public boolean l() {
        return this instanceof C1655l;
    }

    public boolean m() {
        return this instanceof C1656m;
    }

    public boolean n() {
        return this instanceof C1658o;
    }

    public String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            C3.c cVar = new C3.c(AbstractC1735F.c(sb));
            cVar.M(t.LENIENT);
            AbstractC1735F.b(this, cVar);
            return sb.toString();
        } catch (IOException e7) {
            throw new AssertionError(e7);
        }
    }
}
