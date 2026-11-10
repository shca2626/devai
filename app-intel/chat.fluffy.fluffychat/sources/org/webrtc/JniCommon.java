package org.webrtc;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class JniCommon {
    public static native void nativeAddRef(long j7);

    public static native ByteBuffer nativeAllocateByteBuffer(int i7);

    public static native void nativeFreeByteBuffer(ByteBuffer byteBuffer);

    public static native void nativeReleaseRef(long j7);
}
