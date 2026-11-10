package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: classes7.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: b, reason: collision with root package name */
    long f6825b;

    /* renamed from: c, reason: collision with root package name */
    boolean f6826c;

    /* renamed from: d, reason: collision with root package name */
    boolean f6827d;

    /* renamed from: e, reason: collision with root package name */
    boolean f6828e;

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f6829f;

    /* renamed from: g, reason: collision with root package name */
    private final Runnable f6830g;

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f6825b = -1L;
        this.f6826c = false;
        this.f6827d = false;
        this.f6828e = false;
        this.f6829f = new Runnable() { // from class: androidx.core.widget.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f6890b.c();
            }
        };
        this.f6830g = new Runnable() { // from class: androidx.core.widget.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f6891b.d();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        this.f6826c = false;
        this.f6825b = -1L;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.f6827d = false;
        if (this.f6828e) {
            return;
        }
        this.f6825b = System.currentTimeMillis();
        setVisibility(0);
    }

    private void e() {
        removeCallbacks(this.f6829f);
        removeCallbacks(this.f6830g);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }
}
