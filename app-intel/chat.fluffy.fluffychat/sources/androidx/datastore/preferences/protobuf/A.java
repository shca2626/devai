package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractC0789u;
import java.util.List;

/* loaded from: classes.dex */
public final class A implements InterfaceC0794z {
    public static AbstractC0789u.b d(Object obj, long j7) {
        return (AbstractC0789u.b) j0.z(obj, j7);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0794z
    public void a(Object obj, Object obj2, long j7) {
        AbstractC0789u.b bVarD = d(obj, j7);
        AbstractC0789u.b bVarD2 = d(obj2, j7);
        int size = bVarD.size();
        int size2 = bVarD2.size();
        if (size > 0 && size2 > 0) {
            if (!bVarD.e()) {
                bVarD = bVarD.c(size2 + size);
            }
            bVarD.addAll(bVarD2);
        }
        if (size > 0) {
            bVarD2 = bVarD;
        }
        j0.O(obj, j7, bVarD2);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0794z
    public void b(Object obj, long j7) {
        d(obj, j7).a();
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0794z
    public List c(Object obj, long j7) {
        AbstractC0789u.b bVarD = d(obj, j7);
        if (bVarD.e()) {
            return bVarD;
        }
        int size = bVarD.size();
        AbstractC0789u.b bVarC = bVarD.c(size == 0 ? 10 : size * 2);
        j0.O(obj, j7, bVarC);
        return bVarC;
    }
}
