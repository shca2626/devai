package M1;

import android.text.TextUtils;
import j3.AbstractC1228c;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: f, reason: collision with root package name */
    public int f5635f;

    /* renamed from: h, reason: collision with root package name */
    public int f5637h;

    /* renamed from: o, reason: collision with root package name */
    public float f5644o;

    /* renamed from: a, reason: collision with root package name */
    public String f5630a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f5631b = "";

    /* renamed from: c, reason: collision with root package name */
    public Set f5632c = Collections.EMPTY_SET;

    /* renamed from: d, reason: collision with root package name */
    public String f5633d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f5634e = null;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5636g = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f5638i = false;

    /* renamed from: j, reason: collision with root package name */
    public int f5639j = -1;

    /* renamed from: k, reason: collision with root package name */
    public int f5640k = -1;

    /* renamed from: l, reason: collision with root package name */
    public int f5641l = -1;

    /* renamed from: m, reason: collision with root package name */
    public int f5642m = -1;

    /* renamed from: n, reason: collision with root package name */
    public int f5643n = -1;

    /* renamed from: p, reason: collision with root package name */
    public int f5645p = -1;

    /* renamed from: q, reason: collision with root package name */
    public boolean f5646q = false;

    public static int B(int i7, String str, String str2, int i8) {
        if (str.isEmpty() || i7 == -1) {
            return i7;
        }
        if (str.equals(str2)) {
            return i7 + i8;
        }
        return -1;
    }

    public c A(boolean z7) {
        this.f5640k = z7 ? 1 : 0;
        return this;
    }

    public int a() {
        if (this.f5638i) {
            return this.f5637h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean b() {
        return this.f5646q;
    }

    public int c() {
        if (this.f5636g) {
            return this.f5635f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    public String d() {
        return this.f5634e;
    }

    public float e() {
        return this.f5644o;
    }

    public int f() {
        return this.f5643n;
    }

    public int g() {
        return this.f5645p;
    }

    public int h(String str, String str2, Set set, String str3) {
        if (this.f5630a.isEmpty() && this.f5631b.isEmpty() && this.f5632c.isEmpty() && this.f5633d.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int iB = B(B(B(0, this.f5630a, str, 1073741824), this.f5631b, str2, 2), this.f5633d, str3, 4);
        if (iB == -1 || !set.containsAll(this.f5632c)) {
            return 0;
        }
        return iB + (this.f5632c.size() * 4);
    }

    public int i() {
        int i7 = this.f5641l;
        if (i7 == -1 && this.f5642m == -1) {
            return -1;
        }
        return (i7 == 1 ? 1 : 0) | (this.f5642m == 1 ? 2 : 0);
    }

    public boolean j() {
        return this.f5638i;
    }

    public boolean k() {
        return this.f5636g;
    }

    public boolean l() {
        return this.f5639j == 1;
    }

    public boolean m() {
        return this.f5640k == 1;
    }

    public c n(int i7) {
        this.f5637h = i7;
        this.f5638i = true;
        return this;
    }

    public c o(boolean z7) {
        this.f5641l = z7 ? 1 : 0;
        return this;
    }

    public c p(boolean z7) {
        this.f5646q = z7;
        return this;
    }

    public c q(int i7) {
        this.f5635f = i7;
        this.f5636g = true;
        return this;
    }

    public c r(String str) {
        this.f5634e = str == null ? null : AbstractC1228c.f(str);
        return this;
    }

    public c s(float f7) {
        this.f5644o = f7;
        return this;
    }

    public c t(int i7) {
        this.f5643n = i7;
        return this;
    }

    public c u(boolean z7) {
        this.f5642m = z7 ? 1 : 0;
        return this;
    }

    public c v(int i7) {
        this.f5645p = i7;
        return this;
    }

    public void w(String[] strArr) {
        this.f5632c = new HashSet(Arrays.asList(strArr));
    }

    public void x(String str) {
        this.f5630a = str;
    }

    public void y(String str) {
        this.f5631b = str;
    }

    public void z(String str) {
        this.f5633d = str;
    }
}
