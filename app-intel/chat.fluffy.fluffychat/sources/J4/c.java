package J4;

import M5.g;
import M5.m;
import android.util.Log;

/* loaded from: classes.dex */
public final class c implements b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f4801a;

    public c() {
        this(false, 1, null);
    }

    @Override // J4.b
    public void a(String str, String str2, Throwable th) {
        m.e(str, "tag");
        m.e(str2, "message");
        m.e(th, "throwable");
        if (d()) {
            Log.e(c(str), str2, th);
        }
    }

    @Override // J4.b
    public void b(String str, String str2) {
        m.e(str, "tag");
        m.e(str2, "message");
        if (d()) {
            Log.d(c(str), str2);
        }
    }

    public final String c(String str) {
        return "AS/" + str;
    }

    public boolean d() {
        return this.f4801a;
    }

    public c(boolean z7) {
        this.f4801a = z7;
    }

    public /* synthetic */ c(boolean z7, int i7, g gVar) {
        this((i7 & 1) != 0 ? false : z7);
    }
}
