package org.webrtc;

import java.util.List;
import java.util.Map;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes3.dex */
public class RtpParameters {
    public final List<Codec> codecs;
    public DegradationPreference degradationPreference;
    public final List<Encoding> encodings;
    private final List<HeaderExtension> headerExtensions;
    private final Rtcp rtcp;
    public final String transactionId;

    public static class Codec {
        public Integer clockRate;
        MediaStreamTrack.MediaType kind;
        public String name;
        public Integer numChannels;
        public Map<String, String> parameters;
        public int payloadType;

        @CalledByNative
        public Codec(int i7, String str, MediaStreamTrack.MediaType mediaType, Integer num, Integer num2, Map<String, String> map) {
            this.payloadType = i7;
            this.name = str;
            this.kind = mediaType;
            this.clockRate = num;
            this.numChannels = num2;
            this.parameters = map;
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
        public int getPayloadType() {
            return this.payloadType;
        }
    }

    public enum DegradationPreference {
        MAINTAIN_FRAMERATE_AND_RESOLUTION,
        MAINTAIN_FRAMERATE,
        MAINTAIN_RESOLUTION,
        BALANCED,
        DISABLED;

        @CalledByNative
        public static DegradationPreference fromNativeIndex(int i7) {
            return values()[i7];
        }
    }

    public static class HeaderExtension {
        private final boolean encrypted;
        private final int id;
        private final String uri;

        @CalledByNative
        public HeaderExtension(String str, int i7, boolean z7) {
            this.uri = str;
            this.id = i7;
            this.encrypted = z7;
        }

        @CalledByNative
        public boolean getEncrypted() {
            return this.encrypted;
        }

        @CalledByNative
        public int getId() {
            return this.id;
        }

        @CalledByNative
        public String getUri() {
            return this.uri;
        }
    }

    public static class Rtcp {
        private final String cname;
        private final boolean reducedSize;

        @CalledByNative
        public Rtcp(String str, boolean z7) {
            this.cname = str;
            this.reducedSize = z7;
        }

        @CalledByNative
        public String getCname() {
            return this.cname;
        }

        @CalledByNative
        public boolean getReducedSize() {
            return this.reducedSize;
        }
    }

    @CalledByNative
    public RtpParameters(String str, DegradationPreference degradationPreference, Rtcp rtcp, List<HeaderExtension> list, List<Encoding> list2, List<Codec> list3) {
        this.transactionId = str;
        this.degradationPreference = degradationPreference;
        this.rtcp = rtcp;
        this.headerExtensions = list;
        this.encodings = list2;
        this.codecs = list3;
    }

    @CalledByNative
    public List<Codec> getCodecs() {
        return this.codecs;
    }

    @CalledByNative
    public DegradationPreference getDegradationPreference() {
        return this.degradationPreference;
    }

    @CalledByNative
    public List<Encoding> getEncodings() {
        return this.encodings;
    }

    @CalledByNative
    public List<HeaderExtension> getHeaderExtensions() {
        return this.headerExtensions;
    }

    @CalledByNative
    public Rtcp getRtcp() {
        return this.rtcp;
    }

    @CalledByNative
    public String getTransactionId() {
        return this.transactionId;
    }

    public static class Encoding {
        public boolean active;
        public boolean adaptiveAudioPacketTime;
        public double bitratePriority;
        public Integer maxBitrateBps;
        public Integer maxFramerate;
        public Integer minBitrateBps;
        public int networkPriority;
        public Integer numTemporalLayers;
        public String rid;
        public String scalabilityMode;
        public Double scaleResolutionDownBy;
        public Long ssrc;

        public Encoding(String str, boolean z7, Double d7) {
            this.bitratePriority = 1.0d;
            this.networkPriority = 1;
            this.rid = str;
            this.active = z7;
            this.scaleResolutionDownBy = d7;
        }

        @CalledByNative
        public boolean getActive() {
            return this.active;
        }

        @CalledByNative
        public boolean getAdaptivePTime() {
            return this.adaptiveAudioPacketTime;
        }

        @CalledByNative
        public double getBitratePriority() {
            return this.bitratePriority;
        }

        @CalledByNative
        public Integer getMaxBitrateBps() {
            return this.maxBitrateBps;
        }

        @CalledByNative
        public Integer getMaxFramerate() {
            return this.maxFramerate;
        }

        @CalledByNative
        public Integer getMinBitrateBps() {
            return this.minBitrateBps;
        }

        @CalledByNative
        public int getNetworkPriority() {
            return this.networkPriority;
        }

        @CalledByNative
        public Integer getNumTemporalLayers() {
            return this.numTemporalLayers;
        }

        @CalledByNative
        public String getRid() {
            return this.rid;
        }

        @CalledByNative
        public String getScalabilityMode() {
            return this.scalabilityMode;
        }

        @CalledByNative
        public Double getScaleResolutionDownBy() {
            return this.scaleResolutionDownBy;
        }

        @CalledByNative
        public Long getSsrc() {
            return this.ssrc;
        }

        @CalledByNative
        public Encoding(String str, boolean z7, double d7, int i7, Integer num, Integer num2, Integer num3, Integer num4, Double d8, String str2, Long l7, boolean z8) {
            this.rid = str;
            this.active = z7;
            this.bitratePriority = d7;
            this.networkPriority = i7;
            this.maxBitrateBps = num;
            this.minBitrateBps = num2;
            this.maxFramerate = num3;
            this.numTemporalLayers = num4;
            this.scaleResolutionDownBy = d8;
            this.scalabilityMode = str2;
            this.ssrc = l7;
            this.adaptiveAudioPacketTime = z8;
        }
    }
}
