package V5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import y5.AbstractC1816l;
import y5.C1812h;
import z5.C1880k;
import z5.C1881l;
import z5.C1883n;
import z5.C1885p;
import z5.C1892w;

/* loaded from: classes.dex */
public class y extends w {

    public static final class a implements U5.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f8888a;

        public a(CharSequence charSequence) {
            this.f8888a = charSequence;
        }

        @Override // U5.d
        public Iterator iterator() {
            return new e(this.f8888a);
        }
    }

    public static boolean A(CharSequence charSequence, CharSequence charSequence2, boolean z7) {
        M5.m.e(charSequence, "<this>");
        M5.m.e(charSequence2, "other");
        return charSequence2 instanceof String ? L(charSequence, (String) charSequence2, 0, z7, 2, null) >= 0 : J(charSequence, charSequence2, 0, charSequence.length(), z7, false, 16, null) >= 0;
    }

    public static /* synthetic */ boolean B(CharSequence charSequence, CharSequence charSequence2, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return A(charSequence, charSequence2, z7);
    }

    public static final boolean C(CharSequence charSequence, CharSequence charSequence2, boolean z7) {
        M5.m.e(charSequence, "<this>");
        M5.m.e(charSequence2, "suffix");
        return (!z7 && (charSequence instanceof String) && (charSequence2 instanceof String)) ? w.s((String) charSequence, (String) charSequence2, false, 2, null) : Y(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z7);
    }

    public static /* synthetic */ boolean D(CharSequence charSequence, CharSequence charSequence2, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return C(charSequence, charSequence2, z7);
    }

    public static final C1812h E(CharSequence charSequence, Collection collection, int i7, boolean z7, boolean z8) {
        CharSequence charSequence2;
        Object next;
        boolean z9;
        Object next2;
        if (!z7 && collection.size() == 1) {
            String str = (String) C1892w.R(collection);
            int iL = !z8 ? L(charSequence, str, i7, false, 4, null) : R(charSequence, str, i7, false, 4, null);
            if (iL < 0) {
                return null;
            }
            return AbstractC1816l.a(Integer.valueOf(iL), str);
        }
        CharSequence charSequence3 = charSequence;
        S5.a cVar = !z8 ? new S5.c(S5.e.b(i7, 0), charSequence3.length()) : S5.e.l(S5.e.f(i7, F(charSequence3)), 0);
        if (charSequence3 instanceof String) {
            int iF = cVar.f();
            int iG = cVar.g();
            int iH = cVar.h();
            if ((iH > 0 && iF <= iG) || (iH < 0 && iG <= iF)) {
                int i8 = iF;
                while (true) {
                    Iterator it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z9 = z7;
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        String str2 = (String) next2;
                        z9 = z7;
                        if (w.u(str2, 0, (String) charSequence3, i8, str2.length(), z9)) {
                            break;
                        }
                        z7 = z9;
                    }
                    String str3 = (String) next2;
                    if (str3 == null) {
                        if (i8 == iG) {
                            break;
                        }
                        i8 += iH;
                        z7 = z9;
                    } else {
                        return AbstractC1816l.a(Integer.valueOf(i8), str3);
                    }
                }
            }
        } else {
            boolean z10 = z7;
            int iF2 = cVar.f();
            int iG2 = cVar.g();
            int iH2 = cVar.h();
            if ((iH2 > 0 && iF2 <= iG2) || (iH2 < 0 && iG2 <= iF2)) {
                int i9 = iF2;
                while (true) {
                    Iterator it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            charSequence2 = charSequence3;
                            next = null;
                            break;
                        }
                        next = it2.next();
                        String str4 = (String) next;
                        boolean z11 = z10;
                        charSequence2 = charSequence3;
                        z10 = z11;
                        if (Y(str4, 0, charSequence2, i9, str4.length(), z11)) {
                            break;
                        }
                        charSequence3 = charSequence2;
                    }
                    String str5 = (String) next;
                    if (str5 == null) {
                        if (i9 == iG2) {
                            break;
                        }
                        i9 += iH2;
                        charSequence3 = charSequence2;
                    } else {
                        return AbstractC1816l.a(Integer.valueOf(i9), str5);
                    }
                }
            }
        }
        return null;
    }

    public static final int F(CharSequence charSequence) {
        M5.m.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int G(CharSequence charSequence, char c7, int i7, boolean z7) {
        M5.m.e(charSequence, "<this>");
        return (z7 || !(charSequence instanceof String)) ? M(charSequence, new char[]{c7}, i7, z7) : ((String) charSequence).indexOf(c7, i7);
    }

    public static final int H(CharSequence charSequence, String str, int i7, boolean z7) {
        M5.m.e(charSequence, "<this>");
        M5.m.e(str, "string");
        return (z7 || !(charSequence instanceof String)) ? J(charSequence, str, i7, charSequence.length(), z7, false, 16, null) : ((String) charSequence).indexOf(str, i7);
    }

    public static final int I(CharSequence charSequence, CharSequence charSequence2, int i7, int i8, boolean z7, boolean z8) {
        S5.a cVar = !z8 ? new S5.c(S5.e.b(i7, 0), S5.e.f(i8, charSequence.length())) : S5.e.l(S5.e.f(i7, F(charSequence)), S5.e.b(i8, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iF = cVar.f();
            int iG = cVar.g();
            int iH = cVar.h();
            if ((iH <= 0 || iF > iG) && (iH >= 0 || iG > iF)) {
                return -1;
            }
            int i9 = iF;
            while (true) {
                String str = (String) charSequence2;
                boolean z9 = z7;
                if (w.u(str, 0, (String) charSequence, i9, str.length(), z9)) {
                    return i9;
                }
                if (i9 == iG) {
                    return -1;
                }
                i9 += iH;
                z7 = z9;
            }
        } else {
            boolean z10 = z7;
            int iF2 = cVar.f();
            int iG2 = cVar.g();
            int iH2 = cVar.h();
            if ((iH2 <= 0 || iF2 > iG2) && (iH2 >= 0 || iG2 > iF2)) {
                return -1;
            }
            int i10 = iF2;
            while (true) {
                boolean z11 = z10;
                CharSequence charSequence3 = charSequence;
                CharSequence charSequence4 = charSequence2;
                z10 = z11;
                if (Y(charSequence4, 0, charSequence3, i10, charSequence2.length(), z11)) {
                    return i10;
                }
                if (i10 == iG2) {
                    return -1;
                }
                i10 += iH2;
                charSequence2 = charSequence4;
                charSequence = charSequence3;
            }
        }
    }

    public static /* synthetic */ int J(CharSequence charSequence, CharSequence charSequence2, int i7, int i8, boolean z7, boolean z8, int i9, Object obj) {
        if ((i9 & 16) != 0) {
            z8 = false;
        }
        return I(charSequence, charSequence2, i7, i8, z7, z8);
    }

    public static /* synthetic */ int K(CharSequence charSequence, char c7, int i7, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return G(charSequence, c7, i7, z7);
    }

    public static /* synthetic */ int L(CharSequence charSequence, String str, int i7, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return H(charSequence, str, i7, z7);
    }

    public static final int M(CharSequence charSequence, char[] cArr, int i7, boolean z7) {
        M5.m.e(charSequence, "<this>");
        M5.m.e(cArr, "chars");
        if (!z7 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(C1881l.G(cArr), i7);
        }
        int iB = S5.e.b(i7, 0);
        int iF = F(charSequence);
        if (iB > iF) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iB);
            for (char c7 : cArr) {
                if (b.d(c7, cCharAt, z7)) {
                    return iB;
                }
            }
            if (iB == iF) {
                return -1;
            }
            iB++;
        }
    }

    public static boolean N(CharSequence charSequence) {
        M5.m.e(charSequence, "<this>");
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            if (!C0608a.c(charSequence.charAt(i7))) {
                return false;
            }
        }
        return true;
    }

    public static final int O(CharSequence charSequence, char c7, int i7, boolean z7) {
        M5.m.e(charSequence, "<this>");
        return (z7 || !(charSequence instanceof String)) ? S(charSequence, new char[]{c7}, i7, z7) : ((String) charSequence).lastIndexOf(c7, i7);
    }

    public static final int P(CharSequence charSequence, String str, int i7, boolean z7) {
        M5.m.e(charSequence, "<this>");
        M5.m.e(str, "string");
        return (z7 || !(charSequence instanceof String)) ? I(charSequence, str, i7, 0, z7, true) : ((String) charSequence).lastIndexOf(str, i7);
    }

    public static /* synthetic */ int Q(CharSequence charSequence, char c7, int i7, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = F(charSequence);
        }
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return O(charSequence, c7, i7, z7);
    }

    public static /* synthetic */ int R(CharSequence charSequence, String str, int i7, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = F(charSequence);
        }
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return P(charSequence, str, i7, z7);
    }

    public static final int S(CharSequence charSequence, char[] cArr, int i7, boolean z7) {
        M5.m.e(charSequence, "<this>");
        M5.m.e(cArr, "chars");
        if (!z7 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(C1881l.G(cArr), i7);
        }
        for (int iF = S5.e.f(i7, F(charSequence)); -1 < iF; iF--) {
            char cCharAt = charSequence.charAt(iF);
            for (char c7 : cArr) {
                if (b.d(c7, cCharAt, z7)) {
                    return iF;
                }
            }
        }
        return -1;
    }

    public static final U5.d T(CharSequence charSequence) {
        M5.m.e(charSequence, "<this>");
        return new a(charSequence);
    }

    public static final List U(CharSequence charSequence) {
        M5.m.e(charSequence, "<this>");
        return U5.k.m(T(charSequence));
    }

    public static final U5.d V(CharSequence charSequence, String[] strArr, int i7, final boolean z7, int i8) {
        b0(i8);
        final List listD = C1880k.d(strArr);
        return new d(charSequence, i7, i8, new L5.p() { // from class: V5.x
            @Override // L5.p
            public final Object n(Object obj, Object obj2) {
                return y.X(listD, z7, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    public static /* synthetic */ U5.d W(CharSequence charSequence, String[] strArr, int i7, boolean z7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            z7 = false;
        }
        if ((i9 & 8) != 0) {
            i8 = 0;
        }
        return V(charSequence, strArr, i7, z7, i8);
    }

    public static final C1812h X(List list, boolean z7, CharSequence charSequence, int i7) {
        M5.m.e(charSequence, "$this$DelimitedRangesSequence");
        C1812h c1812hE = E(charSequence, list, i7, z7, false);
        if (c1812hE != null) {
            return AbstractC1816l.a(c1812hE.c(), Integer.valueOf(((String) c1812hE.d()).length()));
        }
        return null;
    }

    public static final boolean Y(CharSequence charSequence, int i7, CharSequence charSequence2, int i8, int i9, boolean z7) {
        M5.m.e(charSequence, "<this>");
        M5.m.e(charSequence2, "other");
        if (i8 < 0 || i7 < 0 || i7 > charSequence.length() - i9 || i8 > charSequence2.length() - i9) {
            return false;
        }
        for (int i10 = 0; i10 < i9; i10++) {
            if (!b.d(charSequence.charAt(i7 + i10), charSequence2.charAt(i8 + i10), z7)) {
                return false;
            }
        }
        return true;
    }

    public static String Z(String str, CharSequence charSequence) {
        M5.m.e(str, "<this>");
        M5.m.e(charSequence, "prefix");
        if (!g0(str, charSequence, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(charSequence.length());
        M5.m.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String a0(String str, CharSequence charSequence) {
        M5.m.e(str, "<this>");
        M5.m.e(charSequence, "suffix");
        if (!D(str, charSequence, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - charSequence.length());
        M5.m.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final void b0(int i7) {
        if (i7 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i7).toString());
    }

    public static final List c0(CharSequence charSequence, String[] strArr, boolean z7, int i7) {
        M5.m.e(charSequence, "<this>");
        M5.m.e(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                return d0(charSequence, str, z7, i7);
            }
        }
        Iterable iterableG = U5.k.g(W(charSequence, strArr, 0, z7, i7, 2, null));
        ArrayList arrayList = new ArrayList(C1885p.o(iterableG, 10));
        Iterator it = iterableG.iterator();
        while (it.hasNext()) {
            arrayList.add(h0(charSequence, (S5.c) it.next()));
        }
        return arrayList;
    }

    public static final List d0(CharSequence charSequence, String str, boolean z7, int i7) {
        b0(i7);
        int length = 0;
        int iH = H(charSequence, str, 0, z7);
        if (iH == -1 || i7 == 1) {
            return C1883n.d(charSequence.toString());
        }
        boolean z8 = i7 > 0;
        ArrayList arrayList = new ArrayList(z8 ? S5.e.f(i7, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iH).toString());
            length = str.length() + iH;
            if (z8 && arrayList.size() == i7 - 1) {
                break;
            }
            iH = H(charSequence, str, length, z7);
        } while (iH != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List e0(CharSequence charSequence, String[] strArr, boolean z7, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        if ((i8 & 4) != 0) {
            i7 = 0;
        }
        return c0(charSequence, strArr, z7, i7);
    }

    public static final boolean f0(CharSequence charSequence, CharSequence charSequence2, boolean z7) {
        M5.m.e(charSequence, "<this>");
        M5.m.e(charSequence2, "prefix");
        return (!z7 && (charSequence instanceof String) && (charSequence2 instanceof String)) ? w.y((String) charSequence, (String) charSequence2, false, 2, null) : Y(charSequence, 0, charSequence2, 0, charSequence2.length(), z7);
    }

    public static /* synthetic */ boolean g0(CharSequence charSequence, CharSequence charSequence2, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return f0(charSequence, charSequence2, z7);
    }

    public static final String h0(CharSequence charSequence, S5.c cVar) {
        M5.m.e(charSequence, "<this>");
        M5.m.e(cVar, "range");
        return charSequence.subSequence(cVar.l().intValue(), cVar.k().intValue() + 1).toString();
    }

    public static final String i0(String str, char c7, String str2) {
        M5.m.e(str, "<this>");
        M5.m.e(str2, "missingDelimiterValue");
        int iK = K(str, c7, 0, false, 6, null);
        if (iK == -1) {
            return str2;
        }
        String strSubstring = str.substring(iK + 1, str.length());
        M5.m.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String j0(String str, String str2, String str3) {
        M5.m.e(str, "<this>");
        M5.m.e(str2, "delimiter");
        M5.m.e(str3, "missingDelimiterValue");
        int iL = L(str, str2, 0, false, 6, null);
        if (iL == -1) {
            return str3;
        }
        String strSubstring = str.substring(iL + str2.length(), str.length());
        M5.m.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String k0(String str, char c7, String str2, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            str2 = str;
        }
        return i0(str, c7, str2);
    }

    public static /* synthetic */ String l0(String str, String str2, String str3, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            str3 = str;
        }
        return j0(str, str2, str3);
    }

    public static String m0(String str, char c7, String str2) {
        M5.m.e(str, "<this>");
        M5.m.e(str2, "missingDelimiterValue");
        int iQ = Q(str, c7, 0, false, 6, null);
        if (iQ == -1) {
            return str2;
        }
        String strSubstring = str.substring(iQ + 1, str.length());
        M5.m.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String n0(String str, char c7, String str2, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            str2 = str;
        }
        return m0(str, c7, str2);
    }

    public static final String o0(String str, char c7, String str2) {
        M5.m.e(str, "<this>");
        M5.m.e(str2, "missingDelimiterValue");
        int iK = K(str, c7, 0, false, 6, null);
        if (iK == -1) {
            return str2;
        }
        String strSubstring = str.substring(0, iK);
        M5.m.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String p0(String str, String str2, String str3) {
        M5.m.e(str, "<this>");
        M5.m.e(str2, "delimiter");
        M5.m.e(str3, "missingDelimiterValue");
        int iL = L(str, str2, 0, false, 6, null);
        if (iL == -1) {
            return str3;
        }
        String strSubstring = str.substring(0, iL);
        M5.m.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String q0(String str, char c7, String str2, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            str2 = str;
        }
        return o0(str, c7, str2);
    }

    public static /* synthetic */ String r0(String str, String str2, String str3, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            str3 = str;
        }
        return p0(str, str2, str3);
    }

    public static final String s0(String str, char c7, String str2) {
        M5.m.e(str, "<this>");
        M5.m.e(str2, "missingDelimiterValue");
        int iQ = Q(str, c7, 0, false, 6, null);
        if (iQ == -1) {
            return str2;
        }
        String strSubstring = str.substring(0, iQ);
        M5.m.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String t0(String str, char c7, String str2, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            str2 = str;
        }
        return s0(str, c7, str2);
    }

    public static CharSequence u0(CharSequence charSequence) {
        M5.m.e(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i7 = 0;
        boolean z7 = false;
        while (i7 <= length) {
            boolean zC = C0608a.c(charSequence.charAt(!z7 ? i7 : length));
            if (z7) {
                if (!zC) {
                    break;
                }
                length--;
            } else if (zC) {
                i7++;
            } else {
                z7 = true;
            }
        }
        return charSequence.subSequence(i7, length + 1);
    }
}
