package B0;

import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public static final HashSet f948a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public static String f949b = "media3.common";

    public static synchronized void a(String str) {
        if (f948a.add(str)) {
            f949b += ", " + str;
        }
    }

    public static synchronized String b() {
        return f949b;
    }
}
