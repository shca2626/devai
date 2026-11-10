package q;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class D {

    /* renamed from: l, reason: collision with root package name */
    public static final RectF f21068l = new RectF();

    /* renamed from: m, reason: collision with root package name */
    public static ConcurrentHashMap f21069m = new ConcurrentHashMap();

    /* renamed from: n, reason: collision with root package name */
    public static ConcurrentHashMap f21070n = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public int f21071a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f21072b = false;

    /* renamed from: c, reason: collision with root package name */
    public float f21073c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    public float f21074d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    public float f21075e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    public int[] f21076f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    public boolean f21077g = false;

    /* renamed from: h, reason: collision with root package name */
    public TextPaint f21078h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f21079i;

    /* renamed from: j, reason: collision with root package name */
    public final Context f21080j;

    /* renamed from: k, reason: collision with root package name */
    public final f f21081k;

    public static final class a {
        public static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i7, TextView textView, TextPaint textPaint) {
            return new StaticLayout(charSequence, textPaint, i7, alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
        }

        public static int b(TextView textView) {
            return textView.getMaxLines();
        }
    }

    public static final class b {
        public static boolean a(View view) {
            return view.isInLayout();
        }
    }

    public static final class c {
        public static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i7, int i8, TextView textView, TextPaint textPaint, f fVar) {
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i7);
            StaticLayout.Builder hyphenationFrequency = builderObtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i8 == -1) {
                i8 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i8);
            try {
                fVar.a(builderObtain, textView);
            } catch (ClassCastException unused) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return builderObtain.build();
        }
    }

    public static class d extends f {
        @Override // q.D.f
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) D.m(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    public static class e extends d {
        @Override // q.D.d, q.D.f
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // q.D.f
        public boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    public static class f {
        public abstract void a(StaticLayout.Builder builder, TextView textView);

        public boolean b(TextView textView) {
            return ((Boolean) D.m(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    public D(TextView textView) {
        this.f21079i = textView;
        this.f21080j = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.f21081k = new e();
        } else {
            this.f21081k = new d();
        }
    }

    public static Method k(String str) throws SecurityException {
        try {
            Method declaredMethod = (Method) f21069m.get(str);
            if (declaredMethod != null || (declaredMethod = TextView.class.getDeclaredMethod(str, null)) == null) {
                return declaredMethod;
            }
            declaredMethod.setAccessible(true);
            f21069m.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e7) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e7);
            return null;
        }
    }

    public static Object m(Object obj, String str, Object obj2) {
        try {
            return k(str).invoke(obj, null);
        } catch (Exception e7) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e7);
            return obj2;
        }
    }

    public void a() {
        if (n()) {
            if (this.f21072b) {
                if (this.f21079i.getMeasuredHeight() <= 0 || this.f21079i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f21081k.b(this.f21079i) ? 1048576 : (this.f21079i.getMeasuredWidth() - this.f21079i.getTotalPaddingLeft()) - this.f21079i.getTotalPaddingRight();
                int height = (this.f21079i.getHeight() - this.f21079i.getCompoundPaddingBottom()) - this.f21079i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f21068l;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float fE = e(rectF);
                        if (fE != this.f21079i.getTextSize()) {
                            t(0, fE);
                        }
                    } finally {
                    }
                }
            }
            this.f21072b = true;
        }
    }

    public final int[] b(int[] iArr) {
        int length = iArr.length;
        if (length != 0) {
            Arrays.sort(iArr);
            ArrayList arrayList = new ArrayList();
            for (int i7 : iArr) {
                if (i7 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i7)) < 0) {
                    arrayList.add(Integer.valueOf(i7));
                }
            }
            if (length != arrayList.size()) {
                int size = arrayList.size();
                int[] iArr2 = new int[size];
                for (int i8 = 0; i8 < size; i8++) {
                    iArr2[i8] = ((Integer) arrayList.get(i8)).intValue();
                }
                return iArr2;
            }
        }
        return iArr;
    }

    public final void c() {
        this.f21071a = 0;
        this.f21074d = -1.0f;
        this.f21075e = -1.0f;
        this.f21073c = -1.0f;
        this.f21076f = new int[0];
        this.f21072b = false;
    }

    public StaticLayout d(CharSequence charSequence, Layout.Alignment alignment, int i7, int i8) {
        return c.a(charSequence, alignment, i7, i8, this.f21079i, this.f21078h, this.f21081k);
    }

    public final int e(RectF rectF) {
        int length = this.f21076f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i7 = 1;
        int i8 = length - 1;
        int i9 = 0;
        while (i7 <= i8) {
            int i10 = (i7 + i8) / 2;
            if (x(this.f21076f[i10], rectF)) {
                int i11 = i10 + 1;
                i9 = i7;
                i7 = i11;
            } else {
                i9 = i10 - 1;
                i8 = i9;
            }
        }
        return this.f21076f[i9];
    }

    public int f() {
        return Math.round(this.f21075e);
    }

    public int g() {
        return Math.round(this.f21074d);
    }

    public int h() {
        return Math.round(this.f21073c);
    }

    public int[] i() {
        return this.f21076f;
    }

    public int j() {
        return this.f21071a;
    }

    public void l(int i7) {
        TextPaint textPaint = this.f21078h;
        if (textPaint == null) {
            this.f21078h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f21078h.set(this.f21079i.getPaint());
        this.f21078h.setTextSize(i7);
    }

    public boolean n() {
        return y() && this.f21071a != 0;
    }

    public void o(AttributeSet attributeSet, int i7) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = this.f21080j.obtainStyledAttributes(attributeSet, i.j.f17256g0, i7, 0);
        TextView textView = this.f21079i;
        Z.W.j0(textView, textView.getContext(), i.j.f17256g0, attributeSet, typedArrayObtainStyledAttributes, i7, 0);
        if (typedArrayObtainStyledAttributes.hasValue(i.j.f17281l0)) {
            this.f21071a = typedArrayObtainStyledAttributes.getInt(i.j.f17281l0, 0);
        }
        float dimension = typedArrayObtainStyledAttributes.hasValue(i.j.f17276k0) ? typedArrayObtainStyledAttributes.getDimension(i.j.f17276k0, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(i.j.f17266i0) ? typedArrayObtainStyledAttributes.getDimension(i.j.f17266i0, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(i.j.f17261h0) ? typedArrayObtainStyledAttributes.getDimension(i.j.f17261h0, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes.hasValue(i.j.f17271j0) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(i.j.f17271j0, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            v(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!y()) {
            this.f21071a = 0;
            return;
        }
        if (this.f21071a == 1) {
            if (!this.f21077g) {
                DisplayMetrics displayMetrics = this.f21080j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                z(dimension2, dimension3, dimension);
            }
            u();
        }
    }

    public void p(int i7, int i8, int i9, int i10) {
        if (y()) {
            DisplayMetrics displayMetrics = this.f21080j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(i10, i7, displayMetrics), TypedValue.applyDimension(i10, i8, displayMetrics), TypedValue.applyDimension(i10, i9, displayMetrics));
            if (u()) {
                a();
            }
        }
    }

    public void q(int[] iArr, int i7) {
        if (y()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i7 == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f21080j.getResources().getDisplayMetrics();
                    for (int i8 = 0; i8 < length; i8++) {
                        iArrCopyOf[i8] = Math.round(TypedValue.applyDimension(i7, iArr[i8], displayMetrics));
                    }
                }
                this.f21076f = b(iArrCopyOf);
                if (!w()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f21077g = false;
            }
            if (u()) {
                a();
            }
        }
    }

    public void r(int i7) {
        if (y()) {
            if (i7 == 0) {
                c();
                return;
            }
            if (i7 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i7);
            }
            DisplayMetrics displayMetrics = this.f21080j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (u()) {
                a();
            }
        }
    }

    public final void s(float f7) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (f7 != this.f21079i.getPaint().getTextSize()) {
            this.f21079i.getPaint().setTextSize(f7);
            boolean zA = b.a(this.f21079i);
            if (this.f21079i.getLayout() != null) {
                this.f21072b = false;
                try {
                    Method methodK = k("nullLayouts");
                    if (methodK != null) {
                        methodK.invoke(this.f21079i, null);
                    }
                } catch (Exception e7) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e7);
                }
                if (zA) {
                    this.f21079i.forceLayout();
                } else {
                    this.f21079i.requestLayout();
                }
                this.f21079i.invalidate();
            }
        }
    }

    public void t(int i7, float f7) {
        Context context = this.f21080j;
        s(TypedValue.applyDimension(i7, f7, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    public final boolean u() {
        if (y() && this.f21071a == 1) {
            if (!this.f21077g || this.f21076f.length == 0) {
                int iFloor = ((int) Math.floor((this.f21075e - this.f21074d) / this.f21073c)) + 1;
                int[] iArr = new int[iFloor];
                for (int i7 = 0; i7 < iFloor; i7++) {
                    iArr[i7] = Math.round(this.f21074d + (i7 * this.f21073c));
                }
                this.f21076f = b(iArr);
            }
            this.f21072b = true;
        } else {
            this.f21072b = false;
        }
        return this.f21072b;
    }

    public final void v(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i7 = 0; i7 < length; i7++) {
                iArr[i7] = typedArray.getDimensionPixelSize(i7, -1);
            }
            this.f21076f = b(iArr);
            w();
        }
    }

    public final boolean w() {
        boolean z7 = this.f21076f.length > 0;
        this.f21077g = z7;
        if (z7) {
            this.f21071a = 1;
            this.f21074d = r0[0];
            this.f21075e = r0[r1 - 1];
            this.f21073c = -1.0f;
        }
        return z7;
    }

    public final boolean x(int i7, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f21079i.getText();
        TransformationMethod transformationMethod = this.f21079i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f21079i)) != null) {
            text = transformation;
        }
        int iB = a.b(this.f21079i);
        l(i7);
        StaticLayout staticLayoutD = d(text, (Layout.Alignment) m(this.f21079i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), iB);
        return (iB == -1 || (staticLayoutD.getLineCount() <= iB && staticLayoutD.getLineEnd(staticLayoutD.getLineCount() - 1) == text.length())) && ((float) staticLayoutD.getHeight()) <= rectF.bottom;
    }

    public final boolean y() {
        return !(this.f21079i instanceof C1474k);
    }

    public final void z(float f7, float f8, float f9) {
        if (f7 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f7 + "px) is less or equal to (0px)");
        }
        if (f8 <= f7) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f8 + "px) is less or equal to minimum auto-size text size (" + f7 + "px)");
        }
        if (f9 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f9 + "px) is less or equal to (0px)");
        }
        this.f21071a = 1;
        this.f21074d = f7;
        this.f21075e = f8;
        this.f21073c = f9;
        this.f21077g = false;
    }
}
