package D3;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public final int f1733a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1734b;

    public h(int i7, int i8) {
        this.f1733a = i7;
        this.f1734b = i8;
    }

    public final int a() {
        return this.f1734b;
    }

    public abstract byte[] b();

    public abstract byte[] c(int i7, byte[] bArr);

    public final int d() {
        return this.f1733a;
    }

    public h e() {
        return new g(this);
    }

    public boolean f() {
        return false;
    }

    public h g() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        int i7 = this.f1733a;
        byte[] bArrC = new byte[i7];
        StringBuilder sb = new StringBuilder(this.f1734b * (i7 + 1));
        for (int i8 = 0; i8 < this.f1734b; i8++) {
            bArrC = c(i8, bArrC);
            for (int i9 = 0; i9 < this.f1733a; i9++) {
                int i10 = bArrC[i9] & 255;
                sb.append(i10 < 64 ? '#' : i10 < 128 ? '+' : i10 < 192 ? '.' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
