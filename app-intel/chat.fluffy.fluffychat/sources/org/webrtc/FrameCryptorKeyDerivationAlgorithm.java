package org.webrtc;

/* loaded from: classes3.dex */
public enum FrameCryptorKeyDerivationAlgorithm {
    PBKDF2(0),
    HKDF(1);

    private final int value;

    FrameCryptorKeyDerivationAlgorithm(int i7) {
        this.value = i7;
    }

    public int getValue() {
        return this.value;
    }
}
