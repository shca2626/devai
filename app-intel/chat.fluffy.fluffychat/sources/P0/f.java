package P0;

import B0.C0313o;
import P0.f;
import android.net.Uri;
import j3.o;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import k3.AbstractC1279v;
import k3.AbstractC1281x;
import k3.D;

/* loaded from: classes.dex */
public final class f extends j {

    /* renamed from: d, reason: collision with root package name */
    public final int f7347d;

    /* renamed from: e, reason: collision with root package name */
    public final long f7348e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f7349f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f7350g;

    /* renamed from: h, reason: collision with root package name */
    public final long f7351h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f7352i;

    /* renamed from: j, reason: collision with root package name */
    public final int f7353j;

    /* renamed from: k, reason: collision with root package name */
    public final long f7354k;

    /* renamed from: l, reason: collision with root package name */
    public final int f7355l;

    /* renamed from: m, reason: collision with root package name */
    public final long f7356m;

    /* renamed from: n, reason: collision with root package name */
    public final long f7357n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f7358o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f7359p;

    /* renamed from: q, reason: collision with root package name */
    public final C0313o f7360q;

    /* renamed from: r, reason: collision with root package name */
    public final List f7361r;

    /* renamed from: s, reason: collision with root package name */
    public final List f7362s;

    /* renamed from: t, reason: collision with root package name */
    public final Map f7363t;

    /* renamed from: u, reason: collision with root package name */
    public final long f7364u;

    /* renamed from: v, reason: collision with root package name */
    public final h f7365v;

    /* renamed from: w, reason: collision with root package name */
    public final AbstractC1279v f7366w;

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f7371a;

        /* renamed from: b, reason: collision with root package name */
        public final Uri f7372b;

        /* renamed from: c, reason: collision with root package name */
        public final Uri f7373c;

        /* renamed from: d, reason: collision with root package name */
        public final long f7374d;

        /* renamed from: e, reason: collision with root package name */
        public final long f7375e;

        /* renamed from: f, reason: collision with root package name */
        public final long f7376f;

        /* renamed from: g, reason: collision with root package name */
        public final long f7377g;

        /* renamed from: h, reason: collision with root package name */
        public final List f7378h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f7379i;

        /* renamed from: j, reason: collision with root package name */
        public final long f7380j;

        /* renamed from: k, reason: collision with root package name */
        public final long f7381k;

        /* renamed from: l, reason: collision with root package name */
        public final AbstractC1279v f7382l;

        /* renamed from: m, reason: collision with root package name */
        public final AbstractC1279v f7383m;

        /* renamed from: n, reason: collision with root package name */
        public final AbstractC1279v f7384n;

        /* renamed from: o, reason: collision with root package name */
        public final boolean f7385o;

        /* renamed from: p, reason: collision with root package name */
        public final String f7386p;

        /* renamed from: q, reason: collision with root package name */
        public final String f7387q;

        /* renamed from: r, reason: collision with root package name */
        public final long f7388r;

        /* renamed from: s, reason: collision with root package name */
        public final long f7389s;

        /* renamed from: t, reason: collision with root package name */
        public final String f7390t;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public final String f7391a;

            /* renamed from: c, reason: collision with root package name */
            public Uri f7393c;

            /* renamed from: d, reason: collision with root package name */
            public Uri f7394d;

            /* renamed from: j, reason: collision with root package name */
            public boolean f7400j;

            /* renamed from: o, reason: collision with root package name */
            public Boolean f7405o;

            /* renamed from: p, reason: collision with root package name */
            public String f7406p;

            /* renamed from: q, reason: collision with root package name */
            public String f7407q;

            /* renamed from: t, reason: collision with root package name */
            public String f7410t;

            /* renamed from: b, reason: collision with root package name */
            public final Map f7392b = new HashMap();

            /* renamed from: e, reason: collision with root package name */
            public long f7395e = -9223372036854775807L;

            /* renamed from: f, reason: collision with root package name */
            public long f7396f = -9223372036854775807L;

            /* renamed from: g, reason: collision with root package name */
            public long f7397g = -9223372036854775807L;

            /* renamed from: h, reason: collision with root package name */
            public long f7398h = -9223372036854775807L;

