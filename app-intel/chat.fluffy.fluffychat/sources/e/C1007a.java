package e;

import M5.m;
import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: e.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1007a {

    /* renamed from: a, reason: collision with root package name */
    public final Set f15318a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    public volatile Context f15319b;

    public final void a(InterfaceC1008b interfaceC1008b) {
        m.e(interfaceC1008b, "listener");
        Context context = this.f15319b;
        if (context != null) {
            interfaceC1008b.a(context);
        }
        this.f15318a.add(interfaceC1008b);
    }

    public final void b() {
        this.f15319b = null;
    }

    public final void c(Context context) {
        m.e(context, "context");
        this.f15319b = context;
        Iterator it = this.f15318a.iterator();
        while (it.hasNext()) {
            ((InterfaceC1008b) it.next()).a(context);
        }
    }
}
