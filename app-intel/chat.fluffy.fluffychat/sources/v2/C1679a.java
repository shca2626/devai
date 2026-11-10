package v2;

import W5.InterfaceC0652w0;
import androidx.lifecycle.AbstractC0804j;

/* renamed from: v2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1679a extends s {

    /* renamed from: l, reason: collision with root package name */
    public final AbstractC0804j f22911l;

    /* renamed from: m, reason: collision with root package name */
    public final InterfaceC0652w0 f22912m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1679a(AbstractC0804j abstractC0804j, InterfaceC0652w0 interfaceC0652w0) {
        super(null);
        M5.m.e(abstractC0804j, "lifecycle");
        M5.m.e(interfaceC0652w0, "job");
        this.f22911l = abstractC0804j;
        this.f22912m = interfaceC0652w0;
    }

    @Override // v2.s
    public void a() {
        this.f22911l.c(this);
    }

    @Override // v2.s
    public void b() {
        InterfaceC0652w0.G(this.f22912m, null, 1, null);
    }
}
