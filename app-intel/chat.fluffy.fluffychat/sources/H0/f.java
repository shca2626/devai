package H0;

import B0.s;
import B0.w;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class f extends H0.a {

    /* renamed from: m, reason: collision with root package name */
    public s f3328m;

    /* renamed from: n, reason: collision with root package name */
    public final c f3329n;

    /* renamed from: o, reason: collision with root package name */
    public ByteBuffer f3330o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f3331p;

    /* renamed from: q, reason: collision with root package name */
    public long f3332q;

    /* renamed from: r, reason: collision with root package name */
    public ByteBuffer f3333r;

    /* renamed from: s, reason: collision with root package name */
    public final int f3334s;

    /* renamed from: t, reason: collision with root package name */
    public final int f3335t;

    public static final class a extends IllegalStateException {

        /* renamed from: l, reason: collision with root package name */
        public final int f3336l;

        /* renamed from: m, reason: collision with root package name */
        public final int f3337m;

        public a(int i7, int i8) {
            super("Buffer too small (" + i7 + " < " + i8 + ")");
            this.f3336l = i7;
            this.f3337m = i8;
        }
    }

    static {
        w.a("media3.decoder");
    }

    public f(int i7) {
        this(i7, 0);
    }

    public static f v() {
        return new f(0);
    }

    @Override // H0.a
    public void i() {
        super.i();
        ByteBuffer byteBuffer = this.f3330o;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f3333r;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f3331p = false;
    }

    public final ByteBuffer r(int i7) {
        int i8 = this.f3334s;
        if (i8 == 1) {
            return ByteBuffer.allocate(i7);
        }
        if (i8 == 2) {
            return ByteBuffer.allocateDirect(i7);
        }
        ByteBuffer byteBuffer = this.f3330o;
        throw new a(byteBuffer == null ? 0 : byteBuffer.capacity(), i7);
    }

    public void s(int i7) {
        int i8 = i7 + this.f3335t;
        ByteBuffer byteBuffer = this.f3330o;
        if (byteBuffer == null) {
            this.f3330o = r(i8);
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = byteBuffer.position();
        int i9 = i8 + iPosition;
        if (iCapacity >= i9) {
            this.f3330o = byteBuffer;
            return;
        }
        ByteBuffer byteBufferR = r(i9);
        byteBufferR.order(byteBuffer.order());
        if (iPosition > 0) {
            byteBuffer.flip();
            byteBufferR.put(byteBuffer);
        }
        this.f3330o = byteBufferR;
    }

    public final void t() {
        ByteBuffer byteBuffer = this.f3330o;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f3333r;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean u() {
        return j(1073741824);
    }

    public void w(int i7) {
        ByteBuffer byteBuffer = this.f3333r;
        if (byteBuffer == null || byteBuffer.capacity() < i7) {
            this.f3333r = ByteBuffer.allocate(i7);
        } else {
            this.f3333r.clear();
        }
    }

    public f(int i7, int i8) {
        this.f3329n = new c();
        this.f3334s = i7;
        this.f3335t = i8;
    }
}
