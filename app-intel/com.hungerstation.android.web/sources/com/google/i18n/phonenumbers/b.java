package com.google.i18n.phonenumbers;

import java.io.Serializable;

/* loaded from: classes8.dex */
public class b implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    private boolean f25205b;

    /* renamed from: d, reason: collision with root package name */
    private boolean f25207d;

    /* renamed from: f, reason: collision with root package name */
    private boolean f25209f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f25211h;

    /* renamed from: j, reason: collision with root package name */
    private boolean f25213j;

    /* renamed from: l, reason: collision with root package name */
    private boolean f25215l;

    /* renamed from: n, reason: collision with root package name */
    private boolean f25217n;

    /* renamed from: p, reason: collision with root package name */
    private boolean f25219p;

    /* renamed from: c, reason: collision with root package name */
    private int f25206c = 0;

    /* renamed from: e, reason: collision with root package name */
    private long f25208e = 0;

    /* renamed from: g, reason: collision with root package name */
    private String f25210g = "";

    /* renamed from: i, reason: collision with root package name */
    private boolean f25212i = false;

    /* renamed from: k, reason: collision with root package name */
    private int f25214k = 1;

    /* renamed from: m, reason: collision with root package name */
    private String f25216m = "";

    /* renamed from: q, reason: collision with root package name */
    private String f25220q = "";

    /* renamed from: o, reason: collision with root package name */
    private a f25218o = a.UNSPECIFIED;

    public enum a {
        FROM_NUMBER_WITH_PLUS_SIGN,
        FROM_NUMBER_WITH_IDD,
        FROM_NUMBER_WITHOUT_PLUS_SIGN,
        FROM_DEFAULT_COUNTRY,
        UNSPECIFIED
    }

    public b b() {
        this.f25217n = false;
        this.f25218o = a.UNSPECIFIED;
        return this;
    }

    public boolean c(b bVar) {
        if (bVar == null) {
            return false;
        }
        if (this == bVar) {
            return true;
        }
        return this.f25206c == bVar.f25206c && this.f25208e == bVar.f25208e && this.f25210g.equals(bVar.f25210g) && this.f25212i == bVar.f25212i && this.f25214k == bVar.f25214k && this.f25216m.equals(bVar.f25216m) && this.f25218o == bVar.f25218o && this.f25220q.equals(bVar.f25220q) && o() == bVar.o();
    }

    public int d() {
        return this.f25206c;
    }

    public a e() {
        return this.f25218o;
    }

    public boolean equals(Object obj) {
        return (obj instanceof b) && c((b) obj);
    }

    public String f() {
        return this.f25210g;
    }

    public long g() {
        return this.f25208e;
    }

    public int h() {
        return this.f25214k;
    }

    public int hashCode() {
        return ((((((((((((((((2173 + d()) * 53) + Long.valueOf(g()).hashCode()) * 53) + f().hashCode()) * 53) + (p() ? 1231 : 1237)) * 53) + h()) * 53) + j().hashCode()) * 53) + e().hashCode()) * 53) + i().hashCode()) * 53) + (o() ? 1231 : 1237);
    }

    public String i() {
        return this.f25220q;
    }

    public String j() {
        return this.f25216m;
    }

    public boolean k() {
        return this.f25217n;
    }

    public boolean l() {
        return this.f25209f;
    }

    public boolean m() {
        return this.f25211h;
    }

    public boolean n() {
        return this.f25213j;
    }

    public boolean o() {
        return this.f25219p;
    }

    public boolean p() {
        return this.f25212i;
    }

    public b q(int i12) {
        this.f25205b = true;
        this.f25206c = i12;
        return this;
    }

    public b r(a aVar) {
        aVar.getClass();
        this.f25217n = true;
        this.f25218o = aVar;
        return this;
    }

    public b s(String str) {
        str.getClass();
        this.f25209f = true;
        this.f25210g = str;
        return this;
    }

    public b t(boolean z12) {
        this.f25211h = true;
        this.f25212i = z12;
        return this;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Country Code: ");
        sb2.append(this.f25206c);
        sb2.append(" National Number: ");
        sb2.append(this.f25208e);
        if (m() && p()) {
            sb2.append(" Leading Zero(s): true");
        }
        if (n()) {
            sb2.append(" Number of leading zeros: ");
            sb2.append(this.f25214k);
        }
        if (l()) {
            sb2.append(" Extension: ");
            sb2.append(this.f25210g);
        }
        if (k()) {
            sb2.append(" Country Code Source: ");
            sb2.append(this.f25218o);
        }
        if (o()) {
            sb2.append(" Preferred Domestic Carrier Code: ");
            sb2.append(this.f25220q);
        }
        return sb2.toString();
    }

    public b u(long j12) {
        this.f25207d = true;
        this.f25208e = j12;
        return this;
    }

    public b v(int i12) {
        this.f25213j = true;
        this.f25214k = i12;
        return this;
    }

    public b w(String str) {
        str.getClass();
        this.f25219p = true;
        this.f25220q = str;
        return this;
    }

    public b x(String str) {
        str.getClass();
        this.f25215l = true;
        this.f25216m = str;
        return this;
    }
}
