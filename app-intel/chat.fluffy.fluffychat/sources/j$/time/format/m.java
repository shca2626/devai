package j$.time.format;

/* loaded from: classes2.dex */
public final class m implements e {

    /* renamed from: a, reason: collision with root package name */
    public final String f18305a;

    public m(String str) {
        this.f18305a = str;
    }

    @Override // j$.time.format.e
    public final boolean s(s sVar, StringBuilder sb) {
        sb.append(this.f18305a);
        return true;
    }

    @Override // j$.time.format.e
    public final int A(p pVar, CharSequence charSequence, int i7) {
        if (i7 > charSequence.length() || i7 < 0) {
            throw new IndexOutOfBoundsException();
        }
        String str = this.f18305a;
        return !pVar.g(charSequence, i7, str, 0, str.length()) ? ~i7 : str.length() + i7;
    }

    public final String toString() {
        return "'" + this.f18305a.replace("'", "''") + "'";
    }
}
