package w3;

import java.math.BigDecimal;

/* loaded from: classes.dex */
public final class y extends Number {

    /* renamed from: l, reason: collision with root package name */
    public final String f23348l;

    public y(String str) {
        this.f23348l = str;
    }

    public final BigDecimal a() {
        return AbstractC1731A.b(this.f23348l);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f23348l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y) {
            return this.f23348l.equals(((y) obj).f23348l);
        }
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f23348l);
    }

    public int hashCode() {
        return this.f23348l.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f23348l);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f23348l);
            }
        } catch (NumberFormatException unused2) {
            return a().intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f23348l);
        } catch (NumberFormatException unused) {
            return a().longValue();
        }
    }

    public String toString() {
        return this.f23348l;
    }
}
