package com.fasterxml.jackson.databind.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class LRUMap<K, V> implements Serializable {
    private static final long serialVersionUID = 1;
    protected transient int _jdkSerializeMaxEntries;
    protected final transient ConcurrentHashMap<K, V> _map;
    protected final transient int _maxEntries;

    public LRUMap(int i7, int i8) {
        this._map = new ConcurrentHashMap<>(i7, 0.8f, 4);
        this._maxEntries = i8;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this._jdkSerializeMaxEntries = objectInputStream.readInt();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this._jdkSerializeMaxEntries);
    }

    public void clear() {
        this._map.clear();
    }

    public V get(Object obj) {
        return this._map.get(obj);
    }

    public V put(K k7, V v7) {
        if (this._map.size() >= this._maxEntries) {
            synchronized (this) {
                try {
                    if (this._map.size() >= this._maxEntries) {
                        clear();
                    }
                } finally {
                }
            }
        }
        return this._map.put(k7, v7);
    }

    public V putIfAbsent(K k7, V v7) {
        if (this._map.size() >= this._maxEntries) {
            synchronized (this) {
                try {
                    if (this._map.size() >= this._maxEntries) {
                        clear();
                    }
                } finally {
                }
            }
        }
        return this._map.putIfAbsent(k7, v7);
    }

    public Object readResolve() {
        int i7 = this._jdkSerializeMaxEntries;
        return new LRUMap(i7, i7);
    }

    public int size() {
        return this._map.size();
    }
}
