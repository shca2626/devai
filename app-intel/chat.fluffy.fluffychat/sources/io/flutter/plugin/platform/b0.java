package io.flutter.plugin.platform;

import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowMetrics;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* loaded from: classes.dex */
public abstract class b0 implements WindowManager {

    /* renamed from: l, reason: collision with root package name */
    public final WindowManager f17809l;

    /* renamed from: m, reason: collision with root package name */
    public W f17810m;

    public b0(WindowManager windowManager, W w7) {
        this.f17809l = windowManager;
        this.f17810m = w7;
    }

    @Override // android.view.WindowManager
    public void addCrossWindowBlurEnabledListener(Consumer consumer) {
        this.f17809l.addCrossWindowBlurEnabledListener(consumer);
    }

    @Override // android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        W w7 = this.f17810m;
        if (w7 == null) {
            U4.b.g("PlatformViewsController", "Embedded view called addView while detached from presentation");
        } else {
            w7.addView(view, layoutParams);
        }
    }

    @Override // android.view.WindowManager
    public WindowMetrics getCurrentWindowMetrics() {
        return this.f17809l.getCurrentWindowMetrics();
    }

    @Override // android.view.WindowManager
    public Display getDefaultDisplay() {
        return this.f17809l.getDefaultDisplay();
    }

    @Override // android.view.WindowManager
    public WindowMetrics getMaximumWindowMetrics() {
        return this.f17809l.getMaximumWindowMetrics();
    }

    @Override // android.view.WindowManager
    public boolean isCrossWindowBlurEnabled() {
        return this.f17809l.isCrossWindowBlurEnabled();
    }

    @Override // android.view.WindowManager
    public void removeCrossWindowBlurEnabledListener(Consumer consumer) {
        this.f17809l.removeCrossWindowBlurEnabledListener(consumer);
    }

    @Override // android.view.ViewManager
    public void removeView(View view) {
        W w7 = this.f17810m;
        if (w7 == null) {
            U4.b.g("PlatformViewsController", "Embedded view called removeView while detached from presentation");
        } else {
            w7.removeView(view);
        }
    }

    @Override // android.view.WindowManager
    public void removeViewImmediate(View view) {
        if (this.f17810m == null) {
            U4.b.g("PlatformViewsController", "Embedded view called removeViewImmediate while detached from presentation");
        } else {
            view.clearAnimation();
            this.f17810m.removeView(view);
        }
    }

    @Override // android.view.ViewManager
    public void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        W w7 = this.f17810m;
        if (w7 == null) {
            U4.b.g("PlatformViewsController", "Embedded view called updateViewLayout while detached from presentation");
        } else {
            w7.updateViewLayout(view, layoutParams);
        }
    }

    @Override // android.view.WindowManager
    public void addCrossWindowBlurEnabledListener(Executor executor, Consumer consumer) {
        this.f17809l.addCrossWindowBlurEnabledListener(executor, consumer);
    }
}
