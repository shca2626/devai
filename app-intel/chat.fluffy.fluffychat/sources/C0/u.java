package C0;

import E0.U;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Objects;

/* loaded from: classes.dex */
public interface u {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f1256a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    public static final class a {

        /* renamed from: e, reason: collision with root package name */
        public static final a f1257e = new a(-1, -1, -1);

        /* renamed from: a, reason: collision with root package name */
        public final int f1258a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1259b;

        /* renamed from: c, reason: collision with root package name */
        public final int f1260c;

        /* renamed from: d, reason: collision with root package name */
        public final int f1261d;

        public a(B0.s sVar) {
            this(sVar.f735H, sVar.f734G, sVar.f736I);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f1258a == aVar.f1258a && this.f1259b == aVar.f1259b && this.f1260c == aVar.f1260c;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f1258a), Integer.valueOf(this.f1259b), Integer.valueOf(this.f1260c));
        }

        public String toString() {
            return "AudioFormat[sampleRate=" + this.f1258a + ", channelCount=" + this.f1259b + ", encoding=" + this.f1260c + ']';
        }

        public a(int i7, int i8, int i9) {
            this.f1258a = i7;
            this.f1259b = i8;
            this.f1260c = i9;
            this.f1261d = U.E0(i9) ? U.l0(i9, i8) : -1;
        }
    }

    public static final class b {

        /* renamed from: b, reason: collision with root package name */
        public static final b f1262b = new b(0);

        /* renamed from: a, reason: collision with root package name */
        public final long f1263a;

        public b(long j7) {
            j3.o.d(j7 >= 0);
            this.f1263a = j7;
        }
    }

    public static final class c extends Exception {

        /* renamed from: l, reason: collision with root package name */
        public final a f1264l;

        public c(a aVar) {
            this("Unhandled input format:", aVar);
        }

        public c(String str, a aVar) {
            super(str + " " + aVar);
            this.f1264l = aVar;
        }
    }

    boolean d();

    boolean e();

    ByteBuffer f();

    void g(ByteBuffer byteBuffer);

    void h(b bVar);

    a i(a aVar);

    void j();

    void reset();

    default long k(long j7) {
        return j7;
    }
}
