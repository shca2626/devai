package R0;

import B0.C0309j;
import E0.AbstractC0323h;
import E0.AbstractC0333s;
import I0.C0366f;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import java.util.Objects;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final String f7859a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7860b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7861c;

    /* renamed from: d, reason: collision with root package name */
    public final MediaCodecInfo.CodecCapabilities f7862d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f7863e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f7864f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f7865g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f7866h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f7867i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f7868j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f7869k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f7870l;

    /* renamed from: o, reason: collision with root package name */
    public float f7873o = -3.4028235E38f;

    /* renamed from: m, reason: collision with root package name */
    public int f7871m = -1;

    /* renamed from: n, reason: collision with root package name */
    public int f7872n = -1;

    public x(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f7859a = (String) j3.o.q(str);
        this.f7860b = str2;
        this.f7861c = str3;
        this.f7862d = codecCapabilities;
        this.f7866h = z7;
        this.f7867i = z8;
        this.f7868j = z9;
        this.f7863e = z10;
        this.f7864f = z11;
        this.f7865g = z12;
        this.f7869k = z13;
        this.f7870l = B0.z.t(str2);
    }

    public static boolean A(String str) {
        return Build.MODEL.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    public static boolean B() {
        String str = Build.MANUFACTURER;
        return str.equals("Xiaomi") || str.equals("OPPO") || str.equals("realme") || str.equals("motorola") || str.equals("LENOVO");
    }

    public static boolean C(String str, int i7) {
        if (!"video/hevc".equals(str) || 2 != i7) {
            return false;
        }
        String str2 = Build.DEVICE;
        return "sailfish".equals(str2) || "marlin".equals(str2);
    }

    public static boolean D(String str) {
        return ("OMX.MTK.VIDEO.DECODER.HEVC".equals(str) && "mcv5a".equals(Build.DEVICE)) ? false : true;
    }

    public static x E(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11) {
        return new x(str, str2, str3, codecCapabilities, z7, z8, z9, (z10 || codecCapabilities == null || !j(codecCapabilities)) ? false : true, codecCapabilities != null && v(codecCapabilities), z11 || (codecCapabilities != null && u(codecCapabilities)), o(codecCapabilities));
    }

    public static int a(String str, String str2, int i7) {
        if (i7 > 1 || ((Build.VERSION.SDK_INT >= 26 && i7 > 0) || "audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2))) {
            return i7;
        }
        int i8 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
        AbstractC0333s.h("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + i7 + " to " + i8 + "]");
        return i8;
    }

    public static Point b(MediaCodecInfo.VideoCapabilities videoCapabilities, int i7, int i8) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(E0.U.k(i7, widthAlignment) * widthAlignment, E0.U.k(i8, heightAlignment) * heightAlignment);
    }

    public static boolean d(MediaCodecInfo.VideoCapabilities videoCapabilities, int i7, int i8, double d7) {
        Point pointB = b(videoCapabilities, i7, i8);
        int i9 = pointB.x;
        int i10 = pointB.y;
        if (d7 == -1.0d || d7 < 1.0d) {
            return videoCapabilities.isSizeSupported(i9, i10);
        }
        double dFloor = Math.floor(d7);
        if (!videoCapabilities.areSizeAndRateSupported(i9, i10, dFloor)) {
            return false;
        }
        Range<Double> achievableFrameRatesFor = videoCapabilities.getAchievableFrameRatesFor(i9, i10);
        return achievableFrameRatesFor == null || dFloor <= ((Double) achievableFrameRatesFor.getUpper()).doubleValue();
    }

    public static MediaCodecInfo.CodecProfileLevel[] g(Context context, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        MediaCodecInfo.AudioCapabilities audioCapabilities;
        int i7 = ((codecCapabilities == null || (audioCapabilities = codecCapabilities.getAudioCapabilities()) == null) ? 2 : audioCapabilities.getMaxInputChannelCount()) > 18 ? 16 : 8;
        return E0.U.B0(context) ? new MediaCodecInfo.CodecProfileLevel[]{T.f(1026, i7)} : new MediaCodecInfo.CodecProfileLevel[]{T.f(257, i7), T.f(513, i7), T.f(514, i7), T.f(1026, i7), T.f(1028, i7)};
    }

    public static boolean j(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    public static boolean o(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Build.VERSION.SDK_INT >= 35 && codecCapabilities != null && codecCapabilities.isFeatureSupported("detached-surface") && !B();
    }

    public static boolean u(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    public static boolean v(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    public static boolean z(String str) {
        return "audio/opus".equals(str);
    }

    public Point c(int i7, int i8) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f7862d;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return b(videoCapabilities, i7, i8);
    }

    public C0366f e(B0.s sVar, B0.s sVar2) {
        B0.s sVar3;
        B0.s sVar4;
        int i7;
        int i8 = !Objects.equals(sVar.f759o, sVar2.f759o) ? 8 : 0;
        if (this.f7870l) {
            if (sVar.f728A != sVar2.f728A) {
                i8 |= 1024;
            }
            boolean z7 = (sVar.f766v == sVar2.f766v && sVar.f767w == sVar2.f767w) ? false : true;
            if (!this.f7863e && z7) {
                i8 |= 512;
            }
            if ((!C0309j.h(sVar.f732E) || !C0309j.h(sVar2.f732E)) && !Objects.equals(sVar.f732E, sVar2.f732E)) {
                i8 |= 2048;
            }
            if (A(this.f7859a) && !sVar.f(sVar2)) {
                i8 |= 2;
            }
            int i9 = sVar.f768x;
            if (i9 != -1 && (i7 = sVar.f769y) != -1 && i9 == sVar2.f768x && i7 == sVar2.f769y && z7) {
                i8 |= 2;
            }
            if (i8 == 0 && Objects.equals(sVar2.f759o, "video/dolby-vision")) {
                Pair pairU = AbstractC0323h.u(sVar);
                Pair pairU2 = AbstractC0323h.u(sVar2);
                if (pairU == null || pairU2 == null || !((Integer) pairU.first).equals(pairU2.first)) {
                    i8 |= 2;
                }
            }
            if (i8 == 0) {
                return new C0366f(this.f7859a, sVar, sVar2, sVar.f(sVar2) ? 3 : 2, 0);
            }
            sVar3 = sVar;
            sVar4 = sVar2;
        } else {
            sVar3 = sVar;
            sVar4 = sVar2;
            if (sVar3.f734G != sVar4.f734G) {
                i8 |= 4096;
            }
            if (sVar3.f735H != sVar4.f735H) {
                i8 |= 8192;
            }
            if (sVar3.f736I != sVar4.f736I) {
                i8 |= 16384;
            }
            if (i8 == 0 && (this.f7860b.equals("audio/mp4a-latm") || this.f7860b.equals("audio/ac4"))) {
                Pair pairU3 = AbstractC0323h.u(sVar3);
                Pair pairU4 = AbstractC0323h.u(sVar4);
                if (pairU3 != null && pairU4 != null) {
                    int iIntValue = ((Integer) pairU3.first).intValue();
                    int iIntValue2 = ((Integer) pairU4.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new C0366f(this.f7859a, sVar3, sVar4, 3, 0);
                    }
                    if (this.f7860b.equals("audio/ac4") && pairU3.equals(pairU4)) {
                        return new C0366f(this.f7859a, sVar3, sVar4, 3, 0);
                    }
                }
            }
            if (i8 == 0 && (this.f7860b.equals("audio/eac3-joc") || this.f7860b.equals("audio/eac3"))) {
                return new C0366f(this.f7859a, sVar3, sVar4, 3, 0);
            }
            if (!sVar3.f(sVar4)) {
                i8 |= 32;
            }
            if (z(this.f7860b)) {
                i8 |= 2;
            }
            if (i8 == 0) {
                return new C0366f(this.f7859a, sVar3, sVar4, 1, 0);
            }
        }
        return new C0366f(this.f7859a, sVar3, sVar4, 0, i8);
    }

    public final float f(int i7, int i8) {
        float f7 = 1024.0f;
        if (w(i7, i8, 1024.0f)) {
            return 1024.0f;
        }
        float f8 = 0.0f;
        while (true) {
            float f9 = f7 - f8;
            if (Math.abs(f9) <= 5.0f) {
                return f8;
            }
            float f10 = (f9 / 2.0f) + f8;
            if (w(i7, i8, f10)) {
                f8 = f10;
            } else {
                f7 = f10;
            }
        }
    }

    public float h(int i7, int i8) {
        if (!this.f7870l) {
            return -3.4028235E38f;
        }
        float f7 = this.f7873o;
        if (f7 != -3.4028235E38f && this.f7871m == i7 && this.f7872n == i8) {
            return f7;
        }
        float f8 = f(i7, i8);
        this.f7873o = f8;
        this.f7871m = i7;
        this.f7872n = i8;
        return f8;
    }

    public MediaCodecInfo.CodecProfileLevel[] i() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f7862d;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    public boolean k(int i7) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f7862d;
        if (codecCapabilities == null) {
            y("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            y("channelCount.aCaps");
            return false;
        }
        if (a(this.f7859a, this.f7860b, audioCapabilities.getMaxInputChannelCount()) >= i7) {
            return true;
        }
        y("channelCount.support, " + i7);
        return false;
    }

    public boolean l(int i7) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f7862d;
        if (codecCapabilities == null) {
            y("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            y("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i7)) {
            return true;
        }
        y("sampleRate.support, " + i7);
        return false;
    }

    public final boolean m(Context context, B0.s sVar, boolean z7) {
        Pair pairU = AbstractC0323h.u(sVar);
        String str = sVar.f759o;
        if (str != null && str.equals("video/mv-hevc")) {
            String strU = B0.z.u(this.f7861c);
            if (strU.equals("video/mv-hevc")) {
                return true;
            }
            if (strU.equals("video/hevc")) {
                pairU = T.q(sVar);
            }
        }
        if (pairU == null) {
            return true;
        }
        int iIntValue = ((Integer) pairU.first).intValue();
        int iIntValue2 = ((Integer) pairU.second).intValue();
        if ("video/dolby-vision".equals(sVar.f759o)) {
            String str2 = this.f7860b;
            str2.getClass();
            switch (str2) {
                case "video/av01":
                case "video/hevc":
                    iIntValue2 = 0;
                    iIntValue = 2;
                    break;
                case "video/avc":
                    iIntValue = 8;
                    iIntValue2 = 0;
                    break;
            }
        }
        if (!this.f7870l && !this.f7860b.equals("audio/ac4") && iIntValue != 42) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrI = i();
        if (this.f7860b.equals("audio/ac4") && codecProfileLevelArrI.length == 0) {
            codecProfileLevelArrI = g(context, this.f7862d);
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArrI) {
            if (codecProfileLevel.profile == iIntValue && ((codecProfileLevel.level >= iIntValue2 || !z7) && !C(this.f7860b, iIntValue))) {
                return true;
            }
        }
        y("codec.profileLevel, " + sVar.f755k + ", " + this.f7861c);
        return false;
    }

    public final boolean n(B0.s sVar) {
        return (Objects.equals(sVar.f759o, "audio/flac") && sVar.f736I == 22 && Build.VERSION.SDK_INT < 34 && this.f7859a.equals("c2.android.flac.decoder")) ? false : true;
    }

    public boolean p(Context context, B0.s sVar) {
        return s(sVar) && m(context, sVar, false) && n(sVar);
    }

    public boolean q(Context context, B0.s sVar) {
        int i7;
        int i8;
        if (!s(sVar) || !m(context, sVar, true) || !n(sVar)) {
            return false;
        }
        if (!this.f7870l) {
            int i9 = sVar.f735H;
            return (i9 == -1 || l(i9)) && ((i7 = sVar.f734G) == -1 || k(i7));
        }
        int i10 = sVar.f766v;
        if (i10 <= 0 || (i8 = sVar.f767w) <= 0) {
            return true;
        }
        return w(i10, i8, sVar.f770z);
    }

    public boolean r() {
        if (Build.VERSION.SDK_INT >= 29 && "video/x-vnd.on2.vp9".equals(this.f7860b)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : i()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean s(B0.s sVar) {
        return this.f7860b.equals(sVar.f759o) || this.f7860b.equals(T.g(sVar));
    }

    public boolean t(B0.s sVar) {
        if (this.f7870l) {
            return this.f7863e;
        }
        Pair pairU = AbstractC0323h.u(sVar);
        return pairU != null && ((Integer) pairU.first).intValue() == 42;
    }

    public String toString() {
        return this.f7859a;
    }

    public boolean w(int i7, int i8, double d7) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f7862d;
        if (codecCapabilities == null) {
            y("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            y("sizeAndRate.vCaps");
            return false;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            int iC = D.c(videoCapabilities, i7, i8, d7);
            if (iC == 2) {
                return true;
            }
            if (iC == 1) {
                y("sizeAndRate.cover, " + i7 + "x" + i8 + "@" + d7);
                return false;
            }
        }
        if (!d(videoCapabilities, i7, i8, d7)) {
            if (i7 >= i8 || !D(this.f7859a) || !d(videoCapabilities, i8, i7, d7)) {
                y("sizeAndRate.support, " + i7 + "x" + i8 + "@" + d7);
                return false;
            }
            x("sizeAndRate.rotated, " + i7 + "x" + i8 + "@" + d7);
        }
        return true;
    }

    public final void x(String str) {
        AbstractC0333s.b("MediaCodecInfo", "AssumedSupport [" + str + "] [" + this.f7859a + ", " + this.f7860b + "] [" + E0.U.f2097e + "]");
    }

    public final void y(String str) {
        AbstractC0333s.b("MediaCodecInfo", "NoSupport [" + str + "] [" + this.f7859a + ", " + this.f7860b + "] [" + E0.U.f2097e + "]");
    }
}
