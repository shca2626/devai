package u3;

import java.io.IOException;
import w3.AbstractC1736F;

/* renamed from: u3.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1654j {
    @Deprecated
    public AbstractC1654j() {
    }

    public boolean f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public C1651g g() {
        if (k()) {
            return (C1651g) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public C1657m h() {
        if (m()) {
            return (C1657m) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public C1659o i() {
        if (n()) {
            return (C1659o) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public String j() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean k() {
        return this instanceof C1651g;
    }

    public boolean l() {
        return this instanceof C1656l;
    }

    public boolean m() {
        return this instanceof C1657m;
    }

    public boolean n() {
        return this instanceof C1659o;
    }

    public String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            C3.c cVar = new C3.c(AbstractC1736F.c(sb));
            cVar.M(t.LENIENT);
            AbstractC1736F.b(this, cVar);
            return sb.toString();
        } catch (IOException e7) {
            throw new AssertionError(e7);
        }
    }
}
