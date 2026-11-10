package c1;

import Y0.A;
import Y0.D;
import java.io.IOException;

/* loaded from: classes.dex */
public interface k {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f13912a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13913b;

        /* renamed from: c, reason: collision with root package name */
        public final int f13914c;

        /* renamed from: d, reason: collision with root package name */
        public final int f13915d;

        public a(int i7, int i8, int i9, int i10) {
            this.f13912a = i7;
            this.f13913b = i8;
            this.f13914c = i9;
            this.f13915d = i10;
        }

        public boolean a(int i7) {
            return i7 == 1 ? this.f13912a - this.f13913b > 1 : this.f13914c - this.f13915d > 1;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f13916a;

        /* renamed from: b, reason: collision with root package name */
        public final long f13917b;

        public b(int i7, long j7) {
            j3.o.d(j7 >= 0);
            this.f13916a = i7;
            this.f13917b = j7;
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final A f13918a;

        /* renamed from: b, reason: collision with root package name */
        public final D f13919b;

        /* renamed from: c, reason: collision with root package name */
        public final IOException f13920c;

        /* renamed from: d, reason: collision with root package name */
        public final int f13921d;

        public c(A a7, D d7, IOException iOException, int i7) {
            this.f13918a = a7;
            this.f13919b = d7;
            this.f13920c = iOException;
            this.f13921d = i7;
        }
    }

    long a(c cVar);

    b b(a aVar, c cVar);

    int d(int i7);

    default void c(long j7) {
    }
}
