package J1;

import E0.AbstractC0332s;
import E0.U;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import j3.o;
import java.util.ArrayDeque;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class f {
    public static void a(Spannable spannable, int i7, int i8, g gVar, c cVar, Map map, int i9) {
        c cVarE;
        g gVarF;
        int i10;
        if (gVar.n() != -1) {
            spannable.setSpan(new StyleSpan(gVar.n()), i7, i8, 33);
        }
        if (gVar.u()) {
            spannable.setSpan(new StrikethroughSpan(), i7, i8, 33);
        }
        if (gVar.v()) {
            spannable.setSpan(new UnderlineSpan(), i7, i8, 33);
        }
        if (gVar.s()) {
            D0.g.b(spannable, new ForegroundColorSpan(gVar.d()), i7, i8, 33);
        }
        if (gVar.r()) {
            D0.g.b(spannable, new BackgroundColorSpan(gVar.b()), i7, i8, 33);
        }
        if (gVar.e() != null) {
            D0.g.b(spannable, new TypefaceSpan(gVar.e()), i7, i8, 33);
        }
        if (gVar.q() != null) {
            b bVar = (b) o.q(gVar.q());
            int i11 = bVar.f4658a;
            if (i11 == -1) {
                i11 = (i9 == 2 || i9 == 1) ? 3 : 1;
                i10 = 1;
            } else {
                i10 = bVar.f4659b;
            }
            int i12 = bVar.f4660c;
            if (i12 == -2) {
                i12 = 1;
            }
            D0.g.b(spannable, new D0.h(i11, i10, i12), i7, i8, 33);
        }
        int iL = gVar.l();
        if (iL == 2) {
            c cVarD = d(cVar, map);
            if (cVarD != null && (cVarE = e(cVarD, map)) != null) {
                if (cVarE.g() != 1 || cVarE.f(0).f4662b == null) {
                    AbstractC0332s.f("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                } else {
                    String str = (String) U.i(cVarE.f(0).f4662b);
                    g gVarF2 = f(cVarE.f4666f, cVarE.l(), map);
                    int iK = gVarF2 != null ? gVarF2.k() : -1;
                    if (iK == -1 && (gVarF = f(cVarD.f4666f, cVarD.l(), map)) != null) {
                        iK = gVarF.k();
                    }
                    spannable.setSpan(new D0.f(str, iK), i7, i8, 33);
                }
            }
        } else if (iL == 3 || iL == 4) {
            spannable.setSpan(new a(), i7, i8, 33);
        }
        if (gVar.p()) {
            D0.g.b(spannable, new D0.e(), i7, i8, 33);
        }
        int iG = gVar.g();
        if (iG == 1) {
            D0.g.b(spannable, new AbsoluteSizeSpan((int) gVar.f(), true), i7, i8, 33);
        } else if (iG == 2) {
            D0.g.b(spannable, new RelativeSizeSpan(gVar.f()), i7, i8, 33);
        } else {
            if (iG != 3) {
                return;
            }
            D0.g.a(spannable, gVar.f() / 100.0f, i7, i8, 33);
        }
    }

    public static String b(String str) {
        return str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    public static void c(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length < 0 || spannableStringBuilder.charAt(length) == '\n') {
            return;
        }
        spannableStringBuilder.append('\n');
    }

    public static c d(c cVar, Map map) {
        while (cVar != null) {
            g gVarF = f(cVar.f4666f, cVar.l(), map);
            if (gVarF != null && gVarF.l() == 1) {
                return cVar;
            }
            cVar = cVar.f4670j;
        }
        return null;
    }

    public static c e(c cVar, Map map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(cVar);
        while (!arrayDeque.isEmpty()) {
            c cVar2 = (c) arrayDeque.pop();
            g gVarF = f(cVar2.f4666f, cVar2.l(), map);
            if (gVarF != null && gVarF.l() == 3) {
                return cVar2;
            }
            for (int iG = cVar2.g() - 1; iG >= 0; iG--) {
                arrayDeque.push(cVar2.f(iG));
            }
        }
        return null;
    }

    public static g f(g gVar, String[] strArr, Map map) {
        int i7 = 0;
        if (gVar == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return (g) map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                g gVar2 = new g();
                int length = strArr.length;
                while (i7 < length) {
                    gVar2.a((g) map.get(strArr[i7]));
                    i7++;
                }
                return gVar2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                return gVar.a((g) map.get(strArr[0]));
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i7 < length2) {
                    gVar.a((g) map.get(strArr[i7]));
                    i7++;
                }
            }
        }
        return gVar;
    }
}
