package C0;

import C0.u;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import k3.AbstractC1279v;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC1279v f1250a;

    /* renamed from: b, reason: collision with root package name */
    public final List f1251b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public ByteBuffer[] f1252c = new ByteBuffer[0];

    /* renamed from: d, reason: collision with root package name */
    public u.a f1253d;

    /* renamed from: e, reason: collision with root package name */
    public u.a f1254e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1255f;

    public t(AbstractC1279v abstractC1279v) {
        this.f1250a = abstractC1279v;
        u.a aVar = u.a.f1257e;
        this.f1253d = aVar;
        this.f1254e = aVar;
        this.f1255f = false;
    }

    public u.a a(u.a aVar) throws u.c {
        if (aVar.equals(u.a.f1257e)) {
            throw new u.c(aVar);
        }
        for (int i7 = 0; i7 < this.f1250a.size(); i7++) {
            u uVar = (u) this.f1250a.get(i7);
            u.a aVarI = uVar.i(aVar);
            if (uVar.e()) {
                j3.o.v(!aVarI.equals(u.a.f1257e));
                aVar = aVarI;
            }
        }
        this.f1254e = aVar;
        return aVar;
    }

    public void b() {
        c(u.b.f1262b);
    }

    public void c(u.b bVar) {
        this.f1251b.clear();
        this.f1253d = this.f1254e;
        this.f1255f = false;
        long jK = bVar.f1263a;
        for (int i7 = 0; i7 < this.f1250a.size(); i7++) {
            u uVar = (u) this.f1250a.get(i7);
            uVar.h(new u.b(jK));
            if (uVar.e()) {
                jK = uVar.k(jK);
                j3.o.v(jK >= 0);
                this.f1251b.add(uVar);
            }
        }
        this.f1252c = new ByteBuffer[this.f1251b.size()];
        for (int i8 = 0; i8 <= d(); i8++) {
            this.f1252c[i8] = ((u) this.f1251b.get(i8)).f();
        }
    }

    public final int d() {
        return this.f1252c.length - 1;
    }

    public ByteBuffer e() {
        if (!g()) {
            return u.f1256a;
        }
        ByteBuffer byteBuffer = this.f1252c[d()];
        if (byteBuffer.hasRemaining()) {
            return byteBuffer;
        }
        h(u.f1256a);
        return this.f1252c[d()];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        if (this.f1250a.size() != tVar.f1250a.size()) {
            return false;
        }
        for (int i7 = 0; i7 < this.f1250a.size(); i7++) {
            if (this.f1250a.get(i7) != tVar.f1250a.get(i7)) {
                return false;
            }
        }
        return true;
    }

    public boolean f() {
        return this.f1255f && ((u) this.f1251b.get(d())).d() && !this.f1252c[d()].hasRemaining();
    }

    public boolean g() {
        return !this.f1251b.isEmpty();
    }

    public final void h(ByteBuffer byteBuffer) {
        boolean z7;
        for (boolean z8 = true; z8; z8 = z7) {
            z7 = false;
            int i7 = 0;
            while (i7 <= d()) {
                if (!this.f1252c[i7].hasRemaining()) {
                    u uVar = (u) this.f1251b.get(i7);
                    if (!uVar.d()) {
                        ByteBuffer byteBuffer2 = i7 > 0 ? this.f1252c[i7 - 1] : byteBuffer.hasRemaining() ? byteBuffer : u.f1256a;
                        long jRemaining = byteBuffer2.remaining();
                        uVar.g(byteBuffer2);
                        this.f1252c[i7] = uVar.f();
                        z7 |= jRemaining - ((long) byteBuffer2.remaining()) > 0 || this.f1252c[i7].hasRemaining();
                    } else if (!this.f1252c[i7].hasRemaining() && i7 < d()) {
                        ((u) this.f1251b.get(i7 + 1)).j();
                    }
                }
                i7++;
            }
        }
    }

    public int hashCode() {
        return this.f1250a.hashCode();
    }

    public void i() {
        if (!g() || this.f1255f) {
            return;
        }
        this.f1255f = true;
        ((u) this.f1251b.get(0)).j();
    }

    public void j(ByteBuffer byteBuffer) {
        if (!g() || this.f1255f) {
            return;
        }
        h(byteBuffer);
    }

    public void k() {
        for (int i7 = 0; i7 < this.f1250a.size(); i7++) {
            u uVar = (u) this.f1250a.get(i7);
            uVar.h(u.b.f1262b);
            uVar.reset();
        }
        this.f1251b.clear();
        this.f1252c = new ByteBuffer[0];
        u.a aVar = u.a.f1257e;
        this.f1253d = aVar;
        this.f1254e = aVar;
        this.f1255f = false;
    }
}
