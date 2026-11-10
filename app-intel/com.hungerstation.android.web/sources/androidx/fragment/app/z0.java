package androidx.fragment.app;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.io.Writer;

/* loaded from: classes7.dex */
final class z0 extends Writer {

    /* renamed from: b, reason: collision with root package name */
    private final String f7814b;

    /* renamed from: c, reason: collision with root package name */
    private StringBuilder f7815c = new StringBuilder(UserVerificationMethods.USER_VERIFY_PATTERN);

    z0(String str) {
        this.f7814b = str;
    }

    private void a() {
        if (this.f7815c.length() > 0) {
            this.f7815c.toString();
            StringBuilder sb2 = this.f7815c;
            sb2.delete(0, sb2.length());
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
    public void write(char[] cArr, int i12, int i13) {
        for (int i14 = 0; i14 < i13; i14++) {
            char c12 = cArr[i12 + i14];
            if (c12 == '\n') {
                a();
            } else {
                this.f7815c.append(c12);
            }
        }
    }
}
