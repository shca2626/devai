package com.hiennv.flutter_callkit_incoming.widgets;

import A2.a;
import C5.e;
import M5.m;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import p2.InterfaceC1439a;
import y2.h;

/* loaded from: classes.dex */
public final class CircleTransform implements a {
    @Override // A2.a
    public String key() {
        return "circle";
    }

    @Override // A2.a
    public Object transform(InterfaceC1439a interfaceC1439a, Bitmap bitmap, h hVar, e eVar) {
        int iMin = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - iMin) / 2, (bitmap.getHeight() - iMin) / 2, iMin, iMin);
        m.d(bitmapCreateBitmap, "createBitmap(...)");
        if (!m.a(bitmapCreateBitmap, bitmap)) {
            bitmap.recycle();
        }
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(iMin, iMin, config);
        m.d(bitmapCreateBitmap2, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap2);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmapCreateBitmap, tileMode, tileMode));
        paint.setAntiAlias(true);
        float f7 = iMin / 2.0f;
        canvas.drawCircle(f7, f7, f7, paint);
        bitmapCreateBitmap.recycle();
        return bitmapCreateBitmap2;
    }
}
