package w3;

import java.math.BigDecimal;

/* loaded from: classes.dex */
public final class y extends Number {

    /* renamed from: l, reason: collision with root package name */
    public final String f23354l;

    public y(String str) {
        this.f23354l = str;
    }

    public final BigDecimal a() {
        return AbstractC1730A.b(this.f23354l);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f23354l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y) {
            return this.f23354l.equals(((y) obj).f23354l);
        }
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f23354l);
    }

    public int hashCode() {
        return this.f23354l.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f23354l);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f23354l);
            }
        } catch (NumberFormatException unused2) {
            return a().intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f23354l);
        } catch (NumberFormatException unused) {
            return a().longValue();
        }
    }

    public String toString() {
        return this.f23354l;
    }
}
