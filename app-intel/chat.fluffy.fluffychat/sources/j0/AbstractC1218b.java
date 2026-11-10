package j0;

import M5.m;
import android.content.Context;
import g0.AbstractC1069a;
import java.io.File;

/* renamed from: j0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1218b {
    public static final File a(Context context, String str) {
        m.e(context, "<this>");
        m.e(str, "name");
        return AbstractC1069a.a(context, str + ".preferences_pb");
    }
}
