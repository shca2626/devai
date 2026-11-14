package t1;

import B0.x;
import B0.y;
import java.util.Arrays;

/* renamed from: t1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1624c implements y.a {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f22509a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22510b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22511c;

    public C1624c(byte[] bArr, String str, String str2) {
        this.f22509a = bArr;
        this.f22510b = str;
        this.f22511c = str2;
    }

    @Override // B0.y.a
    public void a(x.b bVar) {
        String str = this.f22510b;
        if (str != null) {
            bVar.q0(str);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1624c.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f22509a, ((C1624c) obj).f22509a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f22509a);
    }

    public String toString() {
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", this.f22510b, this.f22511c, Integer.valueOf(this.f22509a.length));
    }
}
