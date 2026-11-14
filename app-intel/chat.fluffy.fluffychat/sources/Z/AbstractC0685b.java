package Z;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: Z.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0685b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f9995a;

    /* renamed from: b, reason: collision with root package name */
    public a f9996b;

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC0084b f9997c;

    /* renamed from: Z.b$a */
    public interface a {
    }

    /* renamed from: Z.b$b, reason: collision with other inner class name */
    public interface InterfaceC0084b {
        void onActionProviderVisibilityChanged(boolean z7);
    }

    public AbstractC0685b(Context context) {
        this.f9995a = context;
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract View c(MenuItem menuItem);

    public abstract boolean d();

    public abstract void e(SubMenu subMenu);

    public abstract boolean f();

    public void g() {
        this.f9997c = null;
        this.f9996b = null;
    }

    public void h(a aVar) {
        this.f9996b = aVar;
    }

    public abstract void i(InterfaceC0084b interfaceC0084b);
}
