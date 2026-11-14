package org.webrtc;

/* loaded from: classes3.dex */
public final class CryptoOptions {
    private final SFrame sframe;
    private final Srtp srtp;

    public static class Builder {
        private boolean enableAes128Sha1_32CryptoCipher;
        private boolean enableAes128Sha1_80CryptoCipher;
        private boolean enableEncryptedRtpHeaderExtensions;
        private boolean enableGcmCryptoSuites;
        private boolean requireFrameEncryption;

        public CryptoOptions createCryptoOptions() {
            boolean z7 = this.enableGcmCryptoSuites;
            if (z7 || this.enableAes128Sha1_32CryptoCipher || this.enableAes128Sha1_80CryptoCipher) {
                return new CryptoOptions(z7, this.enableAes128Sha1_32CryptoCipher, this.enableAes128Sha1_80CryptoCipher, this.enableEncryptedRtpHeaderExtensions, this.requireFrameEncryption);
            }
            throw new IllegalStateException("CryptoOptions: no SRTP crypto suite enabled");
        }

        public Builder setEnableAes128Sha1_32CryptoCipher(boolean z7) {
            this.enableAes128Sha1_32CryptoCipher = z7;
            return this;
        }

        public Builder setEnableAes128Sha1_80CryptoCipher(boolean z7) {
            this.enableAes128Sha1_80CryptoCipher = z7;
            return this;
        }

        public Builder setEnableEncryptedRtpHeaderExtensions(boolean z7) {
            this.enableEncryptedRtpHeaderExtensions = z7;
            return this;
        }

        public Builder setEnableGcmCryptoSuites(boolean z7) {
            this.enableGcmCryptoSuites = z7;
            return this;
        }

        public Builder setRequireFrameEncryption(boolean z7) {
            this.requireFrameEncryption = z7;
            return this;
        }

        private Builder() {
            this.enableAes128Sha1_80CryptoCipher = true;
        }
    }

    public final class SFrame {
        private final boolean requireFrameEncryption;

        @CalledByNative
        public boolean getRequireFrameEncryption() {
            return this.requireFrameEncryption;
        }

        private SFrame(CryptoOptions cryptoOptions, boolean z7) {
            this.requireFrameEncryption = z7;
        }
    }

    public final class Srtp {
        private final boolean enableAes128Sha1_32CryptoCipher;
        private final boolean enableAes128Sha1_80CryptoCipher;
        private final boolean enableEncryptedRtpHeaderExtensions;
        private final boolean enableGcmCryptoSuites;

        @CalledByNative
        public boolean getEnableAes128Sha1_32CryptoCipher() {
            return this.enableAes128Sha1_32CryptoCipher;
        }

        @CalledByNative
        public boolean getEnableAes128Sha1_80CryptoCipher() {
            return this.enableAes128Sha1_80CryptoCipher;
        }

        @CalledByNative
        public boolean getEnableEncryptedRtpHeaderExtensions() {
            return this.enableEncryptedRtpHeaderExtensions;
        }

        @CalledByNative
        public boolean getEnableGcmCryptoSuites() {
            return this.enableGcmCryptoSuites;
        }

        private Srtp(CryptoOptions cryptoOptions, boolean z7, boolean z8, boolean z9, boolean z10) {
            this.enableGcmCryptoSuites = z7;
            this.enableAes128Sha1_32CryptoCipher = z8;
            this.enableAes128Sha1_80CryptoCipher = z9;
            this.enableEncryptedRtpHeaderExtensions = z10;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @CalledByNative
    public SFrame getSFrame() {
        return this.sframe;
    }

    @CalledByNative
    public Srtp getSrtp() {
        return this.srtp;
    }

    private CryptoOptions(boolean z7, boolean z8, boolean z9, boolean z10, boolean z11) {
        this.srtp = new Srtp(z7, z8, z9, z10);
        this.sframe = new SFrame(z11);
    }
}
