package v2;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import v2.p;
import z5.C1889w;

/* loaded from: classes.dex */
public final class r implements y {

    /* renamed from: c, reason: collision with root package name */
    public static final a f22978c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f22979a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public int f22980b;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public a() {
        }
    }

    public static final class b implements p.a {

        /* renamed from: a, reason: collision with root package name */
        public final Bitmap f22981a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f22982b;

        public b(Bitmap bitmap, boolean z7) {
            M5.m.e(bitmap, "bitmap");
            this.f22981a = bitmap;
            this.f22982b = z7;
        }

        @Override // v2.p.a
        public boolean a() {
            return this.f22982b;
        }

        @Override // v2.p.a
        public Bitmap b() {
            return this.f22981a;
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f22983a;

        /* renamed from: b, reason: collision with root package name */
        public final WeakReference f22984b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f22985c;

        /* renamed from: d, reason: collision with root package name */
        public final int f22986d;

        public c(int i7, WeakReference weakReference, boolean z7, int i8) {
            M5.m.e(weakReference, "bitmap");
            this.f22983a = i7;
            this.f22984b = weakReference;
            this.f22985c = z7;
            this.f22986d = i8;
        }

        public final WeakReference a() {
            return this.f22984b;
        }

        public final int b() {
            return this.f22983a;
        }

        public final int c() {
            return this.f22986d;
        }

        public final boolean d() {
            return this.f22985c;
        }
    }

    public r(C2.l lVar) {
    }

    @Override // v2.y
    public synchronized void a(int i7) {
        if (i7 >= 10 && i7 != 20) {
            e();
        }
    }

    @Override // v2.y
    public synchronized p.a b(m mVar) {
        try {
            M5.m.e(mVar, "key");
            ArrayList arrayList = (ArrayList) this.f22979a.get(mVar);
            b bVar = null;
            if (arrayList == null) {
                return null;
            }
            int size = arrayList.size() - 1;
            if (size >= 0) {
                int i7 = 0;
                while (true) {
                    int i8 = i7 + 1;
                    c cVar = (c) arrayList.get(i7);
                    Bitmap bitmap = (Bitmap) cVar.a().get();
                    b bVar2 = bitmap == null ? null : new b(bitmap, cVar.d());
                    if (bVar2 != null) {
                        bVar = bVar2;
                        break;
                    }
                    if (i8 > size) {
                        break;
                    }
                    i7 = i8;
                }
            }
            f();
            return bVar;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // v2.y
    public synchronized boolean c(Bitmap bitmap) {
        boolean z7;
        try {
            M5.m.e(bitmap, "bitmap");
            int iIdentityHashCode = System.identityHashCode(bitmap);
            Collection collectionValues = g().values();
            M5.m.d(collectionValues, "cache.values");
            Iterator it = collectionValues.iterator();
            loop0: while (true) {
                z7 = false;
                int i7 = 0;
                if (!it.hasNext()) {
                    break;
                }
                ArrayList arrayList = (ArrayList) it.next();
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i8 = i7 + 1;
                        if (((c) arrayList.get(i7)).b() == iIdentityHashCode) {
                            arrayList.remove(i7);
                            z7 = true;
                            break loop0;
                        }
                        if (i8 > size) {
                            break;
                        }
                        i7 = i8;
                    }
                }
            }
            f();
        } catch (Throwable th) {
            throw th;
        }
        return z7;
    }

    @Override // v2.y
    public synchronized void d(m mVar, Bitmap bitmap, boolean z7, int i7) {
        try {
            M5.m.e(mVar, "key");
            M5.m.e(bitmap, "bitmap");
            HashMap map = this.f22979a;
            Object arrayList = map.get(mVar);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(mVar, arrayList);
            }
            ArrayList arrayList2 = (ArrayList) arrayList;
            int iIdentityHashCode = System.identityHashCode(bitmap);
            c cVar = new c(iIdentityHashCode, new WeakReference(bitmap), z7, i7);
            int size = arrayList2.size() - 1;
            if (size >= 0) {
                int i8 = 0;
                while (true) {
                    int i9 = i8 + 1;
                    Object obj = arrayList2.get(i8);
                    M5.m.d(obj, "values[index]");
                    c cVar2 = (c) obj;
                    if (i7 >= cVar2.c()) {
                        if (cVar2.b() == iIdentityHashCode && cVar2.a().get() == bitmap) {
                            arrayList2.set(i8, cVar);
                        } else {
                            arrayList2.add(i8, cVar);
                        }
                    } else if (i9 > size) {
                        break;
                    } else {
                        i8 = i9;
                    }
                }
            } else {
                arrayList2.add(cVar);
            }
            f();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void e() {
        this.f22980b = 0;
        Iterator it = this.f22979a.values().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            M5.m.d(next, "iterator.next()");
            ArrayList arrayList = (ArrayList) next;
            if (arrayList.size() <= 1) {
                c cVar = (c) C1889w.G(arrayList);
                if ((cVar == null ? null : (Bitmap) cVar.a().get()) == null) {
                    it.remove();
                }
            } else {
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    int i7 = 0;
                    int i8 = 0;
                    while (true) {
                        int i9 = i7 + 1;
                        int i10 = i7 - i8;
                        if (((c) arrayList.get(i10)).a().get() == null) {
                            arrayList.remove(i10);
                            i8++;
                        }
                        if (i9 > size) {
                            break;
                        } else {
                            i7 = i9;
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    it.remove();
                }
            }
        }
    }

    public final void f() {
        int i7 = this.f22980b;
        this.f22980b = i7 + 1;
        if (i7 >= 10) {
            e();
        }
    }

    public final HashMap g() {
        return this.f22979a;
    }
}
