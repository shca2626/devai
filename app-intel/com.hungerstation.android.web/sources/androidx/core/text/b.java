package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;

@SuppressLint({"InlinedApi"})
/* loaded from: classes7.dex */
public final class b {

    static class a {
        static Spanned a(String str, int i12) {
            return Html.fromHtml(str, i12);
        }

        static Spanned b(String str, int i12, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
            return Html.fromHtml(str, i12, imageGetter, tagHandler);
        }

        static String c(Spanned spanned, int i12) {
            return Html.toHtml(spanned, i12);
        }
    }

    public static Spanned a(String str, int i12) {
        return Build.VERSION.SDK_INT >= 24 ? a.a(str, i12) : Html.fromHtml(str);
    }
}
