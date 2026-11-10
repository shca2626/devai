package d2;

import M5.m;

/* renamed from: d2.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0985i extends AbstractC0984h {

    /* renamed from: b, reason: collision with root package name */
    public final Object f15141b;

    /* renamed from: c, reason: collision with root package name */
    public final String f15142c;

    /* renamed from: d, reason: collision with root package name */
    public final EnumC0986j f15143d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC0983g f15144e;

    public C0985i(Object obj, String str, EnumC0986j enumC0986j, InterfaceC0983g interfaceC0983g) {
        m.e(obj, "value");
        m.e(str, "tag");
        m.e(enumC0986j, "verificationMode");
        m.e(interfaceC0983g, "logger");
        this.f15141b = obj;
        this.f15142c = str;
        this.f15143d = enumC0986j;
        this.f15144e = interfaceC0983g;
    }

    @Override // d2.AbstractC0984h
    public Object a() {
        return this.f15141b;
    }

    @Override // d2.AbstractC0984h
    public AbstractC0984h c(String str, L5.l lVar) {
        m.e(str, "message");
        m.e(lVar, "condition");
        return ((Boolean) lVar.a(this.f15141b)).booleanValue() ? this : new C0982f(this.f15141b, this.f15142c, str, this.f15144e, this.f15143d);
    }
}
