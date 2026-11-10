package n0;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;

/* renamed from: n0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1339e implements KeyListener {

    /* renamed from: a, reason: collision with root package name */
    public final KeyListener f19848a;

    /* renamed from: b, reason: collision with root package name */
    public final a f19849b;

    /* renamed from: n0.e$a */
    public static class a {
        public boolean a(Editable editable, int i7, KeyEvent keyEvent) {
            return androidx.emoji2.text.c.f(editable, i7, keyEvent);
        }
    }

    public C1339e(KeyListener keyListener) {
        this(keyListener, new a());
    }

    @Override // android.text.method.KeyListener
    public void clearMetaKeyState(View view, Editable editable, int i7) {
        this.f19848a.clearMetaKeyState(view, editable, i7);
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return this.f19848a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyDown(View view, Editable editable, int i7, KeyEvent keyEvent) {
        return this.f19849b.a(editable, i7, keyEvent) || this.f19848a.onKeyDown(view, editable, i7, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f19848a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyUp(View view, Editable editable, int i7, KeyEvent keyEvent) {
        return this.f19848a.onKeyUp(view, editable, i7, keyEvent);
    }

    public C1339e(KeyListener keyListener, a aVar) {
        this.f19848a = keyListener;
        this.f19849b = aVar;
    }
}
