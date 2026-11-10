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
import r0.AbstractC1517J;
import r0.ActivityC1554v;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public AbstractC1517J f22642a;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final c f22643a;

        /* renamed from: b, reason: collision with root package name */
        public final int f22644b;

        public b(c cVar, int i7) {
            this.f22643a = cVar;
            this.f22644b = i7;
        }

        public int a() {
            return this.f22644b;
        }

        public c b() {
            return this.f22643a;
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final CharSequence f22649a;

        /* renamed from: b, reason: collision with root package name */
        public final CharSequence f22650b;

        /* renamed from: c, reason: collision with root package name */
        public final CharSequence f22651c;

        /* renamed from: d, reason: collision with root package name */
        public final CharSequence f22652d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f22653e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f22654f;

        /* renamed from: g, reason: collision with root package name */
        public final int f22655g;

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public CharSequence f22656a = null;

            /* renamed from: b, reason: collision with root package name */
            public CharSequence f22657b = null;

            /* renamed from: c, reason: collision with root package name */
            public CharSequence f22658c = null;

            /* renamed from: d, reason: collision with root package name */
            public CharSequence f22659d = null;

            /* renamed from: e, reason: collision with root package name */
            public boolean f22660e = true;

            /* renamed from: f, reason: collision with root package name */
            public boolean f22661f = false;

            /* renamed from: g, reason: collision with root package name */
            public int f22662g = 0;

            public d a() {
                if (TextUtils.isEmpty(this.f22656a)) {
                    throw new IllegalArgumentException("Title must be set and non-empty.");
                }
                if (!AbstractC1640b.e(this.f22662g)) {
                    throw new IllegalArgumentException("Authenticator combination is unsupported on API " + Build.VERSION.SDK_INT + ": " + AbstractC1640b.a(this.f22662g));
                }
                int i7 = this.f22662g;
                boolean zC = i7 != 0 ? AbstractC1640b.c(i7) : this.f22661f;
                if (TextUtils.isEmpty(this.f22659d) && !zC) {
                    throw new IllegalArgumentException("Negative text must be set and non-empty.");
                }
                if (TextUtils.isEmpty(this.f22659d) || !zC) {
                    return new d(this.f22656a, this.f22657b, this.f22658c, this.f22659d, this.f22660e, this.f22661f, this.f22662g);
                }
                throw new IllegalArgumentException("Negative text must not be set if device credential authentication is allowed.");
            }

            public a b(int i7) {
                this.f22662g = i7;
                return this;
            }

            public a c(boolean z7) {
                this.f22660e = z7;
                return this;
            }

            public a d(CharSequence charSequence) {
                this.f22658c = charSequence;
                return this;
            }

            public a e(CharSequence charSequence) {
                this.f22659d = charSequence;
                return this;
            }

            public a f(CharSequence charSequence) {
                this.f22657b = charSequence;
                return this;
            }

            public a g(CharSequence charSequence) {
                this.f22656a = charSequence;
                return this;
            }
        }

        public d(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, boolean z7, boolean z8, int i7) {
            this.f22649a = charSequence;
            this.f22650b = charSequence2;
            this.f22651c = charSequence3;
            this.f22652d = charSequence4;
            this.f22653e = z7;
            this.f22654f = z8;
            this.f22655g = i7;
        }

        public int a() {
            return this.f22655g;
        }

        public CharSequence b() {
            return this.f22651c;
        }

        public CharSequence c() {
            CharSequence charSequence = this.f22652d;
            return charSequence != null ? charSequence : "";
        }

        public CharSequence d() {
            return this.f22650b;
        }

        public CharSequence e() {
            return this.f22649a;
        }

        public boolean f() {
            return this.f22653e;
        }

        public boolean g() {
            return this.f22654f;
        }
    }

    public f(ActivityC1554v activityC1554v, Executor executor, a aVar) {
        if (activityC1554v == null) {
            throw new IllegalArgumentException("FragmentActivity must not be null.");
        }
        if (executor == null) {
            throw new IllegalArgumentException("Executor must not be null.");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("AuthenticationCallback must not be null.");
        }
        g(activityC1554v.T0(), f(activityC1554v), executor, aVar);
    }

    public static u.d d(AbstractC1517J abstractC1517J) {
        return (u.d) abstractC1517J.j0("androidx.biometric.BiometricFragment");
    }

    public static u.d e(AbstractC1517J abstractC1517J) {
        u.d dVarD = d(abstractC1517J);
        if (dVarD != null) {
            return dVarD;
        }
        u.d dVarX2 = u.d.x2();
        abstractC1517J.o().d(dVarX2, "androidx.biometric.BiometricFragment").g();
        abstractC1517J.f0();
        return dVarX2;
    }

    public static g f(ActivityC1554v activityC1554v) {
        if (activityC1554v != null) {
            return (g) new N(activityC1554v).b(g.class);
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
        AbstractC1517J abstractC1517J = this.f22642a;
        if (abstractC1517J == null) {
            Log.e("BiometricPromptCompat", "Unable to start authentication. Client fragment manager was null.");
        } else if (abstractC1517J.Q0()) {
            Log.e("BiometricPromptCompat", "Unable to start authentication. Called after onSaveInstanceState().");
        } else {
            e(this.f22642a).h2(dVar, cVar);
        }
    }

    public void c() {
        AbstractC1517J abstractC1517J = this.f22642a;
        if (abstractC1517J == null) {
            Log.e("BiometricPromptCompat", "Unable to start authentication. Client fragment manager was null.");
            return;
        }
        u.d dVarD = d(abstractC1517J);
        if (dVarD == null) {
            Log.e("BiometricPromptCompat", "Unable to cancel authentication. BiometricFragment not found.");
        } else {
            dVarD.k2(3);
        }
    }

    public final void g(AbstractC1517J abstractC1517J, g gVar, Executor executor, a aVar) {
        this.f22642a = abstractC1517J;
        if (gVar != null) {
            if (executor != null) {
                gVar.N(executor);
            }
            gVar.M(aVar);
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final Signature f22645a;

        /* renamed from: b, reason: collision with root package name */
        public final Cipher f22646b;

        /* renamed from: c, reason: collision with root package name */
        public final Mac f22647c;

        /* renamed from: d, reason: collision with root package name */
        public final IdentityCredential f22648d;

        public c(Signature signature) {
            this.f22645a = signature;
            this.f22646b = null;
            this.f22647c = null;
            this.f22648d = null;
        }

        public Cipher a() {
            return this.f22646b;
        }

        public IdentityCredential b() {
            return this.f22648d;
        }

        public Mac c() {
            return this.f22647c;
        }

        public Signature d() {
            return this.f22645a;
        }

        public c(Cipher cipher) {
            this.f22645a = null;
            this.f22646b = cipher;
            this.f22647c = null;
            this.f22648d = null;
        }

        public c(Mac mac) {
            this.f22645a = null;
            this.f22646b = null;
            this.f22647c = mac;
            this.f22648d = null;
        }

        public c(IdentityCredential identityCredential) {
            this.f22645a = null;
            this.f22646b = null;
            this.f22647c = null;
            this.f22648d = identityCredential;
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
