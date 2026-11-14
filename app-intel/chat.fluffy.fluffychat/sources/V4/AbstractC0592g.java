package V4;

import android.os.Bundle;

/* renamed from: V4.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0592g {

    /* renamed from: a, reason: collision with root package name */
    public static final String f8777a = a.opaque.name();

    /* renamed from: V4.g$a */
    public enum a {
        opaque,
        transparent
    }

    public static boolean a(Bundle bundle) {
        if (bundle == null || !bundle.containsKey("flutter_deeplinking_enabled")) {
            return true;
        }
        return bundle.getBoolean("flutter_deeplinking_enabled");
    }
}
