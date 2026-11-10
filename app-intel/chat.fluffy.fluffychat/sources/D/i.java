package D;

import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes.dex */
public class i {

    /* renamed from: o, reason: collision with root package name */
    public static int f1496o = 1;

    /* renamed from: a, reason: collision with root package name */
    public boolean f1497a;

    /* renamed from: b, reason: collision with root package name */
    public String f1498b;

    /* renamed from: f, reason: collision with root package name */
    public float f1502f;

    /* renamed from: j, reason: collision with root package name */
    public a f1506j;

    /* renamed from: c, reason: collision with root package name */
    public int f1499c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f1500d = -1;

    /* renamed from: e, reason: collision with root package name */
    public int f1501e = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1503g = false;

    /* renamed from: h, reason: collision with root package name */
    public float[] f1504h = new float[9];

    /* renamed from: i, reason: collision with root package name */
    public float[] f1505i = new float[9];

    /* renamed from: k, reason: collision with root package name */
    public b[] f1507k = new b[16];

    /* renamed from: l, reason: collision with root package name */
    public int f1508l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f1509m = 0;

    /* renamed from: n, reason: collision with root package name */
    public HashSet f1510n = null;

    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public i(a aVar, String str) {
        this.f1506j = aVar;
    }

    public static void b() {
        f1496o++;
    }

    public final void a(b bVar) {
        int i7 = 0;
        while (true) {
            int i8 = this.f1508l;
            if (i7 >= i8) {
                b[] bVarArr = this.f1507k;
                if (i8 >= bVarArr.length) {
                    this.f1507k = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f1507k;
                int i9 = this.f1508l;
                bVarArr2[i9] = bVar;
                this.f1508l = i9 + 1;
                return;
            }
            if (this.f1507k[i7] == bVar) {
                return;
            } else {
                i7++;
            }
        }
    }

    public final void c(b bVar) {
        int i7 = this.f1508l;
        int i8 = 0;
        while (i8 < i7) {
            if (this.f1507k[i8] == bVar) {
                while (i8 < i7 - 1) {
                    b[] bVarArr = this.f1507k;
                    int i9 = i8 + 1;
                    bVarArr[i8] = bVarArr[i9];
                    i8 = i9;
                }
                this.f1508l--;
                return;
            }
            i8++;
        }
    }

    public void d() {
        this.f1498b = null;
        this.f1506j = a.UNKNOWN;
        this.f1501e = 0;
        this.f1499c = -1;
        this.f1500d = -1;
        this.f1502f = 0.0f;
        this.f1503g = false;
        int i7 = this.f1508l;
        for (int i8 = 0; i8 < i7; i8++) {
            this.f1507k[i8] = null;
        }
        this.f1508l = 0;
        this.f1509m = 0;
        this.f1497a = false;
        Arrays.fill(this.f1505i, 0.0f);
    }

    public void e(d dVar, float f7) {
        this.f1502f = f7;
        this.f1503g = true;
        int i7 = this.f1508l;
        for (int i8 = 0; i8 < i7; i8++) {
            this.f1507k[i8].B(dVar, this, false);
        }
        this.f1508l = 0;
    }

    public void f(a aVar, String str) {
        this.f1506j = aVar;
    }

    public final void g(b bVar) {
        int i7 = this.f1508l;
        for (int i8 = 0; i8 < i7; i8++) {
            this.f1507k[i8].C(bVar, false);
        }
        this.f1508l = 0;
    }

    public String toString() {
        if (this.f1498b != null) {
            return "" + this.f1498b;
        }
        return "" + this.f1499c;
    }
}
