package r5;

import java.util.List;
import z5.C1880n;

/* renamed from: r5.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1579i extends C {

    /* renamed from: b, reason: collision with root package name */
    public static final a f22251b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f22252a;

    /* renamed from: r5.i$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1579i a(List list) {
            M5.m.e(list, "pigeonVar_list");
            return new C1579i((String) list.get(0));
        }

        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C1579i() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final List a() {
        return C1880n.d(this.f22252a);
    }

    public boolean equals(Object obj) {
        if (obj == null || !M5.m.a(obj.getClass(), C1579i.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return C1593x.f22331a.a(this.f22252a, ((C1579i) obj).f22252a);
    }

    public int hashCode() {
        return (C1579i.class.hashCode() * 31) + C1593x.f22331a.b(this.f22252a);
    }

    public String toString() {
        return "AudioTrackChangedEvent(selectedTrackId=" + this.f22252a + ")";
    }

    public C1579i(String str) {
        super(null);
        this.f22252a = str;
    }

    public /* synthetic */ C1579i(String str, int i7, M5.g gVar) {
        this((i7 & 1) != 0 ? null : str);
    }
}
