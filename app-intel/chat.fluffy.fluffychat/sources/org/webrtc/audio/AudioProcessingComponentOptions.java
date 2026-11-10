package org.webrtc.audio;

import org.webrtc.CalledByNative;

/* loaded from: classes3.dex */
public final class AudioProcessingComponentOptions {
    public final boolean isEnabled;
    public final AudioProcessingMode mode;

    public AudioProcessingComponentOptions(boolean z7) {
        this(z7, AudioProcessingMode.AUTOMATIC);
    }

    private static <T> T checkNotNull(T t7, String str) {
        if (t7 != null) {
            return t7;
        }
        throw new IllegalArgumentException(str + " is not allowed to be null");
    }

    @CalledByNative
    public AudioProcessingComponentOptions(boolean z7, AudioProcessingMode audioProcessingMode) {
        this.isEnabled = z7;
        this.mode = (AudioProcessingMode) checkNotNull(audioProcessingMode, "mode");
    }
}
