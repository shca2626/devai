package v2;

import W5.InterfaceC0653w0;
import androidx.lifecycle.AbstractC0805j;

/* renamed from: v2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1678a extends s {

    /* renamed from: l, reason: collision with root package name */
    public final AbstractC0805j f22917l;

    /* renamed from: m, reason: collision with root package name */
    public final InterfaceC0653w0 f22918m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1678a(AbstractC0805j abstractC0805j, InterfaceC0653w0 interfaceC0653w0) {
        super(null);
        M5.m.e(abstractC0805j, "lifecycle");
        M5.m.e(interfaceC0653w0, "job");
        this.f22917l = abstractC0805j;
        this.f22918m = interfaceC0653w0;
    }

    @Override // v2.s
    public void a() {
        this.f22917l.c(this);
    }

    @Override // v2.s
    public void b() {
        InterfaceC0653w0.G(this.f22918m, null, 1, null);
    }
}
