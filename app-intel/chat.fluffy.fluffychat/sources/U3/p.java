package U3;

/* loaded from: classes.dex */
public final class p extends q {

    /* renamed from: b, reason: collision with root package name */
    public final int f8434b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8435c;

    public p(int i7, int i8, int i9) throws D3.f {
        super(i7);
        if (i8 < 0 || i8 > 10 || i9 < 0 || i9 > 10) {
            throw D3.f.a();
        }
        this.f8434b = i8;
        this.f8435c = i9;
    }

    public int b() {
        return this.f8434b;
    }

    public int c() {
        return this.f8435c;
    }

    public boolean d() {
        return this.f8434b == 10;
    }

    public boolean e() {
        return this.f8435c == 10;
    }
}
