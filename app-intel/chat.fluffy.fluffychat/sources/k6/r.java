package k6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final String[] f19396a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final List f19397a = new ArrayList(20);

        public a a(String str, String str2) {
            r.a(str);
            r.b(str2, str);
            return c(str, str2);
        }

        public a b(String str) {
            int iIndexOf = str.indexOf(":", 1);
            return iIndexOf != -1 ? c(str.substring(0, iIndexOf), str.substring(iIndexOf + 1)) : str.startsWith(":") ? c("", str.substring(1)) : c("", str);
        }

        public a c(String str, String str2) {
            this.f19397a.add(str);
            this.f19397a.add(str2.trim());
            return this;
        }

        public r d() {
            return new r(this);
        }

        public String e(String str) {
            for (int size = this.f19397a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase((String) this.f19397a.get(size))) {
                    return (String) this.f19397a.get(size + 1);
                }
            }
            return null;
        }

        public a f(String str) {
            int i7 = 0;
            while (i7 < this.f19397a.size()) {
                if (str.equalsIgnoreCase((String) this.f19397a.get(i7))) {
                    this.f19397a.remove(i7);
                    this.f19397a.remove(i7);
                    i7 -= 2;
                }
                i7 += 2;
            }
            return this;
        }

        public a g(String str, String str2) {
            r.a(str);
            r.b(str2, str);
            f(str);
            c(str, str2);
            return this;
        }
    }

    public r(a aVar) {
        List list = aVar.f19397a;
        this.f19396a = (String[]) list.toArray(new String[list.size()]);
    }

    public static void a(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt = str.charAt(i7);
            if (cCharAt <= ' ' || cCharAt >= 127) {
                throw new IllegalArgumentException(l6.c.p("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i7), str));
            }
        }
    }

    public static void b(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("value for name " + str2 + " == null");
        }
        int length = str.length();
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt = str.charAt(i7);
            if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                throw new IllegalArgumentException(l6.c.p("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt), Integer.valueOf(i7), str2, str));
            }
        }
    }

    public static String d(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public String c(String str) {
        return d(this.f19396a, str);
    }

    public String e(int i7) {
        return this.f19396a[i7 * 2];
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && Arrays.equals(((r) obj).f19396a, this.f19396a);
    }

    public a f() {
        a aVar = new a();
        Collections.addAll(aVar.f19397a, this.f19396a);
        return aVar;
    }

    public int g() {
        return this.f19396a.length / 2;
    }

    public String h(int i7) {
        return this.f19396a[(i7 * 2) + 1];
    }

    public int hashCode() {
        return Arrays.hashCode(this.f19396a);
    }

    public List i(String str) {
        int iG = g();
        ArrayList arrayList = null;
        for (int i7 = 0; i7 < iG; i7++) {
            if (str.equalsIgnoreCase(e(i7))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(h(i7));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.EMPTY_LIST;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iG = g();
        for (int i7 = 0; i7 < iG; i7++) {
            sb.append(e(i7));
            sb.append(": ");
            sb.append(h(i7));
            sb.append("\n");
        }
        return sb.toString();
    }
}
