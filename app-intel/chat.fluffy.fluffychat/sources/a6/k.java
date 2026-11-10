package a6;

/* loaded from: classes.dex */
public interface k extends Z5.d {
    static /* synthetic */ Z5.d c(k kVar, C5.i iVar, int i7, Y5.a aVar, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
        }
        if ((i8 & 1) != 0) {
            iVar = C5.j.f1392l;
        }
        if ((i8 & 2) != 0) {
            i7 = -3;
        }
        if ((i8 & 4) != 0) {
            aVar = Y5.a.f9870l;
        }
        return kVar.d(iVar, i7, aVar);
    }

    Z5.d d(C5.i iVar, int i7, Y5.a aVar);
}
