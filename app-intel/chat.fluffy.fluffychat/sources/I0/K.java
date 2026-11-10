package I0;

import Y0.F;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.IOException;

/* loaded from: classes.dex */
public final class K extends B0.B {

    /* renamed from: A, reason: collision with root package name */
    public final boolean f3709A;

    /* renamed from: u, reason: collision with root package name */
    public final int f3710u;

    /* renamed from: v, reason: collision with root package name */
    public final String f3711v;

    /* renamed from: w, reason: collision with root package name */
    public final int f3712w;

    /* renamed from: x, reason: collision with root package name */
    public final B0.s f3713x;

    /* renamed from: y, reason: collision with root package name */
    public final int f3714y;

    /* renamed from: z, reason: collision with root package name */
    public final F.b f3715z;

    public K(int i7, Throwable th, int i8) {
        this(i7, th, null, i8, null, -1, null, 4, null, false);
    }

    public static K b(Throwable th, String str, int i7, B0.s sVar, int i8, F.b bVar, boolean z7, int i9) {
        if (sVar == null) {
            i8 = 4;
        }
        return new K(1, th, null, i9, str, i7, sVar, i8, bVar, z7);
    }

    public static K c(IOException iOException, int i7) {
        return new K(0, iOException, i7);
    }

    public static K d(RuntimeException runtimeException, int i7) {
        return new K(2, runtimeException, i7);
    }

    public static String e(int i7, String str, String str2, int i8, B0.s sVar, int i9) {
        String str3;
        if (i7 == 0) {
            str3 = "Source error";
        } else if (i7 != 1) {
            str3 = i7 != 3 ? "Unexpected runtime error" : "Remote error";
        } else {
            str3 = str2 + " error, index=" + i8 + ", format=" + sVar + ", format_supported=" + E0.U.c0(i9);
        }
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        return str3 + ": " + str;
    }

    public K a(F.b bVar) {
        return new K((String) E0.U.i(getMessage()), getCause(), this.f334l, this.f3710u, this.f3711v, this.f3712w, this.f3713x, this.f3714y, bVar, this.f335m, this.f3709A);
    }

    public Exception f() {
        j3.o.v(this.f3710u == 1);
        return (Exception) j3.o.q(getCause());
    }

    public IOException g() {
        j3.o.v(this.f3710u == 0);
        return (IOException) j3.o.q(getCause());
    }

    public RuntimeException h() {
        j3.o.v(this.f3710u == 2);
        return (RuntimeException) j3.o.q(getCause());
    }

    public K(int i7, Throwable th, String str, int i8, String str2, int i9, B0.s sVar, int i10, F.b bVar, boolean z7) {
        this(e(i7, str, str2, i9, sVar, i10), th, i8, i7, str2, i9, sVar, i10, bVar, SystemClock.elapsedRealtime(), z7);
    }

    public K(String str, Throwable th, int i7, int i8, String str2, int i9, B0.s sVar, int i10, F.b bVar, long j7, boolean z7) {
        super(str, th, i7, Bundle.EMPTY, j7);
        j3.o.d(!z7 || i8 == 1);
        j3.o.d(th != null || i8 == 3);
        this.f3710u = i8;
        this.f3711v = str2;
        this.f3712w = i9;
        this.f3713x = sVar;
        this.f3714y = i10;
        this.f3715z = bVar;
        this.f3709A = z7;
    }
}
