package z5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: z5.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1881l extends C1880k {
    public static Object A(Object[] objArr, int i7) {
        M5.m.e(objArr, "<this>");
        if (i7 < 0 || i7 >= objArr.length) {
            return null;
        }
        return objArr[i7];
    }

    public static int B(int[] iArr, int i7) {
        M5.m.e(iArr, "<this>");
        int length = iArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            if (i7 == iArr[i8]) {
                return i8;
            }
        }
        return -1;
    }

    public static int C(Object[] objArr, Object obj) {
        M5.m.e(objArr, "<this>");
        int i7 = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i7 < length) {
                if (objArr[i7] == null) {
                    return i7;
                }
                i7++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i7 < length2) {
            if (M5.m.a(obj, objArr[i7])) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    public static final Appendable D(byte[] bArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, L5.l lVar) throws IOException {
        M5.m.e(bArr, "<this>");
        M5.m.e(appendable, "buffer");
        M5.m.e(charSequence, "separator");
        M5.m.e(charSequence2, "prefix");
        M5.m.e(charSequence3, "postfix");
        M5.m.e(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i8 = 0;
        for (byte b7 : bArr) {
            i8++;
            if (i8 > 1) {
                appendable.append(charSequence);
            }
            if (i7 >= 0 && i8 > i7) {
                break;
            }
            if (lVar != null) {
                appendable.append((CharSequence) lVar.a(Byte.valueOf(b7)));
            } else {
                appendable.append(String.valueOf((int) b7));
            }
        }
        if (i7 >= 0 && i8 > i7) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final String E(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, L5.l lVar) {
        M5.m.e(bArr, "<this>");
        M5.m.e(charSequence, "separator");
        M5.m.e(charSequence2, "prefix");
        M5.m.e(charSequence3, "postfix");
        M5.m.e(charSequence4, "truncated");
        return ((StringBuilder) D(bArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i7, charSequence4, lVar)).toString();
    }

    public static /* synthetic */ String F(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, L5.l lVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i8 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i8 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i8 & 8) != 0) {
            i7 = -1;
        }
        if ((i8 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i8 & 32) != 0) {
            lVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        L5.l lVar2 = lVar;
        return E(bArr, charSequence, charSequence2, charSequence3, i7, charSequence5, lVar2);
    }

    public static char G(char[] cArr) {
        M5.m.e(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static Object H(Object[] objArr) {
        M5.m.e(objArr, "<this>");
        if (objArr.length == 1) {
            return objArr[0];
        }
        return null;
    }

    public static List I(float[] fArr, S5.c cVar) {
        M5.m.e(fArr, "<this>");
        M5.m.e(cVar, "indices");
        return cVar.isEmpty() ? C1884o.i() : C1880k.c(C1880k.m(fArr, cVar.l().intValue(), cVar.k().intValue() + 1));
    }

    public static float J(float[] fArr) {
        M5.m.e(fArr, "<this>");
        float f7 = 0.0f;
        for (float f8 : fArr) {
            f7 += f8;
        }
        return f7;
    }

    public static List K(short[] sArr, int i7) {
        M5.m.e(sArr, "<this>");
        if (i7 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return C1884o.i();
        }
        if (i7 >= sArr.length) {
            return P(sArr);
        }
        if (i7 == 1) {
            return C1883n.d(Short.valueOf(sArr[0]));
        }
        ArrayList arrayList = new ArrayList(i7);
        int i8 = 0;
        for (short s7 : sArr) {
            arrayList.add(Short.valueOf(s7));
            i8++;
            if (i8 == i7) {
                break;
            }
        }
        return arrayList;
    }

    public static final List L(Object[] objArr, int i7) {
        M5.m.e(objArr, "<this>");
        if (i7 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return C1884o.i();
        }
        int length = objArr.length;
        if (i7 >= length) {
            return O(objArr);
        }
        if (i7 == 1) {
            return C1883n.d(objArr[length - 1]);
        }
        ArrayList arrayList = new ArrayList(i7);
        for (int i8 = length - i7; i8 < length; i8++) {
            arrayList.add(objArr[i8]);
        }
        return arrayList;
    }

    public static final Collection M(Object[] objArr, Collection collection) {
        M5.m.e(objArr, "<this>");
        M5.m.e(collection, "destination");
        for (Object obj : objArr) {
            collection.add(obj);
        }
        return collection;
    }

    public static List N(int[] iArr) {
        M5.m.e(iArr, "<this>");
        int length = iArr.length;
        return length != 0 ? length != 1 ? Q(iArr) : C1883n.d(Integer.valueOf(iArr[0])) : C1884o.i();
    }

    public static List O(Object[] objArr) {
        M5.m.e(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? R(objArr) : C1883n.d(objArr[0]) : C1884o.i();
    }

    public static final List P(short[] sArr) {
        M5.m.e(sArr, "<this>");
        int length = sArr.length;
        return length != 0 ? length != 1 ? S(sArr) : C1883n.d(Short.valueOf(sArr[0])) : C1884o.i();
    }

    public static final List Q(int[] iArr) {
        M5.m.e(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i7 : iArr) {
            arrayList.add(Integer.valueOf(i7));
        }
        return arrayList;
    }

    public static List R(Object[] objArr) {
        M5.m.e(objArr, "<this>");
        return new ArrayList(C1884o.h(objArr, false, 1, null));
    }

    public static final List S(short[] sArr) {
        M5.m.e(sArr, "<this>");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s7 : sArr) {
            arrayList.add(Short.valueOf(s7));
        }
        return arrayList;
    }

    public static final Set T(Object[] objArr) {
        M5.m.e(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? (Set) M(objArr, new LinkedHashSet(C1865F.e(objArr.length))) : C1867H.c(objArr[0]) : C1868I.d();
    }

    public static boolean q(Object[] objArr, Object obj) {
        M5.m.e(objArr, "<this>");
        return C(objArr, obj) >= 0;
    }

    public static List r(Object[] objArr, int i7) {
        M5.m.e(objArr, "<this>");
        if (i7 >= 0) {
            return L(objArr, S5.e.b(objArr.length - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    public static List s(Object[] objArr) {
        M5.m.e(objArr, "<this>");
        return (List) t(objArr, new ArrayList());
    }

    public static final Collection t(Object[] objArr, Collection collection) {
        M5.m.e(objArr, "<this>");
        M5.m.e(collection, "destination");
        for (Object obj : objArr) {
            if (obj != null) {
                collection.add(obj);
            }
        }
        return collection;
    }

    public static Object u(Object[] objArr) {
        M5.m.e(objArr, "<this>");
        if (objArr.length != 0) {
            return objArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static Integer v(int[] iArr) {
        M5.m.e(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[0]);
    }

    public static S5.c w(int[] iArr) {
        M5.m.e(iArr, "<this>");
        return new S5.c(0, y(iArr));
    }

    public static S5.c x(Object[] objArr) {
        M5.m.e(objArr, "<this>");
        return new S5.c(0, z(objArr));
    }

    public static final int y(int[] iArr) {
        M5.m.e(iArr, "<this>");
        return iArr.length - 1;
    }

    public static final int z(Object[] objArr) {
        M5.m.e(objArr, "<this>");
        return objArr.length - 1;
    }
}
