package Z;

import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class T {

    /* renamed from: a, reason: collision with root package name */
    public static Map f9962a = Collections.synchronizedMap(new WeakHashMap());

    public static class a {
        public static float a(VelocityTracker velocityTracker, int i7) {
            return velocityTracker.getAxisVelocity(i7);
        }
    }

    public static void a(VelocityTracker velocityTracker, MotionEvent motionEvent) {
        velocityTracker.addMovement(motionEvent);
        if (Build.VERSION.SDK_INT < 34 && motionEvent.getSource() == 4194304) {
            if (!f9962a.containsKey(velocityTracker)) {
                f9962a.put(velocityTracker, new U());
            }
            ((U) f9962a.get(velocityTracker)).a(motionEvent);
        }
    }

    public static void b(VelocityTracker velocityTracker, int i7) {
        c(velocityTracker, i7, Float.MAX_VALUE);
    }

    public static void c(VelocityTracker velocityTracker, int i7, float f7) {
        velocityTracker.computeCurrentVelocity(i7, f7);
        U uE = e(velocityTracker);
        if (uE != null) {
            uE.c(i7, f7);
        }
    }

    public static float d(VelocityTracker velocityTracker, int i7) {
        if (Build.VERSION.SDK_INT >= 34) {
            return a.a(velocityTracker, i7);
        }
        if (i7 == 0) {
            return velocityTracker.getXVelocity();
        }
        if (i7 == 1) {
            return velocityTracker.getYVelocity();
        }
        U uE = e(velocityTracker);
        if (uE != null) {
            return uE.d(i7);
        }
        return 0.0f;
    }

    public static U e(VelocityTracker velocityTracker) {
        return (U) f9962a.get(velocityTracker);
    }
}
