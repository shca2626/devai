package U0;

import j3.AbstractC1229c;
import java.util.Map;
import k3.AbstractC1281x;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final int f8351a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8352b;

    /* renamed from: c, reason: collision with root package name */
    public final B0.s f8353c;

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC1281x f8354d;

    /* renamed from: e, reason: collision with root package name */
    public final String f8355e;

    public g(B0.s sVar, int i7, int i8, Map map, String str) {
        this.f8351a = i7;
        this.f8352b = i8;
        this.f8353c = sVar;
        this.f8354d = AbstractC1281x.c(map);
        this.f8355e = str;
    }

    public static String a(String str) {
        String strG = AbstractC1229c.g(str);
        strG.getClass();
        switch (strG) {
            case "MPEG4-GENERIC":
            case "MP4A-LATM":
                return "audio/mp4a-latm";
            case "L8":
            case "L16":
                return "audio/raw";
            case "AC3":
                return "audio/ac3";
            case "AMR":
                return "audio/3gpp";
            case "VP8":
                return "video/x-vnd.on2.vp8";
            case "VP9":
                return "video/x-vnd.on2.vp9";
            case "H264":
                return "video/avc";
            case "H265":
                return "video/hevc";
            case "OPUS":
                return "audio/opus";
            case "PCMA":
                return "audio/g711-alaw";
            case "PCMU":
                return "audio/g711-mlaw";
            case "AMR-WB":
                return "audio/amr-wb";
            case "MP4V-ES":
                return "video/mp4v-es";
            case "H263-1998":
            case "H263-2000":
                return "video/3gpp";
            default:
                throw new IllegalArgumentException(str);
        }
    }

    public static int b(String str) {
        j3.o.d(str.equals("L8") || str.equals("L16"));
        return str.equals("L8") ? 3 : 268435456;
    }

    public static boolean c(a aVar) {
        String strG = AbstractC1229c.g(aVar.f8295j.f8306b);
        strG.getClass();
        switch (strG) {
            case "MPEG4-GENERIC":
            case "L8":
            case "AC3":
            case "AMR":
            case "L16":
            case "VP8":
            case "VP9":
            case "H264":
            case "H265":
            case "OPUS":
            case "PCMA":
            case "PCMU":
            case "MP4A-LATM":
            case "AMR-WB":
            case "MP4V-ES":
            case "H263-1998":
            case "H263-2000":
                return true;
            default:
                return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && g.class == obj.getClass()) {
            g gVar = (g) obj;
            if (this.f8351a == gVar.f8351a && this.f8352b == gVar.f8352b && this.f8353c.equals(gVar.f8353c) && this.f8354d.equals(gVar.f8354d) && this.f8355e.equals(gVar.f8355e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((217 + this.f8351a) * 31) + this.f8352b) * 31) + this.f8353c.hashCode()) * 31) + this.f8354d.hashCode()) * 31) + this.f8355e.hashCode();
    }
}
