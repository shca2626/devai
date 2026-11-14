package u1;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class b extends i {

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f22748b;

    public b(String str, byte[] bArr) {
        super(str);
        this.f22748b = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f22772a.equals(bVar.f22772a) && Arrays.equals(this.f22748b, bVar.f22748b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f22772a.hashCode()) * 31) + Arrays.hashCode(this.f22748b);
    }
}
