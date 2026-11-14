package b6;

import W5.R0;

/* renamed from: b6.P, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0864P {

    /* renamed from: a, reason: collision with root package name */
    public final C5.i f13770a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f13771b;

    /* renamed from: c, reason: collision with root package name */
    public final R0[] f13772c;

    /* renamed from: d, reason: collision with root package name */
    public int f13773d;

    public C0864P(C5.i iVar, int i7) {
        this.f13770a = iVar;
        this.f13771b = new Object[i7];
        this.f13772c = new R0[i7];
    }

    public final void a(R0 r02, Object obj) {
        Object[] objArr = this.f13771b;
        int i7 = this.f13773d;
        objArr[i7] = obj;
        R0[] r0Arr = this.f13772c;
        this.f13773d = i7 + 1;
        M5.m.c(r02, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        r0Arr[i7] = r02;
    }

    public final void b(C5.i iVar) {
        int length = this.f13772c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i7 = length - 1;
            R0 r02 = this.f13772c[length];
            M5.m.b(r02);
            r02.J(iVar, this.f13771b[length]);
            if (i7 < 0) {
                return;
            } else {
                length = i7;
            }
        }
    }
}
