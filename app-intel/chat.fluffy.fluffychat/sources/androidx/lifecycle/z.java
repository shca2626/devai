package androidx.lifecycle;

import androidx.lifecycle.AbstractC0804j;
import androidx.lifecycle.C0797c;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class z implements InterfaceC0806l {

    /* renamed from: l, reason: collision with root package name */
    public final Object f12464l;

    /* renamed from: m, reason: collision with root package name */
    public final C0797c.a f12465m;

    public z(Object obj) {
        this.f12464l = obj;
        this.f12465m = C0797c.f12390c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.InterfaceC0806l
    public void d(InterfaceC0808n interfaceC0808n, AbstractC0804j.a aVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f12465m.a(interfaceC0808n, aVar, this.f12464l);
    }
}
