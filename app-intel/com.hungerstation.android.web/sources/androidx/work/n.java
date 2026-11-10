package androidx.work;

/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    private static n f12160a = null;

    /* renamed from: b, reason: collision with root package name */
    private static final int f12161b = 20;

    public static class a extends n {

        /* renamed from: c, reason: collision with root package name */
        private int f12162c;

        public a(int i12) {
            super(i12);
            this.f12162c = i12;
        }

        @Override // androidx.work.n
        public void a(String str, String str2, Throwable... thArr) {
            if (this.f12162c > 3 || thArr == null || thArr.length < 1) {
                return;
            }
            Throwable th2 = thArr[0];
        }

        @Override // androidx.work.n
        public void b(String str, String str2, Throwable... thArr) {
            if (this.f12162c > 6 || thArr == null || thArr.length < 1) {
                return;
            }
            Throwable th2 = thArr[0];
        }

        @Override // androidx.work.n
        public void d(String str, String str2, Throwable... thArr) {
            if (this.f12162c > 4 || thArr == null || thArr.length < 1) {
                return;
            }
            Throwable th2 = thArr[0];
        }

        @Override // androidx.work.n
        public void g(String str, String str2, Throwable... thArr) {
            if (this.f12162c > 2 || thArr == null || thArr.length < 1) {
                return;
            }
            Throwable th2 = thArr[0];
        }

        @Override // androidx.work.n
        public void h(String str, String str2, Throwable... thArr) {
            if (this.f12162c > 5 || thArr == null || thArr.length < 1) {
                return;
            }
            Throwable th2 = thArr[0];
        }
    }

    public n(int i12) {
    }

    public static synchronized n c() {
        try {
            if (f12160a == null) {
                f12160a = new a(3);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f12160a;
    }

    public static synchronized void e(n nVar) {
        f12160a = nVar;
    }

    public static String f(String str) {
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(23);
        sb2.append("WM-");
        int i12 = f12161b;
        if (length >= i12) {
            sb2.append(str.substring(0, i12));
        } else {
            sb2.append(str);
        }
        return sb2.toString();
    }

    public abstract void a(String str, String str2, Throwable... thArr);

    public abstract void b(String str, String str2, Throwable... thArr);

    public abstract void d(String str, String str2, Throwable... thArr);

    public abstract void g(String str, String str2, Throwable... thArr);

    public abstract void h(String str, String str2, Throwable... thArr);
}
