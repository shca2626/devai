package k3;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: k3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1260c extends AbstractC1261d implements F {
    public AbstractC1260c(Map map) {
        super(map);
    }

    @Override // k3.AbstractC1261d, k3.J
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public List get(Object obj) {
        return (List) super.get(obj);
    }

    @Override // k3.AbstractC1263f, k3.J
    public Map b() {
        return super.b();
    }

    @Override // k3.AbstractC1263f
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // k3.AbstractC1261d, k3.J
    public boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // k3.AbstractC1261d
    public Collection y(Collection collection) {
        return Collections.unmodifiableList((List) collection);
    }

    @Override // k3.AbstractC1261d
    public Collection z(Object obj, Collection collection) {
        return A(obj, (List) collection, null);
    }
}
