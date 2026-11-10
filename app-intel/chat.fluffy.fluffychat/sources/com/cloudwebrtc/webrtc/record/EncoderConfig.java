package com.cloudwebrtc.webrtc.record;

/* loaded from: classes.dex */
class EncoderConfig {
    final int bitrate;
    final int height;
    final int profile;
    final int width;

    public EncoderConfig(int i7, int i8, int i9, int i10) {
        this.width = i7;
        this.height = i8;
        this.bitrate = i9;
        this.profile = i10;
    }

    public String toString() {
        return this.width + "x" + this.height + ", bitrate: " + this.bitrate + ", profile: " + this.profile;
    }
}
