package s;

import java.util.HashMap;
import java.util.Map;
import s.C1596b;

/* renamed from: s.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1595a extends C1596b {

    /* renamed from: p, reason: collision with root package name */
    public final HashMap f22343p = new HashMap();

    public boolean contains(Object obj) {
        return this.f22343p.containsKey(obj);
    }

    @Override // s.C1596b
    public C1596b.c g(Object obj) {
        return (C1596b.c) this.f22343p.get(obj);
    }

    @Override // s.C1596b
    public Object k(Object obj, Object obj2) {
        C1596b.c cVarG = g(obj);
        if (cVarG != null) {
            return cVarG.f22349m;
        }
        this.f22343p.put(obj, j(obj, obj2));
        return null;
    }

    @Override // s.C1596b
    public Object l(Object obj) {
        Object objL = super.l(obj);
        this.f22343p.remove(obj);
        return objL;
    }

    public Map.Entry m(Object obj) {
        if (contains(obj)) {
            return ((C1596b.c) this.f22343p.get(obj)).f22351o;
        }
        return null;
    }
}
