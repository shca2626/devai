package io.flutter.plugin.platform;

import V4.C0602s;
import android.content.Context;
import android.view.MotionEvent;

/* renamed from: io.flutter.plugin.platform.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1171c extends C0602s {

    /* renamed from: s, reason: collision with root package name */
    public C1169a f17811s;

    public C1171c(Context context, int i7, int i8, C1169a c1169a) {
        super(context, i7, i8, C0602s.a.overlay);
        this.f17811s = c1169a;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        C1169a c1169a = this.f17811s;
        if (c1169a == null || !c1169a.a(motionEvent, true)) {
            return super.onHoverEvent(motionEvent);
        }
        return true;
    }
}
