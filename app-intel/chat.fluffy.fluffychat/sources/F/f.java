package F;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class f implements d {

    /* renamed from: d, reason: collision with root package name */
    public m f2413d;

    /* renamed from: f, reason: collision with root package name */
    public int f2415f;

    /* renamed from: g, reason: collision with root package name */
    public int f2416g;

    /* renamed from: a, reason: collision with root package name */
    public d f2410a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2411b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2412c = false;

    /* renamed from: e, reason: collision with root package name */
    public a f2414e = a.UNKNOWN;

    /* renamed from: h, reason: collision with root package name */
    public int f2417h = 1;

    /* renamed from: i, reason: collision with root package name */
    public g f2418i = null;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2419j = false;

    /* renamed from: k, reason: collision with root package name */
    public List f2420k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public List f2421l = new ArrayList();

    public enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public f(m mVar) {
        this.f2413d = mVar;
    }

    @Override // F.d
    public void a(d dVar) {
        Iterator it = this.f2421l.iterator();
        while (it.hasNext()) {
            if (!((f) it.next()).f2419j) {
                return;
            }
        }
        this.f2412c = true;
        d dVar2 = this.f2410a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.f2411b) {
            this.f2413d.a(this);
            return;
        }
        f fVar = null;
        int i7 = 0;
        for (f fVar2 : this.f2421l) {
            if (!(fVar2 instanceof g)) {
                i7++;
                fVar = fVar2;
            }
        }
        if (fVar != null && i7 == 1 && fVar.f2419j) {
            g gVar = this.f2418i;
            if (gVar != null) {
                if (!gVar.f2419j) {
                    return;
                } else {
                    this.f2415f = this.f2417h * gVar.f2416g;
                }
            }
            d(fVar.f2416g + this.f2415f);
        }
        d dVar3 = this.f2410a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b(d dVar) {
        this.f2420k.add(dVar);
        if (this.f2419j) {
            dVar.a(dVar);
        }
    }

    public void c() {
        this.f2421l.clear();
        this.f2420k.clear();
        this.f2419j = false;
        this.f2416g = 0;
        this.f2412c = false;
        this.f2411b = false;
    }

    public void d(int i7) {
        if (this.f2419j) {
            return;
        }
        this.f2419j = true;
        this.f2416g = i7;
        for (d dVar : this.f2420k) {
            dVar.a(dVar);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2413d.f2446b.p());
        sb.append(":");
        sb.append(this.f2414e);
        sb.append("(");
        sb.append(this.f2419j ? Integer.valueOf(this.f2416g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f2421l.size());
        sb.append(":d=");
        sb.append(this.f2420k.size());
        sb.append(">");
        return sb.toString();
    }
}
