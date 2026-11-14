package o0;

/* renamed from: o0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1391f implements InterfaceC1390e {

    /* renamed from: a, reason: collision with root package name */
    public boolean f20343a;

    /* renamed from: b, reason: collision with root package name */
    public int f20344b;

    /* renamed from: c, reason: collision with root package name */
    public final int f20345c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC1390e f20346d;

    public C1391f(int i7, InterfaceC1390e interfaceC1390e) {
        this.f20343a = false;
        this.f20345c = i7;
        this.f20346d = interfaceC1390e;
        if (i7 == 0) {
            this.f20343a = true;
            interfaceC1390e.a(0, null);
        }
    }

    @Override // o0.InterfaceC1390e
    public void a(int i7, Throwable th) {
        if (this.f20343a) {
            return;
        }
        if (i7 == 0) {
            int i8 = this.f20344b + 1;
            this.f20344b = i8;
            if (i8 < this.f20345c) {
                return;
            }
        }
        this.f20343a = true;
        this.f20346d.a(i7, th);
    }
}