            /* renamed from: i, reason: collision with root package name */
            public List f7399i = new ArrayList();

            /* renamed from: k, reason: collision with root package name */
            public long f7401k = -9223372036854775807L;

            /* renamed from: l, reason: collision with root package name */
            public long f7402l = -9223372036854775807L;

            /* renamed from: m, reason: collision with root package name */
            public List f7403m = new ArrayList();

            /* renamed from: n, reason: collision with root package name */
            public List f7404n = new ArrayList();

            /* renamed from: r, reason: collision with root package name */
            public long f7408r = -9223372036854775807L;

            /* renamed from: s, reason: collision with root package name */
            public long f7409s = -9223372036854775807L;

            public a(String str) {
                this.f7391a = str;
            }

            public c a() {
                Uri uri = this.f7394d;
                if ((uri != null || this.f7393c == null) && (uri == null || this.f7393c != null)) {
                    return null;
                }
                long j7 = this.f7395e;
                if (j7 == -9223372036854775807L) {
                    return null;
                }
                String str = this.f7391a;
                Uri uri2 = this.f7393c;
                long j8 = this.f7396f;
                long j9 = this.f7397g;
                long j10 = this.f7398h;
                List list = this.f7399i;
                boolean z7 = this.f7400j;
                long j11 = this.f7401k;
                long j12 = this.f7402l;
                List list2 = this.f7403m;
                List list3 = this.f7404n;
                ArrayList arrayList = new ArrayList(this.f7392b.values());
                Boolean bool = this.f7405o;
                boolean z8 = bool == null || bool.booleanValue();
                String str2 = this.f7406p;
                if (str2 == null) {
                    str2 = "POINT";
                }
                String str3 = str2;
                String str4 = this.f7407q;
                if (str4 == null) {
                    str4 = "HIGHLIGHT";
                }
                return new c(str, uri2, uri, j7, j8, j9, j10, list, z7, j11, j12, list2, list3, arrayList, z8, str3, str4, this.f7408r, this.f7409s, this.f7410t);
            }

            public a b(Uri uri) {
                if (uri == null) {
                    return this;
                }
                Uri uri2 = this.f7394d;
                if (uri2 != null) {
                    o.m(uri2.equals(uri), "Can't change assetListUri from %s to %s", this.f7394d, uri);
                }
                this.f7394d = uri;
                return this;
            }

            public a c(Uri uri) {
                if (uri == null) {
                    return this;
                }
                Uri uri2 = this.f7393c;
                if (uri2 != null) {
                    o.m(uri2.equals(uri), "Can't change assetUri from %s to %s", this.f7393c, uri);
                }
                this.f7393c = uri;
                return this;
            }

            public a d(List list) {
                if (!list.isEmpty()) {
                    for (int i7 = 0; i7 < list.size(); i7++) {
                        b bVar = (b) list.get(i7);
                        String str = bVar.f7367a;
                        b bVar2 = (b) this.f7392b.get(str);
                        if (bVar2 != null) {
                            o.n(bVar2.equals(bVar), "Can't change %s from %s %s to %s %s", str, bVar2.f7370d, Double.valueOf(bVar2.f7369c), bVar.f7370d, Double.valueOf(bVar.f7369c));
                        }
                        this.f7392b.put(str, bVar);
                    }
                }
                return this;
            }

            public a e(Boolean bool) {
                if (bool == null) {
                    return this;
                }
                Boolean bool2 = this.f7405o;
                if (bool2 != null) {
                    o.m(bool2.equals(bool), "Can't change contentMayVary from %s to %s", this.f7405o, bool);
                }
                this.f7405o = bool;
                return this;
            }

            public a f(List list) {
                if (list.isEmpty()) {
                    return this;
                }
                if (!this.f7399i.isEmpty()) {
                    o.e(this.f7399i.equals(list), "Can't change cue from " + P0.h.a(", ", this.f7399i) + " to " + P0.h.a(", ", list));
                }
                this.f7399i = list;
                return this;
            }

