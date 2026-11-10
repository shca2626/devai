package org.webrtc.audio;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import java.nio.ByteBuffer;
import java.util.concurrent.ScheduledExecutorService;
import org.webrtc.JniCommon;
import org.webrtc.Logging;
import org.webrtc.MediaStreamTrack;
import org.webrtc.audio.WebRtcAudioEffects;

/* loaded from: classes3.dex */
public class JavaAudioDeviceModule implements AudioDeviceModule {
    private static final String TAG = "JavaAudioDeviceModule";
    public final WebRtcAudioRecord audioInput;
    private final AudioManager audioManager;
    public final WebRtcAudioTrack audioOutput;
    private final Context context;
    private final int inputSampleRate;
    private long nativeAudioDeviceModule;
    private final Object nativeLock;
    private final int outputSampleRate;
    private final boolean useStereoInput;
    private final boolean useStereoOutput;

    public interface AudioBufferCallback {
        long onBuffer(ByteBuffer byteBuffer, int i7, int i8, int i9, int i10, long j7);
    }

    public interface AudioRecordErrorCallback {
        void onWebRtcAudioRecordError(String str);

        void onWebRtcAudioRecordInitError(String str);

        void onWebRtcAudioRecordStartError(AudioRecordStartErrorCode audioRecordStartErrorCode, String str);
    }

    public enum AudioRecordStartErrorCode {
        AUDIO_RECORD_START_EXCEPTION,
        AUDIO_RECORD_START_STATE_MISMATCH
    }

    public interface AudioRecordStateCallback {
        void onWebRtcAudioRecordStart();

        void onWebRtcAudioRecordStop();
    }

    public static class AudioSamples {
        private final int audioFormat;
        private final int channelCount;
        private final byte[] data;
        private final int sampleRate;

        public AudioSamples(int i7, int i8, int i9, byte[] bArr) {
            this.audioFormat = i7;
            this.channelCount = i8;
            this.sampleRate = i9;
            this.data = bArr;
        }

        public int getAudioFormat() {
            return this.audioFormat;
        }

        public int getChannelCount() {
            return this.channelCount;
        }

        public byte[] getData() {
            return this.data;
        }

        public int getSampleRate() {
            return this.sampleRate;
        }
    }

    public interface AudioTrackErrorCallback {
        void onWebRtcAudioTrackError(String str);

        void onWebRtcAudioTrackInitError(String str);

        void onWebRtcAudioTrackStartError(AudioTrackStartErrorCode audioTrackStartErrorCode, String str);
    }

    public enum AudioTrackStartErrorCode {
        AUDIO_TRACK_START_EXCEPTION,
        AUDIO_TRACK_START_STATE_MISMATCH
    }

    public interface AudioTrackStateCallback {
        void onWebRtcAudioTrackStart();

        void onWebRtcAudioTrackStop();
    }

    public static class Builder {
        private AudioAttributes audioAttributes;
        private AudioBufferCallback audioBufferCallback;
        private int audioFormat;
        private final AudioManager audioManager;
        private AudioRecordErrorCallback audioRecordErrorCallback;
        private AudioRecordStateCallback audioRecordStateCallback;
        private int audioSource;
        private AudioTrackErrorCallback audioTrackErrorCallback;
        private AudioTrackStateCallback audioTrackStateCallback;
        private final Context context;
        private boolean enableVolumeLogger;
        private int inputSampleRate;
        private int outputSampleRate;
        private PlaybackSamplesReadyCallback playbackSamplesReadyCallback;
        private SamplesReadyCallback samplesReadyCallback;
        private ScheduledExecutorService scheduler;
        private boolean useHardwareAcousticEchoCanceler;
        private boolean useHardwareNoiseSuppressor;
        private boolean useLowLatency;
        private boolean useStereoInput;
        private boolean useStereoOutput;

