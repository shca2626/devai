package com.fasterxml.jackson.databind.util;

import java.lang.reflect.Array;
import java.util.List;

/* loaded from: classes.dex */
public final class ObjectBuffer {
    private static final int MAX_CHUNK = 262144;
    private static final int SMALL_CHUNK = 16384;
    private Object[] _freeBuffer;
    private LinkedNode<Object[]> _head;
    private int _size;
    private LinkedNode<Object[]> _tail;

    public final void _copyTo(Object obj, int i7, Object[] objArr, int i8) {
        int i9 = 0;
        for (LinkedNode<Object[]> next = this._head; next != null; next = next.next()) {
            Object[] objArrValue = next.value();
            int length = objArrValue.length;
            System.arraycopy(objArrValue, 0, obj, i9, length);
            i9 += length;
        }
        System.arraycopy(objArr, 0, obj, i9, i8);
        int i10 = i9 + i8;
        if (i10 == i7) {
            return;
        }
        throw new IllegalStateException("Should have gotten " + i7 + " entries, got " + i10);
    }

    public void _reset() {
        LinkedNode<Object[]> linkedNode = this._tail;
        if (linkedNode != null) {
            this._freeBuffer = linkedNode.value();
        }
        this._tail = null;
        this._head = null;
        this._size = 0;
    }

    public Object[] appendCompletedChunk(Object[] objArr) {
        LinkedNode<Object[]> linkedNode = new LinkedNode<>(objArr, null);
        if (this._head == null) {
            this._tail = linkedNode;
            this._head = linkedNode;
        } else {
            this._tail.linkNext(linkedNode);
            this._tail = linkedNode;
        }
        int length = objArr.length;
        this._size += length;
        if (length < SMALL_CHUNK) {
            length += length;
        } else if (length < MAX_CHUNK) {
            length += length >> 2;
        }
        return new Object[length];
    }

    public int bufferedSize() {
        return this._size;
    }

    public Object[] completeAndClearBuffer(Object[] objArr, int i7) {
        int i8 = this._size + i7;
        Object[] objArr2 = new Object[i8];
        _copyTo(objArr2, i8, objArr, i7);
        _reset();
        return objArr2;
    }

    public int initialCapacity() {
        Object[] objArr = this._freeBuffer;
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    public Object[] resetAndStart() {
        _reset();
        Object[] objArr = this._freeBuffer;
        if (objArr != null) {
            return objArr;
        }
        Object[] objArr2 = new Object[12];
        this._freeBuffer = objArr2;
        return objArr2;
    }

    public Object[] resetAndStart(Object[] objArr, int i7) {
        _reset();
        Object[] objArr2 = this._freeBuffer;
        if (objArr2 == null || objArr2.length < i7) {
            this._freeBuffer = new Object[Math.max(12, i7)];
        }
        System.arraycopy(objArr, 0, this._freeBuffer, 0, i7);
        return this._freeBuffer;
    }

    public <T> T[] completeAndClearBuffer(Object[] objArr, int i7, Class<T> cls) {
        int i8 = this._size + i7;
        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i8));
        _copyTo(tArr, i8, objArr, i7);
        _reset();
        return tArr;
    }

    public void completeAndClearBuffer(Object[] objArr, int i7, List<Object> list) {
        int i8;
        LinkedNode<Object[]> next = this._head;
        while (true) {
            i8 = 0;
            if (next == null) {
                break;
            }
            Object[] objArrValue = next.value();
            int length = objArrValue.length;
            while (i8 < length) {
                list.add(objArrValue[i8]);
                i8++;
            }
            next = next.next();
        }
        while (i8 < i7) {
            list.add(objArr[i8]);
            i8++;
        }
        _reset();
    }
}
