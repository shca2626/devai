package n0;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;

/* renamed from: n0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1336c extends InputConnectionWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f19841a;

    /* renamed from: b, reason: collision with root package name */
    public final a f19842b;

    /* renamed from: n0.c$a */
    public static class a {
        public boolean a(InputConnection inputConnection, Editable editable, int i7, int i8, boolean z7) {
            return androidx.emoji2.text.c.e(inputConnection, editable, i7, i8, z7);
        }

        public void b(EditorInfo editorInfo) {
            if (androidx.emoji2.text.c.h()) {
                androidx.emoji2.text.c.b().u(editorInfo);
            }
        }
    }

    public C1336c(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new a());
    }

    public final Editable a() {
        return this.f19841a.getEditableText();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i7, int i8) {
        return this.f19842b.a(this, a(), i7, i8, false) || super.deleteSurroundingText(i7, i8);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i7, int i8) {
        return this.f19842b.a(this, a(), i7, i8, true) || super.deleteSurroundingTextInCodePoints(i7, i8);
    }

    public C1336c(TextView textView, InputConnection inputConnection, EditorInfo editorInfo, a aVar) {
        super(inputConnection, false);
        this.f19841a = textView;
        this.f19842b = aVar;
        aVar.b(editorInfo);
    }
}
