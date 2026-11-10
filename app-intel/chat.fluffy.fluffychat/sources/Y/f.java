package Y;

import M5.m;

/* loaded from: classes.dex */
public class f implements e {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f9354a;

    /* renamed from: b, reason: collision with root package name */
    public int f9355b;

    public f(int i7) {
        if (i7 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f9354a = new Object[i7];
    }

    @Override // Y.e
    public boolean a(Object obj) {
        m.e(obj, "instance");
        if (c(obj)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i7 = this.f9355b;
        Object[] objArr = this.f9354a;
        if (i7 >= objArr.length) {
            return false;
        }
        objArr[i7] = obj;
        this.f9355b = i7 + 1;
        return true;
    }

    @Override // Y.e
    public Object b() {
        int i7 = this.f9355b;
        if (i7 <= 0) {
            return null;
        }
        int i8 = i7 - 1;
        Object obj = this.f9354a[i8];
        m.c(obj, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
        this.f9354a[i8] = null;
        this.f9355b--;
        return obj;
    }

    public final boolean c(Object obj) {
        int i7 = this.f9355b;
        for (int i8 = 0; i8 < i7; i8++) {
            if (this.f9354a[i8] == obj) {
                return true;
            }
        }
        return false;
    }
}
