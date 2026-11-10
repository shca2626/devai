package org.webrtc.audio;

/* loaded from: classes3.dex */
public final class AudioProcessingOptions {
    public final boolean autoGainControl;
    public final AudioProcessingMode autoGainControlMode;
    public final boolean echoCancellation;
    public final AudioProcessingMode echoCancellationMode;
    public final boolean highPassFilter;
    public final AudioProcessingMode highPassFilterMode;
    public final boolean noiseSuppression;
    public final AudioProcessingMode noiseSuppressionMode;

    /* JADX WARN: Illegal instructions before constructor call */
    public AudioProcessingOptions(boolean z7, boolean z8, boolean z9, boolean z10) {
        AudioProcessingMode audioProcessingMode = AudioProcessingMode.AUTOMATIC;
        this(new AudioProcessingComponentOptions(z7, audioProcessingMode), new AudioProcessingComponentOptions(z8, audioProcessingMode), new AudioProcessingComponentOptions(z9, audioProcessingMode), new AudioProcessingComponentOptions(z10, audioProcessingMode));
    }

    private static <T> T checkNotNull(T t7, String str) {
        if (t7 != null) {
            return t7;
        }
        throw new IllegalArgumentException(str + " is not allowed to be null");
    }

    public static AudioProcessingOptions communication() {
        return new AudioProcessingOptions(true, true, true, true);
    }

    public static AudioProcessingOptions raw() {
        return new AudioProcessingOptions(false, false, false, false);
    }

    public AudioProcessingOptions(AudioProcessingComponentOptions audioProcessingComponentOptions, AudioProcessingComponentOptions audioProcessingComponentOptions2, AudioProcessingComponentOptions audioProcessingComponentOptions3, AudioProcessingComponentOptions audioProcessingComponentOptions4) {
        AudioProcessingComponentOptions audioProcessingComponentOptions5 = (AudioProcessingComponentOptions) checkNotNull(audioProcessingComponentOptions, "echoCancellationOptions");
        AudioProcessingComponentOptions audioProcessingComponentOptions6 = (AudioProcessingComponentOptions) checkNotNull(audioProcessingComponentOptions2, "noiseSuppressionOptions");
        AudioProcessingComponentOptions audioProcessingComponentOptions7 = (AudioProcessingComponentOptions) checkNotNull(audioProcessingComponentOptions3, "autoGainControlOptions");
        AudioProcessingComponentOptions audioProcessingComponentOptions8 = (AudioProcessingComponentOptions) checkNotNull(audioProcessingComponentOptions4, "highPassFilterOptions");
        this.echoCancellation = audioProcessingComponentOptions5.isEnabled;
        this.noiseSuppression = audioProcessingComponentOptions6.isEnabled;
        this.autoGainControl = audioProcessingComponentOptions7.isEnabled;
        this.highPassFilter = audioProcessingComponentOptions8.isEnabled;
        this.echoCancellationMode = audioProcessingComponentOptions5.mode;
        this.noiseSuppressionMode = audioProcessingComponentOptions6.mode;
        this.autoGainControlMode = audioProcessingComponentOptions7.mode;
        this.highPassFilterMode = audioProcessingComponentOptions8.mode;
    }
}