        public JavaAudioDeviceModule createAudioDeviceModule() {
            Logging.d(JavaAudioDeviceModule.TAG, "createAudioDeviceModule");
            if (this.useHardwareNoiseSuppressor) {
                Logging.d(JavaAudioDeviceModule.TAG, "HW NS will be used.");
            } else {
                if (JavaAudioDeviceModule.isBuiltInNoiseSuppressorSupported()) {
                    Logging.d(JavaAudioDeviceModule.TAG, "Overriding default behavior; now using WebRTC NS!");
                }
                Logging.d(JavaAudioDeviceModule.TAG, "HW NS will not be used.");
            }
            if (this.useHardwareAcousticEchoCanceler) {
                Logging.d(JavaAudioDeviceModule.TAG, "HW AEC will be used.");
            } else {
                if (JavaAudioDeviceModule.isBuiltInAcousticEchoCancelerSupported()) {
                    Logging.d(JavaAudioDeviceModule.TAG, "Overriding default behavior; now using WebRTC AEC!");
                }
                Logging.d(JavaAudioDeviceModule.TAG, "HW AEC will not be used.");
            }
            if (this.useLowLatency && Build.VERSION.SDK_INT >= 26) {
                Logging.d(JavaAudioDeviceModule.TAG, "Low latency mode will be used.");
            }
            ScheduledExecutorService scheduledExecutorServiceNewDefaultScheduler = this.scheduler;
            if (scheduledExecutorServiceNewDefaultScheduler == null) {
                scheduledExecutorServiceNewDefaultScheduler = WebRtcAudioRecord.newDefaultScheduler();
            }
            return new JavaAudioDeviceModule(this.context, this.audioManager, new WebRtcAudioRecord(this.context, scheduledExecutorServiceNewDefaultScheduler, this.audioManager, this.audioSource, this.audioFormat, this.audioRecordErrorCallback, this.audioRecordStateCallback, this.samplesReadyCallback, this.audioBufferCallback, this.useHardwareAcousticEchoCanceler, this.useHardwareNoiseSuppressor, this.inputSampleRate, this.useStereoInput ? 2 : 1), new WebRtcAudioTrack(this.context, this.audioManager, this.audioAttributes, this.audioTrackErrorCallback, this.audioTrackStateCallback, this.playbackSamplesReadyCallback, this.useLowLatency, this.enableVolumeLogger), this.inputSampleRate, this.outputSampleRate, this.useStereoInput, this.useStereoOutput);
        }

        public Builder setAudioAttributes(AudioAttributes audioAttributes) {
            this.audioAttributes = audioAttributes;
            return this;
        }

        public Builder setAudioBufferCallback(AudioBufferCallback audioBufferCallback) {
            this.audioBufferCallback = audioBufferCallback;
            return this;
        }

        public Builder setAudioFormat(int i7) {
            this.audioFormat = i7;
            return this;
        }

        public Builder setAudioRecordErrorCallback(AudioRecordErrorCallback audioRecordErrorCallback) {
            this.audioRecordErrorCallback = audioRecordErrorCallback;
            return this;
        }

        public Builder setAudioRecordStateCallback(AudioRecordStateCallback audioRecordStateCallback) {
            this.audioRecordStateCallback = audioRecordStateCallback;
            return this;
        }

        public Builder setAudioSource(int i7) {
            this.audioSource = i7;
            return this;
        }

        public Builder setAudioTrackErrorCallback(AudioTrackErrorCallback audioTrackErrorCallback) {
            this.audioTrackErrorCallback = audioTrackErrorCallback;
            return this;
        }

        public Builder setAudioTrackStateCallback(AudioTrackStateCallback audioTrackStateCallback) {
            this.audioTrackStateCallback = audioTrackStateCallback;
            return this;
        }

        public Builder setEnableVolumeLogger(boolean z7) {
            this.enableVolumeLogger = z7;
            return this;
        }

        public Builder setInputSampleRate(int i7) {
            Logging.d(JavaAudioDeviceModule.TAG, "Input sample rate overridden to: " + i7);
            this.inputSampleRate = i7;
            return this;
        }

        public Builder setOutputSampleRate(int i7) {
            Logging.d(JavaAudioDeviceModule.TAG, "Output sample rate overridden to: " + i7);
            this.outputSampleRate = i7;
            return this;
        }

        public Builder setPlaybackSamplesReadyCallback(PlaybackSamplesReadyCallback playbackSamplesReadyCallback) {
            this.playbackSamplesReadyCallback = playbackSamplesReadyCallback;
            return this;
        }

        public Builder setSampleRate(int i7) {
            Logging.d(JavaAudioDeviceModule.TAG, "Input/Output sample rate overridden to: " + i7);
            this.inputSampleRate = i7;
            this.outputSampleRate = i7;
            return this;
        }

