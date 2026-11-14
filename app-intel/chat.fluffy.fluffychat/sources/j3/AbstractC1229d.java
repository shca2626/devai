package j3;

import java.util.Arrays;

/* renamed from: j3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1229d implements p {

    /* renamed from: j3.d$a */
    public static final class a extends AbstractC1229d {

        /* renamed from: l, reason: collision with root package name */
        public final AbstractC1229d f18703l;

        /* renamed from: m, reason: collision with root package name */
        public final AbstractC1229d f18704m;

        public a(AbstractC1229d abstractC1229d, AbstractC1229d abstractC1229d2) {
            this.f18703l = (AbstractC1229d) o.q(abstractC1229d);
            this.f18704m = (AbstractC1229d) o.q(abstractC1229d2);
        }

        @Override // j3.p
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.e((Character) obj);
        }

        @Override // j3.AbstractC1229d
        public boolean m(char c7) {
            return this.f18703l.m(c7) && this.f18704m.m(c7);
        }

        public String toString() {
            return "CharMatcher.and(" + this.f18703l + ", " + this.f18704m + ")";
        }
    }

    /* renamed from: j3.d$b */
    public static final class b extends j {

        /* renamed from: m, reason: collision with root package name */
        public static final AbstractC1229d f18705m = new b();

        public b() {
            super("CharMatcher.any()");
        }

        @Override // j3.AbstractC1229d
        public AbstractC1229d b(AbstractC1229d abstractC1229d) {
            return (AbstractC1229d) o.q(abstractC1229d);
        }

        @Override // j3.AbstractC1229d
        public int g(CharSequence charSequence) {
            return charSequence.length() == 0 ? -1 : 0;
        }

        @Override // j3.AbstractC1229d
        public int h(CharSequence charSequence, int i7) {
            int length = charSequence.length();
            o.s(i7, length);
            if (i7 == length) {
                return -1;
            }
            return i7;
        }

        @Override // j3.AbstractC1229d
        public boolean m(char c7) {
            return true;
        }

        @Override // j3.AbstractC1229d
        public boolean n(CharSequence charSequence) {
            o.q(charSequence);
            return true;
        }

        @Override // j3.AbstractC1229d
        public boolean o(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // j3.AbstractC1229d.e, j3.AbstractC1229d
        public AbstractC1229d p() {
            return AbstractC1229d.q();
        }
    }

    /* renamed from: j3.d$c */
    public static final class c extends AbstractC1229d {

        /* renamed from: l, reason: collision with root package name */
        public final char[] f18706l;

        public c(CharSequence charSequence) {
            char[] charArray = charSequence.toString().toCharArray();
            this.f18706l = charArray;
            Arrays.sort(charArray);
        }

        @Override // j3.p
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.e((Character) obj);
        }

        @Override // j3.AbstractC1229d
        public boolean m(char c7) {
            return Arrays.binarySearch(this.f18706l, c7) >= 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("CharMatcher.anyOf(\"");
            for (char c7 : this.f18706l) {
                sb.append(AbstractC1229d.s(c7));
            }
            sb.append("\")");
            return sb.toString();
        }
    }

    /* renamed from: j3.d$d, reason: collision with other inner class name */
    public static final class C0208d extends j {

        /* renamed from: m, reason: collision with root package name */
        public static final AbstractC1229d f18707m = new C0208d();

        public C0208d() {
            super("CharMatcher.ascii()");
        }

        @Override // j3.AbstractC1229d
        public boolean m(char c7) {
            return c7 <= 127;
        }
    }

    /* renamed from: j3.d$e */
    public static abstract class e extends AbstractC1229d {
        @Override // j3.p
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.e((Character) obj);
        }

        @Override // j3.AbstractC1229d
        public AbstractC1229d p() {
            return new l(this);
        }
    }

    /* renamed from: j3.d$f */
    public static final class f extends e {

        /* renamed from: l, reason: collision with root package name */
        public final char f18708l;

        public f(char c7) {
            this.f18708l = c7;
        }

        @Override // j3.AbstractC1229d
        public AbstractC1229d b(AbstractC1229d abstractC1229d) {
            return abstractC1229d.m(this.f18708l) ? this : AbstractC1229d.q();
        }

        @Override // j3.AbstractC1229d
        public boolean m(char c7) {
            return c7 == this.f18708l;
        }

        @Override // j3.AbstractC1229d.e, j3.AbstractC1229d
        public AbstractC1229d p() {
            return AbstractC1229d.k(this.f18708l);
        }

        public String toString() {
            return "CharMatcher.is('" + AbstractC1229d.s(this.f18708l) + "')";
        }
    }

    /* renamed from: j3.d$g */
    public static final class g extends e {

        /* renamed from: l, reason: collision with root package name */
        public final char f18709l;

        /* renamed from: m, reason: collision with root package name */
        public final char f18710m;

        public g(char c7, char c8) {
            this.f18709l = c7;
            this.f18710m = c8;
        }

        @Override // j3.AbstractC1229d
        public boolean m(char c7) {
            return c7 == this.f18709l || c7 == this.f18710m;
        }

        public String toString() {
            return "CharMatcher.anyOf(\"" + AbstractC1229d.s(this.f18709l) + AbstractC1229d.s(this.f18710m) + "\")";
        }
    }

    /* renamed from: j3.d$h */
    public static final class h extends e {

        /* renamed from: l, reason: collision with root package name */
        public final char f18711l;

        public h(char c7) {
            this.f18711l = c7;
        }

        @Override // j3.AbstractC1229d
        public AbstractC1229d b(AbstractC1229d abstractC1229d) {
            return abstractC1229d.m(this.f18711l) ? super.b(abstractC1229d) : abstractC1229d;
        }

        @Override // j3.AbstractC1229d
        public boolean m(char c7) {
            return c7 != this.f18711l;
        }

        @Override // j3.AbstractC1229d.e, j3.AbstractC1229d
        public AbstractC1229d p() {
            return AbstractC1229d.i(this.f18711l);
        }

        public String toString() {
            return "CharMatcher.isNot('" + AbstractC1229d.s(this.f18711l) + "')";
        }
    }

    /* renamed from: j3.d$i */
    public static final class i extends j {

        /* renamed from: m, reason: collision with root package name */
        public static final AbstractC1229d f18712m = new i();

        public i() {
            super("CharMatcher.javaIsoControl()");
        }

        @Override // j3.AbstractC1229d
        public boolean m(char c7) {
            if (c7 > 31) {
                return c7 >= 127 && c7 <= 159;
            }
            return true;
        }
    }

    /* renamed from: j3.d$j */
    public static abstract class j extends e {

        /* renamed from: l, reason: collision with root package name */
        public final String f18713l;

        public j(String str) {
            this.f18713l = (String) o.q(str);
        }

        public final String toString() {
            return this.f18713l;
        }
    }

    /* renamed from: j3.d$k */
    public static class k extends AbstractC1229d {

        /* renamed from: l, reason: collision with root package name */
        public final AbstractC1229d f18714l;

        public k(AbstractC1229d abstractC1229d) {
            this.f18714l = (AbstractC1229d) o.q(abstractC1229d);
        }

        @Override // j3.p
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.e((Character) obj);
        }

        @Override // j3.AbstractC1229d
        public boolean m(char c7) {
            return !this.f18714l.m(c7);
        }

        @Override // j3.AbstractC1229d
        public boolean n(CharSequence charSequence) {
            return this.f18714l.o(charSequence);
        }

        @Override // j3.AbstractC1229d
        public boolean o(CharSequence charSequence) {
            return this.f18714l.n(charSequence);
        }

        @Override // j3.AbstractC1229d
        public AbstractC1229d p() {
            return this.f18714l;
        }

        public String toString() {
            return this.f18714l + ".negate()";
        }
    }

    /* renamed from: j3.d$l */
    public static class l extends k {
        public l(AbstractC1229d abstractC1229d) {
            super(abstractC1229d);
        }
    }

    /* renamed from: j3.d$m */
    public static final class m extends j {

        /* renamed from: m, reason: collision with root package name */
        public static final AbstractC1229d f18715m = new m();

        public m() {
            super("CharMatcher.none()");
        }

        @Override // j3.AbstractC1229d
        public AbstractC1229d b(AbstractC1229d abstractC1229d) {
            o.q(abstractC1229d);
            return this;
        }

        @Override // j3.AbstractC1229d
        public int g(CharSequence charSequence) {
            o.q(charSequence);
            return -1;
        }

        @Override // j3.AbstractC1229d
        public int h(CharSequence charSequence, int i7) {
            o.s(i7, charSequence.length());
            return -1;
        }

        @Override // j3.AbstractC1229d
        public boolean m(char c7) {
            return false;
        }

        @Override // j3.AbstractC1229d
        public boolean n(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // j3.AbstractC1229d
        public boolean o(CharSequence charSequence) {
            o.q(charSequence);
            return true;
        }

        @Override // j3.AbstractC1229d.e, j3.AbstractC1229d
        public AbstractC1229d p() {
            return AbstractC1229d.c();
        }
    }

    public static AbstractC1229d c() {
        return b.f18705m;
    }

    public static AbstractC1229d d(CharSequence charSequence) {
        int length = charSequence.length();
        return length != 0 ? length != 1 ? length != 2 ? new c(charSequence) : j(charSequence.charAt(0), charSequence.charAt(1)) : i(charSequence.charAt(0)) : q();
    }

    public static AbstractC1229d f() {
        return C0208d.f18707m;
    }

    public static AbstractC1229d i(char c7) {
        return new f(c7);
    }

    public static g j(char c7, char c8) {
        return new g(c7, c8);
    }

    public static AbstractC1229d k(char c7) {
        return new h(c7);
    }

    public static AbstractC1229d l() {
        return i.f18712m;
    }

    public static AbstractC1229d q() {
        return m.f18715m;
    }

    public static AbstractC1229d r(CharSequence charSequence) {
        return d(charSequence).p();
    }

    public static String s(char c7) {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        for (int i7 = 0; i7 < 4; i7++) {
            cArr[5 - i7] = "0123456789ABCDEF".charAt(c7 & 15);
            c7 = (char) (c7 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public AbstractC1229d b(AbstractC1229d abstractC1229d) {
        return new a(this, abstractC1229d);
    }

    public boolean e(Character ch) {
        return m(ch.charValue());
    }

    public int g(CharSequence charSequence) {
        return h(charSequence, 0);
    }

    public int h(CharSequence charSequence, int i7) {
        int length = charSequence.length();
        o.s(i7, length);
        while (i7 < length) {
            if (m(charSequence.charAt(i7))) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    public abstract boolean m(char c7);

    public boolean n(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!m(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public boolean o(CharSequence charSequence) {
        return g(charSequence) == -1;
    }

    public AbstractC1229d p() {
        return new k(this);
    }
}
