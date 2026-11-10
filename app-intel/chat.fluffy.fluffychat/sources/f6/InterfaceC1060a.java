package f6;

/* renamed from: f6.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC1060a {

    /* renamed from: f6.a$a, reason: collision with other inner class name */
    public static final class C0167a {
    }

    static /* synthetic */ boolean a(InterfaceC1060a interfaceC1060a, Object obj, int i7, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
        }
        if ((i7 & 1) != 0) {
            obj = null;
        }
        return interfaceC1060a.d(obj);
    }

    static /* synthetic */ void b(InterfaceC1060a interfaceC1060a, Object obj, int i7, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
        }
        if ((i7 & 1) != 0) {
            obj = null;
        }
        interfaceC1060a.e(obj);
    }

    Object c(Object obj, C5.e eVar);

    boolean d(Object obj);

    void e(Object obj);
}
