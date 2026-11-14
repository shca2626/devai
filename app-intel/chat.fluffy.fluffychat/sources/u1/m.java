package u1;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public final class m extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f22782b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f22783c;

    public m(String str, byte[] bArr) {
        super("PRIV");
        this.f22782b = str;
        this.f22783c = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && m.class == obj.getClass()) {
            m mVar = (m) obj;
            if (Objects.equals(this.f22782b, mVar.f22782b) && Arrays.equals(this.f22783c, mVar.f22783c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f22782b;
        return ((527 + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.f22783c);
    }

    @Override // u1.i
    public String toString() {
        return this.f22772a + ": owner=" + this.f22782b;
    }
}
