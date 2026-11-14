package z5;

import java.util.Iterator;

/* renamed from: z5.D, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1863D implements Iterator, N5.a {
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(nextInt());
    }

    public abstract int nextInt();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
