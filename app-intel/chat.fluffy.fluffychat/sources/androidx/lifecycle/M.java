package androidx.lifecycle;

/* loaded from: classes.dex */
public abstract class M {

    /* renamed from: a, reason: collision with root package name */
    public final x0.e f12375a = new x0.e();

    public final void a(String str, AutoCloseable autoCloseable) throws Exception {
        M5.m.e(str, "key");
        M5.m.e(autoCloseable, "closeable");
        x0.e eVar = this.f12375a;
        if (eVar != null) {
            eVar.d(str, autoCloseable);
        }
    }

    public final void b() {
        x0.e eVar = this.f12375a;
        if (eVar != null) {
            eVar.e();
        }
        d();
    }

    public final AutoCloseable c(String str) {
        M5.m.e(str, "key");
        x0.e eVar = this.f12375a;
        if (eVar != null) {
            return eVar.g(str);
        }
        return null;
    }

    public void d() {
    }
}
