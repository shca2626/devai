package D;

/* loaded from: classes.dex */
public class g implements f {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f1484a;

    /* renamed from: b, reason: collision with root package name */
    public int f1485b;

    public g(int i7) {
        if (i7 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f1484a = new Object[i7];
    }

    @Override // D.f
    public boolean a(Object obj) {
        int i7 = this.f1485b;
        Object[] objArr = this.f1484a;
        if (i7 >= objArr.length) {
            return false;
        }
        objArr[i7] = obj;
        this.f1485b = i7 + 1;
        return true;
    }

    @Override // D.f
    public Object b() {
        int i7 = this.f1485b;
        if (i7 <= 0) {
            return null;
        }
        int i8 = i7 - 1;
        Object[] objArr = this.f1484a;
        Object obj = objArr[i8];
        objArr[i8] = null;
        this.f1485b = i7 - 1;
        return obj;
    }

    @Override // D.f
    public void c(Object[] objArr, int i7) {
        if (i7 > objArr.length) {
            i7 = objArr.length;
        }
        for (int i8 = 0; i8 < i7; i8++) {
            Object obj = objArr[i8];
            int i9 = this.f1485b;
            Object[] objArr2 = this.f1484a;
            if (i9 < objArr2.length) {
                objArr2[i9] = obj;
                this.f1485b = i9 + 1;
            }
        }
    }
}
