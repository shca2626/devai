package org.webrtc;

import java.util.List;
import java.util.Map;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes3.dex */
public class RtpCapabilities {
    public List<CodecCapability> codecs;
    public List<HeaderExtensionCapability> headerExtensions;

    public static class CodecCapability {
        public Integer clockRate;
        public MediaStreamTrack.MediaType kind;
        public String mimeType;
        public String name;
        public Integer numChannels;
        public Map<String, String> parameters;
        public int preferredPayloadType;

        public CodecCapability() {
        }

        @CalledByNative
        public Integer getClockRate() {
            return this.clockRate;
        }

        @CalledByNative
        public MediaStreamTrack.MediaType getKind() {
            return this.kind;
        }

        @CalledByNative
        public String getName() {
            return this.name;
        }

        @CalledByNative
        public Integer getNumChannels() {
            return this.numChannels;
        }

        @CalledByNative
        public Map<String, String> getParameters() {
            return this.parameters;
        }

        @CalledByNative
        public int getPreferredPayloadType() {
            return this.preferredPayloadType;
        }

        @CalledByNative
        public CodecCapability(int i7, String str, MediaStreamTrack.MediaType mediaType, Integer num, Integer num2, String str2, Map<String, String> map) {
            this.preferredPayloadType = i7;
            this.name = str;
            this.kind = mediaType;
            this.clockRate = num;
            this.numChannels = num2;
            this.parameters = map;
            this.mimeType = str2;
        }
    }

    public static class HeaderExtensionCapability {
        private final boolean preferredEncrypted;
        private final int preferredId;
        private final String uri;

        @CalledByNative
        public HeaderExtensionCapability(String str, int i7, boolean z7) {
            this.uri = str;
            this.preferredId = i7;
            this.preferredEncrypted = z7;
        }

        @CalledByNative
        public boolean getPreferredEncrypted() {
            return this.preferredEncrypted;
        }

        @CalledByNative
        public int getPreferredId() {
            return this.preferredId;
        }

        @CalledByNative
        public String getUri() {
            return this.uri;
        }
    }

    @CalledByNative
    public RtpCapabilities(List<CodecCapability> list, List<HeaderExtensionCapability> list2) {
        this.headerExtensions = list2;
        this.codecs = list;
    }

    @CalledByNative
    public List<CodecCapability> getCodecs() {
        return this.codecs;
    }

    @CalledByNative
    public List<HeaderExtensionCapability> getHeaderExtensions() {
        return this.headerExtensions;
    }
}
