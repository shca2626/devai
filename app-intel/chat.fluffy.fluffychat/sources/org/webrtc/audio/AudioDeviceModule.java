package org.webrtc.audio;

/* loaded from: classes3.dex */
public interface AudioDeviceModule {
    long getNative(long j7);

    void release();

    void setMicrophoneMute(boolean z7);

    default boolean setNoiseSuppressorEnabled(boolean z7) {
        return false;
    }

    default boolean setPreferredMicrophoneFieldDimension(float f7) {
        return false;
    }

    void setSpeakerMute(boolean z7);
}
