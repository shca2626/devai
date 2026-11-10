package u;

import android.content.Context;
import android.hardware.biometrics.BiometricManager;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final d f22638a;

    /* renamed from: b, reason: collision with root package name */
    public final BiometricManager f22639b;

    /* renamed from: c, reason: collision with root package name */
    public final Q.a f22640c;

    public static class a {
        public static int a(BiometricManager biometricManager) {
            return biometricManager.canAuthenticate();
        }

        public static BiometricManager b(Context context) {
            return (BiometricManager) context.getSystemService(BiometricManager.class);
        }

        public static Method c() {
            try {
                return BiometricManager.class.getMethod("canAuthenticate", BiometricPrompt.CryptoObject.class);
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }
    }

    public static class b {
        public static int a(BiometricManager biometricManager, int i7) {
            return biometricManager.canAuthenticate(i7);
        }
    }

    public static class c implements d {

        /* renamed from: a, reason: collision with root package name */
        public final Context f22641a;

        public c(Context context) {
            this.f22641a = context.getApplicationContext();
        }

        @Override // u.e.d
        public BiometricManager a() {
            return a.b(this.f22641a);
        }

        @Override // u.e.d
        public boolean b() {
            return m.a(this.f22641a) != null;
        }

        @Override // u.e.d
        public boolean c() {
            return n.a(this.f22641a);
        }

        @Override // u.e.d
        public boolean d() {
            return m.b(this.f22641a);
        }

        @Override // u.e.d
        public boolean e() {
            return j.a(this.f22641a, Build.MODEL);
        }

        @Override // u.e.d
        public Q.a f() {
            return Q.a.b(this.f22641a);
        }
    }

    public interface d {
        BiometricManager a();

        boolean b();

        boolean c();

        boolean d();

        boolean e();

        Q.a f();
    }

    public e(d dVar) {
        this.f22638a = dVar;
        int i7 = Build.VERSION.SDK_INT;
        this.f22639b = i7 >= 29 ? dVar.a() : null;
        this.f22640c = i7 <= 29 ? dVar.f() : null;
    }

    public static e g(Context context) {
        return new e(new c(context));
    }

    public int a(int i7) {
        if (Build.VERSION.SDK_INT < 30) {
            return b(i7);
        }
        BiometricManager biometricManager = this.f22639b;
        if (biometricManager != null) {
            return b.a(biometricManager, i7);
        }
        Log.e("BiometricManager", "Failure in canAuthenticate(). BiometricManager was null.");
        return 1;
    }

    public final int b(int i7) {
        if (!AbstractC1640b.e(i7)) {
            return -2;
        }
        if (i7 == 0 || !this.f22638a.b()) {
            return 12;
        }
        if (AbstractC1640b.c(i7)) {
            return this.f22638a.d() ? 0 : 11;
        }
        int i8 = Build.VERSION.SDK_INT;
        if (i8 == 29) {
            return AbstractC1640b.f(i7) ? f() : e();
        }
        if (i8 != 28) {
            return c();
        }
        if (this.f22638a.c()) {
            return d();
        }
        return 12;
    }

    public final int c() {
        Q.a aVar = this.f22640c;
        if (aVar == null) {
            Log.e("BiometricManager", "Failure in canAuthenticate(). FingerprintManager was null.");
            return 1;
        }
        if (aVar.d()) {
            return !this.f22640c.c() ? 11 : 0;
        }
        return 12;
    }

    public final int d() {
        return !this.f22638a.d() ? c() : c() == 0 ? 0 : -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0044 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int e() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r4 = this;
            java.lang.String r0 = "BiometricManager"
            java.lang.reflect.Method r1 = u.e.a.c()
            if (r1 == 0) goto L38
            u.f$c r2 = u.i.a()
            android.hardware.biometrics.BiometricPrompt$CryptoObject r2 = u.i.c(r2)
            if (r2 == 0) goto L38
            android.hardware.biometrics.BiometricManager r3 = r4.f22639b     // Catch: java.lang.reflect.InvocationTargetException -> L27 java.lang.IllegalArgumentException -> L29 java.lang.IllegalAccessException -> L2b
            java.lang.Object[] r2 = new java.lang.Object[]{r2}     // Catch: java.lang.reflect.InvocationTargetException -> L27 java.lang.IllegalArgumentException -> L29 java.lang.IllegalAccessException -> L2b
            java.lang.Object r1 = r1.invoke(r3, r2)     // Catch: java.lang.reflect.InvocationTargetException -> L27 java.lang.IllegalArgumentException -> L29 java.lang.IllegalAccessException -> L2b
            boolean r2 = r1 instanceof java.lang.Integer     // Catch: java.lang.reflect.InvocationTargetException -> L27 java.lang.IllegalArgumentException -> L29 java.lang.IllegalAccessException -> L2b
            if (r2 == 0) goto L2d
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.reflect.InvocationTargetException -> L27 java.lang.IllegalArgumentException -> L29 java.lang.IllegalAccessException -> L2b
            int r0 = r1.intValue()     // Catch: java.lang.reflect.InvocationTargetException -> L27 java.lang.IllegalArgumentException -> L29 java.lang.IllegalAccessException -> L2b
            return r0
        L27:
            r1 = move-exception
            goto L33
        L29:
            r1 = move-exception
            goto L33
        L2b:
            r1 = move-exception
            goto L33
        L2d:
            java.lang.String r1 = "Invalid return type for canAuthenticate(CryptoObject)."
            android.util.Log.w(r0, r1)     // Catch: java.lang.reflect.InvocationTargetException -> L27 java.lang.IllegalArgumentException -> L29 java.lang.IllegalAccessException -> L2b
            goto L38
        L33:
            java.lang.String r2 = "Failed to invoke canAuthenticate(CryptoObject)."
            android.util.Log.w(r0, r2, r1)
        L38:
            int r0 = r4.f()
            u.e$d r1 = r4.f22638a
            boolean r1 = r1.e()
            if (r1 != 0) goto L4b
            if (r0 == 0) goto L47
            goto L4b
        L47:
            int r0 = r4.d()
        L4b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u.e.e():int");
    }

    public final int f() {
        BiometricManager biometricManager = this.f22639b;
        if (biometricManager != null) {
            return a.a(biometricManager);
        }
        Log.e("BiometricManager", "Failure in canAuthenticate(). BiometricManager was null.");
        return 1;
    }
}
