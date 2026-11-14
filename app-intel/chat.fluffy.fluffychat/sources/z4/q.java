package z4;

import y5.AbstractC1816l;
import y5.C1812h;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f24183a = new q();

    public final C1812h a(String str, String str2) {
        M5.m.e(str, "currentName");
        M5.m.e(str2, "extension");
        C1812h c1812hB = b(str, V5.k.f8883m.a(str2));
        return c((String) c1812hB.a(), (Integer) c1812hB.b());
    }

    public final C1812h b(String str, String str2) {
        V5.k kVar = new V5.k("^(.*)\\." + str2 + " \\((\\d+)\\)$");
        V5.k kVar2 = new V5.k("^(.*) \\((\\d+)\\)\\." + str2 + "$");
        V5.k kVar3 = new V5.k("^(.*)\\." + str2 + "$");
        V5.k kVar4 = new V5.k("^(.*)\\." + str2 + "\\.[^./\\\\]+$");
        if (kVar.b(str)) {
            V5.h hVarA = kVar.a(str);
            M5.m.b(hVarA);
            return AbstractC1816l.a(hVarA.a().get(1), Integer.valueOf(Integer.parseInt((String) hVarA.a().get(2))));
        }
        if (kVar2.b(str)) {
            V5.h hVarA2 = kVar2.a(str);
            M5.m.b(hVarA2);
            return AbstractC1816l.a(hVarA2.a().get(1), Integer.valueOf(Integer.parseInt((String) hVarA2.a().get(2))));
        }
        if (kVar3.b(str)) {
            V5.h hVarA3 = kVar3.a(str);
            M5.m.b(hVarA3);
            return AbstractC1816l.a(hVarA3.a().get(1), null);
        }
        if (!kVar4.b(str)) {
            return AbstractC1816l.a(str, null);
        }
        V5.h hVarA4 = kVar4.a(str);
        M5.m.b(hVarA4);
        return AbstractC1816l.a(hVarA4.a().get(1), null);
    }

    public final C1812h c(String str, Integer num) throws NumberFormatException {
        V5.k kVar = new V5.k("^(.*) \\((\\d+)\\)$");
        while (true) {
            V5.h hVarA = kVar.a(str);
            if (hVarA == null) {
                return AbstractC1816l.a(str, num);
            }
            str = (String) hVarA.a().get(1);
            num = Integer.valueOf((num != null ? num.intValue() : 0) + Integer.parseInt((String) hVarA.a().get(2)));
        }
    }
}
