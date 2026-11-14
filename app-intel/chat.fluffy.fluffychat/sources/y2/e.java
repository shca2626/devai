package y2;

import M5.m;

/* loaded from: classes.dex */
public final class e implements i {

    /* renamed from: c, reason: collision with root package name */
    public final h f23988c;

    public e(h hVar) {
        m.e(hVar, "size");
        this.f23988c = hVar;
    }

    @Override // y2.i
    public Object c(C5.e eVar) {
        return this.f23988c;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof e) && m.a(this.f23988c, ((e) obj).f23988c);
        }
        return true;
    }

    public int hashCode() {
        return this.f23988c.hashCode();
    }

    public String toString() {
        return "RealSizeResolver(size=" + this.f23988c + ')';
    }
}
