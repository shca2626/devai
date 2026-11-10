package com.facebook.stetho.inspector.helper;

import android.util.SparseArray;
import java.util.IdentityHashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class ObjectIdMapper {
    protected final Object mSync = new Object();
    private int mNextId = 1;
    private final Map<Object, Integer> mObjectToIdMap = new IdentityHashMap();
    private SparseArray<Object> mIdToObjectMap = new SparseArray<>();

    public void clear() {
        SparseArray<Object> sparseArray;
        synchronized (this.mSync) {
            sparseArray = this.mIdToObjectMap;
            this.mObjectToIdMap.clear();
            this.mIdToObjectMap = new SparseArray<>();
        }
        int size = sparseArray.size();
        for (int i12 = 0; i12 < size; i12++) {
            onUnmapped(sparseArray.valueAt(i12), sparseArray.keyAt(i12));
        }
    }

    public boolean containsId(int i12) {
        boolean z12;
        synchronized (this.mSync) {
            z12 = this.mIdToObjectMap.get(i12) != null;
        }
        return z12;
    }

    public boolean containsObject(Object obj) {
        boolean zContainsKey;
        synchronized (this.mSync) {
            zContainsKey = this.mObjectToIdMap.containsKey(obj);
        }
        return zContainsKey;
    }

    public Integer getIdForObject(Object obj) {
        Integer num;
        synchronized (this.mSync) {
            num = this.mObjectToIdMap.get(obj);
        }
        return num;
    }

    public Object getObjectForId(int i12) {
        Object obj;
        synchronized (this.mSync) {
            obj = this.mIdToObjectMap.get(i12);
        }
        return obj;
    }

    protected void onMapped(Object obj, int i12) {
    }

    protected void onUnmapped(Object obj, int i12) {
    }

    public int putObject(Object obj) {
        synchronized (this.mSync) {
            try {
                Integer num = this.mObjectToIdMap.get(obj);
                if (num != null) {
                    return num.intValue();
                }
                int i12 = this.mNextId;
                this.mNextId = i12 + 1;
                this.mObjectToIdMap.put(obj, Integer.valueOf(i12));
                this.mIdToObjectMap.put(i12, obj);
                onMapped(obj, i12);
                return i12;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public Integer removeObject(Object obj) {
        synchronized (this.mSync) {
            try {
                Integer numRemove = this.mObjectToIdMap.remove(obj);
                if (numRemove == null) {
                    return null;
                }
                this.mIdToObjectMap.remove(numRemove.intValue());
                onUnmapped(obj, numRemove.intValue());
                return numRemove;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public Object removeObjectById(int i12) {
        synchronized (this.mSync) {
            try {
                Object obj = this.mIdToObjectMap.get(i12);
                if (obj == null) {
                    return null;
                }
                this.mIdToObjectMap.remove(i12);
                this.mObjectToIdMap.remove(obj);
                onUnmapped(obj, i12);
                return obj;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int size() {
        int size;
        synchronized (this.mSync) {
            size = this.mObjectToIdMap.size();
        }
        return size;
    }
}
