package U3;

/* loaded from: classes.dex */
public final class c extends h {
    public c(J3.a aVar) {
        super(aVar);
    }

    @Override // U3.j
    public String d() throws D3.j {
        if (c().k() < 48) {
            throw D3.j.a();
        }
        StringBuilder sb = new StringBuilder();
        f(sb, 8);
        int iF = b().f(48, 2);
        sb.append("(392");
        sb.append(iF);
        sb.append(')');
        sb.append(b().c(50, null).b());
        return sb.toString();
    }
}
