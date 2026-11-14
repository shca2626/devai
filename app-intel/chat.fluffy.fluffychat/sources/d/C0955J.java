package d;

import androidx.lifecycle.InterfaceC0809n;

/* renamed from: d.J, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0955J extends Q1.g {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0954I f15017a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0809n f15018b;

    public C0955J(AbstractC0954I abstractC0954I, InterfaceC0809n interfaceC0809n) {
        M5.m.e(abstractC0954I, "callback");
        this.f15017a = abstractC0954I;
        this.f15018b = interfaceC0809n;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0955J)) {
            return false;
        }
        C0955J c0955j = (C0955J) obj;
        return M5.m.a(this.f15017a, c0955j.f15017a) && M5.m.a(this.f15018b, c0955j.f15018b);
    }

    public int hashCode() {
        int iHashCode = this.f15017a.hashCode() * 31;
        InterfaceC0809n interfaceC0809n = this.f15018b;
        return iHashCode + (interfaceC0809n == null ? 0 : interfaceC0809n.hashCode());
    }

    public String toString() {
        return "OnBackPressedCallbackInfo(callback=" + this.f15017a + ", owner=" + this.f15018b + ')';
    }
}
