package s2;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class e extends f {

    /* renamed from: a, reason: collision with root package name */
    public final Drawable f22395a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f22396b;

    /* renamed from: c, reason: collision with root package name */
    public final r2.e f22397c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Drawable drawable, boolean z7, r2.e eVar) {
        super(null);
        M5.m.e(drawable, "drawable");
        M5.m.e(eVar, "dataSource");
        this.f22395a = drawable;
        this.f22396b = z7;
        this.f22397c = eVar;
    }

    public static /* synthetic */ e e(e eVar, Drawable drawable, boolean z7, r2.e eVar2, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            drawable = eVar.f22395a;
        }
        if ((i7 & 2) != 0) {
            z7 = eVar.f22396b;
        }
        if ((i7 & 4) != 0) {
            eVar2 = eVar.f22397c;
        }
        return eVar.d(drawable, z7, eVar2);
    }

    public final Drawable a() {
        return this.f22395a;
    }

    public final boolean b() {
        return this.f22396b;
    }

    public final r2.e c() {
        return this.f22397c;
    }

    public final e d(Drawable drawable, boolean z7, r2.e eVar) {
        M5.m.e(drawable, "drawable");
        M5.m.e(eVar, "dataSource");
        return new e(drawable, z7, eVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return M5.m.a(this.f22395a, eVar.f22395a) && this.f22396b == eVar.f22396b && this.f22397c == eVar.f22397c;
    }

    public final Drawable f() {
        return this.f22395a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = this.f22395a.hashCode() * 31;
        boolean z7 = this.f22396b;
        int i7 = z7;
        if (z7 != 0) {
            i7 = 1;
        }
        return ((iHashCode + i7) * 31) + this.f22397c.hashCode();
    }

    public String toString() {
        return "DrawableResult(drawable=" + this.f22395a + ", isSampled=" + this.f22396b + ", dataSource=" + this.f22397c + ')';
    }
}
