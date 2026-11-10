package M0;

import E0.O;
import android.net.Uri;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final long f5579a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5580b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5581c;

    /* renamed from: d, reason: collision with root package name */
    public int f5582d;

    public i(String str, long j7, long j8) {
        this.f5581c = str == null ? "" : str;
        this.f5579a = j7;
        this.f5580b = j8;
    }

    public i a(i iVar, String str) {
        String strC = c(str);
        i iVar2 = null;
        if (iVar != null && strC.equals(iVar.c(str))) {
            long j7 = this.f5580b;
            if (j7 != -1) {
                long j8 = this.f5579a;
                if (j8 + j7 == iVar.f5579a) {
                    long j9 = iVar.f5580b;
                    return new i(strC, j8, j9 != -1 ? j7 + j9 : -1L);
                }
            }
            long j10 = iVar.f5580b;
            if (j10 != -1) {
                long j11 = iVar.f5579a;
                if (j11 + j10 == this.f5579a) {
                    iVar2 = new i(strC, j11, j7 != -1 ? j10 + j7 : -1L);
                }
            }
        }
        return iVar2;
    }

    public Uri b(String str) {
        return O.g(str, this.f5581c);
    }

    public String c(String str) {
        return O.f(str, this.f5581c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && i.class == obj.getClass()) {
            i iVar = (i) obj;
            if (this.f5579a == iVar.f5579a && this.f5580b == iVar.f5580b && this.f5581c.equals(iVar.f5581c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f5582d == 0) {
            this.f5582d = ((((527 + ((int) this.f5579a)) * 31) + ((int) this.f5580b)) * 31) + this.f5581c.hashCode();
        }
        return this.f5582d;
    }

    public String toString() {
        return "RangedUri(referenceUri=" + this.f5581c + ", start=" + this.f5579a + ", length=" + this.f5580b + ")";
    }
}
