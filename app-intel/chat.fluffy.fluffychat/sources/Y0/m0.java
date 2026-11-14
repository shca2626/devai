package Y0;

import E0.InterfaceC0326k;
import android.util.SparseArray;

/* loaded from: classes.dex */
public final class m0 {

    /* renamed from: a, reason: collision with root package name */
    public int f9780a;

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray f9781b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0326k f9782c;

    public m0() {
        this(new InterfaceC0326k() { // from class: Y0.l0
            @Override // E0.InterfaceC0326k
            public final void accept(Object obj) {
                m0.a(obj);
            }
        });
    }

    public static /* synthetic */ void a(Object obj) {
    }

    public void b(int i7, Object obj) {
        if (this.f9780a == -1) {
            j3.o.v(this.f9781b.size() == 0);
            this.f9780a = 0;
        }
        if (this.f9781b.size() > 0) {
            SparseArray sparseArray = this.f9781b;
            int iKeyAt = sparseArray.keyAt(sparseArray.size() - 1);
            j3.o.d(i7 >= iKeyAt);
            if (iKeyAt == i7) {
                InterfaceC0326k interfaceC0326k = this.f9782c;
                SparseArray sparseArray2 = this.f9781b;
                interfaceC0326k.accept(sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.f9781b.append(i7, obj);
    }

    public void c() {
        for (int i7 = 0; i7 < this.f9781b.size(); i7++) {
            this.f9782c.accept(this.f9781b.valueAt(i7));
        }
        this.f9780a = -1;
        this.f9781b.clear();
    }

    public void d(int i7) {
        for (int size = this.f9781b.size() - 1; size >= 0 && i7 < this.f9781b.keyAt(size); size--) {
            this.f9782c.accept(this.f9781b.valueAt(size));
            this.f9781b.removeAt(size);
        }
        this.f9780a = this.f9781b.size() > 0 ? Math.min(this.f9780a, this.f9781b.size() - 1) : -1;
    }

    public void e(int i7) {
        int i8 = 0;
        while (i8 < this.f9781b.size() - 1) {
            int i9 = i8 + 1;
            if (i7 < this.f9781b.keyAt(i9)) {
                return;
            }
            this.f9782c.accept(this.f9781b.valueAt(i8));
            this.f9781b.removeAt(i8);
            int i10 = this.f9780a;
            if (i10 > 0) {
                this.f9780a = i10 - 1;
            }
            i8 = i9;
        }
    }

    public Object f(int i7) {
        if (this.f9780a == -1) {
            this.f9780a = 0;
        }
        while (true) {
            int i8 = this.f9780a;
            if (i8 <= 0 || i7 >= this.f9781b.keyAt(i8)) {
                break;
            }
            this.f9780a--;
        }
        while (this.f9780a < this.f9781b.size() - 1 && i7 >= this.f9781b.keyAt(this.f9780a + 1)) {
            this.f9780a++;
        }
        return this.f9781b.valueAt(this.f9780a);
    }

    public Object g() {
        return this.f9781b.valueAt(r0.size() - 1);
    }

    public boolean h() {
        return this.f9781b.size() == 0;
    }

    public m0(InterfaceC0326k interfaceC0326k) {
        this.f9781b = new SparseArray();
        this.f9782c = interfaceC0326k;
        this.f9780a = -1;
    }
}
