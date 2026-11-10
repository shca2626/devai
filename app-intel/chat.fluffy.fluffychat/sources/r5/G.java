package r5;

import java.util.List;
import z5.C1880n;

/* loaded from: classes.dex */
public final class G extends C {

    /* renamed from: b, reason: collision with root package name */
    public static final a f22191b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final B f22192a;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final G a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type io.flutter.plugins.videoplayer.PlatformPlaybackState");
            return new G((B) obj);
        }

        public a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G(B b7) {
        super(null);
        M5.m.e(b7, "state");
        this.f22192a = b7;
    }

    public final List a() {
        return C1880n.d(this.f22192a);
    }

    public boolean equals(Object obj) {
        if (obj == null || !M5.m.a(obj.getClass(), G.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return C1593x.f22331a.a(this.f22192a, ((G) obj).f22192a);
    }

    public int hashCode() {
        return (G.class.hashCode() * 31) + C1593x.f22331a.b(this.f22192a);
    }

    public String toString() {
        return "PlaybackStateChangeEvent(state=" + this.f22192a + ")";
    }
}
