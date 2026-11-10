package W5;

import C5.i;
import java.util.concurrent.CancellationException;

/* renamed from: W5.w0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0652w0 extends i.b {

    /* renamed from: d, reason: collision with root package name */
    public static final b f9180d = b.f9181l;

    /* renamed from: W5.w0$a */
    public static final class a {
        public static Object b(InterfaceC0652w0 interfaceC0652w0, Object obj, L5.p pVar) {
            return i.b.a.a(interfaceC0652w0, obj, pVar);
        }

        public static i.b c(InterfaceC0652w0 interfaceC0652w0, i.c cVar) {
            return i.b.a.b(interfaceC0652w0, cVar);
        }

        public static C5.i d(InterfaceC0652w0 interfaceC0652w0, i.c cVar) {
            return i.b.a.c(interfaceC0652w0, cVar);
        }

        public static C5.i e(InterfaceC0652w0 interfaceC0652w0, C5.i iVar) {
            return i.b.a.d(interfaceC0652w0, iVar);
        }
    }

    /* renamed from: W5.w0$b */
    public static final class b implements i.c {

        /* renamed from: l, reason: collision with root package name */
        public static final /* synthetic */ b f9181l = new b();
    }

    static /* synthetic */ void G(InterfaceC0652w0 interfaceC0652w0, CancellationException cancellationException, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
        if ((i7 & 1) != 0) {
            cancellationException = null;
        }
        interfaceC0652w0.d(cancellationException);
    }

    InterfaceC0615d0 E(boolean z7, boolean z8, L5.l lVar);

    boolean L();

    InterfaceC0615d0 N(L5.l lVar);

    void d(CancellationException cancellationException);

    boolean e();

    InterfaceC0645t j(InterfaceC0649v interfaceC0649v);

    CancellationException r();

    boolean start();
}
