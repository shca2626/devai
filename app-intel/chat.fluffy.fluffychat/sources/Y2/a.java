package Y2;

import O.AbstractC0562a;
import V2.b;
import android.content.Context;
import android.graphics.Color;
import c3.C0902b;

/* loaded from: classes.dex */
public class a {

    /* renamed from: f, reason: collision with root package name */
    public static final int f9856f = (int) Math.round(5.1000000000000005d);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f9857a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9858b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9859c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9860d;

    /* renamed from: e, reason: collision with root package name */
    public final float f9861e;

    public a(Context context) {
        this(C0902b.b(context, O2.a.f6753p, false), b.b(context, O2.a.f6752o, 0), b.b(context, O2.a.f6751n, 0), b.b(context, O2.a.f6748k, 0), context.getResources().getDisplayMetrics().density);
    }

    public float a(float f7) {
        if (this.f9861e <= 0.0f || f7 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f7 / r0)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i7, float f7) {
        int i8;
        float fA = a(f7);
        int iAlpha = Color.alpha(i7);
        int iH = b.h(AbstractC0562a.j(i7, 255), this.f9858b, fA);
        if (fA > 0.0f && (i8 = this.f9859c) != 0) {
            iH = b.g(iH, AbstractC0562a.j(i8, f9856f));
        }
        return AbstractC0562a.j(iH, iAlpha);
    }

    public int c(int i7, float f7) {
        return (this.f9857a && e(i7)) ? b(i7, f7) : i7;
    }

    public boolean d() {
        return this.f9857a;
    }

    public final boolean e(int i7) {
        return AbstractC0562a.j(i7, 255) == this.f9860d;
    }

    public a(boolean z7, int i7, int i8, int i9, float f7) {
        this.f9857a = z7;
        this.f9858b = i7;
        this.f9859c = i8;
        this.f9860d = i9;
        this.f9861e = f7;
    }
}
