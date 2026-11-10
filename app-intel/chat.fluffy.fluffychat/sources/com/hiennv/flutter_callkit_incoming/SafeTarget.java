package com.hiennv.flutter_callkit_incoming;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import z2.c;

/* loaded from: classes.dex */
public class SafeTarget implements z2.c {
    private boolean isCancelled;
    private final int notificationId;
    private final L5.l onLoaded;

    public SafeTarget(int i7, L5.l lVar) {
        M5.m.e(lVar, "onLoaded");
        this.notificationId = i7;
        this.onLoaded = lVar;
    }

    public final boolean isCancelled() {
        return this.isCancelled;
    }

    @Override // z2.c
    public void onError(Drawable drawable) {
        c.a.a(this, drawable);
        Log.d("onError", "-");
    }

    @Override // z2.c
    public void onStart(Drawable drawable) {
        c.a.b(this, drawable);
        Log.d("onStart", "-");
    }

    @Override // z2.c
    public void onSuccess(Drawable drawable) {
        M5.m.e(drawable, "result");
        c.a.c(this, drawable);
        Log.d("onSuccess", "-");
        if (this.isCancelled) {
            return;
        }
        L5.l lVar = this.onLoaded;
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        M5.m.d(bitmap, "getBitmap(...)");
        lVar.a(bitmap);
    }

    public final void setCancelled(boolean z7) {
        this.isCancelled = z7;
    }
}
