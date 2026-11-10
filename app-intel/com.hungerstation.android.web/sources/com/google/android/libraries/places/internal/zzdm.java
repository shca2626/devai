package com.google.android.libraries.places.internal;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class zzdm extends LinkedHashMap<Long, Integer> {
    zzdm(int i12, float f12, boolean z12) {
        super(16, 0.75f, true);
    }

    @Override // java.util.LinkedHashMap
    protected final boolean removeEldestEntry(Map.Entry<Long, Integer> entry) {
        return size() > 10;
    }
}
