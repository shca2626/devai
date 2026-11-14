package d;

import android.os.Build;
import android.window.BackEvent;

/* renamed from: d.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0960e {

    /* renamed from: f, reason: collision with root package name */
    public static final a f15034f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final float f15035a;

    /* renamed from: b, reason: collision with root package name */
    public final float f15036b;

    /* renamed from: c, reason: collision with root package name */
    public final float f15037c;

    /* renamed from: d, reason: collision with root package name */
    public final int f15038d;

    /* renamed from: e, reason: collision with root package name */
    public final long f15039e;

    /* renamed from: d.e$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public a() {
        }
    }

    public C0960e(float f7, float f8, float f9, int i7, long j7) {
        this.f15035a = f7;
        this.f15036b = f8;
        this.f15037c = f9;
        this.f15038d = i7;
        this.f15039e = j7;
    }

    public final float a() {
        return this.f15037c;
    }

    public final BackEvent b() {
        if (Build.VERSION.SDK_INT >= 36) {
            AbstractC0959d.a();
            return AbstractC0957b.a(this.f15035a, this.f15036b, this.f15037c, this.f15038d, this.f15039e);
        }
        AbstractC0959d.a();
        return AbstractC0958c.a(this.f15035a, this.f15036b, this.f15037c, this.f15038d);
    }

    public String toString() {
        return "BackEventCompat(touchX=" + this.f15035a + ", touchY=" + this.f15036b + ", progress=" + this.f15037c + ", swipeEdge=" + this.f15038d + ", frameTimeMillis=" + this.f15039e + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0960e(Q1.b bVar) {
        this(bVar.d(), bVar.e(), bVar.b(), bVar.c(), bVar.a());
        M5.m.e(bVar, "navigationEvent");
    }
}
