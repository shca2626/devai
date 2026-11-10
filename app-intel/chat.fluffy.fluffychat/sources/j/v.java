package j;

import java.util.LinkedHashSet;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class v {
    public static V.h a(V.h hVar, V.h hVar2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i7 = 0;
        while (i7 < hVar.f() + hVar2.f()) {
            Locale localeC = i7 < hVar.f() ? hVar.c(i7) : hVar2.c(i7 - hVar.f());
            if (localeC != null) {
                linkedHashSet.add(localeC);
            }
            i7++;
        }
        return V.h.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    public static V.h b(V.h hVar, V.h hVar2) {
        return (hVar == null || hVar.e()) ? V.h.d() : a(hVar, hVar2);
    }
}
