package r5;

import java.util.List;
import z5.C1883n;

/* renamed from: r5.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1594z {

    /* renamed from: b, reason: collision with root package name */
    public static final a f22340b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final List f22341a;

    /* renamed from: r5.z$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1594z a(List list) {
            M5.m.e(list, "pigeonVar_list");
            return new C1594z((List) list.get(0));
        }

        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C1594z() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final List a() {
        return C1883n.d(this.f22341a);
    }

    public boolean equals(Object obj) {
        if (obj == null || !M5.m.a(obj.getClass(), C1594z.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return C1592x.f22337a.a(this.f22341a, ((C1594z) obj).f22341a);
    }

    public int hashCode() {
        return (C1594z.class.hashCode() * 31) + C1592x.f22337a.b(this.f22341a);
    }

    public String toString() {
        return "NativeVideoTrackData(exoPlayerTracks=" + this.f22341a + ")";
    }

    public C1594z(List list) {
        this.f22341a = list;
    }

    public /* synthetic */ C1594z(List list, int i7, M5.g gVar) {
        this((i7 & 1) != 0 ? null : list);
    }
}
