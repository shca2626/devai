package c1;

import E0.U;
import G0.j;
import G0.w;
import Y0.A;
import android.net.Uri;
import c1.m;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/* loaded from: classes.dex */
public final class o implements m.e {

    /* renamed from: a, reason: collision with root package name */
    public final long f13942a;

    /* renamed from: b, reason: collision with root package name */
    public final G0.j f13943b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13944c;

    /* renamed from: d, reason: collision with root package name */
    public final w f13945d;

    /* renamed from: e, reason: collision with root package name */
    public final a f13946e;

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f13947f;

    public interface a {
        Object a(Uri uri, InputStream inputStream);
    }

    public o(G0.f fVar, Uri uri, int i7, a aVar) {
        this(fVar, new j.b().i(uri).b(1).a(), i7, aVar);
    }

    @Override // c1.m.e
    public final void a() throws IOException {
        this.f13945d.w();
        G0.h hVar = new G0.h(this.f13945d, this.f13943b);
        try {
            hVar.d();
            this.f13947f = this.f13946e.a((Uri) j3.o.q(this.f13945d.r()), hVar);
        } finally {
            U.m(hVar);
        }
    }

    public long b() {
        return this.f13945d.f();
    }

    public Map d() {
        return this.f13945d.v();
    }

    public final Object e() {
        return this.f13947f;
    }

    public Uri f() {
        return this.f13945d.u();
    }

    public o(G0.f fVar, G0.j jVar, int i7, a aVar) {
        this.f13945d = new w(fVar);
        this.f13943b = jVar;
        this.f13944c = i7;
        this.f13946e = aVar;
        this.f13942a = A.b();
    }

    @Override // c1.m.e
    public final void c() {
    }
}
