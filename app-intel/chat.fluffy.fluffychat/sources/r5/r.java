package r5;

import java.util.List;
import z5.C1883n;

/* loaded from: classes.dex */
public final class r extends C {

    /* renamed from: b, reason: collision with root package name */
    public static final a f22332b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f22333a;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final r a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
            return new r(((Boolean) obj).booleanValue());
        }

        public a() {
        }
    }

    public r(boolean z7) {
        super(null);
        this.f22333a = z7;
    }

    public final List a() {
        return C1883n.d(Boolean.valueOf(this.f22333a));
    }

    public boolean equals(Object obj) {
        if (obj == null || !M5.m.a(obj.getClass(), r.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return C1592x.f22337a.a(Boolean.valueOf(this.f22333a), Boolean.valueOf(((r) obj).f22333a));
    }

    public int hashCode() {
        return (r.class.hashCode() * 31) + C1592x.f22337a.b(Boolean.valueOf(this.f22333a));
    }

    public String toString() {
        return "IsPlayingStateEvent(isPlaying=" + this.f22333a + ")";
    }
}
