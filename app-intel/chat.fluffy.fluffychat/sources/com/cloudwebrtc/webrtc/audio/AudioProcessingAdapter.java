package com.cloudwebrtc.webrtc.audio;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.webrtc.ExternalAudioProcessingFactory;

/* loaded from: classes.dex */
public class AudioProcessingAdapter implements ExternalAudioProcessingFactory.AudioProcessing {
    List<ExternalAudioFrameProcessing> audioProcessors = new ArrayList();

    public interface ExternalAudioFrameProcessing {
        void initialize(int i7, int i8);

        void process(int i7, int i8, ByteBuffer byteBuffer);

        void reset(int i7);
    }

    public void addProcessor(ExternalAudioFrameProcessing externalAudioFrameProcessing) {
        synchronized (this.audioProcessors) {
            this.audioProcessors.add(externalAudioFrameProcessing);
        }
    }

    @Override // org.webrtc.ExternalAudioProcessingFactory.AudioProcessing
    public void initialize(int i7, int i8) {
        synchronized (this.audioProcessors) {
            try {
                Iterator<ExternalAudioFrameProcessing> it = this.audioProcessors.iterator();
                while (it.hasNext()) {
                    it.next().initialize(i7, i8);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.webrtc.ExternalAudioProcessingFactory.AudioProcessing
    public void process(int i7, int i8, ByteBuffer byteBuffer) {
        synchronized (this.audioProcessors) {
            try {
                Iterator<ExternalAudioFrameProcessing> it = this.audioProcessors.iterator();
                while (it.hasNext()) {
                    it.next().process(i7, i8, byteBuffer);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void removeProcessor(ExternalAudioFrameProcessing externalAudioFrameProcessing) {
        synchronized (this.audioProcessors) {
            this.audioProcessors.remove(externalAudioFrameProcessing);
        }
    }

    @Override // org.webrtc.ExternalAudioProcessingFactory.AudioProcessing
    public void reset(int i7) {
        synchronized (this.audioProcessors) {
            try {
                Iterator<ExternalAudioFrameProcessing> it = this.audioProcessors.iterator();
                while (it.hasNext()) {
                    it.next().reset(i7);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
