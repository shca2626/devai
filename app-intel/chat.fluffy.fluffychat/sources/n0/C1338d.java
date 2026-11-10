package n0;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.c;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* renamed from: n0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1338d implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f19844a;

    /* renamed from: b, reason: collision with root package name */
    public c.e f19845b;

    /* renamed from: n0.d$a */
    public static class a extends c.e {

        /* renamed from: a, reason: collision with root package name */
        public final Reference f19846a;

        /* renamed from: b, reason: collision with root package name */
        public final Reference f19847b;

        public a(TextView textView, C1338d c1338d) {
            this.f19846a = new WeakReference(textView);
            this.f19847b = new WeakReference(c1338d);
        }

        @Override // androidx.emoji2.text.c.e
        public void b() {
            CharSequence text;
            CharSequence charSequenceO;
            super.b();
            TextView textView = (TextView) this.f19846a.get();
            if (c(textView, (InputFilter) this.f19847b.get()) && textView.isAttachedToWindow() && text != (charSequenceO = androidx.emoji2.text.c.b().o((text = textView.getText())))) {
                int selectionStart = Selection.getSelectionStart(charSequenceO);
                int selectionEnd = Selection.getSelectionEnd(charSequenceO);
                textView.setText(charSequenceO);
                if (charSequenceO instanceof Spannable) {
                    C1338d.b((Spannable) charSequenceO, selectionStart, selectionEnd);
                }
            }
        }

        public final boolean c(TextView textView, InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
        }
    }

    public C1338d(TextView textView) {
        this.f19844a = textView;
    }

    public static void b(Spannable spannable, int i7, int i8) {
        if (i7 >= 0 && i8 >= 0) {
            Selection.setSelection(spannable, i7, i8);
        } else if (i7 >= 0) {
            Selection.setSelection(spannable, i7);
        } else if (i8 >= 0) {
            Selection.setSelection(spannable, i8);
        }
    }

    public final c.e a() {
        if (this.f19845b == null) {
            this.f19845b = new a(this.f19844a, this);
        }
        return this.f19845b;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i7, int i8, Spanned spanned, int i9, int i10) {
        if (this.f19844a.isInEditMode()) {
            return charSequence;
        }
        int iD = androidx.emoji2.text.c.b().d();
        if (iD != 0) {
            if (iD == 1) {
                if ((i10 == 0 && i9 == 0 && spanned.length() == 0 && charSequence == this.f19844a.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i7 != 0 || i8 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i7, i8);
                }
                return androidx.emoji2.text.c.b().p(charSequence, 0, charSequence.length());
            }
            if (iD != 3) {
                return charSequence;
            }
        }
        androidx.emoji2.text.c.b().s(a());
        return charSequence;
    }
}
