package com.amazonaws.mobile.client;

/* loaded from: classes7.dex */
public enum IdentityProvider {
    AMAZON("www.amazon.com"),
    FACEBOOK("graph.facebook.com"),
    GOOGLE("accounts.google.com"),
    TWITTER("api.twitter.com");

    private final String key;

    IdentityProvider(String str) {
        this.key = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.key;
    }
}
