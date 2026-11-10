package com.cloudwebrtc.webrtc.record;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.webrtc.EglBase;
import org.webrtc.GlRectDrawer;
import org.webrtc.VideoFrame;
import org.webrtc.VideoFrameDrawer;
import org.webrtc.VideoSink;
import org.webrtc.audio.JavaAudioDeviceModule;

/* loaded from: classes.dex */
class VideoFileRenderer implements VideoSink, JavaAudioDeviceModule.SamplesReadyCallback {
    private static final int FRAME_RATE = 30;
    private static final int IFRAME_INTERVAL = 5;
    private static final String MIME_TYPE = "video/avc";
    private static final String TAG = "VideoFileRenderer";
    private MediaCodec.BufferInfo audioBufferInfo;
    private MediaCodec audioEncoder;
    private ByteBuffer[] audioInputBuffers;
    private ByteBuffer[] audioOutputBuffers;
    private final HandlerThread audioThread;
    private final Handler audioThreadHandler;
    private int audioTrackIndex;
    private final MediaCodec.BufferInfo bufferInfo;
    private GlRectDrawer drawer;
    private EglBase eglBase;
    private MediaCodec encoder;
    private ByteBuffer[] encoderOutputBuffers;
    private VideoFrameDrawer frameDrawer;
    private final MediaMuxer mediaMuxer;
    private final HandlerThread renderThread;
    private final Handler renderThreadHandler;
    private final EglBase.Context sharedContext;
    private Surface surface;
    private int outputFileWidth = -1;
    private int outputFileHeight = -1;
    private int trackIndex = -1;
    private boolean isRunning = true;
    private boolean encoderInitFailed = false;
    private boolean encoderInitializing = false;
    private boolean encoderStarted = false;
    private volatile boolean muxerStarted = false;
    private long videoFrameStart = 0;
    private long presTime = 0;

    public VideoFileRenderer(String str, EglBase.Context context, boolean z7) {
        HandlerThread handlerThread = new HandlerThread("VideoFileRendererRenderThread");
        this.renderThread = handlerThread;
        handlerThread.start();
        this.renderThreadHandler = new Handler(handlerThread.getLooper());
        if (z7) {
            HandlerThread handlerThread2 = new HandlerThread("VideoFileRendererAudioThread");
            this.audioThread = handlerThread2;
            handlerThread2.start();
            this.audioThreadHandler = new Handler(handlerThread2.getLooper());
        } else {
            this.audioThread = null;
            this.audioThreadHandler = null;
        }
        this.bufferInfo = new MediaCodec.BufferInfo();
        this.sharedContext = context;
        this.mediaMuxer = new MediaMuxer(str, 0);
        this.audioTrackIndex = z7 ? -1 : 0;
    }

    public static /* synthetic */ void a(VideoFileRenderer videoFileRenderer, JavaAudioDeviceModule.AudioSamples audioSamples) throws MediaCodec.CryptoException {
        if (videoFileRenderer.audioEncoder == null) {
            try {
                videoFileRenderer.audioEncoder = MediaCodec.createEncoderByType("audio/mp4a-latm");
                MediaFormat mediaFormat = new MediaFormat();
                mediaFormat.setString("mime", "audio/mp4a-latm");
                mediaFormat.setInteger("channel-count", audioSamples.getChannelCount());
                mediaFormat.setInteger("sample-rate", audioSamples.getSampleRate());
                mediaFormat.setInteger("bitrate", 65536);
                mediaFormat.setInteger("aac-profile", 2);
                videoFileRenderer.audioEncoder.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
                videoFileRenderer.audioEncoder.start();
                videoFileRenderer.audioInputBuffers = videoFileRenderer.audioEncoder.getInputBuffers();
                videoFileRenderer.audioOutputBuffers = videoFileRenderer.audioEncoder.getOutputBuffers();
            } catch (IOException e7) {
                Log.wtf(TAG, e7);
            }
        }
        int iDequeueInputBuffer = videoFileRenderer.audioEncoder.dequeueInputBuffer(0L);
        if (iDequeueInputBuffer >= 0) {
            ByteBuffer byteBuffer = videoFileRenderer.audioInputBuffers[iDequeueInputBuffer];
            byteBuffer.clear();
            byte[] data = audioSamples.getData();
            byteBuffer.put(data);
            videoFileRenderer.audioEncoder.queueInputBuffer(iDequeueInputBuffer, 0, data.length, videoFileRenderer.presTime, 0);
            videoFileRenderer.presTime += (data.length * 125) / 12;
        }
        videoFileRenderer.drainAudio();
    }

