package u;

import android.os.CancellationSignal;
import android.util.Log;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final c f22691a = new a();

    /* renamed from: b, reason: collision with root package name */
    public CancellationSignal f22692b;

    /* renamed from: c, reason: collision with root package name */
    public V.f f22693c;

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
        CancellationSignal cancellationSignal = this.f22692b;
        if (cancellationSignal != null) {
            try {
                b.a(cancellationSignal);
            } catch (NullPointerException e7) {
                Log.e("CancelSignalProvider", "Got NPE while canceling biometric authentication.", e7);
            }
            this.f22692b = null;
        }
        V.f fVar = this.f22693c;
        if (fVar != null) {
            try {
                fVar.a();
            } catch (NullPointerException e8) {
                Log.e("CancelSignalProvider", "Got NPE while canceling fingerprint authentication.", e8);
            }
            this.f22693c = null;
        }
    }

    public CancellationSignal b() {
        if (this.f22692b == null) {
            this.f22692b = this.f22691a.b();
        }
        return this.f22692b;
    }

    public V.f c() {
        if (this.f22693c == null) {
            this.f22693c = this.f22691a.a();
        }
        return this.f22693c;
    }
}
