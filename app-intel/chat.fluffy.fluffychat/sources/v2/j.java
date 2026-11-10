package v2;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import p2.InterfaceC1441c;
import y5.C1824s;

/* loaded from: classes.dex */
public final class j extends v {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1441c f22923a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(InterfaceC1441c interfaceC1441c) {
        super(null);
        M5.m.e(interfaceC1441c, "referenceCounter");
        this.f22923a = interfaceC1441c;
    }

    @Override // v2.v
    public Object f(x2.n nVar, C5.e eVar) {
        InterfaceC1441c interfaceC1441c = this.f22923a;
        Drawable drawableA = nVar.a();
        BitmapDrawable bitmapDrawable = drawableA instanceof BitmapDrawable ? (BitmapDrawable) drawableA : null;
        Bitmap bitmap = bitmapDrawable != null ? bitmapDrawable.getBitmap() : null;
        if (bitmap != null) {
            interfaceC1441c.a(bitmap, false);
        }
        return C1824s.f24014a;
    }
}
