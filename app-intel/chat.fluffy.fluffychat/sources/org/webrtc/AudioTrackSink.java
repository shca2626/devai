package org.webrtc;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public interface AudioTrackSink {
    @CalledByNative
    void onData(ByteBuffer byteBuffer, int i7, int i8, int i9, int i10, long j7);
}
