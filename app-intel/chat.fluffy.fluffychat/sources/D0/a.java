package D0;

import E0.U;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import j3.o;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f1552a;

    /* renamed from: b, reason: collision with root package name */
    public final Layout.Alignment f1553b;

    /* renamed from: c, reason: collision with root package name */
    public final Layout.Alignment f1554c;

    /* renamed from: d, reason: collision with root package name */
    public final Bitmap f1555d;

    /* renamed from: e, reason: collision with root package name */
    public final float f1556e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1557f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1558g;

    /* renamed from: h, reason: collision with root package name */
    public final float f1559h;

    /* renamed from: i, reason: collision with root package name */
    public final int f1560i;

    /* renamed from: j, reason: collision with root package name */
    public final float f1561j;

    /* renamed from: k, reason: collision with root package name */
    public final float f1562k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f1563l;

    /* renamed from: m, reason: collision with root package name */
    public final int f1564m;

    /* renamed from: n, reason: collision with root package name */
    public final int f1565n;

    /* renamed from: o, reason: collision with root package name */
    public final float f1566o;

    /* renamed from: p, reason: collision with root package name */
    public final int f1567p;

    /* renamed from: q, reason: collision with root package name */
    public final float f1568q;

    /* renamed from: r, reason: collision with root package name */
    public final int f1569r;

    /* renamed from: s, reason: collision with root package name */
    public static final a f1544s = new b().o("").a();

    /* renamed from: t, reason: collision with root package name */
    public static final String f1545t = U.A0(0);

    /* renamed from: u, reason: collision with root package name */
    public static final String f1546u = U.A0(17);

    /* renamed from: v, reason: collision with root package name */
    public static final String f1547v = U.A0(1);

    /* renamed from: w, reason: collision with root package name */
    public static final String f1548w = U.A0(2);

    /* renamed from: x, reason: collision with root package name */
    public static final String f1549x = U.A0(3);

    /* renamed from: y, reason: collision with root package name */
    public static final String f1550y = U.A0(18);

    /* renamed from: z, reason: collision with root package name */
    public static final String f1551z = U.A0(4);

    /* renamed from: A, reason: collision with root package name */
    public static final String f1531A = U.A0(5);

    /* renamed from: B, reason: collision with root package name */
    public static final String f1532B = U.A0(6);

    /* renamed from: C, reason: collision with root package name */
    public static final String f1533C = U.A0(7);

    /* renamed from: D, reason: collision with root package name */
    public static final String f1534D = U.A0(8);

    /* renamed from: E, reason: collision with root package name */
    public static final String f1535E = U.A0(9);

    /* renamed from: F, reason: collision with root package name */
    public static final String f1536F = U.A0(10);

    /* renamed from: G, reason: collision with root package name */
    public static final String f1537G = U.A0(11);

    /* renamed from: H, reason: collision with root package name */
    public static final String f1538H = U.A0(12);

    /* renamed from: I, reason: collision with root package name */
    public static final String f1539I = U.A0(13);

    /* renamed from: J, reason: collision with root package name */
    public static final String f1540J = U.A0(14);

    /* renamed from: K, reason: collision with root package name */
    public static final String f1541K = U.A0(15);

    /* renamed from: L, reason: collision with root package name */
    public static final String f1542L = U.A0(16);

    /* renamed from: M, reason: collision with root package name */
    public static final String f1543M = U.A0(19);

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public CharSequence f1570a;

        /* renamed from: b, reason: collision with root package name */
        public Bitmap f1571b;

        /* renamed from: c, reason: collision with root package name */
        public Layout.Alignment f1572c;

        /* renamed from: d, reason: collision with root package name */
        public Layout.Alignment f1573d;

        /* renamed from: e, reason: collision with root package name */
        public float f1574e;

        /* renamed from: f, reason: collision with root package name */
        public int f1575f;

        /* renamed from: g, reason: collision with root package name */
        public int f1576g;

        /* renamed from: h, reason: collision with root package name */
        public float f1577h;

        /* renamed from: i, reason: collision with root package name */
        public int f1578i;

        /* renamed from: j, reason: collision with root package name */
        public int f1579j;

        /* renamed from: k, reason: collision with root package name */
        public float f1580k;

        /* renamed from: l, reason: collision with root package name */
        public float f1581l;

        /* renamed from: m, reason: collision with root package name */
        public float f1582m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f1583n;

        /* renamed from: o, reason: collision with root package name */
        public int f1584o;

        /* renamed from: p, reason: collision with root package name */
        public int f1585p;

        /* renamed from: q, reason: collision with root package name */
        public float f1586q;

        /* renamed from: r, reason: collision with root package name */
        public int f1587r;

        public a a() {
            return new a(this.f1570a, this.f1572c, this.f1573d, this.f1571b, this.f1574e, this.f1575f, this.f1576g, this.f1577h, this.f1578i, this.f1579j, this.f1580k, this.f1581l, this.f1582m, this.f1583n, this.f1584o, this.f1585p, this.f1586q, this.f1587r);
        }

        public b b() {
            this.f1583n = false;
            return this;
        }

        public int c() {
            return this.f1576g;
        }

        public int d() {
            return this.f1578i;
        }

        public CharSequence e() {
            return this.f1570a;
        }

        public b f(Bitmap bitmap) {
            this.f1571b = bitmap;
            this.f1570a = null;
            return this;
        }

        public b g(float f7) {
            this.f1582m = f7;
            return this;
        }

        public b h(float f7, int i7) {
            this.f1574e = f7;
            this.f1575f = i7;
            return this;
        }

        public b i(int i7) {
            this.f1576g = i7;
            return this;
        }

        public b j(Layout.Alignment alignment) {
            this.f1573d = alignment;
            return this;
        }

        public b k(float f7) {
            this.f1577h = f7;
            return this;
        }

        public b l(int i7) {
            this.f1578i = i7;
            return this;
        }

        public b m(float f7) {
            this.f1586q = f7;
            return this;
        }

        public b n(float f7) {
            this.f1581l = f7;
            return this;
        }

        public b o(CharSequence charSequence) {
            this.f1570a = charSequence;
            this.f1571b = null;
            return this;
        }

        public b p(Layout.Alignment alignment) {
            this.f1572c = alignment;
            return this;
        }

        public b q(float f7, int i7) {
            this.f1580k = f7;
            this.f1579j = i7;
            return this;
        }

        public b r(int i7) {
            this.f1585p = i7;
            return this;
        }

        public b s(int i7) {
            this.f1584o = i7;
            this.f1583n = true;
            return this;
        }

        public b t(int i7) {
            this.f1587r = i7;
            return this;
        }

        public b() {
            this.f1570a = null;
            this.f1571b = null;
            this.f1572c = null;
            this.f1573d = null;
            this.f1574e = -3.4028235E38f;
            this.f1575f = Integer.MIN_VALUE;
            this.f1576g = Integer.MIN_VALUE;
            this.f1577h = -3.4028235E38f;
            this.f1578i = Integer.MIN_VALUE;
            this.f1579j = Integer.MIN_VALUE;
            this.f1580k = -3.4028235E38f;
            this.f1581l = -3.4028235E38f;
            this.f1582m = -3.4028235E38f;
            this.f1583n = false;
            this.f1584o = -16777216;
            this.f1585p = Integer.MIN_VALUE;
        }

        public b(a aVar) {
            this.f1570a = aVar.f1552a;
            this.f1571b = aVar.f1555d;
            this.f1572c = aVar.f1553b;
            this.f1573d = aVar.f1554c;
            this.f1574e = aVar.f1556e;
            this.f1575f = aVar.f1557f;
            this.f1576g = aVar.f1558g;
            this.f1577h = aVar.f1559h;
            this.f1578i = aVar.f1560i;
            this.f1579j = aVar.f1565n;
            this.f1580k = aVar.f1566o;
            this.f1581l = aVar.f1561j;
            this.f1582m = aVar.f1562k;
            this.f1583n = aVar.f1563l;
            this.f1584o = aVar.f1564m;
            this.f1585p = aVar.f1567p;
            this.f1586q = aVar.f1568q;
            this.f1587r = aVar.f1569r;
        }
    }

    public static a b(Bundle bundle) {
        b bVar = new b();
        CharSequence charSequence = bundle.getCharSequence(f1545t);
        if (charSequence != null) {
            bVar.o(charSequence);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(f1546u);
            if (parcelableArrayList != null) {
                SpannableString spannableStringValueOf = SpannableString.valueOf(charSequence);
                int size = parcelableArrayList.size();
                int i7 = 0;
                while (i7 < size) {
                    Object obj = parcelableArrayList.get(i7);
                    i7++;
                    d.c((Bundle) obj, spannableStringValueOf);
                }
                bVar.o(spannableStringValueOf);
            }
        }
        Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(f1547v);
        if (alignment != null) {
            bVar.p(alignment);
        }
        Layout.Alignment alignment2 = (Layout.Alignment) bundle.getSerializable(f1548w);
        if (alignment2 != null) {
            bVar.j(alignment2);
        }
        Bitmap bitmap = (Bitmap) bundle.getParcelable(f1549x);
        if (bitmap != null) {
            bVar.f(bitmap);
        } else {
            byte[] byteArray = bundle.getByteArray(f1550y);
            if (byteArray != null) {
                bVar.f(BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length));
            }
        }
        String str = f1551z;
        if (bundle.containsKey(str)) {
            String str2 = f1531A;
            if (bundle.containsKey(str2)) {
                bVar.h(bundle.getFloat(str), bundle.getInt(str2));
            }
        }
        String str3 = f1532B;
        if (bundle.containsKey(str3)) {
            bVar.i(bundle.getInt(str3));
        }
        String str4 = f1533C;
        if (bundle.containsKey(str4)) {
            bVar.k(bundle.getFloat(str4));
        }
        String str5 = f1534D;
        if (bundle.containsKey(str5)) {
            bVar.l(bundle.getInt(str5));
        }
        String str6 = f1536F;
        if (bundle.containsKey(str6)) {
            String str7 = f1535E;
            if (bundle.containsKey(str7)) {
                bVar.q(bundle.getFloat(str6), bundle.getInt(str7));
            }
        }
        String str8 = f1537G;
        if (bundle.containsKey(str8)) {
            bVar.n(bundle.getFloat(str8));
        }
        String str9 = f1538H;
        if (bundle.containsKey(str9)) {
            bVar.g(bundle.getFloat(str9));
        }
        String str10 = f1539I;
        if (bundle.containsKey(str10)) {
            bVar.s(bundle.getInt(str10));
        }
        if (!bundle.getBoolean(f1540J, false)) {
            bVar.b();
        }
        String str11 = f1541K;
        if (bundle.containsKey(str11)) {
            bVar.r(bundle.getInt(str11));
        }
        String str12 = f1542L;
        if (bundle.containsKey(str12)) {
            bVar.m(bundle.getFloat(str12));
        }
        String str13 = f1543M;
        if (bundle.containsKey(str13)) {
            bVar.t(bundle.getInt(str13));
        }
        return bVar.a();
    }

    public b a() {
        return new b();
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        CharSequence charSequence = this.f1552a;
        if (charSequence != null) {
            bundle.putCharSequence(f1545t, charSequence);
            CharSequence charSequence2 = this.f1552a;
            if (charSequence2 instanceof Spanned) {
                ArrayList<? extends Parcelable> arrayListA = d.a((Spanned) charSequence2);
                if (!arrayListA.isEmpty()) {
                    bundle.putParcelableArrayList(f1546u, arrayListA);
                }
            }
        }
        bundle.putSerializable(f1547v, this.f1553b);
        bundle.putSerializable(f1548w, this.f1554c);
        bundle.putFloat(f1551z, this.f1556e);
        bundle.putInt(f1531A, this.f1557f);
        bundle.putInt(f1532B, this.f1558g);
        bundle.putFloat(f1533C, this.f1559h);
        bundle.putInt(f1534D, this.f1560i);
        bundle.putInt(f1535E, this.f1565n);
        bundle.putFloat(f1536F, this.f1566o);
        bundle.putFloat(f1537G, this.f1561j);
        bundle.putFloat(f1538H, this.f1562k);
        bundle.putBoolean(f1540J, this.f1563l);
        bundle.putInt(f1539I, this.f1564m);
        bundle.putInt(f1541K, this.f1567p);
        bundle.putFloat(f1542L, this.f1568q);
        bundle.putInt(f1543M, this.f1569r);
        return bundle;
    }

    public Bundle d() {
        Bundle bundleC = c();
        if (this.f1555d != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            o.v(this.f1555d.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream));
            bundleC.putByteArray(f1550y, byteArrayOutputStream.toByteArray());
        }
        return bundleC;
    }

    public boolean equals(Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (TextUtils.equals(this.f1552a, aVar.f1552a) && this.f1553b == aVar.f1553b && this.f1554c == aVar.f1554c && ((bitmap = this.f1555d) != null ? !((bitmap2 = aVar.f1555d) == null || !bitmap.sameAs(bitmap2)) : aVar.f1555d == null) && this.f1556e == aVar.f1556e && this.f1557f == aVar.f1557f && this.f1558g == aVar.f1558g && this.f1559h == aVar.f1559h && this.f1560i == aVar.f1560i && this.f1561j == aVar.f1561j && this.f1562k == aVar.f1562k && this.f1563l == aVar.f1563l && this.f1564m == aVar.f1564m && this.f1565n == aVar.f1565n && this.f1566o == aVar.f1566o && this.f1567p == aVar.f1567p && this.f1568q == aVar.f1568q && this.f1569r == aVar.f1569r) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f1552a, this.f1553b, this.f1554c, this.f1555d, Float.valueOf(this.f1556e), Integer.valueOf(this.f1557f), Integer.valueOf(this.f1558g), Float.valueOf(this.f1559h), Integer.valueOf(this.f1560i), Float.valueOf(this.f1561j), Float.valueOf(this.f1562k), Boolean.valueOf(this.f1563l), Integer.valueOf(this.f1564m), Integer.valueOf(this.f1565n), Float.valueOf(this.f1566o), Integer.valueOf(this.f1567p), Float.valueOf(this.f1568q), Integer.valueOf(this.f1569r));
    }

    public a(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f7, int i7, int i8, float f8, int i9, int i10, float f9, float f10, float f11, boolean z7, int i11, int i12, float f12, int i13) {
        if (charSequence == null) {
            o.q(bitmap);
        } else {
            o.d(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.f1552a = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.f1552a = charSequence.toString();
        } else {
            this.f1552a = null;
        }
        this.f1553b = alignment;
        this.f1554c = alignment2;
        this.f1555d = bitmap;
        this.f1556e = f7;
        this.f1557f = i7;
        this.f1558g = i8;
        this.f1559h = f8;
        this.f1560i = i9;
        this.f1561j = f10;
        this.f1562k = f11;
        this.f1563l = z7;
        this.f1564m = i11;
        this.f1565n = i10;
        this.f1566o = f9;
        this.f1567p = i12;
        this.f1568q = f12;
        this.f1569r = i13;
    }
}
