package com.google.gson.internal;

import java.math.BigDecimal;

/* loaded from: classes.dex */
public final class f extends Number {

    /* renamed from: b, reason: collision with root package name */
    private final String f25076b;

    public f(String str) {
        this.f25076b = str;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f25076b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        String str = this.f25076b;
        String str2 = ((f) obj).f25076b;
        return str == str2 || str.equals(str2);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f25076b);
    }

    public int hashCode() {
        return this.f25076b.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f25076b);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f25076b);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.f25076b).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f25076b);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f25076b).longValue();
        }
    }

    public String toString() {
        return this.f25076b;
    }
}
