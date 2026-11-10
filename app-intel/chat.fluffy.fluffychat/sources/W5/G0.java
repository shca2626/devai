package W5;

import b6.AbstractC0877m;

/* loaded from: classes.dex */
public abstract class G0 extends J {
    @Override // W5.J
    public J W(int i7, String str) {
        AbstractC0877m.a(i7);
        return AbstractC0877m.b(this, str);
    }

    public abstract G0 Y();

    public final String Z() {
        G0 g0Y;
        G0 g0C = C0613c0.c();
        if (this == g0C) {
            return "Dispatchers.Main";
        }
        try {
            g0Y = g0C.Y();
        } catch (UnsupportedOperationException unused) {
            g0Y = null;
        }
        if (this == g0Y) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // W5.J
    public String toString() {
        String strZ = Z();
        if (strZ != null) {
            return strZ;
        }
        return Q.a(this) + '@' + Q.b(this);
    }
}
