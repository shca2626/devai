package l0;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* loaded from: classes.dex */
public class l implements Spannable {

    /* renamed from: l, reason: collision with root package name */
    public boolean f19536l = false;

    /* renamed from: m, reason: collision with root package name */
    public Spannable f19537m;

    public static class a {
        public static IntStream a(CharSequence charSequence) {
            return charSequence.chars();
        }

        public static IntStream b(CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }

    public static class b {
        public boolean a(CharSequence charSequence) {
            return false;
        }
    }

    public static class c extends b {
        @Override // l0.l.b
        public boolean a(CharSequence charSequence) {
            return m.a(charSequence);
        }
    }

    public l(Spannable spannable) {
        this.f19537m = spannable;
    }

    public static b c() {
        return Build.VERSION.SDK_INT < 28 ? new b() : new c();
    }

    public final void a() {
        Spannable spannable = this.f19537m;
        if (!this.f19536l && c().a(spannable)) {
            this.f19537m = new SpannableString(spannable);
        }
        this.f19536l = true;
    }

    public Spannable b() {
        return this.f19537m;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i7) {
        return this.f19537m.charAt(i7);
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return a.a(this.f19537m);
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return a.b(this.f19537m);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f19537m.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f19537m.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f19537m.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public Object[] getSpans(int i7, int i8, Class cls) {
        return this.f19537m.getSpans(i7, i8, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f19537m.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i7, int i8, Class cls) {
        return this.f19537m.nextSpanTransition(i7, i8, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        a();
        this.f19537m.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i7, int i8, int i9) {
        a();
        this.f19537m.setSpan(obj, i7, i8, i9);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i7, int i8) {
        return this.f19537m.subSequence(i7, i8);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f19537m.toString();
    }

    public l(CharSequence charSequence) {
        this.f19537m = new SpannableString(charSequence);
    }
}
