package n0;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;

/* renamed from: n0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1338e implements KeyListener {

    /* renamed from: a, reason: collision with root package name */
    public final KeyListener f19847a;

    /* renamed from: b, reason: collision with root package name */
    public final a f19848b;

    /* renamed from: n0.e$a */
    public static class a {
        public boolean a(Editable editable, int i7, KeyEvent keyEvent) {
            return androidx.emoji2.text.c.f(editable, i7, keyEvent);
        }
    }

    public C1338e(KeyListener keyListener) {
        this(keyListener, new a());
    }

    @Override // android.text.method.KeyListener
    public void clearMetaKeyState(View view, Editable editable, int i7) {
        this.f19847a.clearMetaKeyState(view, editable, i7);
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return this.f19847a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyDown(View view, Editable editable, int i7, KeyEvent keyEvent) {
        return this.f19848b.a(editable, i7, keyEvent) || this.f19847a.onKeyDown(view, editable, i7, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f19847a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyUp(View view, Editable editable, int i7, KeyEvent keyEvent) {
        return this.f19847a.onKeyUp(view, editable, i7, keyEvent);
    }

    public C1338e(KeyListener keyListener, a aVar) {
        this.f19847a = keyListener;
        this.f19848b = aVar;
    }
}
