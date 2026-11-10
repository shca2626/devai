package k3;

import java.io.Serializable;

/* renamed from: k3.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1278u extends AbstractC1263e implements Serializable {

    /* renamed from: l, reason: collision with root package name */
    public final Object f19017l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f19018m;

    public C1278u(Object obj, Object obj2) {
        this.f19017l = obj;
        this.f19018m = obj2;
    }

    @Override // k3.AbstractC1263e, java.util.Map.Entry
    public final Object getKey() {
        return this.f19017l;
    }

    @Override // k3.AbstractC1263e, java.util.Map.Entry
    public final Object getValue() {
        return this.f19018m;
    }

    @Override // k3.AbstractC1263e, java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}
