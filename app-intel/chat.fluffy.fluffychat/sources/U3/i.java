package U3;

/* loaded from: classes.dex */
public abstract class i extends h {
    public i(J3.a aVar) {
        super(aVar);
    }

    public abstract void h(StringBuilder sb, int i7);

    public abstract int i(int i7);

    public final void j(StringBuilder sb, int i7, int i8) {
        int iF = b().f(i7, i8);
        h(sb, iF);
        int i9 = i(iF);
        int i10 = 100000;
        for (int i11 = 0; i11 < 5; i11++) {
            if (i9 / i10 == 0) {
                sb.append('0');
            }
            i10 /= 10;
        }
        sb.append(i9);
    }
}
