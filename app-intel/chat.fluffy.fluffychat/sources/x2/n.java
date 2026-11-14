package x2;

import android.graphics.drawable.Drawable;
import x2.j;

/* loaded from: classes.dex */
public final class n extends j {

    /* renamed from: a, reason: collision with root package name */
    public final Drawable f23576a;

    /* renamed from: b, reason: collision with root package name */
    public final i f23577b;

    /* renamed from: c, reason: collision with root package name */
    public final j.a f23578c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Drawable drawable, i iVar, j.a aVar) {
        super(null);
        M5.m.e(drawable, "drawable");
        M5.m.e(iVar, "request");
        M5.m.e(aVar, "metadata");
        this.f23576a = drawable;
        this.f23577b = iVar;
        this.f23578c = aVar;
    }

    @Override // x2.j
    public Drawable a() {
        return this.f23576a;
    }

    @Override // x2.j
    public i b() {
        return this.f23577b;
    }

    public final j.a c() {
        return this.f23578c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return M5.m.a(a(), nVar.a()) && M5.m.a(b(), nVar.b()) && M5.m.a(this.f23578c, nVar.f23578c);
    }

    public int hashCode() {
        return (((a().hashCode() * 31) + b().hashCode()) * 31) + this.f23578c.hashCode();
    }

    public String toString() {
        return "SuccessResult(drawable=" + a() + ", request=" + b() + ", metadata=" + this.f23578c + ')';
    }
}
