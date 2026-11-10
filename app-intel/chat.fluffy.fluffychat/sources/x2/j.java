package x2;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public abstract class j {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final v2.m f23561a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f23562b;

        /* renamed from: c, reason: collision with root package name */
        public final r2.e f23563c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f23564d;

        public a(v2.m mVar, boolean z7, r2.e eVar, boolean z8) {
            M5.m.e(eVar, "dataSource");
            this.f23561a = mVar;
            this.f23562b = z7;
            this.f23563c = eVar;
            this.f23564d = z8;
        }

        public final r2.e a() {
            return this.f23563c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return M5.m.a(this.f23561a, aVar.f23561a) && this.f23562b == aVar.f23562b && this.f23563c == aVar.f23563c && this.f23564d == aVar.f23564d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            v2.m mVar = this.f23561a;
            int iHashCode = (mVar == null ? 0 : mVar.hashCode()) * 31;
            boolean z7 = this.f23562b;
            int i7 = z7;
            if (z7 != 0) {
                i7 = 1;
            }
            int iHashCode2 = (((iHashCode + i7) * 31) + this.f23563c.hashCode()) * 31;
            boolean z8 = this.f23564d;
            return iHashCode2 + (z8 ? 1 : z8 ? 1 : 0);
        }

        public String toString() {
            return "Metadata(memoryCacheKey=" + this.f23561a + ", isSampled=" + this.f23562b + ", dataSource=" + this.f23563c + ", isPlaceholderMemoryCacheKeyPresent=" + this.f23564d + ')';
        }
    }

    public /* synthetic */ j(M5.g gVar) {
        this();
    }

    public abstract Drawable a();

    public abstract i b();

    public j() {
    }
}
