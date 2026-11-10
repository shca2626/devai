package i2;

import M5.m;
import android.content.Context;
import g2.j;
import h2.InterfaceC1138a;
import java.util.concurrent.Executor;
import z5.C1881o;

/* loaded from: classes.dex */
public final class c implements InterfaceC1138a {
    public static final void d(Y.a aVar) {
        m.e(aVar, "$callback");
        aVar.accept(new j(C1881o.i()));
    }

    @Override // h2.InterfaceC1138a
    public void a(Y.a aVar) {
        m.e(aVar, "callback");
    }

    @Override // h2.InterfaceC1138a
    public void b(Context context, Executor executor, final Y.a aVar) {
        m.e(context, "context");
        m.e(executor, "executor");
        m.e(aVar, "callback");
        executor.execute(new Runnable() { // from class: i2.b
            @Override // java.lang.Runnable
            public final void run() {
                c.d(aVar);
            }
        });
    }
}
