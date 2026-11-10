package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.D;
import java.util.Map;

/* loaded from: classes.dex */
public final class G implements F {
    public static int i(int i7, Object obj, Object obj2) {
        E e7 = (E) obj;
        D d7 = (D) obj2;
        int iA = 0;
        if (e7.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : e7.entrySet()) {
            iA += d7.a(i7, entry.getKey(), entry.getValue());
        }
        return iA;
    }

    public static E j(Object obj, Object obj2) {
        E eO = (E) obj;
        E e7 = (E) obj2;
        if (!e7.isEmpty()) {
            if (!eO.l()) {
                eO = eO.o();
            }
            eO.n(e7);
        }
        return eO;
    }

    @Override // androidx.datastore.preferences.protobuf.F
    public Object a(Object obj, Object obj2) {
        return j(obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.F
    public Object b(Object obj) {
        ((E) obj).m();
        return obj;
    }

    @Override // androidx.datastore.preferences.protobuf.F
    public D.a c(Object obj) {
        return ((D) obj).c();
    }

    @Override // androidx.datastore.preferences.protobuf.F
    public Map d(Object obj) {
        return (E) obj;
    }

    @Override // androidx.datastore.preferences.protobuf.F
    public Object e(Object obj) {
        return E.f().o();
    }

    @Override // androidx.datastore.preferences.protobuf.F
    public int f(int i7, Object obj, Object obj2) {
        return i(i7, obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.F
    public boolean g(Object obj) {
        return !((E) obj).l();
    }

    @Override // androidx.datastore.preferences.protobuf.F
    public Map h(Object obj) {
        return (E) obj;
    }
}
