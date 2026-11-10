package E;

import java.util.Arrays;

/* loaded from: classes.dex */
public class i extends e implements h {

    /* renamed from: w0, reason: collision with root package name */
    public e[] f1999w0 = new e[4];

    /* renamed from: x0, reason: collision with root package name */
    public int f2000x0 = 0;

    @Override // E.h
    public void b(e eVar) {
        if (eVar == this || eVar == null) {
            return;
        }
        int i7 = this.f2000x0 + 1;
        e[] eVarArr = this.f1999w0;
        if (i7 > eVarArr.length) {
            this.f1999w0 = (e[]) Arrays.copyOf(eVarArr, eVarArr.length * 2);
        }
        e[] eVarArr2 = this.f1999w0;
        int i8 = this.f2000x0;
        eVarArr2[i8] = eVar;
        this.f2000x0 = i8 + 1;
    }

    @Override // E.h
    public void c() {
        this.f2000x0 = 0;
        Arrays.fill(this.f1999w0, (Object) null);
    }

    @Override // E.h
    public void a(f fVar) {
    }
}
