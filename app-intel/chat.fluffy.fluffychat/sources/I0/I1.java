package I0;

import java.util.Objects;
import k3.AbstractC1258B;

/* loaded from: classes.dex */
public final class I1 {

    /* renamed from: j, reason: collision with root package name */
    public static final I1 f3682j = new b().i();

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC1258B f3683a;

    /* renamed from: b, reason: collision with root package name */
    public final Double f3684b;

    /* renamed from: c, reason: collision with root package name */
    public final Double f3685c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f3686d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f3687e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f3688f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f3689g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f3690h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f3691i;

    public static final class b {

        /* renamed from: b, reason: collision with root package name */
        public Double f3693b;

        /* renamed from: c, reason: collision with root package name */
        public Double f3694c;

        /* renamed from: a, reason: collision with root package name */
        public AbstractC1258B f3692a = AbstractC1258B.w(1, 5);

        /* renamed from: d, reason: collision with root package name */
        public boolean f3695d = true;

        /* renamed from: e, reason: collision with root package name */
        public boolean f3696e = true;

        /* renamed from: f, reason: collision with root package name */
        public boolean f3697f = true;

        /* renamed from: g, reason: collision with root package name */
        public boolean f3698g = true;

        /* renamed from: h, reason: collision with root package name */
        public boolean f3699h = true;

        public I1 i() {
            return new I1(this);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof I1)) {
            return false;
        }
        I1 i12 = (I1) obj;
        return this.f3683a.equals(i12.f3683a) && this.f3688f == i12.f3688f && this.f3691i == i12.f3691i && Objects.equals(this.f3684b, i12.f3684b) && Objects.equals(this.f3685c, i12.f3685c) && this.f3686d == i12.f3686d && this.f3689g == i12.f3689g && this.f3690h == i12.f3690h;
    }

    public int hashCode() {
        return Objects.hash(this.f3683a, this.f3684b, this.f3685c, Boolean.valueOf(this.f3686d), Boolean.valueOf(this.f3688f), Boolean.valueOf(this.f3691i), Boolean.valueOf(this.f3689g), Boolean.valueOf(this.f3690h));
    }

    public I1(b bVar) {
        this.f3683a = bVar.f3692a;
        this.f3684b = bVar.f3693b;
        this.f3685c = bVar.f3694c;
        this.f3686d = bVar.f3695d;
        this.f3687e = !bVar.f3696e;
        this.f3688f = bVar.f3696e;
        this.f3691i = bVar.f3697f;
        this.f3689g = bVar.f3698g;
        this.f3690h = bVar.f3699h;
    }
}
