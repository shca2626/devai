package S5;

import java.util.NoSuchElementException;
import z5.AbstractC1863D;

/* loaded from: classes.dex */
public final class b extends AbstractC1863D {

    /* renamed from: l, reason: collision with root package name */
    public final int f8208l;

    /* renamed from: m, reason: collision with root package name */
    public final int f8209m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8210n;

    /* renamed from: o, reason: collision with root package name */
    public int f8211o;

    public b(int i7, int i8, int i9) {
        this.f8208l = i9;
        this.f8209m = i8;
        boolean z7 = false;
        if (i9 <= 0 ? i7 >= i8 : i7 <= i8) {
            z7 = true;
        }
        this.f8210n = z7;
        this.f8211o = z7 ? i7 : i8;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f8210n;
    }

    @Override // z5.AbstractC1863D
    public int nextInt() {
        int i7 = this.f8211o;
        if (i7 != this.f8209m) {
            this.f8211o = this.f8208l + i7;
            return i7;
        }
        if (!this.f8210n) {
            throw new NoSuchElementException();
        }
        this.f8210n = false;
        return i7;
    }
}
