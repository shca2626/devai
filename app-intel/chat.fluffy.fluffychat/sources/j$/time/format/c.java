package j$.time.format;

/* loaded from: classes2.dex */
public final class c implements e {

    /* renamed from: a, reason: collision with root package name */
    public final char f18288a;

    public c(char c7) {
        this.f18288a = c7;
    }

    @Override // j$.time.format.e
    public final boolean r(s sVar, StringBuilder sb) {
        sb.append(this.f18288a);
        return true;
    }

    @Override // j$.time.format.e
    public final int z(p pVar, CharSequence charSequence, int i7) {
        if (i7 == charSequence.length()) {
            return ~i7;
        }
        char cCharAt = charSequence.charAt(i7);
        char c7 = this.f18288a;
        return (cCharAt == c7 || (!pVar.f18325b && (Character.toUpperCase(cCharAt) == Character.toUpperCase(c7) || Character.toLowerCase(cCharAt) == Character.toLowerCase(c7)))) ? i7 + 1 : ~i7;
    }

    public final String toString() {
        char c7 = this.f18288a;
        if (c7 == '\'') {
            return "''";
        }
        return "'" + c7 + "'";
    }
}
