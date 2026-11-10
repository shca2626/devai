package k3;

import java.util.NoSuchElementException;

/* renamed from: k3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1259a extends i0 {

    /* renamed from: l, reason: collision with root package name */
    public final int f18919l;

    /* renamed from: m, reason: collision with root package name */
    public int f18920m;

    public AbstractC1259a(int i7, int i8) {
        j3.o.s(i8, i7);
        this.f18919l = i7;
        this.f18920m = i8;
    }

    public abstract Object a(int i7);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f18920m < this.f18919l;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f18920m > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i7 = this.f18920m;
        this.f18920m = i7 + 1;
        return a(i7);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f18920m;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i7 = this.f18920m - 1;
        this.f18920m = i7;
        return a(i7);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f18920m - 1;
    }
}
