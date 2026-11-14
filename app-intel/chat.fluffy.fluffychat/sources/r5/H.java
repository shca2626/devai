package r5;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class H {

    /* renamed from: a, reason: collision with root package name */
    public C1569A f22199a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f22200b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public boolean f22201c = false;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f22202a;

        /* renamed from: b, reason: collision with root package name */
        public String f22203b;

        /* renamed from: c, reason: collision with root package name */
        public Object f22204c;

        public a(String str, String str2, Object obj) {
            this.f22202a = str;
            this.f22203b = str2;
            this.f22204c = obj;
        }
    }

    public final void a(Object obj) {
        if (this.f22201c) {
            return;
        }
        this.f22200b.add(obj);
    }

    public void b(String str, String str2, Object obj) {
        a(new a(str, str2, obj));
        c();
    }

    public final void c() {
        if (this.f22199a == null) {
            return;
        }
        ArrayList arrayList = this.f22200b;
        int size = arrayList.size();
        int i7 = 0;
        while (i7 < size) {
            Object obj = arrayList.get(i7);
            i7++;
            if (obj instanceof a) {
                a aVar = (a) obj;
                this.f22199a.a(aVar.f22202a, aVar.f22203b, aVar.f22204c);
            } else {
                this.f22199a.b((C) obj);
            }
        }
        this.f22200b.clear();
    }

    public void d(C1569A c1569a) {
        this.f22199a = c1569a;
        c();
    }

    public void e(C c7) {
        a(c7);
        c();
    }
}
