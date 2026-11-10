package org.webrtc;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/* loaded from: classes3.dex */
class JniHelper {
    @CalledByNative
    public static Object getKey(Map.Entry<?, ?> entry) {
        return entry.getKey();
    }

    @CalledByNative
    public static byte[] getStringBytes(String str) {
        return str.getBytes(StandardCharsets.ISO_8859_1);
    }

    @CalledByNative
    public static Object getStringClass() {
        return String.class;
    }

    @CalledByNative
    public static Object getValue(Map.Entry<?, ?> entry) {
        return entry.getValue();
    }
}
