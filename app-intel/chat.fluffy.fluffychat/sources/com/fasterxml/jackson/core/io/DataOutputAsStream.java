package com.fasterxml.jackson.core.io;

import java.io.DataOutput;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class DataOutputAsStream extends OutputStream {
    protected final DataOutput _output;

    public DataOutputAsStream(DataOutput dataOutput) {
        this._output = dataOutput;
    }

    @Override // java.io.OutputStream
    public void write(int i7) throws IOException {
        this._output.write(i7);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this._output.write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i7, int i8) throws IOException {
        this._output.write(bArr, i7, i8);
    }
}
