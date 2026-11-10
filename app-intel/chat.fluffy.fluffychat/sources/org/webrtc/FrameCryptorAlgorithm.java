package org.webrtc;

/* loaded from: classes3.dex */
public enum FrameCryptorAlgorithm {
    AES_GCM(0);

    private final int value;

    FrameCryptorAlgorithm(int i7) {
        this.value = i7;
    }

    public int getValue() {
        return this.value;
    }
}
