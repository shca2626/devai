package l0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import m0.C1319a;

/* renamed from: l0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1296e {

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f19518d = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    public final int f19519a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.emoji2.text.f f19520b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f19521c = 0;

    public C1296e(androidx.emoji2.text.f fVar, int i7) {
        this.f19520b = fVar;
        this.f19519a = i7;
    }

    public void a(Canvas canvas, float f7, float f8, Paint paint) {
        Typeface typefaceG = this.f19520b.g();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(typefaceG);
        canvas.drawText(this.f19520b.c(), this.f19519a * 2, 2, f7, f8, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i7) {
        return g().h(i7);
    }

    public int c() {
        return g().i();
    }

    public int d() {
        return this.f19521c;
    }

    public short e() {
        return g().k();
    }

    public int f() {
        return g().l();
    }

    public final C1319a g() {
        ThreadLocal threadLocal = f19518d;
        C1319a c1319a = (C1319a) threadLocal.get();
        if (c1319a == null) {
            c1319a = new C1319a();
            threadLocal.set(c1319a);
        }
        this.f19520b.d().j(c1319a, this.f19519a);
        return c1319a;
    }

    public short h() {
        return g().m();
    }

    public short i() {
        return g().n();
    }

    public boolean j() {
        return g().j();
    }

    public void k(boolean z7) {
        this.f19521c = z7 ? 2 : 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(f()));
        sb.append(", codepoints:");
        int iC = c();
        for (int i7 = 0; i7 < iC; i7++) {
            sb.append(Integer.toHexString(b(i7)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
