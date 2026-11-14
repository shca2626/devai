package u;

import android.os.CancellationSignal;
import android.util.Log;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final c f22697a = new a();

    /* renamed from: b, reason: collision with root package name */
    public CancellationSignal f22698b;

    /* renamed from: c, reason: collision with root package name */
    public V.f f22699c;

    public class a implements c {
        public a() {
        }

        @Override // u.h.c
        public V.f a() {
            return new V.f();
        }

        @Override // u.h.c
        public CancellationSignal b() {
            return b.b();
        }
    }

    public static class b {
        public static void a(CancellationSignal cancellationSignal) {
            cancellationSignal.cancel();
        }

        public static CancellationSignal b() {
            return new CancellationSignal();
        }
    }

    public interface c {
        V.f a();

        CancellationSignal b();
    }

    public void a() {
        CancellationSignal cancellationSignal = this.f22698b;
        if (cancellationSignal != null) {
            try {
                b.a(cancellationSignal);
            } catch (NullPointerException e7) {
                Log.e("CancelSignalProvider", "Got NPE while canceling biometric authentication.", e7);
            }
            this.f22698b = null;
        }
        V.f fVar = this.f22699c;
        if (fVar != null) {
            try {
                fVar.a();
            } catch (NullPointerException e8) {
                Log.e("CancelSignalProvider", "Got NPE while canceling fingerprint authentication.", e8);
            }
            this.f22699c = null;
        }
    }

    public CancellationSignal b() {
        if (this.f22698b == null) {
            this.f22698b = this.f22697a.b();
        }
        return this.f22698b;
    }

    public V.f c() {
        if (this.f22699c == null) {
            this.f22699c = this.f22697a.a();
        }
        return this.f22699c;
    }
}
