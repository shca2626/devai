package s1;

import B0.x;
import B0.y;
import j3.AbstractC1229c;
import o3.g;

/* renamed from: s1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1602b implements y.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f22383a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22384b;

    public AbstractC1602b(String str, String str2) {
        this.f22383a = AbstractC1229c.g(str);
        this.f22384b = str2;
    }

    @Override // B0.y.a
    public void a(x.b bVar) {
        String str = this.f22383a;
        str.getClass();
        switch (str) {
            case "TOTALTRACKS":
                Integer numQ = g.q(this.f22384b);
                if (numQ != null) {
                    bVar.s0(numQ);
                    break;
                }
                break;
            case "TOTALDISCS":
                Integer numQ2 = g.q(this.f22384b);
                if (numQ2 != null) {
                    bVar.r0(numQ2);
                    break;
                }
                break;
            case "TRACKNUMBER":
                Integer numQ3 = g.q(this.f22384b);
                if (numQ3 != null) {
                    bVar.t0(numQ3);
                    break;
                }
                break;
            case "ALBUM":
                bVar.Q(this.f22384b);
                break;
            case "GENRE":
                bVar.d0(this.f22384b);
                break;
            case "TITLE":
                bVar.q0(this.f22384b);
                break;
            case "DESCRIPTION":
                bVar.X(this.f22384b);
                break;
            case "DISCNUMBER":
                Integer numQ4 = g.q(this.f22384b);
                if (numQ4 != null) {
                    bVar.Y(numQ4);
                    break;
                }
                break;
            case "ALBUMARTIST":
                bVar.P(this.f22384b);
                break;
            case "ARTIST":
                bVar.R(this.f22384b);
                break;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AbstractC1602b abstractC1602b = (AbstractC1602b) obj;
            if (this.f22383a.equals(abstractC1602b.f22383a) && this.f22384b.equals(abstractC1602b.f22384b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f22383a.hashCode()) * 31) + this.f22384b.hashCode();
    }

    public String toString() {
        return "VC: " + this.f22383a + "=" + this.f22384b;
    }
}
