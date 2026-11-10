package F0;

import E0.E;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public final int f2469a;

    public static final class b extends e {

        /* renamed from: b, reason: collision with root package name */
        public final long f2470b;

        /* renamed from: c, reason: collision with root package name */
        public final List f2471c;

        /* renamed from: d, reason: collision with root package name */
        public final List f2472d;

        public b(int i7, long j7) {
            super(i7);
            this.f2470b = j7;
            this.f2471c = new ArrayList();
            this.f2472d = new ArrayList();
        }

        public void b(b bVar) {
            this.f2472d.add(bVar);
        }

        public void c(c cVar) {
            this.f2471c.add(cVar);
        }

        public b d(int i7) {
            int size = this.f2472d.size();
            for (int i8 = 0; i8 < size; i8++) {
                b bVar = (b) this.f2472d.get(i8);
                if (bVar.f2469a == i7) {
                    return bVar;
                }
            }
            return null;
        }

        public c e(int i7) {
            int size = this.f2471c.size();
            for (int i8 = 0; i8 < size; i8++) {
                c cVar = (c) this.f2471c.get(i8);
                if (cVar.f2469a == i7) {
                    return cVar;
                }
            }
            return null;
        }

        @Override // F0.e
        public String toString() {
            return e.a(this.f2469a) + " leaves: " + Arrays.toString(this.f2471c.toArray()) + " containers: " + Arrays.toString(this.f2472d.toArray());
        }
    }

    public static final class c extends e {

        /* renamed from: b, reason: collision with root package name */
        public final E f2473b;

        public c(int i7, E e7) {
            super(i7);
            this.f2473b = e7;
        }
    }

    public static String a(int i7) {
        return "" + ((char) ((i7 >> 24) & 255)) + ((char) ((i7 >> 16) & 255)) + ((char) ((i7 >> 8) & 255)) + ((char) (i7 & 255));
    }

    public String toString() {
        return a(this.f2469a);
    }

    public e(int i7) {
        this.f2469a = i7;
    }
}
