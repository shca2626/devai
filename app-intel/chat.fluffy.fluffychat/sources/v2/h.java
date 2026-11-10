package v2;

import android.os.Build;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final a f22921a = new a(null);

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final h a() {
            int i7 = Build.VERSION.SDK_INT;
            return (i7 < 26 || g.f22920b) ? new i(false) : (i7 == 26 || i7 == 27) ? l.f22937b : new i(true);
        }

        public a() {
        }
    }

    public /* synthetic */ h(M5.g gVar) {
        this();
    }

    public abstract boolean a(y2.h hVar, C2.l lVar);

    public h() {
    }
}
