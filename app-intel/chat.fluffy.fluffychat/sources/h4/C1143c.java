package h4;

import M5.g;
import M5.m;
import d4.EnumC0992a;

/* renamed from: h4.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1143c {

    /* renamed from: a, reason: collision with root package name */
    public final int f16839a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f16840b;

    /* renamed from: c, reason: collision with root package name */
    public final String f16841c;

    /* renamed from: d, reason: collision with root package name */
    public final long f16842d;

    /* renamed from: e, reason: collision with root package name */
    public final String f16843e;

    /* renamed from: f, reason: collision with root package name */
    public final double f16844f;

    /* renamed from: g, reason: collision with root package name */
    public final EnumC0992a f16845g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f16846h;

    /* renamed from: i, reason: collision with root package name */
    public final String f16847i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f16848j;

    /* renamed from: k, reason: collision with root package name */
    public final int f16849k;

    public C1143c(int i7, boolean z7, String str, long j7, String str2, double d7, EnumC0992a enumC0992a, boolean z8, String str3, boolean z9, int i8) {
        m.e(enumC0992a, "errorType");
        m.e(str3, "videoFormat");
        this.f16839a = i7;
        this.f16840b = z7;
        this.f16841c = str;
        this.f16842d = j7;
        this.f16843e = str2;
        this.f16844f = d7;
        this.f16845g = enumC0992a;
        this.f16846h = z8;
        this.f16847i = str3;
        this.f16848j = z9;
        this.f16849k = i8;
    }

    public static /* synthetic */ C1143c b(C1143c c1143c, int i7, boolean z7, String str, long j7, String str2, double d7, EnumC0992a enumC0992a, boolean z8, String str3, boolean z9, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = c1143c.f16839a;
        }
        return c1143c.a(i7, (i9 & 2) != 0 ? c1143c.f16840b : z7, (i9 & 4) != 0 ? c1143c.f16841c : str, (i9 & 8) != 0 ? c1143c.f16842d : j7, (i9 & 16) != 0 ? c1143c.f16843e : str2, (i9 & 32) != 0 ? c1143c.f16844f : d7, (i9 & 64) != 0 ? c1143c.f16845g : enumC0992a, (i9 & 128) != 0 ? c1143c.f16846h : z8, (i9 & 256) != 0 ? c1143c.f16847i : str3, (i9 & 512) != 0 ? c1143c.f16848j : z9, (i9 & 1024) != 0 ? c1143c.f16849k : i8);
    }

    public final C1143c a(int i7, boolean z7, String str, long j7, String str2, double d7, EnumC0992a enumC0992a, boolean z8, String str3, boolean z9, int i8) {
        m.e(enumC0992a, "errorType");
        m.e(str3, "videoFormat");
        return new C1143c(i7, z7, str, j7, str2, d7, enumC0992a, z8, str3, z9, i8);
    }

    public final boolean c() {
        return this.f16846h;
    }

    public final double d() {
        return this.f16844f;
    }

    public final EnumC0992a e() {
        return this.f16845g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1143c)) {
            return false;
        }
        C1143c c1143c = (C1143c) obj;
        return this.f16839a == c1143c.f16839a && this.f16840b == c1143c.f16840b && m.a(this.f16841c, c1143c.f16841c) && this.f16842d == c1143c.f16842d && m.a(this.f16843e, c1143c.f16843e) && Double.compare(this.f16844f, c1143c.f16844f) == 0 && this.f16845g == c1143c.f16845g && this.f16846h == c1143c.f16846h && m.a(this.f16847i, c1143c.f16847i) && this.f16848j == c1143c.f16848j && this.f16849k == c1143c.f16849k;
    }

    public final String f() {
        return this.f16841c;
    }

    public final int g() {
        return this.f16849k;
    }

    public final String h() {
        return this.f16843e;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.f16839a) * 31) + Boolean.hashCode(this.f16840b)) * 31;
        String str = this.f16841c;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.f16842d)) * 31;
        String str2 = this.f16843e;
        return ((((((((((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Double.hashCode(this.f16844f)) * 31) + this.f16845g.hashCode()) * 31) + Boolean.hashCode(this.f16846h)) * 31) + this.f16847i.hashCode()) * 31) + Boolean.hashCode(this.f16848j)) * 31) + Integer.hashCode(this.f16849k);
    }

    public final long i() {
        return this.f16842d;
    }

    public final boolean j() {
        return this.f16840b;
    }

    public final boolean k() {
        return this.f16848j;
    }

    public final String l() {
        return this.f16847i;
    }

    public String toString() {
        return "Result(index=" + this.f16839a + ", success=" + this.f16840b + ", failureMessage=" + this.f16841c + ", size=" + this.f16842d + ", path=" + this.f16843e + ", duration=" + this.f16844f + ", errorType=" + this.f16845g + ", cancelled=" + this.f16846h + ", videoFormat=" + this.f16847i + ", targetSizeMet=" + this.f16848j + ", passesUsed=" + this.f16849k + ')';
    }

    public /* synthetic */ C1143c(int i7, boolean z7, String str, long j7, String str2, double d7, EnumC0992a enumC0992a, boolean z8, String str3, boolean z9, int i8, int i9, g gVar) {
        this(i7, z7, str, (i9 & 8) != 0 ? 0L : j7, (i9 & 16) != 0 ? null : str2, (i9 & 32) != 0 ? 0.0d : d7, (i9 & 64) != 0 ? EnumC0992a.f15178o : enumC0992a, (i9 & 128) != 0 ? false : z8, (i9 & 256) != 0 ? "h264" : str3, (i9 & 512) != 0 ? true : z9, (i9 & 1024) != 0 ? 1 : i8);
    }
}
