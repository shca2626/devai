package Q1;

import android.os.Build;
import android.window.BackEvent;

/* loaded from: classes.dex */
public abstract class p {
    public static final b a(BackEvent backEvent) {
        M5.m.e(backEvent, "backEvent");
        float touchX = backEvent.getTouchX();
        float touchY = backEvent.getTouchY();
        return new b(backEvent.getSwipeEdge(), backEvent.getProgress(), touchX, touchY, Build.VERSION.SDK_INT >= 36 ? backEvent.getFrameTimeMillis() : 0L);
    }
}
