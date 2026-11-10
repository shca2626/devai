package u3;

import java.util.Set;
import w3.z;

/* renamed from: u3.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1657m extends AbstractC1654j {

    /* renamed from: l, reason: collision with root package name */
    public final z f22857l = new z(false);

    public Set entrySet() {
        return this.f22857l.entrySet();
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof C1657m) && ((C1657m) obj).f22857l.equals(this.f22857l);
        }
        return true;
    }

    public int hashCode() {
        return this.f22857l.hashCode();
    }

    public void o(String str, AbstractC1654j abstractC1654j) {
        z zVar = this.f22857l;
        if (abstractC1654j == null) {
            abstractC1654j = C1656l.f22856l;
        }
        zVar.put(str, abstractC1654j);
    }

    public boolean p(String str) {
        return this.f22857l.containsKey(str);
    }

    public AbstractC1654j q(String str) {
        return (AbstractC1654j) this.f22857l.remove(str);
    }
}
