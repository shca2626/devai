package org.webrtc;

import android.net.http.X509TrustManagerExtensions;
import java.io.ByteArrayInputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes3.dex */
final class PlatformCertificateVerifier {
    private static final String TAG = "PlatformCertificateVerifier";
    private static CertificateFactory certificateFactory;
    private static boolean initialized;
    private static X509TrustManagerExtensions trustManager;

    private PlatformCertificateVerifier() {
    }

    private static synchronized boolean initialize() {
        boolean z7 = false;
        if (initialized) {
            if (trustManager != null && certificateFactory != null) {
                z7 = true;
            }
            return z7;
        }
        initialized = true;
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            int length = trustManagers.length;
            int i7 = 0;
            while (true) {
                if (i7 >= length) {
                    break;
                }
                TrustManager trustManager2 = trustManagers[i7];
                if (trustManager2 instanceof X509TrustManager) {
                    trustManager = new X509TrustManagerExtensions((X509TrustManager) trustManager2);
                    break;
                }
                i7++;
            }
            certificateFactory = CertificateFactory.getInstance("X.509");
        } catch (Exception e7) {
            Logging.e(TAG, "Could not reach the platform trust store", e7);
            trustManager = null;
            certificateFactory = null;
        }
        if (trustManager != null && certificateFactory != null) {
            z7 = true;
        }
        return z7;
    }

    @CalledByNative
    public static boolean verifyServerChain(byte[][] bArr, String str) {
        if (bArr != null && bArr.length != 0 && initialize()) {
            X509TrustManagerExtensions x509TrustManagerExtensions = trustManager;
            CertificateFactory certificateFactory2 = certificateFactory;
            if (x509TrustManagerExtensions != null && certificateFactory2 != null) {
                return verifyServerChain(bArr, str, x509TrustManagerExtensions, certificateFactory2);
            }
        }
        return false;
    }

    public static boolean verifyServerChain(byte[][] bArr, String str, X509TrustManagerExtensions x509TrustManagerExtensions, CertificateFactory certificateFactory2) throws CertificateException {
        if (bArr != null && bArr.length != 0) {
            try {
                ArrayList arrayList = new ArrayList(bArr.length);
                for (byte[] bArr2 : bArr) {
                    arrayList.add((X509Certificate) certificateFactory2.generateCertificate(new ByteArrayInputStream(bArr2)));
                }
                X509Certificate[] x509CertificateArr = (X509Certificate[]) arrayList.toArray(new X509Certificate[0]);
                String algorithm = x509CertificateArr[0].getPublicKey().getAlgorithm();
                if (algorithm == null) {
                    algorithm = "RSA";
                }
                if (str == null || str.isEmpty()) {
                    str = null;
                }
                x509TrustManagerExtensions.checkServerTrusted(x509CertificateArr, algorithm, str);
                return true;
            } catch (Exception e7) {
                Logging.d(TAG, "Peer certificate chain was rejected by the platform trust store: " + String.valueOf(e7));
            }
        }
        return false;
    }
}
