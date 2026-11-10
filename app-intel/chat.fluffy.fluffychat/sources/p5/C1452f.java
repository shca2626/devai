package p5;

import android.util.Log;
import java.util.List;
import z5.C1881o;

/* renamed from: p5.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1452f {

    /* renamed from: a, reason: collision with root package name */
    public static final C1452f f20990a = new C1452f();

    public final List a(Throwable th) {
        M5.m.e(th, "exception");
        return C1881o.l(th.getClass().getSimpleName(), th.toString(), "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
    }
}
