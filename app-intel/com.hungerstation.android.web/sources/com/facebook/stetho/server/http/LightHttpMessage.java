package com.facebook.stetho.server.http;

import java.util.ArrayList;

/* loaded from: classes8.dex */
public class LightHttpMessage {
    public final ArrayList<String> headerNames = new ArrayList<>();
    public final ArrayList<String> headerValues = new ArrayList<>();

    public void addHeader(String str, String str2) {
        this.headerNames.add(str);
        this.headerValues.add(str2);
    }

    public String getFirstHeaderValue(String str) {
        int size = this.headerNames.size();
        for (int i12 = 0; i12 < size; i12++) {
            if (str.equals(this.headerNames.get(i12))) {
                return this.headerValues.get(i12);
            }
        }
        return null;
    }

    public void reset() {
        this.headerNames.clear();
        this.headerValues.clear();
    }
}
