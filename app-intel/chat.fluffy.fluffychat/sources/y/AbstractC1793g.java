package y;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: y.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1793g implements Iterator, N5.a {

    /* renamed from: l, reason: collision with root package name */
    public int f23797l;

    /* renamed from: m, reason: collision with root package name */
    public int f23798m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f23799n;

    public AbstractC1793g(int i7) {
        this.f23797l = i7;
    }

    public abstract Object a(int i7);

    public abstract void b(int i7);

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f23798m < this.f23797l;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object objA = a(this.f23798m);
        this.f23798m++;
        this.f23799n = true;
        return objA;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.f23799n) {
            throw new IllegalStateException("Call next() before removing an element.");
        }
        int i7 = this.f23798m - 1;
        this.f23798m = i7;
        b(i7);
        this.f23797l--;
        this.f23799n = false;
    }
}
