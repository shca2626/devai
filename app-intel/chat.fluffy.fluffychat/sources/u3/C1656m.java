package u3;

import java.util.Set;
import w3.z;

/* renamed from: u3.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1656m extends AbstractC1653j {

    /* renamed from: l, reason: collision with root package name */
    public final z f22863l = new z(false);

    public Set entrySet() {
        return this.f22863l.entrySet();
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof C1656m) && ((C1656m) obj).f22863l.equals(this.f22863l);
        }
        return true;
    }

    public int hashCode() {
        return this.f22863l.hashCode();
    }

    public void o(String str, AbstractC1653j abstractC1653j) {
        z zVar = this.f22863l;
        if (abstractC1653j == null) {
            abstractC1653j = C1655l.f22862l;
        }
        zVar.put(str, abstractC1653j);
    }

    public boolean p(String str) {
        return this.f22863l.containsKey(str);
    }

    public AbstractC1653j q(String str) {
        return (AbstractC1653j) this.f22863l.remove(str);
    }
}
