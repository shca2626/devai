package f3;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import e3.C1033a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public float f15815a;

    /* renamed from: b, reason: collision with root package name */
    public float f15816b;

    /* renamed from: c, reason: collision with root package name */
    public float f15817c;

    /* renamed from: d, reason: collision with root package name */
    public float f15818d;

    /* renamed from: e, reason: collision with root package name */
    public float f15819e;

    /* renamed from: f, reason: collision with root package name */
    public float f15820f;

    /* renamed from: g, reason: collision with root package name */
    public final List f15821g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final List f15822h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public boolean f15823i;

    public class a extends g {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f15824c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Matrix f15825d;

        public a(List list, Matrix matrix) {
            this.f15824c = list;
            this.f15825d = matrix;
        }

        @Override // f3.m.g
        public void a(Matrix matrix, C1033a c1033a, int i7, Canvas canvas) {
            Iterator it = this.f15824c.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(this.f15825d, c1033a, i7, canvas);
            }
        }
    }

    public static class b extends g {

        /* renamed from: c, reason: collision with root package name */
        public final d f15827c;

        public b(d dVar) {
            this.f15827c = dVar;
        }

        @Override // f3.m.g
        public void a(Matrix matrix, C1033a c1033a, int i7, Canvas canvas) {
            c1033a.a(canvas, matrix, new RectF(this.f15827c.k(), this.f15827c.o(), this.f15827c.l(), this.f15827c.j()), i7, this.f15827c.m(), this.f15827c.n());
        }
    }

    public static class c extends g {

        /* renamed from: c, reason: collision with root package name */
        public final e f15828c;

        /* renamed from: d, reason: collision with root package name */
        public final float f15829d;

        /* renamed from: e, reason: collision with root package name */
        public final float f15830e;

        public c(e eVar, float f7, float f8) {
            this.f15828c = eVar;
            this.f15829d = f7;
            this.f15830e = f8;
        }

        @Override // f3.m.g
        public void a(Matrix matrix, C1033a c1033a, int i7, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f15828c.f15839c - this.f15830e, this.f15828c.f15838b - this.f15829d), 0.0f);
            this.f15842a.set(matrix);
            this.f15842a.preTranslate(this.f15829d, this.f15830e);
            this.f15842a.preRotate(c());
            c1033a.b(canvas, this.f15842a, rectF, i7);
        }

        public float c() {
            return (float) Math.toDegrees(Math.atan((this.f15828c.f15839c - this.f15830e) / (this.f15828c.f15838b - this.f15829d)));
        }
    }

    public static class d extends f {

        /* renamed from: h, reason: collision with root package name */
        public static final RectF f15831h = new RectF();

        /* renamed from: b, reason: collision with root package name */
        public float f15832b;

        /* renamed from: c, reason: collision with root package name */
        public float f15833c;

        /* renamed from: d, reason: collision with root package name */
        public float f15834d;

        /* renamed from: e, reason: collision with root package name */
        public float f15835e;

        /* renamed from: f, reason: collision with root package name */
        public float f15836f;

        /* renamed from: g, reason: collision with root package name */
        public float f15837g;

        public d(float f7, float f8, float f9, float f10) {
            q(f7);
            u(f8);
            r(f9);
            p(f10);
        }

        @Override // f3.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f15840a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f15831h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }

        public final float j() {
            return this.f15835e;
        }

        public final float k() {
            return this.f15832b;
        }

        public final float l() {
            return this.f15834d;
        }

        public final float m() {
            return this.f15836f;
        }

        public final float n() {
            return this.f15837g;
        }

        public final float o() {
            return this.f15833c;
        }

        public final void p(float f7) {
            this.f15835e = f7;
        }

        public final void q(float f7) {
            this.f15832b = f7;
        }

        public final void r(float f7) {
            this.f15834d = f7;
        }

        public final void s(float f7) {
            this.f15836f = f7;
        }

        public final void t(float f7) {
            this.f15837g = f7;
        }

        public final void u(float f7) {
            this.f15833c = f7;
        }
    }

    public static class e extends f {

        /* renamed from: b, reason: collision with root package name */
        public float f15838b;

        /* renamed from: c, reason: collision with root package name */
        public float f15839c;

        @Override // f3.m.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f15840a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f15838b, this.f15839c);
            path.transform(matrix);
        }
    }

    public static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        public final Matrix f15840a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    public static abstract class g {

        /* renamed from: b, reason: collision with root package name */
        public static final Matrix f15841b = new Matrix();

        /* renamed from: a, reason: collision with root package name */
        public final Matrix f15842a = new Matrix();

        public abstract void a(Matrix matrix, C1033a c1033a, int i7, Canvas canvas);

        public final void b(C1033a c1033a, int i7, Canvas canvas) {
            a(f15841b, c1033a, i7, canvas);
        }
    }

    public m() {
        n(0.0f, 0.0f);
    }

    public void a(float f7, float f8, float f9, float f10, float f11, float f12) {
        d dVar = new d(f7, f8, f9, f10);
        dVar.s(f11);
        dVar.t(f12);
        this.f15821g.add(dVar);
        b bVar = new b(dVar);
        float f13 = f11 + f12;
        boolean z7 = f12 < 0.0f;
        if (z7) {
            f11 = (f11 + 180.0f) % 360.0f;
        }
        c(bVar, f11, z7 ? (180.0f + f13) % 360.0f : f13);
        double d7 = f13;
        r(((f7 + f9) * 0.5f) + (((f9 - f7) / 2.0f) * ((float) Math.cos(Math.toRadians(d7)))));
        s(((f8 + f10) * 0.5f) + (((f10 - f8) / 2.0f) * ((float) Math.sin(Math.toRadians(d7)))));
    }

    public final void b(float f7) {
        if (g() == f7) {
            return;
        }
        float fG = ((f7 - g()) + 360.0f) % 360.0f;
        if (fG > 180.0f) {
            return;
        }
        d dVar = new d(i(), j(), i(), j());
        dVar.s(g());
        dVar.t(fG);
        this.f15822h.add(new b(dVar));
        p(f7);
    }

    public final void c(g gVar, float f7, float f8) {
        b(f7);
        this.f15822h.add(gVar);
        p(f8);
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f15821g.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((f) this.f15821g.get(i7)).a(matrix, path);
        }
    }

    public boolean e() {
        return this.f15823i;
    }

    public g f(Matrix matrix) {
        b(h());
        return new a(new ArrayList(this.f15822h), new Matrix(matrix));
    }

    public final float g() {
        return this.f15819e;
    }

    public final float h() {
        return this.f15820f;
    }

    public float i() {
        return this.f15817c;
    }

    public float j() {
        return this.f15818d;
    }

    public float k() {
        return this.f15815a;
    }

    public float l() {
        return this.f15816b;
    }

    public void m(float f7, float f8) {
        e eVar = new e();
        eVar.f15838b = f7;
        eVar.f15839c = f8;
        this.f15821g.add(eVar);
        c cVar = new c(eVar, i(), j());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        r(f7);
        s(f8);
    }

    public void n(float f7, float f8) {
        o(f7, f8, 270.0f, 0.0f);
    }

    public void o(float f7, float f8, float f9, float f10) {
        t(f7);
        u(f8);
        r(f7);
        s(f8);
        p(f9);
        q((f9 + f10) % 360.0f);
        this.f15821g.clear();
        this.f15822h.clear();
        this.f15823i = false;
    }

    public final void p(float f7) {
        this.f15819e = f7;
    }

    public final void q(float f7) {
        this.f15820f = f7;
    }

    public final void r(float f7) {
        this.f15817c = f7;
    }

    public final void s(float f7) {
        this.f15818d = f7;
    }

    public final void t(float f7) {
        this.f15815a = f7;
    }

    public final void u(float f7) {
        this.f15816b = f7;
    }
}
