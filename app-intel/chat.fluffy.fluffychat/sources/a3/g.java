package a3;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: n, reason: collision with root package name */
    public static final int f10747n = 1;

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f10748a;

    /* renamed from: b, reason: collision with root package name */
    public final TextPaint f10749b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10750c;

    /* renamed from: e, reason: collision with root package name */
    public int f10752e;

    /* renamed from: l, reason: collision with root package name */
    public boolean f10759l;

    /* renamed from: d, reason: collision with root package name */
    public int f10751d = 0;

    /* renamed from: f, reason: collision with root package name */
    public Layout.Alignment f10753f = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: g, reason: collision with root package name */
    public int f10754g = Integer.MAX_VALUE;

    /* renamed from: h, reason: collision with root package name */
    public float f10755h = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    public float f10756i = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    public int f10757j = f10747n;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10758k = true;

    /* renamed from: m, reason: collision with root package name */
    public TextUtils.TruncateAt f10760m = null;

    public static class a extends Exception {
    }

    public g(CharSequence charSequence, TextPaint textPaint, int i7) {
        this.f10748a = charSequence;
        this.f10749b = textPaint;
        this.f10750c = i7;
        this.f10752e = charSequence.length();
    }

    public static g b(CharSequence charSequence, TextPaint textPaint, int i7) {
        return new g(charSequence, textPaint, i7);
    }

    public StaticLayout a() {
        if (this.f10748a == null) {
            this.f10748a = "";
        }
        int iMax = Math.max(0, this.f10750c);
        CharSequence charSequenceEllipsize = this.f10748a;
        if (this.f10754g == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f10749b, iMax, this.f10760m);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f10752e);
        this.f10752e = iMin;
        if (this.f10759l && this.f10754g == 1) {
            this.f10753f = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, this.f10751d, iMin, this.f10749b, iMax);
        builderObtain.setAlignment(this.f10753f);
        builderObtain.setIncludePad(this.f10758k);
        builderObtain.setTextDirection(this.f10759l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f10760m;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f10754g);
        float f7 = this.f10755h;
        if (f7 != 0.0f || this.f10756i != 1.0f) {
            builderObtain.setLineSpacing(f7, this.f10756i);
        }
        if (this.f10754g > 1) {
            builderObtain.setHyphenationFrequency(this.f10757j);
        }
        return builderObtain.build();
    }

    public g c(Layout.Alignment alignment) {
        this.f10753f = alignment;
        return this;
    }

    public g d(TextUtils.TruncateAt truncateAt) {
        this.f10760m = truncateAt;
        return this;
    }

    public g e(int i7) {
        this.f10757j = i7;
        return this;
    }

    public g f(boolean z7) {
        this.f10758k = z7;
        return this;
    }

    public g g(boolean z7) {
        this.f10759l = z7;
        return this;
    }

    public g h(float f7, float f8) {
        this.f10755h = f7;
        this.f10756i = f8;
        return this;
    }

    public g i(int i7) {
        this.f10754g = i7;
        return this;
    }

    public g j(h hVar) {
        return this;
    }
}
