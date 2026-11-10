package Z0;

import B0.s;
import G0.w;
import Y0.A;
import android.net.Uri;
import c1.m;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class f implements m.e {

    /* renamed from: a, reason: collision with root package name */
    public final long f10119a = A.b();

    /* renamed from: b, reason: collision with root package name */
    public final G0.j f10120b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10121c;

    /* renamed from: d, reason: collision with root package name */
    public final s f10122d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10123e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f10124f;

    /* renamed from: g, reason: collision with root package name */
    public final long f10125g;

    /* renamed from: h, reason: collision with root package name */
    public final long f10126h;

    /* renamed from: i, reason: collision with root package name */
    public final w f10127i;

    public f(G0.f fVar, G0.j jVar, int i7, s sVar, int i8, Object obj, long j7, long j8) {
        this.f10127i = new w(fVar);
        this.f10120b = (G0.j) j3.o.q(jVar);
        this.f10121c = i7;
        this.f10122d = sVar;
        this.f10123e = i8;
        this.f10124f = obj;
        this.f10125g = j7;
        this.f10126h = j8;
    }

    public final long b() {
        return this.f10127i.f();
    }

    public final long d() {
        return this.f10126h - this.f10125g;
    }

    public final Map e() {
        return this.f10127i.v();
    }

    public final Uri f() {
        return this.f10127i.u();
    }
}
