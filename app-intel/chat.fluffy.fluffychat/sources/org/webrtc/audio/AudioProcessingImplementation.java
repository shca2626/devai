package org.webrtc.audio;

import org.webrtc.CalledByNative;

/* loaded from: classes3.dex */
public enum AudioProcessingImplementation {
    UNKNOWN,
    DISABLED,
    SOFTWARE,
    PLATFORM,
    SOFTWARE_AND_PLATFORM;

    @CalledByNative
    public static AudioProcessingImplementation fromNativeIndex(int i7) {
        return values()[i7];
    }
}
