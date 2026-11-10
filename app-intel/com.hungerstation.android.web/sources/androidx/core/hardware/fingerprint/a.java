package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@Deprecated
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6567a;

    /* renamed from: androidx.core.hardware.fingerprint.a$a, reason: collision with other inner class name */
    static class C0118a {
        static void a(Object obj, Object obj2, CancellationSignal cancellationSignal, int i12, Object obj3, Handler handler) {
            ((FingerprintManager) obj).authenticate((FingerprintManager.CryptoObject) obj2, cancellationSignal, i12, (FingerprintManager.AuthenticationCallback) obj3, handler);
        }

        static FingerprintManager.CryptoObject b(Object obj) {
            return ((FingerprintManager.AuthenticationResult) obj).getCryptoObject();
        }

        public static FingerprintManager c(Context context) {
            int i12 = Build.VERSION.SDK_INT;
            if (i12 == 23) {
                return (FingerprintManager) context.getSystemService(FingerprintManager.class);
            }
            if (i12 <= 23 || !context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
                return null;
            }
            return (FingerprintManager) context.getSystemService(FingerprintManager.class);
        }

        static boolean d(Object obj) {
            return ((FingerprintManager) obj).hasEnrolledFingerprints();
        }

        static boolean e(Object obj) {
            return ((FingerprintManager) obj).isHardwareDetected();
        }

        public static b f(Object obj) {
            FingerprintManager.CryptoObject cryptoObject = (FingerprintManager.CryptoObject) obj;
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new b(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new b(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new b(cryptoObject.getMac());
            }
            return null;
        }

        public static FingerprintManager.CryptoObject g(b bVar) {
            if (bVar == null) {
                return null;
            }
            if (bVar.a() != null) {
                return new FingerprintManager.CryptoObject(bVar.a());
            }
            if (bVar.c() != null) {
                return new FingerprintManager.CryptoObject(bVar.c());
            }
            if (bVar.b() != null) {
                return new FingerprintManager.CryptoObject(bVar.b());
            }
            return null;
        }
    }

    private a(Context context) {
        this.f6567a = context;
    }

    public static a a(Context context) {
        return new a(context);
    }

    private static FingerprintManager b(Context context) {
        return C0118a.c(context);
    }

    public boolean c() {
        FingerprintManager fingerprintManagerB;
        return Build.VERSION.SDK_INT >= 23 && (fingerprintManagerB = b(this.f6567a)) != null && C0118a.d(fingerprintManagerB);
    }

    public boolean d() {
        FingerprintManager fingerprintManagerB;
        return Build.VERSION.SDK_INT >= 23 && (fingerprintManagerB = b(this.f6567a)) != null && C0118a.e(fingerprintManagerB);
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Signature f6568a;

        /* renamed from: b, reason: collision with root package name */
        private final Cipher f6569b;

        /* renamed from: c, reason: collision with root package name */
        private final Mac f6570c;

        public b(Signature signature) {
            this.f6568a = signature;
            this.f6569b = null;
            this.f6570c = null;
        }

        public Cipher a() {
            return this.f6569b;
        }

        public Mac b() {
            return this.f6570c;
        }

        public Signature c() {
            return this.f6568a;
        }

        public b(Cipher cipher) {
            this.f6569b = cipher;
            this.f6568a = null;
            this.f6570c = null;
        }

        public b(Mac mac) {
            this.f6570c = mac;
            this.f6569b = null;
            this.f6568a = null;
        }
    }
}
