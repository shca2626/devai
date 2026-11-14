package e3;

import O.AbstractC0563a;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* renamed from: e3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1033a {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f15596i = new int[3];

    /* renamed from: j, reason: collision with root package name */
    public static final float[] f15597j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f15598k = new int[4];

    /* renamed from: l, reason: collision with root package name */
    public static final float[] f15599l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    public final Paint f15600a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f15601b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f15602c;

    /* renamed from: d, reason: collision with root package name */
    public int f15603d;

    /* renamed from: e, reason: collision with root package name */
    public int f15604e;

    /* renamed from: f, reason: collision with root package name */
    public int f15605f;

    /* renamed from: g, reason: collision with root package name */
    public final Path f15606g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f15607h;

    public C1033a() {
        this(-16777216);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i7, float f7, float f8) {
        float f9;
        boolean z7 = f8 < 0.0f;
        Path path = this.f15606g;
        if (z7) {
            int[] iArr = f15598k;
            iArr[0] = 0;
            iArr[1] = this.f15605f;
            iArr[2] = this.f15604e;
            iArr[3] = this.f15603d;
            f9 = f7;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            f9 = f7;
            path.arcTo(rectF, f9, f8);
            path.close();
            float f10 = -i7;
            rectF.inset(f10, f10);
            int[] iArr2 = f15598k;
            iArr2[0] = 0;
            iArr2[1] = this.f15603d;
            iArr2[2] = this.f15604e;
            iArr2[3] = this.f15605f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= 0.0f) {
            return;
        }
        float f11 = 1.0f - (i7 / fWidth);
        float[] fArr = f15599l;
        fArr[1] = f11;
        fArr[2] = ((1.0f - f11) / 2.0f) + f11;
        this.f15601b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, f15598k, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z7) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f15607h);
        }
        canvas.drawArc(rectF, f9, f8, true, this.f15601b);
        canvas.restore();
    }

    public void b(Canvas canvas, Matrix matrix, RectF rectF, int i7) {
        rectF.bottom += i7;
        rectF.offset(0.0f, -i7);
        int[] iArr = f15596i;
        iArr[0] = this.f15605f;
        iArr[1] = this.f15604e;
        iArr[2] = this.f15603d;
        Paint paint = this.f15602c;
        float f7 = rectF.left;
        paint.setShader(new LinearGradient(f7, rectF.top, f7, rectF.bottom, iArr, f15597j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f15602c);
        canvas.restore();
    }

    public Paint c() {
        return this.f15600a;
    }

    public void d(int i7) {
        this.f15603d = AbstractC0563a.j(i7, 68);
        this.f15604e = AbstractC0563a.j(i7, 20);
        this.f15605f = AbstractC0563a.j(i7, 0);
        this.f15600a.setColor(this.f15603d);
    }

    public C1033a(int i7) {
        this.f15606g = new Path();
        Paint paint = new Paint();
        this.f15607h = paint;
        this.f15600a = new Paint();
        d(i7);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f15601b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f15602c = new Paint(paint2);
    }
}
