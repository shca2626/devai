package com.adjust.sdk;

/* loaded from: classes7.dex */
public class ReferrerDetails {
    public Boolean googlePlayInstant;
    public long installBeginTimestampSeconds;
    public long installBeginTimestampServerSeconds;
    public String installReferrer;
    public String installVersion;
    public long referrerClickTimestampSeconds;
    public long referrerClickTimestampServerSeconds;

    public ReferrerDetails(String str, long j12, long j13) {
        this(str, j12, j13, -1L, -1L, null, null);
    }

    public ReferrerDetails(String str, long j12, long j13, long j14, long j15, String str2, Boolean bool) {
        this.installReferrer = str;
        this.referrerClickTimestampSeconds = j12;
        this.installBeginTimestampSeconds = j13;
        this.referrerClickTimestampServerSeconds = j14;
        this.installBeginTimestampServerSeconds = j15;
        this.installVersion = str2;
        this.googlePlayInstant = bool;
    }
}
