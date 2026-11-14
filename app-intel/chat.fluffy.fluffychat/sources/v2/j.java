package v2;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import p2.InterfaceC1440c;
import y5.C1823s;

/* loaded from: classes.dex */
public final class j extends v {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1440c f22929a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(InterfaceC1440c interfaceC1440c) {
        super(null);
        M5.m.e(interfaceC1440c, "referenceCounter");
        this.f22929a = interfaceC1440c;
    }

    @Override // v2.v
    public Object f(x2.n nVar, C5.e eVar) {
        InterfaceC1440c interfaceC1440c = this.f22929a;
        Drawable drawableA = nVar.a();
        BitmapDrawable bitmapDrawable = drawableA instanceof BitmapDrawable ? (BitmapDrawable) drawableA : null;
        Bitmap bitmap = bitmapDrawable != null ? bitmapDrawable.getBitmap() : null;
        if (bitmap != null) {
            interfaceC1440c.a(bitmap, false);
        }
        return C1823s.f24020a;
    }
}
