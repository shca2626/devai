package com.checkout.exceptions;

/* loaded from: classes7.dex */
public class CardException extends Exception {
    private CardExceptionType type;

    public enum CardExceptionType {
        INVALID_CVV,
        INVALID_EXPIRY_DATE,
        INVALID_NUMBER
    }

    public CardException(CardExceptionType cardExceptionType) {
        super(cardExceptionType.toString());
        this.type = cardExceptionType;
    }

    public CardExceptionType getType() {
        return this.type;
    }

    public CardException(String str) {
        super(str);
    }

    public CardException(Throwable th2) {
        super(th2);
    }

    public CardException(String str, Throwable th2) {
        super(str, th2);
    }

    public CardException(String str, Throwable th2, boolean z12, boolean z13) {
        super(str, th2, z12, z13);
    }
}