    public static /* synthetic */ void c(VideoFileRenderer videoFileRenderer, CountDownLatch countDownLatch) {
        videoFileRenderer.getClass();
        try {
            MediaCodec mediaCodec = videoFileRenderer.audioEncoder;
            if (mediaCodec != null) {
                mediaCodec.stop();
                videoFileRenderer.audioEncoder.release();
            }
            videoFileRenderer.audioThread.quit();
            countDownLatch.countDown();
        } catch (Throwable th) {
            countDownLatch.countDown();
            throw th;
        }
    }

    private boolean containsResolution(List<int[]> list, int i7, int i8) {
        boolean z7;
        Iterator<int[]> it = list.iterator();
        while (true) {
            z7 = false;
            if (!it.hasNext()) {
                break;
            }
            int[] next = it.next();
            if (next[0] == i7) {
                z7 = true;
                if (next[1] == i8) {
                    break;
                }
            }
        }
        return z7;
    }

    public static /* synthetic */ void d(VideoFileRenderer videoFileRenderer, CountDownLatch countDownLatch) {
        videoFileRenderer.getClass();
        try {
            MediaCodec mediaCodec = videoFileRenderer.encoder;
            if (mediaCodec != null) {
                mediaCodec.stop();
                videoFileRenderer.encoder.release();
            }
            EglBase eglBase = videoFileRenderer.eglBase;
            if (eglBase != null) {
                eglBase.release();
                videoFileRenderer.eglBase = null;
            }
            if (videoFileRenderer.muxerStarted) {
                videoFileRenderer.mediaMuxer.stop();
                videoFileRenderer.mediaMuxer.release();
                videoFileRenderer.muxerStarted = false;
            }
            videoFileRenderer.renderThread.quit();
            countDownLatch.countDown();
        } catch (Throwable th) {
            countDownLatch.countDown();
            throw th;
        }
    }

