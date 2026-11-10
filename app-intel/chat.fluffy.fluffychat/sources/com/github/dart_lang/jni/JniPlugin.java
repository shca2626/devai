package com.github.dart_lang.jni;

import c5.InterfaceC0910a;

/* loaded from: classes.dex */
public class JniPlugin implements InterfaceC0910a {
    static {
        System.loadLibrary("dartjni");
        setClassLoader(JniPlugin.class.getClassLoader());
    }

    public static native void setClassLoader(ClassLoader classLoader);

    @Override // c5.InterfaceC0910a
    public void onAttachedToEngine(InterfaceC0910a.b bVar) {
    }

    @Override // c5.InterfaceC0910a
    public void onDetachedFromEngine(InterfaceC0910a.b bVar) {
    }
}
