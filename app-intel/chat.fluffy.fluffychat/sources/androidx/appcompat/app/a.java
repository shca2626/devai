package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertController;
import i.AbstractC1146a;
import j.p;

/* loaded from: classes.dex */
public class a extends p implements DialogInterface {

    /* renamed from: r, reason: collision with root package name */
    public final AlertController f11073r;

    /* renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    public static class C0096a {

        /* renamed from: a, reason: collision with root package name */
        public final AlertController.b f11074a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11075b;

        public C0096a(Context context) {
            this(context, a.r(context, 0));
        }

        public a a() {
            a aVar = new a(this.f11074a.f11034a, this.f11075b);
            this.f11074a.a(aVar.f11073r);
            aVar.setCancelable(this.f11074a.f11051r);
            if (this.f11074a.f11051r) {
                aVar.setCanceledOnTouchOutside(true);
            }
            aVar.setOnCancelListener(this.f11074a.f11052s);
            aVar.setOnDismissListener(this.f11074a.f11053t);
            DialogInterface.OnKeyListener onKeyListener = this.f11074a.f11054u;
            if (onKeyListener != null) {
                aVar.setOnKeyListener(onKeyListener);
            }
            return aVar;
        }

        public Context b() {
            return this.f11074a.f11034a;
        }

        public C0096a c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f11074a;
            bVar.f11056w = listAdapter;
            bVar.f11057x = onClickListener;
            return this;
        }

        public C0096a d(View view) {
            this.f11074a.f11040g = view;
            return this;
        }

        public C0096a e(Drawable drawable) {
            this.f11074a.f11037d = drawable;
            return this;
        }

        public C0096a f(CharSequence charSequence) {
            this.f11074a.f11041h = charSequence;
            return this;
        }

        public C0096a g(int i7, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f11074a;
            bVar.f11045l = bVar.f11034a.getText(i7);
            this.f11074a.f11047n = onClickListener;
            return this;
        }

        public C0096a h(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f11074a;
            bVar.f11045l = charSequence;
            bVar.f11047n = onClickListener;
            return this;
        }

        public C0096a i(DialogInterface.OnKeyListener onKeyListener) {
            this.f11074a.f11054u = onKeyListener;
            return this;
        }

        public C0096a j(int i7, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f11074a;
            bVar.f11042i = bVar.f11034a.getText(i7);
            this.f11074a.f11044k = onClickListener;
            return this;
        }

        public C0096a k(ListAdapter listAdapter, int i7, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f11074a;
            bVar.f11056w = listAdapter;
            bVar.f11057x = onClickListener;
            bVar.f11027I = i7;
            bVar.f11026H = true;
            return this;
        }

        public C0096a l(CharSequence charSequence) {
            this.f11074a.f11039f = charSequence;
            return this;
        }

        public C0096a m(View view) {
            AlertController.b bVar = this.f11074a;
            bVar.f11059z = view;
            bVar.f11058y = 0;
            bVar.f11023E = false;
            return this;
        }

        public C0096a(Context context, int i7) {
            this.f11074a = new AlertController.b(new ContextThemeWrapper(context, a.r(context, i7)));
            this.f11075b = i7;
        }
    }

    public a(Context context, int i7) {
        super(context, r(context, i7));
        this.f11073r = new AlertController(getContext(), this, getWindow());
    }

    public static int r(Context context, int i7) {
        if (((i7 >>> 24) & 255) >= 1) {
            return i7;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(AbstractC1146a.f16941l, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // j.p, d.DialogC0947B, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11073r.e();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i7, KeyEvent keyEvent) {
        if (this.f11073r.f(i7, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i7, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i7, KeyEvent keyEvent) {
        if (this.f11073r.g(i7, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i7, keyEvent);
    }

    public ListView q() {
        return this.f11073r.d();
    }

    @Override // j.p, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f11073r.p(charSequence);
    }
}
