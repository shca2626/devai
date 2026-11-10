package r5;

import java.util.List;
import z5.C1880n;

/* loaded from: classes.dex */
public final class r extends C {

    /* renamed from: b, reason: collision with root package name */
    public static final a f22326b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f22327a;

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
        this.f22327a = z7;
    }

    public final List a() {
        return C1880n.d(Boolean.valueOf(this.f22327a));
    }

    public boolean equals(Object obj) {
        if (obj == null || !M5.m.a(obj.getClass(), r.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return C1593x.f22331a.a(Boolean.valueOf(this.f22327a), Boolean.valueOf(((r) obj).f22327a));
    }

    public int hashCode() {
        return (r.class.hashCode() * 31) + C1593x.f22331a.b(Boolean.valueOf(this.f22327a));
    }

    public String toString() {
        return "IsPlayingStateEvent(isPlaying=" + this.f22327a + ")";
    }
}
