package v6;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class t implements f {

    /* renamed from: l, reason: collision with root package name */
    public final y f23215l;

    /* renamed from: m, reason: collision with root package name */
    public final e f23216m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f23217n;

    public t(y yVar) {
        M5.m.e(yVar, "sink");
        this.f23215l = yVar;
        this.f23216m = new e();
    }

    @Override // v6.y
    public void A(e eVar, long j7) {
        M5.m.e(eVar, "source");
        if (this.f23217n) {
            throw new IllegalStateException("closed");
        }
        this.f23216m.A(eVar, j7);
        p();
    }

    @Override // v6.f
    public f Q(long j7) {
        if (this.f23217n) {
            throw new IllegalStateException("closed");
        }
        this.f23216m.Q(j7);
        return p();
    }

    @Override // v6.f
    public e b() {
        return this.f23216m;
    }

    @Override // v6.y
    public B c() {
        return this.f23215l.c();
    }

    @Override // v6.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f23217n) {
            return;
        }
        try {
            if (this.f23216m.size() > 0) {
                y yVar = this.f23215l;
                e eVar = this.f23216m;
                yVar.A(eVar, eVar.size());
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f23215l.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f23217n = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // v6.f, v6.y, java.io.Flushable
    public void flush() {
        if (this.f23217n) {
            throw new IllegalStateException("closed");
        }
        if (this.f23216m.size() > 0) {
            y yVar = this.f23215l;
            e eVar = this.f23216m;
            yVar.A(eVar, eVar.size());
        }
        this.f23215l.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f23217n;
    }

    @Override // v6.f
    public f p() {
        if (this.f23217n) {
            throw new IllegalStateException("closed");
        }
        long jN = this.f23216m.n();
        if (jN > 0) {
            this.f23215l.A(this.f23216m, jN);
        }
        return this;
    }

    public String toString() {
        return "buffer(" + this.f23215l + ')';
    }

    @Override // v6.f
    public f v(String str) {
        M5.m.e(str, "string");
        if (this.f23217n) {
            throw new IllegalStateException("closed");
        }
        this.f23216m.v(str);
        return p();
    }

    @Override // v6.f
    public f w(long j7) {
        if (this.f23217n) {
            throw new IllegalStateException("closed");
        }
        this.f23216m.w(j7);
        return p();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        M5.m.e(byteBuffer, "source");
        if (this.f23217n) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.f23216m.write(byteBuffer);
        p();
        return iWrite;
    }

    @Override // v6.f
    public f writeByte(int i7) {
        if (this.f23217n) {
            throw new IllegalStateException("closed");
        }
        this.f23216m.writeByte(i7);
        return p();
    }

    @Override // v6.f
    public f writeInt(int i7) {
        if (this.f23217n) {
            throw new IllegalStateException("closed");
        }
        this.f23216m.writeInt(i7);
        return p();
    }

    @Override // v6.f
    public f writeShort(int i7) {
        if (this.f23217n) {
            throw new IllegalStateException("closed");
        }
        this.f23216m.writeShort(i7);
        return p();
    }

    @Override // v6.f
    public f write(byte[] bArr) {
        M5.m.e(bArr, "source");
        if (!this.f23217n) {
            this.f23216m.write(bArr);
            return p();
        }
        throw new IllegalStateException("closed");
    }

    @Override // v6.f
    public f write(byte[] bArr, int i7, int i8) {
        M5.m.e(bArr, "source");
        if (!this.f23217n) {
            this.f23216m.write(bArr, i7, i8);
            return p();
        }
        throw new IllegalStateException("closed");
    }
}
