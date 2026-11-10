package W2;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public class a implements View.OnTouchListener {

    /* renamed from: l, reason: collision with root package name */
    public final Dialog f8956l;

    /* renamed from: m, reason: collision with root package name */
    public final int f8957m;

    /* renamed from: n, reason: collision with root package name */
    public final int f8958n;

    /* renamed from: o, reason: collision with root package name */
    public final int f8959o;

    public a(Dialog dialog, Rect rect) {
        this.f8956l = dialog;
        this.f8957m = rect.left;
        this.f8958n = rect.top;
        this.f8959o = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View viewFindViewById = view.findViewById(R.id.content);
        int left = this.f8957m + viewFindViewById.getLeft();
        int width = viewFindViewById.getWidth() + left;
        if (new RectF(left, this.f8958n + viewFindViewById.getTop(), width, viewFindViewById.getHeight() + r3).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            motionEventObtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            motionEventObtain.setAction(0);
            int i7 = this.f8959o;
            motionEventObtain.setLocation((-i7) - 1, (-i7) - 1);
        }
        view.performClick();
        return this.f8956l.onTouchEvent(motionEventObtain);
    }
}
