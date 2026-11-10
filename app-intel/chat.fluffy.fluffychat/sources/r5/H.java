package r5;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class H {

    /* renamed from: a, reason: collision with root package name */
    public C1570A f22193a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f22194b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public boolean f22195c = false;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f22196a;

        /* renamed from: b, reason: collision with root package name */
        public String f22197b;

        /* renamed from: c, reason: collision with root package name */
        public Object f22198c;

        public a(String str, String str2, Object obj) {
            this.f22196a = str;
            this.f22197b = str2;
            this.f22198c = obj;
        }
    }

    public final void a(Object obj) {
        if (this.f22195c) {
            return;
        }
        this.f22194b.add(obj);
    }

    public void b(String str, String str2, Object obj) {
        a(new a(str, str2, obj));
        c();
    }

    public final void c() {
        if (this.f22193a == null) {
            return;
        }
        ArrayList arrayList = this.f22194b;
        int size = arrayList.size();
        int i7 = 0;
        while (i7 < size) {
            Object obj = arrayList.get(i7);
            i7++;
            if (obj instanceof a) {
                a aVar = (a) obj;
                this.f22193a.a(aVar.f22196a, aVar.f22197b, aVar.f22198c);
            } else {
                this.f22193a.b((C) obj);
            }
        }
        this.f22194b.clear();
    }

    public void d(C1570A c1570a) {
        this.f22193a = c1570a;
        c();
    }

    public void e(C c7) {
        a(c7);
        c();
    }
}
