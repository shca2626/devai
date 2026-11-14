package u;

import java.util.Arrays;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f22620a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f22621b;

    public c(int i7, CharSequence charSequence) {
        this.f22620a = i7;
        this.f22621b = charSequence;
    }

    public static String a(CharSequence charSequence) {
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public int b() {
        return this.f22620a;
    }

    public CharSequence c() {
        return this.f22621b;
    }

    public final boolean d(CharSequence charSequence) {
        String strA = a(this.f22621b);
        String strA2 = a(charSequence);
        if (strA == null && strA2 == null) {
            return true;
        }
        return strA != null && strA.equals(strA2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f22620a == cVar.f22620a && d(cVar.f22621b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f22620a), a(this.f22621b)});
    }
}
