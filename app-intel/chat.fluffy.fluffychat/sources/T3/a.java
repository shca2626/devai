package T3;

import java.util.List;

/* loaded from: classes.dex */
public abstract class a {
    public static J3.a a(List list) {
        int size = list.size() * 2;
        int i7 = size - 1;
        if (((b) list.get(list.size() - 1)).c() == null) {
            i7 = size - 2;
        }
        J3.a aVar = new J3.a(i7 * 12);
        int i8 = 0;
        int iB = ((b) list.get(0)).c().b();
        for (int i9 = 11; i9 >= 0; i9--) {
            if (((1 << i9) & iB) != 0) {
                aVar.o(i8);
            }
            i8++;
        }
        for (int i10 = 1; i10 < list.size(); i10++) {
            b bVar = (b) list.get(i10);
            int iB2 = bVar.b().b();
            for (int i11 = 11; i11 >= 0; i11--) {
                if (((1 << i11) & iB2) != 0) {
                    aVar.o(i8);
                }
                i8++;
            }
            if (bVar.c() != null) {
                int iB3 = bVar.c().b();
                for (int i12 = 11; i12 >= 0; i12--) {
                    if (((1 << i12) & iB3) != 0) {
                        aVar.o(i8);
                    }
                    i8++;
                }
            }
        }
        return aVar;
    }
}
