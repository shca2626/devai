package com.github.dart_lang.jni;

import c5.InterfaceC0911a;

/* loaded from: classes.dex */
public class JniPlugin implements InterfaceC0911a {
    static {
        System.loadLibrary("dartjni");
        setClassLoader(JniPlugin.class.getClassLoader());
    }

    public static native void setClassLoader(ClassLoader classLoader);

    @Override // c5.InterfaceC0911a
    public void onAttachedToEngine(InterfaceC0911a.b bVar) {
    }

    @Override // c5.InterfaceC0911a
    public void onDetachedFromEngine(InterfaceC0911a.b bVar) {
    }
}
