package org.webrtc.audio;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.media.AudioTimestamp;
import android.os.Process;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.webrtc.CalledByNative;
import org.webrtc.Logging;
import org.webrtc.ThreadUtils;
import org.webrtc.audio.JavaAudioDeviceModule;
import org.webrtc.audio.WebRtcAudioEffects;

/* loaded from: classes3.dex */
class WebRtcAudioRecord {
    private static final int AUDIO_RECORD_START = 0;
    private static final int AUDIO_RECORD_STOP = 1;
    private static final long AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS = 2000;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int BUFFER_SIZE_FACTOR = 2;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    private static final int CHECK_REC_STATUS_DELAY_MS = 100;
    public static final int DEFAULT_AUDIO_FORMAT = 2;
    public static final int DEFAULT_AUDIO_SOURCE = 7;
    private static final String TAG = "WebRtcAudioRecordExternal";
    private static final AtomicInteger nextSchedulerId = new AtomicInteger(0);
    private final JavaAudioDeviceModule.AudioBufferCallback audioBufferCallback;
    private final int audioFormat;
    private final AudioManager audioManager;
    private volatile AudioRecord audioRecord;
    private final Object audioRecordStateLock;
    private final JavaAudioDeviceModule.SamplesReadyCallback audioSamplesReadyCallback;
    private final int audioSource;
    private final AtomicReference<Boolean> audioSourceMatchesRecordingSessionRef;
    private AudioRecordThread audioThread;
    private final Object audioThreadStateLock;
    private ByteBuffer byteBuffer;
    private int channelCount;
    private AtomicBoolean clientCalledStartRecording;
    private final Context context;
    private final WebRtcAudioEffects effects;
    private byte[] emptyBytes;
    private final JavaAudioDeviceModule.AudioRecordErrorCallback errorCallback;
    private final ScheduledExecutorService executor;
    private int expectedChannelCount;
    private int expectedSampleRate;
    private ScheduledFuture<String> future;
    private final boolean isAcousticEchoCancelerSupported;
    private final boolean isNoiseSuppressorSupported;
    private volatile boolean microphoneMute;
    private long nativeAudioRecord;
    private AtomicBoolean nativeCalledInitRecording;
    private AtomicBoolean nativeCalledStartRecording;
    private AudioDeviceInfo preferredDevice;
    private int sampleRate;
    private final JavaAudioDeviceModule.AudioRecordStateCallback stateCallback;
    private boolean useAudioRecord;

    public class AudioRecordThread extends Thread {
        private AudioRecord activeRecord;
        private final AtomicBoolean cleanupDone;
        private volatile boolean keepAlive;
        private final AtomicReference<AudioRecord> orphanedRecord;

