package r5;

import java.util.List;
import z5.C1883n;

/* renamed from: r5.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1578i extends C {

    /* renamed from: b, reason: collision with root package name */
    public static final a f22257b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f22258a;

    /* renamed from: r5.i$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1578i a(List list) {
            M5.m.e(list, "pigeonVar_list");
            return new C1578i((String) list.get(0));
        }

        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C1578i() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final List a() {
        return C1883n.d(this.f22258a);
    }

    public boolean equals(Object obj) {
        if (obj == null || !M5.m.a(obj.getClass(), C1578i.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return C1592x.f22337a.a(this.f22258a, ((C1578i) obj).f22258a);
    }

    public int hashCode() {
        return (C1578i.class.hashCode() * 31) + C1592x.f22337a.b(this.f22258a);
    }

    public String toString() {
        return "AudioTrackChangedEvent(selectedTrackId=" + this.f22258a + ")";
    }

    public C1578i(String str) {
        super(null);
        this.f22258a = str;
    }

    public /* synthetic */ C1578i(String str, int i7, M5.g gVar) {
        this((i7 & 1) != 0 ? null : str);
    }
}
