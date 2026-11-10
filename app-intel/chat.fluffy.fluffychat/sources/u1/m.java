package u1;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public final class m extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f22776b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f22777c;

    public m(String str, byte[] bArr) {
        super("PRIV");
        this.f22776b = str;
        this.f22777c = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && m.class == obj.getClass()) {
            m mVar = (m) obj;
            if (Objects.equals(this.f22776b, mVar.f22776b) && Arrays.equals(this.f22777c, mVar.f22777c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f22776b;
        return ((527 + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.f22777c);
    }

    @Override // u1.i
    public String toString() {
        return this.f22766a + ": owner=" + this.f22776b;
    }
}
