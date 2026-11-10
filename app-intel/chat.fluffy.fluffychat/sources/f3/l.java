package f3;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public final m[] f15797a = new m[4];

    /* renamed from: b, reason: collision with root package name */
    public final Matrix[] f15798b = new Matrix[4];

    /* renamed from: c, reason: collision with root package name */
    public final Matrix[] f15799c = new Matrix[4];

    /* renamed from: d, reason: collision with root package name */
    public final PointF f15800d = new PointF();

    /* renamed from: e, reason: collision with root package name */
    public final Path f15801e = new Path();

    /* renamed from: f, reason: collision with root package name */
    public final Path f15802f = new Path();

    /* renamed from: g, reason: collision with root package name */
    public final m f15803g = new m();

    /* renamed from: h, reason: collision with root package name */
    public final float[] f15804h = new float[2];

    /* renamed from: i, reason: collision with root package name */
    public final float[] f15805i = new float[2];

    /* renamed from: j, reason: collision with root package name */
    public final Path f15806j = new Path();

    /* renamed from: k, reason: collision with root package name */
    public final Path f15807k = new Path();

    /* renamed from: l, reason: collision with root package name */
    public boolean f15808l = true;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final l f15809a = new l();
    }

    public interface b {
        void a(m mVar, Matrix matrix, int i7);

        void b(m mVar, Matrix matrix, int i7);
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final k f15810a;

        /* renamed from: b, reason: collision with root package name */
        public final Path f15811b;

        /* renamed from: c, reason: collision with root package name */
        public final RectF f15812c;

        /* renamed from: d, reason: collision with root package name */
        public final b f15813d;

        /* renamed from: e, reason: collision with root package name */
        public final float f15814e;

        public c(k kVar, float f7, RectF rectF, b bVar, Path path) {
            this.f15813d = bVar;
            this.f15810a = kVar;
            this.f15814e = f7;
            this.f15812c = rectF;
            this.f15811b = path;
        }
    }

    public l() {
        for (int i7 = 0; i7 < 4; i7++) {
            this.f15797a[i7] = new m();
            this.f15798b[i7] = new Matrix();
            this.f15799c[i7] = new Matrix();
        }
    }

    public static l k() {
        return a.f15809a;
    }

    public final float a(int i7) {
        return (i7 + 1) * 90;
    }

    public final void b(c cVar, int i7) {
        this.f15804h[0] = this.f15797a[i7].k();
        this.f15804h[1] = this.f15797a[i7].l();
        this.f15798b[i7].mapPoints(this.f15804h);
        if (i7 == 0) {
            Path path = cVar.f15811b;
            float[] fArr = this.f15804h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = cVar.f15811b;
            float[] fArr2 = this.f15804h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f15797a[i7].d(this.f15798b[i7], cVar.f15811b);
        b bVar = cVar.f15813d;
        if (bVar != null) {
            bVar.a(this.f15797a[i7], this.f15798b[i7], i7);
        }
    }

    public final void c(c cVar, int i7) {
        int i8 = (i7 + 1) % 4;
        this.f15804h[0] = this.f15797a[i7].i();
        this.f15804h[1] = this.f15797a[i7].j();
        this.f15798b[i7].mapPoints(this.f15804h);
        this.f15805i[0] = this.f15797a[i8].k();
        this.f15805i[1] = this.f15797a[i8].l();
        this.f15798b[i8].mapPoints(this.f15805i);
        float f7 = this.f15804h[0];
        float[] fArr = this.f15805i;
        float fMax = Math.max(((float) Math.hypot(f7 - fArr[0], r1[1] - fArr[1])) - 0.001f, 0.0f);
        float fI = i(cVar.f15812c, i7);
        this.f15803g.n(0.0f, 0.0f);
        f fVarJ = j(i7, cVar.f15810a);
        fVarJ.b(fMax, fI, cVar.f15814e, this.f15803g);
        this.f15806j.reset();
        this.f15803g.d(this.f15799c[i7], this.f15806j);
        if (this.f15808l && (fVarJ.a() || l(this.f15806j, i7) || l(this.f15806j, i8))) {
            Path path = this.f15806j;
            path.op(path, this.f15802f, Path.Op.DIFFERENCE);
            this.f15804h[0] = this.f15803g.k();
            this.f15804h[1] = this.f15803g.l();
            this.f15799c[i7].mapPoints(this.f15804h);
            Path path2 = this.f15801e;
            float[] fArr2 = this.f15804h;
            path2.moveTo(fArr2[0], fArr2[1]);
            this.f15803g.d(this.f15799c[i7], this.f15801e);
        } else {
            this.f15803g.d(this.f15799c[i7], cVar.f15811b);
        }
        b bVar = cVar.f15813d;
        if (bVar != null) {
            bVar.b(this.f15803g, this.f15799c[i7], i7);
        }
    }

    public void d(k kVar, float f7, RectF rectF, Path path) {
        e(kVar, f7, rectF, null, path);
    }

    public void e(k kVar, float f7, RectF rectF, b bVar, Path path) {
        path.rewind();
        this.f15801e.rewind();
        this.f15802f.rewind();
        this.f15802f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(kVar, f7, rectF, bVar, path);
        for (int i7 = 0; i7 < 4; i7++) {
            m(cVar, i7);
            n(i7);
        }
        for (int i8 = 0; i8 < 4; i8++) {
            b(cVar, i8);
            c(cVar, i8);
        }
        path.close();
        this.f15801e.close();
        if (this.f15801e.isEmpty()) {
            return;
        }
        path.op(this.f15801e, Path.Op.UNION);
    }

    public final void f(int i7, RectF rectF, PointF pointF) {
        if (i7 == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (i7 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i7 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    public final f3.c g(int i7, k kVar) {
        return i7 != 1 ? i7 != 2 ? i7 != 3 ? kVar.t() : kVar.r() : kVar.j() : kVar.l();
    }

    public final d h(int i7, k kVar) {
        return i7 != 1 ? i7 != 2 ? i7 != 3 ? kVar.s() : kVar.q() : kVar.i() : kVar.k();
    }

    public final float i(RectF rectF, int i7) {
        float[] fArr = this.f15804h;
        m mVar = this.f15797a[i7];
        fArr[0] = mVar.f15817c;
        fArr[1] = mVar.f15818d;
        this.f15798b[i7].mapPoints(fArr);
        return (i7 == 1 || i7 == 3) ? Math.abs(rectF.centerX() - this.f15804h[0]) : Math.abs(rectF.centerY() - this.f15804h[1]);
    }

    public final f j(int i7, k kVar) {
        return i7 != 1 ? i7 != 2 ? i7 != 3 ? kVar.o() : kVar.p() : kVar.n() : kVar.h();
    }

    public final boolean l(Path path, int i7) {
        this.f15807k.reset();
        this.f15797a[i7].d(this.f15798b[i7], this.f15807k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f15807k.computeBounds(rectF, true);
        path.op(this.f15807k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        return !rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f);
    }

    public final void m(c cVar, int i7) {
        h(i7, cVar.f15810a).c(this.f15797a[i7], 90.0f, cVar.f15814e, cVar.f15812c, g(i7, cVar.f15810a));
        float fA = a(i7);
        this.f15798b[i7].reset();
        f(i7, cVar.f15812c, this.f15800d);
        Matrix matrix = this.f15798b[i7];
        PointF pointF = this.f15800d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f15798b[i7].preRotate(fA);
    }

    public final void n(int i7) {
        this.f15804h[0] = this.f15797a[i7].i();
        this.f15804h[1] = this.f15797a[i7].j();
        this.f15798b[i7].mapPoints(this.f15804h);
        float fA = a(i7);
        this.f15799c[i7].reset();
        Matrix matrix = this.f15799c[i7];
        float[] fArr = this.f15804h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f15799c[i7].preRotate(fA);
    }
}
