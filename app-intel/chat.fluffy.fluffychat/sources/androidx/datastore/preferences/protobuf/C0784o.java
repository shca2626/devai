package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractC0788t;
import java.util.Map;

/* renamed from: androidx.datastore.preferences.protobuf.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0784o extends AbstractC0783n {
    @Override // androidx.datastore.preferences.protobuf.AbstractC0783n
    public int a(Map.Entry entry) {
        android.support.v4.media.session.b.a(entry.getKey());
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0783n
    public Object b(C0782m c0782m, K k7, int i7) {
        c0782m.a(k7, i7);
        return null;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0783n
    public C0786q c(Object obj) {
        return ((AbstractC0788t.c) obj).extensions;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0783n
    public C0786q d(Object obj) {
        return ((AbstractC0788t.c) obj).R();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0783n
    public boolean e(K k7) {
        return k7 instanceof AbstractC0788t.c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0783n
    public void f(Object obj) {
        c(obj).q();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0783n
    public Object g(Object obj, Y y7, Object obj2, C0782m c0782m, C0786q c0786q, Object obj3, g0 g0Var) {
        android.support.v4.media.session.b.a(obj2);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0783n
    public void h(Y y7, Object obj, C0782m c0782m, C0786q c0786q) {
        android.support.v4.media.session.b.a(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0783n
    public void i(AbstractC0775f abstractC0775f, Object obj, C0782m c0782m, C0786q c0786q) {
        android.support.v4.media.session.b.a(obj);
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0783n
    public void j(m0 m0Var, Map.Entry entry) {
        android.support.v4.media.session.b.a(entry.getKey());
        throw null;
    }
}
