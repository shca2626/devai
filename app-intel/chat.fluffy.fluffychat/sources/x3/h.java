package x3;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import u3.AbstractC1653j;
import u3.C1650g;
import u3.C1655l;
import u3.C1656m;
import u3.C1658o;

/* loaded from: classes.dex */
public final class h extends C3.c {

    /* renamed from: C, reason: collision with root package name */
    public static final Writer f23609C = new a();

    /* renamed from: D, reason: collision with root package name */
    public static final C1658o f23610D = new C1658o("closed");

    /* renamed from: A, reason: collision with root package name */
    public String f23611A;

    /* renamed from: B, reason: collision with root package name */
    public AbstractC1653j f23612B;

    /* renamed from: z, reason: collision with root package name */
    public final List f23613z;

    public class a extends Writer {
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i7, int i8) {
            throw new AssertionError();
        }
    }

    public h() {
        super(f23609C);
        this.f23613z = new ArrayList();
        this.f23612B = C1655l.f22862l;
    }

    @Override // C3.c
    public C3.c C() {
        b0(C1655l.f22862l);
        return this;
    }

    @Override // C3.c
    public C3.c P(double d7) {
        if (x() || !(Double.isNaN(d7) || Double.isInfinite(d7))) {
            b0(new C1658o(Double.valueOf(d7)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d7);
    }

    @Override // C3.c
    public C3.c R(long j7) {
        b0(new C1658o(Long.valueOf(j7)));
        return this;
    }

    @Override // C3.c
    public C3.c U(Boolean bool) {
        if (bool == null) {
            return C();
        }
        b0(new C1658o(bool));
        return this;
    }

    @Override // C3.c
    public C3.c V(Number number) {
        if (number == null) {
            return C();
        }
        if (!x()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        b0(new C1658o(number));
        return this;
    }

    @Override // C3.c
    public C3.c W(String str) {
        if (str == null) {
            return C();
        }
        b0(new C1658o(str));
        return this;
    }

    @Override // C3.c
    public C3.c X(boolean z7) {
        b0(new C1658o(Boolean.valueOf(z7)));
        return this;
    }

    public AbstractC1653j Z() {
        if (this.f23613z.isEmpty()) {
            return this.f23612B;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f23613z);
    }

    public final AbstractC1653j a0() {
        return (AbstractC1653j) this.f23613z.get(r0.size() - 1);
    }

    public final void b0(AbstractC1653j abstractC1653j) {
        if (this.f23611A != null) {
            if (!abstractC1653j.l() || r()) {
                ((C1656m) a0()).o(this.f23611A, abstractC1653j);
            }
            this.f23611A = null;
            return;
        }
        if (this.f23613z.isEmpty()) {
            this.f23612B = abstractC1653j;
            return;
        }
        AbstractC1653j abstractC1653jA0 = a0();
        if (!(abstractC1653jA0 instanceof C1650g)) {
            throw new IllegalStateException();
        }
        ((C1650g) abstractC1653jA0).o(abstractC1653j);
    }

    @Override // C3.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f23613z.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f23613z.add(f23610D);
    }

    @Override // C3.c
    public C3.c f() {
        C1650g c1650g = new C1650g();
        b0(c1650g);
        this.f23613z.add(c1650g);
        return this;
    }

    @Override // C3.c
    public C3.c i() {
        C1656m c1656m = new C1656m();
        b0(c1656m);
        this.f23613z.add(c1656m);
        return this;
    }

    @Override // C3.c
    public C3.c n() {
        if (this.f23613z.isEmpty() || this.f23611A != null) {
            throw new IllegalStateException();
        }
        if (!(a0() instanceof C1650g)) {
            throw new IllegalStateException();
        }
        this.f23613z.remove(r0.size() - 1);
        return this;
    }

    @Override // C3.c
    public C3.c o() {
        if (this.f23613z.isEmpty() || this.f23611A != null) {
            throw new IllegalStateException();
        }
        if (!(a0() instanceof C1656m)) {
            throw new IllegalStateException();
        }
        this.f23613z.remove(r0.size() - 1);
        return this;
    }

    @Override // C3.c
    public C3.c y(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f23613z.isEmpty() || this.f23611A != null) {
            throw new IllegalStateException("Did not expect a name");
        }
        if (!(a0() instanceof C1656m)) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.f23611A = str;
        return this;
    }

    @Override // C3.c, java.io.Flushable
    public void flush() {
    }
}
