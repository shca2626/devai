package B0;

import B0.v;
import E0.U;
import android.net.Uri;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: B0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0299a {

    /* renamed from: g, reason: collision with root package name */
    public static final C0299a f576g = new C0299a(null, new C0008a[0], 0, -9223372036854775807L, 0);

    /* renamed from: h, reason: collision with root package name */
    public static final C0008a f577h = new C0008a(0).i(0);

    /* renamed from: i, reason: collision with root package name */
    public static final String f578i = U.A0(1);

    /* renamed from: j, reason: collision with root package name */
    public static final String f579j = U.A0(2);

    /* renamed from: k, reason: collision with root package name */
    public static final String f580k = U.A0(3);

    /* renamed from: l, reason: collision with root package name */
    public static final String f581l = U.A0(4);

    /* renamed from: a, reason: collision with root package name */
    public final Object f582a;

    /* renamed from: b, reason: collision with root package name */
    public final int f583b;

    /* renamed from: c, reason: collision with root package name */
    public final long f584c;

    /* renamed from: d, reason: collision with root package name */
    public final long f585d;

    /* renamed from: e, reason: collision with root package name */
    public final int f586e;

    /* renamed from: f, reason: collision with root package name */
    public final C0008a[] f587f;

    /* renamed from: B0.a$a, reason: collision with other inner class name */
    public static final class C0008a {

        /* renamed from: m, reason: collision with root package name */
        public static final String f588m = U.A0(0);

        /* renamed from: n, reason: collision with root package name */
        public static final String f589n = U.A0(1);

        /* renamed from: o, reason: collision with root package name */
        public static final String f590o = U.A0(2);

        /* renamed from: p, reason: collision with root package name */
        public static final String f591p = U.A0(3);

        /* renamed from: q, reason: collision with root package name */
        public static final String f592q = U.A0(4);

        /* renamed from: r, reason: collision with root package name */
        public static final String f593r = U.A0(5);

        /* renamed from: s, reason: collision with root package name */
        public static final String f594s = U.A0(6);

        /* renamed from: t, reason: collision with root package name */
        public static final String f595t = U.A0(7);

        /* renamed from: u, reason: collision with root package name */
        public static final String f596u = U.A0(8);

        /* renamed from: v, reason: collision with root package name */
        public static final String f597v = U.A0(9);

        /* renamed from: w, reason: collision with root package name */
        public static final String f598w = U.A0(10);

        /* renamed from: x, reason: collision with root package name */
        public static final String f599x = U.A0(11);

        /* renamed from: a, reason: collision with root package name */
        public final long f600a;

        /* renamed from: b, reason: collision with root package name */
        public final int f601b;

        /* renamed from: c, reason: collision with root package name */
        public final int f602c;

        /* renamed from: d, reason: collision with root package name */
        public final Uri[] f603d;

        /* renamed from: e, reason: collision with root package name */
        public final v[] f604e;

        /* renamed from: f, reason: collision with root package name */
        public final int[] f605f;

        /* renamed from: g, reason: collision with root package name */
        public final long[] f606g;

        /* renamed from: h, reason: collision with root package name */
        public final String[] f607h;

        /* renamed from: i, reason: collision with root package name */
        public final b[] f608i;

        /* renamed from: j, reason: collision with root package name */
        public final long f609j;

        /* renamed from: k, reason: collision with root package name */
        public final boolean f610k;

        /* renamed from: l, reason: collision with root package name */
        public final boolean f611l;

        public C0008a(long j7) {
            this(j7, -1, -1, new int[0], new v[0], new long[0], 0L, false, new String[0], new b[0], false);
        }

        public static long[] a(long[] jArr, int i7) {
            int length = jArr.length;
            int iMax = Math.max(i7, length);
            long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
            Arrays.fill(jArrCopyOf, length, iMax, -9223372036854775807L);
            return jArrCopyOf;
        }

        public static b[] b(b[] bVarArr, int i7) {
            return (b[]) Arrays.copyOf(bVarArr, Math.max(i7, bVarArr.length));
        }

        public static int[] c(int[] iArr, int i7) {
            int length = iArr.length;
            int iMax = Math.max(i7, length);
            int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
            Arrays.fill(iArrCopyOf, length, iMax, 0);
            return iArrCopyOf;
        }

        public int d() {
            return e(-1);
        }

        public int e(int i7) {
            int i8;
            int i9 = i7 + 1;
            while (true) {
                int[] iArr = this.f605f;
                if (i9 >= iArr.length || this.f610k || (i8 = iArr[i9]) == 0 || i8 == 1) {
                    break;
                }
                i9++;
            }
            return i9;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && C0008a.class == obj.getClass()) {
                C0008a c0008a = (C0008a) obj;
                if (this.f600a == c0008a.f600a && this.f601b == c0008a.f601b && this.f602c == c0008a.f602c && Arrays.equals(this.f604e, c0008a.f604e) && Arrays.equals(this.f605f, c0008a.f605f) && Arrays.equals(this.f606g, c0008a.f606g) && this.f609j == c0008a.f609j && this.f610k == c0008a.f610k && Arrays.equals(this.f607h, c0008a.f607h) && Arrays.equals(this.f608i, c0008a.f608i) && this.f611l == c0008a.f611l) {
                    return true;
                }
            }
            return false;
        }

        public boolean f() {
            if (this.f601b == -1) {
                return true;
            }
            for (int i7 = 0; i7 < this.f601b; i7++) {
                int i8 = this.f605f[i7];
                if (i8 == 0 || i8 == 1) {
                    return true;
                }
            }
            return false;
        }

        public boolean g() {
            return this.f611l && this.f600a == Long.MIN_VALUE && this.f601b == -1;
        }

        public boolean h() {
            return this.f601b == -1 || d() < this.f601b;
        }

        public int hashCode() {
            int i7 = ((this.f601b * 31) + this.f602c) * 31;
            long j7 = this.f600a;
            int iHashCode = (((((((i7 + ((int) (j7 ^ (j7 >>> 32)))) * 31) + Arrays.hashCode(this.f604e)) * 31) + Arrays.hashCode(this.f605f)) * 31) + Arrays.hashCode(this.f606g)) * 31;
            long j8 = this.f609j;
            return ((((((((iHashCode + ((int) (j8 ^ (j8 >>> 32)))) * 31) + (this.f610k ? 1 : 0)) * 31) + Arrays.hashCode(this.f607h)) * 31) + Arrays.hashCode(this.f608i)) * 31) + (this.f611l ? 1 : 0);
        }

        public C0008a i(int i7) {
            int[] iArrC = c(this.f605f, i7);
            long[] jArrA = a(this.f606g, i7);
            return new C0008a(this.f600a, i7, this.f602c, iArrC, (v[]) Arrays.copyOf(this.f604e, i7), jArrA, this.f609j, this.f610k, (String[]) Arrays.copyOf(this.f607h, i7), b(this.f608i, i7), this.f611l);
        }

        public C0008a(long j7, int i7, int i8, int[] iArr, v[] vVarArr, long[] jArr, long j8, boolean z7, String[] strArr, b[] bVarArr, boolean z8) {
            int i9 = 0;
            j3.o.d(iArr.length == vVarArr.length);
            j3.o.d(iArr.length == bVarArr.length);
            this.f600a = j7;
            this.f601b = i7;
            this.f602c = i8;
            this.f605f = iArr;
            this.f604e = vVarArr;
            this.f606g = jArr;
            this.f609j = j8;
            this.f610k = z7;
            this.f603d = new Uri[vVarArr.length];
            while (true) {
                Uri[] uriArr = this.f603d;
                if (i9 >= uriArr.length) {
                    this.f607h = strArr;
                    this.f608i = bVarArr;
                    this.f611l = z8;
                    return;
                } else {
                    v vVar = vVarArr[i9];
                    uriArr[i9] = vVar == null ? null : ((v.h) j3.o.q(vVar.f827b)).f922a;
                    i9++;
                }
            }
        }
    }

    /* renamed from: B0.a$b */
    public static final class b {
    }

    public C0299a(Object obj, C0008a[] c0008aArr, long j7, long j8, int i7) {
        this.f582a = obj;
        this.f584c = j7;
        this.f585d = j8;
        this.f583b = c0008aArr.length + i7;
        this.f587f = c0008aArr;
        this.f586e = i7;
    }

    public C0008a a(int i7) {
        int i8 = this.f586e;
        return i7 < i8 ? f577h : this.f587f[i7 - i8];
    }

    public int b(long j7, long j8) {
        if (j7 != Long.MIN_VALUE && (j8 == -9223372036854775807L || j7 < j8)) {
            int i7 = this.f586e;
            while (i7 < this.f583b && ((a(i7).f600a != Long.MIN_VALUE && a(i7).f600a <= j7) || !a(i7).h())) {
                i7++;
            }
            if (i7 < this.f583b && (j8 == -9223372036854775807L || a(i7).f600a <= j8)) {
                return i7;
            }
        }
        return -1;
    }

    public int c(long j7, long j8) {
        int i7 = this.f583b - 1;
        int i8 = i7 - (d(i7) ? 1 : 0);
        while (i8 >= 0) {
            long j9 = j7;
            long j10 = j8;
            if (!e(j9, j10, i8)) {
                break;
            }
            i8--;
            j7 = j9;
            j8 = j10;
        }
        if (i8 < 0 || !a(i8).f()) {
            return -1;
        }
        return i8;
    }

    public boolean d(int i7) {
        return i7 == this.f583b - 1 && a(i7).g();
    }

    public final boolean e(long j7, long j8, int i7) {
        if (j7 == Long.MIN_VALUE) {
            return false;
        }
        C0008a c0008aA = a(i7);
        long j9 = c0008aA.f600a;
        return j9 == Long.MIN_VALUE ? j8 == -9223372036854775807L || c0008aA.g() || j7 < j8 : j7 < j9;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0299a.class == obj.getClass()) {
            C0299a c0299a = (C0299a) obj;
            if (Objects.equals(this.f582a, c0299a.f582a) && this.f583b == c0299a.f583b && this.f584c == c0299a.f584c && this.f585d == c0299a.f585d && this.f586e == c0299a.f586e && Arrays.equals(this.f587f, c0299a.f587f)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i7 = this.f583b * 31;
        Object obj = this.f582a;
        return ((((((((i7 + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.f584c)) * 31) + ((int) this.f585d)) * 31) + this.f586e) * 31) + Arrays.hashCode(this.f587f);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdPlaybackState(adsId=");
        sb.append(this.f582a);
        sb.append(", adResumePositionUs=");
        sb.append(this.f584c);
        sb.append(", adGroups=[");
        for (int i7 = 0; i7 < this.f587f.length; i7++) {
            sb.append("adGroup(timeUs=");
            sb.append(this.f587f[i7].f600a);
            sb.append(", ads=[");
            for (int i8 = 0; i8 < this.f587f[i7].f605f.length; i8++) {
                sb.append("ad(state=");
                int i9 = this.f587f[i7].f605f[i8];
                if (i9 == 0) {
                    sb.append('_');
                } else if (i9 == 1) {
                    sb.append('R');
                } else if (i9 == 2) {
                    sb.append('S');
                } else if (i9 == 3) {
                    sb.append('P');
                } else if (i9 != 4) {
                    sb.append('?');
                } else {
                    sb.append('!');
                }
                sb.append(", durationUs=");
                sb.append(this.f587f[i7].f606g[i8]);
                sb.append(')');
                if (i8 < this.f587f[i7].f605f.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i7 < this.f587f.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("])");
        return sb.toString();
    }
}