        public AudioRecordThread(String str) {
            super(str);
            this.keepAlive = true;
            this.orphanedRecord = new AtomicReference<>();
            this.cleanupDone = new AtomicBoolean(false);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws IllegalStateException, SecurityException, IllegalArgumentException {
            AudioRecord audioRecord;
            boolean z7;
            int iCapacity;
            boolean z8;
            AudioRecord audioRecord2;
            boolean z9;
            boolean z10;
            Process.setThreadPriority(-19);
            Logging.d(WebRtcAudioRecord.TAG, "AudioRecordThread" + WebRtcAudioUtils.getThreadInfo());
            synchronized (WebRtcAudioRecord.this.audioRecordStateLock) {
                try {
                    AudioRecord audioRecord3 = WebRtcAudioRecord.this.audioRecord;
                    if (this.keepAlive && audioRecord3 != null) {
                        WebRtcAudioRecord.assertTrue(audioRecord3.getRecordingState() == 3);
                    }
                } finally {
                }
            }
            WebRtcAudioRecord.this.doAudioRecordStateCallback(0);
            System.nanoTime();
            AudioTimestamp audioTimestamp = new AudioTimestamp();
            while (true) {
                AudioRecord audioRecord4 = null;
                if (this.keepAlive) {
                    synchronized (WebRtcAudioRecord.this.audioRecordStateLock) {
                        audioRecord = WebRtcAudioRecord.this.audioRecord;
                        z7 = WebRtcAudioRecord.this.nativeCalledInitRecording.get();
                    }
                    if (this.keepAlive) {
                        if (audioRecord == null && WebRtcAudioRecord.this.useAudioRecord && this.keepAlive) {
                            synchronized (WebRtcAudioRecord.this.audioRecordStateLock) {
                                try {
                                    z8 = this.keepAlive && WebRtcAudioRecord.this.initAudioRecord();
                                } finally {
                                }
                            }
                            if (z8) {
                                synchronized (WebRtcAudioRecord.this.audioRecordStateLock) {
                                    audioRecord2 = this.keepAlive ? WebRtcAudioRecord.this.audioRecord : null;
                                    if (audioRecord2 != null) {
                                        try {
                                            audioRecord2.startRecording();
                                            z9 = false;
                                        } catch (IllegalStateException e7) {
                                            WebRtcAudioRecord.this.reportWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION, "AudioRecord.startRecording failed: " + e7.getMessage());
                                            z9 = true;
                                        }
                                        if (z9 || audioRecord2.getRecordingState() == 3) {
                                            z10 = false;
                                        } else {
                                            WebRtcAudioRecord.this.reportWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH, "AudioRecord.startRecording failed - incorrect state: " + audioRecord2.getRecordingState());
                                            z10 = true;
                                        }
                                    } else {
                                        z9 = false;
                                        z10 = false;
                                    }
                                }
                                if (audioRecord2 == null) {
                                    continue;
                                } else if (z9 || z10) {
                                    WebRtcAudioRecord.this.useAudioRecord = false;
                                    audioRecord = null;
                                } else {
                                    audioRecord = audioRecord2;
                                }
                            } else if (this.keepAlive) {
                                WebRtcAudioRecord.this.useAudioRecord = false;
                            }
                        }
                        if (audioRecord == null || WebRtcAudioRecord.this.useAudioRecord) {
                            audioRecord4 = audioRecord;
                        } else {
                            synchronized (WebRtcAudioRecord.this.audioRecordStateLock) {
                                try {
                                    if (WebRtcAudioRecord.this.audioRecord == audioRecord) {
                                        WebRtcAudioRecord.this.releaseAudioResources();
                                    }
                                } finally {
                                }
                            }
                        }
                        this.activeRecord = audioRecord4;
                        long j7 = 0;
                        if (audioRecord4 != null) {
                            int i7 = audioRecord4.read(WebRtcAudioRecord.this.byteBuffer, WebRtcAudioRecord.this.byteBuffer.capacity());
                            if (i7 == WebRtcAudioRecord.this.byteBuffer.capacity()) {
                                if (WebRtcAudioRecord.this.microphoneMute) {
                                    WebRtcAudioRecord.this.byteBuffer.put(WebRtcAudioRecord.this.emptyBytes);
                                }
                                if (this.keepAlive && audioRecord4.getTimestamp(audioTimestamp, 0) == 0) {
                                    j7 = audioTimestamp.nanoTime;
                                }
                                iCapacity = i7;
                            } else if (this.keepAlive) {
                                String str = "AudioRecord.read failed: " + i7;
                                Logging.e(WebRtcAudioRecord.TAG, str);
                                if (i7 == -3) {
                                    this.keepAlive = false;
                                    WebRtcAudioRecord.this.reportWebRtcAudioRecordError(str);
                                }
                            }
                        } else {
                            WebRtcAudioRecord.this.byteBuffer.put(WebRtcAudioRecord.this.emptyBytes);
                            iCapacity = 0;
                        }
                        long jOnBuffer = j7;
                        if (this.keepAlive && WebRtcAudioRecord.this.audioBufferCallback != null) {
                            jOnBuffer = WebRtcAudioRecord.this.audioBufferCallback.onBuffer(WebRtcAudioRecord.this.byteBuffer, WebRtcAudioRecord.this.audioFormat, WebRtcAudioRecord.this.channelCount, WebRtcAudioRecord.this.sampleRate, iCapacity, jOnBuffer);
                            iCapacity = WebRtcAudioRecord.this.byteBuffer.capacity();
                        }
                        int i8 = iCapacity;
                        long j8 = jOnBuffer;
                        if (this.keepAlive && z7) {
                            WebRtcAudioRecord webRtcAudioRecord = WebRtcAudioRecord.this;
                            webRtcAudioRecord.nativeDataIsRecorded(webRtcAudioRecord.nativeAudioRecord, i8, j8);
                        }
                        if (WebRtcAudioRecord.this.audioSamplesReadyCallback != null) {
                            WebRtcAudioRecord.this.audioSamplesReadyCallback.onWebRtcAudioRecordSamplesReady(new JavaAudioDeviceModule.AudioSamples(WebRtcAudioRecord.this.audioFormat, WebRtcAudioRecord.this.channelCount, WebRtcAudioRecord.this.sampleRate, Arrays.copyOfRange(WebRtcAudioRecord.this.byteBuffer.array(), WebRtcAudioRecord.this.byteBuffer.arrayOffset(), WebRtcAudioRecord.this.byteBuffer.capacity() + WebRtcAudioRecord.this.byteBuffer.arrayOffset())));
                        }
                    }
                }
                try {
                    AudioRecord audioRecord5 = this.activeRecord;
                    if (audioRecord5 != null) {
                        audioRecord5.stop();
                    }
                } catch (IllegalStateException e8) {
                    Logging.e(WebRtcAudioRecord.TAG, "AudioRecord.stop failed: " + e8.getMessage());
                }
                this.cleanupDone.set(true);
                AudioRecord andSet = this.orphanedRecord.getAndSet(null);
                if (andSet != null) {
                    Logging.w(WebRtcAudioRecord.TAG, "Releasing orphaned AudioRecord after delayed thread exit");
                    try {
                        andSet.stop();
                    } catch (IllegalStateException unused) {
                    }
                    andSet.release();
                }
                WebRtcAudioRecord.this.doAudioRecordStateCallback(1);
                return;
            }
        }

