package q;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import c0.AbstractC0895g;

/* renamed from: q.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1481s extends PopupWindow {

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f21340b = false;

    /* renamed from: a, reason: collision with root package name */
    public boolean f21341a;

    public C1481s(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        a(context, attributeSet, i7, i8);
    }

    public final void a(Context context, AttributeSet attributeSet, int i7, int i8) {
        d0 d0VarV = d0.v(context, attributeSet, i.j.f17219Y1, i7, i8);
        if (d0VarV.s(i.j.f17228a2)) {
            b(d0VarV.a(i.j.f17228a2, false));
        }
        setBackgroundDrawable(d0VarV.g(i.j.f17223Z1));
        d0VarV.w();
    }

    public final void b(boolean z7) {
        if (f21340b) {
            this.f21341a = z7;
        } else {
            AbstractC0895g.a(this, z7);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i7, int i8) {
        if (f21340b && this.f21341a) {
            i8 -= view.getHeight();
        }
        super.showAsDropDown(view, i7, i8);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i7, int i8, int i9, int i10) {
        if (f21340b && this.f21341a) {
            i8 -= view.getHeight();
        }
        super.update(view, i7, i8, i9, i10);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i7, int i8, int i9) {
        if (f21340b && this.f21341a) {
            i8 -= view.getHeight();
        }
        super.showAsDropDown(view, i7, i8, i9);
    }
}
