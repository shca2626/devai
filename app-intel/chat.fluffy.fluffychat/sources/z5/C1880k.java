package z5;

import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: z5.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1880k extends C1879j {

    /* renamed from: z5.k$a */
    public static final class a extends AbstractC1872c implements RandomAccess {

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ float[] f24200m;

        public a(float[] fArr) {
            this.f24200m = fArr;
        }

        @Override // z5.AbstractC1871b, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Float) {
                return i(((Number) obj).floatValue());
            }
            return false;
        }

        @Override // z5.AbstractC1871b
        public int g() {
            return this.f24200m.length;
        }

        public boolean i(float f7) {
            for (float f8 : this.f24200m) {
                if (Float.floatToIntBits(f8) == Float.floatToIntBits(f7)) {
                    return true;
                }
            }
            return false;
        }

        @Override // z5.AbstractC1872c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Float) {
                return k(((Number) obj).floatValue());
            }
            return -1;
        }

        @Override // z5.AbstractC1871b, java.util.Collection
        public boolean isEmpty() {
            return this.f24200m.length == 0;
        }

        @Override // z5.AbstractC1872c, java.util.List
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Float get(int i7) {
            return Float.valueOf(this.f24200m[i7]);
        }

        public int k(float f7) {
            float[] fArr = this.f24200m;
            int length = fArr.length;
            for (int i7 = 0; i7 < length; i7++) {
                if (Float.floatToIntBits(fArr[i7]) == Float.floatToIntBits(f7)) {
                    return i7;
                }
            }
            return -1;
        }

        public int l(float f7) {
            float[] fArr = this.f24200m;
            int length = fArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i7 = length - 1;
                    if (Float.floatToIntBits(fArr[length]) == Float.floatToIntBits(f7)) {
                        return length;
                    }
                    if (i7 < 0) {
                        break;
                    }
                    length = i7;
                }
            }
            return -1;
        }

        @Override // z5.AbstractC1872c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Float) {
                return l(((Number) obj).floatValue());
            }
            return -1;
        }
    }

    public static final List c(float[] fArr) {
        M5.m.e(fArr, "<this>");
        return new a(fArr);
    }

    public static List d(Object[] objArr) {
        M5.m.e(objArr, "<this>");
        List listA = AbstractC1882m.a(objArr);
        M5.m.d(listA, "asList(...)");
        return listA;
    }

    public static byte[] e(byte[] bArr, byte[] bArr2, int i7, int i8, int i9) {
        M5.m.e(bArr, "<this>");
        M5.m.e(bArr2, "destination");
        System.arraycopy(bArr, i8, bArr2, i7, i9 - i8);
        return bArr2;
    }

    public static int[] f(int[] iArr, int[] iArr2, int i7, int i8, int i9) {
        M5.m.e(iArr, "<this>");
        M5.m.e(iArr2, "destination");
        System.arraycopy(iArr, i8, iArr2, i7, i9 - i8);
        return iArr2;
    }

    public static long[] g(long[] jArr, long[] jArr2, int i7, int i8, int i9) {
        M5.m.e(jArr, "<this>");
        M5.m.e(jArr2, "destination");
        System.arraycopy(jArr, i8, jArr2, i7, i9 - i8);
        return jArr2;
    }

    public static Object[] h(Object[] objArr, Object[] objArr2, int i7, int i8, int i9) {
        M5.m.e(objArr, "<this>");
        M5.m.e(objArr2, "destination");
        System.arraycopy(objArr, i8, objArr2, i7, i9 - i8);
        return objArr2;
    }

    public static /* synthetic */ byte[] i(byte[] bArr, byte[] bArr2, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i7 = 0;
        }
        if ((i10 & 4) != 0) {
            i8 = 0;
        }
        if ((i10 & 8) != 0) {
            i9 = bArr.length;
        }
        return e(bArr, bArr2, i7, i8, i9);
    }

    public static /* synthetic */ int[] j(int[] iArr, int[] iArr2, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i7 = 0;
        }
        if ((i10 & 4) != 0) {
            i8 = 0;
        }
        if ((i10 & 8) != 0) {
            i9 = iArr.length;
        }
        return f(iArr, iArr2, i7, i8, i9);
    }

    public static /* synthetic */ Object[] k(Object[] objArr, Object[] objArr2, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i7 = 0;
        }
        if ((i10 & 4) != 0) {
            i8 = 0;
        }
        if ((i10 & 8) != 0) {
            i9 = objArr.length;
        }
        return h(objArr, objArr2, i7, i8, i9);
    }

    public static byte[] l(byte[] bArr, int i7, int i8) {
        M5.m.e(bArr, "<this>");
        C1878i.b(i8, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i7, i8);
        M5.m.d(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    public static final float[] m(float[] fArr, int i7, int i8) {
        M5.m.e(fArr, "<this>");
        C1878i.b(i8, fArr.length);
        float[] fArrCopyOfRange = Arrays.copyOfRange(fArr, i7, i8);
        M5.m.d(fArrCopyOfRange, "copyOfRange(...)");
        return fArrCopyOfRange;
    }

    public static Object[] n(Object[] objArr, int i7, int i8) {
        M5.m.e(objArr, "<this>");
        C1878i.b(i8, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i7, i8);
        M5.m.d(objArrCopyOfRange, "copyOfRange(...)");
        return objArrCopyOfRange;
    }

    public static final void o(Object[] objArr, Object obj, int i7, int i8) {
        M5.m.e(objArr, "<this>");
        Arrays.fill(objArr, i7, i8, obj);
    }

    public static byte[] p(byte[] bArr, byte[] bArr2) {
        M5.m.e(bArr, "<this>");
        M5.m.e(bArr2, "elements");
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(bArr2, 0, bArrCopyOf, length, length2);
        M5.m.b(bArrCopyOf);
        return bArrCopyOf;
    }
}
