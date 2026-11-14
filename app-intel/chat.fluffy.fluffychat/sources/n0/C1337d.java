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
public final class C1337d implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f19843a;

    /* renamed from: b, reason: collision with root package name */
    public c.e f19844b;

    /* renamed from: n0.d$a */
    public static class a extends c.e {

        /* renamed from: a, reason: collision with root package name */
        public final Reference f19845a;

        /* renamed from: b, reason: collision with root package name */
        public final Reference f19846b;

        public a(TextView textView, C1337d c1337d) {
            this.f19845a = new WeakReference(textView);
            this.f19846b = new WeakReference(c1337d);
        }

        @Override // androidx.emoji2.text.c.e
        public void b() {
            CharSequence text;
            CharSequence charSequenceO;
            super.b();
            TextView textView = (TextView) this.f19845a.get();
            if (c(textView, (InputFilter) this.f19846b.get()) && textView.isAttachedToWindow() && text != (charSequenceO = androidx.emoji2.text.c.b().o((text = textView.getText())))) {
                int selectionStart = Selection.getSelectionStart(charSequenceO);
                int selectionEnd = Selection.getSelectionEnd(charSequenceO);
                textView.setText(charSequenceO);
                if (charSequenceO instanceof Spannable) {
                    C1337d.b((Spannable) charSequenceO, selectionStart, selectionEnd);
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

    public C1337d(TextView textView) {
        this.f19843a = textView;
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
        if (this.f19844b == null) {
            this.f19844b = new a(this.f19843a, this);
        }
        return this.f19844b;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i7, int i8, Spanned spanned, int i9, int i10) {
        if (this.f19843a.isInEditMode()) {
            return charSequence;
        }
        int iD = androidx.emoji2.text.c.b().d();
        if (iD != 0) {
            if (iD == 1) {
                if ((i10 == 0 && i9 == 0 && spanned.length() == 0 && charSequence == this.f19843a.getText()) || charSequence == null) {
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
