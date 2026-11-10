package D3;

import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final String f1746a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f1747b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1748c;

    /* renamed from: d, reason: collision with root package name */
    public p[] f1749d;

    /* renamed from: e, reason: collision with root package name */
    public final a f1750e;

    /* renamed from: f, reason: collision with root package name */
    public Map f1751f;

    /* renamed from: g, reason: collision with root package name */
    public final long f1752g;

    public n(String str, byte[] bArr, p[] pVarArr, a aVar) {
        this(str, bArr, pVarArr, aVar, System.currentTimeMillis());
    }

    public void a(p[] pVarArr) {
        p[] pVarArr2 = this.f1749d;
        if (pVarArr2 == null) {
            this.f1749d = pVarArr;
            return;
        }
        if (pVarArr == null || pVarArr.length <= 0) {
            return;
        }
        p[] pVarArr3 = new p[pVarArr2.length + pVarArr.length];
        System.arraycopy(pVarArr2, 0, pVarArr3, 0, pVarArr2.length);
        System.arraycopy(pVarArr, 0, pVarArr3, pVarArr2.length, pVarArr.length);
        this.f1749d = pVarArr3;
    }

    public a b() {
        return this.f1750e;
    }

    public byte[] c() {
        return this.f1747b;
    }

    public Map d() {
        return this.f1751f;
    }

    public p[] e() {
        return this.f1749d;
    }

    public String f() {
        return this.f1746a;
    }

    public void g(Map map) {
        if (map != null) {
            Map map2 = this.f1751f;
            if (map2 == null) {
                this.f1751f = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void h(o oVar, Object obj) {
        if (this.f1751f == null) {
            this.f1751f = new EnumMap(o.class);
        }
        this.f1751f.put(oVar, obj);
    }

    public String toString() {
        return this.f1746a;
    }

    public n(String str, byte[] bArr, p[] pVarArr, a aVar, long j7) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, pVarArr, aVar, j7);
    }

    public n(String str, byte[] bArr, int i7, p[] pVarArr, a aVar, long j7) {
        this.f1746a = str;
        this.f1747b = bArr;
        this.f1748c = i7;
        this.f1749d = pVarArr;
        this.f1750e = aVar;
        this.f1751f = null;
        this.f1752g = j7;
    }
}
