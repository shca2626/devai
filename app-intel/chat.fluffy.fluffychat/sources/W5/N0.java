package W5;

import y5.C1824s;

/* loaded from: classes.dex */
public final class N0 implements Runnable {

    /* renamed from: l, reason: collision with root package name */
    public final J f9113l;

    /* renamed from: m, reason: collision with root package name */
    public final InterfaceC0632m f9114m;

    public N0(J j7, InterfaceC0632m interfaceC0632m) {
        this.f9113l = j7;
        this.f9114m = interfaceC0632m;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9114m.p(this.f9113l, C1824s.f24014a);
    }
}
