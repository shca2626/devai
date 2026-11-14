package g0;

import M5.m;
import android.content.Context;
import java.io.File;

/* renamed from: g0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1070a {
    public static final File a(Context context, String str) {
        m.e(context, "<this>");
        m.e(str, "fileName");
        return new File(context.getApplicationContext().getFilesDir(), "datastore/" + str);
    }
}
