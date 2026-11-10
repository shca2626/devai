package k3;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: k3.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1275q extends r implements Map {
    public abstract Map b();

    public boolean c(Object obj) {
        return H.f(this, obj);
    }

    @Override // java.util.Map
    public void clear() {
        b().clear();
    }

    public boolean containsKey(Object obj) {
        return b().containsKey(obj);
    }

    public boolean d(Object obj) {
        return H.g(this, obj);
    }

    public int e() {
        return d0.d(entrySet());
    }

    public Set entrySet() {
        return b().entrySet();
    }

    public Object get(Object obj) {
        return b().get(obj);
    }

    public boolean isEmpty() {
        return b().isEmpty();
    }

    public Set keySet() {
        return b().keySet();
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        return b().put(obj, obj2);
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        b().putAll(map);
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return b().remove(obj);
    }

    public int size() {
        return b().size();
    }

    @Override // java.util.Map
    public Collection values() {
        return b().values();
    }
}
