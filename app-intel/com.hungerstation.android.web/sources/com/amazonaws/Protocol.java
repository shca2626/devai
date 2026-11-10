package com.amazonaws;

import com.adjust.sdk.Constants;

/* loaded from: classes7.dex */
public enum Protocol {
    HTTP("http"),
    HTTPS(Constants.SCHEME);

    private final String protocol;

    Protocol(String str) {
        this.protocol = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
