package U3;

/* loaded from: classes.dex */
public abstract class h extends j {
    public h(J3.a aVar) {
        super(aVar);
    }

    public static void e(StringBuilder sb, int i7) {
        int i8 = 0;
        for (int i9 = 0; i9 < 13; i9++) {
            int iCharAt = sb.charAt(i9 + i7) - '0';
            if ((i9 & 1) == 0) {
                iCharAt *= 3;
            }
            i8 += iCharAt;
        }
        int i10 = 10 - (i8 % 10);
        sb.append(i10 != 10 ? i10 : 0);
    }

    public final void f(StringBuilder sb, int i7) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        g(sb, i7, length);
    }

    public final void g(StringBuilder sb, int i7, int i8) {
        for (int i9 = 0; i9 < 4; i9++) {
            int iF = b().f((i9 * 10) + i7, 10);
            if (iF / 100 == 0) {
                sb.append('0');
            }
            if (iF / 10 == 0) {
                sb.append('0');
            }
            sb.append(iF);
        }
        e(sb, i8);
    }
}
