package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class MergedStream extends InputStream {
    private byte[] _b;
    private final IOContext _ctxt;
    private final int _end;
    private final InputStream _in;
    private int _ptr;

    public MergedStream(IOContext iOContext, InputStream inputStream, byte[] bArr, int i7, int i8) {
        this._ctxt = iOContext;
        this._in = inputStream;
        this._b = bArr;
        this._ptr = i7;
        this._end = i8;
    }

    private void _free() {
        byte[] bArr = this._b;
        if (bArr != null) {
            this._b = null;
            IOContext iOContext = this._ctxt;
            if (iOContext != null) {
                iOContext.releaseReadIOBuffer(bArr);
            }
        }
    }

    @Override // java.io.InputStream
    public int available() {
        return this._b != null ? this._end - this._ptr : this._in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        _free();
        this._in.close();
    }

    @Override // java.io.InputStream
    public void mark(int i7) {
        if (this._b == null) {
            this._in.mark(i7);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this._b == null && this._in.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        byte[] bArr = this._b;
        if (bArr == null) {
            return this._in.read();
        }
        int i7 = this._ptr;
        int i8 = i7 + 1;
        this._ptr = i8;
        int i9 = bArr[i7] & 255;
        if (i8 >= this._end) {
            _free();
        }
        return i9;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        if (this._b == null) {
            this._in.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j7) {
        long j8;
        if (this._b != null) {
            int i7 = this._end;
            int i8 = this._ptr;
            j8 = i7 - i8;
            if (j8 > j7) {
                this._ptr = i8 + ((int) j7);
                return j7;
            }
            _free();
            j7 -= j8;
        } else {
            j8 = 0;
        }
        return j7 > 0 ? j8 + this._in.skip(j7) : j8;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i7, int i8) {
        byte[] bArr2 = this._b;
        if (bArr2 != null) {
            int i9 = this._end;
            int i10 = this._ptr;
            int i11 = i9 - i10;
            if (i8 > i11) {
                i8 = i11;
            }
            System.arraycopy(bArr2, i10, bArr, i7, i8);
            int i12 = this._ptr + i8;
            this._ptr = i12;
            if (i12 >= this._end) {
                _free();
            }
            return i8;
        }
        return this._in.read(bArr, i7, i8);
    }
}
