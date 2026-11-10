package org.webrtc.audio;

import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AudioEffect;
import android.media.audiofx.NoiseSuppressor;
import java.util.UUID;
import org.webrtc.Logging;

/* loaded from: classes3.dex */
class WebRtcAudioEffects {
    private static final UUID AOSP_ACOUSTIC_ECHO_CANCELER = UUID.fromString("bb392ec0-8d4d-11e0-a896-0002a5d5c51b");
    private static final UUID AOSP_NOISE_SUPPRESSOR = UUID.fromString("c06c8400-8e06-11e0-9cb6-0002a5d5c51b");
    private static final boolean DEBUG = false;
    private static final String TAG = "WebRtcAudioEffectsExternal";
    private static AudioEffect.Descriptor[] cachedEffects;
    private AcousticEchoCanceler aec;
    private NoiseSuppressor ns;
    private boolean shouldEnableAec;
    private boolean shouldEnableNs;

    public static final class State {
        final Boolean aecActive;
        final boolean isAecRequested;
        final boolean isNsRequested;
        final Boolean nsActive;

        public State(boolean z7, Boolean bool, boolean z8, Boolean bool2) {
            this.isAecRequested = z7;
            this.aecActive = bool;
            this.isNsRequested = z8;
            this.nsActive = bool2;
        }
    }

    public WebRtcAudioEffects() {
        Logging.d(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
    }

    private static void assertTrue(boolean z7) {
        if (!z7) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    private boolean effectTypeIsVoIP(UUID uuid) {
        if (AudioEffect.EFFECT_TYPE_AEC.equals(uuid) && isAcousticEchoCancelerSupported()) {
            return true;
        }
        if (AudioEffect.EFFECT_TYPE_NS.equals(uuid) && isNoiseSuppressorSupported()) {
            return true;
        }
        return DEBUG;
    }

    private static AudioEffect.Descriptor[] getAvailableEffects() {
        AudioEffect.Descriptor[] descriptorArr = cachedEffects;
        if (descriptorArr != null) {
            return descriptorArr;
        }
        AudioEffect.Descriptor[] descriptorArrQueryEffects = AudioEffect.queryEffects();
        cachedEffects = descriptorArrQueryEffects;
        return descriptorArrQueryEffects;
    }

    public static boolean isAcousticEchoCancelerSupported() {
        return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_AEC, AOSP_ACOUSTIC_ECHO_CANCELER);
    }

    private static boolean isEffectTypeAvailable(UUID uuid, UUID uuid2) {
        AudioEffect.Descriptor[] availableEffects = getAvailableEffects();
        if (availableEffects == null) {
            return DEBUG;
        }
        for (AudioEffect.Descriptor descriptor : availableEffects) {
            if (descriptor.type.equals(uuid)) {
                return !r4.uuid.equals(uuid2);
            }
        }
        return DEBUG;
    }

    public static boolean isNoiseSuppressorSupported() {
        return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_NS, AOSP_NOISE_SUPPRESSOR);
    }

