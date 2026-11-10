package o6;

import java.net.ProtocolException;
import k6.w;

/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final w f20508a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20509b;

    /* renamed from: c, reason: collision with root package name */
    public final String f20510c;

    public k(w wVar, int i7, String str) {
        this.f20508a = wVar;
        this.f20509b = i7;
        this.f20510c = str;
    }

    public static k a(String str) throws ProtocolException, NumberFormatException {
        w wVar;
        int i7;
        String strSubstring;
        if (str.startsWith("HTTP/1.")) {
            i7 = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt == 0) {
                wVar = w.HTTP_1_0;
            } else {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                wVar = w.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            wVar = w.HTTP_1_0;
            i7 = 4;
        }
        int i8 = i7 + 3;
        if (str.length() < i8) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int i9 = Integer.parseInt(str.substring(i7, i8));
            if (str.length() <= i8) {
                strSubstring = "";
            } else {
                if (str.charAt(i8) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                strSubstring = str.substring(i7 + 4);
            }
            return new k(wVar, i9, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f20508a == w.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f20509b);
        if (this.f20510c != null) {
            sb.append(' ');
            sb.append(this.f20510c);
        }
        return sb.toString();
    }
}
