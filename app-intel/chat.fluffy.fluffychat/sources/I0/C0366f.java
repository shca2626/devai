package I0;

import android.text.TextUtils;

/* renamed from: I0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0366f {

    /* renamed from: a, reason: collision with root package name */
    public final String f3969a;

    /* renamed from: b, reason: collision with root package name */
    public final B0.s f3970b;

    /* renamed from: c, reason: collision with root package name */
    public final B0.s f3971c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3972d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3973e;

    public C0366f(String str, B0.s sVar, B0.s sVar2, int i7, int i8) {
        j3.o.d(i7 == 0 || i8 == 0);
        j3.o.d(true ^ TextUtils.isEmpty(str));
        this.f3969a = str;
        this.f3970b = (B0.s) j3.o.q(sVar);
        this.f3971c = (B0.s) j3.o.q(sVar2);
        this.f3972d = i7;
        this.f3973e = i8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0366f.class == obj.getClass()) {
            C0366f c0366f = (C0366f) obj;
            if (this.f3972d == c0366f.f3972d && this.f3973e == c0366f.f3973e && this.f3969a.equals(c0366f.f3969a) && this.f3970b.equals(c0366f.f3970b) && this.f3971c.equals(c0366f.f3971c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + this.f3972d) * 31) + this.f3973e) * 31) + this.f3969a.hashCode()) * 31) + this.f3970b.hashCode()) * 31) + this.f3971c.hashCode();
    }
}
