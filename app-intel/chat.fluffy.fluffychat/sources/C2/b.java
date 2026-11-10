package C2;

import java.util.List;
import n2.C1346a;
import y5.C1813h;

/* loaded from: classes.dex */
public abstract class b {
    public static final Object a(C1346a c1346a, Object obj) {
        M5.m.e(c1346a, "<this>");
        M5.m.e(obj, "data");
        List listD = c1346a.d();
        int size = listD.size() - 1;
        if (size < 0) {
            return obj;
        }
        int i7 = 0;
        while (true) {
            int i8 = i7 + 1;
            C1813h c1813h = (C1813h) listD.get(i7);
            u2.b bVar = (u2.b) c1813h.a();
            if (((Class) c1813h.b()).isAssignableFrom(obj.getClass()) && bVar.a(obj)) {
                obj = bVar.b(obj);
            }
            if (i8 > size) {
                return obj;
            }
            i7 = i8;
        }
    }

    public static final r2.h b(C1346a c1346a, Object obj, v6.g gVar, String str) {
        Object obj2;
        M5.m.e(c1346a, "<this>");
        M5.m.e(obj, "data");
        M5.m.e(gVar, "source");
        List listA = c1346a.a();
        int size = listA.size() - 1;
        if (size >= 0) {
            int i7 = 0;
            while (true) {
                int i8 = i7 + 1;
                obj2 = listA.get(i7);
                if (((r2.h) obj2).a(gVar, str)) {
                    break;
                }
                if (i8 > size) {
                    break;
                }
                i7 = i8;
            }
            obj2 = null;
        } else {
            obj2 = null;
        }
        r2.h hVar = (r2.h) obj2;
        if (hVar != null) {
            return hVar;
        }
        throw new IllegalStateException(M5.m.j("Unable to decode data. No decoder supports: ", obj).toString());
    }

    public static final s2.g c(C1346a c1346a, Object obj) {
        Object obj2;
        M5.m.e(c1346a, "<this>");
        M5.m.e(obj, "data");
        List listB = c1346a.b();
        int size = listB.size() - 1;
        if (size >= 0) {
            int i7 = 0;
            while (true) {
                int i8 = i7 + 1;
                obj2 = listB.get(i7);
                C1813h c1813h = (C1813h) obj2;
                s2.g gVar = (s2.g) c1813h.a();
                if (((Class) c1813h.b()).isAssignableFrom(obj.getClass()) && gVar.a(obj)) {
                    break;
                }
                if (i8 > size) {
                    break;
                }
                i7 = i8;
            }
            obj2 = null;
        } else {
            obj2 = null;
        }
        C1813h c1813h2 = (C1813h) obj2;
        if (c1813h2 != null) {
            return (s2.g) c1813h2.c();
        }
        throw new IllegalStateException(M5.m.j("Unable to fetch data. No fetcher supports: ", obj).toString());
    }
}
