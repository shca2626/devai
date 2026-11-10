package R0;

import E0.C0324j;
import android.media.MediaCodec;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: R0.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0572j implements InterfaceC0583v {

    /* renamed from: g, reason: collision with root package name */
    public static final ArrayDeque f7805g = new ArrayDeque();

    /* renamed from: h, reason: collision with root package name */
    public static final Object f7806h = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final MediaCodec f7807a;

    /* renamed from: b, reason: collision with root package name */
    public final HandlerThread f7808b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f7809c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReference f7810d;

    /* renamed from: e, reason: collision with root package name */
    public final C0324j f7811e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7812f;

    /* renamed from: R0.j$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws MediaCodec.CryptoException {
            C0572j.this.h(message);
        }
    }

    /* renamed from: R0.j$b */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f7814a;

        /* renamed from: b, reason: collision with root package name */
        public int f7815b;

        /* renamed from: c, reason: collision with root package name */
        public int f7816c;

        /* renamed from: d, reason: collision with root package name */
        public final MediaCodec.CryptoInfo f7817d = new MediaCodec.CryptoInfo();

        /* renamed from: e, reason: collision with root package name */
        public long f7818e;

        /* renamed from: f, reason: collision with root package name */
        public int f7819f;

        public void a(int i7, int i8, int i9, long j7, int i10) {
            this.f7814a = i7;
            this.f7815b = i8;
            this.f7816c = i9;
            this.f7818e = j7;
            this.f7819f = i10;
        }
    }

    public C0572j(MediaCodec mediaCodec, HandlerThread handlerThread) {
        this(mediaCodec, handlerThread, new C0324j());
    }

    public static void e(H0.c cVar, MediaCodec.CryptoInfo cryptoInfo) {
        cryptoInfo.numSubSamples = cVar.f3321f;
        cryptoInfo.numBytesOfClearData = g(cVar.f3319d, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = g(cVar.f3320e, cryptoInfo.numBytesOfEncryptedData);
        cryptoInfo.key = (byte[]) j3.o.q(f(cVar.f3317b, cryptoInfo.key));
        cryptoInfo.iv = (byte[]) j3.o.q(f(cVar.f3316a, cryptoInfo.iv));
        cryptoInfo.mode = cVar.f3318c;
        cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(cVar.f3322g, cVar.f3323h));
    }

    public static byte[] f(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static int[] g(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    public static b m() {
        ArrayDeque arrayDeque = f7805g;
        synchronized (arrayDeque) {
            try {
                if (arrayDeque.isEmpty()) {
                    return new b();
                }
                return (b) arrayDeque.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void n(b bVar) {
        ArrayDeque arrayDeque = f7805g;
        synchronized (arrayDeque) {
            arrayDeque.add(bVar);
        }
    }

    @Override // R0.InterfaceC0583v
    public void a(int i7, int i8, H0.c cVar, long j7, int i9) {
        b();
        b bVarM = m();
        bVarM.a(i7, i8, 0, j7, i9);
        e(cVar, bVarM.f7817d);
        ((Handler) E0.U.i(this.f7809c)).obtainMessage(2, bVarM).sendToTarget();
    }

    @Override // R0.InterfaceC0583v
    public void b() {
        RuntimeException runtimeException = (RuntimeException) this.f7810d.getAndSet(null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    public final void d() {
        this.f7811e.d();
        ((Handler) j3.o.q(this.f7809c)).obtainMessage(3).sendToTarget();
        this.f7811e.a();
    }

    @Override // R0.InterfaceC0583v
    public void flush() {
        if (this.f7812f) {
            try {
                l();
            } catch (InterruptedException e7) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e7);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(android.os.Message r9) throws android.media.MediaCodec.CryptoException {
        /*
            r8 = this;
            int r2 = r9.what
            r3 = 1
            if (r2 == r3) goto L43
            r3 = 2
            if (r2 == r3) goto L2e
            r3 = 3
            r4 = 0
            if (r2 == r3) goto L28
            r3 = 4
            if (r2 == r3) goto L20
            java.util.concurrent.atomic.AtomicReference r2 = r8.f7810d
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            int r1 = r9.what
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r3.<init>(r1)
            R0.AbstractC0571i.a(r2, r4, r3)
            goto L57
        L20:
            java.lang.Object r1 = r9.obj
            android.os.Bundle r1 = (android.os.Bundle) r1
            r8.k(r1)
            goto L57
        L28:
            E0.j r1 = r8.f7811e
            r1.f()
            goto L57
        L2e:
            java.lang.Object r1 = r9.obj
            r7 = r1
            R0.j$b r7 = (R0.C0572j.b) r7
            int r1 = r7.f7814a
            int r2 = r7.f7815b
            android.media.MediaCodec$CryptoInfo r3 = r7.f7817d
            long r4 = r7.f7818e
            int r6 = r7.f7819f
            r0 = r8
            r0.j(r1, r2, r3, r4, r6)
        L41:
            r4 = r7
            goto L57
        L43:
            java.lang.Object r0 = r9.obj
            r7 = r0
            R0.j$b r7 = (R0.C0572j.b) r7
            int r1 = r7.f7814a
            int r2 = r7.f7815b
            int r3 = r7.f7816c
            long r4 = r7.f7818e
            int r6 = r7.f7819f
            r0 = r8
            r0.i(r1, r2, r3, r4, r6)
            goto L41
        L57:
            if (r4 == 0) goto L5c
            n(r4)
        L5c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: R0.C0572j.h(android.os.Message):void");
    }

    public final void i(int i7, int i8, int i9, long j7, int i10) throws MediaCodec.CryptoException {
        try {
            this.f7807a.queueInputBuffer(i7, i8, i9, j7, i10);
        } catch (RuntimeException e7) {
            AbstractC0571i.a(this.f7810d, null, e7);
        }
    }

    public final void j(int i7, int i8, MediaCodec.CryptoInfo cryptoInfo, long j7, int i9) {
        try {
            synchronized (f7806h) {
                this.f7807a.queueSecureInputBuffer(i7, i8, cryptoInfo, j7, i9);
            }
        } catch (RuntimeException e7) {
            AbstractC0571i.a(this.f7810d, null, e7);
        }
    }

    public final void k(Bundle bundle) {
        try {
            this.f7807a.setParameters(bundle);
        } catch (RuntimeException e7) {
            AbstractC0571i.a(this.f7810d, null, e7);
        }
    }

    public final void l() {
        ((Handler) j3.o.q(this.f7809c)).removeCallbacksAndMessages(null);
        d();
    }

    @Override // R0.InterfaceC0583v
    public void queueInputBuffer(int i7, int i8, int i9, long j7, int i10) {
        b();
        b bVarM = m();
        bVarM.a(i7, i8, i9, j7, i10);
        ((Handler) E0.U.i(this.f7809c)).obtainMessage(1, bVarM).sendToTarget();
    }

    @Override // R0.InterfaceC0583v
    public void setParameters(Bundle bundle) {
        b();
        ((Handler) E0.U.i(this.f7809c)).obtainMessage(4, bundle).sendToTarget();
    }

    @Override // R0.InterfaceC0583v
    public void shutdown() {
        if (this.f7812f) {
            flush();
            this.f7808b.quit();
        }
        this.f7812f = false;
    }

    @Override // R0.InterfaceC0583v
    public void start() {
        if (this.f7812f) {
            return;
        }
        this.f7808b.start();
        this.f7809c = new a(this.f7808b.getLooper());
        this.f7812f = true;
    }

    public C0572j(MediaCodec mediaCodec, HandlerThread handlerThread, C0324j c0324j) {
        this.f7807a = mediaCodec;
        this.f7808b = handlerThread;
        this.f7811e = c0324j;
        this.f7810d = new AtomicReference();
    }
}
