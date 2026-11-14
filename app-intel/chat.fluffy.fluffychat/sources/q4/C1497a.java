package q4;

import M5.g;
import M5.m;
import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AutomaticGainControl;
import android.media.audiofx.NoiseSuppressor;
import android.util.Log;
import v4.C1685c;

/* renamed from: q4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1497a implements AutoCloseable {

    /* renamed from: p, reason: collision with root package name */
    public static final C0257a f21430p = new C0257a(null);

    /* renamed from: q, reason: collision with root package name */
    public static final String f21431q = C1497a.class.getSimpleName();

    /* renamed from: l, reason: collision with root package name */
    public final int f21432l;

    /* renamed from: m, reason: collision with root package name */
    public AutomaticGainControl f21433m;

    /* renamed from: n, reason: collision with root package name */
    public AcousticEchoCanceler f21434n;

    /* renamed from: o, reason: collision with root package name */
    public NoiseSuppressor f21435o;

    /* renamed from: q4.a$a, reason: collision with other inner class name */
    public static final class C0257a {
        public /* synthetic */ C0257a(g gVar) {
            this();
        }

        public C0257a() {
        }
    }

    public C1497a(int i7) {
        this.f21432l = i7;
    }

    public final void a(C1685c c1685c) throws IllegalStateException {
        m.e(c1685c, "config");
        if (AutomaticGainControl.isAvailable()) {
            AutomaticGainControl automaticGainControlCreate = AutomaticGainControl.create(this.f21432l);
            this.f21433m = automaticGainControlCreate;
            if (automaticGainControlCreate != null) {
                automaticGainControlCreate.setEnabled(c1685c.e());
            }
        } else if (c1685c.e()) {
            Log.d(f21431q, "Auto gain effect is not available.");
        }
        if (AcousticEchoCanceler.isAvailable()) {
            AcousticEchoCanceler acousticEchoCancelerCreate = AcousticEchoCanceler.create(this.f21432l);
            this.f21434n = acousticEchoCancelerCreate;
            if (acousticEchoCancelerCreate != null) {
                acousticEchoCancelerCreate.setEnabled(c1685c.h());
            }
        } else if (c1685c.h()) {
            Log.d(f21431q, "Echo canceler effect is not available.");
        }
        if (!NoiseSuppressor.isAvailable()) {
            if (c1685c.l()) {
                Log.d(f21431q, "Noise suppressor effect is not available.");
            }
        } else {
            NoiseSuppressor noiseSuppressorCreate = NoiseSuppressor.create(this.f21432l);
            this.f21435o = noiseSuppressorCreate;
            if (noiseSuppressorCreate != null) {
                noiseSuppressorCreate.setEnabled(c1685c.l());
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        d();
    }

    public final void d() {
        AutomaticGainControl automaticGainControl = this.f21433m;
        if (automaticGainControl != null) {
            automaticGainControl.release();
        }
        AcousticEchoCanceler acousticEchoCanceler = this.f21434n;
        if (acousticEchoCanceler != null) {
            acousticEchoCanceler.release();
        }
        NoiseSuppressor noiseSuppressor = this.f21435o;
        if (noiseSuppressor != null) {
            noiseSuppressor.release();
        }
    }
}
