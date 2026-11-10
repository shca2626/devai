package n5;

import java.util.List;
import z5.C1881o;

/* renamed from: n5.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1370g {

    /* renamed from: d, reason: collision with root package name */
    public static final a f20154d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f20155a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f20156b;

    /* renamed from: c, reason: collision with root package name */
    public final Long f20157c;

    /* renamed from: n5.g$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1370g a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            Object obj2 = list.get(1);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            return new C1370g(zBooleanValue, ((Boolean) obj2).booleanValue(), (Long) list.get(2));
        }

        public a() {
        }
    }

    public C1370g(boolean z7, boolean z8, Long l7) {
        this.f20155a = z7;
        this.f20156b = z8;
        this.f20157c = l7;
    }

    public final boolean a() {
        return this.f20155a;
    }

    public final Long b() {
        return this.f20157c;
    }

    public final boolean c() {
        return this.f20156b;
    }

    public final List d() {
        return C1881o.l(Boolean.valueOf(this.f20155a), Boolean.valueOf(this.f20156b), this.f20157c);
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), C1370g.class)) {
            if (this == obj) {
                return true;
            }
            C1370g c1370g = (C1370g) obj;
            I i7 = I.f20120a;
            if (i7.a(Boolean.valueOf(this.f20155a), Boolean.valueOf(c1370g.f20155a)) && i7.a(Boolean.valueOf(this.f20156b), Boolean.valueOf(c1370g.f20156b)) && i7.a(this.f20157c, c1370g.f20157c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = C1370g.class.hashCode() * 31;
        I i7 = I.f20120a;
        return ((((iHashCode + i7.b(Boolean.valueOf(this.f20155a))) * 31) + i7.b(Boolean.valueOf(this.f20156b))) * 31) + i7.b(this.f20157c);
    }

    public String toString() {
        return "GeneralOptions(allowMultiple=" + this.f20155a + ", usePhotoPicker=" + this.f20156b + ", limit=" + this.f20157c + ")";
    }
}
