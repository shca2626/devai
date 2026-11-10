package androidx.core.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

@Deprecated
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    private final GestureDetector f6808a;

    public s(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.f6808a.onTouchEvent(motionEvent);
    }

    public s(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.f6808a = new GestureDetector(context, onGestureListener, handler);
    }
}
