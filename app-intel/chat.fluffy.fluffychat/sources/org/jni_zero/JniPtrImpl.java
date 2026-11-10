package org.jni_zero;

import org.jni_zero.JniTypeToken;

/* loaded from: classes3.dex */
class JniPtrImpl<T extends JniTypeToken> implements JniPtrInner<T> {
    private long mNativePtr;

    public JniPtrImpl(long j7) {
        if (j7 == 0) {
            throw new IllegalArgumentException("JNI Zero internal error: if the pointer is 0, it should be converted to null");
        }
        this.mNativePtr = j7;
    }

    @Override // org.jni_zero.JniPtrInner
    public long getNativePtr() {
        long j7 = this.mNativePtr;
        if (j7 != 0) {
            return j7;
        }
        throw new IllegalStateException("Trying to access an already-released JniPtr");
    }

    public void release() {
        this.mNativePtr = 0L;
    }
}
