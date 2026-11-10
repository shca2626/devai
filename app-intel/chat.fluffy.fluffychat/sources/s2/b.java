package s2;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import p2.InterfaceC1439a;
import s2.g;

/* loaded from: classes.dex */
public final class b implements g {
    @Override // s2.g
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Object b(InterfaceC1439a interfaceC1439a, Bitmap bitmap, y2.h hVar, r2.m mVar, C5.e eVar) {
        Resources resources = mVar.e().getResources();
        M5.m.d(resources, "context.resources");
        return new e(new BitmapDrawable(resources, bitmap), false, r2.e.MEMORY);
    }

    @Override // s2.g
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean a(Bitmap bitmap) {
        return g.a.a(this, bitmap);
    }

    @Override // s2.g
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public String c(Bitmap bitmap) {
        M5.m.e(bitmap, "data");
        return null;
    }
}
