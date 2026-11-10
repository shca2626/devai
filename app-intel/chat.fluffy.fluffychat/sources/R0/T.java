package R0;

import E0.AbstractC0322h;
import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import j3.AbstractC1229c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import k3.AbstractC1279v;

/* loaded from: classes.dex */
public abstract class T {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f7778a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static int f7779b = -1;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f7780a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f7781b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f7782c;

        public b(String str, boolean z7, boolean z8) {
            this.f7780a = str;
            this.f7781b = z7;
            this.f7782c = z8;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == b.class) {
                b bVar = (b) obj;
                if (TextUtils.equals(this.f7780a, bVar.f7780a) && this.f7781b == bVar.f7781b && this.f7782c == bVar.f7782c) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((this.f7780a.hashCode() + 31) * 31) + (this.f7781b ? 1231 : 1237)) * 31) + (this.f7782c ? 1231 : 1237);
        }
    }

    public static class c extends Exception {
        public c(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    public interface d {
        MediaCodecInfo a(int i7);

        boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        int d();

        boolean e();
    }

    public static final class e implements d {

        /* renamed from: a, reason: collision with root package name */
        public final int f7783a;

        /* renamed from: b, reason: collision with root package name */
        public MediaCodecInfo[] f7784b;

        public e(boolean z7, boolean z8, boolean z9) {
            this.f7783a = (z7 || z8 || z9) ? 1 : 0;
        }

        @Override // R0.T.d
        public MediaCodecInfo a(int i7) {
            f();
            return this.f7784b[i7];
        }

        @Override // R0.T.d
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        @Override // R0.T.d
        public boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        @Override // R0.T.d
        public int d() {
            f();
            return this.f7784b.length;
        }

        @Override // R0.T.d
        public boolean e() {
            return true;
        }

        public final void f() {
            if (this.f7784b == null) {
                this.f7784b = new MediaCodecList(this.f7783a).getCodecInfos();
            }
        }
    }

    public interface f {
        int a(Object obj);
    }

    public static void A(List list, final f fVar) {
        Collections.sort(list, new Comparator() { // from class: R0.S
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return T.a(fVar, obj, obj2);
            }
        });
    }

    public static /* synthetic */ int a(f fVar, Object obj, Object obj2) {
        return fVar.a(obj2) - fVar.a(obj);
    }

    public static /* synthetic */ int b(x xVar) {
        return (xVar.f7867i ? 2 : 0) + (!xVar.f7868j ? 1 : 0);
    }

    public static /* synthetic */ int c(Context context, B0.s sVar, x xVar) {
        return xVar.p(context, sVar) ? 1 : 0;
    }

    public static /* synthetic */ int d(x xVar) {
        String str = xVar.f7859a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (Build.VERSION.SDK_INT >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }

    public static void e(String str, List list) {
        if ("audio/raw".equals(str)) {
            if (Build.VERSION.SDK_INT < 26 && Build.DEVICE.equals("R9") && list.size() == 1 && ((x) list.get(0)).f7859a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(x.E("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
            }
            A(list, new f() { // from class: R0.P
                @Override // R0.T.f
                public final int a(Object obj) {
                    return T.d((x) obj);
                }
            });
        }
        if (Build.VERSION.SDK_INT >= 32 || list.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(((x) list.get(0)).f7859a)) {
            return;
        }
        list.add((x) list.remove(0));
    }

    public static MediaCodecInfo.CodecProfileLevel f(int i7, int i8) {
        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = i7;
        codecProfileLevel.level = i8;
        return codecProfileLevel;
    }

    public static String g(B0.s sVar) {
        Pair pairU;
        if ("audio/eac3-joc".equals(sVar.f759o)) {
            return "audio/eac3";
        }
        if ("video/dolby-vision".equals(sVar.f759o) && (pairU = AbstractC0322h.u(sVar)) != null) {
            int iIntValue = ((Integer) pairU.first).intValue();
            if (iIntValue == 16 || iIntValue == 256) {
                return "video/hevc";
            }
            if (iIntValue == 512) {
                return "video/avc";
            }
            if (iIntValue == 1024) {
                return "video/av01";
            }
        }
        if ("video/mv-hevc".equals(sVar.f759o)) {
            return "video/hevc";
        }
        return null;
    }

    public static List h(J j7, B0.s sVar, boolean z7, boolean z8) {
        String strG = g(sVar);
        return strG == null ? AbstractC1279v.v() : j7.b(strG, z7, z8);
    }

    public static String i(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals("video/mv-hevc")) {
            if ("c2.qti.mvhevc.decoder".equals(str) || "c2.qti.mvhevc.decoder.secure".equals(str)) {
                return "video/x-mvhevc";
            }
            return null;
        }
        if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals("audio/flac") && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        if (str2.equals("audio/ac3") && "OMX.lge.ac3.decoder".equals(str)) {
            return "audio/lg-ac3";
        }
        return null;
    }

    public static x j(String str, boolean z7, boolean z8) {
        List listK = k(str, z7, z8);
        if (listK.isEmpty()) {
            return null;
        }
        return (x) listK.get(0);
    }

    public static synchronized List k(String str, boolean z7, boolean z8) {
        try {
            b bVar = new b(str, z7, z8);
            HashMap map = f7778a;
            List list = (List) map.get(bVar);
            if (list != null) {
                return list;
            }
            ArrayList arrayListL = l(bVar, new e(z7, z8, str.equals("video/mv-hevc")));
            if (z7) {
                arrayListL.isEmpty();
            }
            e(str, arrayListL);
            AbstractC1279v abstractC1279vR = AbstractC1279v.r(arrayListL);
            map.put(bVar, abstractC1279vR);
            return abstractC1279vR;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList l(R0.T.b r16, R0.T.d r17) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: R0.T.l(R0.T$b, R0.T$d):java.util.ArrayList");
    }

    public static List m(J j7, B0.s sVar, boolean z7, boolean z8) {
        List listB = j7.b(sVar.f759o, z7, z8);
        return AbstractC1279v.o().j(listB).j(h(j7, sVar, z7, z8)).k();
    }

    public static List n(final Context context, List list, final B0.s sVar) {
        ArrayList arrayList = new ArrayList(list);
        A(arrayList, new f() { // from class: R0.O
            @Override // R0.T.f
            public final int a(Object obj) {
                return T.c(context, sVar, (x) obj);
            }
        });
        return arrayList;
    }

    public static List o(List list) {
        ArrayList arrayList = new ArrayList(list);
        A(arrayList, new f() { // from class: R0.Q
            @Override // R0.T.f
            public final int a(Object obj) {
                return T.b((x) obj);
            }
        });
        return AbstractC1279v.r(arrayList);
    }

    public static x p() {
        return j("audio/raw", false, false);
    }

    public static Pair q(B0.s sVar) {
        String strH = F0.h.h(sVar.f762r);
        if (strH == null) {
            return null;
        }
        return AbstractC0322h.x(strH, E0.U.k1(strH.trim(), "\\."), sVar.f732E);
    }

    public static boolean r(MediaCodecInfo mediaCodecInfo) {
        return Build.VERSION.SDK_INT >= 29 && s(mediaCodecInfo);
    }

    public static boolean s(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }

    public static boolean t(MediaCodecInfo mediaCodecInfo, String str, boolean z7, String str2) {
        if (mediaCodecInfo.isEncoder()) {
            return false;
        }
        return z7 || !str.endsWith(".secure");
    }

    public static boolean u(MediaCodecInfo mediaCodecInfo, String str) {
        return Build.VERSION.SDK_INT >= 29 ? v(mediaCodecInfo) : !w(mediaCodecInfo, str);
    }

    public static boolean v(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    public static boolean w(MediaCodecInfo mediaCodecInfo, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            return x(mediaCodecInfo);
        }
        if (B0.z.o(str)) {
            return true;
        }
        String strF = AbstractC1229c.f(mediaCodecInfo.getName());
        if (strF.startsWith("arc.")) {
            return false;
        }
        return strF.startsWith("omx.google.") || strF.startsWith("omx.ffmpeg.") || (strF.startsWith("omx.sec.") && strF.contains(".sw.")) || strF.equals("omx.qcom.video.decoder.hevcswvdec") || strF.startsWith("c2.android.") || strF.startsWith("c2.google.") || !(strF.startsWith("omx.") || strF.startsWith("c2."));
    }

    public static boolean x(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    public static boolean y(MediaCodecInfo mediaCodecInfo) {
        if (Build.VERSION.SDK_INT >= 29) {
            return z(mediaCodecInfo);
        }
        String strF = AbstractC1229c.f(mediaCodecInfo.getName());
        return (strF.startsWith("omx.google.") || strF.startsWith("c2.android.") || strF.startsWith("c2.google.")) ? false : true;
    }

    public static boolean z(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }
}