        public void stopThread() {
            Logging.d(WebRtcAudioRecord.TAG, "stopThread");
            this.keepAlive = false;
        }

        public AudioRecord transferRecordOwnership(AudioRecord audioRecord) {
            this.orphanedRecord.set(audioRecord);
            if (this.cleanupDone.get()) {
                return this.orphanedRecord.getAndSet(null);
            }
            return null;
        }
    }

    @CalledByNative
    public WebRtcAudioRecord(Context context, AudioManager audioManager) {
        this(context, newDefaultScheduler(), audioManager, 7, 2, null, null, null, null, WebRtcAudioEffects.isAcousticEchoCancelerSupported(), WebRtcAudioEffects.isNoiseSuppressorSupported(), WebRtcAudioManager.getSampleRate(audioManager), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void assertTrue(boolean z7) {
        if (!z7) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    private static String audioStateToString(int i7) {
        return i7 != 0 ? i7 != 1 ? "INVALID" : "STOP" : "START";
    }

    private int channelCountToConfiguration(int i7) {
        return i7 == 1 ? 16 : 12;
    }

    @TargetApi(24)
    private static boolean checkDeviceMatch(AudioDeviceInfo audioDeviceInfo, AudioDeviceInfo audioDeviceInfo2) {
        return audioDeviceInfo.getId() == audioDeviceInfo2.getId() && audioDeviceInfo.getType() == audioDeviceInfo2.getType();
    }

    private static AudioRecord createAudioRecordOnLowerThanM(int i7, int i8, int i9, int i10, int i11) {
        Logging.d(TAG, "createAudioRecordOnLowerThanM");
        return new AudioRecord(i7, i8, i9, i10, i11);
    }

    @TargetApi(23)
    private static AudioRecord createAudioRecordOnMOrHigher(int i7, int i8, int i9, int i10, int i11) {
        Logging.d(TAG, "createAudioRecordOnMOrHigher");
        return new AudioRecord.Builder().setAudioSource(i7).setAudioFormat(new AudioFormat.Builder().setEncoding(i10).setSampleRate(i8).setChannelMask(i9).build()).setBufferSizeInBytes(i11).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAudioRecordStateCallback(int i7) {
        Logging.d(TAG, "doAudioRecordStateCallback: " + audioStateToString(i7));
        JavaAudioDeviceModule.AudioRecordStateCallback audioRecordStateCallback = this.stateCallback;
        if (audioRecordStateCallback != null) {
            if (i7 == 0) {
                audioRecordStateCallback.onWebRtcAudioRecordStart();
            } else if (i7 == 1) {
                audioRecordStateCallback.onWebRtcAudioRecordStop();
            } else {
                Logging.e(TAG, "Invalid audio state");
            }
        }
    }

    @CalledByNative
    private boolean enableBuiltInAEC(boolean z7) {
        Logging.d(TAG, "enableBuiltInAEC(" + z7 + ")");
        return this.effects.setAEC(z7);
    }

    @CalledByNative
    private boolean enableBuiltInNS(boolean z7) {
        Logging.d(TAG, "enableBuiltInNS(" + z7 + ")");
        return this.effects.setNS(z7);
    }

    private static int getBytesPerFrame(int i7, int i8) {
        return i7 * getBytesPerSample(i8);
    }

    private static int getBytesPerSample(int i7) {
        int i8 = 1;
        if (i7 != 1 && i7 != 2) {
            if (i7 != 3) {
                i8 = 4;
                if (i7 != 4) {
                    if (i7 != 13) {
                        throw new IllegalArgumentException("Bad audio format " + i7);
                    }
                }
            }
            return i8;
        }
        return 2;
    }

    private static int getFramesPerBuffer(int i7) {
        return i7 / 100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean initAudioRecord() {
        if (this.sampleRate == 0 || this.channelCount == 0) {
            Logging.w(TAG, "initAudioRecord called before initRecord!");
            return false;
        }
        synchronized (this.audioRecordStateLock) {
            try {
                if (this.audioRecord != null) {
                    reportWebRtcAudioRecordInitError("InitAudioRecord called twice without StopRecording.");
                    return false;
                }
                int iChannelCountToConfiguration = channelCountToConfiguration(this.channelCount);
                int minBufferSize = AudioRecord.getMinBufferSize(this.sampleRate, iChannelCountToConfiguration, this.audioFormat);
                if (minBufferSize != -1 && minBufferSize != -2) {
                    Logging.d(TAG, "AudioRecord.getMinBufferSize: " + minBufferSize);
                    int iMax = Math.max(minBufferSize * 2, this.byteBuffer.capacity());
                    Logging.d(TAG, "bufferSizeInBytes: " + iMax);
                    try {
                        this.audioRecord = createAudioRecordOnMOrHigher(this.audioSource, this.sampleRate, iChannelCountToConfiguration, this.audioFormat, iMax);
                        this.audioSourceMatchesRecordingSessionRef.set(null);
                        AudioDeviceInfo audioDeviceInfo = this.preferredDevice;
                        if (audioDeviceInfo != null) {
                            setPreferredDevice(audioDeviceInfo);
                        }
                        if (this.audioRecord != null && this.audioRecord.getState() == 1) {
                            this.effects.enable(this.audioRecord.getAudioSessionId());
                            logMainParameters();
                            logMainParametersExtended();
                            return true;
                        }
                        reportWebRtcAudioRecordInitError("Creation or initialization of audio recorder failed.");
                        releaseAudioResources();
                        return false;
                    } catch (IllegalArgumentException | UnsupportedOperationException e7) {
                        reportWebRtcAudioRecordInitError(e7.getMessage());
                        releaseAudioResources();
                        return false;
                    }
                }
                reportWebRtcAudioRecordInitError("AudioRecord.getMinBufferSize failed: " + minBufferSize);
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @CalledByNative
    private int initRecording(int i7, int i8) {
        Logging.d(TAG, "initRecording(sampleRate=" + i7 + ", channels=" + i8 + ")");
        synchronized (this.audioRecordStateLock) {
            try {
                if (!this.nativeCalledInitRecording.compareAndSet(false, true)) {
                    reportWebRtcAudioRecordInitError("InitRecording called twice without StopRecording.");
                    return -1;
                }
                if (this.audioRecord == null) {
                    return initRecordingImpl(i7, i8, true);
                }
                int framesPerBuffer = getFramesPerBuffer(i7);
                ByteBuffer byteBuffer = this.byteBuffer;
                if (byteBuffer == null) {
                    throw new IllegalStateException("initRecording: byteBuffer is null!");
                }
                nativeCacheDirectBufferAddress(this.nativeAudioRecord, byteBuffer);
                return framesPerBuffer;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private int initRecordingImpl(int i7, int i8, boolean z7) {
        Logging.d(TAG, "initRecordingImpl(sampleRate=" + i7 + ", channels=" + i8 + ")");
        if (this.audioRecord != null) {
            reportWebRtcAudioRecordInitError("InitRecording called twice without StopRecording.");
            return -1;
        }
        this.sampleRate = i7;
        this.channelCount = i8;
        int bytesPerFrame = getBytesPerFrame(i8, this.audioFormat);
        int framesPerBuffer = getFramesPerBuffer(i7);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bytesPerFrame * framesPerBuffer);
        this.byteBuffer = byteBufferAllocateDirect;
        if (!byteBufferAllocateDirect.hasArray()) {
            reportWebRtcAudioRecordInitError("ByteBuffer does not have backing array.");
            return -1;
        }
        Logging.d(TAG, "byteBuffer.capacity: " + this.byteBuffer.capacity());
        this.emptyBytes = new byte[this.byteBuffer.capacity()];
        if (z7) {
            nativeCacheDirectBufferAddress(this.nativeAudioRecord, this.byteBuffer);
        }
        if (this.useAudioRecord && !initAudioRecord()) {
            return -1;
        }
        int iLogRecordingConfigurations = logRecordingConfigurations(this.audioRecord, false);
        if (iLogRecordingConfigurations != 0) {
            Logging.w(TAG, "Potential microphone conflict. Active sessions: " + iLogRecordingConfigurations);
        }
        return framesPerBuffer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$scheduleLogRecordingConfigurationsTask$0(AudioRecord audioRecord) {
        if (this.audioRecord == audioRecord) {
            logRecordingConfigurations(audioRecord, true);
            return "Scheduled task is done";
        }
        Logging.d(TAG, "audio record has changed");
        return "Scheduled task is done";
    }

    @TargetApi(24)
    private static boolean logActiveRecordingConfigs(int i7, List<AudioRecordingConfiguration> list) {
        assertTrue(!list.isEmpty());
        Logging.d(TAG, "AudioRecordingConfigurations: ");
        for (AudioRecordingConfiguration audioRecordingConfiguration : list) {
            StringBuilder sb = new StringBuilder();
            int clientAudioSource = audioRecordingConfiguration.getClientAudioSource();
            sb.append("  client audio source=");
            sb.append(WebRtcAudioUtils.audioSourceToString(clientAudioSource));
            sb.append(", client session id=");
            sb.append(audioRecordingConfiguration.getClientAudioSessionId());
            sb.append(" (");
            sb.append(i7);
            sb.append(")");
            sb.append("\n");
            AudioFormat format = audioRecordingConfiguration.getFormat();
            sb.append("  Device AudioFormat: ");
            sb.append("channel count=");
            sb.append(format.getChannelCount());
            sb.append(", channel index mask=");
            sb.append(format.getChannelIndexMask());
            sb.append(", channel mask=");
            sb.append(WebRtcAudioUtils.channelMaskToString(format.getChannelMask()));
            sb.append(", encoding=");
            sb.append(WebRtcAudioUtils.audioEncodingToString(format.getEncoding()));
            sb.append(", sample rate=");
            sb.append(format.getSampleRate());
            sb.append("\n");
            AudioFormat clientFormat = audioRecordingConfiguration.getClientFormat();
            sb.append("  Client AudioFormat: ");
            sb.append("channel count=");
            sb.append(clientFormat.getChannelCount());
            sb.append(", channel index mask=");
            sb.append(clientFormat.getChannelIndexMask());
            sb.append(", channel mask=");
            sb.append(WebRtcAudioUtils.channelMaskToString(clientFormat.getChannelMask()));
            sb.append(", encoding=");
            sb.append(WebRtcAudioUtils.audioEncodingToString(clientFormat.getEncoding()));
            sb.append(", sample rate=");
            sb.append(clientFormat.getSampleRate());
            sb.append("\n");
            AudioDeviceInfo audioDevice = audioRecordingConfiguration.getAudioDevice();
            if (audioDevice != null) {
                assertTrue(audioDevice.isSource());
                sb.append("  AudioDevice: ");
                sb.append("type=");
                sb.append(WebRtcAudioUtils.deviceTypeToString(audioDevice.getType()));
                sb.append(", id=");
                sb.append(audioDevice.getId());
            }
            Logging.d(TAG, sb.toString());
        }
        return true;
    }

    private void logMainParameters() {
        synchronized (this.audioRecordStateLock) {
            try {
                if (this.audioRecord != null) {
                    Logging.d(TAG, "AudioRecord: session ID: " + this.audioRecord.getAudioSessionId() + ", channels: " + this.audioRecord.getChannelCount() + ", sample rate: " + this.audioRecord.getSampleRate());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @TargetApi(23)
    private void logMainParametersExtended() {
        synchronized (this.audioRecordStateLock) {
            try {
                if (this.audioRecord != null) {
                    Logging.d(TAG, "AudioRecord: buffer size in frames: " + this.audioRecord.getBufferSizeInFrames());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @TargetApi(24)
    private int logRecordingConfigurations(AudioRecord audioRecord, boolean z7) {
        if (audioRecord == null) {
            return 0;
        }
        List<AudioRecordingConfiguration> activeRecordingConfigurations = this.audioManager.getActiveRecordingConfigurations();
        int size = activeRecordingConfigurations.size();
        Logging.d(TAG, "Number of active recording sessions: " + size);
        if (size > 0) {
            logActiveRecordingConfigs(audioRecord.getAudioSessionId(), activeRecordingConfigurations);
            if (z7) {
                this.audioSourceMatchesRecordingSessionRef.set(Boolean.valueOf(verifyAudioConfig(audioRecord.getAudioSource(), audioRecord.getAudioSessionId(), audioRecord.getFormat(), audioRecord.getRoutedDevice(), activeRecordingConfigurations)));
            }
        }
        return size;
    }

    private native void nativeCacheDirectBufferAddress(long j7, ByteBuffer byteBuffer);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDataIsRecorded(long j7, int i7, long j8);

    public static ScheduledExecutorService newDefaultScheduler() {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        return Executors.newScheduledThreadPool(0, new ThreadFactory() { // from class: org.webrtc.audio.WebRtcAudioRecord.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
                threadNewThread.setName(String.format("WebRtcAudioRecordScheduler-%s-%s", Integer.valueOf(WebRtcAudioRecord.nextSchedulerId.getAndIncrement()), Integer.valueOf(atomicInteger.getAndIncrement())));
                return threadNewThread;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseAudioResources() {
        Logging.d(TAG, "releaseAudioResources");
        synchronized (this.audioRecordStateLock) {
            try {
                this.effects.release();
                if (this.audioRecord != null) {
                    this.audioRecord.release();
                    this.audioRecord = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.audioSourceMatchesRecordingSessionRef.set(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportWebRtcAudioRecordError(String str) {
        Logging.e(TAG, "Run-time recording error: " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback = this.errorCallback;
        if (audioRecordErrorCallback != null) {
            audioRecordErrorCallback.onWebRtcAudioRecordError(str);
        }
    }

    private void reportWebRtcAudioRecordInitError(String str) {
        Logging.e(TAG, "Init recording error: " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        logRecordingConfigurations(this.audioRecord, false);
        JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback = this.errorCallback;
        if (audioRecordErrorCallback != null) {
            audioRecordErrorCallback.onWebRtcAudioRecordInitError(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode audioRecordStartErrorCode, String str) {
        Logging.e(TAG, "Start recording error: " + String.valueOf(audioRecordStartErrorCode) + ". " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        logRecordingConfigurations(this.audioRecord, false);
        JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback = this.errorCallback;
        if (audioRecordErrorCallback != null) {
            audioRecordErrorCallback.onWebRtcAudioRecordStartError(audioRecordStartErrorCode, str);
        }
    }

    private void scheduleLogRecordingConfigurationsTask(final AudioRecord audioRecord) {
        Logging.d(TAG, "scheduleLogRecordingConfigurationsTask");
        Callable callable = new Callable() { // from class: org.webrtc.audio.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f20563a.lambda$scheduleLogRecordingConfigurationsTask$0(audioRecord);
            }
        };
        ScheduledFuture<String> scheduledFuture = this.future;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            this.future.cancel(true);
        }
        this.future = this.executor.schedule(callable, 100L, TimeUnit.MILLISECONDS);
    }

    private static boolean shouldUsePlatformEffect(boolean z7, AudioProcessingMode audioProcessingMode, boolean z8) {
        return z7 && z8 && audioProcessingMode != AudioProcessingMode.SOFTWARE;
    }

    @CalledByNative
    private boolean startRecording() {
        if (!this.nativeCalledStartRecording.compareAndSet(false, true)) {
            throw new IllegalStateException("startRecording called twice without stopRecording");
        }
        if (this.audioThread == null) {
            synchronized (this.audioRecordStateLock) {
                synchronized (this.audioThreadStateLock) {
                    if (this.audioThread == null) {
                        return startRecordingImpl();
                    }
                }
            }
        }
        return true;
    }

    private boolean startRecordingImpl() {
        Logging.d(TAG, "startRecording");
        synchronized (this.audioRecordStateLock) {
            synchronized (this.audioThreadStateLock) {
                assertTrue(this.audioThread == null);
                if (this.useAudioRecord) {
                    assertTrue(this.audioRecord != null);
                    try {
                        this.audioRecord.startRecording();
                        if (this.audioRecord.getRecordingState() != 3) {
                            reportWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH, "AudioRecord.startRecording failed - incorrect state: " + this.audioRecord.getRecordingState());
                            return false;
                        }
                    } catch (IllegalStateException e7) {
                        reportWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION, "AudioRecord.startRecording failed: " + e7.getMessage());
                        return false;
                    }
                }
                AudioRecordThread audioRecordThread = new AudioRecordThread("AudioRecordJavaThread");
                this.audioThread = audioRecordThread;
                audioRecordThread.start();
                scheduleLogRecordingConfigurationsTask(this.audioRecord);
                return true;
            }
        }
    }

    @CalledByNative
    private boolean stopRecording() {
        Logging.d(TAG, "stopRecording");
        synchronized (this.audioRecordStateLock) {
            this.nativeCalledStartRecording.set(false);
            this.nativeCalledInitRecording.set(false);
        }
        return stopRecordingIfNeededImpl();
    }

    private boolean stopRecordingIfNeededImpl() {
        AudioRecord audioRecordTransferRecordOwnership;
        synchronized (this.audioRecordStateLock) {
            try {
                if (!this.clientCalledStartRecording.get() && !this.nativeCalledStartRecording.get()) {
                    if (this.audioThread == null) {
                        return true;
                    }
                    Logging.d(TAG, "stopping recording");
                    ScheduledFuture<String> scheduledFuture = this.future;
                    if (scheduledFuture != null) {
                        if (!scheduledFuture.isDone()) {
                            this.future.cancel(true);
                        }
                        this.future = null;
                    }
                    AudioRecordThread audioRecordThread = this.audioThread;
                    this.audioThread = null;
                    audioRecordThread.stopThread();
                    AudioRecord audioRecord = this.audioRecord;
                    this.audioRecord = null;
                    this.effects.release();
                    this.audioSourceMatchesRecordingSessionRef.set(null);
                    if (audioRecord != null) {
                        try {
                            audioRecord.stop();
                        } catch (IllegalStateException e7) {
                            Logging.e(TAG, "AudioRecord.stop failed: " + e7.getMessage());
                        }
                    }
                    if (ThreadUtils.joinUninterruptibly(audioRecordThread, AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS)) {
                        if (audioRecord != null) {
                            audioRecord.release();
                        }
                        return true;
                    }
                    Logging.e(TAG, "Join of AudioRecordJavaThread timed out");
                    WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
                    if (audioRecord != null && (audioRecordTransferRecordOwnership = audioRecordThread.transferRecordOwnership(audioRecord)) != null) {
                        audioRecordTransferRecordOwnership.release();
                    }
                    return true;
                }
                return true;
            } finally {
            }
        }
    }

    @TargetApi(24)
    private static boolean verifyAudioConfig(int i7, int i8, AudioFormat audioFormat, AudioDeviceInfo audioDeviceInfo, List<AudioRecordingConfiguration> list) {
        assertTrue(!list.isEmpty());
        for (AudioRecordingConfiguration audioRecordingConfiguration : list) {
            AudioDeviceInfo audioDevice = audioRecordingConfiguration.getAudioDevice();
            if (audioDevice != null && audioRecordingConfiguration.getClientAudioSource() == i7 && audioRecordingConfiguration.getClientAudioSessionId() == i8 && audioRecordingConfiguration.getClientFormat().getEncoding() == audioFormat.getEncoding() && audioRecordingConfiguration.getClientFormat().getSampleRate() == audioFormat.getSampleRate() && audioRecordingConfiguration.getClientFormat().getChannelMask() == audioFormat.getChannelMask() && audioRecordingConfiguration.getClientFormat().getChannelIndexMask() == audioFormat.getChannelIndexMask() && audioRecordingConfiguration.getFormat().getEncoding() != 0 && audioRecordingConfiguration.getFormat().getSampleRate() > 0 && (audioRecordingConfiguration.getFormat().getChannelMask() != 0 || audioRecordingConfiguration.getFormat().getChannelIndexMask() != 0)) {
                if (checkDeviceMatch(audioDevice, audioDeviceInfo)) {
                    Logging.d(TAG, "verifyAudioConfig: PASS");
                    return true;
                }
            }
        }
        Logging.e(TAG, "verifyAudioConfig: FAILED");
        return false;
    }

    public void applyPlatformAudioProcessingOptions(AudioProcessingOptions audioProcessingOptions) {
        if (audioProcessingOptions == null) {
            return;
        }
        this.effects.setAEC(shouldUsePlatformEffect(audioProcessingOptions.echoCancellation, audioProcessingOptions.echoCancellationMode, this.isAcousticEchoCancelerSupported));
        this.effects.setNS(shouldUsePlatformEffect(audioProcessingOptions.noiseSuppression, audioProcessingOptions.noiseSuppressionMode, this.isNoiseSuppressorSupported));
    }

    public WebRtcAudioEffects.State getBuiltInAudioEffectsState() {
        return this.effects.getState();
    }

    @CalledByNative
    public boolean hasBuiltInAEC() {
        return this.effects.hasAEC();
    }

    @CalledByNative
    public boolean hasBuiltInNS() {
        return this.effects.hasNS();
    }

    public boolean initRecordingIfNeeded() {
        synchronized (this.audioRecordStateLock) {
            try {
                boolean z7 = true;
                if (this.audioRecord != null) {
                    return true;
                }
                if (initRecordingImpl(this.expectedSampleRate, this.expectedChannelCount, false) < 0) {
                    z7 = false;
                }
                return z7;
            } finally {
            }
        }
    }

    @CalledByNative
    public boolean isAcousticEchoCancelerSupported() {
        return this.isAcousticEchoCancelerSupported;
    }

    @CalledByNative
    public boolean isAudioConfigVerified() {
        return this.audioSourceMatchesRecordingSessionRef.get() != null;
    }

    @CalledByNative
    public boolean isAudioSourceMatchingRecordingSession() {
        Boolean bool = this.audioSourceMatchesRecordingSessionRef.get();
        if (bool != null) {
            return bool.booleanValue();
        }
        Logging.w(TAG, "Audio configuration has not yet been verified");
        return false;
    }

    @CalledByNative
    public boolean isBuiltInAECEnabled() {
        return this.effects.isAECEnabled();
    }

    @CalledByNative
    public boolean isBuiltInAECRequested() {
        return this.effects.shouldEnableAEC();
    }

    @CalledByNative
    public boolean isBuiltInNSEnabled() {
        return this.effects.isNSEnabled();
    }

    @CalledByNative
    public boolean isBuiltInNSRequested() {
        return this.effects.shouldEnableNS();
    }

    @CalledByNative
    public boolean isNoiseSuppressorSupported() {
        return this.isNoiseSuppressorSupported;
    }

    public boolean prewarmRecordingIfNeeded() {
        if (this.audioThread != null) {
            return true;
        }
        synchronized (this.audioRecordStateLock) {
            synchronized (this.audioThreadStateLock) {
                if (this.audioThread != null) {
                    return true;
                }
                return startRecordingImpl();
            }
        }
    }

    public void setMicrophoneMute(boolean z7) {
        Logging.w(TAG, "setMicrophoneMute(" + z7 + ")");
        this.microphoneMute = z7;
    }

    @CalledByNative
    public void setNativeAudioRecord(long j7) {
        this.nativeAudioRecord = j7;
    }

    public boolean setNoiseSuppressorEnabled(boolean z7) {
        if (!WebRtcAudioEffects.isNoiseSuppressorSupported()) {
            Logging.e(TAG, "Noise suppressor is not supported.");
            return false;
        }
        Logging.w(TAG, "SetNoiseSuppressorEnabled(" + z7 + ")");
        return this.effects.toggleNS(z7);
    }

    @TargetApi(23)
    public void setPreferredDevice(AudioDeviceInfo audioDeviceInfo) {
        Logging.d(TAG, "setPreferredDevice " + (audioDeviceInfo != null ? Integer.valueOf(audioDeviceInfo.getId()) : null));
        this.preferredDevice = audioDeviceInfo;
        if (this.audioRecord == null || this.audioRecord.setPreferredDevice(audioDeviceInfo)) {
            return;
        }
        Logging.e(TAG, "setPreferredDevice failed");
    }

    public void setUseAudioRecord(boolean z7) {
        Logging.d(TAG, "setUseAudioRecord(" + z7 + ")");
        this.useAudioRecord = z7;
    }

    public boolean startRecordingIfNeeded() {
        this.clientCalledStartRecording.set(true);
        if (this.audioThread == null) {
            synchronized (this.audioRecordStateLock) {
                synchronized (this.audioThreadStateLock) {
                    if (this.audioThread == null) {
                        return startRecordingImpl();
                    }
                }
            }
        }
        return true;
    }

    public boolean stopRecordingIfNeeded() {
        Logging.d(TAG, "stopRecordingIfNeeded");
        synchronized (this.audioRecordStateLock) {
            try {
                this.clientCalledStartRecording.set(false);
                if (this.audioThread == null) {
                    return true;
                }
                return stopRecordingIfNeededImpl();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public WebRtcAudioRecord(Context context, ScheduledExecutorService scheduledExecutorService, AudioManager audioManager, int i7, int i8, JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback, JavaAudioDeviceModule.AudioRecordStateCallback audioRecordStateCallback, JavaAudioDeviceModule.SamplesReadyCallback samplesReadyCallback, JavaAudioDeviceModule.AudioBufferCallback audioBufferCallback, boolean z7, boolean z8, int i9, int i10) {
        this.effects = new WebRtcAudioEffects();
        this.audioRecordStateLock = new Object();
        this.useAudioRecord = true;
        this.audioThreadStateLock = new Object();
        this.audioSourceMatchesRecordingSessionRef = new AtomicReference<>();
        this.clientCalledStartRecording = new AtomicBoolean(false);
        this.nativeCalledInitRecording = new AtomicBoolean(false);
        this.nativeCalledStartRecording = new AtomicBoolean(false);
        if (z7 && !WebRtcAudioEffects.isAcousticEchoCancelerSupported()) {
            throw new IllegalArgumentException("HW AEC not supported");
        }
        if (z8 && !WebRtcAudioEffects.isNoiseSuppressorSupported()) {
            throw new IllegalArgumentException("HW NS not supported");
        }
        this.context = context;
        this.executor = scheduledExecutorService;
        this.audioManager = audioManager;
        this.audioSource = i7;
        this.audioFormat = i8;
        this.errorCallback = audioRecordErrorCallback;
        this.stateCallback = audioRecordStateCallback;
        this.audioSamplesReadyCallback = samplesReadyCallback;
        this.audioBufferCallback = audioBufferCallback;
        this.isAcousticEchoCancelerSupported = z7;
        this.isNoiseSuppressorSupported = z8;
        this.expectedSampleRate = i9;
        this.expectedChannelCount = i10;
        Logging.d(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
    }
}
