package p2;

import M5.m;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import v2.y;
import y.l;

/* loaded from: classes.dex */
public final class i implements InterfaceC1441c {

    /* renamed from: e, reason: collision with root package name */
    public static final a f20770e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public static final Handler f20771f = new Handler(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    public final y f20772a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC1439a f20773b;

    /* renamed from: c, reason: collision with root package name */
    public final l f20774c;

    /* renamed from: d, reason: collision with root package name */
    public int f20775d;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public a() {
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f20776a;

        /* renamed from: b, reason: collision with root package name */
        public int f20777b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f20778c;

        public b(WeakReference weakReference, int i7, boolean z7) {
            m.e(weakReference, "bitmap");
            this.f20776a = weakReference;
            this.f20777b = i7;
            this.f20778c = z7;
        }

        public final WeakReference a() {
            return this.f20776a;
        }

        public final int b() {
            return this.f20777b;
        }

        public final boolean c() {
            return this.f20778c;
        }

        public final void d(int i7) {
            this.f20777b = i7;
        }

        public final void e(boolean z7) {
            this.f20778c = z7;
        }
    }

    public i(y yVar, InterfaceC1439a interfaceC1439a, C2.l lVar) {
        m.e(yVar, "weakMemoryCache");
        m.e(interfaceC1439a, "bitmapPool");
        this.f20772a = yVar;
        this.f20773b = interfaceC1439a;
        this.f20774c = new l();
    }

    public static final void g(i iVar, Bitmap bitmap) {
        m.e(iVar, "this$0");
        m.e(bitmap, "$bitmap");
        iVar.f20773b.b(bitmap);
    }

    @Override // p2.InterfaceC1441c
    public synchronized void a(Bitmap bitmap, boolean z7) {
        try {
            m.e(bitmap, "bitmap");
            int iIdentityHashCode = System.identityHashCode(bitmap);
            if (!z7) {
                h(iIdentityHashCode, bitmap).e(false);
            } else if (i(iIdentityHashCode, bitmap) == null) {
                this.f20774c.k(iIdentityHashCode, new b(new WeakReference(bitmap), 0, true));
            }
            f();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // p2.InterfaceC1441c
    public synchronized boolean b(final Bitmap bitmap) {
        try {
            m.e(bitmap, "bitmap");
            int iIdentityHashCode = System.identityHashCode(bitmap);
            b bVarI = i(iIdentityHashCode, bitmap);
            boolean z7 = false;
            if (bVarI == null) {
                return false;
            }
            bVarI.d(bVarI.b() - 1);
            if (bVarI.b() <= 0 && bVarI.c()) {
                z7 = true;
            }
            if (z7) {
                this.f20774c.l(iIdentityHashCode);
                this.f20772a.c(bitmap);
                f20771f.post(new Runnable() { // from class: p2.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.g(this.f20768l, bitmap);
                    }
                });
            }
            f();
            return z7;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // p2.InterfaceC1441c
    public synchronized void c(Bitmap bitmap) {
        m.e(bitmap, "bitmap");
        b bVarH = h(System.identityHashCode(bitmap), bitmap);
        bVarH.d(bVarH.b() + 1);
        f();
    }

    public final void e() {
        ArrayList arrayList = new ArrayList();
        int iN = this.f20774c.n();
        int i7 = 0;
        if (iN > 0) {
            int i8 = 0;
            while (true) {
                int i9 = i8 + 1;
                if (((b) this.f20774c.o(i8)).a().get() == null) {
                    arrayList.add(Integer.valueOf(i8));
                }
                if (i9 >= iN) {
                    break;
                } else {
                    i8 = i9;
                }
            }
        }
        l lVar = this.f20774c;
        int size = arrayList.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i10 = i7 + 1;
            lVar.m(((Number) arrayList.get(i7)).intValue());
            if (i10 > size) {
                return;
            } else {
                i7 = i10;
            }
        }
    }

    public final void f() {
        int i7 = this.f20775d;
        this.f20775d = i7 + 1;
        if (i7 >= 50) {
            e();
        }
    }

    public final b h(int i7, Bitmap bitmap) {
        b bVarI = i(i7, bitmap);
        if (bVarI != null) {
            return bVarI;
        }
        b bVar = new b(new WeakReference(bitmap), 0, false);
        this.f20774c.k(i7, bVar);
        return bVar;
    }

    public final b i(int i7, Bitmap bitmap) {
        b bVar = (b) this.f20774c.f(i7);
        if (bVar != null && bVar.a().get() == bitmap) {
            return bVar;
        }
        return null;
    }
}
