package r2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.os.Build;
import k6.r;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final Context f22143a;

    /* renamed from: b, reason: collision with root package name */
    public final Bitmap.Config f22144b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorSpace f22145c;

    /* renamed from: d, reason: collision with root package name */
    public final y2.g f22146d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f22147e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f22148f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f22149g;

    /* renamed from: h, reason: collision with root package name */
    public final r f22150h;

    /* renamed from: i, reason: collision with root package name */
    public final x2.m f22151i;

    /* renamed from: j, reason: collision with root package name */
    public final x2.b f22152j;

    /* renamed from: k, reason: collision with root package name */
    public final x2.b f22153k;

    /* renamed from: l, reason: collision with root package name */
    public final x2.b f22154l;

    public m(Context context, Bitmap.Config config, ColorSpace colorSpace, y2.g gVar, boolean z7, boolean z8, boolean z9, r rVar, x2.m mVar, x2.b bVar, x2.b bVar2, x2.b bVar3) {
        M5.m.e(context, "context");
        M5.m.e(config, "config");
        M5.m.e(gVar, "scale");
        M5.m.e(rVar, "headers");
        M5.m.e(mVar, "parameters");
        M5.m.e(bVar, "memoryCachePolicy");
        M5.m.e(bVar2, "diskCachePolicy");
        M5.m.e(bVar3, "networkCachePolicy");
        this.f22143a = context;
        this.f22144b = config;
        this.f22145c = colorSpace;
        this.f22146d = gVar;
        this.f22147e = z7;
        this.f22148f = z8;
        this.f22149g = z9;
        this.f22150h = rVar;
        this.f22151i = mVar;
        this.f22152j = bVar;
        this.f22153k = bVar2;
        this.f22154l = bVar3;
    }

    public final boolean a() {
        return this.f22147e;
    }

    public final boolean b() {
        return this.f22148f;
    }

    public final ColorSpace c() {
        return this.f22145c;
    }

    public final Bitmap.Config d() {
        return this.f22144b;
    }

    public final Context e() {
        return this.f22143a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (M5.m.a(this.f22143a, mVar.f22143a) && this.f22144b == mVar.f22144b) {
            return (Build.VERSION.SDK_INT < 26 || M5.m.a(this.f22145c, mVar.f22145c)) && this.f22146d == mVar.f22146d && this.f22147e == mVar.f22147e && this.f22148f == mVar.f22148f && this.f22149g == mVar.f22149g && M5.m.a(this.f22150h, mVar.f22150h) && M5.m.a(this.f22151i, mVar.f22151i) && this.f22152j == mVar.f22152j && this.f22153k == mVar.f22153k && this.f22154l == mVar.f22154l;
        }
        return false;
    }

    public final x2.b f() {
        return this.f22153k;
    }

    public final r g() {
        return this.f22150h;
    }

    public final x2.b h() {
        return this.f22154l;
    }

    public int hashCode() {
        int iHashCode = ((this.f22143a.hashCode() * 31) + this.f22144b.hashCode()) * 31;
        ColorSpace colorSpace = this.f22145c;
        return ((((((((((((((((((iHashCode + (colorSpace == null ? 0 : colorSpace.hashCode())) * 31) + this.f22146d.hashCode()) * 31) + Boolean.hashCode(this.f22147e)) * 31) + Boolean.hashCode(this.f22148f)) * 31) + Boolean.hashCode(this.f22149g)) * 31) + this.f22150h.hashCode()) * 31) + this.f22151i.hashCode()) * 31) + this.f22152j.hashCode()) * 31) + this.f22153k.hashCode()) * 31) + this.f22154l.hashCode();
    }

    public final boolean i() {
        return this.f22149g;
    }

    public final y2.g j() {
        return this.f22146d;
    }

    public String toString() {
        return "Options(context=" + this.f22143a + ", config=" + this.f22144b + ", colorSpace=" + this.f22145c + ", scale=" + this.f22146d + ", allowInexactSize=" + this.f22147e + ", allowRgb565=" + this.f22148f + ", premultipliedAlpha=" + this.f22149g + ", headers=" + this.f22150h + ", parameters=" + this.f22151i + ", memoryCachePolicy=" + this.f22152j + ", diskCachePolicy=" + this.f22153k + ", networkCachePolicy=" + this.f22154l + ')';
    }
}
