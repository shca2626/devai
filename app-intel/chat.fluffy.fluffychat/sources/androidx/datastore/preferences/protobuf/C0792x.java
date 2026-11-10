package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* renamed from: androidx.datastore.preferences.protobuf.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0792x implements Iterator {

    /* renamed from: l, reason: collision with root package name */
    public Iterator f12267l;

    public C0792x(Iterator it) {
        this.f12267l = it;
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map.Entry next() {
        Map.Entry entry = (Map.Entry) this.f12267l.next();
        entry.getValue();
        return entry;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f12267l.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f12267l.remove();
    }
}
