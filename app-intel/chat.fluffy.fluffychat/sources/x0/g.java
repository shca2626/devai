package x0;

import M5.m;
import androidx.lifecycle.M;
import androidx.lifecycle.N;
import w0.AbstractC1725a;

/* loaded from: classes.dex */
public abstract class g {
    public static final M a(N.c cVar, T5.b bVar, AbstractC1725a abstractC1725a) {
        m.e(cVar, "factory");
        m.e(bVar, "modelClass");
        m.e(abstractC1725a, "extras");
        try {
            try {
                return cVar.c(bVar, abstractC1725a);
            } catch (AbstractMethodError unused) {
                return cVar.a(K5.a.a(bVar));
            }
        } catch (AbstractMethodError unused2) {
            return cVar.b(K5.a.a(bVar), abstractC1725a);
        }
    }
}
