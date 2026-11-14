package W5;

/* loaded from: classes.dex */
public final class A {

    /* renamed from: a, reason: collision with root package name */
    public final Object f9077a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0631l f9078b;

    /* renamed from: c, reason: collision with root package name */
    public final L5.q f9079c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f9080d;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f9081e;

    public A(Object obj, InterfaceC0631l interfaceC0631l, L5.q qVar, Object obj2, Throwable th) {
        this.f9077a = obj;
        this.f9078b = interfaceC0631l;
        this.f9079c = qVar;
        this.f9080d = obj2;
        this.f9081e = th;
    }

    public static /* synthetic */ A b(A a7, Object obj, InterfaceC0631l interfaceC0631l, L5.q qVar, Object obj2, Throwable th, int i7, Object obj3) {
        if ((i7 & 1) != 0) {
            obj = a7.f9077a;
        }
        if ((i7 & 2) != 0) {
            interfaceC0631l = a7.f9078b;
        }
        if ((i7 & 4) != 0) {
            qVar = a7.f9079c;
        }
        if ((i7 & 8) != 0) {
            obj2 = a7.f9080d;
        }
        if ((i7 & 16) != 0) {
            th = a7.f9081e;
        }
        Throwable th2 = th;
        L5.q qVar2 = qVar;
        return a7.a(obj, interfaceC0631l, qVar2, obj2, th2);
    }

    public final A a(Object obj, InterfaceC0631l interfaceC0631l, L5.q qVar, Object obj2, Throwable th) {
        return new A(obj, interfaceC0631l, qVar, obj2, th);
    }

    public final boolean c() {
        return this.f9081e != null;
    }

    public final void d(C0637o c0637o, Throwable th) {
        InterfaceC0631l interfaceC0631l = this.f9078b;
        if (interfaceC0631l != null) {
            c0637o.m(interfaceC0631l, th);
        }
        L5.q qVar = this.f9079c;
        if (qVar != null) {
            c0637o.n(qVar, th, this.f9077a);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof A)) {
            return false;
        }
        A a7 = (A) obj;
        return M5.m.a(this.f9077a, a7.f9077a) && M5.m.a(this.f9078b, a7.f9078b) && M5.m.a(this.f9079c, a7.f9079c) && M5.m.a(this.f9080d, a7.f9080d) && M5.m.a(this.f9081e, a7.f9081e);
    }

    public int hashCode() {
        Object obj = this.f9077a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        InterfaceC0631l interfaceC0631l = this.f9078b;
        int iHashCode2 = (iHashCode + (interfaceC0631l == null ? 0 : interfaceC0631l.hashCode())) * 31;
        L5.q qVar = this.f9079c;
        int iHashCode3 = (iHashCode2 + (qVar == null ? 0 : qVar.hashCode())) * 31;
        Object obj2 = this.f9080d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f9081e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f9077a + ", cancelHandler=" + this.f9078b + ", onCancellation=" + this.f9079c + ", idempotentResume=" + this.f9080d + ", cancelCause=" + this.f9081e + ')';
    }

    public /* synthetic */ A(Object obj, InterfaceC0631l interfaceC0631l, L5.q qVar, Object obj2, Throwable th, int i7, M5.g gVar) {
        this(obj, (i7 & 2) != 0 ? null : interfaceC0631l, (i7 & 4) != 0 ? null : qVar, (i7 & 8) != 0 ? null : obj2, (i7 & 16) != 0 ? null : th);
    }
}
