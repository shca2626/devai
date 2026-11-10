package W5;

import C5.i;
import W5.AbstractC0635n0;
import java.io.Closeable;

/* renamed from: W5.n0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0635n0 extends J implements Closeable, AutoCloseable {

    /* renamed from: n, reason: collision with root package name */
    public static final a f9163n = new a(null);

    /* renamed from: W5.n0$a */
    public static final class a extends C5.b {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public static final AbstractC0635n0 d(i.b bVar) {
            if (bVar instanceof AbstractC0635n0) {
                return (AbstractC0635n0) bVar;
            }
            return null;
        }

        public a() {
            super(J.f9108m, new L5.l() { // from class: W5.m0
                @Override // L5.l
                public final Object a(Object obj) {
                    return AbstractC0635n0.a.d((i.b) obj);
                }
            });
        }
    }
}
