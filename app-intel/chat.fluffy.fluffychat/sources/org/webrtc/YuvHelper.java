package org.webrtc;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class YuvHelper {
    public static void ABGRToI420(ByteBuffer byteBuffer, int i7, ByteBuffer byteBuffer2, int i8, ByteBuffer byteBuffer3, int i9, ByteBuffer byteBuffer4, int i10, int i11, int i12) {
        nativeABGRToI420((ByteBuffer) checkNotNull(byteBuffer, "src"), i7, (ByteBuffer) checkNotNull(byteBuffer2, "dstY"), i8, (ByteBuffer) checkNotNull(byteBuffer3, "dstU"), i9, (ByteBuffer) checkNotNull(byteBuffer4, "dstV"), i10, i11, i12);
    }

    public static void I420Copy(ByteBuffer byteBuffer, int i7, ByteBuffer byteBuffer2, int i8, ByteBuffer byteBuffer3, int i9, ByteBuffer byteBuffer4, int i10, int i11, int i12, int i13, int i14, int i15) {
        int i16 = (i11 + 1) / 2;
        int i17 = i12 * i11;
        int i18 = i12 * i13;
        int i19 = (i14 * i16) + i18;
        int i20 = (i14 * i15) + i18;
        int i21 = ((i16 - 1) * i14) + i20 + ((i10 + 1) / 2);
        if (byteBuffer4.capacity() < i21) {
            throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + i21 + " was " + byteBuffer4.capacity());
        }
        ByteBuffer byteBufferSlice = byteBuffer4.slice();
        ByteBuffer byteBufferSlice2 = byteBuffer4.slice();
        I420Copy(byteBuffer, i7, byteBuffer2, i8, byteBuffer3, i9, byteBufferSlice, i12, byteBufferSlice2, i14, byteBuffer4.slice(), i14, i10, i11);
    }

    public static void I420Rotate(ByteBuffer byteBuffer, int i7, ByteBuffer byteBuffer2, int i8, ByteBuffer byteBuffer3, int i9, ByteBuffer byteBuffer4, int i10, int i11, int i12) {
        checkNotNull(byteBuffer, "srcY");
        checkNotNull(byteBuffer2, "srcU");
        checkNotNull(byteBuffer3, "srcV");
        checkNotNull(byteBuffer4, "dst");
        int i13 = i12 % 180;
        int i14 = i13 == 0 ? i10 : i11;
        int i15 = i13 == 0 ? i11 : i10;
        int i16 = (i15 + 1) / 2;
        int i17 = (i14 + 1) / 2;
        int i18 = i15 * i14;
        int i19 = i16 * i17;
        int i20 = (i19 * 2) + i18;
        if (byteBuffer4.capacity() < i20) {
            throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + i20 + " was " + byteBuffer4.capacity());
        }
        int i21 = i19 + i18;
        ByteBuffer byteBufferSlice = byteBuffer4.slice();
        ByteBuffer byteBufferSlice2 = byteBuffer4.slice();
        nativeI420Rotate(byteBuffer, i7, byteBuffer2, i8, byteBuffer3, i9, byteBufferSlice, i14, byteBufferSlice2, i17, byteBuffer4.slice(), i17, i10, i11, i12);
    }

    public static void I420ToNV12(ByteBuffer byteBuffer, int i7, ByteBuffer byteBuffer2, int i8, ByteBuffer byteBuffer3, int i9, ByteBuffer byteBuffer4, int i10, int i11, int i12, int i13) {
        int i14 = (i10 + 1) / 2;
        int i15 = i12 * i11;
        int i16 = i12 * i13;
        int i17 = (((i11 + 1) / 2) * i14 * 2) + i16;
        if (byteBuffer4.capacity() >= i17) {
            ByteBuffer byteBufferSlice = byteBuffer4.slice();
            I420ToNV12(byteBuffer, i7, byteBuffer2, i8, byteBuffer3, i9, byteBufferSlice, i12, byteBuffer4.slice(), i14 * 2, i10, i11);
            return;
        }
        throw new IllegalArgumentException("Expected destination buffer capacity to be at least " + i17 + " was " + byteBuffer4.capacity());
    }

    private static <T> T checkNotNull(T t7, String str) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(str + " should not be null");
    }

    public static void copyPlane(ByteBuffer byteBuffer, int i7, ByteBuffer byteBuffer2, int i8, int i9, int i10) {
        nativeCopyPlane((ByteBuffer) checkNotNull(byteBuffer, "src"), i7, (ByteBuffer) checkNotNull(byteBuffer2, "dst"), i8, i9, i10);
    }

    private static native void nativeABGRToI420(ByteBuffer byteBuffer, int i7, ByteBuffer byteBuffer2, int i8, ByteBuffer byteBuffer3, int i9, ByteBuffer byteBuffer4, int i10, int i11, int i12);

    private static native void nativeCopyPlane(ByteBuffer byteBuffer, int i7, ByteBuffer byteBuffer2, int i8, int i9, int i10);

    private static native void nativeI420Copy(ByteBuffer byteBuffer, int i7, ByteBuffer byteBuffer2, int i8, ByteBuffer byteBuffer3, int i9, ByteBuffer byteBuffer4, int i10, ByteBuffer byteBuffer5, int i11, ByteBuffer byteBuffer6, int i12, int i13, int i14);

    private static native void nativeI420Rotate(ByteBuffer byteBuffer, int i7, ByteBuffer byteBuffer2, int i8, ByteBuffer byteBuffer3, int i9, ByteBuffer byteBuffer4, int i10, ByteBuffer byteBuffer5, int i11, ByteBuffer byteBuffer6, int i12, int i13, int i14, int i15);

    private static native void nativeI420ToNV12(ByteBuffer byteBuffer, int i7, ByteBuffer byteBuffer2, int i8, ByteBuffer byteBuffer3, int i9, ByteBuffer byteBuffer4, int i10, ByteBuffer byteBuffer5, int i11, int i12, int i13);

    public static void I420ToNV12(ByteBuffer byteBuffer, int i7, ByteBuffer byteBuffer2, int i8, ByteBuffer byteBuffer3, int i9, ByteBuffer byteBuffer4, int i10, int i11) {
        I420ToNV12(byteBuffer, i7, byteBuffer2, i8, byteBuffer3, i9, byteBuffer4, i10, i11, i10, i11);
    }

    public static void I420ToNV12(ByteBuffer byteBuffer, int i7, ByteBuffer byteBuffer2, int i8, ByteBuffer byteBuffer3, int i9, ByteBuffer byteBuffer4, int i10, ByteBuffer byteBuffer5, int i11, int i12, int i13) {
        checkNotNull(byteBuffer, "srcY");
        checkNotNull(byteBuffer2, "srcU");
        checkNotNull(byteBuffer3, "srcV");
        checkNotNull(byteBuffer4, "dstY");
        checkNotNull(byteBuffer5, "dstUV");
        if (i12 > 0 && i13 > 0) {
            nativeI420ToNV12(byteBuffer, i7, byteBuffer2, i8, byteBuffer3, i9, byteBuffer4, i10, byteBuffer5, i11, i12, i13);
            return;
        }
        throw new IllegalArgumentException("I420ToNV12: width and height should not be negative");
    }

    public static void I420Copy(ByteBuffer byteBuffer, int i7, ByteBuffer byteBuffer2, int i8, ByteBuffer byteBuffer3, int i9, ByteBuffer byteBuffer4, int i10, int i11) {
        I420Copy(byteBuffer, i7, byteBuffer2, i8, byteBuffer3, i9, byteBuffer4, i10, i11, i10, i11, (i10 + 1) / 2, (i11 + 1) / 2);
    }

    public static void I420Copy(ByteBuffer byteBuffer, int i7, ByteBuffer byteBuffer2, int i8, ByteBuffer byteBuffer3, int i9, ByteBuffer byteBuffer4, int i10, int i11, int i12, int i13) {
        I420Copy(byteBuffer, i7, byteBuffer2, i8, byteBuffer3, i9, byteBuffer4, i10, i11, i12, i13, (i12 + 1) / 2, (i13 + 1) / 2);
    }

    public static void I420Copy(ByteBuffer byteBuffer, int i7, ByteBuffer byteBuffer2, int i8, ByteBuffer byteBuffer3, int i9, ByteBuffer byteBuffer4, int i10, ByteBuffer byteBuffer5, int i11, ByteBuffer byteBuffer6, int i12, int i13, int i14) {
        checkNotNull(byteBuffer, "srcY");
        checkNotNull(byteBuffer2, "srcU");
        checkNotNull(byteBuffer3, "srcV");
        checkNotNull(byteBuffer4, "dstY");
        checkNotNull(byteBuffer5, "dstU");
        checkNotNull(byteBuffer6, "dstV");
        if (i13 > 0 && i14 > 0) {
            nativeI420Copy(byteBuffer, i7, byteBuffer2, i8, byteBuffer3, i9, byteBuffer4, i10, byteBuffer5, i11, byteBuffer6, i12, i13, i14);
            return;
        }
        throw new IllegalArgumentException("I420Copy: width and height should not be negative");
    }

    public static void I420Rotate(ByteBuffer byteBuffer, int i7, ByteBuffer byteBuffer2, int i8, ByteBuffer byteBuffer3, int i9, ByteBuffer byteBuffer4, int i10, ByteBuffer byteBuffer5, int i11, ByteBuffer byteBuffer6, int i12, int i13, int i14, int i15) {
        checkNotNull(byteBuffer, "srcY");
        checkNotNull(byteBuffer2, "srcU");
        checkNotNull(byteBuffer3, "srcV");
        checkNotNull(byteBuffer4, "dstY");
        checkNotNull(byteBuffer5, "dstU");
        checkNotNull(byteBuffer6, "dstV");
        nativeI420Rotate(byteBuffer, i7, byteBuffer2, i8, byteBuffer3, i9, byteBuffer4, i10, byteBuffer5, i11, byteBuffer6, i12, i13, i14, i15);
    }
}
