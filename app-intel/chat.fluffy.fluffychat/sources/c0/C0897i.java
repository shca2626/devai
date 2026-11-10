package c0;

import Z.C0688d;
import Z.J;
import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/* renamed from: c0.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0897i implements J {
    public static CharSequence b(Context context, ClipData.Item item, int i7) {
        if ((i7 & 1) == 0) {
            return item.coerceToStyledText(context);
        }
        CharSequence charSequenceCoerceToText = item.coerceToText(context);
        return charSequenceCoerceToText instanceof Spanned ? charSequenceCoerceToText.toString() : charSequenceCoerceToText;
    }

    public static void c(Editable editable, CharSequence charSequence) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int iMax = Math.max(0, Math.min(selectionStart, selectionEnd));
        int iMax2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, iMax2);
        editable.replace(iMax, iMax2, charSequence);
    }

    @Override // Z.J
    public C0688d a(View view, C0688d c0688d) {
        if (Log.isLoggable("ReceiveContent", 3)) {
            Log.d("ReceiveContent", "onReceive: " + c0688d);
        }
        if (c0688d.d() == 2) {
            return c0688d;
        }
        ClipData clipDataB = c0688d.b();
        int iC = c0688d.c();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z7 = false;
        for (int i7 = 0; i7 < clipDataB.getItemCount(); i7++) {
            CharSequence charSequenceB = b(context, clipDataB.getItemAt(i7), iC);
            if (charSequenceB != null) {
                if (z7) {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), charSequenceB);
                } else {
                    c(editable, charSequenceB);
                    z7 = true;
                }
            }
        }
        return null;
    }
}
