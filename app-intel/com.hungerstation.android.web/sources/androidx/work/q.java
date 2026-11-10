package androidx.work;

import android.annotation.SuppressLint;

/* loaded from: classes.dex */
public interface q {

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"SyntheticAccessor"})
    public static final b.c f12170a;

    /* renamed from: b, reason: collision with root package name */
    @SuppressLint({"SyntheticAccessor"})
    public static final b.C0217b f12171b;

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a, reason: collision with root package name */
            private final Throwable f12172a;

            public a(Throwable th2) {
                this.f12172a = th2;
            }

            public Throwable a() {
                return this.f12172a;
            }

            public String toString() {
                return String.format("FAILURE (%s)", this.f12172a.getMessage());
            }
        }

        /* renamed from: androidx.work.q$b$b, reason: collision with other inner class name */
        public static final class C0217b extends b {
            public String toString() {
                return "IN_PROGRESS";
            }

            private C0217b() {
            }
        }

        public static final class c extends b {
            public String toString() {
                return "SUCCESS";
            }

            private c() {
            }
        }

        b() {
        }
    }

    static {
        f12170a = new b.c();
        f12171b = new b.C0217b();
    }
}
