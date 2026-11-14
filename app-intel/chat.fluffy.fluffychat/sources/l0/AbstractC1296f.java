package l0;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* renamed from: l0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1296f extends ReplacementSpan {

    /* renamed from: m, reason: collision with root package name */
    public final C1295e f19522m;

    /* renamed from: l, reason: collision with root package name */
    public final Paint.FontMetricsInt f19521l = new Paint.FontMetricsInt();

    /* renamed from: n, reason: collision with root package name */
    public short f19523n = -1;

    /* renamed from: o, reason: collision with root package name */
    public short f19524o = -1;

    /* renamed from: p, reason: collision with root package name */
    public float f19525p = 1.0f;

    public AbstractC1296f(C1295e c1295e) {
        Y.h.k(c1295e, "metadata cannot be null");
        this.f19522m = c1295e;
    }

    public final C1295e a() {
        return this.f19522m;
    }

    public final int b() {
        return this.f19523n;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i7, int i8, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f19521l);
        Paint.FontMetricsInt fontMetricsInt2 = this.f19521l;
        this.f19525p = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f19522m.e();
        this.f19524o = (short) (this.f19522m.e() * this.f19525p);
        short sI = (short) (this.f19522m.i() * this.f19525p);
        this.f19523n = sI;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f19521l;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return sI;
    }
}
