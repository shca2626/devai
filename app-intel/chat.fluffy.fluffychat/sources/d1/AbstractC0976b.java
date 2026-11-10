package d1;

import android.os.SystemClock;
import c1.m;
import j3.o;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.ConcurrentModificationException;

/* renamed from: d1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0976b {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f15109a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f15110b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static boolean f15111c = false;

    /* renamed from: d, reason: collision with root package name */
    public static long f15112d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static String f15113e = "time.android.com";

    /* renamed from: f, reason: collision with root package name */
    public static int f15114f = 1000;

    /* renamed from: g, reason: collision with root package name */
    public static long f15115g = -9223372036854775807L;

    /* renamed from: h, reason: collision with root package name */
    public static long f15116h = -9223372036854775807L;

    /* renamed from: d1.b$b, reason: collision with other inner class name */
    public interface InterfaceC0153b {
        void a(IOException iOException);

        void b();
    }

    public static void h(byte b7, byte b8, int i7, long j7) throws IOException {
        if (b7 == 3) {
            throw new IOException("SNTP: Unsynchronized server");
        }
        if (b8 != 4 && b8 != 5) {
            throw new IOException("SNTP: Untrusted mode: " + ((int) b8));
        }
        if (i7 != 0 && i7 <= 15) {
            if (j7 == 0) {
                throw new IOException("SNTP: Zero transmitTime");
            }
        } else {
            throw new IOException("SNTP: Untrusted stratum: " + i7);
        }
    }

    public static long i() {
        long j7;
        synchronized (f15110b) {
            try {
                j7 = f15111c ? f15112d : -9223372036854775807L;
            } catch (Throwable th) {
                throw th;
            }
        }
        return j7;
    }

    public static String j() {
        String str;
        synchronized (f15110b) {
            str = f15113e;
        }
        return str;
    }

    public static int k() {
        int i7;
        synchronized (f15110b) {
            i7 = f15114f;
        }
        return i7;
    }

    public static void l(m mVar, InterfaceC0153b interfaceC0153b) {
        if (m()) {
            if (interfaceC0153b != null) {
                interfaceC0153b.b();
            }
        } else {
            if (mVar == null) {
                mVar = new m("SntpClient");
            }
            mVar.n(new d(), new c(interfaceC0153b), 1);
        }
    }

    public static boolean m() {
        boolean z7;
        synchronized (f15110b) {
            try {
                if (f15116h != -9223372036854775807L && f15115g != -9223372036854775807L) {
                    f15111c = f15111c && SystemClock.elapsedRealtime() - f15116h < f15115g;
                }
                z7 = f15111c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z7;
    }

    public static long n() {
        DatagramSocket datagramSocket = new DatagramSocket();
        try {
            datagramSocket.setSoTimeout(k());
            InetAddress[] allByName = InetAddress.getAllByName(j());
            int length = allByName.length;
            SocketTimeoutException socketTimeoutException = null;
            int i7 = 0;
            int i8 = 0;
            while (i7 < length) {
                byte[] bArr = new byte[48];
                DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, allByName[i7], 123);
                bArr[0] = 27;
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                q(bArr, 40, jCurrentTimeMillis);
                datagramSocket.send(datagramPacket);
                try {
                    datagramSocket.receive(new DatagramPacket(bArr, 48));
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    long j7 = jCurrentTimeMillis + (jElapsedRealtime2 - jElapsedRealtime);
                    byte b7 = bArr[0];
                    int i9 = bArr[1] & 255;
                    long jP = p(bArr, 24);
                    long jP2 = p(bArr, 32);
                    long jP3 = p(bArr, 40);
                    h((byte) ((b7 >> 6) & 3), (byte) (b7 & 7), i9, jP3);
                    long j8 = (j7 + (((jP2 - jP) + (jP3 - j7)) / 2)) - jElapsedRealtime2;
                    datagramSocket.close();
                    return j8;
                } catch (SocketTimeoutException e7) {
                    if (socketTimeoutException == null) {
                        socketTimeoutException = e7;
                    } else {
                        socketTimeoutException.addSuppressed(e7);
                    }
                    int i10 = i8 + 1;
                    if (i8 >= 10) {
                        break;
                    }
                    i7++;
                    i8 = i10;
                }
            }
            throw ((SocketTimeoutException) o.q(socketTimeoutException));
        } finally {
        }
    }

    public static long o(byte[] bArr, int i7) {
        int i8 = bArr[i7];
        int i9 = bArr[i7 + 1];
        int i10 = bArr[i7 + 2];
        int i11 = bArr[i7 + 3];
        if ((i8 & 128) == 128) {
            i8 = (i8 & 127) + 128;
        }
        if ((i9 & 128) == 128) {
            i9 = (i9 & 127) + 128;
        }
        if ((i10 & 128) == 128) {
            i10 = (i10 & 127) + 128;
        }
        if ((i11 & 128) == 128) {
            i11 = (i11 & 127) + 128;
        }
        return (i8 << 24) + (i9 << 16) + (i10 << 8) + i11;
    }

    public static long p(byte[] bArr, int i7) {
        long jO = o(bArr, i7);
        long jO2 = o(bArr, i7 + 4);
        if (jO == 0 && jO2 == 0) {
            return 0L;
        }
        return ((jO - 2208988800L) * 1000) + ((jO2 * 1000) / 4294967296L);
    }

    public static void q(byte[] bArr, int i7, long j7) {
        if (j7 == 0) {
            Arrays.fill(bArr, i7, i7 + 8, (byte) 0);
            return;
        }
        long j8 = j7 / 1000;
        long j9 = j7 - (j8 * 1000);
        bArr[i7] = (byte) (r2 >> 24);
        bArr[i7 + 1] = (byte) (r2 >> 16);
        bArr[i7 + 2] = (byte) (r2 >> 8);
        bArr[i7 + 3] = (byte) (j8 + 2208988800L);
        long j10 = (j9 * 4294967296L) / 1000;
        bArr[i7 + 4] = (byte) (j10 >> 24);
        bArr[i7 + 5] = (byte) (j10 >> 16);
        bArr[i7 + 6] = (byte) (j10 >> 8);
        bArr[i7 + 7] = (byte) (Math.random() * 255.0d);
    }

    /* renamed from: d1.b$d */
    public static final class d implements m.e {
        public d() {
        }

        @Override // c1.m.e
        public void a() {
            synchronized (AbstractC0976b.f15109a) {
                synchronized (AbstractC0976b.f15110b) {
                    if (AbstractC0976b.f15111c) {
                        return;
                    }
                    long jN = AbstractC0976b.n();
                    synchronized (AbstractC0976b.f15110b) {
                        long unused = AbstractC0976b.f15116h = SystemClock.elapsedRealtime();
                        long unused2 = AbstractC0976b.f15112d = jN;
                        boolean unused3 = AbstractC0976b.f15111c = true;
                    }
                }
            }
        }

        @Override // c1.m.e
        public void c() {
        }
    }

    /* renamed from: d1.b$c */
    public static final class c implements m.b {

        /* renamed from: l, reason: collision with root package name */
        public final InterfaceC0153b f15117l;

        public c(InterfaceC0153b interfaceC0153b) {
            this.f15117l = interfaceC0153b;
        }

        @Override // c1.m.b
        public m.c q(m.e eVar, long j7, long j8, IOException iOException, int i7) {
            InterfaceC0153b interfaceC0153b = this.f15117l;
            if (interfaceC0153b != null) {
                interfaceC0153b.a(iOException);
            }
            return m.f13924f;
        }

        @Override // c1.m.b
        public void t(m.e eVar, long j7, long j8) {
            if (this.f15117l != null) {
                if (AbstractC0976b.m()) {
                    this.f15117l.b();
                } else {
                    this.f15117l.a(new IOException(new ConcurrentModificationException()));
                }
            }
        }

        @Override // c1.m.b
        public void i(m.e eVar, long j7, long j8, boolean z7) {
        }
    }
}
