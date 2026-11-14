package r2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.os.Build;
import k6.r;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final Context f22149a;

    /* renamed from: b, reason: collision with root package name */
    public final Bitmap.Config f22150b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorSpace f22151c;

    /* renamed from: d, reason: collision with root package name */
    public final y2.g f22152d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f22153e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f22154f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f22155g;

    /* renamed from: h, reason: collision with root package name */
    public final r f22156h;

    /* renamed from: i, reason: collision with root package name */
    public final x2.m f22157i;

    /* renamed from: j, reason: collision with root package name */
    public final x2.b f22158j;

    /* renamed from: k, reason: collision with root package name */
    public final x2.b f22159k;

    /* renamed from: l, reason: collision with root package name */
    public final x2.b f22160l;

    public m(Context context, Bitmap.Config config, ColorSpace colorSpace, y2.g gVar, boolean z7, boolean z8, boolean z9, r rVar, x2.m mVar, x2.b bVar, x2.b bVar2, x2.b bVar3) {
        M5.m.e(context, "context");
        M5.m.e(config, "config");
        M5.m.e(gVar, "scale");
        M5.m.e(rVar, "headers");
        M5.m.e(mVar, "parameters");
        M5.m.e(bVar, "memoryCachePolicy");
        M5.m.e(bVar2, "diskCachePolicy");
        M5.m.e(bVar3, "networkCachePolicy");
        this.f22149a = context;
        this.f22150b = config;
        this.f22151c = colorSpace;
        this.f22152d = gVar;
        this.f22153e = z7;
        this.f22154f = z8;
        this.f22155g = z9;
        this.f22156h = rVar;
        this.f22157i = mVar;
        this.f22158j = bVar;
        this.f22159k = bVar2;
        this.f22160l = bVar3;
    }

    public final boolean a() {
        return this.f22153e;
    }

    public final boolean b() {
        return this.f22154f;
    }

    public final ColorSpace c() {
        return this.f22151c;
    }

    public final Bitmap.Config d() {
        return this.f22150b;
    }

    public final Context e() {
        return this.f22149a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (M5.m.a(this.f22149a, mVar.f22149a) && this.f22150b == mVar.f22150b) {
            return (Build.VERSION.SDK_INT < 26 || M5.m.a(this.f22151c, mVar.f22151c)) && this.f22152d == mVar.f22152d && this.f22153e == mVar.f22153e && this.f22154f == mVar.f22154f && this.f22155g == mVar.f22155g && M5.m.a(this.f22156h, mVar.f22156h) && M5.m.a(this.f22157i, mVar.f22157i) && this.f22158j == mVar.f22158j && this.f22159k == mVar.f22159k && this.f22160l == mVar.f22160l;
        }
        return false;
    }

    public final x2.b f() {
        return this.f22159k;
    }

    public final r g() {
        return this.f22156h;
    }

    public final x2.b h() {
        return this.f22160l;
    }

    public int hashCode() {
        int iHashCode = ((this.f22149a.hashCode() * 31) + this.f22150b.hashCode()) * 31;
        ColorSpace colorSpace = this.f22151c;
        return ((((((((((((((((((iHashCode + (colorSpace == null ? 0 : colorSpace.hashCode())) * 31) + this.f22152d.hashCode()) * 31) + Boolean.hashCode(this.f22153e)) * 31) + Boolean.hashCode(this.f22154f)) * 31) + Boolean.hashCode(this.f22155g)) * 31) + this.f22156h.hashCode()) * 31) + this.f22157i.hashCode()) * 31) + this.f22158j.hashCode()) * 31) + this.f22159k.hashCode()) * 31) + this.f22160l.hashCode();
    }

    public final boolean i() {
        return this.f22155g;
    }

    public final y2.g j() {
        return this.f22152d;
    }

    public String toString() {
        return "Options(context=" + this.f22149a + ", config=" + this.f22150b + ", colorSpace=" + this.f22151c + ", scale=" + this.f22152d + ", allowInexactSize=" + this.f22153e + ", allowRgb565=" + this.f22154f + ", premultipliedAlpha=" + this.f22155g + ", headers=" + this.f22156h + ", parameters=" + this.f22157i + ", memoryCachePolicy=" + this.f22158j + ", diskCachePolicy=" + this.f22159k + ", networkCachePolicy=" + this.f22160l + ')';
    }
}
