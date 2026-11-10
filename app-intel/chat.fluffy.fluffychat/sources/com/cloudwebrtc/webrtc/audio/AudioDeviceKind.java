package com.cloudwebrtc.webrtc.audio;

import I4.b;

/* loaded from: classes.dex */
public enum AudioDeviceKind {
    BLUETOOTH("bluetooth", b.a.class),
    WIRED_HEADSET("wired-headset", b.d.class),
    SPEAKER("speaker", b.c.class),
    EARPIECE("earpiece", b.C0041b.class);

    public final Class<? extends I4.b> audioDeviceClass;
    public final String typeName;

    AudioDeviceKind(String str, Class cls) {
        this.typeName = str;
        this.audioDeviceClass = cls;
    }

    public static AudioDeviceKind fromAudioDevice(I4.b bVar) {
        for (AudioDeviceKind audioDeviceKind : values()) {
            if (audioDeviceKind.audioDeviceClass.equals(bVar.getClass())) {
                return audioDeviceKind;
            }
        }
        return null;
    }

    public static AudioDeviceKind fromTypeName(String str) {
        for (AudioDeviceKind audioDeviceKind : values()) {
            if (audioDeviceKind.typeName.equals(str)) {
                return audioDeviceKind;
            }
        }
        return null;
    }
}
