package j;

import Z.AbstractC0720w;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import d.DialogC0947B;
import i.AbstractC1146a;
import o.AbstractC1378b;

/* loaded from: classes.dex */
public abstract class p extends DialogC0947B implements InterfaceC1211c {

    /* renamed from: p, reason: collision with root package name */
    public AbstractC1213e f18582p;

    /* renamed from: q, reason: collision with root package name */
    public final AbstractC0720w.a f18583q;

    public p(Context context, int i7) {
        super(context, n(context, i7));
        this.f18583q = new AbstractC0720w.a() { // from class: j.o
            @Override // Z.AbstractC0720w.a
            public final boolean Q(KeyEvent keyEvent) {
                return this.f18581l.o(keyEvent);
            }
        };
        AbstractC1213e abstractC1213eM = m();
        abstractC1213eM.K(n(context, i7));
        abstractC1213eM.w(null);
    }

    public static int n(Context context, int i7) {
        if (i7 != 0) {
            return i7;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(AbstractC1146a.f16952w, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // j.InterfaceC1211c
    public AbstractC1378b A(AbstractC1378b.a aVar) {
        return null;
    }

    @Override // d.DialogC0947B, android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m().e(view, layoutParams);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        m().x();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return AbstractC0720w.e(this.f18583q, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public View findViewById(int i7) {
        return m().j(i7);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        m().t();
    }

    public AbstractC1213e m() {
        if (this.f18582p == null) {
            this.f18582p = AbstractC1213e.i(this, this);
        }
        return this.f18582p;
    }

    public boolean o(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // d.DialogC0947B, android.app.Dialog
    public void onCreate(Bundle bundle) {
        m().s();
        super.onCreate(bundle);
        m().w(bundle);
    }

    @Override // d.DialogC0947B, android.app.Dialog
    public void onStop() {
        super.onStop();
        m().C();
    }

    public boolean p(int i7) {
        return m().F(i7);
    }

    @Override // d.DialogC0947B, android.app.Dialog
    public void setContentView(int i7) {
        m().G(i7);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        m().L(charSequence);
    }

    @Override // d.DialogC0947B, android.app.Dialog
    public void setContentView(View view) {
        m().H(view);
    }

    @Override // d.DialogC0947B, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m().I(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i7) {
        super.setTitle(i7);
        m().L(getContext().getString(i7));
    }

    @Override // j.InterfaceC1211c
    public void E(AbstractC1378b abstractC1378b) {
    }

    @Override // j.InterfaceC1211c
    public void Y(AbstractC1378b abstractC1378b) {
    }
}
