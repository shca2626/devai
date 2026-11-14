package i1;

import E0.E;

/* loaded from: classes.dex */
public final class c implements InterfaceC1151a {

    /* renamed from: a, reason: collision with root package name */
    public final int f17376a;

    /* renamed from: b, reason: collision with root package name */
    public final int f17377b;

    /* renamed from: c, reason: collision with root package name */
    public final int f17378c;

    /* renamed from: d, reason: collision with root package name */
    public final int f17379d;

    public c(int i7, int i8, int i9, int i10) {
        this.f17376a = i7;
        this.f17377b = i8;
        this.f17378c = i9;
        this.f17379d = i10;
    }

    public static c b(E e7) {
        int iD = e7.D();
        e7.g0(8);
        int iD2 = e7.D();
        int iD3 = e7.D();
        e7.g0(4);
        int iD4 = e7.D();
        e7.g0(12);
        return new c(iD, iD2, iD3, iD4);
    }

    public boolean a() {
        return (this.f17377b & 16) == 16;
    }

    @Override // i1.InterfaceC1151a
    public int getType() {
        return 1751742049;
    }
}
