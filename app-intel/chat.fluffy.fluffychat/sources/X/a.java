package X;

import android.text.SpannableStringBuilder;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import java.util.Locale;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final m f9184d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f9185e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f9186f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f9187g;

    /* renamed from: h, reason: collision with root package name */
    public static final a f9188h;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f9189a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9190b;

    /* renamed from: c, reason: collision with root package name */
    public final m f9191c;

    /* renamed from: X.a$a, reason: collision with other inner class name */
    public static final class C0076a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f9192a;

        /* renamed from: b, reason: collision with root package name */
        public int f9193b;

        /* renamed from: c, reason: collision with root package name */
        public m f9194c;

        public C0076a() {
            c(a.e(Locale.getDefault()));
        }

        public static a b(boolean z7) {
            return z7 ? a.f9188h : a.f9187g;
        }

        public a a() {
            return (this.f9193b == 2 && this.f9194c == a.f9184d) ? b(this.f9192a) : new a(this.f9192a, this.f9193b, this.f9194c);
        }

        public final void c(boolean z7) {
            this.f9192a = z7;
            this.f9194c = a.f9184d;
            this.f9193b = 2;
        }
    }

    public static class b {

        /* renamed from: f, reason: collision with root package name */
        public static final byte[] f9195f = new byte[1792];

        /* renamed from: a, reason: collision with root package name */
        public final CharSequence f9196a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f9197b;

        /* renamed from: c, reason: collision with root package name */
        public final int f9198c;

        /* renamed from: d, reason: collision with root package name */
        public int f9199d;

        /* renamed from: e, reason: collision with root package name */
        public char f9200e;

        static {
            for (int i7 = 0; i7 < 1792; i7++) {
                f9195f[i7] = Character.getDirectionality(i7);
            }
        }

        public b(CharSequence charSequence, boolean z7) {
            this.f9196a = charSequence;
            this.f9197b = z7;
            this.f9198c = charSequence.length();
        }

        public static byte c(char c7) {
            return c7 < 1792 ? f9195f[c7] : Character.getDirectionality(c7);
        }

        public byte a() {
            char cCharAt = this.f9196a.charAt(this.f9199d - 1);
            this.f9200e = cCharAt;
            if (Character.isLowSurrogate(cCharAt)) {
                int iCodePointBefore = Character.codePointBefore(this.f9196a, this.f9199d);
                this.f9199d -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.f9199d--;
            byte bC = c(this.f9200e);
            if (!this.f9197b) {
                return bC;
            }
            char c7 = this.f9200e;
            return c7 == '>' ? h() : c7 == ';' ? f() : bC;
        }

        public byte b() {
            char cCharAt = this.f9196a.charAt(this.f9199d);
            this.f9200e = cCharAt;
            if (Character.isHighSurrogate(cCharAt)) {
                int iCodePointAt = Character.codePointAt(this.f9196a, this.f9199d);
                this.f9199d += Character.charCount(iCodePointAt);
                return Character.getDirectionality(iCodePointAt);
            }
            this.f9199d++;
            byte bC = c(this.f9200e);
            if (!this.f9197b) {
                return bC;
            }
            char c7 = this.f9200e;
            return c7 == '<' ? i() : c7 == '&' ? g() : bC;
        }

        public int d() {
            this.f9199d = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (this.f9199d < this.f9198c && i7 == 0) {
                byte b7 = b();
                if (b7 != 0) {
                    if (b7 == 1 || b7 == 2) {
                        if (i9 == 0) {
                            return 1;
                        }
                    } else if (b7 != 9) {
                        switch (b7) {
                            case StdKeyDeserializer.TYPE_URL /* 14 */:
                            case StdKeyDeserializer.TYPE_CLASS /* 15 */:
                                i9++;
                                i8 = -1;
                                continue;
                            case 16:
                            case StdKeyDeserializer.TYPE_BYTE_ARRAY /* 17 */:
                                i9++;
                                i8 = 1;
                                continue;
                            case 18:
                                i9--;
                                i8 = 0;
                                continue;
                        }
                    }
                } else if (i9 == 0) {
                    return -1;
                }
                i7 = i9;
            }
            if (i7 == 0) {
                return 0;
            }
            if (i8 != 0) {
                return i8;
            }
            while (this.f9199d > 0) {
                switch (a()) {
                    case StdKeyDeserializer.TYPE_URL /* 14 */:
                    case StdKeyDeserializer.TYPE_CLASS /* 15 */:
                        if (i7 == i9) {
                            return -1;
                        }
                        break;
                    case 16:
                    case StdKeyDeserializer.TYPE_BYTE_ARRAY /* 17 */:
                        if (i7 == i9) {
                            return 1;
                        }
                        break;
                    case 18:
                        i9++;
                        continue;
                }
                i9--;
            }
            return 0;
        }

        public int e() {
            this.f9199d = this.f9198c;
            int i7 = 0;
            while (true) {
                int i8 = i7;
                while (this.f9199d > 0) {
                    byte bA = a();
                    if (bA != 0) {
                        if (bA == 1 || bA == 2) {
                            if (i7 == 0) {
                                return 1;
                            }
                            if (i8 == 0) {
                                break;
                            }
                        } else if (bA != 9) {
                            switch (bA) {
                                case StdKeyDeserializer.TYPE_URL /* 14 */:
                                case StdKeyDeserializer.TYPE_CLASS /* 15 */:
                                    if (i8 == i7) {
                                        return -1;
                                    }
                                    i7--;
                                    break;
                                case 16:
                                case StdKeyDeserializer.TYPE_BYTE_ARRAY /* 17 */:
                                    if (i8 == i7) {
                                        return 1;
                                    }
                                    i7--;
                                    break;
                                case 18:
                                    i7++;
                                    break;
                                default:
                                    if (i8 != 0) {
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } else {
                            continue;
                        }
                    } else {
                        if (i7 == 0) {
                            return -1;
                        }
                        if (i8 == 0) {
                            break;
                        }
                    }
                }
                return 0;
            }
        }

        public final byte f() {
            char cCharAt;
            int i7 = this.f9199d;
            do {
                int i8 = this.f9199d;
                if (i8 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f9196a;
                int i9 = i8 - 1;
                this.f9199d = i9;
                cCharAt = charSequence.charAt(i9);
                this.f9200e = cCharAt;
                if (cCharAt == '&') {
                    return (byte) 12;
                }
            } while (cCharAt != ';');
            this.f9199d = i7;
            this.f9200e = ';';
            return (byte) 13;
        }

        public final byte g() {
            char cCharAt;
            do {
                int i7 = this.f9199d;
                if (i7 >= this.f9198c) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f9196a;
                this.f9199d = i7 + 1;
                cCharAt = charSequence.charAt(i7);
                this.f9200e = cCharAt;
            } while (cCharAt != ';');
            return (byte) 12;
        }

        public final byte h() {
            char cCharAt;
            int i7 = this.f9199d;
            while (true) {
                int i8 = this.f9199d;
                if (i8 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f9196a;
                int i9 = i8 - 1;
                this.f9199d = i9;
                char cCharAt2 = charSequence.charAt(i9);
                this.f9200e = cCharAt2;
                if (cCharAt2 == '<') {
                    return (byte) 12;
                }
                if (cCharAt2 == '>') {
                    break;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i10 = this.f9199d;
                        if (i10 > 0) {
                            CharSequence charSequence2 = this.f9196a;
                            int i11 = i10 - 1;
                            this.f9199d = i11;
                            cCharAt = charSequence2.charAt(i11);
                            this.f9200e = cCharAt;
                        }
                    } while (cCharAt != cCharAt2);
                }
            }
            this.f9199d = i7;
            this.f9200e = '>';
            return (byte) 13;
        }

        public final byte i() {
            char cCharAt;
            int i7 = this.f9199d;
            while (true) {
                int i8 = this.f9199d;
                if (i8 >= this.f9198c) {
                    this.f9199d = i7;
                    this.f9200e = '<';
                    return (byte) 13;
                }
                CharSequence charSequence = this.f9196a;
                this.f9199d = i8 + 1;
                char cCharAt2 = charSequence.charAt(i8);
                this.f9200e = cCharAt2;
                if (cCharAt2 == '>') {
                    return (byte) 12;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i9 = this.f9199d;
                        if (i9 < this.f9198c) {
                            CharSequence charSequence2 = this.f9196a;
                            this.f9199d = i9 + 1;
                            cCharAt = charSequence2.charAt(i9);
                            this.f9200e = cCharAt;
                        }
                    } while (cCharAt != cCharAt2);
                }
            }
        }
    }

    static {
        m mVar = n.f9212c;
        f9184d = mVar;
        f9185e = Character.toString((char) 8206);
        f9186f = Character.toString((char) 8207);
        f9187g = new a(false, 2, mVar);
        f9188h = new a(true, 2, mVar);
    }

    public a(boolean z7, int i7, m mVar) {
        this.f9189a = z7;
        this.f9190b = i7;
        this.f9191c = mVar;
    }

    public static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    public static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new C0076a().a();
    }

    public static boolean e(Locale locale) {
        return o.a(locale) == 1;
    }

    public boolean d() {
        return (this.f9190b & 2) != 0;
    }

    public final String f(CharSequence charSequence, m mVar) {
        boolean zIsRtl = mVar.isRtl(charSequence, 0, charSequence.length());
        return (this.f9189a || !(zIsRtl || b(charSequence) == 1)) ? this.f9189a ? (!zIsRtl || b(charSequence) == -1) ? f9186f : "" : "" : f9185e;
    }

    public final String g(CharSequence charSequence, m mVar) {
        boolean zIsRtl = mVar.isRtl(charSequence, 0, charSequence.length());
        return (this.f9189a || !(zIsRtl || a(charSequence) == 1)) ? this.f9189a ? (!zIsRtl || a(charSequence) == -1) ? f9186f : "" : "" : f9185e;
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f9191c, true);
    }

    public CharSequence i(CharSequence charSequence, m mVar, boolean z7) {
        if (charSequence == null) {
            return null;
        }
        boolean zIsRtl = mVar.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z7) {
            spannableStringBuilder.append((CharSequence) g(charSequence, zIsRtl ? n.f9211b : n.f9210a));
        }
        if (zIsRtl != this.f9189a) {
            spannableStringBuilder.append(zIsRtl ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z7) {
            spannableStringBuilder.append((CharSequence) f(charSequence, zIsRtl ? n.f9211b : n.f9210a));
        }
        return spannableStringBuilder;
    }

    public String j(String str) {
        return k(str, this.f9191c, true);
    }

    public String k(String str, m mVar, boolean z7) {
        if (str == null) {
            return null;
        }
        return i(str, mVar, z7).toString();
    }
}
