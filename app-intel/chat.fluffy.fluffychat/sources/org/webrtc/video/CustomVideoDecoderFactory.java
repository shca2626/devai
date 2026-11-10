package org.webrtc.video;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.webrtc.EglBase;
import org.webrtc.SoftwareVideoDecoderFactory;
import org.webrtc.VideoCodecInfo;
import org.webrtc.VideoDecoder;
import org.webrtc.VideoDecoderFactory;
import org.webrtc.WrappedVideoDecoderFactory;

/* loaded from: classes3.dex */
public class CustomVideoDecoderFactory implements VideoDecoderFactory {
    private WrappedVideoDecoderFactory wrappedVideoDecoderFactory;
    private SoftwareVideoDecoderFactory softwareVideoDecoderFactory = new SoftwareVideoDecoderFactory();
    private boolean forceSWCodec = false;
    private List<String> forceSWCodecs = new ArrayList();

    public CustomVideoDecoderFactory(EglBase.Context context) {
        this.wrappedVideoDecoderFactory = new WrappedVideoDecoderFactory(context);
    }

    private VideoCodecInfo[] withHigherH264Level(VideoCodecInfo[] videoCodecInfoArr) {
        VideoCodecInfo[] videoCodecInfoArr2 = new VideoCodecInfo[videoCodecInfoArr.length];
        for (int i7 = 0; i7 < videoCodecInfoArr.length; i7++) {
            VideoCodecInfo videoCodecInfo = videoCodecInfoArr[i7];
            if ("H264".equalsIgnoreCase(videoCodecInfo.name)) {
                String str = videoCodecInfo.params.get("profile-level-id");
                if (str == null || str.length() != 6) {
                    videoCodecInfoArr2[i7] = videoCodecInfo;
                } else {
                    String strSubstring = str.substring(0, 4);
                    if (Integer.parseInt(str.substring(4), 16) >= 41) {
                        videoCodecInfoArr2[i7] = videoCodecInfo;
                    } else {
                        HashMap map = new HashMap(videoCodecInfo.params);
                        map.put("profile-level-id", strSubstring + "29");
                        videoCodecInfoArr2[i7] = new VideoCodecInfo(videoCodecInfo.name, map, videoCodecInfo.scalabilityModes);
                    }
                }
            } else {
                videoCodecInfoArr2[i7] = videoCodecInfo;
            }
        }
        return videoCodecInfoArr2;
    }

    @Override // org.webrtc.VideoDecoderFactory
    public VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo) {
        return this.forceSWCodec ? this.softwareVideoDecoderFactory.createDecoder(videoCodecInfo) : (this.forceSWCodecs.isEmpty() || !this.forceSWCodecs.contains(videoCodecInfo.name)) ? this.wrappedVideoDecoderFactory.createDecoder(videoCodecInfo) : this.softwareVideoDecoderFactory.createDecoder(videoCodecInfo);
    }

    @Override // org.webrtc.VideoDecoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        return withHigherH264Level((this.forceSWCodec && this.forceSWCodecs.isEmpty()) ? this.softwareVideoDecoderFactory.getSupportedCodecs() : this.wrappedVideoDecoderFactory.getSupportedCodecs());
    }

    public void setForceSWCodec(boolean z7) {
        this.forceSWCodec = z7;
    }

    public void setForceSWCodecList(List<String> list) {
        this.forceSWCodecs = list;
    }
}
