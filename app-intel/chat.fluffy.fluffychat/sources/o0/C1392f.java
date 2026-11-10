package o0;

/* renamed from: o0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1392f implements InterfaceC1391e {

    /* renamed from: a, reason: collision with root package name */
    public boolean f20344a;

    /* renamed from: b, reason: collision with root package name */
    public int f20345b;

    /* renamed from: c, reason: collision with root package name */
    public final int f20346c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC1391e f20347d;

    public C1392f(int i7, InterfaceC1391e interfaceC1391e) {
        this.f20344a = false;
        this.f20346c = i7;
        this.f20347d = interfaceC1391e;
        if (i7 == 0) {
            this.f20344a = true;
            interfaceC1391e.a(0, null);
        }
    }

    @Override // o0.InterfaceC1391e
    public void a(int i7, Throwable th) {
        if (this.f20344a) {
            return;
        }
        if (i7 == 0) {
            int i8 = this.f20345b + 1;
            this.f20345b = i8;
            if (i8 < this.f20346c) {
                return;
            }
        }
        this.f20344a = true;
        this.f20347d.a(i7, th);
    }
}
