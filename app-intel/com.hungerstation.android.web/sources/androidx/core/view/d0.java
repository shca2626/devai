package androidx.core.view;

import android.view.MotionEvent;

/* loaded from: classes7.dex */
public final class d0 {
    @Deprecated
    public static int a(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    public static boolean b(MotionEvent motionEvent, int i12) {
        return (motionEvent.getSource() & i12) == i12;
    }
}