    private void drainAudio() {
        int i7;
        if (this.audioBufferInfo == null) {
            this.audioBufferInfo = new MediaCodec.BufferInfo();
        }
        while (true) {
            int iDequeueOutputBuffer = this.audioEncoder.dequeueOutputBuffer(this.audioBufferInfo, 1000L);
            if (iDequeueOutputBuffer == -1) {
                return;
            }
            if (iDequeueOutputBuffer == -3) {
                this.audioOutputBuffers = this.audioEncoder.getOutputBuffers();
                Log.w(TAG, "encoder output buffers changed");
            } else {
                boolean z7 = true;
                if (iDequeueOutputBuffer == -2) {
                    MediaFormat outputFormat = this.audioEncoder.getOutputFormat();
                    Log.w(TAG, "encoder output format changed: " + outputFormat);
                    int iAddTrack = this.mediaMuxer.addTrack(outputFormat);
                    this.audioTrackIndex = iAddTrack;
                    if (this.trackIndex != -1 && iAddTrack != -1 && !this.muxerStarted) {
                        this.mediaMuxer.start();
                        this.muxerStarted = true;
                    }
                    if (!this.muxerStarted) {
                        return;
                    }
                } else if (iDequeueOutputBuffer < 0) {
                    Log.e(TAG, "unexpected result from encoder.dequeueOutputBuffer: " + iDequeueOutputBuffer);
                } else {
                    try {
                        ByteBuffer byteBuffer = this.audioOutputBuffers[iDequeueOutputBuffer];
                        if (byteBuffer == null) {
                            Log.e(TAG, "encoderOutputBuffer " + iDequeueOutputBuffer + " was null");
                            return;
                        }
                        MediaCodec.BufferInfo bufferInfo = this.audioBufferInfo;
                        if ((bufferInfo.flags & 2) != 0) {
                            bufferInfo.size = 0;
                        }
                        if (bufferInfo.size <= 0 || (i7 = bufferInfo.offset) < 0) {
                            this.audioEncoder.releaseOutputBuffer(iDequeueOutputBuffer, false);
                            if ((this.audioBufferInfo.flags & 4) != 0) {
                                return;
                            }
                        } else {
                            byteBuffer.position(i7);
                            MediaCodec.BufferInfo bufferInfo2 = this.audioBufferInfo;
                            byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                            if (this.muxerStarted) {
                                this.mediaMuxer.writeSampleData(this.audioTrackIndex, byteBuffer, this.audioBufferInfo);
                            }
                            if (!this.isRunning || (this.audioBufferInfo.flags & 4) != 0) {
                                z7 = false;
                            }
                            this.isRunning = z7;
                            this.audioEncoder.releaseOutputBuffer(iDequeueOutputBuffer, false);
                            if ((this.audioBufferInfo.flags & 4) != 0) {
                                return;
                            }
                        }
                    } catch (Exception e7) {
                        Log.wtf(TAG, e7);
                        return;
                    }
                }
            }
        }
    }

    private void drainEncoder() {
        int i7;
        while (true) {
            int iDequeueOutputBuffer = this.encoder.dequeueOutputBuffer(this.bufferInfo, 10000L);
            if (iDequeueOutputBuffer == -1) {
                return;
            }
            if (iDequeueOutputBuffer == -3) {
                this.encoderOutputBuffers = this.encoder.getOutputBuffers();
                Log.e(TAG, "encoder output buffers changed");
            } else {
                boolean z7 = true;
                if (iDequeueOutputBuffer == -2) {
                    MediaFormat outputFormat = this.encoder.getOutputFormat();
                    Log.e(TAG, "encoder output format changed: " + outputFormat);
                    int iAddTrack = this.mediaMuxer.addTrack(outputFormat);
                    this.trackIndex = iAddTrack;
                    if (iAddTrack != -1 && this.audioTrackIndex != -1 && !this.muxerStarted) {
                        this.mediaMuxer.start();
                        this.muxerStarted = true;
                    }
                    if (!this.muxerStarted) {
                        return;
                    }
                } else if (iDequeueOutputBuffer < 0) {
                    Log.e(TAG, "unexpected result fr om encoder.dequeueOutputBuffer: " + iDequeueOutputBuffer);
                } else {
                    try {
                        ByteBuffer byteBuffer = this.encoderOutputBuffers[iDequeueOutputBuffer];
                        if (byteBuffer == null) {
                            Log.e(TAG, "encoderOutputBuffer " + iDequeueOutputBuffer + " was null");
                            return;
                        }
                        MediaCodec.BufferInfo bufferInfo = this.bufferInfo;
                        if ((bufferInfo.flags & 2) != 0) {
                            bufferInfo.size = 0;
                        }
                        if (bufferInfo.size <= 0 || (i7 = bufferInfo.offset) < 0) {
                            this.encoder.releaseOutputBuffer(iDequeueOutputBuffer, false);
                            if ((this.bufferInfo.flags & 4) != 0) {
                                return;
                            }
                        } else {
                            byteBuffer.position(i7);
                            MediaCodec.BufferInfo bufferInfo2 = this.bufferInfo;
                            byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                            if (this.videoFrameStart == 0) {
                                long j7 = this.bufferInfo.presentationTimeUs;
                                if (j7 != 0) {
                                    this.videoFrameStart = j7;
                                }
                            }
                            MediaCodec.BufferInfo bufferInfo3 = this.bufferInfo;
                            bufferInfo3.presentationTimeUs = Math.max(0L, bufferInfo3.presentationTimeUs - this.videoFrameStart);
                            if (this.muxerStarted) {
                                this.mediaMuxer.writeSampleData(this.trackIndex, byteBuffer, this.bufferInfo);
                            }
                            if (!this.isRunning || (this.bufferInfo.flags & 4) != 0) {
                                z7 = false;
                            }
                            this.isRunning = z7;
                            this.encoder.releaseOutputBuffer(iDequeueOutputBuffer, false);
                            if ((this.bufferInfo.flags & 4) != 0) {
                                return;
                            }
                        }
                    } catch (Exception e7) {
                        Log.wtf(TAG, e7);
                        return;
                    }
                }
            }
        }
    }

