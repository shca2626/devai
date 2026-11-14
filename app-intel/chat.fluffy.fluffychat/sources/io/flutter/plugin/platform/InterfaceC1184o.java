package io.flutter.plugin.platform;

import android.view.Surface;

/* renamed from: io.flutter.plugin.platform.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC1184o {
    void a(int i7, int i8);

    int getHeight();

    long getId();

    Surface getSurface();

    int getWidth();

    void release();

    default void scheduleFrame() {
    }
}
