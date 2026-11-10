package androidx.datastore.preferences.protobuf;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;

/* renamed from: androidx.datastore.preferences.protobuf.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0775f implements Iterable, Serializable {

    /* renamed from: m, reason: collision with root package name */
    public static final AbstractC0775f f12025m = new j(AbstractC0789u.f12248d);

    /* renamed from: n, reason: collision with root package name */
    public static final InterfaceC0103f f12026n;

    /* renamed from: o, reason: collision with root package name */
    public static final Comparator f12027o;

    /* renamed from: l, reason: collision with root package name */
    public int f12028l = 0;

    /* renamed from: androidx.datastore.preferences.protobuf.f$a */
    public class a extends c {

        /* renamed from: l, reason: collision with root package name */
        public int f12029l = 0;

        /* renamed from: m, reason: collision with root package name */
        public final int f12030m;

        public a() {
            this.f12030m = AbstractC0775f.this.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12029l < this.f12030m;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0775f.g
        public byte nextByte() {
            int i7 = this.f12029l;
            if (i7 >= this.f12030m) {
                throw new NoSuchElementException();
            }
            this.f12029l = i7 + 1;
            return AbstractC0775f.this.n(i7);
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.f$b */
    public class b implements Comparator {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(AbstractC0775f abstractC0775f, AbstractC0775f abstractC0775f2) {
            g gVarO = abstractC0775f.o();
            g gVarO2 = abstractC0775f2.o();
            while (gVarO.hasNext() && gVarO2.hasNext()) {
                int iCompareTo = Integer.valueOf(AbstractC0775f.v(gVarO.nextByte())).compareTo(Integer.valueOf(AbstractC0775f.v(gVarO2.nextByte())));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
            }
            return Integer.valueOf(abstractC0775f.size()).compareTo(Integer.valueOf(abstractC0775f2.size()));
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.f$c */
    public static abstract class c implements g {
        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.f$d */
    public static final class d implements InterfaceC0103f {
        public d() {
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0775f.InterfaceC0103f
        public byte[] a(byte[] bArr, int i7, int i8) {
            return Arrays.copyOfRange(bArr, i7, i8 + i7);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.f$e */
    public static final class e extends j {

        /* renamed from: q, reason: collision with root package name */
        public final int f12032q;

        /* renamed from: r, reason: collision with root package name */
        public final int f12033r;

        public e(byte[] bArr, int i7, int i8) {
            super(bArr);
            AbstractC0775f.i(i7, i7 + i8, bArr.length);
            this.f12032q = i7;
            this.f12033r = i8;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0775f.j
        public int B() {
            return this.f12032q;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0775f.j, androidx.datastore.preferences.protobuf.AbstractC0775f
        public byte g(int i7) {
            AbstractC0775f.h(i7, size());
            return this.f12036p[this.f12032q + i7];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0775f.j, androidx.datastore.preferences.protobuf.AbstractC0775f
        public void m(byte[] bArr, int i7, int i8, int i9) {
            System.arraycopy(this.f12036p, B() + i7, bArr, i8, i9);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0775f.j, androidx.datastore.preferences.protobuf.AbstractC0775f
        public byte n(int i7) {
            return this.f12036p[this.f12032q + i7];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0775f.j, androidx.datastore.preferences.protobuf.AbstractC0775f
        public int size() {
            return this.f12033r;
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.f$f, reason: collision with other inner class name */
    public interface InterfaceC0103f {
        byte[] a(byte[] bArr, int i7, int i8);
    }

    /* renamed from: androidx.datastore.preferences.protobuf.f$g */
    public interface g extends Iterator {
        byte nextByte();
    }

    /* renamed from: androidx.datastore.preferences.protobuf.f$h */
    public static final class h {

        /* renamed from: a, reason: collision with root package name */
        public final AbstractC0778i f12034a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f12035b;

        public /* synthetic */ h(int i7, a aVar) {
            this(i7);
        }

        public AbstractC0775f a() {
            this.f12034a.c();
            return new j(this.f12035b);
        }

        public AbstractC0778i b() {
            return this.f12034a;
        }

        public h(int i7) {
            byte[] bArr = new byte[i7];
            this.f12035b = bArr;
            this.f12034a = AbstractC0778i.c0(bArr);
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.f$i */
    public static abstract class i extends AbstractC0775f {
        public /* synthetic */ i(a aVar) {
            this();
        }

        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.o();
        }

        public i() {
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.f$j */
    public static class j extends i {

        /* renamed from: p, reason: collision with root package name */
        public final byte[] f12036p;

        public j(byte[] bArr) {
            super(null);
            bArr.getClass();
            this.f12036p = bArr;
        }

        public final boolean A(AbstractC0775f abstractC0775f, int i7, int i8) {
            if (i8 > abstractC0775f.size()) {
                throw new IllegalArgumentException("Length too large: " + i8 + size());
            }
            int i9 = i7 + i8;
            if (i9 > abstractC0775f.size()) {
                throw new IllegalArgumentException("Ran off end of other: " + i7 + ", " + i8 + ", " + abstractC0775f.size());
            }
            if (!(abstractC0775f instanceof j)) {
                return abstractC0775f.t(i7, i9).equals(t(0, i8));
            }
            j jVar = (j) abstractC0775f;
            byte[] bArr = this.f12036p;
            byte[] bArr2 = jVar.f12036p;
            int iB = B() + i8;
            int iB2 = B();
            int iB3 = jVar.B() + i7;
            while (iB2 < iB) {
                if (bArr[iB2] != bArr2[iB3]) {
                    return false;
                }
                iB2++;
                iB3++;
            }
            return true;
        }

        public int B() {
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0775f
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AbstractC0775f) || size() != ((AbstractC0775f) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof j)) {
                return obj.equals(this);
            }
            j jVar = (j) obj;
            int iS = s();
            int iS2 = jVar.s();
            if (iS == 0 || iS2 == 0 || iS == iS2) {
                return A(jVar, 0, size());
            }
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0775f
        public byte g(int i7) {
            return this.f12036p[i7];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0775f
        public void m(byte[] bArr, int i7, int i8, int i9) {
            System.arraycopy(this.f12036p, i7, bArr, i8, i9);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0775f
        public byte n(int i7) {
            return this.f12036p[i7];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0775f
        public final AbstractC0776g q() {
            return AbstractC0776g.k(this.f12036p, B(), size(), true);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0775f
        public final int r(int i7, int i8, int i9) {
            return AbstractC0789u.g(i7, this.f12036p, B() + i8, i9);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0775f
        public int size() {
            return this.f12036p.length;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0775f
        public final AbstractC0775f t(int i7, int i8) {
            int i9 = AbstractC0775f.i(i7, i8, size());
            return i9 == 0 ? AbstractC0775f.f12025m : new e(this.f12036p, B() + i7, i9);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0775f
        public final void z(AbstractC0774e abstractC0774e) {
            abstractC0774e.a(this.f12036p, B(), size());
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.f$k */
    public static final class k implements InterfaceC0103f {
        public k() {
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0775f.InterfaceC0103f
        public byte[] a(byte[] bArr, int i7, int i8) {
            byte[] bArr2 = new byte[i8];
            System.arraycopy(bArr, i7, bArr2, 0, i8);
            return bArr2;
        }

        public /* synthetic */ k(a aVar) {
            this();
        }
    }

    static {
        a aVar = null;
        f12026n = AbstractC0773d.c() ? new k(aVar) : new d(aVar);
        f12027o = new b();
    }

    public static void h(int i7, int i8) {
        if (((i8 - (i7 + 1)) | i7) < 0) {
            if (i7 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i7);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i7 + ", " + i8);
        }
    }

    public static int i(int i7, int i8, int i9) {
        int i10 = i8 - i7;
        if ((i7 | i8 | i10 | (i9 - i8)) >= 0) {
            return i10;
        }
        if (i7 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i7 + " < 0");
        }
        if (i8 < i7) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i7 + ", " + i8);
        }
        throw new IndexOutOfBoundsException("End index: " + i8 + " >= " + i9);
    }

    public static AbstractC0775f j(byte[] bArr) {
        return k(bArr, 0, bArr.length);
    }

    public static AbstractC0775f k(byte[] bArr, int i7, int i8) {
        i(i7, i7 + i8, bArr.length);
        return new j(f12026n.a(bArr, i7, i8));
    }

    public static AbstractC0775f l(String str) {
        return new j(str.getBytes(AbstractC0789u.f12246b));
    }

    public static h p(int i7) {
        return new h(i7, null);
    }

    public static int v(byte b7) {
        return b7 & 255;
    }

    public static AbstractC0775f x(byte[] bArr) {
        return new j(bArr);
    }

    public static AbstractC0775f y(byte[] bArr, int i7, int i8) {
        return new e(bArr, i7, i8);
    }

    public abstract boolean equals(Object obj);

    public abstract byte g(int i7);

    public final int hashCode() {
        int iR = this.f12028l;
        if (iR == 0) {
            int size = size();
            iR = r(size, 0, size);
            if (iR == 0) {
                iR = 1;
            }
            this.f12028l = iR;
        }
        return iR;
    }

    public abstract void m(byte[] bArr, int i7, int i8, int i9);

    public abstract byte n(int i7);

    public g o() {
        return new a();
    }

    public abstract AbstractC0776g q();

    public abstract int r(int i7, int i8, int i9);

    public final int s() {
        return this.f12028l;
    }

    public abstract int size();

    public abstract AbstractC0775f t(int i7, int i8);

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), w());
    }

    public final byte[] u() {
        int size = size();
        if (size == 0) {
            return AbstractC0789u.f12248d;
        }
        byte[] bArr = new byte[size];
        m(bArr, 0, 0, size);
        return bArr;
    }

    public final String w() {
        if (size() <= 50) {
            return e0.a(this);
        }
        return e0.a(t(0, 47)) + "...";
    }

    public abstract void z(AbstractC0774e abstractC0774e);
}
