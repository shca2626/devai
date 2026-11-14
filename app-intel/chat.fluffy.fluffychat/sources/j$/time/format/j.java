package j$.time.format;

/* loaded from: classes2.dex */
public final class j extends k {
    @Override // j$.time.format.k
    public final k d(String str, String str2, k kVar) {
        return new j(str, str2, kVar);
    }

    @Override // j$.time.format.k
    public final boolean b(char c7, char c8) {
        return p.b(c7, c8);
    }

    @Override // j$.time.format.k
    public final boolean e(CharSequence charSequence, int i7, int i8) {
        int length = this.f18307a.length();
        if (length > i8 - i7) {
            return false;
        }
        int i9 = 0;
        while (true) {
            int i10 = length - 1;
            if (length <= 0) {
                return true;
            }
            int i11 = i9 + 1;
            int i12 = i7 + 1;
            if (!p.b(this.f18307a.charAt(i9), charSequence.charAt(i7))) {
                return false;
            }
            i7 = i12;
            length = i10;
            i9 = i11;
        }
    }
}
