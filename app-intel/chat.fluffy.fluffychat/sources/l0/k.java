package l0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;

/* loaded from: classes.dex */
public final class k extends AbstractC1297f {

    /* renamed from: q, reason: collision with root package name */
    public static Paint f19536q;

    public k(C1296e c1296e) {
        super(c1296e);
    }

    public static Paint c() {
        if (f19536q == null) {
            TextPaint textPaint = new TextPaint();
            f19536q = textPaint;
            textPaint.setColor(androidx.emoji2.text.c.b().c());
            f19536q.setStyle(Paint.Style.FILL);
        }
        return f19536q;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i7, int i8, float f7, int i9, int i10, int i11, Paint paint) {
        Canvas canvas2;
        float f8;
        if (androidx.emoji2.text.c.b().i()) {
            canvas2 = canvas;
            f8 = f7;
            canvas2.drawRect(f8, i9, f7 + b(), i11, c());
        } else {
            canvas2 = canvas;
            f8 = f7;
        }
        a().a(canvas2, f8, i10, paint);
    }
}
