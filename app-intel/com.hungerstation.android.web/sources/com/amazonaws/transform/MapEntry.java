package com.amazonaws.transform;

import java.util.Map;

/* loaded from: classes7.dex */
public class MapEntry<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;

    @Override // java.util.Map.Entry
    public K getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return this.value;
    }

    public K setKey(K k12) {
        this.key = k12;
        return k12;
    }

    @Override // java.util.Map.Entry
    public V setValue(V v12) {
        this.value = v12;
        return v12;
    }
}
