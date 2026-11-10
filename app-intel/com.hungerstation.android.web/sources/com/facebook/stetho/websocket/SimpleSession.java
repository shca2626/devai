package com.facebook.stetho.websocket;

/* loaded from: classes8.dex */
public interface SimpleSession {
    void close(int i12, String str);

    boolean isOpen();

    void sendBinary(byte[] bArr);

    void sendText(String str);
}
