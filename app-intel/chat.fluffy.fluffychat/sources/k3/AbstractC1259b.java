package k3;

import java.util.NoSuchElementException;

/* renamed from: k3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1259b extends h0 {

    /* renamed from: l, reason: collision with root package name */
    public a f18921l = a.NOT_READY;

    /* renamed from: m, reason: collision with root package name */
    public Object f18922m;

    /* renamed from: k3.b$a */
    public enum a {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    public abstract Object a();

    public final Object b() {
        this.f18921l = a.DONE;
        return null;
    }

    public final boolean c() {
        this.f18921l = a.FAILED;
        this.f18922m = a();
        if (this.f18921l == a.DONE) {
            return false;
        }
        this.f18921l = a.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        j3.o.v(this.f18921l != a.FAILED);
        int iOrdinal = this.f18921l.ordinal();
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
        this.f18921l = a.NOT_READY;
        Object objA = Q.a(this.f18922m);
        this.f18922m = null;
        return objA;
    }
}
