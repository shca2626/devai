package b5;

import V4.C0588c;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import java.util.Iterator;
import u5.C1671g;

/* renamed from: b5.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0848a extends FrameLayout {

    /* renamed from: l, reason: collision with root package name */
    public FlutterMutatorsStack f13746l;

    /* renamed from: m, reason: collision with root package name */
    public float f13747m;

    /* renamed from: n, reason: collision with root package name */
    public int f13748n;

    /* renamed from: o, reason: collision with root package name */
    public int f13749o;

    /* renamed from: p, reason: collision with root package name */
    public final C0588c f13750p;

    /* renamed from: q, reason: collision with root package name */
    public Paint f13751q;

    /* renamed from: r, reason: collision with root package name */
    public ViewTreeObserver.OnGlobalFocusChangeListener f13752r;

    /* renamed from: b5.a$a, reason: collision with other inner class name */
    public class ViewTreeObserverOnGlobalFocusChangeListenerC0131a implements ViewTreeObserver.OnGlobalFocusChangeListener {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ View.OnFocusChangeListener f13753l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ View f13754m;

        public ViewTreeObserverOnGlobalFocusChangeListenerC0131a(View.OnFocusChangeListener onFocusChangeListener, View view) {
            this.f13753l = onFocusChangeListener;
            this.f13754m = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public void onGlobalFocusChanged(View view, View view2) {
            View.OnFocusChangeListener onFocusChangeListener = this.f13753l;
            View view3 = this.f13754m;
            onFocusChangeListener.onFocusChange(view3, C1671g.c(view3));
        }
    }

    public C0848a(Context context, float f7, C0588c c0588c) {
        super(context, null);
        this.f13747m = f7;
        this.f13750p = c0588c;
        this.f13751q = new Paint();
    }

    private Matrix getPlatformViewMatrix() {
        Matrix matrix = new Matrix(this.f13746l.getFinalMatrix());
        float f7 = this.f13747m;
        matrix.preScale(1.0f / f7, 1.0f / f7);
        matrix.postTranslate(-this.f13748n, -this.f13749o);
        return matrix;
    }

    public void a(FlutterMutatorsStack flutterMutatorsStack, int i7, int i8, int i9, int i10) {
        this.f13746l = flutterMutatorsStack;
        this.f13748n = i7;
        this.f13749o = i8;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i9, i10, 51);
        layoutParams.leftMargin = i7;
        layoutParams.topMargin = i8;
        setLayoutParams(layoutParams);
        setWillNotDraw(false);
    }

    public void b() {
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive() || (onGlobalFocusChangeListener = this.f13752r) == null) {
            return;
        }
        this.f13752r = null;
        viewTreeObserver.removeOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(getPlatformViewMatrix());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.save();
        Iterator<Path> it = this.f13746l.getFinalClippingPaths().iterator();
        while (it.hasNext()) {
            Path path = new Path(it.next());
            path.offset(-this.f13748n, -this.f13749o);
            canvas.clipPath(path);
        }
        if (this.f13751q.getAlpha() != ((int) (this.f13746l.getFinalOpacity() * 255.0f))) {
            this.f13751q.setAlpha((int) (this.f13746l.getFinalOpacity() * 255.0f));
            setLayerType(2, this.f13751q);
        }
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f13750p == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate(getLeft(), getTop());
        return this.f13750p.l(motionEvent, matrix);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getImportantForAccessibility() != 4) {
            return super.requestSendAccessibilityEvent(view, accessibilityEvent);
        }
        return false;
    }

    public void setOnDescendantFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        b();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.f13752r == null) {
            ViewTreeObserverOnGlobalFocusChangeListenerC0131a viewTreeObserverOnGlobalFocusChangeListenerC0131a = new ViewTreeObserverOnGlobalFocusChangeListenerC0131a(onFocusChangeListener, this);
            this.f13752r = viewTreeObserverOnGlobalFocusChangeListenerC0131a;
            viewTreeObserver.addOnGlobalFocusChangeListener(viewTreeObserverOnGlobalFocusChangeListenerC0131a);
        }
    }
}
