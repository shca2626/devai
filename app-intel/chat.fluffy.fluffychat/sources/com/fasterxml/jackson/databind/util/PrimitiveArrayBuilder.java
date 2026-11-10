package com.fasterxml.jackson.databind.util;

/* loaded from: classes.dex */
public abstract class PrimitiveArrayBuilder<T> {
    static final int INITIAL_CHUNK_SIZE = 12;
    static final int MAX_CHUNK_SIZE = 262144;
    static final int SMALL_CHUNK_SIZE = 16384;
    protected Node<T> _bufferHead;
    protected Node<T> _bufferTail;
    protected int _bufferedEntryCount;
    protected T _freeBuffer;

    public static final class Node<T> {
        final T _data;
        final int _dataLength;
        Node<T> _next;

        public Node(T t7, int i7) {
            this._data = t7;
            this._dataLength = i7;
        }

        public int copyData(T t7, int i7) {
            System.arraycopy(this._data, 0, t7, i7, this._dataLength);
            return i7 + this._dataLength;
        }

        public T getData() {
            return this._data;
        }

        public void linkNext(Node<T> node) {
            if (this._next != null) {
                throw new IllegalStateException();
            }
            this._next = node;
        }

        public Node<T> next() {
            return this._next;
        }
    }

    public abstract T _constructArray(int i7);

    public void _reset() {
        Node<T> node = this._bufferTail;
        if (node != null) {
            this._freeBuffer = node.getData();
        }
        this._bufferTail = null;
        this._bufferHead = null;
        this._bufferedEntryCount = 0;
    }

    public final T appendCompletedChunk(T t7, int i7) {
        Node<T> node = new Node<>(t7, i7);
        if (this._bufferHead == null) {
            this._bufferTail = node;
            this._bufferHead = node;
        } else {
            this._bufferTail.linkNext(node);
            this._bufferTail = node;
        }
        this._bufferedEntryCount += i7;
        return _constructArray(i7 < SMALL_CHUNK_SIZE ? i7 + i7 : i7 + (i7 >> 2));
    }

    public int bufferedSize() {
        return this._bufferedEntryCount;
    }

    public T completeAndClearBuffer(T t7, int i7) {
        int i8 = this._bufferedEntryCount + i7;
        T t_constructArray = _constructArray(i8);
        int iCopyData = 0;
        for (Node<T> next = this._bufferHead; next != null; next = next.next()) {
            iCopyData = next.copyData(t_constructArray, iCopyData);
        }
        System.arraycopy(t7, 0, t_constructArray, iCopyData, i7);
        int i9 = iCopyData + i7;
        if (i9 == i8) {
            return t_constructArray;
        }
        throw new IllegalStateException("Should have gotten " + i8 + " entries, got " + i9);
    }

    public T resetAndStart() {
        _reset();
        T t7 = this._freeBuffer;
        return t7 == null ? _constructArray(12) : t7;
    }
}
