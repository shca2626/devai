package com.cloudwebrtc.webrtc.record;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import java.nio.ByteBuffer;
import org.webrtc.audio.JavaAudioDeviceModule;

/* loaded from: classes.dex */
public final class AudioTrackInterceptor extends AudioTrack {
    private final JavaAudioDeviceModule.SamplesReadyCallback callback;
    public final AudioTrack originalTrack;

    public AudioTrackInterceptor(AudioTrack audioTrack, JavaAudioDeviceModule.SamplesReadyCallback samplesReadyCallback) {
        super(0, 44200, 4, 2, 128, 1);
        this.originalTrack = audioTrack;
        this.callback = samplesReadyCallback;
    }

    @Override // android.media.AudioTrack
    @TargetApi(24)
    public int getBufferCapacityInFrames() {
        return this.originalTrack.getBufferCapacityInFrames();
    }

    @Override // android.media.AudioTrack
    @TargetApi(23)
    public int getBufferSizeInFrames() {
        return this.originalTrack.getBufferSizeInFrames();
    }

    @Override // android.media.AudioTrack
    public int getPlayState() {
        return this.originalTrack.getPlayState();
    }

    @Override // android.media.AudioTrack
    public int getPlaybackHeadPosition() {
        return this.originalTrack.getPlaybackHeadPosition();
    }

    @Override // android.media.AudioTrack
    @TargetApi(24)
    public int getUnderrunCount() {
        return this.originalTrack.getUnderrunCount();
    }

    @Override // android.media.AudioTrack
    public void play() throws IllegalStateException {
        this.originalTrack.play();
    }

    @Override // android.media.AudioTrack
    public void release() {
        this.originalTrack.release();
    }

    @Override // android.media.AudioTrack
    public void stop() throws IllegalStateException {
        this.originalTrack.stop();
    }

    @Override // android.media.AudioTrack
    public int write(byte[] bArr, int i7, int i8) {
        this.callback.onWebRtcAudioRecordSamplesReady(new JavaAudioDeviceModule.AudioSamples(this.originalTrack.getAudioFormat(), this.originalTrack.getChannelCount(), this.originalTrack.getSampleRate(), bArr));
        return this.originalTrack.write(bArr, i7, i8);
    }

    @Override // android.media.AudioTrack
    @TargetApi(21)
    public int write(ByteBuffer byteBuffer, int i7, int i8) {
        byte[] bArr = new byte[i7];
        int iPosition = byteBuffer.position();
        byteBuffer.get(bArr, 0, i7);
        byteBuffer.position(iPosition);
        this.callback.onWebRtcAudioRecordSamplesReady(new JavaAudioDeviceModule.AudioSamples(this.originalTrack.getAudioFormat(), this.originalTrack.getChannelCount(), this.originalTrack.getSampleRate(), bArr));
        return this.originalTrack.write(byteBuffer, i7, i8);
    }
}
