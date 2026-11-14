package u4;

import M5.m;
import V5.w;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import v4.EnumC1683a;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f22888a = new d();

    public final String a(String str) {
        if (m.a(str, EnumC1683a.f23011n.e()) || m.a(str, EnumC1683a.f23012o.e()) || m.a(str, EnumC1683a.f23013p.e())) {
            return "audio/mp4a-latm";
        }
        if (m.a(str, EnumC1683a.f23014q.e())) {
            return "audio/3gpp";
        }
        if (m.a(str, EnumC1683a.f23015r.e())) {
            return "audio/amr-wb";
        }
        if (m.a(str, EnumC1683a.f23019v.e()) || m.a(str, EnumC1683a.f23017t.e())) {
            return "audio/raw";
        }
        if (m.a(str, EnumC1683a.f23018u.e())) {
            return "audio/opus";
        }
        if (m.a(str, EnumC1683a.f23016s.e())) {
            return "audio/flac";
        }
        return null;
    }

    public final boolean b(String str) {
        if (str == null) {
            return false;
        }
        if (m.a(str, "audio/raw")) {
            return true;
        }
        MediaCodecInfo[] codecInfos = new MediaCodecList(0).getCodecInfos();
        m.d(codecInfos, "getCodecInfos(...)");
        for (MediaCodecInfo mediaCodecInfo : codecInfos) {
            if (mediaCodecInfo.isEncoder()) {
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                m.d(supportedTypes, "getSupportedTypes(...)");
                for (String str2 : supportedTypes) {
                    if (w.t(str2, str, true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
