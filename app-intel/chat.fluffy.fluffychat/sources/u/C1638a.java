package u;

import Q.a;
import android.hardware.biometrics.BiometricPrompt;
import android.hardware.biometrics.BiometricPrompt$AuthenticationCallback;
import android.os.Build;
import u.f;

/* renamed from: u.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1638a {

    /* renamed from: a, reason: collision with root package name */
    public BiometricPrompt$AuthenticationCallback f22615a;

    /* renamed from: b, reason: collision with root package name */
    public a.AbstractC0060a f22616b;

    /* renamed from: c, reason: collision with root package name */
    public final d f22617c;

    /* renamed from: u.a$a, reason: collision with other inner class name */
    public class C0273a extends a.AbstractC0060a {
        public C0273a() {
        }
    }

    /* renamed from: u.a$c */
    public static class c {
        public static int a(BiometricPrompt.AuthenticationResult authenticationResult) {
            return authenticationResult.getAuthenticationType();
        }
    }

    /* renamed from: u.a$d */
    public static class d {
        public abstract void a(int i7, CharSequence charSequence);

        public abstract void b();

        public abstract void c(f.b bVar);
    }

    public C1638a(d dVar) {
        this.f22617c = dVar;
    }

    public BiometricPrompt$AuthenticationCallback a() {
        if (this.f22615a == null) {
            this.f22615a = b.a(this.f22617c);
        }
        return this.f22615a;
    }

    public a.AbstractC0060a b() {
        if (this.f22616b == null) {
            this.f22616b = new C0273a();
        }
        return this.f22616b;
    }

    /* renamed from: u.a$b */
    public static class b {
        public static BiometricPrompt$AuthenticationCallback a(d dVar) {
            return new C0274a(dVar);
        }

        /* renamed from: u.a$b$a, reason: collision with other inner class name */
        public class C0274a extends BiometricPrompt$AuthenticationCallback {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f22619a;

            public C0274a(d dVar) {
                this.f22619a = dVar;
            }

            public void onAuthenticationError(int i7, CharSequence charSequence) {
                this.f22619a.a(i7, charSequence);
            }

            public void onAuthenticationFailed() {
                this.f22619a.b();
            }

            public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
                f.c cVarB = authenticationResult != null ? i.b(authenticationResult.getCryptoObject()) : null;
                int i7 = Build.VERSION.SDK_INT;
                int iA = -1;
                if (i7 >= 30) {
                    if (authenticationResult != null) {
                        iA = c.a(authenticationResult);
                    }
                } else if (i7 != 29) {
                    iA = 2;
                }
                this.f22619a.c(new f.b(cVarB, iA));
            }

            public void onAuthenticationHelp(int i7, CharSequence charSequence) {
            }
        }
    }
}
