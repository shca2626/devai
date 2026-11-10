package N0;

import N0.A;
import java.util.UUID;

/* loaded from: classes.dex */
public interface N {

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f5806a;

        /* renamed from: b, reason: collision with root package name */
        public final Y0.A f5807b;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public final byte[] f5808a;

            /* renamed from: b, reason: collision with root package name */
            public Y0.A f5809b;

            public a(byte[] bArr) {
                this.f5808a = bArr;
            }

            public b c() {
                return new b(this);
            }

            public a d(Y0.A a7) {
                this.f5809b = a7;
                return this;
            }
        }

        public b(a aVar) {
            this.f5806a = aVar.f5808a;
            this.f5807b = aVar.f5809b;
        }
    }

    b a(UUID uuid, A.d dVar);

    b b(UUID uuid, A.a aVar);
}
