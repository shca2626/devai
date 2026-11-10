package q;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import n0.C1340f;

/* renamed from: q.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1476m {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f21319a;

    /* renamed from: b, reason: collision with root package name */
    public final C1340f f21320b;

    public C1476m(TextView textView) {
        this.f21319a = textView;
        this.f21320b = new C1340f(textView, false);
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f21320b.a(inputFilterArr);
    }

    public boolean b() {
        return this.f21320b.b();
    }

    public void c(AttributeSet attributeSet, int i7) {
        TypedArray typedArrayObtainStyledAttributes = this.f21319a.getContext().obtainStyledAttributes(attributeSet, i.j.f17256g0, i7, 0);
        try {
            boolean z7 = typedArrayObtainStyledAttributes.hasValue(i.j.f17326u0) ? typedArrayObtainStyledAttributes.getBoolean(i.j.f17326u0, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            e(z7);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void d(boolean z7) {
        this.f21320b.c(z7);
    }

    public void e(boolean z7) {
        this.f21320b.d(z7);
    }

    public TransformationMethod f(TransformationMethod transformationMethod) {
        return this.f21320b.e(transformationMethod);
    }
}
