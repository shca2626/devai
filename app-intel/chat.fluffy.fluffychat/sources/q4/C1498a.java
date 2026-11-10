package q4;

import M5.g;
import M5.m;
import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AutomaticGainControl;
import android.media.audiofx.NoiseSuppressor;
import android.util.Log;
import v4.C1686c;

/* renamed from: q4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1498a implements AutoCloseable {

    /* renamed from: p, reason: collision with root package name */
    public static final C0257a f21424p = new C0257a(null);

    /* renamed from: q, reason: collision with root package name */
    public static final String f21425q = C1498a.class.getSimpleName();

    /* renamed from: l, reason: collision with root package name */
    public final int f21426l;

    /* renamed from: m, reason: collision with root package name */
    public AutomaticGainControl f21427m;

    /* renamed from: n, reason: collision with root package name */
    public AcousticEchoCanceler f21428n;

    /* renamed from: o, reason: collision with root package name */
    public NoiseSuppressor f21429o;

    /* renamed from: q4.a$a, reason: collision with other inner class name */
    public static final class C0257a {
        public /* synthetic */ C0257a(g gVar) {
            this();
        }

        public C0257a() {
        }
    }

    public C1498a(int i7) {
        this.f21426l = i7;
    }

    public final void a(C1686c c1686c) throws IllegalStateException {
        m.e(c1686c, "config");
        if (AutomaticGainControl.isAvailable()) {
            AutomaticGainControl automaticGainControlCreate = AutomaticGainControl.create(this.f21426l);
            this.f21427m = automaticGainControlCreate;
            if (automaticGainControlCreate != null) {
                automaticGainControlCreate.setEnabled(c1686c.e());
            }
        } else if (c1686c.e()) {
            Log.d(f21425q, "Auto gain effect is not available.");
        }
        if (AcousticEchoCanceler.isAvailable()) {
            AcousticEchoCanceler acousticEchoCancelerCreate = AcousticEchoCanceler.create(this.f21426l);
            this.f21428n = acousticEchoCancelerCreate;
            if (acousticEchoCancelerCreate != null) {
                acousticEchoCancelerCreate.setEnabled(c1686c.h());
            }
        } else if (c1686c.h()) {
            Log.d(f21425q, "Echo canceler effect is not available.");
        }
        if (!NoiseSuppressor.isAvailable()) {
            if (c1686c.l()) {
                Log.d(f21425q, "Noise suppressor effect is not available.");
            }
        } else {
            NoiseSuppressor noiseSuppressorCreate = NoiseSuppressor.create(this.f21426l);
            this.f21429o = noiseSuppressorCreate;
            if (noiseSuppressorCreate != null) {
                noiseSuppressorCreate.setEnabled(c1686c.l());
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        d();
    }

    public final void d() {
        AutomaticGainControl automaticGainControl = this.f21427m;
        if (automaticGainControl != null) {
            automaticGainControl.release();
        }
        AcousticEchoCanceler acousticEchoCanceler = this.f21428n;
        if (acousticEchoCanceler != null) {
            acousticEchoCanceler.release();
        }
        NoiseSuppressor noiseSuppressor = this.f21429o;
        if (noiseSuppressor != null) {
            noiseSuppressor.release();
        }
    }
}
