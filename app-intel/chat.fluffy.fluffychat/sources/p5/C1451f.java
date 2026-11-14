package p5;

import android.util.Log;
import java.util.List;
import z5.C1884o;

/* renamed from: p5.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1451f {

    /* renamed from: a, reason: collision with root package name */
    public static final C1451f f20996a = new C1451f();

    public final List a(Throwable th) {
        M5.m.e(th, "exception");
        return C1884o.l(th.getClass().getSimpleName(), th.toString(), "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
    }
}
