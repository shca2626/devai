package o0;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import java.util.Collection;

/* renamed from: o0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1392g {
    public static boolean a(Context context, String str) {
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) context.getSystemService("device_policy");
        return str.equals("com.android.vending") || devicePolicyManager.isDeviceOwnerApp(str) || devicePolicyManager.isProfileOwnerApp(str);
    }

    public static AbstractC1392g b(Context context) {
        return new C1388c(context);
    }

    public abstract void c(Collection collection, InterfaceC1390e interfaceC1390e);
}
