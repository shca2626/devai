package n6;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import k6.k;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final List f20193a;

    /* renamed from: b, reason: collision with root package name */
    public int f20194b = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f20195c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f20196d;

    public b(List list) {
        this.f20193a = list;
    }

    public k a(SSLSocket sSLSocket) throws UnknownServiceException {
        k kVar;
        int i7 = this.f20194b;
        int size = this.f20193a.size();
        while (true) {
            if (i7 >= size) {
                kVar = null;
                break;
            }
            kVar = (k) this.f20193a.get(i7);
            if (kVar.c(sSLSocket)) {
                this.f20194b = i7 + 1;
                break;
            }
            i7++;
        }
        if (kVar != null) {
            this.f20195c = c(sSLSocket);
            l6.a.f19666a.c(kVar, sSLSocket, this.f20196d);
            return kVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f20196d + ", modes=" + this.f20193a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean b(IOException iOException) {
        this.f20196d = true;
        if (!this.f20195c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z7 = iOException instanceof SSLHandshakeException;
        if ((z7 && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z7 || (iOException instanceof SSLProtocolException) || (iOException instanceof SSLException);
    }

    public final boolean c(SSLSocket sSLSocket) {
        for (int i7 = this.f20194b; i7 < this.f20193a.size(); i7++) {
            if (((k) this.f20193a.get(i7)).c(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
