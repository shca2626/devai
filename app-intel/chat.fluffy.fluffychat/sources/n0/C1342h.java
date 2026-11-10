package n0;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;

/* renamed from: n0.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1342h implements TransformationMethod {

    /* renamed from: l, reason: collision with root package name */
    public final TransformationMethod f19862l;

    public C1342h(TransformationMethod transformationMethod) {
        this.f19862l = transformationMethod;
    }

    public TransformationMethod a() {
        return this.f19862l;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f19862l;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        return (charSequence == null || androidx.emoji2.text.c.b().d() != 1) ? charSequence : androidx.emoji2.text.c.b().o(charSequence);
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z7, int i7, Rect rect) {
        TransformationMethod transformationMethod = this.f19862l;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z7, i7, rect);
        }
    }
}
