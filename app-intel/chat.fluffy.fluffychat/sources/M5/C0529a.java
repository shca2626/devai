package M5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: M5.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0529a implements Iterator, N5.a {

    /* renamed from: l, reason: collision with root package name */
    public final Object[] f5701l;

    /* renamed from: m, reason: collision with root package name */
    public int f5702m;

    public C0529a(Object[] objArr) {
        m.e(objArr, "array");
        this.f5701l = objArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f5702m < this.f5701l.length;
    }

    @Override // java.util.Iterator
    public Object next() {
        try {
            Object[] objArr = this.f5701l;
            int i7 = this.f5702m;
            this.f5702m = i7 + 1;
            return objArr[i7];
        } catch (ArrayIndexOutOfBoundsException e7) {
            this.f5702m--;
            throw new NoSuchElementException(e7.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
