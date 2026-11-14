package B0;

import E0.U;
import android.text.TextUtils;
import j3.AbstractC1228c;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList f1057a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f1058b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f1059a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1060b;

        public a(int i7, int i8) {
            this.f1059a = i7;
            this.f1060b = i8;
        }

        public int a() {
            int i7 = this.f1060b;
            if (i7 == 2) {
                return 10;
            }
            if (i7 == 5) {
                return 11;
            }
            if (i7 == 29) {
                return 12;
            }
            if (i7 == 42) {
                return 16;
            }
            if (i7 != 22) {
                return i7 != 23 ? 0 : 15;
            }
            return 1073741824;
        }
    }

    public static boolean a(String str, String str2) {
        a aVarI;
        int iA;
        if (str == null) {
            return false;
        }
        switch (str) {
            case "audio/mp4a-latm":
                if (str2 != null && (aVarI = i(str2)) != null && (iA = aVarI.a()) != 0 && iA != 16) {
                }
                break;
        }
        return false;
    }

    public static boolean b(String str, String str2) {
        return d(str, str2) != null;
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : U.m1(str)) {
            String strG = g(str2);
            if (strG != null && o(strG)) {
                return strG;
            }
        }
        return null;
    }

    public static String d(String str, String str2) {
        if (str != null && str2 != null) {
            String[] strArrM1 = U.m1(str);
            StringBuilder sb = new StringBuilder();
            for (String str3 : strArrM1) {
                if (str2.equals(g(str3))) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(str3);
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
        }
        return null;
    }

    public static String e(String str) {
        ArrayList arrayList = f1057a;
        if (arrayList.size() <= 0) {
            return null;
        }
        android.support.v4.media.session.b.a(arrayList.get(0));
        throw null;
    }

    public static int f(String str, String str2) {
        a aVarI;
        str.getClass();
        switch (str) {
            case "audio/eac3-joc":
                return 18;
            case "audio/vnd.dts.hd;profile=lbr":
                return 8;
            case "audio/vnd.dts":
                return 7;
            case "audio/mp4a-latm":
                if (str2 == null || (aVarI = i(str2)) == null) {
                    return 0;
                }
                return aVarI.a();
            case "audio/ac3":
                return 5;
            case "audio/ac4":
                return 17;
            case "audio/vnd.dts.uhd;profile=p2":
                return 30;
            case "audio/eac3":
                return 6;
            case "audio/mpeg":
                return 9;
            case "audio/opus":
                return 20;
            case "audio/vnd.dts.hd":
                return 8;
            case "audio/true-hd":
                return 14;
            default:
                return 0;
        }
    }

    public static String g(String str) {
        a aVarI;
        String strH = null;
        if (str == null) {
            return null;
        }
        String strF = AbstractC1228c.f(str.trim());
        if (strF.startsWith("avc1") || strF.startsWith("avc3")) {
            return "video/avc";
        }
        if (strF.startsWith("hev1") || strF.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (strF.startsWith("dvav") || strF.startsWith("dva1") || strF.startsWith("dvhe") || strF.startsWith("dvh1")) {
            return "video/dolby-vision";
        }
        if (strF.startsWith("av01")) {
            return "video/av01";
        }
        if (strF.startsWith("vp9") || strF.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (strF.startsWith("vp8") || strF.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (!strF.startsWith("mp4a")) {
            return strF.startsWith("mha1") ? "audio/mha1" : strF.startsWith("mhm1") ? "audio/mhm1" : (strF.startsWith("ac-3") || strF.startsWith("dac3")) ? "audio/ac3" : (strF.startsWith("ec-3") || strF.startsWith("dec3")) ? "audio/eac3" : strF.startsWith("ec+3") ? "audio/eac3-joc" : (strF.startsWith("ac-4") || strF.startsWith("dac4")) ? "audio/ac4" : strF.startsWith("dtsc") ? "audio/vnd.dts" : strF.startsWith("dtse") ? "audio/vnd.dts.hd;profile=lbr" : (strF.startsWith("dtsh") || strF.startsWith("dtsl")) ? "audio/vnd.dts.hd" : strF.startsWith("dtsx") ? "audio/vnd.dts.uhd;profile=p2" : strF.startsWith("opus") ? "audio/opus" : strF.startsWith("vorbis") ? "audio/vorbis" : strF.startsWith("flac") ? "audio/flac" : strF.startsWith("stpp") ? "application/ttml+xml" : strF.startsWith("wvtt") ? "text/vtt" : strF.contains("cea708") ? "application/cea-708" : (strF.contains("eia608") || strF.contains("cea608")) ? "application/cea-608" : e(strF);
        }
        if (strF.startsWith("mp4a.") && (aVarI = i(strF)) != null) {
            strH = h(aVarI.f1059a);
        }
        return strH == null ? "audio/mp4a-latm" : strH;
    }

    public static String h(int i7) {
        if (i7 == 32) {
            return "video/mp4v-es";
        }
        if (i7 == 33) {
            return "video/avc";
        }
        if (i7 == 35) {
            return "video/hevc";
        }
        if (i7 == 64) {
            return "audio/mp4a-latm";
        }
        if (i7 == 163) {
            return "video/wvc1";
        }
        if (i7 == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i7 == 221) {
            return "audio/vorbis";
        }
        if (i7 == 165) {
            return "audio/ac3";
        }
        if (i7 == 166) {
            return "audio/eac3";
        }
        switch (i7) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return "video/mpeg2";
            case 102:
            case 103:
            case 104:
                return "audio/mp4a-latm";
            case 105:
            case 107:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            case 108:
                return "image/jpeg";
            default:
                switch (i7) {
                    case 169:
                    case 172:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    public static a i(String str) {
        Matcher matcher = f1058b.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String str2 = (String) j3.o.q(matcher.group(1));
        String strGroup = matcher.group(2);
        try {
            return new a(Integer.parseInt(str2, 16), strGroup != null ? Integer.parseInt(strGroup) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static String j(String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, iIndexOf);
    }

    public static int k(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (o(str)) {
            return 1;
        }
        if (t(str)) {
            return 2;
        }
        if (s(str)) {
            return 3;
        }
        if (q(str)) {
            return 4;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str) || "application/meta".equals(str)) {
            return 5;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 6;
        }
        return l(str);
    }

    public static int l(String str) {
        ArrayList arrayList = f1057a;
        if (arrayList.size() <= 0) {
            return -1;
        }
        android.support.v4.media.session.b.a(arrayList.get(0));
        throw null;
    }

    public static int m(String str) {
        return k(g(str));
    }

    public static String n(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : U.m1(str)) {
            String strG = g(str2);
            if (strG != null && t(strG)) {
                return strG;
            }
        }
        return null;
    }

    public static boolean o(String str) {
        return MediaStreamTrack.AUDIO_TRACK_KIND.equals(j(str));
    }

    public static boolean p(String str, String str2) {
        if (str == null) {
            return false;
        }
        if (str.startsWith("dvhe") || str.startsWith("dvh1")) {
            return true;
        }
        if (str2 == null) {
            return false;
        }
        return (str2.startsWith("dvhe") && str.startsWith("hev1")) || (str2.startsWith("dvh1") && str.startsWith("hvc1")) || ((str2.startsWith("dvav") && str.startsWith("avc3")) || ((str2.startsWith("dva1") && str.startsWith("avc1")) || (str2.startsWith("dav1") && str.startsWith("av01"))));
    }

    public static boolean q(String str) {
        return "image".equals(j(str)) || "application/x-image-uri".equals(str);
    }

    public static boolean r(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm") || str.startsWith("video/x-matroska") || str.startsWith("audio/x-matroska") || str.startsWith("application/x-matroska");
    }

    public static boolean s(String str) {
        return "text".equals(j(str)) || "application/x-media3-cues".equals(str) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str);
    }

    public static boolean t(String str) {
        return MediaStreamTrack.VIDEO_TRACK_KIND.equals(j(str));
    }

    public static String u(String str) {
        String strF;
        if (str == null) {
            return null;
        }
        strF = AbstractC1228c.f(str);
        strF.getClass();
        switch (strF) {
            case "video/x-mvhevc":
                return "video/mv-hevc";
            case "audio/x-flac":
                return "audio/flac";
            case "application/x-mpegurl":
                return "application/x-mpegURL";
            case "audio/x-wav":
                return "audio/wav";
            case "audio/mpeg-l1":
                return "audio/mpeg-L1";
            case "audio/mpeg-l2":
                return "audio/mpeg-L2";
            case "audio/mp3":
                return "audio/mpeg";
            default:
                return strF;
        }
    }
}
