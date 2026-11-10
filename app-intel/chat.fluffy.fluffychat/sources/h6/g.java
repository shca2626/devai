package h6;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class g implements g6.a {
    @Override // g6.a
    public List a() {
        return new ArrayList(0);
    }

    @Override // g6.a
    public void b(Context context, ComponentName componentName, int i7) {
        Bundle bundle = new Bundle();
        bundle.putInt("app_badge_count", i7);
        bundle.putString("app_badge_component_name", componentName.flattenToString());
        context.getContentResolver().call(Uri.parse("content://com.android.launcher3.cornermark.unreadbadge"), "setAppUnreadCount", (String) null, bundle);
    }
}
