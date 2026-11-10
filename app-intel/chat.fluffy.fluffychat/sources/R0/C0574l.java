package R0;

import R0.InterfaceC0582u;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayDeque;
import y.C1791e;

/* renamed from: R0.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0574l extends MediaCodec.Callback {

    /* renamed from: b, reason: collision with root package name */
    public final HandlerThread f7822b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f7823c;

    /* renamed from: h, reason: collision with root package name */
    public MediaFormat f7828h;

    /* renamed from: i, reason: collision with root package name */
    public MediaFormat f7829i;

    /* renamed from: j, reason: collision with root package name */
    public MediaCodec.CodecException f7830j;

    /* renamed from: k, reason: collision with root package name */
    public MediaCodec.CryptoException f7831k;

    /* renamed from: l, reason: collision with root package name */
    public long f7832l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f7833m;

    /* renamed from: n, reason: collision with root package name */
    public IllegalStateException f7834n;

    /* renamed from: o, reason: collision with root package name */
    public InterfaceC0582u.c f7835o;

    /* renamed from: a, reason: collision with root package name */
    public final Object f7821a = new Object();

    /* renamed from: d, reason: collision with root package name */
    public final C1791e f7824d = new C1791e();

    /* renamed from: e, reason: collision with root package name */
    public final C1791e f7825e = new C1791e();

    /* renamed from: f, reason: collision with root package name */
    public final ArrayDeque f7826f = new ArrayDeque();

    /* renamed from: g, reason: collision with root package name */
    public final ArrayDeque f7827g = new ArrayDeque();

    public C0574l(HandlerThread handlerThread) {
        this.f7822b = handlerThread;
    }

    public final void b(MediaFormat mediaFormat) {
        this.f7825e.a(-2);
        this.f7827g.add(mediaFormat);
    }

    public int c() {
        synchronized (this.f7821a) {
            try {
                j();
                int iE = -1;
                if (i()) {
                    return -1;
                }
                if (!this.f7824d.d()) {
                    iE = this.f7824d.e();
                }
                return iE;
            } finally {
            }
        }
    }

    public int d(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f7821a) {
            try {
                j();
                if (i()) {
                    return -1;
                }
                if (this.f7825e.d()) {
                    return -1;
                }
                int iE = this.f7825e.e();
                if (iE >= 0) {
                    j3.o.q(this.f7828h);
                    MediaCodec.BufferInfo bufferInfo2 = (MediaCodec.BufferInfo) this.f7826f.remove();
                    bufferInfo.set(bufferInfo2.offset, bufferInfo2.size, bufferInfo2.presentationTimeUs, bufferInfo2.flags);
                } else if (iE == -2) {
                    this.f7828h = (MediaFormat) this.f7827g.remove();
                }
                return iE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e() {
        synchronized (this.f7821a) {
            this.f7832l++;
            ((Handler) E0.U.i(this.f7823c)).post(new Runnable() { // from class: R0.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7820l.n();
                }
            });
        }
    }

    public final void f() {
        if (!this.f7827g.isEmpty()) {
            this.f7829i = (MediaFormat) this.f7827g.getLast();
        }
        this.f7824d.b();
        this.f7825e.b();
        this.f7826f.clear();
        this.f7827g.clear();
    }

    public MediaFormat g() {
        MediaFormat mediaFormat;
        synchronized (this.f7821a) {
            try {
                mediaFormat = this.f7828h;
                if (mediaFormat == null) {
                    throw new IllegalStateException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaFormat;
    }

    public void h(MediaCodec mediaCodec) {
        j3.o.v(this.f7823c == null);
        this.f7822b.start();
        Handler handler = new Handler(this.f7822b.getLooper());
        mediaCodec.setCallback(this, handler);
        this.f7823c = handler;
    }

    public final boolean i() {
        return this.f7832l > 0 || this.f7833m;
    }

    public final void j() {
        k();
        m();
        l();
    }

    public final void k() {
        IllegalStateException illegalStateException = this.f7834n;
        if (illegalStateException == null) {
            return;
        }
        this.f7834n = null;
        throw illegalStateException;
    }

    public final void l() {
        MediaCodec.CryptoException cryptoException = this.f7831k;
        if (cryptoException == null) {
            return;
        }
        this.f7831k = null;
        throw cryptoException;
    }

    public final void m() {
        MediaCodec.CodecException codecException = this.f7830j;
        if (codecException == null) {
            return;
        }
        this.f7830j = null;
        throw codecException;
    }

    public final void n() {
        synchronized (this.f7821a) {
            try {
                if (this.f7833m) {
                    return;
                }
                long j7 = this.f7832l - 1;
                this.f7832l = j7;
                if (j7 > 0) {
                    return;
                }
                if (j7 < 0) {
                    o(new IllegalStateException());
                } else {
                    f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void o(IllegalStateException illegalStateException) {
        synchronized (this.f7821a) {
            this.f7834n = illegalStateException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onCryptoError(MediaCodec mediaCodec, MediaCodec.CryptoException cryptoException) {
        synchronized (this.f7821a) {
            this.f7831k = cryptoException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f7821a) {
            this.f7830j = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i7) {
        synchronized (this.f7821a) {
            try {
                this.f7824d.a(i7);
                InterfaceC0582u.c cVar = this.f7835o;
                if (cVar != null) {
                    cVar.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i7, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f7821a) {
            try {
                MediaFormat mediaFormat = this.f7829i;
                if (mediaFormat != null) {
                    b(mediaFormat);
                    this.f7829i = null;
                }
                this.f7825e.a(i7);
                this.f7826f.add(bufferInfo);
                InterfaceC0582u.c cVar = this.f7835o;
                if (cVar != null) {
                    cVar.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f7821a) {
            b(mediaFormat);
            this.f7829i = null;
        }
    }

    public void p(InterfaceC0582u.c cVar) {
        synchronized (this.f7821a) {
            this.f7835o = cVar;
        }
    }

    public void q() {
        synchronized (this.f7821a) {
            this.f7833m = true;
            this.f7822b.quit();
            f();
        }
    }

    public void r(Runnable runnable) {
        synchronized (this.f7821a) {
            j();
            runnable.run();
        }
    }
}
