package k6;

/* loaded from: classes3.dex */
public abstract class z {

    public class a extends z {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f19508a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f19509b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ byte[] f19510c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f19511d;

        public a(u uVar, int i7, byte[] bArr, int i8) {
            this.f19508a = uVar;
            this.f19509b = i7;
            this.f19510c = bArr;
            this.f19511d = i8;
        }

        @Override // k6.z
        public long a() {
            return this.f19509b;
        }

        @Override // k6.z
        public u b() {
            return this.f19508a;
        }

        @Override // k6.z
        public void e(v6.f fVar) {
            fVar.write(this.f19510c, this.f19511d, this.f19509b);
        }
    }

    public static z c(u uVar, byte[] bArr) {
        return d(uVar, bArr, 0, bArr.length);
    }

    public static z d(u uVar, byte[] bArr, int i7, int i8) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        l6.c.d(bArr.length, i7, i8);
        return new a(uVar, i8, bArr, i7);
    }

    public long a() {
        return -1L;
    }

    public abstract u b();

    public abstract void e(v6.f fVar);
}
