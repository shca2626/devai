package u3;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: u3.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1651g extends AbstractC1654j implements Iterable {

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f22855l = new ArrayList();

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof C1651g) && ((C1651g) obj).f22855l.equals(this.f22855l);
        }
        return true;
    }

    @Override // u3.AbstractC1654j
    public boolean f() {
        return p().f();
    }

    public int hashCode() {
        return this.f22855l.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f22855l.iterator();
    }

    @Override // u3.AbstractC1654j
    public String j() {
        return p().j();
    }

    public void o(AbstractC1654j abstractC1654j) {
        if (abstractC1654j == null) {
            abstractC1654j = C1656l.f22856l;
        }
        this.f22855l.add(abstractC1654j);
    }

    public final AbstractC1654j p() {
        int size = this.f22855l.size();
        if (size == 1) {
            return (AbstractC1654j) this.f22855l.get(0);
        }
        throw new IllegalStateException("Array must have size 1, but has size " + size);
    }
}
