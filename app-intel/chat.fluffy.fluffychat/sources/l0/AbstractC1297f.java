package l0;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* renamed from: l0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1297f extends ReplacementSpan {

    /* renamed from: m, reason: collision with root package name */
    public final C1296e f19523m;

    /* renamed from: l, reason: collision with root package name */
    public final Paint.FontMetricsInt f19522l = new Paint.FontMetricsInt();

    /* renamed from: n, reason: collision with root package name */
    public short f19524n = -1;

    /* renamed from: o, reason: collision with root package name */
    public short f19525o = -1;

    /* renamed from: p, reason: collision with root package name */
    public float f19526p = 1.0f;

    public AbstractC1297f(C1296e c1296e) {
        Y.h.k(c1296e, "metadata cannot be null");
        this.f19523m = c1296e;
    }

    public final C1296e a() {
        return this.f19523m;
    }

    public final int b() {
        return this.f19524n;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i7, int i8, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f19522l);
        Paint.FontMetricsInt fontMetricsInt2 = this.f19522l;
        this.f19526p = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f19523m.e();
        this.f19525o = (short) (this.f19523m.e() * this.f19526p);
        short sI = (short) (this.f19523m.i() * this.f19526p);
        this.f19524n = sI;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f19522l;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return sI;
    }
}
