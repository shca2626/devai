package p2;

import M5.m;
import android.graphics.Bitmap;

/* renamed from: p2.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1442d implements InterfaceC1439a {
    @Override // p2.InterfaceC1439a
    public void b(Bitmap bitmap) {
        m.e(bitmap, "bitmap");
        bitmap.recycle();
    }

    @Override // p2.InterfaceC1439a
    public Bitmap c(int i7, int i8, Bitmap.Config config) {
        m.e(config, "config");
        return d(i7, i8, config);
    }

    @Override // p2.InterfaceC1439a
    public Bitmap d(int i7, int i8, Bitmap.Config config) {
        m.e(config, "config");
        e(config);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i7, i8, config);
        m.d(bitmapCreateBitmap, "createBitmap(width, height, config)");
        return bitmapCreateBitmap;
    }

    public final void e(Bitmap.Config config) {
        if (C2.a.d(config)) {
            throw new IllegalArgumentException("Cannot create a mutable hardware bitmap.");
        }
    }

    @Override // p2.InterfaceC1439a
    public void a(int i7) {
    }
}
