package v4;

import M5.g;
import M5.m;
import android.media.AudioDeviceInfo;
import java.util.Map;
import y5.AbstractC1816l;
import z5.C1866G;

/* renamed from: v4.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1685c {

    /* renamed from: s, reason: collision with root package name */
    public static final a f23028s = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f23029a;

    /* renamed from: b, reason: collision with root package name */
    public int f23030b;

    /* renamed from: c, reason: collision with root package name */
    public int f23031c;

    /* renamed from: d, reason: collision with root package name */
    public int f23032d;

    /* renamed from: e, reason: collision with root package name */
    public final AudioDeviceInfo f23033e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f23034f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f23035g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f23036h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f23037i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f23038j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f23039k;

    /* renamed from: l, reason: collision with root package name */
    public final int f23040l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f23041m;

    /* renamed from: n, reason: collision with root package name */
    public final int f23042n;

    /* renamed from: o, reason: collision with root package name */
    public final Integer f23043o;

    /* renamed from: p, reason: collision with root package name */
    public final Map f23044p;

    /* renamed from: q, reason: collision with root package name */
    public final EnumC1684b f23045q;

    /* renamed from: r, reason: collision with root package name */
    public final EnumC1683a f23046r;

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
        public final v4.C1685c a(h5.i r25, android.content.Context r26) {
            /*
                Method dump skipped, instructions count: 658
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: v4.C1685c.a.a(h5.i, android.content.Context):v4.c");
        }

        public a() {
        }
    }

    public C1685c(String str, String str2, int i7, int i8, int i9, AudioDeviceInfo audioDeviceInfo, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, int i10, boolean z13, int i11, int i12, Integer num, Map map) {
        m.e(str2, "encoder");
        m.e(map, "rawMap");
        this.f23029a = str;
        this.f23030b = i7;
        this.f23031c = i8;
        this.f23032d = i9;
        this.f23033e = audioDeviceInfo;
        this.f23034f = z7;
        this.f23035g = z8;
        this.f23036h = z9;
        this.f23037i = z10;
        this.f23038j = z11;
        this.f23039k = z12;
        this.f23040l = i10;
        this.f23041m = z13;
        this.f23042n = i11;
        this.f23043o = num;
        this.f23044p = map;
        EnumC1684b enumC1684b = i12 != 0 ? (i12 == 1 || i12 != 2) ? EnumC1684b.f23024m : EnumC1684b.f23025n : EnumC1684b.f23023l;
        this.f23045q = enumC1684b;
        this.f23046r = EnumC1683a.f23010m.a(str2);
    }

    public final C1685c a() {
        return new C1685c(this.f23029a, this.f23046r.e(), this.f23030b, this.f23031c, this.f23032d, this.f23033e, this.f23034f, this.f23035g, this.f23036h, this.f23037i, this.f23038j, this.f23039k, this.f23040l, this.f23041m, this.f23042n, this.f23045q.ordinal(), this.f23043o, this.f23044p);
    }

    public final EnumC1684b b() {
        return this.f23045q;
    }

    public final int c() {
        return this.f23042n;
    }

    public final int d() {
        return this.f23040l;
    }

    public final boolean e() {
        return this.f23034f;
    }

    public final int f() {
        return this.f23030b;
    }

    public final AudioDeviceInfo g() {
        return this.f23033e;
    }

    public final boolean h() {
        return this.f23035g;
    }

    public final EnumC1683a i() {
        return this.f23046r;
    }

    public final boolean j() {
        return this.f23039k;
    }

    public final boolean k() {
        return this.f23038j;
    }

    public final boolean l() {
        return this.f23036h;
    }

    public final int m() {
        return this.f23032d;
    }

    public final String n() {
        return this.f23029a;
    }

    public final int o() {
        return this.f23031c;
    }

    public final boolean p() {
        return this.f23041m;
    }

    public final Integer q() {
        return this.f23043o;
    }

    public final boolean r() {
        return this.f23037i;
    }

    public final boolean s(C1685c c1685c) {
        m.e(c1685c, "other");
        return (this.f23031c == c1685c.f23031c && this.f23032d == c1685c.f23032d && this.f23030b == c1685c.f23030b) ? false : true;
    }

    public final void t(int i7) {
        this.f23030b = i7;
    }

    public final void u(int i7) {
        this.f23032d = i7;
    }

    public final void v(int i7) {
        this.f23031c = i7;
    }

    public final Map w() {
        return C1866G.n(this.f23044p, C1866G.k(AbstractC1816l.a("sampleRate", Integer.valueOf(this.f23031c)), AbstractC1816l.a("numChannels", Integer.valueOf(this.f23032d)), AbstractC1816l.a("bitRate", Integer.valueOf(this.f23030b))));
    }
}
