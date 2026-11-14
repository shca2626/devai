package f6;

import b6.C0853E;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final C0853E f15891a = new C0853E("NO_OWNER");

    /* renamed from: b, reason: collision with root package name */
    public static final C0853E f15892b = new C0853E("ALREADY_LOCKED_BY_OWNER");

    public static final InterfaceC1061a a(boolean z7) {
        return new f(z7);
    }

    public static /* synthetic */ InterfaceC1061a b(boolean z7, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            z7 = false;
        }
        return a(z7);
    }
}
