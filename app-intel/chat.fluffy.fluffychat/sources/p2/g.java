package p2;

import C2.l;
import M5.m;
import android.graphics.Bitmap;
import android.os.Build;
import java.util.HashSet;
import java.util.Set;
import z5.C1864H;

/* loaded from: classes.dex */
public final class g implements InterfaceC1439a {

    /* renamed from: j, reason: collision with root package name */
    public static final a f20757j = new a(null);

    /* renamed from: k, reason: collision with root package name */
    public static final Set f20758k;

    /* renamed from: a, reason: collision with root package name */
    public final int f20759a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f20760b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC1440b f20761c;

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f20762d;

    /* renamed from: e, reason: collision with root package name */
    public int f20763e;

    /* renamed from: f, reason: collision with root package name */
    public int f20764f;

    /* renamed from: g, reason: collision with root package name */
    public int f20765g;

    /* renamed from: h, reason: collision with root package name */
    public int f20766h;

    /* renamed from: i, reason: collision with root package name */
    public int f20767i;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public a() {
        }
    }

    static {
        Set setB = C1864H.b();
        setB.add(Bitmap.Config.ALPHA_8);
        setB.add(Bitmap.Config.RGB_565);
        setB.add(Bitmap.Config.ARGB_4444);
        setB.add(Bitmap.Config.ARGB_8888);
        if (Build.VERSION.SDK_INT >= 26) {
            setB.add(Bitmap.Config.RGBA_F16);
        }
        f20758k = C1864H.a(setB);
    }

    public g(int i7, Set set, InterfaceC1440b interfaceC1440b, l lVar) {
        m.e(set, "allowedConfigs");
        m.e(interfaceC1440b, "strategy");
        this.f20759a = i7;
        this.f20760b = set;
        this.f20761c = interfaceC1440b;
        this.f20762d = new HashSet();
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException("maxSize must be >= 0.");
        }
    }

    @Override // p2.InterfaceC1439a
    public synchronized void a(int i7) {
        try {
            if (i7 >= 40) {
                e();
            } else if (10 <= i7 && i7 < 20) {
                i(this.f20763e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // p2.InterfaceC1439a
    public synchronized void b(Bitmap bitmap) {
        m.e(bitmap, "bitmap");
        if (bitmap.isRecycled()) {
            return;
        }
        int iA = C2.a.a(bitmap);
        if (bitmap.isMutable() && iA <= this.f20759a && this.f20760b.contains(bitmap.getConfig())) {
            if (this.f20762d.contains(bitmap)) {
                return;
            }
            this.f20761c.b(bitmap);
            this.f20762d.add(bitmap);
            this.f20763e += iA;
            this.f20766h++;
            i(this.f20759a);
            return;
        }
        bitmap.recycle();
    }

    @Override // p2.InterfaceC1439a
    public Bitmap c(int i7, int i8, Bitmap.Config config) {
        m.e(config, "config");
        Bitmap bitmapG = g(i7, i8, config);
        if (bitmapG != null) {
            return bitmapG;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i7, i8, config);
        m.d(bitmapCreateBitmap, "createBitmap(width, height, config)");
        return bitmapCreateBitmap;
    }

    @Override // p2.InterfaceC1439a
    public Bitmap d(int i7, int i8, Bitmap.Config config) {
        m.e(config, "config");
        Bitmap bitmapF = f(i7, i8, config);
        if (bitmapF != null) {
            return bitmapF;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i7, i8, config);
        m.d(bitmapCreateBitmap, "createBitmap(width, height, config)");
        return bitmapCreateBitmap;
    }

    public final void e() {
        i(-1);
    }

    public synchronized Bitmap f(int i7, int i8, Bitmap.Config config) {
        Bitmap bitmapC;
        try {
            m.e(config, "config");
            if (C2.a.d(config)) {
                throw new IllegalArgumentException("Cannot create a mutable hardware bitmap.");
            }
            bitmapC = this.f20761c.c(i7, i8, config);
            if (bitmapC == null) {
                this.f20765g++;
            } else {
                this.f20762d.remove(bitmapC);
                this.f20763e -= C2.a.a(bitmapC);
                this.f20764f++;
                h(bitmapC);
            }
        } catch (Throwable th) {
            throw th;
        }
        return bitmapC;
    }

    public Bitmap g(int i7, int i8, Bitmap.Config config) {
        m.e(config, "config");
        Bitmap bitmapF = f(i7, i8, config);
        if (bitmapF == null) {
            return null;
        }
        bitmapF.eraseColor(0);
        return bitmapF;
    }

    public final void h(Bitmap bitmap) {
        bitmap.setDensity(0);
        bitmap.setHasAlpha(true);
        bitmap.setPremultiplied(true);
    }

    public final synchronized void i(int i7) {
        while (this.f20763e > i7) {
            Bitmap bitmapRemoveLast = this.f20761c.removeLast();
            if (bitmapRemoveLast == null) {
                this.f20763e = 0;
                return;
            }
            this.f20762d.remove(bitmapRemoveLast);
            this.f20763e -= C2.a.a(bitmapRemoveLast);
            this.f20767i++;
            bitmapRemoveLast.recycle();
        }
    }

    public /* synthetic */ g(int i7, Set set, InterfaceC1440b interfaceC1440b, l lVar, int i8, M5.g gVar) {
        this(i7, (i8 & 2) != 0 ? f20758k : set, (i8 & 4) != 0 ? InterfaceC1440b.f20754a.a() : interfaceC1440b, (i8 & 8) != 0 ? null : lVar);
    }
}
