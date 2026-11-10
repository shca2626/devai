package k0;

import L5.l;
import M5.m;
import M5.n;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import k0.AbstractC1250f;
import y5.C1813h;
import z5.C1862F;
import z5.C1878l;
import z5.C1882p;
import z5.C1889w;

/* renamed from: k0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1247c extends AbstractC1250f {

    /* renamed from: a, reason: collision with root package name */
    public final Map f18812a;

    /* renamed from: b, reason: collision with root package name */
    public final C1246b f18813b;

    /* renamed from: k0.c$a */
    public static final class a extends n implements l {

        /* renamed from: m, reason: collision with root package name */
        public static final a f18814m = new a();

        public a() {
            super(1);
        }

        @Override // L5.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CharSequence a(Map.Entry entry) {
            m.e(entry, "entry");
            Object value = entry.getValue();
            return "  " + ((AbstractC1250f.a) entry.getKey()).a() + " = " + (value instanceof byte[] ? C1878l.F((byte[]) value, ", ", "[", "]", 0, null, null, 56, null) : String.valueOf(entry.getValue()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C1247c() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    @Override // k0.AbstractC1250f
    public Map a() {
        C1813h c1813h;
        Set<Map.Entry> setEntrySet = this.f18812a.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(S5.e.b(C1862F.e(C1882p.o(setEntrySet, 10)), 16));
        for (Map.Entry entry : setEntrySet) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                Object key = entry.getKey();
                byte[] bArr = (byte[]) value;
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                m.d(bArrCopyOf, "copyOf(this, size)");
                c1813h = new C1813h(key, bArrCopyOf);
            } else {
                c1813h = new C1813h(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(c1813h.c(), c1813h.d());
        }
        return AbstractC1245a.b(linkedHashMap);
    }

    @Override // k0.AbstractC1250f
    public Object b(AbstractC1250f.a aVar) {
        m.e(aVar, "key");
        Object obj = this.f18812a.get(aVar);
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        m.d(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    public final void e() {
        if (this.f18813b.a()) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof k0.C1247c
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            k0.c r6 = (k0.C1247c) r6
            java.util.Map r0 = r6.f18812a
            java.util.Map r2 = r5.f18812a
            r3 = 1
            if (r0 != r2) goto L10
            return r3
        L10:
            int r0 = r0.size()
            java.util.Map r2 = r5.f18812a
            int r2 = r2.size()
            if (r0 == r2) goto L1d
            return r1
        L1d:
            java.util.Map r6 = r6.f18812a
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L26
            return r3
        L26:
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L2e:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L67
            java.lang.Object r0 = r6.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.util.Map r2 = r5.f18812a
            java.lang.Object r4 = r0.getKey()
            java.lang.Object r2 = r2.get(r4)
            if (r2 == 0) goto L63
            java.lang.Object r0 = r0.getValue()
            boolean r4 = r0 instanceof byte[]
            if (r4 == 0) goto L5e
            boolean r4 = r2 instanceof byte[]
            if (r4 == 0) goto L63
            byte[] r0 = (byte[]) r0
            byte[] r2 = (byte[]) r2
            boolean r0 = java.util.Arrays.equals(r0, r2)
            if (r0 == 0) goto L63
            r0 = r3
            goto L64
        L5e:
            boolean r0 = M5.m.a(r0, r2)
            goto L64
        L63:
            r0 = r1
        L64:
            if (r0 != 0) goto L2e
            return r1
        L67:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.C1247c.equals(java.lang.Object):boolean");
    }

    public final void f() {
        e();
        this.f18812a.clear();
    }

    public final void g() {
        this.f18813b.b(true);
    }

    public final void h(AbstractC1250f.b... bVarArr) {
        m.e(bVarArr, "pairs");
        e();
        if (bVarArr.length <= 0) {
            return;
        }
        AbstractC1250f.b bVar = bVarArr[0];
        throw null;
    }

    public int hashCode() {
        Iterator it = this.f18812a.entrySet().iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            iHashCode += value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value.hashCode();
        }
        return iHashCode;
    }

    public final Object i(AbstractC1250f.a aVar) {
        m.e(aVar, "key");
        e();
        return this.f18812a.remove(aVar);
    }

    public final void j(AbstractC1250f.a aVar, Object obj) {
        m.e(aVar, "key");
        k(aVar, obj);
    }

    public final void k(AbstractC1250f.a aVar, Object obj) {
        m.e(aVar, "key");
        e();
        if (obj == null) {
            i(aVar);
            return;
        }
        if (obj instanceof Set) {
            this.f18812a.put(aVar, AbstractC1245a.a((Set) obj));
            return;
        }
        if (!(obj instanceof byte[])) {
            this.f18812a.put(aVar, obj);
            return;
        }
        Map map = this.f18812a;
        byte[] bArr = (byte[]) obj;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        m.d(bArrCopyOf, "copyOf(this, size)");
        map.put(aVar, bArrCopyOf);
    }

    public String toString() {
        return C1889w.L(this.f18812a.entrySet(), ",\n", "{\n", "\n}", 0, null, a.f18814m, 24, null);
    }

    public /* synthetic */ C1247c(Map map, boolean z7, int i7, M5.g gVar) {
        this((i7 & 1) != 0 ? new LinkedHashMap() : map, (i7 & 2) != 0 ? true : z7);
    }

    public C1247c(Map map, boolean z7) {
        m.e(map, "preferencesMap");
        this.f18812a = map;
        this.f18813b = new C1246b(z7);
    }
}
