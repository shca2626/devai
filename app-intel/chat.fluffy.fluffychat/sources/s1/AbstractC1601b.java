package s1;

import B0.x;
import B0.y;
import j3.AbstractC1228c;
import o3.g;

/* renamed from: s1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1601b implements y.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f22389a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22390b;

    public AbstractC1601b(String str, String str2) {
        this.f22389a = AbstractC1228c.g(str);
        this.f22390b = str2;
    }

    @Override // B0.y.a
    public void a(x.b bVar) {
        String str = this.f22389a;
        str.getClass();
        switch (str) {
            case "TOTALTRACKS":
                Integer numQ = g.q(this.f22390b);
                if (numQ != null) {
                    bVar.s0(numQ);
                    break;
                }
                break;
            case "TOTALDISCS":
                Integer numQ2 = g.q(this.f22390b);
                if (numQ2 != null) {
                    bVar.r0(numQ2);
                    break;
                }
                break;
            case "TRACKNUMBER":
                Integer numQ3 = g.q(this.f22390b);
                if (numQ3 != null) {
                    bVar.t0(numQ3);
                    break;
                }
                break;
            case "ALBUM":
                bVar.Q(this.f22390b);
                break;
            case "GENRE":
                bVar.d0(this.f22390b);
                break;
            case "TITLE":
                bVar.q0(this.f22390b);
                break;
            case "DESCRIPTION":
                bVar.X(this.f22390b);
                break;
            case "DISCNUMBER":
                Integer numQ4 = g.q(this.f22390b);
                if (numQ4 != null) {
                    bVar.Y(numQ4);
                    break;
                }
                break;
            case "ALBUMARTIST":
                bVar.P(this.f22390b);
                break;
            case "ARTIST":
                bVar.R(this.f22390b);
                break;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AbstractC1601b abstractC1601b = (AbstractC1601b) obj;
            if (this.f22389a.equals(abstractC1601b.f22389a) && this.f22390b.equals(abstractC1601b.f22390b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f22389a.hashCode()) * 31) + this.f22390b.hashCode();
    }

    public String toString() {
        return "VC: " + this.f22389a + "=" + this.f22390b;
    }
}
