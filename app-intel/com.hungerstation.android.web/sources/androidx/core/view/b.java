package androidx.core.view;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes7.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6656a;

    /* renamed from: b, reason: collision with root package name */
    private a f6657b;

    /* renamed from: c, reason: collision with root package name */
    private InterfaceC0125b f6658c;

    public interface a {
    }

    /* renamed from: androidx.core.view.b$b, reason: collision with other inner class name */
    public interface InterfaceC0125b {
        void onActionProviderVisibilityChanged(boolean z12);
    }

    public b(Context context) {
        this.f6656a = context;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public View d(MenuItem menuItem) {
        return c();
    }

    public boolean e() {
        return false;
    }

    public void f(SubMenu subMenu) {
    }

    public boolean g() {
        return false;
    }

    public void h() {
        this.f6658c = null;
        this.f6657b = null;
    }

    public void i(a aVar) {
        this.f6657b = aVar;
    }

    public void j(InterfaceC0125b interfaceC0125b) {
        if (this.f6658c != null && interfaceC0125b != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            sb2.append(getClass().getSimpleName());
            sb2.append(" instance while it is still in use somewhere else?");
        }
        this.f6658c = interfaceC0125b;
    }
}
