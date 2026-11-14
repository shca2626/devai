package j;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import o.AbstractC1378b;

/* renamed from: j.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1209a {
    public boolean f() {
        return false;
    }

    public boolean g() {
        return false;
    }

    public abstract int i();

    public Context j() {
        return null;
    }

    public boolean k() {
        return false;
    }

    public boolean n(int i7, KeyEvent keyEvent) {
        return false;
    }

    public boolean o(KeyEvent keyEvent) {
        return false;
    }

    public boolean p() {
        return false;
    }

    public AbstractC1378b t(AbstractC1378b.a aVar) {
        return null;
    }

    /* renamed from: j.a$a, reason: collision with other inner class name */
    public static class C0203a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f18466a;

        public C0203a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f18466a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.j.f17320t);
            this.f18466a = typedArrayObtainStyledAttributes.getInt(i.j.f17325u, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public C0203a(int i7, int i8) {
            super(i7, i8);
            this.f18466a = 8388627;
        }

        public C0203a(C0203a c0203a) {
            super((ViewGroup.MarginLayoutParams) c0203a);
            this.f18466a = 0;
            this.f18466a = c0203a.f18466a;
        }

        public C0203a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f18466a = 0;
        }
    }

    public void m() {
    }

    public void h(boolean z7) {
    }

    public void l(Configuration configuration) {
    }

    public void q(boolean z7) {
    }

    public void r(boolean z7) {
    }

    public void s(CharSequence charSequence) {
    }
}
