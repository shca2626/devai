package k6;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class B implements Closeable {

    public class a extends B {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ u f19138l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ long f19139m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ v6.g f19140n;

        public a(u uVar, long j7, v6.g gVar) {
            this.f19138l = uVar;
            this.f19139m = j7;
            this.f19140n = gVar;
        }

        @Override // k6.B
        public long a() {
            return this.f19139m;
        }

        @Override // k6.B
        public u d() {
            return this.f19138l;
        }

        @Override // k6.B
        public v6.g i() {
            return this.f19140n;
        }
    }

    public static B e(u uVar, long j7, v6.g gVar) {
        if (gVar != null) {
            return new a(uVar, j7, gVar);
        }
        throw new NullPointerException("source == null");
    }

    public static B f(u uVar, byte[] bArr) {
        return e(uVar, bArr.length, new v6.e().write(bArr));
    }

    public abstract long a();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        l6.c.e(i());
    }

    public abstract u d();

    public abstract v6.g i();
}
