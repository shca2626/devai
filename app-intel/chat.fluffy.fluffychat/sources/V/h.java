package V;

import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    public static final h f8487b = a(new Locale[0]);

    /* renamed from: a, reason: collision with root package name */
    public final i f8488a;

    public static class a {
        public static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }
    }

    public h(i iVar) {
        this.f8488a = iVar;
    }

    public static h a(Locale... localeArr) {
        return h(a.a(localeArr));
    }

    public static h b(String str) {
        if (str == null || str.isEmpty()) {
            return d();
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i7 = 0; i7 < length; i7++) {
            localeArr[i7] = Locale.forLanguageTag(strArrSplit[i7]);
        }
        return a(localeArr);
    }

    public static h d() {
        return f8487b;
    }

    public static h h(LocaleList localeList) {
        return new h(new j(localeList));
    }

    public Locale c(int i7) {
        return this.f8488a.get(i7);
    }

    public boolean e() {
        return this.f8488a.isEmpty();
    }

    public boolean equals(Object obj) {
        return (obj instanceof h) && this.f8488a.equals(((h) obj).f8488a);
    }

    public int f() {
        return this.f8488a.size();
    }

    public String g() {
        return this.f8488a.a();
    }

    public int hashCode() {
        return this.f8488a.hashCode();
    }

    public String toString() {
        return this.f8488a.toString();
    }
}
