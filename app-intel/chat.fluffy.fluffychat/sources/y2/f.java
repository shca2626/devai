package y2;

import M5.m;
import android.view.View;
import y2.j;

/* loaded from: classes.dex */
public final class f implements j {

    /* renamed from: c, reason: collision with root package name */
    public final View f23989c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f23990d;

    public f(View view, boolean z7) {
        m.e(view, "view");
        this.f23989c = view;
        this.f23990d = z7;
    }

    @Override // y2.j
    public View a() {
        return this.f23989c;
    }

    @Override // y2.j
    public boolean b() {
        return this.f23990d;
    }

    @Override // y2.i
    public Object c(C5.e eVar) {
        return j.b.h(this, eVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return m.a(a(), fVar.a()) && b() == fVar.b();
    }

    public int hashCode() {
        return (a().hashCode() * 31) + Boolean.hashCode(b());
    }

    public String toString() {
        return "RealViewSizeResolver(view=" + a() + ", subtractPadding=" + b() + ')';
    }
}
