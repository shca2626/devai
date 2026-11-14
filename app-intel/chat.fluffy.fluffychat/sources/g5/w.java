package g5;

import h5.C1145a;
import java.util.HashMap;

/* loaded from: classes.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    public final C1145a f16486a;

    public w(X4.a aVar) {
        this.f16486a = new C1145a(aVar, "flutter/system", h5.e.f16893a);
    }

    public void a() {
        U4.b.f("SystemChannel", "Sending memory pressure warning to Flutter.");
        HashMap map = new HashMap(1);
        map.put("type", "memoryPressure");
        this.f16486a.c(map);
    }
}
