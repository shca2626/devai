package x3;

import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import u3.AbstractC1654j;
import u3.C1651g;
import u3.C1656l;
import u3.C1657m;
import u3.C1659o;

/* loaded from: classes.dex */
public final class g extends C3.a {

    /* renamed from: F, reason: collision with root package name */
    public static final Reader f23596F = new a();

    /* renamed from: G, reason: collision with root package name */
    public static final Object f23597G = new Object();

    /* renamed from: B, reason: collision with root package name */
    public Object[] f23598B;

    /* renamed from: C, reason: collision with root package name */
    public int f23599C;

    /* renamed from: D, reason: collision with root package name */
    public String[] f23600D;

    /* renamed from: E, reason: collision with root package name */
    public int[] f23601E;

    public class a extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i7, int i8) {
            throw new AssertionError();
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23602a;

        static {
            int[] iArr = new int[C3.b.values().length];
            f23602a = iArr;
            try {
                iArr[C3.b.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23602a[C3.b.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23602a[C3.b.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23602a[C3.b.END_DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public g(AbstractC1654j abstractC1654j) {
        super(f23596F);
        this.f23598B = new Object[32];
        this.f23599C = 0;
        this.f23600D = new String[32];
        this.f23601E = new int[32];
        o0(abstractC1654j);
    }

    private String F() {
        return " at path " + t();
    }

    @Override // C3.a
    public boolean B() throws C3.d {
        C3.b bVarV = V();
        return (bVarV == C3.b.END_OBJECT || bVarV == C3.b.END_ARRAY || bVarV == C3.b.END_DOCUMENT) ? false : true;
    }

    @Override // C3.a
    public boolean G() {
        i0(C3.b.BOOLEAN);
        boolean zF = ((C1659o) m0()).f();
        int i7 = this.f23599C;
        if (i7 > 0) {
            int[] iArr = this.f23601E;
            int i8 = i7 - 1;
            iArr[i8] = iArr[i8] + 1;
        }
        return zF;
    }

    @Override // C3.a
    public double H() throws C3.d {
        C3.b bVarV = V();
        C3.b bVar = C3.b.NUMBER;
        if (bVarV != bVar && bVarV != C3.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarV + F());
        }
        double dQ = ((C1659o) l0()).q();
        if (!C() && (Double.isNaN(dQ) || Double.isInfinite(dQ))) {
            throw new C3.d("JSON forbids NaN and infinities: " + dQ);
        }
        m0();
        int i7 = this.f23599C;
        if (i7 > 0) {
            int[] iArr = this.f23601E;
            int i8 = i7 - 1;
            iArr[i8] = iArr[i8] + 1;
        }
        return dQ;
    }

    @Override // C3.a
    public int J() throws C3.d {
        C3.b bVarV = V();
        C3.b bVar = C3.b.NUMBER;
        if (bVarV != bVar && bVarV != C3.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarV + F());
        }
        int iR = ((C1659o) l0()).r();
        m0();
        int i7 = this.f23599C;
        if (i7 > 0) {
            int[] iArr = this.f23601E;
            int i8 = i7 - 1;
            iArr[i8] = iArr[i8] + 1;
        }
        return iR;
    }

    @Override // C3.a
    public long K() throws C3.d {
        C3.b bVarV = V();
        C3.b bVar = C3.b.NUMBER;
        if (bVarV != bVar && bVarV != C3.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarV + F());
        }
        long jS = ((C1659o) l0()).s();
        m0();
        int i7 = this.f23599C;
        if (i7 > 0) {
            int[] iArr = this.f23601E;
            int i8 = i7 - 1;
            iArr[i8] = iArr[i8] + 1;
        }
        return jS;
    }

    @Override // C3.a
    public String L() {
        return k0(false);
    }

    @Override // C3.a
    public void N() {
        i0(C3.b.NULL);
        m0();
        int i7 = this.f23599C;
        if (i7 > 0) {
            int[] iArr = this.f23601E;
            int i8 = i7 - 1;
            iArr[i8] = iArr[i8] + 1;
        }
    }

    @Override // C3.a
    public String R() throws C3.d {
        C3.b bVarV = V();
        C3.b bVar = C3.b.STRING;
        if (bVarV == bVar || bVarV == C3.b.NUMBER) {
            String strJ = ((C1659o) m0()).j();
            int i7 = this.f23599C;
            if (i7 > 0) {
                int[] iArr = this.f23601E;
                int i8 = i7 - 1;
                iArr[i8] = iArr[i8] + 1;
            }
            return strJ;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + bVarV + F());
    }

    @Override // C3.a
    public C3.b V() throws C3.d {
        if (this.f23599C == 0) {
            return C3.b.END_DOCUMENT;
        }
        Object objL0 = l0();
        if (objL0 instanceof Iterator) {
            boolean z7 = this.f23598B[this.f23599C - 2] instanceof C1657m;
            Iterator it = (Iterator) objL0;
            if (!it.hasNext()) {
                return z7 ? C3.b.END_OBJECT : C3.b.END_ARRAY;
            }
            if (z7) {
                return C3.b.NAME;
            }
            o0(it.next());
            return V();
        }
        if (objL0 instanceof C1657m) {
            return C3.b.BEGIN_OBJECT;
        }
        if (objL0 instanceof C1651g) {
            return C3.b.BEGIN_ARRAY;
        }
        if (objL0 instanceof C1659o) {
            C1659o c1659o = (C1659o) objL0;
            if (c1659o.x()) {
                return C3.b.STRING;
            }
            if (c1659o.u()) {
                return C3.b.BOOLEAN;
            }
            if (c1659o.w()) {
                return C3.b.NUMBER;
            }
            throw new AssertionError();
        }
        if (objL0 instanceof C1656l) {
            return C3.b.NULL;
        }
        if (objL0 == f23597G) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new C3.d("Custom JsonElement subclass " + objL0.getClass().getName() + " is not supported");
    }

    @Override // C3.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f23598B = new Object[]{f23597G};
        this.f23599C = 1;
    }

    @Override // C3.a
    public void d() {
        i0(C3.b.BEGIN_ARRAY);
        o0(((C1651g) l0()).iterator());
        this.f23601E[this.f23599C - 1] = 0;
    }

    @Override // C3.a
    public void e() {
        i0(C3.b.BEGIN_OBJECT);
        o0(((C1657m) l0()).entrySet().iterator());
    }

    @Override // C3.a
    public void f0() throws C3.d {
        int i7 = b.f23602a[V().ordinal()];
        if (i7 == 1) {
            k0(true);
            return;
        }
        if (i7 == 2) {
            n();
            return;
        }
        if (i7 == 3) {
            o();
            return;
        }
        if (i7 != 4) {
            m0();
            int i8 = this.f23599C;
            if (i8 > 0) {
                int[] iArr = this.f23601E;
                int i9 = i8 - 1;
                iArr[i9] = iArr[i9] + 1;
            }
        }
    }

    public final void i0(C3.b bVar) {
        if (V() == bVar) {
            return;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + V() + F());
    }

    public AbstractC1654j j0() throws C3.d {
        C3.b bVarV = V();
        if (bVarV != C3.b.NAME && bVarV != C3.b.END_ARRAY && bVarV != C3.b.END_OBJECT && bVarV != C3.b.END_DOCUMENT) {
            AbstractC1654j abstractC1654j = (AbstractC1654j) l0();
            f0();
            return abstractC1654j;
        }
        throw new IllegalStateException("Unexpected " + bVarV + " when reading a JsonElement.");
    }

    public final String k0(boolean z7) {
        i0(C3.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) l0()).next();
        String str = (String) entry.getKey();
        this.f23600D[this.f23599C - 1] = z7 ? "<skipped>" : str;
        o0(entry.getValue());
        return str;
    }

    public final Object l0() {
        return this.f23598B[this.f23599C - 1];
    }

    public final Object m0() {
        Object[] objArr = this.f23598B;
        int i7 = this.f23599C - 1;
        this.f23599C = i7;
        Object obj = objArr[i7];
        objArr[i7] = null;
        return obj;
    }

    @Override // C3.a
    public void n() {
        i0(C3.b.END_ARRAY);
        m0();
        m0();
        int i7 = this.f23599C;
        if (i7 > 0) {
            int[] iArr = this.f23601E;
            int i8 = i7 - 1;
            iArr[i8] = iArr[i8] + 1;
        }
    }

    public void n0() {
        i0(C3.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) l0()).next();
        o0(entry.getValue());
        o0(new C1659o((String) entry.getKey()));
    }

    @Override // C3.a
    public void o() {
        i0(C3.b.END_OBJECT);
        this.f23600D[this.f23599C - 1] = null;
        m0();
        m0();
        int i7 = this.f23599C;
        if (i7 > 0) {
            int[] iArr = this.f23601E;
            int i8 = i7 - 1;
            iArr[i8] = iArr[i8] + 1;
        }
    }

    public final void o0(Object obj) {
        int i7 = this.f23599C;
        Object[] objArr = this.f23598B;
        if (i7 == objArr.length) {
            int i8 = i7 * 2;
            this.f23598B = Arrays.copyOf(objArr, i8);
            this.f23601E = Arrays.copyOf(this.f23601E, i8);
            this.f23600D = (String[]) Arrays.copyOf(this.f23600D, i8);
        }
        Object[] objArr2 = this.f23598B;
        int i9 = this.f23599C;
        this.f23599C = i9 + 1;
        objArr2[i9] = obj;
    }

    @Override // C3.a
    public String t() {
        return u(false);
    }

    @Override // C3.a
    public String toString() {
        return g.class.getSimpleName() + F();
    }

    public final String u(boolean z7) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i7 = 0;
        while (true) {
            int i8 = this.f23599C;
            if (i7 >= i8) {
                return sb.toString();
            }
            Object[] objArr = this.f23598B;
            Object obj = objArr[i7];
            if (obj instanceof C1651g) {
                i7++;
                if (i7 < i8 && (objArr[i7] instanceof Iterator)) {
                    int i9 = this.f23601E[i7];
                    if (z7 && i9 > 0 && (i7 == i8 - 1 || i7 == i8 - 2)) {
                        i9--;
                    }
                    sb.append('[');
                    sb.append(i9);
                    sb.append(']');
                }
            } else if ((obj instanceof C1657m) && (i7 = i7 + 1) < i8 && (objArr[i7] instanceof Iterator)) {
                sb.append('.');
                String str = this.f23600D[i7];
                if (str != null) {
                    sb.append(str);
                }
            }
            i7++;
        }
    }

    @Override // C3.a
    public String x() {
        return u(true);
    }
}
