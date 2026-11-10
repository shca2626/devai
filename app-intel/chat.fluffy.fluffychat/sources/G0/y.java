package G0;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/* loaded from: classes.dex */
public final class y extends b {

    /* renamed from: e, reason: collision with root package name */
    public final int f3229e;

    /* renamed from: f, reason: collision with root package name */
    public final byte[] f3230f;

    /* renamed from: g, reason: collision with root package name */
    public final DatagramPacket f3231g;

    /* renamed from: h, reason: collision with root package name */
    public Uri f3232h;

    /* renamed from: i, reason: collision with root package name */
    public DatagramSocket f3233i;

    /* renamed from: j, reason: collision with root package name */
    public MulticastSocket f3234j;

    /* renamed from: k, reason: collision with root package name */
    public InetAddress f3235k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3236l;

    /* renamed from: m, reason: collision with root package name */
    public int f3237m;

    public static final class a extends g {
        public a(Throwable th, int i7) {
            super(th, i7);
        }
    }

    public y() {
        this(2000);
    }

    @Override // G0.f
    public void close() throws IOException {
        this.f3232h = null;
        MulticastSocket multicastSocket = this.f3234j;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup((InetAddress) j3.o.q(this.f3235k));
            } catch (IOException unused) {
            }
            this.f3234j = null;
        }
        DatagramSocket datagramSocket = this.f3233i;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f3233i = null;
        }
        this.f3235k = null;
        this.f3237m = 0;
        if (this.f3236l) {
            this.f3236l = false;
            v();
        }
    }

    public int d() {
        DatagramSocket datagramSocket = this.f3233i;
        if (datagramSocket == null) {
            return -1;
        }
        return datagramSocket.getLocalPort();
    }

    @Override // G0.f
    public Uri r() {
        return this.f3232h;
    }

    @Override // B0.InterfaceC0309k
    public int read(byte[] bArr, int i7, int i8) throws IOException {
        if (i8 == 0) {
            return 0;
        }
        if (this.f3237m == 0) {
            try {
                ((DatagramSocket) j3.o.q(this.f3233i)).receive(this.f3231g);
                int length = this.f3231g.getLength();
                this.f3237m = length;
                u(length);
            } catch (SocketTimeoutException e7) {
                throw new a(e7, 2002);
            } catch (IOException e8) {
                throw new a(e8, 2001);
            }
        }
        int length2 = this.f3231g.getLength();
        int i9 = this.f3237m;
        int iMin = Math.min(i9, i8);
        System.arraycopy(this.f3230f, length2 - i9, bArr, i7, iMin);
        this.f3237m -= iMin;
        return iMin;
    }

    @Override // G0.f
    public long s(j jVar) throws IOException {
        Uri uri = jVar.f3143a;
        this.f3232h = uri;
        String str = (String) j3.o.q(uri.getHost());
        int port = this.f3232h.getPort();
        w(jVar);
        try {
            this.f3235k = InetAddress.getByName(str);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f3235k, port);
            if (this.f3235k.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.f3234j = multicastSocket;
                multicastSocket.joinGroup(this.f3235k);
                this.f3233i = this.f3234j;
            } else {
                this.f3233i = new DatagramSocket(inetSocketAddress);
            }
            this.f3233i.setSoTimeout(this.f3229e);
            this.f3236l = true;
            x(jVar);
            return -1L;
        } catch (IOException e7) {
            throw new a(e7, 2001);
        } catch (SecurityException e8) {
            throw new a(e8, 2006);
        }
    }

    public y(int i7) {
        this(i7, 8000);
    }

    public y(int i7, int i8) {
        super(true);
        this.f3229e = i8;
        byte[] bArr = new byte[i7];
        this.f3230f = bArr;
        this.f3231g = new DatagramPacket(bArr, 0, i7);
    }
}
