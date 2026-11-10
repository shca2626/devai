package com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens;

/* loaded from: classes7.dex */
public class CognitoUserToken {
    private final String token;

    public CognitoUserToken(String str) {
        this.token = str;
    }

    protected String getToken() {
        return this.token;
    }
}
