package r5;

import java.util.List;
import z5.C1883n;

/* loaded from: classes.dex */
public final class m0 extends C {

    /* renamed from: b, reason: collision with root package name */
    public static final a f22299b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f22300a;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final m0 a(List list) {
            M5.m.e(list, "pigeonVar_list");
            return new m0((String) list.get(0));
        }

        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m0() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final List a() {
        return C1883n.d(this.f22300a);
    }

    public boolean equals(Object obj) {
        if (obj == null || !M5.m.a(obj.getClass(), m0.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return C1592x.f22337a.a(this.f22300a, ((m0) obj).f22300a);
    }

    public int hashCode() {
        return (m0.class.hashCode() * 31) + C1592x.f22337a.b(this.f22300a);
    }

    public String toString() {
        return "VideoTrackChangedEvent(selectedTrackId=" + this.f22300a + ")";
    }

    public m0(String str) {
        super(null);
        this.f22300a = str;
    }

    public /* synthetic */ m0(String str, int i7, M5.g gVar) {
        this((i7 & 1) != 0 ? null : str);
    }
}
