package s;

import java.util.HashMap;
import java.util.Map;
import s.C1597b;

/* renamed from: s.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1596a extends C1597b {

    /* renamed from: p, reason: collision with root package name */
    public final HashMap f22337p = new HashMap();

    public boolean contains(Object obj) {
        return this.f22337p.containsKey(obj);
    }

    @Override // s.C1597b
    public C1597b.c g(Object obj) {
        return (C1597b.c) this.f22337p.get(obj);
    }

    @Override // s.C1597b
    public Object k(Object obj, Object obj2) {
        C1597b.c cVarG = g(obj);
        if (cVarG != null) {
            return cVarG.f22343m;
        }
        this.f22337p.put(obj, j(obj, obj2));
        return null;
    }

    @Override // s.C1597b
    public Object l(Object obj) {
        Object objL = super.l(obj);
        this.f22337p.remove(obj);
        return objL;
    }

    public Map.Entry m(Object obj) {
        if (contains(obj)) {
            return ((C1597b.c) this.f22337p.get(obj)).f22345o;
        }
        return null;
    }
}
