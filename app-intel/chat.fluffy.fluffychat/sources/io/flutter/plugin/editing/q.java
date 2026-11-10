package io.flutter.plugin.editing;

import android.os.Build;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import g5.s;

/* loaded from: classes.dex */
public class q implements s.b {

    /* renamed from: a, reason: collision with root package name */
    public final g5.s f17748a;

    /* renamed from: b, reason: collision with root package name */
    public final InputMethodManager f17749b;

    /* renamed from: c, reason: collision with root package name */
    public View f17750c;

    public q(View view, InputMethodManager inputMethodManager, g5.s sVar) {
        if (Build.VERSION.SDK_INT >= 33) {
            view.setAutoHandwritingEnabled(false);
        }
        this.f17750c = view;
        this.f17749b = inputMethodManager;
        this.f17748a = sVar;
        sVar.g(this);
    }

    @Override // g5.s.b
    public void a() {
        this.f17749b.startStylusHandwriting(this.f17750c);
    }

    @Override // g5.s.b
    public boolean b() {
        return this.f17749b.isStylusHandwritingAvailable();
    }

    @Override // g5.s.b
    public boolean c() {
        return Build.VERSION.SDK_INT >= 34 && b();
    }
}
