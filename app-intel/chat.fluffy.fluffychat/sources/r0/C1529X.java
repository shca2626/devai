package r0;

import android.util.Log;
import java.io.Writer;

/* renamed from: r0.X, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1529X extends Writer {

    /* renamed from: l, reason: collision with root package name */
    public final String f21841l;

    /* renamed from: m, reason: collision with root package name */
    public StringBuilder f21842m = new StringBuilder(128);

    public C1529X(String str) {
        this.f21841l = str;
    }

    public final void a() {
        if (this.f21842m.length() > 0) {
            Log.d(this.f21841l, this.f21842m.toString());
            StringBuilder sb = this.f21842m;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i7, int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            char c7 = cArr[i7 + i9];
            if (c7 == '\n') {
                a();
            } else {
                this.f21842m.append(c7);
            }
        }
    }
}