            public a g(long j7) {
                long j8;
                if (j7 == -9223372036854775807L) {
                    return this;
                }
                long j9 = this.f7397g;
                if (j9 != -9223372036854775807L) {
                    j8 = j7;
                    o.j(j9 == j7, "Can't change durationUs from %s to %s", j9, j8);
                } else {
                    j8 = j7;
                }
                this.f7397g = j8;
                return this;
            }

            public a h(long j7) {
                long j8;
                if (j7 == -9223372036854775807L) {
                    return this;
                }
                long j9 = this.f7396f;
                if (j9 != -9223372036854775807L) {
                    j8 = j7;
                    o.j(j9 == j7, "Can't change endDateUnixUs from %s to %s", j9, j8);
                } else {
                    j8 = j7;
                }
                this.f7396f = j8;
                return this;
            }

            public a i(boolean z7) {
                if (!z7) {
                    return this;
                }
                this.f7400j = true;
                return this;
            }

            public a j(long j7) {
                long j8;
                if (j7 == -9223372036854775807L) {
                    return this;
                }
                long j9 = this.f7398h;
                if (j9 != -9223372036854775807L) {
                    j8 = j7;
                    o.j(j9 == j7, "Can't change plannedDurationUs from %s to %s", j9, j8);
                } else {
                    j8 = j7;
                }
                this.f7398h = j8;
                return this;
            }

            public a k(long j7) {
                long j8;
                if (j7 == -9223372036854775807L) {
                    return this;
                }
                long j9 = this.f7402l;
                if (j9 != -9223372036854775807L) {
                    j8 = j7;
                    o.j(j9 == j7, "Can't change playoutLimitUs from %s to %s", j9, j8);
                } else {
                    j8 = j7;
                }
                this.f7402l = j8;
                return this;
            }

            public a l(List list) {
                if (list.isEmpty()) {
                    return this;
                }
                if (!this.f7404n.isEmpty()) {
                    o.e(this.f7404n.equals(list), "Can't change restrictions from " + P0.h.a(", ", this.f7404n) + " to " + P0.h.a(", ", list));
                }
                this.f7404n = list;
                return this;
            }

            public a m(long j7) {
                long j8;
                if (j7 == -9223372036854775807L) {
                    return this;
                }
                long j9 = this.f7401k;
                if (j9 != -9223372036854775807L) {
                    j8 = j7;
                    o.j(j9 == j7, "Can't change resumeOffsetUs from %s to %s", j9, j8);
                } else {
                    j8 = j7;
                }
                this.f7401k = j8;
                return this;
            }

            public a n(long j7) {
                long j8;
                if (j7 == -9223372036854775807L) {
                    return this;
                }
                long j9 = this.f7409s;
                if (j9 != -9223372036854775807L) {
                    j8 = j7;
                    o.j(j9 == j7, "Can't change skipControlDurationUs from %s to %s", j9, j8);
                } else {
                    j8 = j7;
                }
                this.f7409s = j8;
                return this;
            }

            public a o(String str) {
                if (str == null) {
                    return this;
                }
                String str2 = this.f7410t;
                if (str2 != null) {
                    o.m(str2.equals(str), "Can't change skipControlLabelId from %s to %s", this.f7410t, str);
                }
                this.f7410t = str;
                return this;
            }

            public a p(long j7) {
                long j8;
                if (j7 == -9223372036854775807L) {
                    return this;
                }
                long j9 = this.f7408r;
                if (j9 != -9223372036854775807L) {
                    j8 = j7;
                    o.j(j9 == j7, "Can't change skipControlOffsetUs from %s to %s", j9, j8);
                } else {
                    j8 = j7;
                }
                this.f7408r = j8;
                return this;
            }

            public a q(List list) {
                if (list.isEmpty()) {
                    return this;
                }
                if (!this.f7403m.isEmpty()) {
                    o.e(this.f7403m.equals(list), "Can't change snapTypes from " + P0.h.a(", ", this.f7403m) + " to " + P0.h.a(", ", list));
                }
                this.f7403m = list;
                return this;
            }

            public a r(long j7) {
                long j8;
                if (j7 == -9223372036854775807L) {
                    return this;
                }
                long j9 = this.f7395e;
                if (j9 != -9223372036854775807L) {
                    j8 = j7;
                    o.j(j9 == j7, "Can't change startDateUnixUs from %s to %s", j9, j8);
                } else {
                    j8 = j7;
                }
                this.f7395e = j8;
                return this;
            }

