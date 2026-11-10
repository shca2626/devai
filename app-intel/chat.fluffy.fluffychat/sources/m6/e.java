package m6;

import java.io.EOFException;
import java.io.IOException;
import v6.i;
import v6.y;

/* loaded from: classes3.dex */
public abstract class e extends i {

    /* renamed from: m, reason: collision with root package name */
    public boolean f19828m;

    public e(y yVar) {
        super(yVar);
    }

    @Override // v6.i, v6.y
    public void A(v6.e eVar, long j7) throws EOFException {
        if (this.f19828m) {
            eVar.skip(j7);
            return;
        }
        try {
            super.A(eVar, j7);
        } catch (IOException e7) {
            this.f19828m = true;
            a(e7);
        }
    }

    public abstract void a(IOException iOException);

    @Override // v6.i, v6.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f19828m) {
            return;
        }
        try {
            super.close();
        } catch (IOException e7) {
            this.f19828m = true;
            a(e7);
        }
    }

    @Override // v6.i, v6.y, java.io.Flushable
    public void flush() {
        if (this.f19828m) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e7) {
            this.f19828m = true;
            a(e7);
        }
    }
}
