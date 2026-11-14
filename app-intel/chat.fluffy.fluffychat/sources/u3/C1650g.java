package u3;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: u3.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1650g extends AbstractC1653j implements Iterable {

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f22861l = new ArrayList();

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof C1650g) && ((C1650g) obj).f22861l.equals(this.f22861l);
        }
        return true;
    }

    @Override // u3.AbstractC1653j
    public boolean f() {
        return p().f();
    }

    public int hashCode() {
        return this.f22861l.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f22861l.iterator();
    }

    @Override // u3.AbstractC1653j
    public String j() {
        return p().j();
    }

    public void o(AbstractC1653j abstractC1653j) {
        if (abstractC1653j == null) {
            abstractC1653j = C1655l.f22862l;
        }
        this.f22861l.add(abstractC1653j);
    }

    public final AbstractC1653j p() {
        int size = this.f22861l.size();
        if (size == 1) {
            return (AbstractC1653j) this.f22861l.get(0);
        }
        throw new IllegalStateException("Array must have size 1, but has size " + size);
    }
}
