package Q2;

import Z.W;
import android.view.View;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final View f7665a;

    /* renamed from: b, reason: collision with root package name */
    public int f7666b;

    /* renamed from: c, reason: collision with root package name */
    public int f7667c;

    /* renamed from: d, reason: collision with root package name */
    public int f7668d;

    /* renamed from: e, reason: collision with root package name */
    public int f7669e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7670f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7671g = true;

    public d(View view) {
        this.f7665a = view;
    }

    public void a() {
        View view = this.f7665a;
        W.W(view, this.f7668d - (view.getTop() - this.f7666b));
        View view2 = this.f7665a;
        W.V(view2, this.f7669e - (view2.getLeft() - this.f7667c));
    }

    public int b() {
        return this.f7668d;
    }

    public void c() {
        this.f7666b = this.f7665a.getTop();
        this.f7667c = this.f7665a.getLeft();
    }

    public boolean d(int i7) {
        if (!this.f7671g || this.f7669e == i7) {
            return false;
        }
        this.f7669e = i7;
        a();
        return true;
    }

    public boolean e(int i7) {
        if (!this.f7670f || this.f7668d == i7) {
            return false;
        }
        this.f7668d = i7;
        a();
        return true;
    }
}