    public static /* synthetic */ void e(VideoFileRenderer videoFileRenderer, EncoderConfig encoderConfig, CountDownLatch countDownLatch) {
        videoFileRenderer.getClass();
        try {
            EglBase.Context context = videoFileRenderer.sharedContext;
            boolean z7 = context != null ? videoFileRenderer.setupEncoderSurface(context, "shared") : false;
            if (!z7) {
                z7 = videoFileRenderer.setupEncoderSurface(null, "standalone");
            }
            videoFileRenderer.encoderStarted = z7;
            if (!z7) {
                videoFileRenderer.resetVideoEncoderState();
                videoFileRenderer.releaseVideoEncoderResources();
                Log.e(TAG, "Failed to setup EGL surface for config: " + encoderConfig);
            }
            videoFileRenderer.encoderInitializing = false;
            countDownLatch.countDown();
        } catch (Throwable th) {
            videoFileRenderer.encoderInitializing = false;
            countDownLatch.countDown();
            throw th;
        }
    }

    private List<EncoderConfig> getSupportedConfigurations(int i7, int i8) {
        int i9;
        int[] iArr = {6000000, 4000000, 2000000, 1000000};
        boolean z7 = true;
        int[] iArr2 = {1, 2, 8};
        ArrayList arrayList = new ArrayList();
        arrayList.add(new int[]{i7, i8});
        for (int[] iArr3 : Arrays.asList(new int[]{1920, 1080}, new int[]{1280, 720}, new int[]{854, 480}, new int[]{640, 360}, new int[]{426, 240})) {
            int i10 = iArr3[0];
            if (i10 <= i7 && (i9 = iArr3[1]) <= i8 && !containsResolution(arrayList, i10, i9)) {
                arrayList.add(iArr3);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            int[] iArr4 = (int[]) obj;
            for (int i12 = 0; i12 < 4; i12++) {
                int i13 = iArr[i12];
                int i14 = 0;
                while (i14 < 3) {
                    boolean z8 = z7;
                    arrayList2.add(new EncoderConfig(iArr4[0], iArr4[z8 ? 1 : 0], i13, iArr2[i14]));
                    i14++;
                    z7 = z8 ? 1 : 0;
                }
            }
        }
        Collections.sort(arrayList2, new Comparator<EncoderConfig>() { // from class: com.cloudwebrtc.webrtc.record.VideoFileRenderer.1
            @Override // java.util.Comparator
            public int compare(EncoderConfig encoderConfig, EncoderConfig encoderConfig2) {
                int iCompare = Integer.compare(encoderConfig2.width * encoderConfig2.height, encoderConfig.width * encoderConfig.height);
                if (iCompare != 0) {
                    return iCompare;
                }
                int iCompare2 = Integer.compare(encoderConfig2.bitrate, encoderConfig.bitrate);
                return iCompare2 != 0 ? iCompare2 : Integer.compare(encoderConfig.profile, encoderConfig2.profile);
            }
        });
        return arrayList2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void initVideoEncoder(int r11, int r12) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloudwebrtc.webrtc.record.VideoFileRenderer.initVideoEncoder(int, int):void");
    }

    private boolean isProfileSupported(MediaCodecInfo mediaCodecInfo, String str, int i7) {
        try {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : mediaCodecInfo.getCapabilitiesForType(str).profileLevels) {
                if (codecProfileLevel.profile == i7) {
                    return true;
                }
            }
        } catch (Exception e7) {
            Log.w(TAG, "Failed to check profile support: " + e7.getMessage());
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void releaseVideoEncoderResources() {
        this.drawer = null;
        this.frameDrawer = null;
        EglBase eglBase = this.eglBase;
        try {
            if (eglBase != null) {
                try {
                    eglBase.release();
                } catch (Exception e7) {
                    Log.w(TAG, "Failed to release EGL base", e7);
                }
            }
            Surface surface = this.surface;
            if (surface != null) {
                try {
                    try {
                        surface.release();
                    } catch (Exception e8) {
                        Log.w(TAG, "Failed to release input surface", e8);
                    }
                } finally {
                    this.surface = null;
                }
            }
            MediaCodec mediaCodec = this.encoder;
            if (mediaCodec != null) {
                try {
                    mediaCodec.stop();
                } catch (Exception e9) {
                    Log.w(TAG, "Failed to stop encoder during cleanup", e9);
                }
                try {
                    try {
                        this.encoder.release();
                    } catch (Exception e10) {
                        Log.w(TAG, "Failed to release encoder during cleanup", e10);
                    }
                } finally {
                    this.encoder = null;
                }
            }
        } finally {
            this.eglBase = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderFrameOnRenderThread(VideoFrame videoFrame) {
        if (!this.encoderStarted || this.drawer == null || this.eglBase == null || this.encoder == null) {
            Log.e(TAG, "drawer is null — skipping frame render");
            videoFrame.release();
            return;
        }
        if (this.frameDrawer == null) {
            this.frameDrawer = new VideoFrameDrawer();
        }
        this.frameDrawer.drawFrame(videoFrame, this.drawer, null, 0, 0, this.outputFileWidth, this.outputFileHeight);
        videoFrame.release();
        this.eglBase.swapBuffers();
        drainEncoder();
    }

    private void resetVideoEncoderState() {
        this.encoderStarted = false;
        this.outputFileWidth = -1;
        this.outputFileHeight = -1;
        this.encoderOutputBuffers = null;
        this.trackIndex = -1;
        this.videoFrameStart = 0L;
    }

    private boolean setupEncoderSurface(EglBase.Context context, String str) {
        try {
            this.eglBase = EglBase.create(context, EglBase.CONFIG_RECORDABLE);
            Log.d(TAG, "EGL context created with " + str + " context");
            this.eglBase.createSurface(this.surface);
            this.eglBase.makeCurrent();
            this.drawer = new GlRectDrawer();
            Log.d(TAG, "Encoder surface setup complete (" + str + "): " + this.surface);
            return true;
        } catch (Exception e7) {
            Log.w(TAG, "Failed to setup EGL surface with " + str + " context", e7);
            EglBase eglBase = this.eglBase;
            if (eglBase != null) {
                try {
                    try {
                        eglBase.release();
                    } catch (Exception e8) {
                        Log.w(TAG, "Failed to release EGL base after setup failure", e8);
                    }
                } finally {
                    this.eglBase = null;
                }
            }
            this.drawer = null;
            return false;
        }
    }

    private boolean shouldForceCodecProfile(String str) {
        if (str == null) {
            return true;
        }
        return (str.startsWith("OMX.qcom.") || "OMX.hisi.video.encoder.avc".equals(str)) ? false : true;
    }

    private boolean startEncoder() {
        try {
            this.encoder.start();
            this.encoderOutputBuffers = this.encoder.getOutputBuffers();
            Log.d(TAG, "Encoder started successfully");
            return true;
        } catch (Exception e7) {
            Log.w(TAG, "Failed to start encoder: " + e7.getMessage());
            Surface surface = this.surface;
            if (surface != null) {
                surface.release();
                this.surface = null;
            }
            MediaCodec mediaCodec = this.encoder;
            if (mediaCodec == null) {
                return false;
            }
            try {
                mediaCodec.release();
            } catch (Exception unused) {
            }
            this.encoder = null;
            return false;
        }
    }

    private boolean tryConfigureEncoder(EncoderConfig encoderConfig) throws IOException {
        try {
            MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(MIME_TYPE, encoderConfig.width, encoderConfig.height);
            mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
            mediaFormatCreateVideoFormat.setInteger("bitrate", encoderConfig.bitrate);
            mediaFormatCreateVideoFormat.setInteger("frame-rate", FRAME_RATE);
            mediaFormatCreateVideoFormat.setInteger("i-frame-interval", 5);
            Log.d(TAG, "Trying encoder config: " + encoderConfig);
            MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType(MIME_TYPE);
            this.encoder = mediaCodecCreateEncoderByType;
            String name = mediaCodecCreateEncoderByType.getName();
            Log.d(TAG, "Codec name: " + name);
            if (shouldForceCodecProfile(name)) {
                mediaFormatCreateVideoFormat.setInteger("profile", encoderConfig.profile);
            } else {
                Log.w(TAG, "Skip explicit H264 profile for codec: " + name);
            }
            this.encoder.configure(mediaFormatCreateVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            this.surface = this.encoder.createInputSurface();
            Log.d(TAG, "Input surface created successfully: " + this.surface);
            return true;
        } catch (Exception e7) {
            Log.w(TAG, "Failed to configure encoder for config: " + encoderConfig + ", error: " + e7.getMessage());
            Surface surface = this.surface;
            if (surface != null) {
                surface.release();
                this.surface = null;
            }
            MediaCodec mediaCodec = this.encoder;
            if (mediaCodec == null) {
                return false;
            }
            try {
                mediaCodec.release();
            } catch (Exception unused) {
            }
            this.encoder = null;
            return false;
        }
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(final VideoFrame videoFrame) throws InterruptedException, IOException {
        if (!this.isRunning || this.encoderInitFailed) {
            return;
        }
        videoFrame.retain();
        if (this.outputFileWidth == -1 && !this.encoderInitializing) {
            this.encoderInitializing = true;
            initVideoEncoder(videoFrame.getRotatedWidth(), videoFrame.getRotatedHeight());
        }
        if (!this.encoderStarted || this.outputFileWidth == -1 || this.outputFileHeight == -1) {
            videoFrame.release();
        } else {
            this.renderThreadHandler.post(new Runnable() { // from class: com.cloudwebrtc.webrtc.record.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f14127l.renderFrameOnRenderThread(videoFrame);
                }
            });
        }
    }

    @Override // org.webrtc.audio.JavaAudioDeviceModule.SamplesReadyCallback
    public void onWebRtcAudioRecordSamplesReady(final JavaAudioDeviceModule.AudioSamples audioSamples) {
        if (this.isRunning) {
            this.audioThreadHandler.post(new Runnable() { // from class: com.cloudwebrtc.webrtc.record.h
                @Override // java.lang.Runnable
                public final void run() throws MediaCodec.CryptoException {
                    VideoFileRenderer.a(this.f14125l, audioSamples);
                }
            });
        }
    }

    public void release() throws InterruptedException {
        this.isRunning = false;
        final CountDownLatch countDownLatch = new CountDownLatch(this.audioThreadHandler != null ? 2 : 1);
        Handler handler = this.audioThreadHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.cloudwebrtc.webrtc.record.f
                @Override // java.lang.Runnable
                public final void run() {
                    VideoFileRenderer.c(this.f14121l, countDownLatch);
                }
            });
        }
        this.renderThreadHandler.post(new Runnable() { // from class: com.cloudwebrtc.webrtc.record.g
            @Override // java.lang.Runnable
            public final void run() {
                VideoFileRenderer.d(this.f14123l, countDownLatch);
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e7) {
            Log.e(TAG, "Release interrupted", e7);
            Thread.currentThread().interrupt();
        }
    }
}
