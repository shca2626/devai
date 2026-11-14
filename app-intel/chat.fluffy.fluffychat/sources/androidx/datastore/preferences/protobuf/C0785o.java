package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractC0789t;
import java.util.Map;

/* renamed from: androidx.datastore.preferences.protobuf.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0785o extends AbstractC0784n {
    @Override // androidx.datastore.preferences.protobuf.AbstractC0784n
    public int a(Map.Entry entry) {
        android.support.v4.media.session.b.a(entry.getKey());
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0784n
    public Object b(C0783m c0783m, K k7, int i7) {
        c0783m.a(k7, i7);
        return null;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0784n
    public C0787q c(Object obj) {
        return ((AbstractC0789t.c) obj).extensions;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0784n
    public C0787q d(Object obj) {
        return ((AbstractC0789t.c) obj).R();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0784n
    public boolean e(K k7) {
        return k7 instanceof AbstractC0789t.c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0784n
    public void f(Object obj) {
        c(obj).q();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0784n
    public Object g(Object obj, Y y7, Object obj2, C0783m c0783m, C0787q c0787q, Object obj3, g0 g0Var) {
        android.support.v4.media.session.b.a(obj2);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0784n
    public void h(Y y7, Object obj, C0783m c0783m, C0787q c0787q) {
        android.support.v4.media.session.b.a(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0784n
    public void i(AbstractC0776f abstractC0776f, Object obj, C0783m c0783m, C0787q c0787q) {
        android.support.v4.media.session.b.a(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0784n
    public void j(m0 m0Var, Map.Entry entry) {
        android.support.v4.media.session.b.a(entry.getKey());
        throw null;
    }
}
