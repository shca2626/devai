package com.cloudwebrtc.webrtc;

import org.webrtc.MediaStreamTrack;

/* loaded from: classes.dex */
public class LocalTrack {
    public MediaStreamTrack track;

    public LocalTrack(MediaStreamTrack mediaStreamTrack) {
        this.track = mediaStreamTrack;
    }

    public void dispose() {
        this.track.dispose();
    }

    public boolean enabled() {
        return this.track.enabled();
    }

    public String id() {
        return this.track.id();
    }

    public String kind() {
        return this.track.kind();
    }

    public void setEnabled(boolean z7) {
        this.track.setEnabled(z7);
    }
}
