package z5;

import java.util.AbstractList;
import java.util.List;

/* renamed from: z5.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1871e extends AbstractList implements List, N5.b {
    public abstract int f();

    public abstract Object g(int i7);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i7) {
        return g(i7);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return f();
    }
}
