package org.jni_zero;

import org.jni_zero.JniTypeToken;

/* loaded from: classes3.dex */
interface JniPtrInner<T extends JniTypeToken> extends JniPtr<T> {
    long getNativePtr();
}
