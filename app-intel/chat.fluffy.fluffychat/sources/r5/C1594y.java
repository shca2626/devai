package r5;

import java.util.List;
import z5.C1880n;

/* renamed from: r5.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1594y {

    /* renamed from: b, reason: collision with root package name */
    public static final a f22332b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final List f22333a;

    /* renamed from: r5.y$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1594y a(List list) {
            M5.m.e(list, "pigeonVar_list");
            return new C1594y((List) list.get(0));
        }

        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C1594y() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final List a() {
        return C1880n.d(this.f22333a);
    }

    public boolean equals(Object obj) {
        if (obj == null || !M5.m.a(obj.getClass(), C1594y.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return C1593x.f22331a.a(this.f22333a, ((C1594y) obj).f22333a);
    }

    public int hashCode() {
        return (C1594y.class.hashCode() * 31) + C1593x.f22331a.b(this.f22333a);
    }

    public String toString() {
        return "NativeAudioTrackData(exoPlayerTracks=" + this.f22333a + ")";
    }

    public C1594y(List list) {
        this.f22333a = list;
    }

    public /* synthetic */ C1594y(List list, int i7, M5.g gVar) {
        this((i7 & 1) != 0 ? null : list);
    }
}
