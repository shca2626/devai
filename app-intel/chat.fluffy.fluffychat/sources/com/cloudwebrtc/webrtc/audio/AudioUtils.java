package com.cloudwebrtc.webrtc.audio;

import android.media.AudioDeviceInfo;
import android.os.Build;
import android.util.Log;

/* loaded from: classes.dex */
public class AudioUtils {
    private static final String TAG = "AudioUtils";

    public static Integer getAudioAttributesContentTypeFromString(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
            case "sonification":
                break;
            case "speech":
                break;
            case "unknown":
                break;
            case "movie":
                break;
            case "music":
                break;
            default:
                Log.w(TAG, "Unknown audio attributes content type:" + str);
                break;
        }
        return null;
    }

    public static Integer getAudioAttributesUsageTypeForString(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
            case "notificationEvent":
                break;
            case "voiceCommunication":
                break;
            case "unknown":
                break;
            case "game":
                break;
            case "assistanceSonification":
                break;
            case "alarm":
                break;
            case "media":
                break;
            case "notification":
                break;
            case "assistanceAccessibility":
                break;
            case "notificationRingtone":
                break;
            case "assistant":
                break;
            case "assistanceNavigationGuidance":
                break;
            case "voiceCommunicationSignalling":
                break;
            default:
                Log.w(TAG, "Unknown audio attributes usage type: " + str);
                break;
        }
        return null;
    }

    public static String getAudioDeviceId(AudioDeviceInfo audioDeviceInfo) {
        String address = Build.VERSION.SDK_INT < 28 ? "" : audioDeviceInfo.getAddress();
        String str = "" + audioDeviceInfo.getId();
        if (audioDeviceInfo.getType() == 15) {
            str = "microphone-" + address;
        }
        if (audioDeviceInfo.getType() == 3) {
            str = "wired-headset";
        }
        return audioDeviceInfo.getType() == 7 ? "bluetooth" : str;
    }

    public static String getAudioDeviceLabel(AudioDeviceInfo audioDeviceInfo) {
        String address = Build.VERSION.SDK_INT < 28 ? "" : audioDeviceInfo.getAddress();
        String string = audioDeviceInfo.getProductName().toString();
        if (audioDeviceInfo.getType() == 15) {
            string = "Built-in Microphone (" + address + ")";
        }
        if (audioDeviceInfo.getType() == 3) {
            string = "Wired Headset Microphone";
        }
        return audioDeviceInfo.getType() == 7 ? audioDeviceInfo.getProductName().toString() : string;
    }

    public static String getAudioGroupId(AudioDeviceInfo audioDeviceInfo) {
        String str = "" + audioDeviceInfo.getType();
        if (audioDeviceInfo.getType() == 15) {
            str = "microphone";
        }
        if (audioDeviceInfo.getType() == 3) {
            str = "wired-headset";
        }
        return audioDeviceInfo.getType() == 7 ? "bluetooth" : str;
    }

    public static Integer getAudioModeForString(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
            case "callScreening":
                break;
            case "ringtone":
                break;
            case "inCall":
                break;
            case "normal":
                break;
            case "inCommunication":
                break;
            default:
                Log.w(TAG, "Unknown audio mode: " + str);
                break;
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Integer getFocusModeForString(java.lang.String r7) {
        /*
            r0 = 0
            if (r7 != 0) goto L4
            return r0
        L4:
            int r1 = r7.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = -1
            switch(r1) {
                case -1600850485: goto L3e;
                case -1587200749: goto L33;
                case -973361293: goto L28;
                case 3165055: goto L1d;
                case 3327779: goto L12;
                default: goto L10;
            }
        L10:
            r1 = r6
            goto L48
        L12:
            java.lang.String r1 = "loss"
            boolean r1 = r7.equals(r1)
            if (r1 != 0) goto L1b
            goto L10
        L1b:
            r1 = r2
            goto L48
        L1d:
            java.lang.String r1 = "gain"
            boolean r1 = r7.equals(r1)
            if (r1 != 0) goto L26
            goto L10
        L26:
            r1 = r3
            goto L48
        L28:
            java.lang.String r1 = "gainTransientMayDuck"
            boolean r1 = r7.equals(r1)
            if (r1 != 0) goto L31
            goto L10
        L31:
            r1 = r4
            goto L48
        L33:
            java.lang.String r1 = "gainTransientExclusive"
            boolean r1 = r7.equals(r1)
            if (r1 != 0) goto L3c
            goto L10
        L3c:
            r1 = r5
            goto L48
        L3e:
            java.lang.String r1 = "gainTransient"
            boolean r1 = r7.equals(r1)
            if (r1 != 0) goto L47
            goto L10
        L47:
            r1 = 0
        L48:
            switch(r1) {
                case 0: goto L76;
                case 1: goto L71;
                case 2: goto L6c;
                case 3: goto L67;
                case 4: goto L62;
                default: goto L4b;
            }
        L4b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown audio focus mode: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            java.lang.String r1 = "AudioUtils"
            android.util.Log.w(r1, r7)
            return r0
        L62:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            return r7
        L67:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            return r7
        L6c:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
            return r7
        L71:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)
            return r7
        L76:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloudwebrtc.webrtc.audio.AudioUtils.getFocusModeForString(java.lang.String):java.lang.Integer");
    }

    public static Integer getStreamTypeForString(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
            case "voiceCall":
                break;
            case "system":
                break;
            case "accessibility":
                break;
            case "dtmf":
                break;
            case "ring":
                break;
            case "alarm":
                break;
            case "music":
                break;
            case "notification":
                break;
            default:
                Log.w(TAG, "Unknown audio stream type: " + str);
                break;
        }
        return null;
    }
}
