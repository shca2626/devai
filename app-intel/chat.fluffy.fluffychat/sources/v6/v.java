package v6;

import z5.C1877k;

/* loaded from: classes3.dex */
public final class v {

    /* renamed from: h, reason: collision with root package name */
    public static final a f23222h = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f23223a;

    /* renamed from: b, reason: collision with root package name */
    public int f23224b;

    /* renamed from: c, reason: collision with root package name */
    public int f23225c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f23226d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f23227e;

    /* renamed from: f, reason: collision with root package name */
    public v f23228f;

    /* renamed from: g, reason: collision with root package name */
    public v f23229g;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public a() {
        }
    }

    public v() {
        this.f23223a = new byte[8192];
        this.f23227e = true;
        this.f23226d = false;
    }

    public final void a() {
        int i7;
        v vVar = this.f23229g;
        if (vVar == this) {
            throw new IllegalStateException("cannot compact");
        }
        M5.m.b(vVar);
        if (vVar.f23227e) {
            int i8 = this.f23225c - this.f23224b;
            v vVar2 = this.f23229g;
            M5.m.b(vVar2);
            int i9 = 8192 - vVar2.f23225c;
            v vVar3 = this.f23229g;
            M5.m.b(vVar3);
            if (vVar3.f23226d) {
                i7 = 0;
            } else {
                v vVar4 = this.f23229g;
                M5.m.b(vVar4);
                i7 = vVar4.f23224b;
            }
            if (i8 > i9 + i7) {
                return;
            }
            v vVar5 = this.f23229g;
            M5.m.b(vVar5);
            f(vVar5, i8);
            b();
            w.b(this);
        }
    }

    public final v b() {
        v vVar = this.f23228f;
        if (vVar == this) {
            vVar = null;
        }
        v vVar2 = this.f23229g;
        M5.m.b(vVar2);
        vVar2.f23228f = this.f23228f;
        v vVar3 = this.f23228f;
        M5.m.b(vVar3);
        vVar3.f23229g = this.f23229g;
        this.f23228f = null;
        this.f23229g = null;
        return vVar;
    }

    public final v c(v vVar) {
        M5.m.e(vVar, "segment");
        vVar.f23229g = this;
        vVar.f23228f = this.f23228f;
        v vVar2 = this.f23228f;
        M5.m.b(vVar2);
        vVar2.f23229g = vVar;
        this.f23228f = vVar;
        return vVar;
    }

    public final v d() {
        this.f23226d = true;
        return new v(this.f23223a, this.f23224b, this.f23225c, true, false);
    }

    public final v e(int i7) {
        v vVarC;
        if (i7 <= 0 || i7 > this.f23225c - this.f23224b) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (i7 >= 1024) {
            vVarC = d();
        } else {
            vVarC = w.c();
            byte[] bArr = this.f23223a;
            byte[] bArr2 = vVarC.f23223a;
            int i8 = this.f23224b;
            C1877k.i(bArr, bArr2, 0, i8, i8 + i7, 2, null);
        }
        vVarC.f23225c = vVarC.f23224b + i7;
        this.f23224b += i7;
        v vVar = this.f23229g;
        M5.m.b(vVar);
        vVar.c(vVarC);
        return vVarC;
    }

    public final void f(v vVar, int i7) {
        M5.m.e(vVar, "sink");
        if (!vVar.f23227e) {
            throw new IllegalStateException("only owner can write");
        }
        int i8 = vVar.f23225c;
        if (i8 + i7 > 8192) {
            if (vVar.f23226d) {
                throw new IllegalArgumentException();
            }
            int i9 = vVar.f23224b;
            if ((i8 + i7) - i9 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = vVar.f23223a;
            C1877k.i(bArr, bArr, 0, i9, i8, 2, null);
            vVar.f23225c -= vVar.f23224b;
            vVar.f23224b = 0;
        }
        byte[] bArr2 = this.f23223a;
        byte[] bArr3 = vVar.f23223a;
        int i10 = vVar.f23225c;
        int i11 = this.f23224b;
        C1877k.e(bArr2, bArr3, i10, i11, i11 + i7);
        vVar.f23225c += i7;
        this.f23224b += i7;
    }

    public v(byte[] bArr, int i7, int i8, boolean z7, boolean z8) {
        M5.m.e(bArr, "data");
        this.f23223a = bArr;
        this.f23224b = i7;
        this.f23225c = i8;
        this.f23226d = z7;
        this.f23227e = z8;
    }
}
