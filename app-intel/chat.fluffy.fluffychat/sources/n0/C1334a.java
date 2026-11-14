package n0;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* renamed from: n0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1334a {

    /* renamed from: a, reason: collision with root package name */
    public final b f19833a;

    /* renamed from: b, reason: collision with root package name */
    public int f19834b = Integer.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public int f19835c = 0;

    /* renamed from: n0.a$a, reason: collision with other inner class name */
    public static class C0225a extends b {

        /* renamed from: a, reason: collision with root package name */
        public final EditText f19836a;

        /* renamed from: b, reason: collision with root package name */
        public final C1340g f19837b;

        public C0225a(EditText editText, boolean z7) {
            this.f19836a = editText;
            C1340g c1340g = new C1340g(editText, z7);
            this.f19837b = c1340g;
            editText.addTextChangedListener(c1340g);
            editText.setEditableFactory(C1335b.getInstance());
        }

        @Override // n0.C1334a.b
        public KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof C1338e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new C1338e(keyListener);
        }

        @Override // n0.C1334a.b
        public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof C1336c ? inputConnection : new C1336c(this.f19836a, inputConnection, editorInfo);
        }

        @Override // n0.C1334a.b
        public void c(boolean z7) {
            this.f19837b.c(z7);
        }
    }

    /* renamed from: n0.a$b */
    public static class b {
        public abstract KeyListener a(KeyListener keyListener);

        public abstract InputConnection b(InputConnection inputConnection, EditorInfo editorInfo);

        public abstract void c(boolean z7);
    }

    public C1334a(EditText editText, boolean z7) {
        Y.h.k(editText, "editText cannot be null");
        this.f19833a = new C0225a(editText, z7);
    }

    public KeyListener a(KeyListener keyListener) {
        return this.f19833a.a(keyListener);
    }

    public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f19833a.b(inputConnection, editorInfo);
    }

    public void c(boolean z7) {
        this.f19833a.c(z7);
    }
}
