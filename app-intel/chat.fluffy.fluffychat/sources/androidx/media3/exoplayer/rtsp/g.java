package androidx.media3.exoplayer.rtsp;

import B0.A;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.media3.exoplayer.rtsp.g;
import c1.m;
import j3.o;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import k3.AbstractC1279v;

/* loaded from: classes.dex */
public final class g implements Closeable {

    /* renamed from: r, reason: collision with root package name */
    public static final Charset f12773r = StandardCharsets.UTF_8;

    /* renamed from: l, reason: collision with root package name */
    public final d f12774l;

    /* renamed from: m, reason: collision with root package name */
    public final c1.m f12775m = new c1.m("ExoPlayer:RtspMessageChannel:ReceiverLoader");

    /* renamed from: n, reason: collision with root package name */
    public final Map f12776n = Collections.synchronizedMap(new HashMap());

    /* renamed from: o, reason: collision with root package name */
    public C0117g f12777o;

    /* renamed from: p, reason: collision with root package name */
    public Socket f12778p;

    /* renamed from: q, reason: collision with root package name */
    public volatile boolean f12779q;

    public interface b {
        void f(byte[] bArr);
    }

    public final class c implements m.b {
        public c() {
        }

        @Override // c1.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void i(f fVar, long j7, long j8, boolean z7) {
        }

