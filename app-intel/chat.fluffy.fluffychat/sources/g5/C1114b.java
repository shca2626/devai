package g5;

import android.window.BackEvent;
import h5.j;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* renamed from: g5.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1114b {

    /* renamed from: a, reason: collision with root package name */
    public final h5.j f16311a;

    /* renamed from: b, reason: collision with root package name */
    public final j.c f16312b;

    /* renamed from: g5.b$a */
    public class a implements j.c {
        public a() {
        }

        @Override // h5.j.c
        public void onMethodCall(h5.i iVar, j.d dVar) {
            dVar.success(null);
        }
    }

    public C1114b(X4.a aVar) {
        a aVar2 = new a();
        this.f16312b = aVar2;
        h5.j jVar = new h5.j(aVar, "flutter/backgesture", h5.p.f16910b);
        this.f16311a = jVar;
        jVar.e(aVar2);
    }

    public final Map a(BackEvent backEvent) {
        HashMap map = new HashMap(3);
        float touchX = backEvent.getTouchX();
        float touchY = backEvent.getTouchY();
        map.put("touchOffset", (Float.isNaN(touchX) || Float.isNaN(touchY)) ? null : Arrays.asList(Float.valueOf(touchX), Float.valueOf(touchY)));
        map.put("progress", Float.valueOf(backEvent.getProgress()));
        map.put("swipeEdge", Integer.valueOf(backEvent.getSwipeEdge()));
        return map;
    }

    public void b() {
        U4.b.f("BackGestureChannel", "Sending message to cancel back gesture");
        this.f16311a.c("cancelBackGesture", null);
    }

    public void c() {
        U4.b.f("BackGestureChannel", "Sending message to commit back gesture");
        this.f16311a.c("commitBackGesture", null);
    }

    public void d(BackEvent backEvent) {
        U4.b.f("BackGestureChannel", "Sending message to start back gesture");
        this.f16311a.c("startBackGesture", a(backEvent));
    }

    public void e(BackEvent backEvent) {
        U4.b.f("BackGestureChannel", "Sending message to update back gesture progress");
        this.f16311a.c("updateBackGestureProgress", a(backEvent));
    }
}
