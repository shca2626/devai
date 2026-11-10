package p2;

import C2.n;
import M5.m;
import android.graphics.Bitmap;
import java.util.TreeMap;
import q2.C1494a;
import z5.C1863G;

/* loaded from: classes.dex */
public final class j implements InterfaceC1440b {

    /* renamed from: d, reason: collision with root package name */
    public static final a f20779d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final C1494a f20780b = new C1494a();

    /* renamed from: c, reason: collision with root package name */
    public final TreeMap f20781c = new TreeMap();

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public a() {
        }
    }

    public final void a(int i7) {
        int iIntValue = ((Number) C1863G.i(this.f20781c, Integer.valueOf(i7))).intValue();
        if (iIntValue == 1) {
            this.f20781c.remove(Integer.valueOf(i7));
        } else {
            this.f20781c.put(Integer.valueOf(i7), Integer.valueOf(iIntValue - 1));
        }
    }

    @Override // p2.InterfaceC1440b
    public void b(Bitmap bitmap) {
        m.e(bitmap, "bitmap");
        int iA = C2.a.a(bitmap);
        this.f20780b.d(Integer.valueOf(iA), bitmap);
        Integer num = (Integer) this.f20781c.get(Integer.valueOf(iA));
        this.f20781c.put(Integer.valueOf(iA), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // p2.InterfaceC1440b
    public Bitmap c(int i7, int i8, Bitmap.Config config) {
        m.e(config, "config");
        int iA = n.f1343a.a(i7, i8, config);
        Integer num = (Integer) this.f20781c.ceilingKey(Integer.valueOf(iA));
        if (num != null) {
            if (num.intValue() > iA * 4) {
                num = null;
            }
            if (num != null) {
                iA = num.intValue();
            }
        }
        Bitmap bitmap = (Bitmap) this.f20780b.g(Integer.valueOf(iA));
        if (bitmap != null) {
            a(iA);
            bitmap.reconfigure(i7, i8, config);
        }
        return bitmap;
    }

    @Override // p2.InterfaceC1440b
    public Bitmap removeLast() {
        Bitmap bitmap = (Bitmap) this.f20780b.f();
        if (bitmap != null) {
            a(bitmap.getAllocationByteCount());
        }
        return bitmap;
    }

    public String toString() {
        return "SizeStrategy: entries=" + this.f20780b + ", sizes=" + this.f20781c;
    }
}
