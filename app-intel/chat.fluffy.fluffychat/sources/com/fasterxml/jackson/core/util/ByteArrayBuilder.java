package com.fasterxml.jackson.core.util;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class ByteArrayBuilder extends OutputStream {
    static final int DEFAULT_BLOCK_ARRAY_SIZE = 40;
    private static final int INITIAL_BLOCK_SIZE = 500;
    private static final int MAX_BLOCK_SIZE = 131072;
    public static final byte[] NO_BYTES = new byte[0];
    private final BufferRecycler _bufferRecycler;
    private byte[] _currBlock;
    private int _currBlockPtr;
    private final LinkedList<byte[]> _pastBlocks;
    private int _pastLen;

    public ByteArrayBuilder() {
        this((BufferRecycler) null);
    }

    private void _allocMore() {
        int length = this._pastLen + this._currBlock.length;
        if (length < 0) {
            throw new IllegalStateException("Maximum Java array size (2GB) exceeded by `ByteArrayBuilder`");
        }
        this._pastLen = length;
        int iMax = Math.max(length >> 1, 1000);
        if (iMax > MAX_BLOCK_SIZE) {
            iMax = MAX_BLOCK_SIZE;
        }
        this._pastBlocks.add(this._currBlock);
        this._currBlock = new byte[iMax];
        this._currBlockPtr = 0;
    }

    public static ByteArrayBuilder fromInitial(byte[] bArr, int i7) {
        return new ByteArrayBuilder(null, bArr, i7);
    }

    public void append(int i7) {
        if (this._currBlockPtr >= this._currBlock.length) {
            _allocMore();
        }
        byte[] bArr = this._currBlock;
        int i8 = this._currBlockPtr;
        this._currBlockPtr = i8 + 1;
        bArr[i8] = (byte) i7;
    }

    public void appendFourBytes(int i7) {
        int i8 = this._currBlockPtr;
        int i9 = i8 + 3;
        byte[] bArr = this._currBlock;
        if (i9 >= bArr.length) {
            append(i7 >> 24);
            append(i7 >> 16);
            append(i7 >> 8);
            append(i7);
            return;
        }
        int i10 = i8 + 1;
        this._currBlockPtr = i10;
        bArr[i8] = (byte) (i7 >> 24);
        int i11 = i8 + 2;
        this._currBlockPtr = i11;
        bArr[i10] = (byte) (i7 >> 16);
        int i12 = i8 + 3;
        this._currBlockPtr = i12;
        bArr[i11] = (byte) (i7 >> 8);
        this._currBlockPtr = i8 + 4;
        bArr[i12] = (byte) i7;
    }

    public void appendThreeBytes(int i7) {
        int i8 = this._currBlockPtr;
        int i9 = i8 + 2;
        byte[] bArr = this._currBlock;
        if (i9 >= bArr.length) {
            append(i7 >> 16);
            append(i7 >> 8);
            append(i7);
            return;
        }
        int i10 = i8 + 1;
        this._currBlockPtr = i10;
        bArr[i8] = (byte) (i7 >> 16);
        int i11 = i8 + 2;
        this._currBlockPtr = i11;
        bArr[i10] = (byte) (i7 >> 8);
        this._currBlockPtr = i8 + 3;
        bArr[i11] = (byte) i7;
    }

    public void appendTwoBytes(int i7) {
        int i8 = this._currBlockPtr;
        int i9 = i8 + 1;
        byte[] bArr = this._currBlock;
        if (i9 >= bArr.length) {
            append(i7 >> 8);
            append(i7);
            return;
        }
        int i10 = i8 + 1;
        this._currBlockPtr = i10;
        bArr[i8] = (byte) (i7 >> 8);
        this._currBlockPtr = i8 + 2;
        bArr[i10] = (byte) i7;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public byte[] completeAndCoalesce(int i7) {
        this._currBlockPtr = i7;
        return toByteArray();
    }

    public byte[] finishCurrentSegment() {
        _allocMore();
        return this._currBlock;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }

    public byte[] getCurrentSegment() {
        return this._currBlock;
    }

    public int getCurrentSegmentLength() {
        return this._currBlockPtr;
    }

    public void release() {
        byte[] bArr;
        reset();
        BufferRecycler bufferRecycler = this._bufferRecycler;
        if (bufferRecycler == null || (bArr = this._currBlock) == null) {
            return;
        }
        bufferRecycler.releaseByteBuffer(2, bArr);
        this._currBlock = null;
    }

    public void reset() {
        this._pastLen = 0;
        this._currBlockPtr = 0;
        if (this._pastBlocks.isEmpty()) {
            return;
        }
        this._pastBlocks.clear();
    }

    public byte[] resetAndGetFirstSegment() {
        reset();
        return this._currBlock;
    }

    public void setCurrentSegmentLength(int i7) {
        this._currBlockPtr = i7;
    }

    public int size() {
        return this._pastLen + this._currBlockPtr;
    }

    public byte[] toByteArray() {
        int i7 = this._pastLen + this._currBlockPtr;
        if (i7 == 0) {
            return NO_BYTES;
        }
        byte[] bArr = new byte[i7];
        Iterator<byte[]> it = this._pastBlocks.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            byte[] next = it.next();
            int length = next.length;
            System.arraycopy(next, 0, bArr, i8, length);
            i8 += length;
        }
        System.arraycopy(this._currBlock, 0, bArr, i8, this._currBlockPtr);
        int i9 = i8 + this._currBlockPtr;
        if (i9 == i7) {
            if (!this._pastBlocks.isEmpty()) {
                reset();
            }
            return bArr;
        }
        throw new RuntimeException("Internal error: total len assumed to be " + i7 + ", copied " + i9 + " bytes");
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public ByteArrayBuilder(BufferRecycler bufferRecycler) {
        this(bufferRecycler, 500);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i7, int i8) {
        while (true) {
            int iMin = Math.min(this._currBlock.length - this._currBlockPtr, i8);
            if (iMin > 0) {
                System.arraycopy(bArr, i7, this._currBlock, this._currBlockPtr, iMin);
                i7 += iMin;
                this._currBlockPtr += iMin;
                i8 -= iMin;
            }
            if (i8 <= 0) {
                return;
            } else {
                _allocMore();
            }
        }
    }

    public ByteArrayBuilder(int i7) {
        this(null, i7);
    }

    public ByteArrayBuilder(BufferRecycler bufferRecycler, int i7) {
        this._pastBlocks = new LinkedList<>();
        this._bufferRecycler = bufferRecycler;
        this._currBlock = bufferRecycler == null ? new byte[i7] : bufferRecycler.allocByteBuffer(2);
    }

    @Override // java.io.OutputStream
    public void write(int i7) {
        append(i7);
    }

    private ByteArrayBuilder(BufferRecycler bufferRecycler, byte[] bArr, int i7) {
        this._pastBlocks = new LinkedList<>();
        this._bufferRecycler = null;
        this._currBlock = bArr;
        this._currBlockPtr = i7;
    }
}
