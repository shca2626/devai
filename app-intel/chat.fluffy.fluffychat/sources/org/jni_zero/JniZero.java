package org.jni_zero;

import java.util.Collections;

@JNINamespace("jni_zero")
/* loaded from: classes3.dex */
public class JniZero {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static boolean sInitialized;
    private static ClassLoader sPendingJniClassLoader;

    public interface Natives {
        void setJniClassLoader(ClassLoader classLoader);
    }

    @CalledByNative
    private static void crashIfMultiplexingMisaligned(long j7, long j8) throws IllegalAccessException, IllegalArgumentException {
        try {
            long j9 = Class.forName("J.N").getField("WHOLE_HASH").getLong(null);
            long j10 = Class.forName("J.N").getField("PRIORITY_HASH").getLong(null);
            if (j9 != j7 && j9 != j8 && j10 != j7) {
                throw new RuntimeException("JNI Zero multiplexing hashes do not align. Native: " + j7 + " or " + j8 + " Java: " + j9 + " or " + j10);
            }
        } catch (ReflectiveOperationException unused) {
        }
    }

    @CalledByNative
    private static Object[] init() {
        sInitialized = true;
        ClassLoader classLoader = sPendingJniClassLoader;
        if (classLoader != null) {
            sPendingJniClassLoader = null;
        } else {
            classLoader = JniZero.class.getClassLoader();
        }
        return new Object[]{Collections.EMPTY_LIST, Collections.EMPTY_MAP, classLoader};
    }

    public static void setJniClassLoader(ClassLoader classLoader) {
        if (sInitialized) {
            JniZeroJni.get().setJniClassLoader(classLoader);
        } else {
            sPendingJniClassLoader = classLoader;
        }
    }
}
