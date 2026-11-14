package v6;

import z5.C1880k;

/* loaded from: classes3.dex */
public final class v {

    /* renamed from: h, reason: collision with root package name */
    public static final a f23228h = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f23229a;

    /* renamed from: b, reason: collision with root package name */
    public int f23230b;

    /* renamed from: c, reason: collision with root package name */
    public int f23231c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f23232d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f23233e;

    /* renamed from: f, reason: collision with root package name */
    public v f23234f;

    /* renamed from: g, reason: collision with root package name */
    public v f23235g;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public a() {
        }
    }

    public v() {
        this.f23229a = new byte[8192];
        this.f23233e = true;
        this.f23232d = false;
    }

    public final void a() {
        int i7;
        v vVar = this.f23235g;
        if (vVar == this) {
            throw new IllegalStateException("cannot compact");
        }
        M5.m.b(vVar);
        if (vVar.f23233e) {
            int i8 = this.f23231c - this.f23230b;
            v vVar2 = this.f23235g;
            M5.m.b(vVar2);
            int i9 = 8192 - vVar2.f23231c;
            v vVar3 = this.f23235g;
            M5.m.b(vVar3);
            if (vVar3.f23232d) {
                i7 = 0;
            } else {
                v vVar4 = this.f23235g;
                M5.m.b(vVar4);
                i7 = vVar4.f23230b;
            }
            if (i8 > i9 + i7) {
                return;
            }
            v vVar5 = this.f23235g;
            M5.m.b(vVar5);
            f(vVar5, i8);
            b();
            w.b(this);
        }
    }

    public final v b() {
        v vVar = this.f23234f;
        if (vVar == this) {
            vVar = null;
        }
        v vVar2 = this.f23235g;
        M5.m.b(vVar2);
        vVar2.f23234f = this.f23234f;
        v vVar3 = this.f23234f;
        M5.m.b(vVar3);
        vVar3.f23235g = this.f23235g;
        this.f23234f = null;
        this.f23235g = null;
        return vVar;
    }

    public final v c(v vVar) {
        M5.m.e(vVar, "segment");
        vVar.f23235g = this;
        vVar.f23234f = this.f23234f;
        v vVar2 = this.f23234f;
        M5.m.b(vVar2);
        vVar2.f23235g = vVar;
        this.f23234f = vVar;
        return vVar;
    }

    public final v d() {
        this.f23232d = true;
        return new v(this.f23229a, this.f23230b, this.f23231c, true, false);
    }

    public final v e(int i7) {
        v vVarC;
        if (i7 <= 0 || i7 > this.f23231c - this.f23230b) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (i7 >= 1024) {
            vVarC = d();
        } else {
            vVarC = w.c();
            byte[] bArr = this.f23229a;
            byte[] bArr2 = vVarC.f23229a;
            int i8 = this.f23230b;
            C1880k.i(bArr, bArr2, 0, i8, i8 + i7, 2, null);
        }
        vVarC.f23231c = vVarC.f23230b + i7;
        this.f23230b += i7;
        v vVar = this.f23235g;
        M5.m.b(vVar);
        vVar.c(vVarC);
        return vVarC;
    }

    public final void f(v vVar, int i7) {
        M5.m.e(vVar, "sink");
        if (!vVar.f23233e) {
            throw new IllegalStateException("only owner can write");
        }
        int i8 = vVar.f23231c;
        if (i8 + i7 > 8192) {
            if (vVar.f23232d) {
                throw new IllegalArgumentException();
            }
            int i9 = vVar.f23230b;
            if ((i8 + i7) - i9 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = vVar.f23229a;
            C1880k.i(bArr, bArr, 0, i9, i8, 2, null);
            vVar.f23231c -= vVar.f23230b;
            vVar.f23230b = 0;
        }
        byte[] bArr2 = this.f23229a;
        byte[] bArr3 = vVar.f23229a;
        int i10 = vVar.f23231c;
        int i11 = this.f23230b;
        C1880k.e(bArr2, bArr3, i10, i11, i11 + i7);
        vVar.f23231c += i7;
        this.f23230b += i7;
    }

    public v(byte[] bArr, int i7, int i8, boolean z7, boolean z8) {
        M5.m.e(bArr, "data");
        this.f23229a = bArr;
        this.f23230b = i7;
        this.f23231c = i8;
        this.f23232d = z7;
        this.f23233e = z8;
    }
}
