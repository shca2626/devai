package androidx.appcompat.widget;

import Z.W;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: l, reason: collision with root package name */
    public TypedValue f11355l;

    /* renamed from: m, reason: collision with root package name */
    public TypedValue f11356m;

    /* renamed from: n, reason: collision with root package name */
    public TypedValue f11357n;

    /* renamed from: o, reason: collision with root package name */
    public TypedValue f11358o;

    /* renamed from: p, reason: collision with root package name */
    public TypedValue f11359p;

    /* renamed from: q, reason: collision with root package name */
    public TypedValue f11360q;

    /* renamed from: r, reason: collision with root package name */
    public final Rect f11361r;

    /* renamed from: s, reason: collision with root package name */
    public a f11362s;

    public interface a {
        void a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public void a(int i7, int i8, int i9, int i10) {
        this.f11361r.set(i7, i8, i9, i10);
        if (W.Q(this)) {
            requestLayout();
        }
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f11359p == null) {
            this.f11359p = new TypedValue();
        }
        return this.f11359p;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f11360q == null) {
            this.f11360q = new TypedValue();
        }
        return this.f11360q;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f11357n == null) {
            this.f11357n = new TypedValue();
        }
        return this.f11357n;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f11358o == null) {
            this.f11358o = new TypedValue();
        }
        return this.f11358o;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f11355l == null) {
            this.f11355l = new TypedValue();
        }
        return this.f11355l;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f11356m == null) {
            this.f11356m = new TypedValue();
        }
        return this.f11356m;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f11362s;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f11362s;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00db  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(a aVar) {
        this.f11362s = aVar;
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f11361r = new Rect();
    }
}
