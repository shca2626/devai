package com.fasterxml.jackson.core.util;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes.dex */
public class BufferRecycler {
    public static final int BYTE_BASE64_CODEC_BUFFER = 3;
    public static final int BYTE_READ_IO_BUFFER = 0;
    public static final int BYTE_WRITE_CONCAT_BUFFER = 2;
    public static final int BYTE_WRITE_ENCODING_BUFFER = 1;
    public static final int CHAR_CONCAT_BUFFER = 1;
    public static final int CHAR_NAME_COPY_BUFFER = 3;
    public static final int CHAR_TEXT_BUFFER = 2;
    public static final int CHAR_TOKEN_BUFFER = 0;
    protected final AtomicReferenceArray<byte[]> _byteBuffers;
    protected final AtomicReferenceArray<char[]> _charBuffers;
    private static final int[] BYTE_BUFFER_LENGTHS = {8000, 8000, 2000, 2000};
    private static final int[] CHAR_BUFFER_LENGTHS = {4000, 4000, 200, 200};

    public BufferRecycler() {
        this(4, 4);
    }

    public final byte[] allocByteBuffer(int i7) {
        return allocByteBuffer(i7, 0);
    }

    public final char[] allocCharBuffer(int i7) {
        return allocCharBuffer(i7, 0);
    }

    public byte[] balloc(int i7) {
        return new byte[i7];
    }

    public int byteBufferLength(int i7) {
        return BYTE_BUFFER_LENGTHS[i7];
    }

    public char[] calloc(int i7) {
        return new char[i7];
    }

    public int charBufferLength(int i7) {
        return CHAR_BUFFER_LENGTHS[i7];
    }

    public void releaseByteBuffer(int i7, byte[] bArr) {
        this._byteBuffers.set(i7, bArr);
    }

    public void releaseCharBuffer(int i7, char[] cArr) {
        this._charBuffers.set(i7, cArr);
    }

    public BufferRecycler(int i7, int i8) {
        this._byteBuffers = new AtomicReferenceArray<>(i7);
        this._charBuffers = new AtomicReferenceArray<>(i8);
    }

    public byte[] allocByteBuffer(int i7, int i8) {
        int iByteBufferLength = byteBufferLength(i7);
        if (i8 < iByteBufferLength) {
            i8 = iByteBufferLength;
        }
        byte[] andSet = this._byteBuffers.getAndSet(i7, null);
        return (andSet == null || andSet.length < i8) ? balloc(i8) : andSet;
    }

    public char[] allocCharBuffer(int i7, int i8) {
        int iCharBufferLength = charBufferLength(i7);
        if (i8 < iCharBufferLength) {
            i8 = iCharBufferLength;
        }
        char[] andSet = this._charBuffers.getAndSet(i7, null);
        return (andSet == null || andSet.length < i8) ? calloc(i8) : andSet;
    }
}