        public Builder setSamplesReadyCallback(SamplesReadyCallback samplesReadyCallback) {
            this.samplesReadyCallback = samplesReadyCallback;
            return this;
        }

        public Builder setScheduler(ScheduledExecutorService scheduledExecutorService) {
            this.scheduler = scheduledExecutorService;
            return this;
        }

        public Builder setUseHardwareAcousticEchoCanceler(boolean z7) {
            if (z7 && !JavaAudioDeviceModule.isBuiltInAcousticEchoCancelerSupported()) {
                Logging.e(JavaAudioDeviceModule.TAG, "HW AEC not supported");
                z7 = false;
            }
            this.useHardwareAcousticEchoCanceler = z7;
            return this;
        }

        public Builder setUseHardwareNoiseSuppressor(boolean z7) {
            if (z7 && !JavaAudioDeviceModule.isBuiltInNoiseSuppressorSupported()) {
                Logging.e(JavaAudioDeviceModule.TAG, "HW NS not supported");
                z7 = false;
            }
            this.useHardwareNoiseSuppressor = z7;
            return this;
        }

        public Builder setUseLowLatency(boolean z7) {
            this.useLowLatency = z7;
            return this;
        }

        public Builder setUseStereoInput(boolean z7) {
            this.useStereoInput = z7;
            return this;
        }

        public Builder setUseStereoOutput(boolean z7) {
            this.useStereoOutput = z7;
            return this;
        }

        private Builder(Context context) {
            this.audioSource = 7;
            this.audioFormat = 2;
            this.useHardwareAcousticEchoCanceler = JavaAudioDeviceModule.isBuiltInAcousticEchoCancelerSupported();
            this.useHardwareNoiseSuppressor = JavaAudioDeviceModule.isBuiltInNoiseSuppressorSupported();
            this.context = context;
            AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.audioManager = audioManager;
            this.inputSampleRate = WebRtcAudioManager.getSampleRate(audioManager);
            this.outputSampleRate = WebRtcAudioManager.getSampleRate(audioManager);
            this.useLowLatency = false;
            this.enableVolumeLogger = true;
        }
    }

    public static final class PlatformAudioProcessingComponentState {
        public final Boolean isActive;
        public final boolean isAvailable;
        public final Boolean isRequested;

        public PlatformAudioProcessingComponentState(boolean z7, Boolean bool, Boolean bool2) {
            this.isAvailable = z7;
            this.isRequested = bool;
            this.isActive = bool2;
        }
    }

    public static final class PlatformAudioProcessingState {
        public final PlatformAudioProcessingComponentState autoGainControl;
        public final PlatformAudioProcessingComponentState echoCancellation;
        public final PlatformAudioProcessingComponentState noiseSuppression;
        public final PlatformAudioProcessingTopology topology;

        public PlatformAudioProcessingState(PlatformAudioProcessingTopology platformAudioProcessingTopology, PlatformAudioProcessingComponentState platformAudioProcessingComponentState, PlatformAudioProcessingComponentState platformAudioProcessingComponentState2, PlatformAudioProcessingComponentState platformAudioProcessingComponentState3) {
            this.topology = platformAudioProcessingTopology;
            this.echoCancellation = platformAudioProcessingComponentState;
            this.noiseSuppression = platformAudioProcessingComponentState2;
            this.autoGainControl = platformAudioProcessingComponentState3;
        }
    }

    public enum PlatformAudioProcessingTopology {
        INDEPENDENT,
        ECHO_CANCELLATION_AND_NOISE_SUPPRESSION_COUPLED
    }

    public interface PlaybackSamplesReadyCallback {
        void onWebRtcAudioTrackSamplesReady(AudioSamples audioSamples);
    }

    public interface SamplesReadyCallback {
        void onWebRtcAudioRecordSamplesReady(AudioSamples audioSamples);
    }

    public static Builder builder(Context context) {
        return new Builder(context);
    }

    public static boolean isBuiltInAcousticEchoCancelerSupported() {
        return WebRtcAudioEffects.isAcousticEchoCancelerSupported();
    }

    public static boolean isBuiltInNoiseSuppressorSupported() {
        return WebRtcAudioEffects.isNoiseSuppressorSupported();
    }

    private static native long nativeCreateAudioDeviceModule(Context context, AudioManager audioManager, WebRtcAudioRecord webRtcAudioRecord, WebRtcAudioTrack webRtcAudioTrack, long j7, int i7, int i8, boolean z7, boolean z8);

