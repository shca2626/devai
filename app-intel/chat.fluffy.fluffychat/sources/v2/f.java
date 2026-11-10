package v2;

import android.graphics.Bitmap;
import v2.p;

/* loaded from: classes.dex */
public final class f implements u {

    /* renamed from: b, reason: collision with root package name */
    public final y f22918b;

    public f(y yVar) {
        M5.m.e(yVar, "weakMemoryCache");
        this.f22918b = yVar;
    }

    @Override // v2.u
    public p.a b(m mVar) {
        M5.m.e(mVar, "key");
        return null;
    }

    @Override // v2.u
    public void c(m mVar, Bitmap bitmap, boolean z7) {
        M5.m.e(mVar, "key");
        M5.m.e(bitmap, "bitmap");
        this.f22918b.d(mVar, bitmap, z7, C2.a.a(bitmap));
    }

    @Override // v2.u
    public void a(int i7) {
    }
}
