package g1;

import g1.N;

/* loaded from: classes.dex */
public final class U implements InterfaceC1088s {

    /* renamed from: l, reason: collision with root package name */
    public final long f15983l;

    /* renamed from: m, reason: collision with root package name */
    public final InterfaceC1088s f15984m;

    public class a extends B {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ N f15985b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(N n7, N n8) {
            super(n7);
            this.f15985b = n8;
        }

        @Override // g1.B, g1.N
        public N.a g(long j7) {
            N.a aVarG = this.f15985b.g(j7);
            O o7 = aVarG.f15966a;
            O o8 = new O(o7.f15971a, o7.f15972b + U.this.f15983l);
            O o9 = aVarG.f15967b;
            return new N.a(o8, new O(o9.f15971a, o9.f15972b + U.this.f15983l));
        }
    }

    public U(long j7, InterfaceC1088s interfaceC1088s) {
        this.f15983l = j7;
        this.f15984m = interfaceC1088s;
    }

    @Override // g1.InterfaceC1088s
    public V e(int i7, int i8) {
        return this.f15984m.e(i7, i8);
    }

    @Override // g1.InterfaceC1088s
    public void o() {
        this.f15984m.o();
    }

    @Override // g1.InterfaceC1088s
    public void w(N n7) {
        this.f15984m.w(new a(n7, n7));
    }
}
