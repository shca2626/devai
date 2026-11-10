package G0;

import java.io.InputStream;

/* loaded from: classes.dex */
public final class h extends InputStream {

    /* renamed from: l, reason: collision with root package name */
    public final f f3137l;

    /* renamed from: m, reason: collision with root package name */
    public final j f3138m;

    /* renamed from: q, reason: collision with root package name */
    public long f3142q;

    /* renamed from: o, reason: collision with root package name */
    public boolean f3140o = false;

    /* renamed from: p, reason: collision with root package name */
    public boolean f3141p = false;

    /* renamed from: n, reason: collision with root package name */
    public final byte[] f3139n = new byte[1];

    public h(f fVar, j jVar) {
        this.f3137l = fVar;
        this.f3138m = jVar;
    }

    public final void a() {
        if (this.f3140o) {
            return;
        }
        this.f3137l.s(this.f3138m);
        this.f3140o = true;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f3141p) {
            return;
        }
        this.f3137l.close();
        this.f3141p = true;
    }

    public void d() {
        a();
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.f3139n) == -1) {
            return -1;
        }
        return this.f3139n[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i7, int i8) {
        j3.o.v(!this.f3141p);
        a();
        int i9 = this.f3137l.read(bArr, i7, i8);
        if (i9 == -1) {
            return -1;
        }
        this.f3142q += i9;
        return i9;
    }
}
