package d2;

import M5.x;
import android.util.Log;
import androidx.window.extensions.WindowExtensionsProvider;

/* renamed from: d2.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0981e {

    /* renamed from: a, reason: collision with root package name */
    public static final C0981e f15131a = new C0981e();

    /* renamed from: b, reason: collision with root package name */
    public static final String f15132b = x.b(C0981e.class).b();

    public final int a() {
        try {
            return WindowExtensionsProvider.getWindowExtensions().getVendorApiLevel();
        } catch (NoClassDefFoundError unused) {
            if (C0979c.f15123a.a() != EnumC0986j.LOG) {
                return 0;
            }
            Log.d(f15132b, "Embedding extension version not found");
            return 0;
        } catch (UnsupportedOperationException unused2) {
            if (C0979c.f15123a.a() != EnumC0986j.LOG) {
                return 0;
            }
            Log.d(f15132b, "Stub Extension");
            return 0;
        }
    }
}
