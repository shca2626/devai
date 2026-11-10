package j3;

import java.util.Arrays;

/* renamed from: j3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1230d implements p {

    /* renamed from: j3.d$a */
    public static final class a extends AbstractC1230d {

        /* renamed from: l, reason: collision with root package name */
        public final AbstractC1230d f18704l;

        /* renamed from: m, reason: collision with root package name */
        public final AbstractC1230d f18705m;

        public a(AbstractC1230d abstractC1230d, AbstractC1230d abstractC1230d2) {
            this.f18704l = (AbstractC1230d) o.q(abstractC1230d);
            this.f18705m = (AbstractC1230d) o.q(abstractC1230d2);
        }

        @Override // j3.p
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.e((Character) obj);
        }

        @Override // j3.AbstractC1230d
        public boolean m(char c7) {
            return this.f18704l.m(c7) && this.f18705m.m(c7);
        }

        public String toString() {
            return "CharMatcher.and(" + this.f18704l + ", " + this.f18705m + ")";
        }
    }

    /* renamed from: j3.d$b */
    public static final class b extends j {

        /* renamed from: m, reason: collision with root package name */
        public static final AbstractC1230d f18706m = new b();

        public b() {
            super("CharMatcher.any()");
        }

        @Override // j3.AbstractC1230d
        public AbstractC1230d b(AbstractC1230d abstractC1230d) {
            return (AbstractC1230d) o.q(abstractC1230d);
        }

        @Override // j3.AbstractC1230d
        public int g(CharSequence charSequence) {
            return charSequence.length() == 0 ? -1 : 0;
        }

        @Override // j3.AbstractC1230d
        public int h(CharSequence charSequence, int i7) {
            int length = charSequence.length();
            o.s(i7, length);
            if (i7 == length) {
                return -1;
            }
            return i7;
        }

        @Override // j3.AbstractC1230d
        public boolean m(char c7) {
            return true;
        }

        @Override // j3.AbstractC1230d
        public boolean n(CharSequence charSequence) {
            o.q(charSequence);
            return true;
        }

        @Override // j3.AbstractC1230d
        public boolean o(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // j3.AbstractC1230d.e, j3.AbstractC1230d
        public AbstractC1230d p() {
            return AbstractC1230d.q();
        }
    }

    /* renamed from: j3.d$c */
    public static final class c extends AbstractC1230d {

        /* renamed from: l, reason: collision with root package name */
        public final char[] f18707l;

        public c(CharSequence charSequence) {
            char[] charArray = charSequence.toString().toCharArray();
            this.f18707l = charArray;
            Arrays.sort(charArray);
        }

        @Override // j3.p
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.e((Character) obj);
        }

        @Override // j3.AbstractC1230d
        public boolean m(char c7) {
            return Arrays.binarySearch(this.f18707l, c7) >= 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("CharMatcher.anyOf(\"");
            for (char c7 : this.f18707l) {
                sb.append(AbstractC1230d.s(c7));
            }
            sb.append("\")");
            return sb.toString();
        }
    }

    /* renamed from: j3.d$d, reason: collision with other inner class name */
    public static final class C0208d extends j {

        /* renamed from: m, reason: collision with root package name */
        public static final AbstractC1230d f18708m = new C0208d();

        public C0208d() {
            super("CharMatcher.ascii()");
        }

        @Override // j3.AbstractC1230d
        public boolean m(char c7) {
            return c7 <= 127;
        }
    }

    /* renamed from: j3.d$e */
    public static abstract class e extends AbstractC1230d {
        @Override // j3.p
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.e((Character) obj);
        }

        @Override // j3.AbstractC1230d
        public AbstractC1230d p() {
            return new l(this);
        }
    }

    /* renamed from: j3.d$f */
    public static final class f extends e {

        /* renamed from: l, reason: collision with root package name */
        public final char f18709l;

        public f(char c7) {
            this.f18709l = c7;
        }

        @Override // j3.AbstractC1230d
        public AbstractC1230d b(AbstractC1230d abstractC1230d) {
            return abstractC1230d.m(this.f18709l) ? this : AbstractC1230d.q();
        }

        @Override // j3.AbstractC1230d
        public boolean m(char c7) {
            return c7 == this.f18709l;
        }

        @Override // j3.AbstractC1230d.e, j3.AbstractC1230d
        public AbstractC1230d p() {
            return AbstractC1230d.k(this.f18709l);
        }

        public String toString() {
            return "CharMatcher.is('" + AbstractC1230d.s(this.f18709l) + "')";
        }
    }

    /* renamed from: j3.d$g */
    public static final class g extends e {

        /* renamed from: l, reason: collision with root package name */
        public final char f18710l;

        /* renamed from: m, reason: collision with root package name */
        public final char f18711m;

        public g(char c7, char c8) {
            this.f18710l = c7;
            this.f18711m = c8;
        }

        @Override // j3.AbstractC1230d
        public boolean m(char c7) {
            return c7 == this.f18710l || c7 == this.f18711m;
        }

        public String toString() {
            return "CharMatcher.anyOf(\"" + AbstractC1230d.s(this.f18710l) + AbstractC1230d.s(this.f18711m) + "\")";
        }
    }

    /* renamed from: j3.d$h */
    public static final class h extends e {

        /* renamed from: l, reason: collision with root package name */
        public final char f18712l;

        public h(char c7) {
            this.f18712l = c7;
        }

        @Override // j3.AbstractC1230d
        public AbstractC1230d b(AbstractC1230d abstractC1230d) {
            return abstractC1230d.m(this.f18712l) ? super.b(abstractC1230d) : abstractC1230d;
        }

        @Override // j3.AbstractC1230d
        public boolean m(char c7) {
            return c7 != this.f18712l;
        }

        @Override // j3.AbstractC1230d.e, j3.AbstractC1230d
        public AbstractC1230d p() {
            return AbstractC1230d.i(this.f18712l);
        }

        public String toString() {
            return "CharMatcher.isNot('" + AbstractC1230d.s(this.f18712l) + "')";
        }
    }

    /* renamed from: j3.d$i */
    public static final class i extends j {

        /* renamed from: m, reason: collision with root package name */
        public static final AbstractC1230d f18713m = new i();

        public i() {
            super("CharMatcher.javaIsoControl()");
        }

        @Override // j3.AbstractC1230d
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
        public final String f18714l;

        public j(String str) {
            this.f18714l = (String) o.q(str);
        }

        public final String toString() {
            return this.f18714l;
        }
    }

    /* renamed from: j3.d$k */
    public static class k extends AbstractC1230d {

        /* renamed from: l, reason: collision with root package name */
        public final AbstractC1230d f18715l;

        public k(AbstractC1230d abstractC1230d) {
            this.f18715l = (AbstractC1230d) o.q(abstractC1230d);
        }

        @Override // j3.p
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.e((Character) obj);
        }

        @Override // j3.AbstractC1230d
        public boolean m(char c7) {
            return !this.f18715l.m(c7);
        }

        @Override // j3.AbstractC1230d
        public boolean n(CharSequence charSequence) {
            return this.f18715l.o(charSequence);
        }

        @Override // j3.AbstractC1230d
        public boolean o(CharSequence charSequence) {
            return this.f18715l.n(charSequence);
        }

        @Override // j3.AbstractC1230d
        public AbstractC1230d p() {
            return this.f18715l;
        }

        public String toString() {
            return this.f18715l + ".negate()";
        }
    }

    /* renamed from: j3.d$l */
    public static class l extends k {
        public l(AbstractC1230d abstractC1230d) {
            super(abstractC1230d);
        }
    }

    /* renamed from: j3.d$m */
    public static final class m extends j {

        /* renamed from: m, reason: collision with root package name */
        public static final AbstractC1230d f18716m = new m();

        public m() {
            super("CharMatcher.none()");
        }

        @Override // j3.AbstractC1230d
        public AbstractC1230d b(AbstractC1230d abstractC1230d) {
            o.q(abstractC1230d);
            return this;
        }

        @Override // j3.AbstractC1230d
        public int g(CharSequence charSequence) {
            o.q(charSequence);
            return -1;
        }

        @Override // j3.AbstractC1230d
        public int h(CharSequence charSequence, int i7) {
            o.s(i7, charSequence.length());
            return -1;
        }

        @Override // j3.AbstractC1230d
        public boolean m(char c7) {
            return false;
        }

        @Override // j3.AbstractC1230d
        public boolean n(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // j3.AbstractC1230d
        public boolean o(CharSequence charSequence) {
            o.q(charSequence);
            return true;
        }

        @Override // j3.AbstractC1230d.e, j3.AbstractC1230d
        public AbstractC1230d p() {
            return AbstractC1230d.c();
        }
    }

    public static AbstractC1230d c() {
        return b.f18706m;
    }

    public static AbstractC1230d d(CharSequence charSequence) {
        int length = charSequence.length();
        return length != 0 ? length != 1 ? length != 2 ? new c(charSequence) : j(charSequence.charAt(0), charSequence.charAt(1)) : i(charSequence.charAt(0)) : q();
    }

    public static AbstractC1230d f() {
        return C0208d.f18708m;
    }

    public static AbstractC1230d i(char c7) {
        return new f(c7);
    }

    public static g j(char c7, char c8) {
        return new g(c7, c8);
    }

    public static AbstractC1230d k(char c7) {
        return new h(c7);
    }

    public static AbstractC1230d l() {
        return i.f18713m;
    }

    public static AbstractC1230d q() {
        return m.f18716m;
    }

    public static AbstractC1230d r(CharSequence charSequence) {
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

    public AbstractC1230d b(AbstractC1230d abstractC1230d) {
        return new a(this, abstractC1230d);
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

    public AbstractC1230d p() {
        return new k(this);
    }
}
