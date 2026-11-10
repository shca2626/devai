package com.cloudwebrtc.webrtc.utils;

import org.webrtc.EglBase;

/* loaded from: classes.dex */
public class EglUtils {
    private static EglBase rootEglBase;

    public static synchronized EglBase getRootEglBase() {
        try {
            if (rootEglBase == null) {
                rootEglBase = EglBase.create();
            }
        } catch (Throwable th) {
            throw th;
        }
        return rootEglBase;
    }

    public static EglBase.Context getRootEglBaseContext() {
        EglBase rootEglBase2 = getRootEglBase();
        if (rootEglBase2 == null) {
            return null;
        }
        return rootEglBase2.getEglBaseContext();
    }
}
