package k3;

import java.io.Serializable;

/* renamed from: k3.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1277u extends AbstractC1262e implements Serializable {

    /* renamed from: l, reason: collision with root package name */
    public final Object f19016l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f19017m;

    public C1277u(Object obj, Object obj2) {
        this.f19016l = obj;
        this.f19017m = obj2;
    }

    @Override // k3.AbstractC1262e, java.util.Map.Entry
    public final Object getKey() {
        return this.f19016l;
    }

    @Override // k3.AbstractC1262e, java.util.Map.Entry
    public final Object getValue() {
        return this.f19017m;
    }

    @Override // k3.AbstractC1262e, java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}
