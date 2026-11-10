package J5;

import M5.m;
import java.io.File;

/* loaded from: classes.dex */
public abstract class c {
    public static final String b(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        if (str != null) {
            sb.append(": " + str);
        }
        String string = sb.toString();
        m.d(string, "toString(...)");
        return string;
    }
}
