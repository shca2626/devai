package v5;

import android.media.AudioTrack;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.TimeUnit;

/* renamed from: v5.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1698g {

    /* renamed from: j, reason: collision with root package name */
    public static final a f23093j = new a(null);

    /* renamed from: k, reason: collision with root package name */
    public static final ByteBuffer f23094k = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    /* renamed from: a, reason: collision with root package name */
    public A4.a f23095a;

    /* renamed from: b, reason: collision with root package name */
    public C1692a f23096b;

    /* renamed from: c, reason: collision with root package name */
    public int f23097c;

    /* renamed from: d, reason: collision with root package name */
    public ByteBuffer f23098d;

    /* renamed from: e, reason: collision with root package name */
    public ByteBuffer f23099e;

    /* renamed from: f, reason: collision with root package name */
    public int f23100f;

    /* renamed from: g, reason: collision with root package name */
    public final short[] f23101g;

    /* renamed from: h, reason: collision with root package name */
    public final float[] f23102h;

    /* renamed from: i, reason: collision with root package name */
    public float[] f23103i;

    /* renamed from: v5.g$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public a() {
        }
    }

    public C1698g() {
        ByteBuffer byteBuffer = f23094k;
        M5.m.d(byteBuffer, "EMPTY_BUFFER");
        this.f23098d = byteBuffer;
        this.f23101g = new short[512];
        this.f23102h = new float[512];
    }

    public final void a(C1692a c1692a) {
        M5.m.e(c1692a, "inputAudioFormat");
        this.f23096b = c1692a;
        this.f23095a = A4.a.f267n.a(512);
        int iD = d(c1692a);
        this.f23097c = iD;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iD + 4096);
        M5.m.d(byteBufferAllocate, "allocate(...)");
        this.f23099e = byteBufferAllocate;
    }

    public final long b(int i7, long j7) {
        return (j7 * i7) / TimeUnit.MICROSECONDS.convert(1L, TimeUnit.SECONDS);
    }

    public final int c(int i7) {
        if (i7 != 1) {
            return i7 != 2 ? 0 : 12;
        }
        return 4;
    }

    public final int d(C1692a c1692a) {
        int iF = f(c1692a.b());
        int minBufferSize = AudioTrack.getMinBufferSize(c1692a.c(), c(c1692a.b()), 2);
        if (minBufferSize != -2) {
            return (S5.e.j(minBufferSize * 4, ((int) b(c1692a.c(), 30000L)) * iF, (int) Math.max(minBufferSize, b(c1692a.c(), 500000L) * iF)) / iF) * iF;
        }
        throw new IllegalStateException("Check failed.");
    }

    public final float[] e() {
        return this.f23103i;
    }

    public final int f(int i7) {
        return i7 * 2;
    }

    public final boolean g() {
        return this.f23095a != null;
    }

    public final void h(ByteBuffer byteBuffer) {
        if (this.f23095a == null) {
            return;
        }
        ByteBuffer byteBuffer2 = this.f23099e;
        if (byteBuffer2 == null) {
            M5.m.o("srcBuffer");
            byteBuffer2 = null;
        }
        byteBuffer2.put(byteBuffer.array());
        this.f23100f += byteBuffer.array().length;
        while (this.f23100f > 1024) {
            ByteBuffer byteBuffer3 = this.f23099e;
            if (byteBuffer3 == null) {
                M5.m.o("srcBuffer");
                byteBuffer3 = null;
            }
            int i7 = 0;
            byteBuffer3.position(0);
            ByteBuffer byteBuffer4 = this.f23099e;
            if (byteBuffer4 == null) {
                M5.m.o("srcBuffer");
                byteBuffer4 = null;
            }
            byteBuffer4.asShortBuffer().get(this.f23101g, 0, 512);
            int length = this.f23101g.length;
            int i8 = 0;
            while (i7 < length) {
                this.f23102h[i8] = r11[i7] / 32767;
                i7++;
                i8++;
            }
            ByteBuffer byteBuffer5 = this.f23099e;
            if (byteBuffer5 == null) {
                M5.m.o("srcBuffer");
                byteBuffer5 = null;
            }
            byteBuffer5.position(1024);
            ByteBuffer byteBuffer6 = this.f23099e;
            if (byteBuffer6 == null) {
                M5.m.o("srcBuffer");
                byteBuffer6 = null;
            }
            byteBuffer6.compact();
            this.f23100f -= 1024;
            ByteBuffer byteBuffer7 = this.f23099e;
            if (byteBuffer7 == null) {
                M5.m.o("srcBuffer");
                byteBuffer7 = null;
            }
            byteBuffer7.position(this.f23100f);
            float[] fArr = new float[514];
            A4.a aVar = this.f23095a;
            float[] fArrA = aVar != null ? aVar.a(this.f23102h, fArr) : null;
            M5.m.b(fArrA);
            this.f23103i = fArrA;
        }
    }

    public final void i(ByteBuffer byteBuffer) {
        M5.m.e(byteBuffer, "inputBuffer");
        if (g()) {
            int iPosition = byteBuffer.position();
            int iLimit = byteBuffer.limit();
            int i7 = iLimit - iPosition;
            C1692a c1692a = this.f23096b;
            if (c1692a == null) {
                M5.m.o("inputAudioFormat");
                c1692a = null;
            }
            int iB = (i7 / (c1692a.b() * 2)) * 2;
            if (this.f23098d.capacity() < iB) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(iB).order(ByteOrder.nativeOrder());
                M5.m.d(byteBufferOrder, "order(...)");
                this.f23098d = byteBufferOrder;
            } else {
                this.f23098d.clear();
            }
            while (iPosition < iLimit) {
                C1692a c1692a2 = this.f23096b;
                if (c1692a2 == null) {
                    M5.m.o("inputAudioFormat");
                    c1692a2 = null;
                }
                int iB2 = c1692a2.b();
                short s7 = 0;
                for (int i8 = 0; i8 < iB2; i8++) {
                    if (i8 == 0) {
                        s7 = (short) (s7 + byteBuffer.getShort((i8 * 2) + iPosition));
                    }
                }
                this.f23098d.putShort(s7);
                C1692a c1692a3 = this.f23096b;
                if (c1692a3 == null) {
                    M5.m.o("inputAudioFormat");
                    c1692a3 = null;
                }
                iPosition += c1692a3.b() * 2;
            }
            byteBuffer.position(iPosition);
            h(this.f23098d);
        }
    }

    public final void j() {
        A4.a aVar = this.f23095a;
        if (aVar != null) {
            aVar.close();
        }
        this.f23095a = null;
    }
}
