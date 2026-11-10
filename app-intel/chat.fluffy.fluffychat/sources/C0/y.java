package C0;

import C0.u;
import E0.U;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class y implements u {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1305b;

    /* renamed from: c, reason: collision with root package name */
    public int f1306c;

    /* renamed from: d, reason: collision with root package name */
    public float f1307d;

    /* renamed from: e, reason: collision with root package name */
    public float f1308e;

    /* renamed from: f, reason: collision with root package name */
    public u.a f1309f;

    /* renamed from: g, reason: collision with root package name */
    public u.a f1310g;

    /* renamed from: h, reason: collision with root package name */
    public u.a f1311h;

    /* renamed from: i, reason: collision with root package name */
    public u.a f1312i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1313j;

    /* renamed from: k, reason: collision with root package name */
    public x f1314k;

    /* renamed from: l, reason: collision with root package name */
    public ByteBuffer f1315l;

    /* renamed from: m, reason: collision with root package name */
    public ByteBuffer f1316m;

    /* renamed from: n, reason: collision with root package name */
    public long f1317n;

    /* renamed from: o, reason: collision with root package name */
    public long f1318o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1319p;

    public y() {
        this(false);
    }

    public final boolean a() {
        return Math.abs(this.f1307d - 1.0f) < 1.0E-4f && Math.abs(this.f1308e - 1.0f) < 1.0E-4f && this.f1310g.f1258a == this.f1309f.f1258a;
    }

    public long b(long j7) {
        if (this.f1318o < 1024) {
            return (long) (this.f1307d * j7);
        }
        long jQ = this.f1317n - ((x) j3.o.q(this.f1314k)).q();
        int i7 = this.f1312i.f1258a;
        int i8 = this.f1311h.f1258a;
        return i7 == i8 ? U.d1(j7, jQ, this.f1318o) : U.d1(j7, jQ * i7, this.f1318o * i8);
    }

    public long c(long j7) {
        if (this.f1318o < 1024) {
            return (long) (j7 / this.f1307d);
        }
        long jQ = this.f1317n - ((x) j3.o.q(this.f1314k)).q();
        int i7 = this.f1312i.f1258a;
        int i8 = this.f1311h.f1258a;
        return i7 == i8 ? U.d1(j7, this.f1318o, jQ) : U.d1(j7, this.f1318o * i8, jQ * i7);
    }

    @Override // C0.u
    public boolean d() {
        if (!this.f1319p) {
            return false;
        }
        x xVar = this.f1314k;
        return xVar == null || xVar.p() == 0;
    }

    @Override // C0.u
    public boolean e() {
        if (this.f1310g.f1258a != -1) {
            return this.f1305b || !a();
        }
        return false;
    }

    @Override // C0.u
    public ByteBuffer f() {
        int iP;
        x xVar = this.f1314k;
        if (xVar != null && (iP = xVar.p()) > 0) {
            if (this.f1315l.capacity() < iP) {
                this.f1315l = ByteBuffer.allocateDirect(iP).order(ByteOrder.nativeOrder());
            } else {
                this.f1315l.clear();
            }
            xVar.o(this.f1315l);
            this.f1315l.flip();
            this.f1318o += iP;
            this.f1316m = this.f1315l;
        }
        ByteBuffer byteBuffer = this.f1316m;
        this.f1316m = u.f1256a;
        return byteBuffer;
    }

    @Override // C0.u
    public void g(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            x xVar = (x) j3.o.q(this.f1314k);
            this.f1317n += byteBuffer.remaining();
            xVar.v(byteBuffer);
        }
    }

    @Override // C0.u
    public void h(u.b bVar) {
        if (e()) {
            u.a aVar = this.f1309f;
            this.f1311h = aVar;
            u.a aVar2 = this.f1310g;
            this.f1312i = aVar2;
            if (this.f1313j) {
                this.f1314k = new x(aVar.f1258a, aVar.f1259b, this.f1307d, this.f1308e, aVar2.f1258a, aVar.f1260c == 4);
            } else {
                x xVar = this.f1314k;
                if (xVar != null) {
                    xVar.n();
                }
            }
        }
        this.f1316m = u.f1256a;
        this.f1317n = 0L;
        this.f1318o = 0L;
        this.f1319p = false;
    }

    @Override // C0.u
    public u.a i(u.a aVar) throws u.c {
        int i7 = aVar.f1260c;
        if (i7 != 2 && i7 != 4) {
            throw new u.c(aVar);
        }
        int i8 = this.f1306c;
        if (i8 == -1) {
            i8 = aVar.f1258a;
        }
        this.f1309f = aVar;
        u.a aVar2 = new u.a(i8, aVar.f1259b, aVar.f1260c);
        this.f1310g = aVar2;
        this.f1313j = true;
        return aVar2;
    }

    @Override // C0.u
    public void j() {
        x xVar = this.f1314k;
        if (xVar != null) {
            xVar.u();
        }
        this.f1319p = true;
    }

    @Override // C0.u
    public long k(long j7) {
        return c(j7);
    }

    public void l(float f7) {
        j3.o.d(f7 > 0.0f);
        if (this.f1308e != f7) {
            this.f1308e = f7;
            this.f1313j = true;
        }
    }

    public void m(float f7) {
        j3.o.d(f7 > 0.0f);
        if (this.f1307d != f7) {
            this.f1307d = f7;
            this.f1313j = true;
        }
    }

    @Override // C0.u
    public void reset() {
        this.f1307d = 1.0f;
        this.f1308e = 1.0f;
        u.a aVar = u.a.f1257e;
        this.f1309f = aVar;
        this.f1310g = aVar;
        this.f1311h = aVar;
        this.f1312i = aVar;
        ByteBuffer byteBuffer = u.f1256a;
        this.f1315l = byteBuffer;
        this.f1316m = byteBuffer;
        this.f1306c = -1;
        this.f1313j = false;
        this.f1314k = null;
        this.f1317n = 0L;
        this.f1318o = 0L;
        this.f1319p = false;
    }

    public y(boolean z7) {
        this.f1307d = 1.0f;
        this.f1308e = 1.0f;
        u.a aVar = u.a.f1257e;
        this.f1309f = aVar;
        this.f1310g = aVar;
        this.f1311h = aVar;
        this.f1312i = aVar;
        ByteBuffer byteBuffer = u.f1256a;
        this.f1315l = byteBuffer;
        this.f1316m = byteBuffer;
        this.f1306c = -1;
        this.f1305b = z7;
    }
}
