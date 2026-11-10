package U3;

/* loaded from: classes.dex */
public final class o extends q {

    /* renamed from: b, reason: collision with root package name */
    public final String f8431b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8432c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f8433d;

    public o(int i7, String str) {
        super(i7);
        this.f8431b = str;
        this.f8433d = false;
        this.f8432c = 0;
    }

    public String b() {
        return this.f8431b;
    }

    public int c() {
        return this.f8432c;
    }

    public boolean d() {
        return this.f8433d;
    }

    public o(int i7, String str, int i8) {
        super(i7);
        this.f8433d = true;
        this.f8432c = i8;
        this.f8431b = str;
    }
}
