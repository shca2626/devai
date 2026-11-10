package U3;

/* loaded from: classes.dex */
public final class b extends f {
    public b(J3.a aVar) {
        super(aVar);
    }

    @Override // U3.i
    public void h(StringBuilder sb, int i7) {
        if (i7 < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }

    @Override // U3.i
    public int i(int i7) {
        return i7 < 10000 ? i7 : i7 - 10000;
    }
}
