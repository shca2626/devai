package bp;

import android.util.SparseIntArray;

/* loaded from: classes.dex */
public class f {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f15994a;

        /* renamed from: b, reason: collision with root package name */
        int f15995b;

        /* renamed from: c, reason: collision with root package name */
        int f15996c;

        public a(int i12, int i13, int i14) {
            this.f15994a = i12;
            this.f15995b = i13;
            this.f15996c = i14;
        }

        public a a(a aVar) {
            return new a(this.f15994a - aVar.d(), this.f15995b - aVar.c(), this.f15996c - aVar.b());
        }

        public int b() {
            return this.f15996c;
        }

        public int c() {
            return this.f15995b;
        }

        public int d() {
            return this.f15994a;
        }
    }

    public static a a(SparseIntArray[] sparseIntArrayArr) {
        int i12;
        int i13;
        SparseIntArray sparseIntArray;
        int i14 = 0;
        if (sparseIntArrayArr == null || (sparseIntArray = sparseIntArrayArr[0]) == null) {
            i12 = 0;
            i13 = 0;
        } else {
            int i15 = 0;
            i12 = 0;
            i13 = 0;
            while (i14 < sparseIntArray.size()) {
                int iKeyAt = sparseIntArray.keyAt(i14);
                int iValueAt = sparseIntArray.valueAt(i14);
                i15 += iValueAt;
                if (iKeyAt > 700) {
                    i13 += iValueAt;
                }
                if (iKeyAt > 16) {
                    i12 += iValueAt;
                }
                i14++;
            }
            i14 = i15;
        }
        return new a(i14, i12, i13);
    }
}
