package r5;

import java.util.List;
import z5.C1883n;

/* renamed from: r5.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1593y {

    /* renamed from: b, reason: collision with root package name */
    public static final a f22338b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final List f22339a;

    /* renamed from: r5.y$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1593y a(List list) {
            M5.m.e(list, "pigeonVar_list");
            return new C1593y((List) list.get(0));
        }

        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C1593y() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final List a() {
        return C1883n.d(this.f22339a);
    }

    public boolean equals(Object obj) {
        if (obj == null || !M5.m.a(obj.getClass(), C1593y.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return C1592x.f22337a.a(this.f22339a, ((C1593y) obj).f22339a);
    }

    public int hashCode() {
        return (C1593y.class.hashCode() * 31) + C1592x.f22337a.b(this.f22339a);
    }

    public String toString() {
        return "NativeAudioTrackData(exoPlayerTracks=" + this.f22339a + ")";
    }

    public C1593y(List list) {
        this.f22339a = list;
    }

    public /* synthetic */ C1593y(List list, int i7, M5.g gVar) {
        this((i7 & 1) != 0 ? null : list);
    }
}
