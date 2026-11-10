package h6;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class a implements g6.a {
    @Override // g6.a
    public List a() {
        return Arrays.asList("com.asus.launcher");
    }

    @Override // g6.a
    public void b(Context context, ComponentName componentName, int i7) throws g6.b {
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", i7);
        intent.putExtra("badge_count_package_name", componentName.getPackageName());
        intent.putExtra("badge_count_class_name", componentName.getClassName());
        intent.putExtra("badge_vip_count", 0);
        i6.a.b(context, intent);
    }
}
