package f4;

import M5.g;
import g4.C1109a;
import y5.C1813h;

/* renamed from: f4.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC1058f {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15872a = a.f15873a;

    /* renamed from: f4.f$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f15873a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final InterfaceC1058f f15874b = new c(null);

        public final InterfaceC1058f b() {
            return f15874b;
        }

        public final C1813h c(double d7, double d8, double d9, double d10) {
            double d11 = d7 / d8;
            return d9 / d10 <= d11 ? new C1813h(Double.valueOf(d9), Double.valueOf(d9 / d11)) : new C1813h(Double.valueOf(d11 * d10), Double.valueOf(d10));
        }

        public final InterfaceC1058f d(double d7, double d8, boolean z7) {
            return new b(d7, d8, z7);
        }
    }

    /* renamed from: f4.f$b */
    public static final class b implements InterfaceC1058f {

        /* renamed from: b, reason: collision with root package name */
        public final double f15875b;

        /* renamed from: c, reason: collision with root package name */
        public final double f15876c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f15877d;

        public b(double d7, double d8, boolean z7) {
            this.f15875b = d7;
            this.f15876c = d8;
            this.f15877d = z7;
        }

        @Override // f4.InterfaceC1058f
        public C1813h a(double d7, double d8) {
            return this.f15877d ? new C1813h(Double.valueOf(this.f15875b), Double.valueOf(this.f15876c)) : InterfaceC1058f.f15872a.c(d7, d8, this.f15875b, this.f15876c);
        }
    }

    /* renamed from: f4.f$c */
    public static final class c implements InterfaceC1058f {

        /* renamed from: b, reason: collision with root package name */
        public final Double f15878b;

        /* JADX WARN: Multi-variable type inference failed */
        public c() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // f4.InterfaceC1058f
        public C1813h a(double d7, double d8) {
            Double d9 = this.f15878b;
            double dDoubleValue = d9 != null ? d9.doubleValue() : C1109a.f16304a.a(d7, d8);
            return new C1813h(Double.valueOf(d7 * dDoubleValue), Double.valueOf(d8 * dDoubleValue));
        }

        public c(Double d7) {
            this.f15878b = d7;
        }

        public /* synthetic */ c(Double d7, int i7, g gVar) {
            this((i7 & 1) != 0 ? null : d7);
        }
    }

    C1813h a(double d7, double d8);
}
