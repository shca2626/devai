package io.flutter.plugin.platform;

import V4.C0603s;
import android.content.Context;
import android.view.MotionEvent;

/* renamed from: io.flutter.plugin.platform.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1172c extends C0603s {

    /* renamed from: s, reason: collision with root package name */
    public C1170a f17811s;

    public C1172c(Context context, int i7, int i8, C1170a c1170a) {
        super(context, i7, i8, C0603s.a.overlay);
        this.f17811s = c1170a;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        C1170a c1170a = this.f17811s;
        if (c1170a == null || !c1170a.a(motionEvent, true)) {
            return super.onHoverEvent(motionEvent);
        }
        return true;
    }
}
