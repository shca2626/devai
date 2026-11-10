package a6;

import Z5.w;

/* loaded from: classes.dex */
public final class u extends Z5.t implements w {
    public u(int i7) {
        super(1, Integer.MAX_VALUE, Y5.a.f9871m);
        S(Integer.valueOf(i7));
    }

    @Override // Z5.w
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public Integer getValue() {
        Integer numValueOf;
        synchronized (this) {
            numValueOf = Integer.valueOf(((Number) M()).intValue());
        }
        return numValueOf;
    }

    public final boolean b0(int i7) {
        boolean zS;
        synchronized (this) {
            zS = S(Integer.valueOf(((Number) M()).intValue() + i7));
        }
        return zS;
    }
}
