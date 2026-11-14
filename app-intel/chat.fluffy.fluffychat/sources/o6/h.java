package o6;

import k6.B;
import k6.u;

/* loaded from: classes3.dex */
public final class h extends B {

    /* renamed from: l, reason: collision with root package name */
    public final String f20499l;

    /* renamed from: m, reason: collision with root package name */
    public final long f20500m;

    /* renamed from: n, reason: collision with root package name */
    public final v6.g f20501n;

    public h(String str, long j7, v6.g gVar) {
        this.f20499l = str;
        this.f20500m = j7;
        this.f20501n = gVar;
    }

    @Override // k6.B
    public long a() {
        return this.f20500m;
    }

    @Override // k6.B
    public u d() {
        String str = this.f20499l;
        if (str != null) {
            return u.b(str);
        }
        return null;
    }

    @Override // k6.B
    public v6.g i() {
        return this.f20501n;
    }
}
