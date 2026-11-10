package Z0;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public interface o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f10174a = new a();

    public class a implements o {
        @Override // Z0.o
        public long a() {
            throw new NoSuchElementException();
        }

        @Override // Z0.o
        public long b() {
            throw new NoSuchElementException();
        }

        @Override // Z0.o
        public boolean next() {
            return false;
        }
    }

    long a();

    long b();

    boolean next();
}
