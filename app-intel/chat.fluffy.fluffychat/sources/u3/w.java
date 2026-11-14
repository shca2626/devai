package u3;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class w {

    public final class b extends w {
        public b() {
        }

        @Override // u3.w
        public Object c(C3.a aVar) throws IOException {
            if (aVar.V() != C3.b.NULL) {
                return w.this.c(aVar);
            }
            aVar.N();
            return null;
        }

        @Override // u3.w
        public void e(C3.c cVar, Object obj) throws IOException {
            if (obj == null) {
                cVar.C();
            } else {
                w.this.e(cVar, obj);
            }
        }

        public String toString() {
            return "NullSafeTypeAdapter[" + w.this + "]";
        }
    }

    public final Object a(AbstractC1653j abstractC1653j) {
        try {
            return c(new x3.g(abstractC1653j));
        } catch (IOException e7) {
            throw new C1654k(e7);
        }
    }

    public final w b() {
        return !(this instanceof b) ? new b() : this;
    }

    public abstract Object c(C3.a aVar);

    public final AbstractC1653j d(Object obj) {
        try {
            x3.h hVar = new x3.h();
            e(hVar, obj);
            return hVar.Z();
        } catch (IOException e7) {
            throw new C1654k(e7);
        }
    }

    public abstract void e(C3.c cVar, Object obj);
}
