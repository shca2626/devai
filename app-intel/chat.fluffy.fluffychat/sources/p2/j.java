package p2;

import C2.n;
import M5.m;
import android.graphics.Bitmap;
import java.util.TreeMap;
import q2.C1493a;
import z5.C1866G;

/* loaded from: classes.dex */
public final class j implements InterfaceC1439b {

    /* renamed from: d, reason: collision with root package name */
    public static final a f20785d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final C1493a f20786b = new C1493a();

    /* renamed from: c, reason: collision with root package name */
    public final TreeMap f20787c = new TreeMap();

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public a() {
        }
    }

    public final void a(int i7) {
        int iIntValue = ((Number) C1866G.i(this.f20787c, Integer.valueOf(i7))).intValue();
        if (iIntValue == 1) {
            this.f20787c.remove(Integer.valueOf(i7));
        } else {
            this.f20787c.put(Integer.valueOf(i7), Integer.valueOf(iIntValue - 1));
        }
    }

    @Override // p2.InterfaceC1439b
    public void b(Bitmap bitmap) {
        m.e(bitmap, "bitmap");
        int iA = C2.a.a(bitmap);
        this.f20786b.d(Integer.valueOf(iA), bitmap);
        Integer num = (Integer) this.f20787c.get(Integer.valueOf(iA));
        this.f20787c.put(Integer.valueOf(iA), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // p2.InterfaceC1439b
    public Bitmap c(int i7, int i8, Bitmap.Config config) {
        m.e(config, "config");
        int iA = n.f1343a.a(i7, i8, config);
        Integer num = (Integer) this.f20787c.ceilingKey(Integer.valueOf(iA));
        if (num != null) {
            if (num.intValue() > iA * 4) {
                num = null;
            }
            if (num != null) {
                iA = num.intValue();
            }
        }
        Bitmap bitmap = (Bitmap) this.f20786b.g(Integer.valueOf(iA));
        if (bitmap != null) {
            a(iA);
            bitmap.reconfigure(i7, i8, config);
        }
        return bitmap;
    }

    @Override // p2.InterfaceC1439b
    public Bitmap removeLast() {
        Bitmap bitmap = (Bitmap) this.f20786b.f();
        if (bitmap != null) {
            a(bitmap.getAllocationByteCount());
        }
        return bitmap;
    }

    public String toString() {
        return "SizeStrategy: entries=" + this.f20786b + ", sizes=" + this.f20787c;
    }
}
