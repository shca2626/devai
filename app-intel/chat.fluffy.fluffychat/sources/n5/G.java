package n5;

import java.util.List;
import z5.C1880n;

/* loaded from: classes.dex */
public final class G {

    /* renamed from: b, reason: collision with root package name */
    public static final a f20118b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final F f20119a;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final G a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type io.flutter.plugins.imagepicker.ImageSelectionOptions");
            return new G((F) obj);
        }

        public a() {
        }
    }

    public G(F f7) {
        M5.m.e(f7, "imageSelectionOptions");
        this.f20119a = f7;
    }

    public final F a() {
        return this.f20119a;
    }

    public final List b() {
        return C1880n.d(this.f20119a);
    }

    public boolean equals(Object obj) {
        if (obj == null || !M5.m.a(obj.getClass(), G.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return I.f20120a.a(this.f20119a, ((G) obj).f20119a);
    }

    public int hashCode() {
        return (G.class.hashCode() * 31) + I.f20120a.b(this.f20119a);
    }

    public String toString() {
        return "MediaSelectionOptions(imageSelectionOptions=" + this.f20119a + ")";
    }
}
