package r5;

import java.util.List;
import z5.C1883n;

/* loaded from: classes.dex */
public final class G extends C {

    /* renamed from: b, reason: collision with root package name */
    public static final a f22197b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final B f22198a;

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
        this.f22198a = b7;
    }

    public final List a() {
        return C1883n.d(this.f22198a);
    }

    public boolean equals(Object obj) {
        if (obj == null || !M5.m.a(obj.getClass(), G.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return C1592x.f22337a.a(this.f22198a, ((G) obj).f22198a);
    }

    public int hashCode() {
        return (G.class.hashCode() * 31) + C1592x.f22337a.b(this.f22198a);
    }

    public String toString() {
        return "PlaybackStateChangeEvent(state=" + this.f22198a + ")";
    }
}
