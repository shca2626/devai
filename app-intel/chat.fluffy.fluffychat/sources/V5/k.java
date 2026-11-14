package V5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import z5.C1883n;

/* loaded from: classes.dex */
public final class k implements Serializable {

    /* renamed from: m, reason: collision with root package name */
    public static final a f8883m = new a(null);

    /* renamed from: l, reason: collision with root package name */
    public final Pattern f8884l;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final String a(String str) {
            M5.m.e(str, "literal");
            String strQuote = Pattern.quote(str);
            M5.m.d(strQuote, "quote(...)");
            return strQuote;
        }

        public a() {
        }
    }

    public k(Pattern pattern) {
        M5.m.e(pattern, "nativePattern");
        this.f8884l = pattern;
    }

    public final h a(CharSequence charSequence) {
        M5.m.e(charSequence, "input");
        Matcher matcher = this.f8884l.matcher(charSequence);
        M5.m.d(matcher, "matcher(...)");
        return l.c(matcher, charSequence);
    }

    public final boolean b(CharSequence charSequence) {
        M5.m.e(charSequence, "input");
        return this.f8884l.matcher(charSequence).matches();
    }

    public final List c(CharSequence charSequence, int i7) {
        M5.m.e(charSequence, "input");
        y.b0(i7);
        Matcher matcher = this.f8884l.matcher(charSequence);
        if (i7 == 1 || !matcher.find()) {
            return C1883n.d(charSequence.toString());
        }
        ArrayList arrayList = new ArrayList(i7 > 0 ? S5.e.f(i7, 10) : 10);
        int i8 = i7 - 1;
        int iEnd = 0;
        do {
            arrayList.add(charSequence.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
            if (i8 >= 0 && arrayList.size() == i8) {
                break;
            }
        } while (matcher.find());
        arrayList.add(charSequence.subSequence(iEnd, charSequence.length()).toString());
        return arrayList;
    }

    public String toString() {
        String string = this.f8884l.toString();
        M5.m.d(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public k(String str) {
        M5.m.e(str, "pattern");
        Pattern patternCompile = Pattern.compile(str);
        M5.m.d(patternCompile, "compile(...)");
        this(patternCompile);
    }
}
