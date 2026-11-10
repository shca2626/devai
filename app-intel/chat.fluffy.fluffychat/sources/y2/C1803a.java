package y2;

import M5.m;
import android.content.Context;
import android.util.DisplayMetrics;

/* renamed from: y2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1803a implements i {

    /* renamed from: c, reason: collision with root package name */
    public final Context f23974c;

    public C1803a(Context context) {
        m.e(context, "context");
        this.f23974c = context;
    }

    @Override // y2.i
    public Object c(C5.e eVar) {
        DisplayMetrics displayMetrics = this.f23974c.getResources().getDisplayMetrics();
        return new c(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof C1803a) && m.a(this.f23974c, ((C1803a) obj).f23974c);
        }
        return true;
    }

    public int hashCode() {
        return this.f23974c.hashCode();
    }

    public String toString() {
        return "DisplaySizeResolver(context=" + this.f23974c + ')';
    }
}
