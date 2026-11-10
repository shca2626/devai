package C2;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1334a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1335b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f1336c;

    public k() {
        this(false, false, false, 7, null);
    }

    public final boolean a() {
        return this.f1334a;
    }

    public final boolean b() {
        return this.f1335b;
    }

    public final boolean c() {
        return this.f1336c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f1334a == kVar.f1334a && this.f1335b == kVar.f1335b && this.f1336c == kVar.f1336c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z7 = this.f1334a;
        ?? r02 = z7;
        if (z7) {
            r02 = 1;
        }
        int i7 = r02 * 31;
        ?? r22 = this.f1335b;
        int i8 = r22;
        if (r22 != 0) {
            i8 = 1;
        }
        int i9 = (i7 + i8) * 31;
        boolean z8 = this.f1336c;
        return i9 + (z8 ? 1 : z8 ? 1 : 0);
    }

    public String toString() {
        return "ImageLoaderOptions(addLastModifiedToFileCacheKey=" + this.f1334a + ", launchInterceptorChainOnMainThread=" + this.f1335b + ", networkObserverEnabled=" + this.f1336c + ')';
    }

    public k(boolean z7, boolean z8, boolean z9) {
        this.f1334a = z7;
        this.f1335b = z8;
        this.f1336c = z9;
    }

    public /* synthetic */ k(boolean z7, boolean z8, boolean z9, int i7, M5.g gVar) {
        this((i7 & 1) != 0 ? true : z7, (i7 & 2) != 0 ? true : z8, (i7 & 4) != 0 ? true : z9);
    }
}
