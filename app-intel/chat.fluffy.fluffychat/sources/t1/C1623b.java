package t1;

import B0.x;
import B0.y;
import j3.o;
import java.util.Objects;

/* renamed from: t1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1623b implements y.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f22503a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22504b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22505c;

    /* renamed from: d, reason: collision with root package name */
    public final String f22506d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f22507e;

    /* renamed from: f, reason: collision with root package name */
    public final int f22508f;

    public C1623b(int i7, String str, String str2, String str3, boolean z7, int i8) {
        o.d(i8 == -1 || i8 > 0);
        this.f22503a = i7;
        this.f22504b = str;
        this.f22505c = str2;
        this.f22506d = str3;
        this.f22507e = z7;
        this.f22508f = i8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static t1.C1623b d(java.util.Map r13) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t1.C1623b.d(java.util.Map):t1.b");
    }

    @Override // B0.y.a
    public void a(x.b bVar) {
        String str = this.f22505c;
        if (str != null) {
            bVar.n0(str);
        }
        String str2 = this.f22504b;
        if (str2 != null) {
            bVar.d0(str2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C1623b.class == obj.getClass()) {
            C1623b c1623b = (C1623b) obj;
            if (this.f22503a == c1623b.f22503a && Objects.equals(this.f22504b, c1623b.f22504b) && Objects.equals(this.f22505c, c1623b.f22505c) && Objects.equals(this.f22506d, c1623b.f22506d) && this.f22507e == c1623b.f22507e && this.f22508f == c1623b.f22508f) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i7 = (527 + this.f22503a) * 31;
        String str = this.f22504b;
        int iHashCode = (i7 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f22505c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f22506d;
        return ((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.f22507e ? 1 : 0)) * 31) + this.f22508f;
    }

    public String toString() {
        return "IcyHeaders: name=\"" + this.f22505c + "\", genre=\"" + this.f22504b + "\", bitrate=" + this.f22503a + ", metadataInterval=" + this.f22508f;
    }
}
