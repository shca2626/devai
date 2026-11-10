package org.webrtc.audio;

import org.webrtc.CalledByNative;

/* loaded from: classes3.dex */
public final class AudioProcessingComponentState {
    public final AudioProcessingImplementation effective;
    public final boolean isPlatformActive;
    public final boolean isPlatformAvailable;
    public final boolean isPlatformResolved;
    public final boolean isSoftwareActive;
    public final boolean isSoftwareResolved;
    public final AudioProcessingComponentOptions requested;

    @CalledByNative
    public AudioProcessingComponentState(AudioProcessingComponentOptions audioProcessingComponentOptions, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, AudioProcessingImplementation audioProcessingImplementation) {
        this.requested = audioProcessingComponentOptions;
        this.isSoftwareResolved = z7;
        this.isSoftwareActive = z8;
        this.isPlatformAvailable = z9;
        this.isPlatformResolved = z10;
        this.isPlatformActive = z11;
        this.effective = audioProcessingImplementation;
    }
}
