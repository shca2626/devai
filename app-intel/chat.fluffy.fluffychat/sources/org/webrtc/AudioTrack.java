package org.webrtc;

import java.util.IdentityHashMap;
import java.util.Iterator;
import org.webrtc.audio.AudioProcessingOptions;
import org.webrtc.audio.AudioProcessingOptionsResult;
import org.webrtc.audio.JavaAudioDeviceModule;

/* loaded from: classes3.dex */
public class AudioTrack extends MediaStreamTrack {
    private final AudioProcessingPlatformPolicy audioProcessingPlatformPolicy;
    private final IdentityHashMap<AudioTrackSink, Long> sinks;

    public static final class AudioProcessingPlatformPolicy {
        final boolean isEchoCancellationPlatformAvailable;
        final boolean isNoiseSuppressionPlatformAvailable;

        public AudioProcessingPlatformPolicy(boolean z7, boolean z8) {
            this.isEchoCancellationPlatformAvailable = z7;
            this.isNoiseSuppressionPlatformAvailable = z8;
        }

        public static AudioProcessingPlatformPolicy fromJavaAudioDeviceModule(JavaAudioDeviceModule javaAudioDeviceModule) {
            JavaAudioDeviceModule.PlatformAudioProcessingState platformAudioProcessingState = javaAudioDeviceModule.getPlatformAudioProcessingState();
            return new AudioProcessingPlatformPolicy(platformAudioProcessingState.echoCancellation.isAvailable, platformAudioProcessingState.noiseSuppression.isAvailable);
        }
    }

    public AudioTrack(long j7) {
        this(j7, null);
    }

    private static native void nativeAddSink(long j7, long j8);

    private static native void nativeFreeSink(long j7);

    private static native double nativeGetVolume(long j7);

    private static native void nativeRemoveSink(long j7, long j8);

    private static native String nativeSetAudioProcessingOptions(long j7, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, int i7, int i8, int i9, int i10);

    private static native void nativeSetVolume(long j7, double d7);

    private static native long nativeWrapSink(AudioTrackSink audioTrackSink);

    public void addSink(AudioTrackSink audioTrackSink) {
        if (audioTrackSink == null) {
            throw new IllegalArgumentException("The AudioTrackSink is not allowed to be null");
        }
        if (this.sinks.containsKey(audioTrackSink)) {
            return;
        }
        long jNativeWrapSink = nativeWrapSink(audioTrackSink);
        this.sinks.put(audioTrackSink, Long.valueOf(jNativeWrapSink));
        nativeAddSink(getNativeMediaStreamTrack(), jNativeWrapSink);
    }

    @Override // org.webrtc.MediaStreamTrack
    public void dispose() {
        Iterator<Long> it = this.sinks.values().iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            nativeRemoveSink(getNativeMediaStreamTrack(), jLongValue);
            nativeFreeSink(jLongValue);
        }
        this.sinks.clear();
        super.dispose();
    }

    public long getNativeAudioTrack() {
        return getNativeMediaStreamTrack();
    }

    public double getVolume() {
        return nativeGetVolume(getNativeAudioTrack());
    }

    public void removeSink(AudioTrackSink audioTrackSink) {
        Long lRemove = this.sinks.remove(audioTrackSink);
        if (lRemove != null) {
            nativeRemoveSink(getNativeMediaStreamTrack(), lRemove.longValue());
            nativeFreeSink(lRemove.longValue());
        }
    }

    public AudioProcessingOptionsResult setAudioProcessingOptions(AudioProcessingOptions audioProcessingOptions) {
        if (audioProcessingOptions == null) {
            throw new IllegalArgumentException("AudioProcessingOptions is not allowed to be null");
        }
        AudioProcessingPlatformPolicy audioProcessingPlatformPolicy = this.audioProcessingPlatformPolicy;
        boolean zIsBuiltInAcousticEchoCancelerSupported = audioProcessingPlatformPolicy == null ? JavaAudioDeviceModule.isBuiltInAcousticEchoCancelerSupported() : audioProcessingPlatformPolicy.isEchoCancellationPlatformAvailable;
        AudioProcessingPlatformPolicy audioProcessingPlatformPolicy2 = this.audioProcessingPlatformPolicy;
        return AudioProcessingOptionsResult.fromNativeResult(nativeSetAudioProcessingOptions(getNativeAudioTrack(), audioProcessingOptions.echoCancellation, audioProcessingOptions.noiseSuppression, audioProcessingOptions.autoGainControl, audioProcessingOptions.highPassFilter, zIsBuiltInAcousticEchoCancelerSupported, audioProcessingPlatformPolicy2 == null ? JavaAudioDeviceModule.isBuiltInNoiseSuppressorSupported() : audioProcessingPlatformPolicy2.isNoiseSuppressionPlatformAvailable, audioProcessingOptions.echoCancellationMode.ordinal(), audioProcessingOptions.noiseSuppressionMode.ordinal(), audioProcessingOptions.autoGainControlMode.ordinal(), audioProcessingOptions.highPassFilterMode.ordinal()));
    }

    public void setVolume(double d7) {
        nativeSetVolume(getNativeAudioTrack(), d7);
    }

    public AudioTrack(long j7, AudioProcessingPlatformPolicy audioProcessingPlatformPolicy) {
        super(j7);
        this.sinks = new IdentityHashMap<>();
        this.audioProcessingPlatformPolicy = audioProcessingPlatformPolicy;
    }
}
