package com.cloudwebrtc.webrtc.audio;

import android.os.SystemClock;
import com.cloudwebrtc.webrtc.LocalTrack;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.webrtc.AudioTrack;
import org.webrtc.AudioTrackSink;
import org.webrtc.audio.JavaAudioDeviceModule;

/* loaded from: classes.dex */
public class LocalAudioTrack extends LocalTrack implements JavaAudioDeviceModule.SamplesReadyCallback {
    final List<AudioTrackSink> sinks;

    public LocalAudioTrack(AudioTrack audioTrack) {
        super(audioTrack);
        this.sinks = new ArrayList();
    }

    private int getBytesPerSample(int i7) {
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

    public void addSink(AudioTrackSink audioTrackSink) {
        synchronized (this.sinks) {
            this.sinks.add(audioTrackSink);
        }
    }

    @Override // org.webrtc.audio.JavaAudioDeviceModule.SamplesReadyCallback
    public void onWebRtcAudioRecordSamplesReady(JavaAudioDeviceModule.AudioSamples audioSamples) {
        int bytesPerSample = getBytesPerSample(audioSamples.getAudioFormat()) * 8;
        int sampleRate = audioSamples.getSampleRate() / 100;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        synchronized (this.sinks) {
            try {
                Iterator<AudioTrackSink> it = this.sinks.iterator();
                while (it.hasNext()) {
                    it.next().onData(ByteBuffer.wrap(audioSamples.getData()), bytesPerSample, audioSamples.getSampleRate(), audioSamples.getChannelCount(), sampleRate, jElapsedRealtime);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void removeSink(AudioTrackSink audioTrackSink) {
        synchronized (this.sinks) {
            this.sinks.remove(audioTrackSink);
        }
    }
}
