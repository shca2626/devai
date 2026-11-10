package X;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

/* loaded from: classes.dex */
public abstract class l implements Spannable {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final TextPaint f9201a;

        /* renamed from: b, reason: collision with root package name */
        public final TextDirectionHeuristic f9202b;

        /* renamed from: c, reason: collision with root package name */
        public final int f9203c;

        /* renamed from: d, reason: collision with root package name */
        public final int f9204d;

        /* renamed from: e, reason: collision with root package name */
        public final PrecomputedText.Params f9205e;

        /* renamed from: X.l$a$a, reason: collision with other inner class name */
        public static class C0077a {

            /* renamed from: a, reason: collision with root package name */
            public final TextPaint f9206a;

            /* renamed from: c, reason: collision with root package name */
            public int f9208c = 1;

            /* renamed from: d, reason: collision with root package name */
            public int f9209d = 1;

            /* renamed from: b, reason: collision with root package name */
            public TextDirectionHeuristic f9207b = TextDirectionHeuristics.FIRSTSTRONG_LTR;

            public C0077a(TextPaint textPaint) {
                this.f9206a = textPaint;
            }

            public a a() {
                return new a(this.f9206a, this.f9207b, this.f9208c, this.f9209d);
            }

            public C0077a b(int i7) {
                this.f9208c = i7;
                return this;
            }

            public C0077a c(int i7) {
                this.f9209d = i7;
                return this;
            }

            public C0077a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f9207b = textDirectionHeuristic;
                return this;
            }
        }

        public a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i7, int i8) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f9205e = k.a(textPaint).setBreakStrategy(i7).setHyphenationFrequency(i8).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f9205e = null;
            }
            this.f9201a = textPaint;
            this.f9202b = textDirectionHeuristic;
            this.f9203c = i7;
            this.f9204d = i8;
        }

        public boolean a(a aVar) {
            if (this.f9203c == aVar.b() && this.f9204d == aVar.c() && this.f9201a.getTextSize() == aVar.e().getTextSize() && this.f9201a.getTextScaleX() == aVar.e().getTextScaleX() && this.f9201a.getTextSkewX() == aVar.e().getTextSkewX() && this.f9201a.getLetterSpacing() == aVar.e().getLetterSpacing() && TextUtils.equals(this.f9201a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()) && this.f9201a.getFlags() == aVar.e().getFlags() && this.f9201a.getTextLocales().equals(aVar.e().getTextLocales())) {
                return this.f9201a.getTypeface() == null ? aVar.e().getTypeface() == null : this.f9201a.getTypeface().equals(aVar.e().getTypeface());
            }
            return false;
        }

        public int b() {
            return this.f9203c;
        }

        public int c() {
            return this.f9204d;
        }

        public TextDirectionHeuristic d() {
            return this.f9202b;
        }

        public TextPaint e() {
            return this.f9201a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a(aVar) && this.f9202b == aVar.d();
        }

        public int hashCode() {
            return Y.c.b(Float.valueOf(this.f9201a.getTextSize()), Float.valueOf(this.f9201a.getTextScaleX()), Float.valueOf(this.f9201a.getTextSkewX()), Float.valueOf(this.f9201a.getLetterSpacing()), Integer.valueOf(this.f9201a.getFlags()), this.f9201a.getTextLocales(), this.f9201a.getTypeface(), Boolean.valueOf(this.f9201a.isElegantTextHeight()), this.f9202b, Integer.valueOf(this.f9203c), Integer.valueOf(this.f9204d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f9201a.getTextSize());
            sb.append(", textScaleX=" + this.f9201a.getTextScaleX());
            sb.append(", textSkewX=" + this.f9201a.getTextSkewX());
            sb.append(", letterSpacing=" + this.f9201a.getLetterSpacing());
            sb.append(", elegantTextHeight=" + this.f9201a.isElegantTextHeight());
            int i7 = Build.VERSION.SDK_INT;
            sb.append(", textLocale=" + this.f9201a.getTextLocales());
            sb.append(", typeface=" + this.f9201a.getTypeface());
            if (i7 >= 26) {
                sb.append(", variationSettings=" + this.f9201a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f9202b);
            sb.append(", breakStrategy=" + this.f9203c);
            sb.append(", hyphenationFrequency=" + this.f9204d);
            sb.append("}");
            return sb.toString();
        }

        public a(PrecomputedText.Params params) {
            this.f9201a = params.getTextPaint();
            this.f9202b = params.getTextDirection();
            this.f9203c = params.getBreakStrategy();
            this.f9204d = params.getHyphenationFrequency();
            this.f9205e = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}
