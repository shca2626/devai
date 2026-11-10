package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    public int f13425b;

    /* renamed from: c, reason: collision with root package name */
    public int f13426c;

    /* renamed from: d, reason: collision with root package name */
    public int f13427d;

    /* renamed from: e, reason: collision with root package name */
    public int f13428e;

    /* renamed from: h, reason: collision with root package name */
    public boolean f13431h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f13432i;

    /* renamed from: a, reason: collision with root package name */
    public boolean f13424a = true;

    /* renamed from: f, reason: collision with root package name */
    public int f13429f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f13430g = 0;

    public boolean a(RecyclerView.z zVar) {
        int i7 = this.f13426c;
        return i7 >= 0 && i7 < zVar.b();
    }

    public View b(RecyclerView.u uVar) {
        View viewO = uVar.o(this.f13426c);
        this.f13426c += this.f13427d;
        return viewO;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f13425b + ", mCurrentPosition=" + this.f13426c + ", mItemDirection=" + this.f13427d + ", mLayoutDirection=" + this.f13428e + ", mStartLine=" + this.f13429f + ", mEndLine=" + this.f13430g + '}';
    }
}
