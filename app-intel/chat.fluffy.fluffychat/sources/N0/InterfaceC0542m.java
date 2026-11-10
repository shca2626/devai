package N0;

import N0.t;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/* renamed from: N0.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0542m {

    /* renamed from: N0.m$a */
    public static class a extends IOException {

        /* renamed from: l, reason: collision with root package name */
        public final int f5905l;

        public a(Throwable th, int i7) {
            super(th);
            this.f5905l = i7;
        }
    }

    static void f(InterfaceC0542m interfaceC0542m, InterfaceC0542m interfaceC0542m2) {
        if (interfaceC0542m == interfaceC0542m2) {
            return;
        }
        if (interfaceC0542m2 != null) {
            interfaceC0542m2.b(null);
        }
        if (interfaceC0542m != null) {
            interfaceC0542m.a(null);
        }
    }

    void a(t.a aVar);

    void b(t.a aVar);

    UUID c();

    boolean d();

    Map e();

    boolean g(String str);

    int getState();

    a h();

    H0.b i();
}
