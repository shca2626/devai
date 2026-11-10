package org.webrtc;

/* loaded from: classes3.dex */
public final class IceCandidateErrorEvent {
    public final String address;
    public final int errorCode;
    public final String errorText;
    public final int port;
    public final String url;

    @CalledByNative
    public IceCandidateErrorEvent(String str, int i7, String str2, int i8, String str3) {
        this.address = str;
        this.port = i7;
        this.url = str2;
        this.errorCode = i8;
        this.errorText = str3;
    }
}
