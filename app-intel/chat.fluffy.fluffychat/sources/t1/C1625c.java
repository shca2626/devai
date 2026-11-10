package t1;

import B0.x;
import B0.y;
import java.util.Arrays;

/* renamed from: t1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1625c implements y.a {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f22503a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22504b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22505c;

    public C1625c(byte[] bArr, String str, String str2) {
        this.f22503a = bArr;
        this.f22504b = str;
        this.f22505c = str2;
    }

    @Override // B0.y.a
    public void a(x.b bVar) {
        String str = this.f22504b;
        if (str != null) {
            bVar.q0(str);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1625c.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f22503a, ((C1625c) obj).f22503a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f22503a);
    }

    public String toString() {
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", this.f22504b, this.f22505c, Integer.valueOf(this.f22503a.length));
    }
}
