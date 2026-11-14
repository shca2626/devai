package n5;

import java.util.List;
import z5.C1883n;

/* loaded from: classes.dex */
public final class G {

    /* renamed from: b, reason: collision with root package name */
    public static final a f20117b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final F f20118a;

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
        this.f20118a = f7;
    }

    public final F a() {
        return this.f20118a;
    }

    public final List b() {
        return C1883n.d(this.f20118a);
    }

    public boolean equals(Object obj) {
        if (obj == null || !M5.m.a(obj.getClass(), G.class)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return I.f20119a.a(this.f20118a, ((G) obj).f20118a);
    }

    public int hashCode() {
        return (G.class.hashCode() * 31) + I.f20119a.b(this.f20118a);
    }

    public String toString() {
        return "MediaSelectionOptions(imageSelectionOptions=" + this.f20118a + ")";
    }
}
