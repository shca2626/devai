package J0;

import android.media.metrics.LogSessionId;
import android.os.Build;

/* loaded from: classes.dex */
public final class G1 {

    /* renamed from: c, reason: collision with root package name */
    public static final G1 f4457c = new G1("");

    /* renamed from: d, reason: collision with root package name */
    public static final G1 f4458d = new G1("preload");

    /* renamed from: a, reason: collision with root package name */
    public final String f4459a;

    /* renamed from: b, reason: collision with root package name */
    public final a f4460b;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public LogSessionId f4461a = LogSessionId.LOG_SESSION_ID_NONE;

        public void a(LogSessionId logSessionId) {
            j3.o.v(this.f4461a.equals(LogSessionId.LOG_SESSION_ID_NONE));
            this.f4461a = logSessionId;
        }
    }

    public G1(String str) {
        this.f4459a = str;
        this.f4460b = Build.VERSION.SDK_INT >= 31 ? new a() : null;
    }

    public synchronized LogSessionId a() {
        return ((a) j3.o.q(this.f4460b)).f4461a;
    }

    public synchronized void b(LogSessionId logSessionId) {
        ((a) j3.o.q(this.f4460b)).a(logSessionId);
    }
}
