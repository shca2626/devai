package androidx.lifecycle;

import androidx.lifecycle.AbstractC0805j;
import androidx.lifecycle.C0798c;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class z implements InterfaceC0807l {

    /* renamed from: l, reason: collision with root package name */
    public final Object f12464l;

    /* renamed from: m, reason: collision with root package name */
    public final C0798c.a f12465m;

    public z(Object obj) {
        this.f12464l = obj;
        this.f12465m = C0798c.f12390c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.InterfaceC0807l
    public void d(InterfaceC0809n interfaceC0809n, AbstractC0805j.a aVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f12465m.a(interfaceC0809n, aVar, this.f12464l);
    }
}
