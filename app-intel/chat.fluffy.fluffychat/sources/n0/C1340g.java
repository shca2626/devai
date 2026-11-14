package n0;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.c;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* renamed from: n0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1340g implements TextWatcher {

    /* renamed from: l, reason: collision with root package name */
    public final EditText f19854l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f19855m;

    /* renamed from: n, reason: collision with root package name */
    public c.e f19856n;

    /* renamed from: o, reason: collision with root package name */
    public int f19857o = Integer.MAX_VALUE;

    /* renamed from: p, reason: collision with root package name */
    public int f19858p = 0;

    /* renamed from: q, reason: collision with root package name */
    public boolean f19859q = true;

    /* renamed from: n0.g$a */
    public static class a extends c.e {

        /* renamed from: a, reason: collision with root package name */
        public final Reference f19860a;

        public a(EditText editText) {
            this.f19860a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.c.e
        public void b() {
            super.b();
            C1340g.b((EditText) this.f19860a.get(), 1);
        }
    }

    public C1340g(EditText editText, boolean z7) {
        this.f19854l = editText;
        this.f19855m = z7;
    }

    public static void b(EditText editText, int i7) {
        if (i7 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            androidx.emoji2.text.c.b().o(editableText);
            C1337d.b(editableText, selectionStart, selectionEnd);
        }
    }

    public final c.e a() {
        if (this.f19856n == null) {
            this.f19856n = new a(this.f19854l);
        }
        return this.f19856n;
    }

    public void c(boolean z7) {
        if (this.f19859q != z7) {
            if (this.f19856n != null) {
                androidx.emoji2.text.c.b().t(this.f19856n);
            }
            this.f19859q = z7;
            if (z7) {
                b(this.f19854l, androidx.emoji2.text.c.b().d());
            }
        }
    }

    public final boolean d() {
        if (this.f19859q) {
            return (this.f19855m || androidx.emoji2.text.c.h()) ? false : true;
        }
        return true;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        if (this.f19854l.isInEditMode() || d() || i8 > i9 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iD = androidx.emoji2.text.c.b().d();
        if (iD != 0) {
            if (iD == 1) {
                androidx.emoji2.text.c.b().r((Spannable) charSequence, i7, i7 + i9, this.f19857o, this.f19858p);
                return;
            } else if (iD != 3) {
                return;
            }
        }
        androidx.emoji2.text.c.b().s(a());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
    }
}
