package io.flutter.plugin.platform;

import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: io.flutter.plugin.platform.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1169a {

    /* renamed from: a, reason: collision with root package name */
    public io.flutter.view.k f17801a;

    public boolean a(MotionEvent motionEvent, boolean z7) {
        io.flutter.view.k kVar = this.f17801a;
        if (kVar == null) {
            return false;
        }
        return kVar.M(motionEvent, z7);
    }

    public boolean b(View view, View view2, AccessibilityEvent accessibilityEvent) {
        io.flutter.view.k kVar = this.f17801a;
        if (kVar == null) {
            return false;
        }
        return kVar.w(view, view2, accessibilityEvent);
    }

    public void c(io.flutter.view.k kVar) {
        this.f17801a = kVar;
    }
}
