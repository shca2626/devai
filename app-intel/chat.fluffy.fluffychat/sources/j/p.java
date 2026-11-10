package j;

import Z.AbstractC0719w;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import d.DialogC0946B;
import i.AbstractC1145a;
import o.AbstractC1379b;

/* loaded from: classes.dex */
public abstract class p extends DialogC0946B implements InterfaceC1212c {

    /* renamed from: p, reason: collision with root package name */
    public AbstractC1214e f18583p;

    /* renamed from: q, reason: collision with root package name */
    public final AbstractC0719w.a f18584q;

    public p(Context context, int i7) {
        super(context, n(context, i7));
        this.f18584q = new AbstractC0719w.a() { // from class: j.o
            @Override // Z.AbstractC0719w.a
            public final boolean Q(KeyEvent keyEvent) {
                return this.f18582l.o(keyEvent);
            }
        };
        AbstractC1214e abstractC1214eM = m();
        abstractC1214eM.K(n(context, i7));
        abstractC1214eM.w(null);
    }

    public static int n(Context context, int i7) {
        if (i7 != 0) {
            return i7;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(AbstractC1145a.f16952w, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // j.InterfaceC1212c
    public AbstractC1379b A(AbstractC1379b.a aVar) {
        return null;
    }

    @Override // d.DialogC0946B, android.app.Dialog
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
        return AbstractC0719w.e(this.f18584q, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public View findViewById(int i7) {
        return m().j(i7);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        m().t();
    }

    public AbstractC1214e m() {
        if (this.f18583p == null) {
            this.f18583p = AbstractC1214e.i(this, this);
        }
        return this.f18583p;
    }

    public boolean o(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // d.DialogC0946B, android.app.Dialog
    public void onCreate(Bundle bundle) {
        m().s();
        super.onCreate(bundle);
        m().w(bundle);
    }

    @Override // d.DialogC0946B, android.app.Dialog
    public void onStop() {
        super.onStop();
        m().C();
    }

    public boolean p(int i7) {
        return m().F(i7);
    }

    @Override // d.DialogC0946B, android.app.Dialog
    public void setContentView(int i7) {
        m().G(i7);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        m().L(charSequence);
    }

    @Override // d.DialogC0946B, android.app.Dialog
    public void setContentView(View view) {
        m().H(view);
    }

    @Override // d.DialogC0946B, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m().I(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i7) {
        super.setTitle(i7);
        m().L(getContext().getString(i7));
    }

    @Override // j.InterfaceC1212c
    public void E(AbstractC1379b abstractC1379b) {
    }

    @Override // j.InterfaceC1212c
    public void Y(AbstractC1379b abstractC1379b) {
    }
}
