package com.fasterxml.jackson.core.io;

import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* loaded from: classes.dex */
public class UTF32Reader extends Reader {
    protected static final int LAST_VALID_UNICODE_CHAR = 1114111;
    protected static final char NC = 0;
    protected final boolean _bigEndian;
    protected byte[] _buffer;
    protected int _byteCount;
    protected int _charCount;
    protected final IOContext _context;
    protected InputStream _in;
    protected int _length;
    protected final boolean _managedBuffers;
    protected int _ptr;
    protected char _surrogate = 0;
    protected char[] _tmpBuf;

    public UTF32Reader(IOContext iOContext, InputStream inputStream, byte[] bArr, int i7, int i8, boolean z7) {
        this._context = iOContext;
        this._in = inputStream;
        this._buffer = bArr;
        this._ptr = i7;
        this._length = i8;
        this._bigEndian = z7;
        this._managedBuffers = inputStream != null;
    }

    private void freeBuffers() {
        byte[] bArr = this._buffer;
        if (bArr != null) {
            this._buffer = null;
            this._context.releaseReadIOBuffer(bArr);
        }
    }

    private boolean loadMore(int i7) throws IOException {
        int i8;
        this._byteCount += this._length - i7;
        if (i7 > 0) {
            int i9 = this._ptr;
            if (i9 > 0) {
                byte[] bArr = this._buffer;
                System.arraycopy(bArr, i9, bArr, 0, i7);
                this._ptr = 0;
            }
            this._length = i7;
        } else {
            this._ptr = 0;
            InputStream inputStream = this._in;
            int i10 = inputStream == null ? -1 : inputStream.read(this._buffer);
            if (i10 < 1) {
                this._length = 0;
                if (i10 < 0) {
                    if (this._managedBuffers) {
                        freeBuffers();
                    }
                    return false;
                }
                reportStrangeStream();
            }
            this._length = i10;
        }
        while (true) {
            int i11 = this._length;
            if (i11 >= 4) {
                return true;
            }
            InputStream inputStream2 = this._in;
            if (inputStream2 == null) {
                i8 = -1;
            } else {
                byte[] bArr2 = this._buffer;
                i8 = inputStream2.read(bArr2, i11, bArr2.length - i11);
            }
            if (i8 < 1) {
                if (i8 < 0) {
                    if (this._managedBuffers) {
                        freeBuffers();
                    }
                    reportUnexpectedEOF(this._length, 4);
                }
                reportStrangeStream();
            }
            this._length += i8;
        }
    }

    private void reportBounds(char[] cArr, int i7, int i8) {
        throw new ArrayIndexOutOfBoundsException("read(buf," + i7 + "," + i8 + "), cbuf[" + cArr.length + "]");
    }

    private void reportInvalid(int i7, int i8, String str) throws CharConversionException {
        int i9 = (this._byteCount + this._ptr) - 1;
        throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(i7) + str + " at char #" + (this._charCount + i8) + ", byte #" + i9 + ")");
    }

    private void reportStrangeStream() throws IOException {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }

    private void reportUnexpectedEOF(int i7, int i8) throws CharConversionException {
        int i9 = this._byteCount + i7;
        throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + i7 + ", needed " + i8 + ", at char #" + this._charCount + ", byte #" + i9 + ")");
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this._in;
        if (inputStream != null) {
            this._in = null;
            freeBuffers();
            inputStream.close();
        }
    }

    @Override // java.io.Reader
    public int read() {
        if (this._tmpBuf == null) {
            this._tmpBuf = new char[1];
        }
        if (read(this._tmpBuf, 0, 1) < 1) {
            return -1;
        }
        return this._tmpBuf[0];
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ce A[LOOP:0: B:24:0x003e->B:42:0x00ce, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c0 A[SYNTHETIC] */
    @Override // java.io.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int read(char[] r9, int r10, int r11) throws java.io.CharConversionException {
        /*
            Method dump skipped, instructions count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.UTF32Reader.read(char[], int, int):int");
    }
}
