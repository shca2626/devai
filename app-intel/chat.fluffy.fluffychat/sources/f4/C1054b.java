package f4;

import M5.g;
import M5.m;
import d4.EnumC0996f;
import d4.EnumC0997g;
import java.util.List;

/* renamed from: f4.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1054b {

    /* renamed from: a, reason: collision with root package name */
    public EnumC0997g f15844a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f15845b;

    /* renamed from: c, reason: collision with root package name */
    public Integer f15846c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15847d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC1058f f15848e;

    /* renamed from: f, reason: collision with root package name */
    public List f15849f;

    /* renamed from: g, reason: collision with root package name */
    public EnumC0996f f15850g;

    /* renamed from: h, reason: collision with root package name */
    public Long f15851h;

    /* renamed from: i, reason: collision with root package name */
    public Integer f15852i;

    /* renamed from: j, reason: collision with root package name */
    public Integer f15853j;

    /* renamed from: k, reason: collision with root package name */
    public Integer f15854k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f15855l;

    /* renamed from: m, reason: collision with root package name */
    public Long f15856m;

    /* renamed from: n, reason: collision with root package name */
    public Long f15857n;

    /* renamed from: o, reason: collision with root package name */
    public Integer f15858o;

    /* renamed from: p, reason: collision with root package name */
    public Double f15859p;

    /* renamed from: q, reason: collision with root package name */
    public Double f15860q;

    /* renamed from: r, reason: collision with root package name */
    public Double f15861r;

    /* renamed from: s, reason: collision with root package name */
    public Integer f15862s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f15863t;

    public C1054b(EnumC0997g enumC0997g, boolean z7, Integer num, boolean z8, InterfaceC1058f interfaceC1058f, List list, EnumC0996f enumC0996f, Long l7, Integer num2, Integer num3, Integer num4, boolean z9, Long l8, Long l9, Integer num5, Double d7, Double d8, Double d9, Integer num6, boolean z10) {
        m.e(enumC0997g, "quality");
        m.e(list, "videoNames");
        m.e(enumC0996f, "videoFormat");
        this.f15844a = enumC0997g;
        this.f15845b = z7;
        this.f15846c = num;
        this.f15847d = z8;
        this.f15848e = interfaceC1058f;
        this.f15849f = list;
        this.f15850g = enumC0996f;
        this.f15851h = l7;
        this.f15852i = num2;
        this.f15853j = num3;
        this.f15854k = num4;
        this.f15855l = z9;
        this.f15856m = l8;
        this.f15857n = l9;
        this.f15858o = num5;
        this.f15859p = d7;
        this.f15860q = d8;
        this.f15861r = d9;
        this.f15862s = num6;
        this.f15863t = z10;
    }

    public final Integer a() {
        return this.f15853j;
    }

    public final Double b() {
        return this.f15859p;
    }

    public final Double c() {
        return this.f15860q;
    }

    public final boolean d() {
        return this.f15863t;
    }

    public final boolean e() {
        return this.f15847d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1054b)) {
            return false;
        }
        C1054b c1054b = (C1054b) obj;
        return this.f15844a == c1054b.f15844a && this.f15845b == c1054b.f15845b && m.a(this.f15846c, c1054b.f15846c) && this.f15847d == c1054b.f15847d && m.a(this.f15848e, c1054b.f15848e) && m.a(this.f15849f, c1054b.f15849f) && this.f15850g == c1054b.f15850g && m.a(this.f15851h, c1054b.f15851h) && m.a(this.f15852i, c1054b.f15852i) && m.a(this.f15853j, c1054b.f15853j) && m.a(this.f15854k, c1054b.f15854k) && this.f15855l == c1054b.f15855l && m.a(this.f15856m, c1054b.f15856m) && m.a(this.f15857n, c1054b.f15857n) && m.a(this.f15858o, c1054b.f15858o) && m.a(this.f15859p, c1054b.f15859p) && m.a(this.f15860q, c1054b.f15860q) && m.a(this.f15861r, c1054b.f15861r) && m.a(this.f15862s, c1054b.f15862s) && this.f15863t == c1054b.f15863t;
    }

    public final Integer f() {
        return this.f15862s;
    }

    public final EnumC0997g g() {
        return this.f15844a;
    }

    public final InterfaceC1058f h() {
        return this.f15848e;
    }

    public int hashCode() {
        int iHashCode = ((this.f15844a.hashCode() * 31) + Boolean.hashCode(this.f15845b)) * 31;
        Integer num = this.f15846c;
        int iHashCode2 = (((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.f15847d)) * 31;
        InterfaceC1058f interfaceC1058f = this.f15848e;
        int iHashCode3 = (((((iHashCode2 + (interfaceC1058f == null ? 0 : interfaceC1058f.hashCode())) * 31) + this.f15849f.hashCode()) * 31) + this.f15850g.hashCode()) * 31;
        Long l7 = this.f15851h;
        int iHashCode4 = (iHashCode3 + (l7 == null ? 0 : l7.hashCode())) * 31;
        Integer num2 = this.f15852i;
        int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.f15853j;
        int iHashCode6 = (iHashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.f15854k;
        int iHashCode7 = (((iHashCode6 + (num4 == null ? 0 : num4.hashCode())) * 31) + Boolean.hashCode(this.f15855l)) * 31;
        Long l8 = this.f15856m;
        int iHashCode8 = (iHashCode7 + (l8 == null ? 0 : l8.hashCode())) * 31;
        Long l9 = this.f15857n;
        int iHashCode9 = (iHashCode8 + (l9 == null ? 0 : l9.hashCode())) * 31;
        Integer num5 = this.f15858o;
        int iHashCode10 = (iHashCode9 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Double d7 = this.f15859p;
        int iHashCode11 = (iHashCode10 + (d7 == null ? 0 : d7.hashCode())) * 31;
        Double d8 = this.f15860q;
        int iHashCode12 = (iHashCode11 + (d8 == null ? 0 : d8.hashCode())) * 31;
        Double d9 = this.f15861r;
        int iHashCode13 = (iHashCode12 + (d9 == null ? 0 : d9.hashCode())) * 31;
        Integer num6 = this.f15862s;
        return ((iHashCode13 + (num6 != null ? num6.hashCode() : 0)) * 31) + Boolean.hashCode(this.f15863t);
    }

    public final Integer i() {
        return this.f15858o;
    }

    public final Double j() {
        return this.f15861r;
    }

    public final Long k() {
        return this.f15851h;
    }

    public final Long l() {
        return this.f15857n;
    }

    public final Long m() {
        return this.f15856m;
    }

    public final boolean n() {
        return this.f15855l;
    }

    public final Integer o() {
        return this.f15846c;
    }

    public final EnumC0996f p() {
        return this.f15850g;
    }

    public final Integer q() {
        return this.f15852i;
    }

    public final List r() {
        return this.f15849f;
    }

    public final boolean s() {
        return this.f15845b;
    }

    public String toString() {
        return "Configuration(quality=" + this.f15844a + ", isMinBitrateCheckEnabled=" + this.f15845b + ", videoBitrateInMbps=" + this.f15846c + ", disableAudio=" + this.f15847d + ", resizer=" + this.f15848e + ", videoNames=" + this.f15849f + ", videoFormat=" + this.f15850g + ", targetSizeBytes=" + this.f15851h + ", videoFps=" + this.f15852i + ", audioBitrate=" + this.f15853j + ", audioSampleRate=" + this.f15854k + ", twoPass=" + this.f15855l + ", trimStartMs=" + this.f15856m + ", trimEndMs=" + this.f15857n + ", rotationDegrees=" + this.f15858o + ", brightness=" + this.f15859p + ", contrast=" + this.f15860q + ", saturation=" + this.f15861r + ", maxConcurrent=" + this.f15862s + ", debugLogging=" + this.f15863t + ')';
    }

    public /* synthetic */ C1054b(EnumC0997g enumC0997g, boolean z7, Integer num, boolean z8, InterfaceC1058f interfaceC1058f, List list, EnumC0996f enumC0996f, Long l7, Integer num2, Integer num3, Integer num4, boolean z9, Long l8, Long l9, Integer num5, Double d7, Double d8, Double d9, Integer num6, boolean z10, int i7, g gVar) {
        this((i7 & 1) != 0 ? EnumC0997g.f15231n : enumC0997g, (i7 & 2) != 0 ? true : z7, (i7 & 4) != 0 ? null : num, (i7 & 8) != 0 ? false : z8, (i7 & 16) != 0 ? InterfaceC1058f.f15872a.b() : interfaceC1058f, list, (i7 & 64) != 0 ? EnumC0996f.f15225l : enumC0996f, (i7 & 128) != 0 ? null : l7, (i7 & 256) != 0 ? null : num2, (i7 & 512) != 0 ? null : num3, (i7 & 1024) != 0 ? null : num4, (i7 & 2048) != 0 ? false : z9, (i7 & 4096) != 0 ? null : l8, (i7 & 8192) != 0 ? null : l9, (i7 & 16384) != 0 ? null : num5, (32768 & i7) != 0 ? null : d7, (65536 & i7) != 0 ? null : d8, (131072 & i7) != 0 ? null : d9, (262144 & i7) != 0 ? null : num6, (i7 & 524288) != 0 ? false : z10);
    }
}
