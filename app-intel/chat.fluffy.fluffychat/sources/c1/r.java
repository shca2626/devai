package c1;

import c1.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes.dex */
public class r {

    /* renamed from: h, reason: collision with root package name */
    public static final Comparator f13948h = new Comparator() { // from class: c1.p
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return r.b((r.b) obj, (r.b) obj2);
        }
    };

    /* renamed from: i, reason: collision with root package name */
    public static final Comparator f13949i = new Comparator() { // from class: c1.q
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Float.compare(((r.b) obj).f13959c, ((r.b) obj2).f13959c);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final int f13950a;

    /* renamed from: e, reason: collision with root package name */
    public int f13954e;

    /* renamed from: f, reason: collision with root package name */
    public int f13955f;

    /* renamed from: g, reason: collision with root package name */
    public int f13956g;

    /* renamed from: c, reason: collision with root package name */
    public final b[] f13952c = new b[5];

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f13951b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public int f13953d = -1;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f13957a;

        /* renamed from: b, reason: collision with root package name */
        public int f13958b;

        /* renamed from: c, reason: collision with root package name */
        public float f13959c;

        public b() {
        }
    }

    public r(int i7) {
        this.f13950a = i7;
    }

    public static /* synthetic */ int b(b bVar, b bVar2) {
        return bVar.f13957a - bVar2.f13957a;
    }

    public void c(int i7, float f7) {
        b bVar;
        d();
        int i8 = this.f13956g;
        if (i8 > 0) {
            b[] bVarArr = this.f13952c;
            int i9 = i8 - 1;
            this.f13956g = i9;
            bVar = bVarArr[i9];
        } else {
            bVar = new b();
        }
        int i10 = this.f13954e;
        this.f13954e = i10 + 1;
        bVar.f13957a = i10;
        bVar.f13958b = i7;
        bVar.f13959c = f7;
        this.f13951b.add(bVar);
        this.f13955f += i7;
        while (true) {
            int i11 = this.f13955f;
            int i12 = this.f13950a;
            if (i11 <= i12) {
                return;
            }
            int i13 = i11 - i12;
            b bVar2 = (b) this.f13951b.get(0);
            int i14 = bVar2.f13958b;
            if (i14 <= i13) {
                this.f13955f -= i14;
                this.f13951b.remove(0);
                int i15 = this.f13956g;
                if (i15 < 5) {
                    b[] bVarArr2 = this.f13952c;
                    this.f13956g = i15 + 1;
                    bVarArr2[i15] = bVar2;
                }
            } else {
                bVar2.f13958b = i14 - i13;
                this.f13955f -= i13;
            }
        }
    }

    public final void d() {
        if (this.f13953d != 1) {
            Collections.sort(this.f13951b, f13948h);
            this.f13953d = 1;
        }
    }

    public final void e() {
        if (this.f13953d != 0) {
            Collections.sort(this.f13951b, f13949i);
            this.f13953d = 0;
        }
    }

    public float f(float f7) {
        e();
        float f8 = f7 * this.f13955f;
        int i7 = 0;
        for (int i8 = 0; i8 < this.f13951b.size(); i8++) {
            b bVar = (b) this.f13951b.get(i8);
            i7 += bVar.f13958b;
            if (i7 >= f8) {
                return bVar.f13959c;
            }
        }
        if (this.f13951b.isEmpty()) {
            return Float.NaN;
        }
        return ((b) this.f13951b.get(r5.size() - 1)).f13959c;
    }

    public void g() {
        this.f13951b.clear();
        this.f13953d = -1;
        this.f13954e = 0;
        this.f13955f = 0;
    }
}
