package k3;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import k3.AbstractC1279v;
import k3.AbstractC1281x;
import k3.AbstractC1282y;

/* renamed from: k3.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1280w extends AbstractC1282y implements F {

    /* renamed from: k3.w$a */
    public static final class a extends AbstractC1282y.c {
        public C1280w e() {
            return (C1280w) super.a();
        }

        public a f(Object obj, Object obj2) {
            super.d(obj, obj2);
            return this;
        }
    }

    public C1280w(AbstractC1281x abstractC1281x, int i7) {
        super(abstractC1281x, i7);
    }

    public static a t() {
        return new a();
    }

    public static C1280w u(Collection collection, Comparator comparator) {
        if (collection.isEmpty()) {
            return w();
        }
        AbstractC1281x.a aVar = new AbstractC1281x.a(collection.size());
        Iterator it = collection.iterator();
        int size = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            AbstractC1279v.a aVar2 = (AbstractC1279v.a) entry.getValue();
            AbstractC1279v abstractC1279vK = comparator == null ? aVar2.k() : aVar2.l(comparator);
            aVar.g(key, abstractC1279vK);
            size += abstractC1279vK.size();
        }
        return new C1280w(aVar.d(), size);
    }

    public static C1280w w() {
        return C1274p.f19012r;
    }

    public static C1280w x(Object obj, Object obj2) {
        a aVarT = t();
        aVarT.f(obj, obj2);
        return aVarT.e();
    }

    @Override // k3.J
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public AbstractC1279v get(Object obj) {
        AbstractC1279v abstractC1279v = (AbstractC1279v) this.f19036p.get(obj);
        return abstractC1279v == null ? AbstractC1279v.v() : abstractC1279v;
    }
}
