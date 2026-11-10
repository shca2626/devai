package k3;

import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class f0 implements Iterator {

    /* renamed from: l, reason: collision with root package name */
    public final Iterator f18976l;

    public f0(Iterator it) {
        this.f18976l = (Iterator) j3.o.q(it);
    }

    public abstract Object a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f18976l.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return a(this.f18976l.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f18976l.remove();
    }
}
