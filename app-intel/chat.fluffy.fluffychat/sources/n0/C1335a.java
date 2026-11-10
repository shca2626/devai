package n0;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* renamed from: n0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1335a {

    /* renamed from: a, reason: collision with root package name */
    public final b f19834a;

    /* renamed from: b, reason: collision with root package name */
    public int f19835b = Integer.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public int f19836c = 0;

    /* renamed from: n0.a$a, reason: collision with other inner class name */
    public static class C0225a extends b {

        /* renamed from: a, reason: collision with root package name */
        public final EditText f19837a;

        /* renamed from: b, reason: collision with root package name */
        public final C1341g f19838b;

        public C0225a(EditText editText, boolean z7) {
            this.f19837a = editText;
            C1341g c1341g = new C1341g(editText, z7);
            this.f19838b = c1341g;
            editText.addTextChangedListener(c1341g);
            editText.setEditableFactory(C1336b.getInstance());
        }

        @Override // n0.C1335a.b
        public KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof C1339e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new C1339e(keyListener);
        }

        @Override // n0.C1335a.b
        public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof C1337c ? inputConnection : new C1337c(this.f19837a, inputConnection, editorInfo);
        }

        @Override // n0.C1335a.b
        public void c(boolean z7) {
            this.f19838b.c(z7);
        }
    }

    /* renamed from: n0.a$b */
    public static class b {
        public abstract KeyListener a(KeyListener keyListener);

        public abstract InputConnection b(InputConnection inputConnection, EditorInfo editorInfo);

        public abstract void c(boolean z7);
    }

    public C1335a(EditText editText, boolean z7) {
        Y.h.k(editText, "editText cannot be null");
        this.f19834a = new C0225a(editText, z7);
    }

    public KeyListener a(KeyListener keyListener) {
        return this.f19834a.a(keyListener);
    }

    public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f19834a.b(inputConnection, editorInfo);
    }

    public void c(boolean z7) {
        this.f19834a.c(z7);
    }
}
