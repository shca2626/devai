package Y0;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class A {

    /* renamed from: h, reason: collision with root package name */
    public static final AtomicLong f9361h = new AtomicLong();

    /* renamed from: a, reason: collision with root package name */
    public final long f9362a;

    /* renamed from: b, reason: collision with root package name */
    public final G0.j f9363b;

    /* renamed from: c, reason: collision with root package name */
    public final Uri f9364c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f9365d;

    /* renamed from: e, reason: collision with root package name */
    public final long f9366e;

    /* renamed from: f, reason: collision with root package name */
    public final long f9367f;

    /* renamed from: g, reason: collision with root package name */
    public final long f9368g;

    public A(long j7, G0.j jVar, long j8) {
        this(j7, jVar, jVar.f3143a, Collections.EMPTY_MAP, j8, 0L, 0L);
    }

    public static long b() {
        return f9361h.getAndIncrement();
    }

    public A a(long j7, long j8) {
        return new A(j7, this.f9363b, this.f9364c, this.f9365d, this.f9366e, j8, this.f9368g);
    }

    public A(long j7, G0.j jVar, Uri uri, Map map, long j8, long j9, long j10) {
        this.f9362a = j7;
        this.f9363b = jVar;
        this.f9364c = uri;
        this.f9365d = map;
        this.f9366e = j8;
        this.f9367f = j9;
        this.f9368g = j10;
    }
}
