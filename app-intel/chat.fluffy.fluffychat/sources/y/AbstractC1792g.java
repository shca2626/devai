package y;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: y.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1792g implements Iterator, N5.a {

    /* renamed from: l, reason: collision with root package name */
    public int f23803l;

    /* renamed from: m, reason: collision with root package name */
    public int f23804m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f23805n;

    public AbstractC1792g(int i7) {
        this.f23803l = i7;
    }

    public abstract Object a(int i7);

    public abstract void b(int i7);

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f23804m < this.f23803l;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object objA = a(this.f23804m);
        this.f23804m++;
        this.f23805n = true;
        return objA;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.f23805n) {
            throw new IllegalStateException("Call next() before removing an element.");
        }
        int i7 = this.f23804m - 1;
        this.f23804m = i7;
        b(i7);
        this.f23803l--;
        this.f23805n = false;
    }
}
