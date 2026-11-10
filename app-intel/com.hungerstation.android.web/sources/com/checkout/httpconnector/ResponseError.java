package com.checkout.httpconnector;

import java.util.List;

/* loaded from: classes7.dex */
public class ResponseError {
    public String errorCode;
    public List<String> errors;
    public String eventId;
    public String message;

    public ResponseError(String str, String str2, String str3, List<String> list) {
        this.errorCode = str;
        this.message = str2;
        this.eventId = str3;
        this.errors = list;
    }
}
