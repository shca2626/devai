package com.fasterxml.jackson.databind.util;

import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class ByteBufferBackedOutputStream extends OutputStream {
    protected final ByteBuffer _b;

    public ByteBufferBackedOutputStream(ByteBuffer byteBuffer) {
        this._b = byteBuffer;
    }

    @Override // java.io.OutputStream
    public void write(int i7) {
        this._b.put((byte) i7);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i7, int i8) {
        this._b.put(bArr, i7, i8);
    }
}
