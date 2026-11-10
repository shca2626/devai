package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.emoji2.text.c;

/* loaded from: classes.dex */
public class b implements c.d {

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f12279b = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f12280a;

    public b() {
        TextPaint textPaint = new TextPaint();
        this.f12280a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    public static StringBuilder b() {
        ThreadLocal threadLocal = f12279b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return (StringBuilder) threadLocal.get();
    }

    @Override // androidx.emoji2.text.c.d
    public boolean a(CharSequence charSequence, int i7, int i8, int i9) {
        StringBuilder sbB = b();
        sbB.setLength(0);
        while (i7 < i8) {
            sbB.append(charSequence.charAt(i7));
            i7++;
        }
        return O.c.a(this.f12280a, sbB.toString());
    }
}
