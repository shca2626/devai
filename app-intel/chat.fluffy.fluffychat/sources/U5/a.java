package U5;

import M5.m;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f8456a;

    public a(d dVar) {
        m.e(dVar, "sequence");
        this.f8456a = new AtomicReference(dVar);
    }

    @Override // U5.d
    public Iterator iterator() {
        d dVar = (d) this.f8456a.getAndSet(null);
        if (dVar != null) {
            return dVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
