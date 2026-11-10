package v4;

import M5.g;
import M5.m;
import android.media.AudioDeviceInfo;
import java.util.Map;
import y5.AbstractC1817l;
import z5.C1863G;

/* renamed from: v4.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1686c {

    /* renamed from: s, reason: collision with root package name */
    public static final a f23022s = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f23023a;

    /* renamed from: b, reason: collision with root package name */
    public int f23024b;

    /* renamed from: c, reason: collision with root package name */
    public int f23025c;

    /* renamed from: d, reason: collision with root package name */
    public int f23026d;

    /* renamed from: e, reason: collision with root package name */
    public final AudioDeviceInfo f23027e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f23028f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f23029g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f23030h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f23031i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f23032j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f23033k;

    /* renamed from: l, reason: collision with root package name */
    public final int f23034l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f23035m;

    /* renamed from: n, reason: collision with root package name */
    public final int f23036n;

    /* renamed from: o, reason: collision with root package name */
    public final Integer f23037o;

    /* renamed from: p, reason: collision with root package name */
    public final Map f23038p;

    /* renamed from: q, reason: collision with root package name */
    public final EnumC1685b f23039q;

    /* renamed from: r, reason: collision with root package name */
    public final EnumC1684a f23040r;

    /* renamed from: v4.c$a */
    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0107  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final v4.C1686c a(h5.i r25, android.content.Context r26) {
            /*
                Method dump skipped, instructions count: 658
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: v4.C1686c.a.a(h5.i, android.content.Context):v4.c");
        }

        public a() {
        }
    }

    public C1686c(String str, String str2, int i7, int i8, int i9, AudioDeviceInfo audioDeviceInfo, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, int i10, boolean z13, int i11, int i12, Integer num, Map map) {
        m.e(str2, "encoder");
        m.e(map, "rawMap");
        this.f23023a = str;
        this.f23024b = i7;
        this.f23025c = i8;
        this.f23026d = i9;
        this.f23027e = audioDeviceInfo;
        this.f23028f = z7;
        this.f23029g = z8;
        this.f23030h = z9;
        this.f23031i = z10;
        this.f23032j = z11;
        this.f23033k = z12;
        this.f23034l = i10;
        this.f23035m = z13;
        this.f23036n = i11;
        this.f23037o = num;
        this.f23038p = map;
        EnumC1685b enumC1685b = i12 != 0 ? (i12 == 1 || i12 != 2) ? EnumC1685b.f23018m : EnumC1685b.f23019n : EnumC1685b.f23017l;
        this.f23039q = enumC1685b;
        this.f23040r = EnumC1684a.f23004m.a(str2);
    }

    public final C1686c a() {
        return new C1686c(this.f23023a, this.f23040r.e(), this.f23024b, this.f23025c, this.f23026d, this.f23027e, this.f23028f, this.f23029g, this.f23030h, this.f23031i, this.f23032j, this.f23033k, this.f23034l, this.f23035m, this.f23036n, this.f23039q.ordinal(), this.f23037o, this.f23038p);
    }

    public final EnumC1685b b() {
        return this.f23039q;
    }

    public final int c() {
        return this.f23036n;
    }

    public final int d() {
        return this.f23034l;
    }

    public final boolean e() {
        return this.f23028f;
    }

    public final int f() {
        return this.f23024b;
    }

    public final AudioDeviceInfo g() {
        return this.f23027e;
    }

    public final boolean h() {
        return this.f23029g;
    }

    public final EnumC1684a i() {
        return this.f23040r;
    }

    public final boolean j() {
        return this.f23033k;
    }

    public final boolean k() {
        return this.f23032j;
    }

    public final boolean l() {
        return this.f23030h;
    }

    public final int m() {
        return this.f23026d;
    }

    public final String n() {
        return this.f23023a;
    }

    public final int o() {
        return this.f23025c;
    }

    public final boolean p() {
        return this.f23035m;
    }

    public final Integer q() {
        return this.f23037o;
    }

    public final boolean r() {
        return this.f23031i;
    }

    public final boolean s(C1686c c1686c) {
        m.e(c1686c, "other");
        return (this.f23025c == c1686c.f23025c && this.f23026d == c1686c.f23026d && this.f23024b == c1686c.f23024b) ? false : true;
    }

    public final void t(int i7) {
        this.f23024b = i7;
    }

    public final void u(int i7) {
        this.f23026d = i7;
    }

    public final void v(int i7) {
        this.f23025c = i7;
    }

    public final Map w() {
        return C1863G.n(this.f23038p, C1863G.k(AbstractC1817l.a("sampleRate", Integer.valueOf(this.f23025c)), AbstractC1817l.a("numChannels", Integer.valueOf(this.f23026d)), AbstractC1817l.a("bitRate", Integer.valueOf(this.f23024b))));
    }
}
