package com.google.android.material.internal;

import android.os.Build;
import java.util.Locale;

/* loaded from: classes8.dex */
public class j {
    private static String a() {
        String str = Build.MANUFACTURER;
        return str != null ? str.toLowerCase(Locale.ENGLISH) : "";
    }

    public static boolean b() {
        return a().equals("meizu");
    }
}
