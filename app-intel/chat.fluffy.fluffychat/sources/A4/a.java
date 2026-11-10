package A4;

import M5.g;
import M5.m;
import com.paramsen.noise.NoiseNativeBridge;
import java.io.Closeable;

/* loaded from: classes.dex */
public final class a implements Closeable {

    /* renamed from: n, reason: collision with root package name */
    public static final C0003a f267n = new C0003a(null);

    /* renamed from: l, reason: collision with root package name */
    public final long f268l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f269m;

    /* renamed from: A4.a$a, reason: collision with other inner class name */
    public static final class C0003a {
        public /* synthetic */ C0003a(g gVar) {
            this();
        }

        public final a a(int i7) {
            return new a(NoiseNativeBridge.f14972a.realConfig(i7), true, null);
        }

        public C0003a() {
        }
    }

    public /* synthetic */ a(long j7, boolean z7, g gVar) {
        this(j7, z7);
    }

    public final float[] a(float[] fArr, float[] fArr2) {
        m.e(fArr, "src");
        m.e(fArr2, "dst");
        if (this.f269m) {
            if (fArr2.length != fArr.length + 2) {
                throw new IllegalArgumentException("Cannot compute FFT, dst length must equal src length + 2");
            }
            NoiseNativeBridge.f14972a.real(fArr, fArr2, this.f268l);
            return fArr2;
        }
        if (fArr.length != fArr2.length) {
            throw new IllegalArgumentException("Cannot compute FFT, dst length must equal src length");
        }
        NoiseNativeBridge.f14972a.imaginary(fArr, fArr2, this.f268l);
        return fArr2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f269m) {
            NoiseNativeBridge.f14972a.realConfigDispose(this.f268l);
        } else {
            NoiseNativeBridge.f14972a.imaginaryConfigDispose(this.f268l);
        }
    }

    public a(long j7, boolean z7) {
        this.f268l = j7;
        this.f269m = z7;
    }
}
