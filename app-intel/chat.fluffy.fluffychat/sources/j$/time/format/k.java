package j$.time.format;

import java.text.ParsePosition;

/* loaded from: classes2.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public String f18307a;

    /* renamed from: b, reason: collision with root package name */
    public String f18308b;

    /* renamed from: c, reason: collision with root package name */
    public final char f18309c;

    /* renamed from: d, reason: collision with root package name */
    public k f18310d;

    /* renamed from: e, reason: collision with root package name */
    public k f18311e;

    public boolean b(char c7, char c8) {
        return c7 == c8;
    }

    public k(String str, String str2, k kVar) {
        this.f18307a = str;
        this.f18308b = str2;
        this.f18310d = kVar;
        if (str.isEmpty()) {
            this.f18309c = (char) 65535;
        } else {
            this.f18309c = this.f18307a.charAt(0);
        }
    }

    public final String c(CharSequence charSequence, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        int length = charSequence.length();
        if (!e(charSequence, index, length)) {
            return null;
        }
        int length2 = this.f18307a.length() + index;
        k kVar = this.f18310d;
        if (kVar != null && length2 != length) {
            while (true) {
                if (b(kVar.f18309c, charSequence.charAt(length2))) {
                    parsePosition.setIndex(length2);
                    String strC = kVar.c(charSequence, parsePosition);
                    if (strC != null) {
                        return strC;
                    }
                } else {
                    kVar = kVar.f18311e;
                    if (kVar == null) {
                        break;
                    }
                }
            }
        }
        parsePosition.setIndex(length2);
        return this.f18308b;
    }

    public k d(String str, String str2, k kVar) {
        return new k(str, str2, kVar);
    }

    public boolean e(CharSequence charSequence, int i7, int i8) {
        if (charSequence instanceof String) {
            return ((String) charSequence).startsWith(this.f18307a, i7);
        }
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
            if (!b(this.f18307a.charAt(i9), charSequence.charAt(i7))) {
                return false;
            }
            i7 = i12;
            length = i10;
            i9 = i11;
        }
    }

    public final boolean a(String str, String str2) {
        int i7 = 0;
        while (i7 < str.length() && i7 < this.f18307a.length() && b(str.charAt(i7), this.f18307a.charAt(i7))) {
            i7++;
        }
        if (i7 == this.f18307a.length()) {
            if (i7 < str.length()) {
                String strSubstring = str.substring(i7);
                for (k kVar = this.f18310d; kVar != null; kVar = kVar.f18311e) {
                    if (b(kVar.f18309c, strSubstring.charAt(0))) {
                        return kVar.a(strSubstring, str2);
                    }
                }
                k kVarD = d(strSubstring, str2, null);
                kVarD.f18311e = this.f18310d;
                this.f18310d = kVarD;
                return true;
            }
            this.f18308b = str2;
            return true;
        }
        k kVarD2 = d(this.f18307a.substring(i7), this.f18308b, this.f18310d);
        this.f18307a = str.substring(0, i7);
        this.f18310d = kVarD2;
        if (i7 < str.length()) {
            this.f18310d.f18311e = d(str.substring(i7), str2, null);
            this.f18308b = null;
            return true;
        }
        this.f18308b = str2;
        return true;
    }
}