    @Override // org.webrtc.audio.AudioDeviceModule
    public long getNative(long j7) {
        long j8;
        synchronized (this.nativeLock) {
            try {
                if (this.nativeAudioDeviceModule == 0) {
                    this.nativeAudioDeviceModule = nativeCreateAudioDeviceModule(this.context, this.audioManager, this.audioInput, this.audioOutput, j7, this.inputSampleRate, this.outputSampleRate, this.useStereoInput, this.useStereoOutput);
                }
                j8 = this.nativeAudioDeviceModule;
            } catch (Throwable th) {
                throw th;
            }
        }
        return j8;
    }

    public PlatformAudioProcessingState getPlatformAudioProcessingState() {
        WebRtcAudioEffects.State builtInAudioEffectsState = this.audioInput.getBuiltInAudioEffectsState();
        return new PlatformAudioProcessingState(PlatformAudioProcessingTopology.INDEPENDENT, new PlatformAudioProcessingComponentState(this.audioInput.isAcousticEchoCancelerSupported(), Boolean.valueOf(builtInAudioEffectsState.isAecRequested), builtInAudioEffectsState.aecActive), new PlatformAudioProcessingComponentState(this.audioInput.isNoiseSuppressorSupported(), Boolean.valueOf(builtInAudioEffectsState.isNsRequested), builtInAudioEffectsState.nsActive), new PlatformAudioProcessingComponentState(false, null, null));
    }

    public void prewarmRecording() {
        prewarmRecording(null);
    }

    @Override // org.webrtc.audio.AudioDeviceModule
    public void release() {
        synchronized (this.nativeLock) {
            try {
                long j7 = this.nativeAudioDeviceModule;
                if (j7 != 0) {
                    JniCommon.nativeReleaseRef(j7);
                    this.nativeAudioDeviceModule = 0L;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void requestStartRecording() {
        requestStartRecording(null);
    }

    public void requestStopRecording() {
        this.audioInput.stopRecordingIfNeeded();
    }

    public void setAudioRecordEnabled(boolean z7) {
        this.audioInput.setUseAudioRecord(z7);
    }

    @Override // org.webrtc.audio.AudioDeviceModule
    public void setMicrophoneMute(boolean z7) {
        Logging.d(TAG, "setMicrophoneMute: " + z7);
        this.audioInput.setMicrophoneMute(z7);
    }

    @Override // org.webrtc.audio.AudioDeviceModule
    public boolean setNoiseSuppressorEnabled(boolean z7) {
        Logging.d(TAG, "setNoiseSuppressorEnabled: " + z7);
        return this.audioInput.setNoiseSuppressorEnabled(z7);
    }

    public void setPreferredInputDevice(AudioDeviceInfo audioDeviceInfo) {
        Logging.d(TAG, "setPreferredInputDevice: " + audioDeviceInfo.getId());
        this.audioInput.setPreferredDevice(audioDeviceInfo);
    }

    @Override // org.webrtc.audio.AudioDeviceModule
    public void setSpeakerMute(boolean z7) {
        Logging.d(TAG, "setSpeakerMute: " + z7);
        this.audioOutput.setSpeakerMute(z7);
    }

    private JavaAudioDeviceModule(Context context, AudioManager audioManager, WebRtcAudioRecord webRtcAudioRecord, WebRtcAudioTrack webRtcAudioTrack, int i7, int i8, boolean z7, boolean z8) {
        this.nativeLock = new Object();
        this.context = context;
        this.audioManager = audioManager;
        this.audioInput = webRtcAudioRecord;
        this.audioOutput = webRtcAudioTrack;
        this.inputSampleRate = i7;
        this.outputSampleRate = i8;
        this.useStereoInput = z7;
        this.useStereoOutput = z8;
    }

    public void prewarmRecording(AudioProcessingOptions audioProcessingOptions) {
        this.audioInput.applyPlatformAudioProcessingOptions(audioProcessingOptions);
        this.audioInput.initRecordingIfNeeded();
        this.audioInput.prewarmRecordingIfNeeded();
    }

    public void requestStartRecording(AudioProcessingOptions audioProcessingOptions) {
        this.audioInput.applyPlatformAudioProcessingOptions(audioProcessingOptions);
        this.audioInput.initRecordingIfNeeded();
        this.audioInput.startRecordingIfNeeded();
    }
}
