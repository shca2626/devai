package M0;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final List f5620a;

    /* renamed from: b, reason: collision with root package name */
    public final List f5621b;

    /* renamed from: c, reason: collision with root package name */
    public final List f5622c;

    public n(List list, List list2, List list3) {
        this.f5620a = list;
        this.f5621b = list2;
        this.f5622c = list3;
    }

    public static n b(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        c(str, arrayList, arrayList2, arrayList3);
        return new n(arrayList, arrayList2, arrayList3);
    }

    public static void c(String str, List list, List list2, List list3) {
        String strSubstring;
        list.add("");
        int length = 0;
        while (length < str.length()) {
            int iIndexOf = str.indexOf("$", length);
            if (iIndexOf == -1) {
                list.set(list2.size(), ((String) list.get(list2.size())) + str.substring(length));
                length = str.length();
            } else if (iIndexOf != length) {
                list.set(list2.size(), ((String) list.get(list2.size())) + str.substring(length, iIndexOf));
                length = iIndexOf;
            } else if (str.startsWith("$$", length)) {
                list.set(list2.size(), ((String) list.get(list2.size())) + "$");
                length += 2;
            } else {
                list3.add("");
                int i7 = length + 1;
                int iIndexOf2 = str.indexOf("$", i7);
                String strSubstring2 = str.substring(i7, iIndexOf2);
                if (strSubstring2.equals("RepresentationID")) {
                    list2.add(1);
                } else {
                    int iIndexOf3 = strSubstring2.indexOf("%0");
                    if (iIndexOf3 != -1) {
                        strSubstring = strSubstring2.substring(iIndexOf3);
                        if (!strSubstring.endsWith("d") && !strSubstring.endsWith("x") && !strSubstring.endsWith("X")) {
                            strSubstring = strSubstring + "d";
                        }
                        strSubstring2 = strSubstring2.substring(0, iIndexOf3);
                    } else {
                        strSubstring = "%01d";
                    }
                    strSubstring2.getClass();
                    switch (strSubstring2) {
                        case "Number":
                            list2.add(2);
                            break;
                        case "Time":
                            list2.add(4);
                            break;
                        case "Bandwidth":
                            list2.add(3);
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid template: " + str);
                    }
                    list3.set(list2.size() - 1, strSubstring);
                }
                list.add("");
                length = iIndexOf2 + 1;
            }
        }
    }

    public String a(String str, long j7, int i7, long j8) {
        StringBuilder sb = new StringBuilder();
        for (int i8 = 0; i8 < this.f5621b.size(); i8++) {
            sb.append((String) this.f5620a.get(i8));
            if (((Integer) this.f5621b.get(i8)).intValue() == 1) {
                sb.append(str);
            } else if (((Integer) this.f5621b.get(i8)).intValue() == 2) {
                sb.append(String.format(Locale.US, (String) this.f5622c.get(i8), Long.valueOf(j7)));
            } else if (((Integer) this.f5621b.get(i8)).intValue() == 3) {
                sb.append(String.format(Locale.US, (String) this.f5622c.get(i8), Integer.valueOf(i7)));
            } else if (((Integer) this.f5621b.get(i8)).intValue() == 4) {
                sb.append(String.format(Locale.US, (String) this.f5622c.get(i8), Long.valueOf(j8)));
            }
        }
        sb.append((String) this.f5620a.get(this.f5621b.size()));
        return sb.toString();
    }
}
