package x2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import y5.AbstractC1817l;
import z5.C1863G;

/* loaded from: classes.dex */
public final class m implements Iterable, N5.a {

    /* renamed from: m, reason: collision with root package name */
    public static final b f23566m = new b(null);

    /* renamed from: n, reason: collision with root package name */
    public static final m f23567n = new m();

    /* renamed from: l, reason: collision with root package name */
    public final Map f23568l;

    public static final class b {
        public /* synthetic */ b(M5.g gVar) {
            this();
        }

        public b() {
        }
    }

    public /* synthetic */ m(Map map, M5.g gVar) {
        this(map);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof m) && M5.m.a(this.f23568l, ((m) obj).f23568l);
        }
        return true;
    }

    public final Map g() {
        if (isEmpty()) {
            return C1863G.h();
        }
        Map map = this.f23568l;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return linkedHashMap;
        }
        android.support.v4.media.session.b.a(((Map.Entry) it.next()).getValue());
        throw null;
    }

    public final a h() {
        return new a(this);
    }

    public int hashCode() {
        return this.f23568l.hashCode();
    }

    public final boolean isEmpty() {
        return this.f23568l.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        Map map = this.f23568l;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            android.support.v4.media.session.b.a(entry.getValue());
            arrayList.add(AbstractC1817l.a(str, null));
        }
        return arrayList.iterator();
    }

    public String toString() {
        return "Parameters(map=" + this.f23568l + ')';
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Map f23569a;

        public a() {
            this.f23569a = new LinkedHashMap();
        }

        public final m a() {
            return new m(C1863G.s(this.f23569a), null);
        }

        public a(m mVar) {
            M5.m.e(mVar, "parameters");
            this.f23569a = C1863G.u(mVar.f23568l);
        }
    }

    public m(Map map) {
        this.f23568l = map;
    }

    public m() {
        this(C1863G.h());
    }
}
