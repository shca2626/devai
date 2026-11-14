package n;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

/* renamed from: n.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1333a implements TransformationMethod {

    /* renamed from: l, reason: collision with root package name */
    public Locale f19832l;

    public C1333a(Context context) {
        this.f19832l = context.getResources().getConfiguration().locale;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.f19832l);
        }
        return null;
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z7, int i7, Rect rect) {
    }
}
