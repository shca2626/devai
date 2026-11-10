package r5;

import java.util.List;
import z5.C1880n;

/* renamed from: r5.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1595z {

    /* renamed from: b, reason: collision with root package name */
    public static final a f22334b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final List f22335a;

    /* renamed from: r5.z$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1595z a(List list) {
            M5.m.e(list, "pigeonVar_list");
            return new C1595z((List) list.get(0));
        }

        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C1595z() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final List a() {
        return C1880n.d(this.f22335a);
    }

    public boolean equals(Object obj) {
        if (obj == null || !M5.m.a(obj.getClass(), C1595z.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return C1593x.f22331a.a(this.f22335a, ((C1595z) obj).f22335a);
    }

    public int hashCode() {
        return (C1595z.class.hashCode() * 31) + C1593x.f22331a.b(this.f22335a);
    }

    public String toString() {
        return "NativeVideoTrackData(exoPlayerTracks=" + this.f22335a + ")";
    }

    public C1595z(List list) {
        this.f22335a = list;
    }

    public /* synthetic */ C1595z(List list, int i7, M5.g gVar) {
        this((i7 & 1) != 0 ? null : list);
    }
}
