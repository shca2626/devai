package d2;

import M5.m;

/* renamed from: d2.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0986i extends AbstractC0985h {

    /* renamed from: b, reason: collision with root package name */
    public final Object f15141b;

    /* renamed from: c, reason: collision with root package name */
    public final String f15142c;

    /* renamed from: d, reason: collision with root package name */
    public final EnumC0987j f15143d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC0984g f15144e;

    public C0986i(Object obj, String str, EnumC0987j enumC0987j, InterfaceC0984g interfaceC0984g) {
        m.e(obj, "value");
        m.e(str, "tag");
        m.e(enumC0987j, "verificationMode");
        m.e(interfaceC0984g, "logger");
        this.f15141b = obj;
        this.f15142c = str;
        this.f15143d = enumC0987j;
        this.f15144e = interfaceC0984g;
    }

    @Override // d2.AbstractC0985h
    public Object a() {
        return this.f15141b;
    }

    @Override // d2.AbstractC0985h
    public AbstractC0985h c(String str, L5.l lVar) {
        m.e(str, "message");
        m.e(lVar, "condition");
        return ((Boolean) lVar.a(this.f15141b)).booleanValue() ? this : new C0983f(this.f15141b, this.f15142c, str, this.f15144e, this.f15143d);
    }
}
