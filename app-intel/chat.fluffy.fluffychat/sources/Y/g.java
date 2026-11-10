package Y;

import M5.m;

/* loaded from: classes.dex */
public class g extends f {

    /* renamed from: c, reason: collision with root package name */
    public final Object f9356c;

    public g(int i7) {
        super(i7);
        this.f9356c = new Object();
    }

    @Override // Y.f, Y.e
    public boolean a(Object obj) {
        boolean zA;
        m.e(obj, "instance");
        synchronized (this.f9356c) {
            zA = super.a(obj);
        }
        return zA;
    }

    @Override // Y.f, Y.e
    public Object b() {
        Object objB;
        synchronized (this.f9356c) {
            objB = super.b();
        }
        return objB;
    }
}
