package bh1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: classes6.dex */
public class b {
    public static NetworkInfo a(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static boolean b(Context context, boolean z12) {
        if (!z12) {
            return true;
        }
        NetworkInfo networkInfoA = a(context);
        return networkInfoA != null && networkInfoA.isConnected();
    }

    public static boolean c(Context context) {
        NetworkInfo networkInfoA = a(context);
        return networkInfoA != null && networkInfoA.isConnected() && networkInfoA.getType() == 0;
    }

    public static boolean d(Context context) {
        NetworkInfo networkInfoA = a(context);
        return (networkInfoA == null || !networkInfoA.isConnected() || networkInfoA.getType() == 0) ? false : true;
    }
}
