package E0;

import android.net.Uri;
import android.text.TextUtils;
import com.fasterxml.jackson.core.JsonPointer;
import j3.AbstractC1229c;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class O {
    public static String a(Uri uri, Uri uri2) {
        if (uri.isOpaque() || uri2.isOpaque()) {
            return uri2.toString();
        }
        String scheme = uri.getScheme();
        String scheme2 = uri2.getScheme();
        if (scheme != null ? !(scheme2 == null || !AbstractC1229c.a(scheme, scheme2)) : scheme2 == null) {
            if (Objects.equals(uri.getAuthority(), uri2.getAuthority())) {
                List<String> pathSegments = uri.getPathSegments();
                List<String> pathSegments2 = uri2.getPathSegments();
                int iMin = Math.min(pathSegments.size(), pathSegments2.size());
                int i7 = 0;
                for (int i8 = 0; i8 < iMin && pathSegments.get(i8).equals(pathSegments2.get(i8)); i8++) {
                    i7++;
                }
                StringBuilder sb = new StringBuilder();
                for (int i9 = i7; i9 < pathSegments.size(); i9++) {
                    sb.append("../");
                }
                while (i7 < pathSegments2.size()) {
                    sb.append(pathSegments2.get(i7));
                    if (i7 < pathSegments2.size() - 1) {
                        sb.append("/");
                    }
                    i7++;
                }
                return sb.toString();
            }
        }
        return uri2.toString();
    }

    public static int[] b(String str) {
        int iIndexOf;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int iIndexOf2 = str.indexOf(35);
        if (iIndexOf2 != -1) {
            length = iIndexOf2;
        }
        int iIndexOf3 = str.indexOf(63);
        if (iIndexOf3 == -1 || iIndexOf3 > length) {
            iIndexOf3 = length;
        }
        int iIndexOf4 = str.indexOf(47);
        if (iIndexOf4 == -1 || iIndexOf4 > iIndexOf3) {
            iIndexOf4 = iIndexOf3;
        }
        int iIndexOf5 = str.indexOf(58);
        if (iIndexOf5 > iIndexOf4) {
            iIndexOf5 = -1;
        }
        int i7 = iIndexOf5 + 2;
        if (i7 < iIndexOf3 && str.charAt(iIndexOf5 + 1) == '/' && str.charAt(i7) == '/') {
            iIndexOf = str.indexOf(47, iIndexOf5 + 3);
            if (iIndexOf == -1 || iIndexOf > iIndexOf3) {
                iIndexOf = iIndexOf3;
            }
        } else {
            iIndexOf = iIndexOf5 + 1;
        }
        iArr[0] = iIndexOf5;
        iArr[1] = iIndexOf;
        iArr[2] = iIndexOf3;
        iArr[3] = length;
        return iArr;
    }

    public static boolean c(String str) {
        return (str == null || b(str)[0] == -1) ? false : true;
    }

    public static String d(StringBuilder sb, int i7, int i8) {
        int i9;
        int iLastIndexOf;
        if (i7 >= i8) {
            return sb.toString();
        }
        if (sb.charAt(i7) == '/') {
            i7++;
        }
        int i10 = i7;
        int i11 = i10;
        while (i10 <= i8) {
            if (i10 == i8) {
                i9 = i10;
            } else if (sb.charAt(i10) == '/') {
                i9 = i10 + 1;
            } else {
                i10++;
            }
            int i12 = i11 + 1;
            if (i10 == i12 && sb.charAt(i11) == '.') {
                sb.delete(i11, i9);
                i8 -= i9 - i11;
            } else {
                if (i10 == i11 + 2 && sb.charAt(i11) == '.' && sb.charAt(i12) == '.') {
                    iLastIndexOf = sb.lastIndexOf("/", i11 - 2) + 1;
                    int i13 = iLastIndexOf > i7 ? iLastIndexOf : i7;
                    sb.delete(i13, i9);
                    i8 -= i9 - i13;
                } else {
                    iLastIndexOf = i10 + 1;
                }
                i11 = iLastIndexOf;
            }
            i10 = i11;
        }
        return sb.toString();
    }

    public static Uri e(Uri uri, String str) {
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        for (String str2 : uri.getQueryParameterNames()) {
            if (!str2.equals(str)) {
                Iterator<String> it = uri.getQueryParameters(str2).iterator();
                while (it.hasNext()) {
                    builderBuildUpon.appendQueryParameter(str2, it.next());
                }
            }
        }
        return builderBuildUpon.build();
    }

    public static String f(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] iArrB = b(str2);
        if (iArrB[0] != -1) {
            sb.append(str2);
            d(sb, iArrB[1], iArrB[2]);
            return sb.toString();
        }
        int[] iArrB2 = b(str);
        if (iArrB[3] == 0) {
            sb.append((CharSequence) str, 0, iArrB2[3]);
            sb.append(str2);
            return sb.toString();
        }
        if (iArrB[2] == 0) {
            sb.append((CharSequence) str, 0, iArrB2[2]);
            sb.append(str2);
            return sb.toString();
        }
        int i7 = iArrB[1];
        if (i7 != 0) {
            int i8 = iArrB2[0] + 1;
            sb.append((CharSequence) str, 0, i8);
            sb.append(str2);
            return d(sb, iArrB[1] + i8, i8 + iArrB[2]);
        }
        if (str2.charAt(i7) == '/') {
            sb.append((CharSequence) str, 0, iArrB2[1]);
            sb.append(str2);
            int i9 = iArrB2[1];
            return d(sb, i9, iArrB[2] + i9);
        }
        int i10 = iArrB2[0] + 2;
        int i11 = iArrB2[1];
        if (i10 >= i11 || i11 != iArrB2[2]) {
            int iLastIndexOf = str.lastIndexOf(47, iArrB2[2] - 1);
            int i12 = iLastIndexOf == -1 ? iArrB2[1] : iLastIndexOf + 1;
            sb.append((CharSequence) str, 0, i12);
            sb.append(str2);
            return d(sb, iArrB2[1], i12 + iArrB[2]);
        }
        sb.append((CharSequence) str, 0, i11);
        sb.append(JsonPointer.SEPARATOR);
        sb.append(str2);
        int i13 = iArrB2[1];
        return d(sb, i13, iArrB[2] + i13 + 1);
    }

    public static Uri g(String str, String str2) {
        return Uri.parse(f(str, str2));
    }
}
