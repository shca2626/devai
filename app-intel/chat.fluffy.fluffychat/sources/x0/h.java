package x0;

import M5.m;
import androidx.lifecycle.InterfaceC0802h;
import androidx.lifecycle.M;
import androidx.lifecycle.N;
import androidx.lifecycle.P;
import w0.AbstractC1725a;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f23451a = new h();

    public final AbstractC1725a a(P p7) {
        m.e(p7, "owner");
        return p7 instanceof InterfaceC0802h ? ((InterfaceC0802h) p7).v() : AbstractC1725a.b.f23253c;
    }

    public final N.c b(P p7) {
        m.e(p7, "owner");
        return p7 instanceof InterfaceC0802h ? ((InterfaceC0802h) p7).u() : C1761b.f23441b;
    }

    public final String c(T5.b bVar) {
        m.e(bVar, "modelClass");
        String strA = AbstractC1760a.a(bVar);
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return "androidx.lifecycle.ViewModelProvider.DefaultKey:" + strA;
    }

    public final M d() {
        throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
    }
}
