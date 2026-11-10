package org.webrtc.audio;

import org.webrtc.CalledByNative;

/* loaded from: classes3.dex */
public final class AudioProcessingState {
    public final AudioProcessingComponentState autoGainControl;
    public final AudioProcessingComponentState echoCancellation;
    public final boolean hasAudioProcessingModule;
    public final AudioProcessingComponentState highPassFilter;
    public final AudioProcessingComponentState noiseSuppression;

    @CalledByNative
    public AudioProcessingState(boolean z7, AudioProcessingComponentState audioProcessingComponentState, AudioProcessingComponentState audioProcessingComponentState2, AudioProcessingComponentState audioProcessingComponentState3, AudioProcessingComponentState audioProcessingComponentState4) {
        this.hasAudioProcessingModule = z7;
        this.echoCancellation = audioProcessingComponentState;
        this.noiseSuppression = audioProcessingComponentState2;
        this.autoGainControl = audioProcessingComponentState3;
        this.highPassFilter = audioProcessingComponentState4;
    }
}
