package U3;

/* loaded from: classes.dex */
public abstract class f extends i {
    public f(J3.a aVar) {
        super(aVar);
    }

    @Override // U3.j
    public String d() throws D3.j {
        if (c().k() != 60) {
            throw D3.j.a();
        }
        StringBuilder sb = new StringBuilder();
        f(sb, 5);
        j(sb, 45, 15);
        return sb.toString();
    }
}
