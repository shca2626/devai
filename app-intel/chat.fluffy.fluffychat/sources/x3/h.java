package x3;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import u3.AbstractC1654j;
import u3.C1651g;
import u3.C1656l;
import u3.C1657m;
import u3.C1659o;

/* loaded from: classes.dex */
public final class h extends C3.c {

    /* renamed from: C, reason: collision with root package name */
    public static final Writer f23603C = new a();

    /* renamed from: D, reason: collision with root package name */
    public static final C1659o f23604D = new C1659o("closed");

    /* renamed from: A, reason: collision with root package name */
    public String f23605A;

    /* renamed from: B, reason: collision with root package name */
    public AbstractC1654j f23606B;

    /* renamed from: z, reason: collision with root package name */
    public final List f23607z;

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
        super(f23603C);
        this.f23607z = new ArrayList();
        this.f23606B = C1656l.f22856l;
    }

    @Override // C3.c
    public C3.c C() {
        b0(C1656l.f22856l);
        return this;
    }

    @Override // C3.c
    public C3.c P(double d7) {
        if (x() || !(Double.isNaN(d7) || Double.isInfinite(d7))) {
            b0(new C1659o(Double.valueOf(d7)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d7);
    }

    @Override // C3.c
    public C3.c R(long j7) {
        b0(new C1659o(Long.valueOf(j7)));
        return this;
    }

    @Override // C3.c
    public C3.c U(Boolean bool) {
        if (bool == null) {
            return C();
        }
        b0(new C1659o(bool));
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
        b0(new C1659o(number));
        return this;
    }

    @Override // C3.c
    public C3.c W(String str) {
        if (str == null) {
            return C();
        }
        b0(new C1659o(str));
        return this;
    }

    @Override // C3.c
    public C3.c X(boolean z7) {
        b0(new C1659o(Boolean.valueOf(z7)));
        return this;
    }

    public AbstractC1654j Z() {
        if (this.f23607z.isEmpty()) {
            return this.f23606B;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f23607z);
    }

    public final AbstractC1654j a0() {
        return (AbstractC1654j) this.f23607z.get(r0.size() - 1);
    }

    public final void b0(AbstractC1654j abstractC1654j) {
        if (this.f23605A != null) {
            if (!abstractC1654j.l() || r()) {
                ((C1657m) a0()).o(this.f23605A, abstractC1654j);
            }
            this.f23605A = null;
            return;
        }
        if (this.f23607z.isEmpty()) {
            this.f23606B = abstractC1654j;
            return;
        }
        AbstractC1654j abstractC1654jA0 = a0();
        if (!(abstractC1654jA0 instanceof C1651g)) {
            throw new IllegalStateException();
        }
        ((C1651g) abstractC1654jA0).o(abstractC1654j);
    }

    @Override // C3.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f23607z.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f23607z.add(f23604D);
    }

    @Override // C3.c
    public C3.c f() {
        C1651g c1651g = new C1651g();
        b0(c1651g);
        this.f23607z.add(c1651g);
        return this;
    }

    @Override // C3.c
    public C3.c i() {
        C1657m c1657m = new C1657m();
        b0(c1657m);
        this.f23607z.add(c1657m);
        return this;
    }

    @Override // C3.c
    public C3.c n() {
        if (this.f23607z.isEmpty() || this.f23605A != null) {
            throw new IllegalStateException();
        }
        if (!(a0() instanceof C1651g)) {
            throw new IllegalStateException();
        }
        this.f23607z.remove(r0.size() - 1);
        return this;
    }

    @Override // C3.c
    public C3.c o() {
        if (this.f23607z.isEmpty() || this.f23605A != null) {
            throw new IllegalStateException();
        }
        if (!(a0() instanceof C1657m)) {
            throw new IllegalStateException();
        }
        this.f23607z.remove(r0.size() - 1);
        return this;
    }

    @Override // C3.c
    public C3.c y(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f23607z.isEmpty() || this.f23605A != null) {
            throw new IllegalStateException("Did not expect a name");
        }
        if (!(a0() instanceof C1657m)) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.f23605A = str;
        return this;
    }

    @Override // C3.c, java.io.Flushable
    public void flush() {
    }
}
