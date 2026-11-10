package J3;

import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f4766a;

    /* renamed from: b, reason: collision with root package name */
    public int f4767b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4768c;

    /* renamed from: d, reason: collision with root package name */
    public final List f4769d;

    /* renamed from: e, reason: collision with root package name */
    public final String f4770e;

    /* renamed from: f, reason: collision with root package name */
    public Integer f4771f;

    /* renamed from: g, reason: collision with root package name */
    public Integer f4772g;

    /* renamed from: h, reason: collision with root package name */
    public Object f4773h;

    /* renamed from: i, reason: collision with root package name */
    public final int f4774i;

    /* renamed from: j, reason: collision with root package name */
    public final int f4775j;

    /* renamed from: k, reason: collision with root package name */
    public final int f4776k;

    public e(byte[] bArr, String str, List list, String str2) {
        this(bArr, str, list, str2, -1, -1, 0);
    }

    public List a() {
        return this.f4769d;
    }

    public String b() {
        return this.f4770e;
    }

    public Integer c() {
        return this.f4772g;
    }

    public Integer d() {
        return this.f4771f;
    }

    public int e() {
        return this.f4767b;
    }

    public Object f() {
        return this.f4773h;
    }

    public byte[] g() {
        return this.f4766a;
    }

    public int h() {
        return this.f4774i;
    }

    public int i() {
        return this.f4775j;
    }

    public int j() {
        return this.f4776k;
    }

    public String k() {
        return this.f4768c;
    }

    public boolean l() {
        return this.f4774i >= 0 && this.f4775j >= 0;
    }

    public void m(Integer num) {
        this.f4772g = num;
    }

    public void n(Integer num) {
        this.f4771f = num;
    }

    public void o(int i7) {
        this.f4767b = i7;
    }

    public void p(Object obj) {
        this.f4773h = obj;
    }

    public e(byte[] bArr, String str, List list, String str2, int i7) {
        this(bArr, str, list, str2, -1, -1, i7);
    }

    public e(byte[] bArr, String str, List list, String str2, int i7, int i8, int i9) {
        this.f4766a = bArr;
        this.f4767b = bArr == null ? 0 : bArr.length * 8;
        this.f4768c = str;
        this.f4769d = list;
        this.f4770e = str2;
        this.f4774i = i8;
        this.f4775j = i7;
        this.f4776k = i9;
    }
}
