package androidx.media3.exoplayer.rtsp;

import E0.U;
import j3.AbstractC1229c;
import java.util.List;
import java.util.Map;
import k3.AbstractC1279v;
import k3.C1280w;
import k3.D;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final e f12733b = new b().e();

    /* renamed from: a, reason: collision with root package name */
    public final C1280w f12734a;

    public static String c(String str) {
        return AbstractC1229c.a(str, "Accept") ? "Accept" : AbstractC1229c.a(str, "Allow") ? "Allow" : AbstractC1229c.a(str, "Authorization") ? "Authorization" : AbstractC1229c.a(str, "Bandwidth") ? "Bandwidth" : AbstractC1229c.a(str, "Blocksize") ? "Blocksize" : AbstractC1229c.a(str, "Cache-Control") ? "Cache-Control" : AbstractC1229c.a(str, "Connection") ? "Connection" : AbstractC1229c.a(str, "Content-Base") ? "Content-Base" : AbstractC1229c.a(str, "Content-Encoding") ? "Content-Encoding" : AbstractC1229c.a(str, "Content-Language") ? "Content-Language" : AbstractC1229c.a(str, "Content-Length") ? "Content-Length" : AbstractC1229c.a(str, "Content-Location") ? "Content-Location" : AbstractC1229c.a(str, "Content-Type") ? "Content-Type" : AbstractC1229c.a(str, "CSeq") ? "CSeq" : AbstractC1229c.a(str, "Date") ? "Date" : AbstractC1229c.a(str, "Expires") ? "Expires" : AbstractC1229c.a(str, "Location") ? "Location" : AbstractC1229c.a(str, "Proxy-Authenticate") ? "Proxy-Authenticate" : AbstractC1229c.a(str, "Proxy-Require") ? "Proxy-Require" : AbstractC1229c.a(str, "Public") ? "Public" : AbstractC1229c.a(str, "Range") ? "Range" : AbstractC1229c.a(str, "RTP-Info") ? "RTP-Info" : AbstractC1229c.a(str, "RTCP-Interval") ? "RTCP-Interval" : AbstractC1229c.a(str, "Scale") ? "Scale" : AbstractC1229c.a(str, "Session") ? "Session" : AbstractC1229c.a(str, "Speed") ? "Speed" : AbstractC1229c.a(str, "Supported") ? "Supported" : AbstractC1229c.a(str, "Timestamp") ? "Timestamp" : AbstractC1229c.a(str, "Transport") ? "Transport" : AbstractC1229c.a(str, "User-Agent") ? "User-Agent" : AbstractC1229c.a(str, "Via") ? "Via" : AbstractC1229c.a(str, "WWW-Authenticate") ? "WWW-Authenticate" : str;
    }

    public C1280w b() {
        return this.f12734a;
    }

    public String d(String str) {
        AbstractC1279v abstractC1279vE = e(str);
        if (abstractC1279vE.isEmpty()) {
            return null;
        }
        return (String) D.d(abstractC1279vE);
    }

    public AbstractC1279v e(String str) {
        return this.f12734a.get(c(str));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return this.f12734a.equals(((e) obj).f12734a);
        }
        return false;
    }

    public int hashCode() {
        return this.f12734a.hashCode();
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final C1280w.a f12735a;

        public b() {
            this.f12735a = new C1280w.a();
        }

        public b b(String str, String str2) {
            this.f12735a.f(e.c(str.trim()), str2.trim());
            return this;
        }

        public b c(List list) {
            for (int i7 = 0; i7 < list.size(); i7++) {
                String[] strArrL1 = U.l1((String) list.get(i7), ":\\s?");
                if (strArrL1.length == 2) {
                    b(strArrL1[0], strArrL1[1]);
                }
            }
            return this;
        }

        public b d(Map map) {
            for (Map.Entry entry : map.entrySet()) {
                b((String) entry.getKey(), (String) entry.getValue());
            }
            return this;
        }

        public e e() {
            return new e(this);
        }

        public b(String str, String str2, int i7) {
            this();
            b("User-Agent", str);
            b("CSeq", String.valueOf(i7));
            if (str2 != null) {
                b("Session", str2);
            }
        }
    }

    public e(b bVar) {
        this.f12734a = bVar.f12735a.e();
    }
}
