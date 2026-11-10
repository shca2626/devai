package com.google.i18n.phonenumbers;

/* loaded from: classes8.dex */
public class NumberParseException extends Exception {

    /* renamed from: b, reason: collision with root package name */
    private a f25143b;

    /* renamed from: c, reason: collision with root package name */
    private String f25144c;

    public enum a {
        INVALID_COUNTRY_CODE,
        NOT_A_NUMBER,
        TOO_SHORT_AFTER_IDD,
        TOO_SHORT_NSN,
        TOO_LONG
    }

    public NumberParseException(a aVar, String str) {
        super(str);
        this.f25144c = str;
        this.f25143b = aVar;
    }

    public a b() {
        return this.f25143b;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "Error type: " + this.f25143b + ". " + this.f25144c;
    }
}
