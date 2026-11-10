package A5;

import M5.m;
import java.util.Map;
import z5.AbstractC1872f;

/* loaded from: classes.dex */
public abstract class a extends AbstractC1872f {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return g((Map.Entry) obj);
        }
        return false;
    }

    public final boolean g(Map.Entry entry) {
        m.e(entry, "element");
        return h(entry);
    }

    public abstract boolean h(Map.Entry entry);

    public /* bridge */ boolean i(Map.Entry entry) {
        return super.remove(entry);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            return i((Map.Entry) obj);
        }
        return false;
    }
}
