package N1;

import android.util.SparseArray;
import g1.InterfaceC1089s;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public interface L {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f6010a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6011b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f6012c;

        public a(String str, int i7, byte[] bArr) {
            this.f6010a = str;
            this.f6011b = i7;
            this.f6012c = bArr;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f6013a;

        /* renamed from: b, reason: collision with root package name */
        public final String f6014b;

        /* renamed from: c, reason: collision with root package name */
        public final int f6015c;

        /* renamed from: d, reason: collision with root package name */
        public final List f6016d;

        /* renamed from: e, reason: collision with root package name */
        public final byte[] f6017e;

        public b(int i7, String str, int i8, List list, byte[] bArr) {
            this.f6013a = i7;
            this.f6014b = str;
            this.f6015c = i8;
            this.f6016d = list == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list);
            this.f6017e = bArr;
        }

        public int a() {
            int i7 = this.f6015c;
            if (i7 != 2) {
                return i7 != 3 ? 0 : 512;
            }
            return 2048;
        }
    }

    public interface c {
        L a(int i7, b bVar);

        SparseArray b();
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f6018a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6019b;

        /* renamed from: c, reason: collision with root package name */
        public final int f6020c;

        /* renamed from: d, reason: collision with root package name */
        public int f6021d;

        /* renamed from: e, reason: collision with root package name */
        public String f6022e;

        public d(int i7, int i8) {
            this(Integer.MIN_VALUE, i7, i8);
        }

        public void a() {
            int i7 = this.f6021d;
            this.f6021d = i7 == Integer.MIN_VALUE ? this.f6019b : i7 + this.f6020c;
            this.f6022e = this.f6018a + this.f6021d;
        }

        public String b() {
            d();
            return this.f6022e;
        }

        public int c() {
            d();
            return this.f6021d;
        }

        public final void d() {
            if (this.f6021d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public d(int i7, int i8, int i9) {
            String str;
            if (i7 != Integer.MIN_VALUE) {
                str = i7 + "/";
            } else {
                str = "";
            }
            this.f6018a = str;
            this.f6019b = i8;
            this.f6020c = i9;
            this.f6021d = Integer.MIN_VALUE;
            this.f6022e = "";
        }
    }

    void a(E0.E e7, int i7);

    void b();

    void c(E0.M m7, InterfaceC1089s interfaceC1089s, d dVar);
}
