package u;

import java.util.Arrays;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f22614a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f22615b;

    public c(int i7, CharSequence charSequence) {
        this.f22614a = i7;
        this.f22615b = charSequence;
    }

    public static String a(CharSequence charSequence) {
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public int b() {
        return this.f22614a;
    }

    public CharSequence c() {
        return this.f22615b;
    }

    public final boolean d(CharSequence charSequence) {
        String strA = a(this.f22615b);
        String strA2 = a(charSequence);
        if (strA == null && strA2 == null) {
            return true;
        }
        return strA != null && strA.equals(strA2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f22614a == cVar.f22614a && d(cVar.f22615b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f22614a), a(this.f22615b)});
    }
}