        @Override // c1.m.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void t(f fVar, long j7, long j8) {
        }

        @Override // c1.m.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public m.c q(f fVar, long j7, long j8, IOException iOException, int i7) {
            if (!g.this.f12779q) {
                g.this.f12774l.a(iOException);
            }
            return c1.m.f13924f;
        }
    }

    public interface d {
        default void a(Exception exc) {
        }

        default void b(List list, Exception exc) {
        }

        void c(List list);
    }

    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final List f12781a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public int f12782b = 1;

        /* renamed from: c, reason: collision with root package name */
        public long f12783c;

        public static byte[] d(byte b7, DataInputStream dataInputStream) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = {b7, dataInputStream.readByte()};
            byteArrayOutputStream.write(bArr);
            while (true) {
                if (bArr[0] == 13 && bArr[1] == 10) {
                    return byteArrayOutputStream.toByteArray();
                }
                bArr[0] = bArr[1];
                byte b8 = dataInputStream.readByte();
                bArr[1] = b8;
                byteArrayOutputStream.write(b8);
            }
        }

        public final AbstractC1279v a(byte[] bArr) {
            o.v(this.f12782b == 3);
            if (bArr.length <= 0 || bArr[bArr.length - 1] != 10) {
                throw new IllegalArgumentException("Message body is empty or does not end with a LF.");
            }
            this.f12781a.add((bArr.length <= 1 || bArr[bArr.length + (-2)] != 13) ? new String(bArr, 0, bArr.length - 1, g.f12773r) : new String(bArr, 0, bArr.length - 2, g.f12773r));
            AbstractC1279v abstractC1279vR = AbstractC1279v.r(this.f12781a);
            e();
            return abstractC1279vR;
        }

        public final AbstractC1279v b(byte[] bArr) throws A {
            o.d(bArr.length >= 2 && bArr[bArr.length - 2] == 13 && bArr[bArr.length - 1] == 10);
            String str = new String(bArr, 0, bArr.length - 2, g.f12773r);
            this.f12781a.add(str);
            int i7 = this.f12782b;
            if (i7 == 1) {
                if (!h.f(str)) {
                    return null;
                }
                this.f12782b = 2;
                return null;
            }
            if (i7 != 2) {
                throw new IllegalStateException();
            }
            long jG = h.g(str);
            if (jG != -1) {
                this.f12783c = jG;
            }
            if (!str.isEmpty()) {
                return null;
            }
            if (this.f12783c > 0) {
                this.f12782b = 3;
                return null;
            }
            AbstractC1279v abstractC1279vR = AbstractC1279v.r(this.f12781a);
            e();
            return abstractC1279vR;
        }

        public AbstractC1279v c(byte b7, DataInputStream dataInputStream) throws IOException {
            AbstractC1279v abstractC1279vB = b(d(b7, dataInputStream));
            while (abstractC1279vB == null) {
                if (this.f12782b == 3) {
                    long j7 = this.f12783c;
                    if (j7 <= 0) {
                        throw new IllegalStateException("Expects a greater than zero Content-Length.");
                    }
                    int iE = o3.g.e(j7);
                    o.v(iE != -1);
                    byte[] bArr = new byte[iE];
                    dataInputStream.readFully(bArr, 0, iE);
                    abstractC1279vB = a(bArr);
                } else {
                    abstractC1279vB = b(d(dataInputStream.readByte(), dataInputStream));
                }
            }
            return abstractC1279vB;
        }

        public final void e() {
            this.f12781a.clear();
            this.f12782b = 1;
            this.f12783c = 0L;
        }
    }

    public final class f implements m.e {

        /* renamed from: a, reason: collision with root package name */
        public final DataInputStream f12784a;

        /* renamed from: b, reason: collision with root package name */
        public final e f12785b = new e();

        /* renamed from: c, reason: collision with root package name */
        public volatile boolean f12786c;

        public f(InputStream inputStream) {
            this.f12784a = new DataInputStream(inputStream);
        }

        @Override // c1.m.e
        public void a() throws IOException {
            while (!this.f12786c) {
                byte b7 = this.f12784a.readByte();
                if (b7 == 36) {
                    b();
                } else {
                    d(b7);
                }
            }
        }

        public final void b() throws IOException {
            int unsignedByte = this.f12784a.readUnsignedByte();
            int unsignedShort = this.f12784a.readUnsignedShort();
            byte[] bArr = new byte[unsignedShort];
            this.f12784a.readFully(bArr, 0, unsignedShort);
            b bVar = (b) g.this.f12776n.get(Integer.valueOf(unsignedByte));
            if (bVar == null || g.this.f12779q) {
                return;
            }
            bVar.f(bArr);
        }

        @Override // c1.m.e
        public void c() {
            this.f12786c = true;
        }

        public final void d(byte b7) {
            if (g.this.f12779q) {
                return;
            }
            g.this.f12774l.c(this.f12785b.c(b7, this.f12784a));
        }
    }

    /* renamed from: androidx.media3.exoplayer.rtsp.g$g, reason: collision with other inner class name */
    public final class C0117g implements Closeable {

        /* renamed from: l, reason: collision with root package name */
        public final OutputStream f12788l;

        /* renamed from: m, reason: collision with root package name */
        public final HandlerThread f12789m;

        /* renamed from: n, reason: collision with root package name */
        public final Handler f12790n;

        public C0117g(OutputStream outputStream) {
            this.f12788l = outputStream;
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:RtspMessageChannel:Sender");
            this.f12789m = handlerThread;
            handlerThread.start();
            this.f12790n = new Handler(handlerThread.getLooper());
        }

        public static /* synthetic */ void a(C0117g c0117g, byte[] bArr, List list) throws IOException {
            c0117g.getClass();
            try {
                c0117g.f12788l.write(bArr);
            } catch (Exception e7) {
                if (g.this.f12779q) {
                    return;
                }
                g.this.f12774l.b(list, e7);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws InterruptedException {
            Handler handler = this.f12790n;
            final HandlerThread handlerThread = this.f12789m;
            Objects.requireNonNull(handlerThread);
            handler.post(new Runnable() { // from class: U0.o
                @Override // java.lang.Runnable
                public final void run() {
                    handlerThread.quit();
                }
            });
            try {
                this.f12789m.join();
            } catch (InterruptedException unused) {
                this.f12789m.interrupt();
            }
        }

        public void d(final List list) {
            final byte[] bArrB = h.b(list);
            this.f12790n.post(new Runnable() { // from class: U0.p
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    g.C0117g.a(this.f8367l, bArrB, list);
                }
            });
        }
    }

    public g(d dVar) {
        this.f12774l = dVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f12779q) {
            return;
        }
        try {
            C0117g c0117g = this.f12777o;
            if (c0117g != null) {
                c0117g.close();
            }
            this.f12775m.l();
            Socket socket = this.f12778p;
            if (socket != null) {
                socket.close();
            }
            this.f12779q = true;
        } catch (Throwable th) {
            this.f12779q = true;
            throw th;
        }
    }

    public void f(Socket socket) {
        this.f12778p = socket;
        this.f12777o = new C0117g(socket.getOutputStream());
        this.f12775m.n(new f(socket.getInputStream()), new c(), 0);
    }

    public void i(int i7, b bVar) {
        this.f12776n.put(Integer.valueOf(i7), bVar);
    }

    public void j(List list) {
        o.q(this.f12777o);
        this.f12777o.d(list);
    }
}
