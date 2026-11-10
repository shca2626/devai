package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.l0;

/* loaded from: classes.dex */
public class D {

    /* renamed from: a, reason: collision with root package name */
    public final a f11946a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f11947b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f11948c;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final l0.b f11949a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f11950b;

        /* renamed from: c, reason: collision with root package name */
        public final l0.b f11951c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f11952d;

        public a(l0.b bVar, Object obj, l0.b bVar2, Object obj2) {
            this.f11949a = bVar;
            this.f11950b = obj;
            this.f11951c = bVar2;
            this.f11952d = obj2;
        }
    }

    public D(l0.b bVar, Object obj, l0.b bVar2, Object obj2) {
        this.f11946a = new a(bVar, obj, bVar2, obj2);
        this.f11947b = obj;
        this.f11948c = obj2;
    }

    public static int b(a aVar, Object obj, Object obj2) {
        return C0786q.b(aVar.f11949a, 1, obj) + C0786q.b(aVar.f11951c, 2, obj2);
    }

    public static D d(l0.b bVar, Object obj, l0.b bVar2, Object obj2) {
        return new D(bVar, obj, bVar2, obj2);
    }

    public static void e(AbstractC0778i abstractC0778i, a aVar, Object obj, Object obj2) {
        C0786q.w(abstractC0778i, aVar.f11949a, 1, obj);
        C0786q.w(abstractC0778i, aVar.f11951c, 2, obj2);
    }

    public int a(int i7, Object obj, Object obj2) {
        return AbstractC0778i.R(i7) + AbstractC0778i.B(b(this.f11946a, obj, obj2));
    }

    public a c() {
        return this.f11946a;
    }
}
