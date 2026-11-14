package I;

import Y.e;
import Y.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import y.C1796k;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final e f3529a = new f(10);

    /* renamed from: b, reason: collision with root package name */
    public final C1796k f3530b = new C1796k();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f3531c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f3532d = new HashSet();

    public void a(Object obj, Object obj2) {
        if (!this.f3530b.containsKey(obj) || !this.f3530b.containsKey(obj2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayListF = (ArrayList) this.f3530b.get(obj);
        if (arrayListF == null) {
            arrayListF = f();
            this.f3530b.put(obj, arrayListF);
        }
        arrayListF.add(obj2);
    }

    public void b(Object obj) {
        if (this.f3530b.containsKey(obj)) {
            return;
        }
        this.f3530b.put(obj, null);
    }

    public void c() {
        int size = this.f3530b.size();
        for (int i7 = 0; i7 < size; i7++) {
            ArrayList arrayList = (ArrayList) this.f3530b.j(i7);
            if (arrayList != null) {
                j(arrayList);
            }
        }
        this.f3530b.clear();
    }

    public boolean d(Object obj) {
        return this.f3530b.containsKey(obj);
    }

    public final void e(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) this.f3530b.get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i7 = 0; i7 < size; i7++) {
                e(arrayList2.get(i7), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    public final ArrayList f() {
        ArrayList arrayList = (ArrayList) this.f3529a.b();
        return arrayList == null ? new ArrayList() : arrayList;
    }

    public List g(Object obj) {
        int size = this.f3530b.size();
        ArrayList arrayList = null;
        for (int i7 = 0; i7 < size; i7++) {
            ArrayList arrayList2 = (ArrayList) this.f3530b.j(i7);
            if (arrayList2 != null && arrayList2.contains(obj)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f3530b.f(i7));
            }
        }
        return arrayList;
    }

    public ArrayList h() {
        this.f3531c.clear();
        this.f3532d.clear();
        int size = this.f3530b.size();
        for (int i7 = 0; i7 < size; i7++) {
            e(this.f3530b.f(i7), this.f3531c, this.f3532d);
        }
        return this.f3531c;
    }

    public boolean i(Object obj) {
        int size = this.f3530b.size();
        for (int i7 = 0; i7 < size; i7++) {
            ArrayList arrayList = (ArrayList) this.f3530b.j(i7);
            if (arrayList != null && arrayList.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public final void j(ArrayList arrayList) {
        arrayList.clear();
        this.f3529a.a(arrayList);
    }
}
