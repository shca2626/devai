package q;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import n0.C1334a;

/* renamed from: q.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1474l {

    /* renamed from: a, reason: collision with root package name */
    public final EditText f21316a;

    /* renamed from: b, reason: collision with root package name */
    public final C1334a f21317b;

    public C1474l(EditText editText) {
        this.f21316a = editText;
        this.f21317b = new C1334a(editText, false);
    }

    public KeyListener a(KeyListener keyListener) {
        return b(keyListener) ? this.f21317b.a(keyListener) : keyListener;
    }

    public boolean b(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    public void c(AttributeSet attributeSet, int i7) {
        TypedArray typedArrayObtainStyledAttributes = this.f21316a.getContext().obtainStyledAttributes(attributeSet, i.j.f17256g0, i7, 0);
        try {
            boolean z7 = typedArrayObtainStyledAttributes.hasValue(i.j.f17326u0) ? typedArrayObtainStyledAttributes.getBoolean(i.j.f17326u0, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            e(z7);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public InputConnection d(InputConnection inputConnection, EditorInfo editorInfo) {
        return this.f21317b.b(inputConnection, editorInfo);
    }

    public void e(boolean z7) {
        this.f21317b.c(z7);
    }
}
