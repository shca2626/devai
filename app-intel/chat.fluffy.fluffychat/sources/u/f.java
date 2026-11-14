package u;

import android.os.Build;
import android.security.identity.IdentityCredential;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.N;
import java.security.Signature;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import r0.AbstractC1516J;
import r0.ActivityC1553v;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public AbstractC1516J f22648a;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final c f22649a;

        /* renamed from: b, reason: collision with root package name */
        public final int f22650b;

        public b(c cVar, int i7) {
            this.f22649a = cVar;
            this.f22650b = i7;
        }

        public int a() {
            return this.f22650b;
        }

        public c b() {
            return this.f22649a;
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final CharSequence f22655a;

        /* renamed from: b, reason: collision with root package name */
        public final CharSequence f22656b;

        /* renamed from: c, reason: collision with root package name */
        public final CharSequence f22657c;

        /* renamed from: d, reason: collision with root package name */
        public final CharSequence f22658d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f22659e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f22660f;

        /* renamed from: g, reason: collision with root package name */
        public final int f22661g;

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public CharSequence f22662a = null;

            /* renamed from: b, reason: collision with root package name */
            public CharSequence f22663b = null;

            /* renamed from: c, reason: collision with root package name */
            public CharSequence f22664c = null;

            /* renamed from: d, reason: collision with root package name */
            public CharSequence f22665d = null;

            /* renamed from: e, reason: collision with root package name */
            public boolean f22666e = true;

            /* renamed from: f, reason: collision with root package name */
            public boolean f22667f = false;

            /* renamed from: g, reason: collision with root package name */
            public int f22668g = 0;

            public d a() {
                if (TextUtils.isEmpty(this.f22662a)) {
                    throw new IllegalArgumentException("Title must be set and non-empty.");
                }
                if (!AbstractC1639b.e(this.f22668g)) {
                    throw new IllegalArgumentException("Authenticator combination is unsupported on API " + Build.VERSION.SDK_INT + ": " + AbstractC1639b.a(this.f22668g));
                }
                int i7 = this.f22668g;
                boolean zC = i7 != 0 ? AbstractC1639b.c(i7) : this.f22667f;
                if (TextUtils.isEmpty(this.f22665d) && !zC) {
                    throw new IllegalArgumentException("Negative text must be set and non-empty.");
                }
                if (TextUtils.isEmpty(this.f22665d) || !zC) {
                    return new d(this.f22662a, this.f22663b, this.f22664c, this.f22665d, this.f22666e, this.f22667f, this.f22668g);
                }
                throw new IllegalArgumentException("Negative text must not be set if device credential authentication is allowed.");
            }

            public a b(int i7) {
                this.f22668g = i7;
                return this;
            }

            public a c(boolean z7) {
                this.f22666e = z7;
                return this;
            }

            public a d(CharSequence charSequence) {
                this.f22664c = charSequence;
                return this;
            }

            public a e(CharSequence charSequence) {
                this.f22665d = charSequence;
                return this;
            }

            public a f(CharSequence charSequence) {
                this.f22663b = charSequence;
                return this;
            }

            public a g(CharSequence charSequence) {
                this.f22662a = charSequence;
                return this;
            }
        }

        public d(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, boolean z7, boolean z8, int i7) {
            this.f22655a = charSequence;
            this.f22656b = charSequence2;
            this.f22657c = charSequence3;
            this.f22658d = charSequence4;
            this.f22659e = z7;
            this.f22660f = z8;
            this.f22661g = i7;
        }

        public int a() {
            return this.f22661g;
        }

        public CharSequence b() {
            return this.f22657c;
        }

        public CharSequence c() {
            CharSequence charSequence = this.f22658d;
            return charSequence != null ? charSequence : "";
        }

        public CharSequence d() {
            return this.f22656b;
        }

        public CharSequence e() {
            return this.f22655a;
        }

        public boolean f() {
            return this.f22659e;
        }

        public boolean g() {
            return this.f22660f;
        }
    }

    public f(ActivityC1553v activityC1553v, Executor executor, a aVar) {
        if (activityC1553v == null) {
            throw new IllegalArgumentException("FragmentActivity must not be null.");
        }
        if (executor == null) {
            throw new IllegalArgumentException("Executor must not be null.");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("AuthenticationCallback must not be null.");
        }
        g(activityC1553v.T0(), f(activityC1553v), executor, aVar);
    }

    public static u.d d(AbstractC1516J abstractC1516J) {
        return (u.d) abstractC1516J.j0("androidx.biometric.BiometricFragment");
    }

    public static u.d e(AbstractC1516J abstractC1516J) {
        u.d dVarD = d(abstractC1516J);
        if (dVarD != null) {
            return dVarD;
        }
        u.d dVarX2 = u.d.x2();
        abstractC1516J.o().d(dVarX2, "androidx.biometric.BiometricFragment").g();
        abstractC1516J.f0();
        return dVarX2;
    }

    public static g f(ActivityC1553v activityC1553v) {
        if (activityC1553v != null) {
            return (g) new N(activityC1553v).b(g.class);
        }
        return null;
    }

    public void a(d dVar) {
        if (dVar == null) {
            throw new IllegalArgumentException("PromptInfo cannot be null.");
        }
        b(dVar, null);
    }

    public final void b(d dVar, c cVar) {
        AbstractC1516J abstractC1516J = this.f22648a;
        if (abstractC1516J == null) {
            Log.e("BiometricPromptCompat", "Unable to start authentication. Client fragment manager was null.");
        } else if (abstractC1516J.Q0()) {
            Log.e("BiometricPromptCompat", "Unable to start authentication. Called after onSaveInstanceState().");
        } else {
            e(this.f22648a).h2(dVar, cVar);
        }
    }

    public void c() {
        AbstractC1516J abstractC1516J = this.f22648a;
        if (abstractC1516J == null) {
            Log.e("BiometricPromptCompat", "Unable to start authentication. Client fragment manager was null.");
            return;
        }
        u.d dVarD = d(abstractC1516J);
        if (dVarD == null) {
            Log.e("BiometricPromptCompat", "Unable to cancel authentication. BiometricFragment not found.");
        } else {
            dVarD.k2(3);
        }
    }

    public final void g(AbstractC1516J abstractC1516J, g gVar, Executor executor, a aVar) {
        this.f22648a = abstractC1516J;
        if (gVar != null) {
            if (executor != null) {
                gVar.N(executor);
            }
            gVar.M(aVar);
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final Signature f22651a;

        /* renamed from: b, reason: collision with root package name */
        public final Cipher f22652b;

        /* renamed from: c, reason: collision with root package name */
        public final Mac f22653c;

        /* renamed from: d, reason: collision with root package name */
        public final IdentityCredential f22654d;

        public c(Signature signature) {
            this.f22651a = signature;
            this.f22652b = null;
            this.f22653c = null;
            this.f22654d = null;
        }

        public Cipher a() {
            return this.f22652b;
        }

        public IdentityCredential b() {
            return this.f22654d;
        }

        public Mac c() {
            return this.f22653c;
        }

        public Signature d() {
            return this.f22651a;
        }

        public c(Cipher cipher) {
            this.f22651a = null;
            this.f22652b = cipher;
            this.f22653c = null;
            this.f22654d = null;
        }

        public c(Mac mac) {
            this.f22651a = null;
            this.f22652b = null;
            this.f22653c = mac;
            this.f22654d = null;
        }

        public c(IdentityCredential identityCredential) {
            this.f22651a = null;
            this.f22652b = null;
            this.f22653c = null;
            this.f22654d = identityCredential;
        }
    }

    public static abstract class a {
        public void b() {
        }

        public void c(b bVar) {
        }

        public void a(int i7, CharSequence charSequence) {
        }
    }
}
