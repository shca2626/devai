package h6;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class c implements g6.a {
    @Override // g6.a
    public List a() {
        return Arrays.asList("com.huawei.android.launcher");
    }

    @Override // g6.a
    public void b(Context context, ComponentName componentName, int i7) {
        Bundle bundle = new Bundle();
        bundle.putString("package", context.getPackageName());
        bundle.putString("class", componentName.getClassName());
        bundle.putInt("badgenumber", i7);
        context.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
    }
}
