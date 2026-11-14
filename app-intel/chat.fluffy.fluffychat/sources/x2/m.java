package x2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import y5.AbstractC1816l;
import z5.C1866G;

/* loaded from: classes.dex */
public final class m implements Iterable, N5.a {

    /* renamed from: m, reason: collision with root package name */
    public static final b f23572m = new b(null);

    /* renamed from: n, reason: collision with root package name */
    public static final m f23573n = new m();

    /* renamed from: l, reason: collision with root package name */
    public final Map f23574l;

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
            return (obj instanceof m) && M5.m.a(this.f23574l, ((m) obj).f23574l);
        }
        return true;
    }

    public final Map g() {
        if (isEmpty()) {
            return C1866G.h();
        }
        Map map = this.f23574l;
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
        return this.f23574l.hashCode();
    }

    public final boolean isEmpty() {
        return this.f23574l.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        Map map = this.f23574l;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            android.support.v4.media.session.b.a(entry.getValue());
            arrayList.add(AbstractC1816l.a(str, null));
        }
        return arrayList.iterator();
    }

    public String toString() {
        return "Parameters(map=" + this.f23574l + ')';
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Map f23575a;

        public a() {
            this.f23575a = new LinkedHashMap();
        }

        public final m a() {
            return new m(C1866G.s(this.f23575a), null);
        }

        public a(m mVar) {
            M5.m.e(mVar, "parameters");
            this.f23575a = C1866G.u(mVar.f23574l);
        }
    }

    public m(Map map) {
        this.f23574l = map;
    }

    public m() {
        this(C1866G.h());
    }
}
