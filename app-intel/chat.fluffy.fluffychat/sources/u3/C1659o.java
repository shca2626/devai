package u3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import w3.AbstractC1731A;
import w3.y;

/* renamed from: u3.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1659o extends AbstractC1654j {

    /* renamed from: l, reason: collision with root package name */
    public final Object f22858l;

    public C1659o(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f22858l = bool;
    }

    public static boolean v(C1659o c1659o) {
        Object obj = c1659o.f22858l;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1659o.class != obj.getClass()) {
            return false;
        }
        C1659o c1659o = (C1659o) obj;
        if (this.f22858l == null) {
            return c1659o.f22858l == null;
        }
        if (v(this) && v(c1659o)) {
            return ((this.f22858l instanceof BigInteger) || (c1659o.f22858l instanceof BigInteger)) ? p().equals(c1659o.p()) : t().longValue() == c1659o.t().longValue();
        }
        Object obj2 = this.f22858l;
        if (obj2 instanceof Number) {
            Object obj3 = c1659o.f22858l;
            if (obj3 instanceof Number) {
                if ((obj2 instanceof BigDecimal) && (obj3 instanceof BigDecimal)) {
                    return o().compareTo(c1659o.o()) == 0;
                }
                double dQ = q();
                double dQ2 = c1659o.q();
                return dQ == dQ2 || (Double.isNaN(dQ) && Double.isNaN(dQ2));
            }
        }
        return obj2.equals(c1659o.f22858l);
    }

    @Override // u3.AbstractC1654j
    public boolean f() {
        return u() ? ((Boolean) this.f22858l).booleanValue() : Boolean.parseBoolean(j());
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.f22858l == null) {
            return 31;
        }
        if (v(this)) {
            jDoubleToLongBits = t().longValue();
        } else {
            Object obj = this.f22858l;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(t().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    @Override // u3.AbstractC1654j
    public String j() {
        Object obj = this.f22858l;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (w()) {
            return t().toString();
        }
        if (u()) {
            return ((Boolean) this.f22858l).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.f22858l.getClass());
    }

    public BigDecimal o() {
        Object obj = this.f22858l;
        return obj instanceof BigDecimal ? (BigDecimal) obj : AbstractC1731A.b(j());
    }

    public BigInteger p() {
        Object obj = this.f22858l;
        return obj instanceof BigInteger ? (BigInteger) obj : v(this) ? BigInteger.valueOf(t().longValue()) : AbstractC1731A.c(j());
    }

    public double q() {
        return w() ? t().doubleValue() : Double.parseDouble(j());
    }

    public int r() {
        return w() ? t().intValue() : Integer.parseInt(j());
    }

    public long s() {
        return w() ? t().longValue() : Long.parseLong(j());
    }

    public Number t() {
        Object obj = this.f22858l;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new y((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public boolean u() {
        return this.f22858l instanceof Boolean;
    }

    public boolean w() {
        return this.f22858l instanceof Number;
    }

    public boolean x() {
        return this.f22858l instanceof String;
    }

    public C1659o(Number number) {
        Objects.requireNonNull(number);
        this.f22858l = number;
    }

    public C1659o(String str) {
        Objects.requireNonNull(str);
        this.f22858l = str;
    }
}
