package Z;

import android.view.MotionEvent;

/* loaded from: classes.dex */
public abstract class D {
    public static boolean a(MotionEvent motionEvent, int i7) {
        return (motionEvent.getSource() & i7) == i7;
    }
}
