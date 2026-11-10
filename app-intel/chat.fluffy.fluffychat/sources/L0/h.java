package L0;

import G0.j;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class h {
    public static G0.j a(M0.j jVar, String str, M0.i iVar, int i7, Map map) {
        return new j.b().i(iVar.b(str)).h(iVar.f5579a).g(iVar.f5580b).f(b(jVar, iVar)).b(i7).e(map).a();
    }

    public static String b(M0.j jVar, M0.i iVar) {
        String strK = jVar.k();
        return strK != null ? strK : iVar.b(((M0.b) jVar.f5585c.get(0)).f5529a).toString();
    }
}
