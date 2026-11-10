package k3;

import java.util.Comparator;

/* renamed from: k3.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1272n {

    /* renamed from: a, reason: collision with root package name */
    public static final AbstractC1272n f19007a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final AbstractC1272n f19008b = new b(-1);

    /* renamed from: c, reason: collision with root package name */
    public static final AbstractC1272n f19009c = new b(1);

    /* renamed from: k3.n$a */
    public class a extends AbstractC1272n {
        public a() {
            super(null);
        }

        @Override // k3.AbstractC1272n
        public AbstractC1272n d(int i7, int i8) {
            return k(Integer.compare(i7, i8));
        }

        @Override // k3.AbstractC1272n
        public AbstractC1272n e(long j7, long j8) {
            return k(Long.compare(j7, j8));
        }

        @Override // k3.AbstractC1272n
        public AbstractC1272n f(Object obj, Object obj2, Comparator comparator) {
            return k(comparator.compare(obj, obj2));
        }

        @Override // k3.AbstractC1272n
        public AbstractC1272n g(boolean z7, boolean z8) {
            return k(Boolean.compare(z7, z8));
        }

        @Override // k3.AbstractC1272n
        public AbstractC1272n h(boolean z7, boolean z8) {
            return k(Boolean.compare(z8, z7));
        }

        @Override // k3.AbstractC1272n
        public int i() {
            return 0;
        }

        public AbstractC1272n k(int i7) {
            return i7 < 0 ? AbstractC1272n.f19008b : i7 > 0 ? AbstractC1272n.f19009c : AbstractC1272n.f19007a;
        }
    }

    public /* synthetic */ AbstractC1272n(a aVar) {
        this();
    }

    public static AbstractC1272n j() {
        return f19007a;
    }

    public abstract AbstractC1272n d(int i7, int i8);

    public abstract AbstractC1272n e(long j7, long j8);

    public abstract AbstractC1272n f(Object obj, Object obj2, Comparator comparator);

    public abstract AbstractC1272n g(boolean z7, boolean z8);

    public abstract AbstractC1272n h(boolean z7, boolean z8);

    public abstract int i();

    public AbstractC1272n() {
    }

    /* renamed from: k3.n$b */
    public static final class b extends AbstractC1272n {

        /* renamed from: d, reason: collision with root package name */
        public final int f19010d;

        public b(int i7) {
            super(null);
            this.f19010d = i7;
        }

        @Override // k3.AbstractC1272n
        public int i() {
            return this.f19010d;
        }

        @Override // k3.AbstractC1272n
        public AbstractC1272n d(int i7, int i8) {
            return this;
        }

        @Override // k3.AbstractC1272n
        public AbstractC1272n e(long j7, long j8) {
            return this;
        }

        @Override // k3.AbstractC1272n
        public AbstractC1272n g(boolean z7, boolean z8) {
            return this;
        }

        @Override // k3.AbstractC1272n
        public AbstractC1272n h(boolean z7, boolean z8) {
            return this;
        }

        @Override // k3.AbstractC1272n
        public AbstractC1272n f(Object obj, Object obj2, Comparator comparator) {
            return this;
        }
    }
}
