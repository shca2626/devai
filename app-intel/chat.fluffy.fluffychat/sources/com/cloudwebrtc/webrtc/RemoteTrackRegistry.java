package com.cloudwebrtc.webrtc;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class RemoteTrackRegistry<T> {
    private final Map<String, T> tracks = new HashMap();

    public synchronized void clear() {
        this.tracks.clear();
    }

    public synchronized T get(String str) {
        return this.tracks.get(str);
    }

    public synchronized void put(String str, T t7) {
        this.tracks.put(str, t7);
    }

    public synchronized boolean remove(String str, T t7) {
        if (this.tracks.get(str) != t7) {
            return false;
        }
        this.tracks.remove(str);
        return true;
    }
}
