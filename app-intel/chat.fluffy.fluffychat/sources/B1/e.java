package B1;

import E0.E;
import g1.AbstractC1089t;
import g1.r;
import j3.o;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final f f1084a = new f();

    /* renamed from: b, reason: collision with root package name */
    public final E f1085b = new E(new byte[65025], 0);

    /* renamed from: c, reason: collision with root package name */
    public int f1086c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f1087d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1088e;

    public final int a(int i7) {
        int i8;
        int i9 = 0;
        this.f1087d = 0;
        do {
            int i10 = this.f1087d;
            int i11 = i7 + i10;
            f fVar = this.f1084a;
            if (i11 >= fVar.f1095g) {
                break;
            }
            int[] iArr = fVar.f1098j;
            this.f1087d = i10 + 1;
            i8 = iArr[i10 + i7];
            i9 += i8;
        } while (i8 == 255);
        return i9;
    }

    public f b() {
        return this.f1084a;
    }

    public E c() {
        return this.f1085b;
    }

    public boolean d(r rVar) {
        int i7;
        o.v(rVar != null);
        if (this.f1088e) {
            this.f1088e = false;
            this.f1085b.b0(0);
        }
        while (!this.f1088e) {
            if (this.f1086c < 0) {
                if (!this.f1084a.c(rVar) || !this.f1084a.a(rVar, true)) {
                    return false;
                }
                f fVar = this.f1084a;
                int iA = fVar.f1096h;
                if ((fVar.f1090b & 1) == 1 && this.f1085b.j() == 0) {
                    iA += a(0);
                    i7 = this.f1087d;
                } else {
                    i7 = 0;
                }
                if (!AbstractC1089t.f(rVar, iA)) {
                    return false;
                }
                this.f1086c = i7;
            }
            int iA2 = a(this.f1086c);
            int i8 = this.f1086c + this.f1087d;
            if (iA2 > 0) {
                E e7 = this.f1085b;
                e7.d(e7.j() + iA2);
                if (!AbstractC1089t.e(rVar, this.f1085b.f(), this.f1085b.j(), iA2)) {
                    return false;
                }
                E e8 = this.f1085b;
                e8.e0(e8.j() + iA2);
                this.f1088e = this.f1084a.f1098j[i8 + (-1)] != 255;
            }
            if (i8 == this.f1084a.f1095g) {
                i8 = -1;
            }
            this.f1086c = i8;
        }
        return true;
    }

    public void e() {
        this.f1084a.b();
        this.f1085b.b0(0);
        this.f1086c = -1;
        this.f1088e = false;
    }

    public void f() {
        if (this.f1085b.f().length == 65025) {
            return;
        }
        E e7 = this.f1085b;
        e7.d0(Arrays.copyOf(e7.f(), Math.max(65025, this.f1085b.j())), this.f1085b.j());
    }
}
