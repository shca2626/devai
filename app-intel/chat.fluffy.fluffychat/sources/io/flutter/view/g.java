package io.flutter.view;

import android.app.UiModeManager;
import io.flutter.view.k;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements UiModeManager.ContrastChangeListener, k.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f17939a;

    public /* synthetic */ g(k kVar) {
        this.f17939a = kVar;
    }

    @Override // android.app.UiModeManager.ContrastChangeListener
    public final void onContrastChanged(float f7) {
        this.f17939a.c0();
    }
}