            public a s(String str) {
                if (str == null) {
                    return this;
                }
                String str2 = this.f7406p;
                if (str2 != null) {
                    o.m(str2.equals(str), "Can't change timelineOccupies from %s to %s", this.f7406p, str);
                }
                this.f7406p = str;
                return this;
            }

            public a t(String str) {
                if (str == null) {
                    return this;
                }
                String str2 = this.f7407q;
                if (str2 != null) {
                    o.m(str2.equals(str), "Can't change timelineStyle from %s to %s", this.f7407q, str);
                }
                this.f7407q = str;
                return this;
            }
        }

        public c(String str, Uri uri, Uri uri2, long j7, long j8, long j9, long j10, List list, boolean z7, long j11, long j12, List list2, List list3, List list4, boolean z8, String str2, String str3, long j13, long j14, String str4) {
            o.d((uri == null || uri2 == null) && !(uri == null && uri2 == null));
            this.f7371a = str;
            this.f7372b = uri;
            this.f7373c = uri2;
            this.f7374d = j7;
            this.f7375e = j8;
            this.f7376f = j9;
            this.f7377g = j10;
            this.f7378h = list;
            this.f7379i = z7;
            this.f7380j = j11;
            this.f7381k = j12;
            this.f7382l = AbstractC1279v.r(list2);
            this.f7383m = AbstractC1279v.r(list3);
            this.f7384n = AbstractC1279v.C(new Comparator() { // from class: P0.g
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ((f.b) obj).f7367a.compareTo(((f.b) obj2).f7367a);
                }
            }, list4);
            this.f7385o = z8;
            this.f7386p = str2;
            this.f7387q = str3;
            this.f7388r = j13;
            this.f7389s = j14;
            this.f7390t = str4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f7374d == cVar.f7374d && this.f7375e == cVar.f7375e && this.f7376f == cVar.f7376f && this.f7377g == cVar.f7377g && this.f7379i == cVar.f7379i && this.f7380j == cVar.f7380j && this.f7381k == cVar.f7381k && this.f7385o == cVar.f7385o && this.f7388r == cVar.f7388r && this.f7389s == cVar.f7389s && Objects.equals(this.f7371a, cVar.f7371a) && Objects.equals(this.f7372b, cVar.f7372b) && Objects.equals(this.f7373c, cVar.f7373c) && Objects.equals(this.f7378h, cVar.f7378h) && Objects.equals(this.f7382l, cVar.f7382l) && Objects.equals(this.f7383m, cVar.f7383m) && Objects.equals(this.f7384n, cVar.f7384n) && Objects.equals(this.f7386p, cVar.f7386p) && Objects.equals(this.f7387q, cVar.f7387q) && Objects.equals(this.f7390t, cVar.f7390t);
        }

        public int hashCode() {
            return Objects.hash(this.f7371a, this.f7372b, this.f7373c, Long.valueOf(this.f7374d), Long.valueOf(this.f7375e), Long.valueOf(this.f7376f), Long.valueOf(this.f7377g), this.f7378h, Boolean.valueOf(this.f7379i), Long.valueOf(this.f7380j), Long.valueOf(this.f7381k), this.f7382l, this.f7383m, this.f7384n, Boolean.valueOf(this.f7385o), this.f7386p, this.f7387q, Long.valueOf(this.f7388r), Long.valueOf(this.f7389s), this.f7390t);
        }
    }

    public static final class d extends g {

        /* renamed from: w, reason: collision with root package name */
        public final boolean f7411w;

        /* renamed from: x, reason: collision with root package name */
        public final boolean f7412x;

        public d(String str, C0059f c0059f, long j7, int i7, long j8, C0313o c0313o, String str2, String str3, long j9, long j10, boolean z7, boolean z8, boolean z9) {
            super(str, c0059f, j7, i7, j8, c0313o, str2, str3, j9, j10, z7);
            this.f7411w = z8;
            this.f7412x = z9;
        }

        public d d(long j7, int i7) {
            return new d(this.f7418l, this.f7419m, this.f7420n, i7, j7, this.f7423q, this.f7424r, this.f7425s, this.f7426t, this.f7427u, this.f7428v, this.f7411w, this.f7412x);
        }
    }

    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f7413a;

        /* renamed from: b, reason: collision with root package name */
        public final long f7414b;

        /* renamed from: c, reason: collision with root package name */
        public final int f7415c;

        public e(Uri uri, long j7, int i7) {
            this.f7413a = uri;
            this.f7414b = j7;
            this.f7415c = i7;
        }
    }

    public static class g implements Comparable {

        /* renamed from: l, reason: collision with root package name */
        public final String f7418l;

        /* renamed from: m, reason: collision with root package name */
        public final C0059f f7419m;

        /* renamed from: n, reason: collision with root package name */
        public final long f7420n;

        /* renamed from: o, reason: collision with root package name */
        public final int f7421o;

        /* renamed from: p, reason: collision with root package name */
        public final long f7422p;

        /* renamed from: q, reason: collision with root package name */
        public final C0313o f7423q;

        /* renamed from: r, reason: collision with root package name */
        public final String f7424r;

        /* renamed from: s, reason: collision with root package name */
        public final String f7425s;

        /* renamed from: t, reason: collision with root package name */
        public final long f7426t;

        /* renamed from: u, reason: collision with root package name */
        public final long f7427u;

        /* renamed from: v, reason: collision with root package name */
        public final boolean f7428v;

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(Long l7) {
            if (this.f7422p > l7.longValue()) {
                return 1;
            }
            return this.f7422p < l7.longValue() ? -1 : 0;
        }

        public g(String str, C0059f c0059f, long j7, int i7, long j8, C0313o c0313o, String str2, String str3, long j9, long j10, boolean z7) {
            this.f7418l = str;
            this.f7419m = c0059f;
            this.f7420n = j7;
            this.f7421o = i7;
            this.f7422p = j8;
            this.f7423q = c0313o;
            this.f7424r = str2;
            this.f7425s = str3;
            this.f7426t = j9;
            this.f7427u = j10;
            this.f7428v = z7;
        }
    }

    public static final class h {

        /* renamed from: a, reason: collision with root package name */
        public final long f7429a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f7430b;

        /* renamed from: c, reason: collision with root package name */
        public final long f7431c;

        /* renamed from: d, reason: collision with root package name */
        public final long f7432d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f7433e;

        public h(long j7, boolean z7, long j8, long j9, boolean z8) {
            this.f7429a = j7;
            this.f7430b = z7;
            this.f7431c = j8;
            this.f7432d = j9;
            this.f7433e = z8;
        }
    }

    public f(int i7, String str, List list, long j7, boolean z7, long j8, boolean z8, int i8, long j9, int i9, long j10, long j11, boolean z9, boolean z10, boolean z11, C0313o c0313o, List list2, List list3, h hVar, Map map, List list4) {
        super(str, list, z9);
        this.f7347d = i7;
        this.f7351h = j8;
        this.f7350g = z7;
        this.f7352i = z8;
        this.f7353j = i8;
        this.f7354k = j9;
        this.f7355l = i9;
        this.f7356m = j10;
        this.f7357n = j11;
        this.f7358o = z10;
        this.f7359p = z11;
        this.f7360q = c0313o;
        this.f7361r = AbstractC1279v.r(list2);
        this.f7362s = AbstractC1279v.r(list3);
        this.f7363t = AbstractC1281x.c(map);
        this.f7366w = AbstractC1279v.r(list4);
        if (!list3.isEmpty()) {
            d dVar = (d) D.d(list3);
            this.f7364u = dVar.f7422p + dVar.f7420n;
        } else if (list2.isEmpty()) {
            this.f7364u = 0L;
        } else {
            C0059f c0059f = (C0059f) D.d(list2);
            this.f7364u = c0059f.f7422p + c0059f.f7420n;
        }
        this.f7348e = j7 != -9223372036854775807L ? j7 >= 0 ? Math.min(this.f7364u, j7) : Math.max(0L, this.f7364u + j7) : -9223372036854775807L;
        this.f7349f = j7 >= 0;
        this.f7365v = hVar;
    }

    public f c(long j7, int i7) {
        return new f(this.f7347d, this.f7455a, this.f7456b, this.f7348e, this.f7350g, j7, true, i7, this.f7354k, this.f7355l, this.f7356m, this.f7357n, this.f7457c, this.f7358o, this.f7359p, this.f7360q, this.f7361r, this.f7362s, this.f7365v, this.f7363t, this.f7366w);
    }

    public f d() {
        return this.f7358o ? this : new f(this.f7347d, this.f7455a, this.f7456b, this.f7348e, this.f7350g, this.f7351h, this.f7352i, this.f7353j, this.f7354k, this.f7355l, this.f7356m, this.f7357n, this.f7457c, true, this.f7359p, this.f7360q, this.f7361r, this.f7362s, this.f7365v, this.f7363t, this.f7366w);
    }

    public long e() {
        return this.f7351h + this.f7364u;
    }

    public boolean f(f fVar) {
        if (fVar != null) {
            long j7 = this.f7354k;
            long j8 = fVar.f7354k;
            if (j7 <= j8) {
                if (j7 < j8) {
                    return false;
                }
                int size = this.f7361r.size() - fVar.f7361r.size();
                if (size != 0) {
                    return size > 0;
                }
                int size2 = this.f7362s.size();
                int size3 = fVar.f7362s.size();
                if (size2 <= size3 && (size2 != size3 || !this.f7358o || fVar.f7358o)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: P0.f$f, reason: collision with other inner class name */
    public static final class C0059f extends g {

        /* renamed from: w, reason: collision with root package name */
        public final String f7416w;

        /* renamed from: x, reason: collision with root package name */
        public final List f7417x;

        public C0059f(String str, long j7, long j8, String str2, String str3) {
            this(str, null, "", 0L, -1, -9223372036854775807L, null, str2, str3, j7, j8, false, AbstractC1279v.v());
        }

        public C0059f d(long j7, int i7) {
            ArrayList arrayList = new ArrayList();
            long j8 = j7;
            for (int i8 = 0; i8 < this.f7417x.size(); i8++) {
                d dVar = (d) this.f7417x.get(i8);
                arrayList.add(dVar.d(j8, i7));
                j8 += dVar.f7420n;
            }
            return new C0059f(this.f7418l, this.f7419m, this.f7416w, this.f7420n, i7, j7, this.f7423q, this.f7424r, this.f7425s, this.f7426t, this.f7427u, this.f7428v, arrayList);
        }

        public C0059f(String str, C0059f c0059f, String str2, long j7, int i7, long j8, C0313o c0313o, String str3, String str4, long j9, long j10, boolean z7, List list) {
            super(str, c0059f, j7, i7, j8, c0313o, str3, str4, j9, j10, z7);
            this.f7416w = str2;
            this.f7417x = AbstractC1279v.r(list);
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f7367a;

        /* renamed from: b, reason: collision with root package name */
        public final int f7368b;

        /* renamed from: c, reason: collision with root package name */
        public final double f7369c;

        /* renamed from: d, reason: collision with root package name */
        public final String f7370d;

        public b(String str, double d7) {
            this.f7367a = str;
            this.f7368b = 2;
            this.f7369c = d7;
            this.f7370d = null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f7368b == bVar.f7368b && Double.compare(this.f7369c, bVar.f7369c) == 0 && Objects.equals(this.f7367a, bVar.f7367a) && Objects.equals(this.f7370d, bVar.f7370d);
        }

        public int hashCode() {
            return Objects.hash(this.f7367a, Integer.valueOf(this.f7368b), Double.valueOf(this.f7369c), this.f7370d);
        }

        public b(String str, String str2, int i7) {
            boolean z7 = true;
            if (i7 == 1 && !str2.startsWith("0x") && !str2.startsWith("0X")) {
                z7 = false;
            }
            o.v(z7);
            this.f7367a = str;
            this.f7368b = i7;
            this.f7370d = str2;
            this.f7369c = 0.0d;
        }
    }

    @Override // T0.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f a(List list) {
        return this;
    }
}
