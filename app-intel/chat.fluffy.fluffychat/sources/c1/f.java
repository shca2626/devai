package c1;

import E0.O;
import android.net.Uri;
import j3.C1233h;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final C1233h f13873a = C1233h.h(",");

    public static final class a {
        public abstract f a();

        public abstract a b(long j7);

        public abstract a c(String str);

        public abstract a d(String str);

        public abstract a e(String str);
    }

    public static Uri b(Uri uri) {
        return (!uri.isHierarchical() || uri.getQueryParameter("CMCD") == null) ? uri : O.e(uri, "CMCD");
    }

    public abstract G0.j a(G0.j jVar);
}
