package org.webrtc;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class Metrics {
    private static final String TAG = "Metrics";
    public final Map<String, HistogramInfo> map = new HashMap();

    public static class HistogramInfo {
        public final int bucketCount;
        public final int max;
        public final int min;
        public final Map<Integer, Integer> samples = new HashMap();

        @CalledByNative
        public HistogramInfo(int i7, int i8, int i9) {
            this.min = i7;
            this.max = i8;
            this.bucketCount = i9;
        }

        @CalledByNative
        public void addSample(int i7, int i8) {
            this.samples.put(Integer.valueOf(i7), Integer.valueOf(i8));
        }
    }

    @CalledByNative
    public Metrics() {
    }

    @CalledByNative
    private void add(String str, HistogramInfo histogramInfo) {
        this.map.put(str, histogramInfo);
    }

    public static void enable() {
        nativeEnable();
    }

    public static Metrics getAndReset() {
        return nativeGetAndReset();
    }

    private static native void nativeEnable();

    private static native Metrics nativeGetAndReset();
}
