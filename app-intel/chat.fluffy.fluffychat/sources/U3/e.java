package U3;

/* loaded from: classes.dex */
public final class e extends i {

    /* renamed from: c, reason: collision with root package name */
    public final String f8418c;

    /* renamed from: d, reason: collision with root package name */
    public final String f8419d;

    public e(J3.a aVar, String str, String str2) {
        super(aVar);
        this.f8418c = str2;
        this.f8419d = str;
    }

    @Override // U3.j
    public String d() throws D3.j {
        if (c().k() != 84) {
            throw D3.j.a();
        }
        StringBuilder sb = new StringBuilder();
        f(sb, 8);
        j(sb, 48, 20);
        k(sb, 68);
        return sb.toString();
    }

    @Override // U3.i
    public void h(StringBuilder sb, int i7) {
        sb.append('(');
        sb.append(this.f8419d);
        sb.append(i7 / 100000);
        sb.append(')');
    }

    @Override // U3.i
    public int i(int i7) {
        return i7 % 100000;
    }

    public final void k(StringBuilder sb, int i7) {
        int iF = b().f(i7, 16);
        if (iF == 38400) {
            return;
        }
        sb.append('(');
        sb.append(this.f8418c);
        sb.append(')');
        int i8 = iF % 32;
        int i9 = iF / 32;
        int i10 = (i9 % 12) + 1;
        int i11 = i9 / 12;
        if (i11 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i11);
        if (i10 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i10);
        if (i8 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i8);
    }
}
