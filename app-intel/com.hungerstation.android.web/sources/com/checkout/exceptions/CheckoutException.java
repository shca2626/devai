package com.checkout.exceptions;

/* loaded from: classes7.dex */
public class CheckoutException extends Exception {
    private CKExceptionType type;

    public enum CKExceptionType {
        INVALID_PUBLIC_KEY,
        API_ERROR,
        NO_PUBLIC_KEY
    }

    public CheckoutException(CKExceptionType cKExceptionType) {
        super(cKExceptionType.toString());
        this.type = cKExceptionType;
    }

    public CheckoutException(String str) {
        super(str);
    }

    public CheckoutException(Throwable th2) {
        super(th2);
    }

    public CheckoutException(String str, Throwable th2) {
        super(str, th2);
    }

    public CheckoutException(String str, Throwable th2, boolean z12, boolean z13) {
        super(str, th2, z12, z13);
    }
}
