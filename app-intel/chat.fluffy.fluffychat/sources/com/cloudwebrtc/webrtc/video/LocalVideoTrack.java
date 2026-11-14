package com.cloudwebrtc.webrtc.video;

import com.cloudwebrtc.webrtc.LocalTrack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.webrtc.VideoFrame;
import org.webrtc.VideoProcessor;
import org.webrtc.VideoSink;
import org.webrtc.VideoTrack;

/* loaded from: classes.dex */
public class LocalVideoTrack extends LocalTrack implements VideoProcessor {
    List<ExternalVideoFrameProcessing> processors;
    private VideoSink sink;

    public interface ExternalVideoFrameProcessing {
        VideoFrame onFrame(VideoFrame videoFrame);
    }

    public LocalVideoTrack(VideoTrack videoTrack) {
        super(videoTrack);
        this.processors = new ArrayList();
        this.sink = null;
    }

    public void addProcessor(ExternalVideoFrameProcessing externalVideoFrameProcessing) {
        synchronized (this.processors) {
            this.processors.add(externalVideoFrameProcessing);
        }
    }

    @Override // org.webrtc.CapturerObserver
    public void onCapturerStarted(boolean z7) {
    }

    @Override // org.webrtc.CapturerObserver
    public void onCapturerStopped() {
    }

    @Override // org.webrtc.CapturerObserver
    public void onFrameCaptured(VideoFrame videoFrame) {
        VideoFrame videoFrame2;
        if (this.sink != null) {
            synchronized (this.processors) {
                try {
                    Iterator<ExternalVideoFrameProcessing> it = this.processors.iterator();
                    videoFrame2 = videoFrame;
                    while (it.hasNext()) {
                        VideoFrame videoFrameOnFrame = it.next().onFrame(videoFrame2);
                        if (videoFrameOnFrame != videoFrame2 && videoFrame2 != videoFrame) {
                            videoFrame2.release();
                        }
                        videoFrame2 = videoFrameOnFrame;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.sink.onFrame(videoFrame2);
            if (videoFrame2 != videoFrame) {
                videoFrame2.release();
            }
        }
    }

    public void removeProcessor(ExternalVideoFrameProcessing externalVideoFrameProcessing) {
        synchronized (this.processors) {
            this.processors.remove(externalVideoFrameProcessing);
        }
    }

    @Override // org.webrtc.VideoProcessor
    public void setSink(VideoSink videoSink) {
        this.sink = videoSink;
    }
}