    public synchronized void enable(int i7) {
        try {
            Logging.d(TAG, "enable(audioSession=" + i7 + ")");
            AcousticEchoCanceler acousticEchoCanceler = this.aec;
            boolean z7 = DEBUG;
            assertTrue(acousticEchoCanceler == null);
            assertTrue(this.ns == null);
            if (isAcousticEchoCancelerSupported()) {
                AcousticEchoCanceler acousticEchoCancelerCreate = AcousticEchoCanceler.create(i7);
                this.aec = acousticEchoCancelerCreate;
                if (acousticEchoCancelerCreate != null) {
                    boolean enabled = acousticEchoCancelerCreate.getEnabled();
                    boolean z8 = this.shouldEnableAec && isAcousticEchoCancelerSupported();
                    if (this.aec.setEnabled(z8) != 0) {
                        Logging.e(TAG, "Failed to set the AcousticEchoCanceler state");
                    }
                    Logging.d(TAG, "AcousticEchoCanceler: was " + (enabled ? "enabled" : "disabled") + ", enable: " + z8 + ", is now: " + (this.aec.getEnabled() ? "enabled" : "disabled"));
                } else {
                    Logging.e(TAG, "Failed to create the AcousticEchoCanceler instance");
                }
            }
            if (isNoiseSuppressorSupported()) {
                NoiseSuppressor noiseSuppressorCreate = NoiseSuppressor.create(i7);
                this.ns = noiseSuppressorCreate;
                if (noiseSuppressorCreate != null) {
                    boolean enabled2 = noiseSuppressorCreate.getEnabled();
                    if (this.shouldEnableNs && isNoiseSuppressorSupported()) {
                        z7 = true;
                    }
                    if (this.ns.setEnabled(z7) != 0) {
                        Logging.e(TAG, "Failed to set the NoiseSuppressor state");
                    }
                    Logging.d(TAG, "NoiseSuppressor: was " + (enabled2 ? "enabled" : "disabled") + ", enable: " + z7 + ", is now: " + (this.ns.getEnabled() ? "enabled" : "disabled"));
                } else {
                    Logging.e(TAG, "Failed to create the NoiseSuppressor instance");
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized State getState() {
        boolean z7;
        Boolean boolValueOf;
        Boolean boolValueOf2;
        boolean z8;
        z7 = this.shouldEnableAec;
        AcousticEchoCanceler acousticEchoCanceler = this.aec;
        boolValueOf = null;
        boolValueOf2 = acousticEchoCanceler == null ? null : Boolean.valueOf(acousticEchoCanceler.getEnabled());
        z8 = this.shouldEnableNs;
        NoiseSuppressor noiseSuppressor = this.ns;
        if (noiseSuppressor != null) {
            boolValueOf = Boolean.valueOf(noiseSuppressor.getEnabled());
        }
        return new State(z7, boolValueOf2, z8, boolValueOf);
    }

    public synchronized boolean hasAEC() {
        return this.aec != null ? true : DEBUG;
    }

    public synchronized boolean hasNS() {
        return this.ns != null ? true : DEBUG;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean isAECEnabled() {
        /*
            r1 = this;
            monitor-enter(r1)
            android.media.audiofx.AcousticEchoCanceler r0 = r1.aec     // Catch: java.lang.Throwable -> Ld
            if (r0 == 0) goto Lf
            boolean r0 = r0.getEnabled()     // Catch: java.lang.Throwable -> Ld
            if (r0 == 0) goto Lf
            r0 = 1
            goto L10
        Ld:
            r0 = move-exception
            goto L12
        Lf:
            r0 = 0
        L10:
            monitor-exit(r1)
            return r0
        L12:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Ld
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.webrtc.audio.WebRtcAudioEffects.isAECEnabled():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean isNSEnabled() {
        /*
            r1 = this;
            monitor-enter(r1)
            android.media.audiofx.NoiseSuppressor r0 = r1.ns     // Catch: java.lang.Throwable -> Ld
            if (r0 == 0) goto Lf
            boolean r0 = r0.getEnabled()     // Catch: java.lang.Throwable -> Ld
            if (r0 == 0) goto Lf
            r0 = 1
            goto L10
        Ld:
            r0 = move-exception
            goto L12
        Lf:
            r0 = 0
        L10:
            monitor-exit(r1)
            return r0
        L12:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Ld
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.webrtc.audio.WebRtcAudioEffects.isNSEnabled():boolean");
    }

    public synchronized void release() {
        try {
            Logging.d(TAG, "release");
            AcousticEchoCanceler acousticEchoCanceler = this.aec;
            if (acousticEchoCanceler != null) {
                acousticEchoCanceler.release();
                this.aec = null;
            }
            NoiseSuppressor noiseSuppressor = this.ns;
            if (noiseSuppressor != null) {
                noiseSuppressor.release();
                this.ns = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean setAEC(boolean z7) {
        Logging.d(TAG, "setAEC(" + z7 + ")");
        if (!isAcousticEchoCancelerSupported()) {
            Logging.w(TAG, "Platform AEC is not supported");
            this.shouldEnableAec = DEBUG;
            return DEBUG;
        }
        if (this.aec == null) {
            this.shouldEnableAec = z7;
            return true;
        }
        return toggleAEC(z7);
    }

    public synchronized boolean setNS(boolean z7) {
        Logging.d(TAG, "setNS(" + z7 + ")");
        if (!isNoiseSuppressorSupported()) {
            Logging.w(TAG, "Platform NS is not supported");
            this.shouldEnableNs = DEBUG;
            return DEBUG;
        }
        if (this.ns == null) {
            this.shouldEnableNs = z7;
            return true;
        }
        return toggleNS(z7);
    }

    public synchronized boolean shouldEnableAEC() {
        return this.shouldEnableAec;
    }

    public synchronized boolean shouldEnableNS() {
        return this.shouldEnableNs;
    }

    public synchronized boolean toggleAEC(boolean z7) {
        AcousticEchoCanceler acousticEchoCanceler = this.aec;
        boolean z8 = DEBUG;
        if (acousticEchoCanceler == null) {
            Logging.e(TAG, "Attempting to enable or disable nonexistent AcousticEchoCanceler.");
            return DEBUG;
        }
        Logging.d(TAG, "toggleAEC(" + z7 + ")");
        if (this.aec.setEnabled(z7) == 0) {
            z8 = true;
        }
        if (z8) {
            this.shouldEnableAec = z7;
        }
        Logging.d(TAG, "AcousticEchoCanceler: is now: " + (this.aec.getEnabled() ? "enabled" : "disabled"));
        return z8;
    }

    public synchronized boolean toggleNS(boolean z7) {
        NoiseSuppressor noiseSuppressor = this.ns;
        boolean z8 = DEBUG;
        if (noiseSuppressor == null) {
            Logging.e(TAG, "Attempting to enable or disable nonexistent NoiseSuppressor.");
            return DEBUG;
        }
        Logging.d(TAG, "toggleNS(" + z7 + ")");
        if (this.ns.setEnabled(z7) == 0) {
            z8 = true;
        }
        if (z8) {
            this.shouldEnableNs = z7;
        }
        Logging.d(TAG, "NoiseSuppressor: is now: " + (this.ns.getEnabled() ? "enabled" : "disabled"));
        return z8;
    }
}
