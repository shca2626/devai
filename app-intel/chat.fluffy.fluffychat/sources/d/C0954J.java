package d;

import androidx.lifecycle.InterfaceC0808n;

/* renamed from: d.J, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0954J extends Q1.g {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0953I f15017a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0808n f15018b;

    public C0954J(AbstractC0953I abstractC0953I, InterfaceC0808n interfaceC0808n) {
        M5.m.e(abstractC0953I, "callback");
        this.f15017a = abstractC0953I;
        this.f15018b = interfaceC0808n;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0954J)) {
            return false;
        }
        C0954J c0954j = (C0954J) obj;
        return M5.m.a(this.f15017a, c0954j.f15017a) && M5.m.a(this.f15018b, c0954j.f15018b);
    }

    public int hashCode() {
        int iHashCode = this.f15017a.hashCode() * 31;
        InterfaceC0808n interfaceC0808n = this.f15018b;
        return iHashCode + (interfaceC0808n == null ? 0 : interfaceC0808n.hashCode());
    }

    public String toString() {
        return "OnBackPressedCallbackInfo(callback=" + this.f15017a + ", owner=" + this.f15018b + ')';
    }
}
