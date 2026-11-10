package o5;

import java.util.List;
import z5.C1881o;

/* renamed from: o5.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1408b {

    /* renamed from: d, reason: collision with root package name */
    public static final a f20418d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f20419a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f20420b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f20421c;

    /* renamed from: o5.b$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1408b a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            Object obj2 = list.get(1);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            boolean zBooleanValue2 = ((Boolean) obj2).booleanValue();
            Object obj3 = list.get(2);
            M5.m.c(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            return new C1408b(zBooleanValue, zBooleanValue2, ((Boolean) obj3).booleanValue());
        }

        public a() {
        }
    }

    public C1408b(boolean z7, boolean z8, boolean z9) {
        this.f20419a = z7;
        this.f20420b = z8;
        this.f20421c = z9;
    }

    public final boolean a() {
        return this.f20419a;
    }

    public final boolean b() {
        return this.f20420b;
    }

    public final boolean c() {
        return this.f20421c;
    }

    public final List d() {
        return C1881o.l(Boolean.valueOf(this.f20419a), Boolean.valueOf(this.f20420b), Boolean.valueOf(this.f20421c));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1408b)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return s.f20479a.a(d(), ((C1408b) obj).d());
    }

    public int hashCode() {
        return d().hashCode();
    }

    public String toString() {
        return "AuthOptions(biometricOnly=" + this.f20419a + ", sensitiveTransaction=" + this.f20420b + ", sticky=" + this.f20421c + ")";
    }
}
