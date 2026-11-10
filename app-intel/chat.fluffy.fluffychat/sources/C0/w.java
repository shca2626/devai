package C0;

import C0.u;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public abstract class w implements u {

    /* renamed from: b, reason: collision with root package name */
    public u.a f1265b;

    /* renamed from: c, reason: collision with root package name */
    public u.a f1266c;

    /* renamed from: d, reason: collision with root package name */
    public u.a f1267d;

    /* renamed from: e, reason: collision with root package name */
    public u.a f1268e;

    /* renamed from: f, reason: collision with root package name */
    public ByteBuffer f1269f;

    /* renamed from: g, reason: collision with root package name */
    public ByteBuffer f1270g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1271h;

    public w() {
        ByteBuffer byteBuffer = u.f1256a;
        this.f1269f = byteBuffer;
        this.f1270g = byteBuffer;
        u.a aVar = u.a.f1257e;
        this.f1267d = aVar;
        this.f1268e = aVar;
        this.f1265b = aVar;
        this.f1266c = aVar;
    }

    public final boolean a() {
        return this.f1270g.hasRemaining();
    }

    public u.a b(u.a aVar) {
        return u.a.f1257e;
    }

    @Override // C0.u
    public boolean d() {
        return this.f1271h && this.f1270g == u.f1256a;
    }

    @Override // C0.u
    public boolean e() {
        return this.f1268e != u.a.f1257e;
    }

    @Override // C0.u
    public ByteBuffer f() {
        ByteBuffer byteBuffer = this.f1270g;
        this.f1270g = u.f1256a;
        return byteBuffer;
    }

    @Override // C0.u
    public final void h(u.b bVar) {
        this.f1270g = u.f1256a;
        this.f1271h = false;
        this.f1265b = this.f1267d;
        this.f1266c = this.f1268e;
        l(bVar);
    }

    @Override // C0.u
    public final u.a i(u.a aVar) {
        this.f1267d = aVar;
        this.f1268e = b(aVar);
        return e() ? this.f1268e : u.a.f1257e;
    }

    @Override // C0.u
    public final void j() {
        this.f1271h = true;
        m();
    }

    public void l(u.b bVar) {
        c();
    }

    public final ByteBuffer o(int i7) {
        if (this.f1269f.capacity() < i7) {
            this.f1269f = ByteBuffer.allocateDirect(i7).order(ByteOrder.nativeOrder());
        } else {
            this.f1269f.clear();
        }
        ByteBuffer byteBuffer = this.f1269f;
        this.f1270g = byteBuffer;
        return byteBuffer;
    }

    @Override // C0.u
    public final void reset() {
        ByteBuffer byteBuffer = u.f1256a;
        this.f1270g = byteBuffer;
        this.f1271h = false;
        this.f1269f = byteBuffer;
        u.a aVar = u.a.f1257e;
        this.f1267d = aVar;
        this.f1268e = aVar;
        this.f1265b = aVar;
        this.f1266c = aVar;
        n();
    }

    public void c() {
    }

    public void m() {
    }

    public void n() {
    }
}
