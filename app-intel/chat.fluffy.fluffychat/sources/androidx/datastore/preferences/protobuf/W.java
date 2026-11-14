package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class W extends AbstractC0773c implements RandomAccess {

    /* renamed from: o, reason: collision with root package name */
    public static final W f11991o = new W(new Object[0], 0, false);

    /* renamed from: m, reason: collision with root package name */
    public Object[] f11992m;

    /* renamed from: n, reason: collision with root package name */
    public int f11993n;

    public W(Object[] objArr, int i7, boolean z7) {
        super(z7);
        this.f11992m = objArr;
        this.f11993n = i7;
    }

    public static Object[] g(int i7) {
        return new Object[i7];
    }

    public static W h() {
        return f11991o;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        f();
        int i7 = this.f11993n;
        Object[] objArr = this.f11992m;
        if (i7 == objArr.length) {
            this.f11992m = Arrays.copyOf(objArr, ((i7 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f11992m;
        int i8 = this.f11993n;
        this.f11993n = i8 + 1;
        objArr2[i8] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i7) {
        i(i7);
        return this.f11992m[i7];
    }

    public final void i(int i7) {
        if (i7 < 0 || i7 >= this.f11993n) {
            throw new IndexOutOfBoundsException(j(i7));
        }
    }

    public final String j(int i7) {
        return "Index:" + i7 + ", Size:" + this.f11993n;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0790u.b
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public W c(int i7) {
        if (i7 >= this.f11993n) {
            return new W(Arrays.copyOf(this.f11992m, i7), this.f11993n, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0773c, java.util.AbstractList, java.util.List
    public Object remove(int i7) {
        f();
        i(i7);
        Object[] objArr = this.f11992m;
        Object obj = objArr[i7];
        if (i7 < this.f11993n - 1) {
            System.arraycopy(objArr, i7 + 1, objArr, i7, (r2 - i7) - 1);
        }
        this.f11993n--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i7, Object obj) {
        f();
        i(i7);
        Object[] objArr = this.f11992m;
        Object obj2 = objArr[i7];
        objArr[i7] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f11993n;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i7, Object obj) {
        int i8;
        f();
        if (i7 >= 0 && i7 <= (i8 = this.f11993n)) {
            Object[] objArr = this.f11992m;
            if (i8 < objArr.length) {
                System.arraycopy(objArr, i7, objArr, i7 + 1, i8 - i7);
            } else {
                Object[] objArrG = g(((i8 * 3) / 2) + 1);
                System.arraycopy(this.f11992m, 0, objArrG, 0, i7);
                System.arraycopy(this.f11992m, i7, objArrG, i7 + 1, this.f11993n - i7);
                this.f11992m = objArrG;
            }
            this.f11992m[i7] = obj;
            this.f11993n++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(j(i7));
    }
}
