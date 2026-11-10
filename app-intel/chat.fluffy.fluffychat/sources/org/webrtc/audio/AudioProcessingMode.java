package org.webrtc.audio;

import org.webrtc.CalledByNative;

/* loaded from: classes3.dex */
public enum AudioProcessingMode {
    AUTOMATIC,
    PLATFORM,
    SOFTWARE;

    @CalledByNative
    public static AudioProcessingMode fromNativeIndex(int i7) {
        return values()[i7];
    }
}
