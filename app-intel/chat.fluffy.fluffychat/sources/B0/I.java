package B0;

import E0.AbstractC0332s;
import E0.U;
import android.text.TextUtils;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class I {

    /* renamed from: f, reason: collision with root package name */
    public static final String f423f = U.A0(0);

    /* renamed from: g, reason: collision with root package name */
    public static final String f424g = U.A0(1);

    /* renamed from: a, reason: collision with root package name */
    public final int f425a;

    /* renamed from: b, reason: collision with root package name */
    public final String f426b;

    /* renamed from: c, reason: collision with root package name */
    public final int f427c;

    /* renamed from: d, reason: collision with root package name */
    public final s[] f428d;

    /* renamed from: e, reason: collision with root package name */
    public int f429e;

    public I(s... sVarArr) {
        this("", sVarArr);
    }

    public static void c(String str, String str2, String str3, int i7) {
        AbstractC0332s.d("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i7 + ")"));
    }

    public static String d(String str) {
        return (str == null || str.equals("und")) ? "" : str;
    }

    public static int e(int i7) {
        return i7 | 16384;
    }

    public s a(int i7) {
        return this.f428d[i7];
    }

    public int b(s sVar) {
        int i7 = 0;
        while (true) {
            s[] sVarArr = this.f428d;
            if (i7 >= sVarArr.length) {
                return -1;
            }
            if (sVar == sVarArr[i7]) {
                return i7;
            }
            i7++;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && I.class == obj.getClass()) {
            I i7 = (I) obj;
            if (this.f426b.equals(i7.f426b) && Arrays.equals(this.f428d, i7.f428d)) {
                return true;
            }
        }
        return false;
    }

    public final void f() {
        String strD = d(this.f428d[0].f748d);
        int iE = e(this.f428d[0].f750f);
        int i7 = 1;
        while (true) {
            s[] sVarArr = this.f428d;
            if (i7 >= sVarArr.length) {
                return;
            }
            if (!strD.equals(d(sVarArr[i7].f748d))) {
                s[] sVarArr2 = this.f428d;
                c("languages", sVarArr2[0].f748d, sVarArr2[i7].f748d, i7);
                return;
            } else {
                if (iE != e(this.f428d[i7].f750f)) {
                    c("role flags", Integer.toBinaryString(this.f428d[0].f750f), Integer.toBinaryString(this.f428d[i7].f750f), i7);
                    return;
                }
                i7++;
            }
        }
    }

    public int hashCode() {
        if (this.f429e == 0) {
            this.f429e = ((527 + this.f426b.hashCode()) * 31) + Arrays.hashCode(this.f428d);
        }
        return this.f429e;
    }

    public String toString() {
        return this.f426b + ": " + Arrays.toString(this.f428d);
    }

    public I(String str, s... sVarArr) {
        j3.o.d(sVarArr.length > 0);
        this.f426b = str;
        this.f428d = sVarArr;
        this.f425a = sVarArr.length;
        String str2 = sVarArr[0].f759o;
        this.f427c = TextUtils.isEmpty(str2) ? z.k(sVarArr[0].f758n) : z.k(str2);
        f();
    }
}
