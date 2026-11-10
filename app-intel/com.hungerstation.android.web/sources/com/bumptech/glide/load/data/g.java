package com.bumptech.glide.load.data;

import com.facebook.stetho.dumpapp.Framer;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes7.dex */
public final class g extends FilterInputStream {

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f19126d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f19127e;

    /* renamed from: f, reason: collision with root package name */
    private static final int f19128f;

    /* renamed from: b, reason: collision with root package name */
    private final byte f19129b;

    /* renamed from: c, reason: collision with root package name */
    private int f19130c;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, Framer.EXIT_FRAME_PREFIX, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f19126d = bArr;
        int length = bArr.length;
        f19127e = length;
        f19128f = length + 2;
    }

    public g(InputStream inputStream, int i12) {
        super(inputStream);
        if (i12 >= -1 && i12 <= 8) {
            this.f19129b = (byte) i12;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i12);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i12) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i12;
        int i13 = this.f19130c;
        int i14 = (i13 < 2 || i13 > (i12 = f19128f)) ? super.read() : i13 == i12 ? this.f19129b : f19126d[i13 - 2] & 255;
        if (i14 != -1) {
            this.f19130c++;
        }
        return i14;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j12) throws IOException {
        long jSkip = super.skip(j12);
        if (jSkip > 0) {
            this.f19130c = (int) (this.f19130c + jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i12, int i13) throws IOException {
        int i14;
        int i15 = this.f19130c;
        int i16 = f19128f;
        if (i15 > i16) {
            i14 = super.read(bArr, i12, i13);
        } else if (i15 == i16) {
            bArr[i12] = this.f19129b;
            i14 = 1;
        } else if (i15 < 2) {
            i14 = super.read(bArr, i12, 2 - i15);
        } else {
            int iMin = Math.min(i16 - i15, i13);
            System.arraycopy(f19126d, this.f19130c - 2, bArr, i12, iMin);
            i14 = iMin;
        }
        if (i14 > 0) {
            this.f19130c += i14;
        }
        return i14;
    }
}
