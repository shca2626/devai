package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.io.Writer;

/* loaded from: classes.dex */
public final class SegmentedStringWriter extends Writer {
    private final TextBuffer _buffer;

    public SegmentedStringWriter(BufferRecycler bufferRecycler) {
        this._buffer = new TextBuffer(bufferRecycler);
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    public String getAndClear() {
        String strContentsAsString = this._buffer.contentsAsString();
        this._buffer.releaseBuffers();
        return strContentsAsString;
    }

    @Override // java.io.Writer
    public void write(char[] cArr) {
        this._buffer.append(cArr, 0, cArr.length);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i7, int i8) {
        this._buffer.append(cArr, i7, i8);
    }

    @Override // java.io.Writer
    public void write(int i7) {
        this._buffer.append((char) i7);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c7) {
        write(c7);
        return this;
    }

    @Override // java.io.Writer
    public void write(String str) {
        this._buffer.append(str, 0, str.length());
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        String string = charSequence.toString();
        this._buffer.append(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer
    public void write(String str, int i7, int i8) {
        this._buffer.append(str, i7, i8);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i7, int i8) {
        String string = charSequence.subSequence(i7, i8).toString();
        this._buffer.append(string, 0, string.length());
        return this;
    }
}
