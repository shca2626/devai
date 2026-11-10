package j3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: j3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1228b implements Iterator {

    /* renamed from: l, reason: collision with root package name */
    public a f18697l = a.NOT_READY;

    /* renamed from: m, reason: collision with root package name */
    public Object f18698m;

    /* renamed from: j3.b$a */
    public enum a {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    public abstract Object a();

    public final Object b() {
        this.f18697l = a.DONE;
        return null;
    }

    public final boolean c() {
        this.f18697l = a.FAILED;
        this.f18698m = a();
        if (this.f18697l == a.DONE) {
            return false;
        }
        this.f18697l = a.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        o.v(this.f18697l != a.FAILED);
        int iOrdinal = this.f18697l.ordinal();
        if (iOrdinal == 0) {
            return true;
        }
        if (iOrdinal != 2) {
            return c();
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f18697l = a.NOT_READY;
        Object objA = AbstractC1236j.a(this.f18698m);
        this.f18698m = null;
        return objA;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
