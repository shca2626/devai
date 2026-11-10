package h6;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class h implements g6.a {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f16917a = Uri.parse("content://com.android.badge/badge");

    @Override // g6.a
    public List a() {
        return Collections.singletonList("com.zui.launcher");
    }

    @Override // g6.a
    public void b(Context context, ComponentName componentName, int i7) {
        Bundle bundle = new Bundle();
        bundle.putInt("app_badge_count", i7);
        context.getContentResolver().call(this.f16917a, "setAppBadgeCount", (String) null, bundle);
    }
}
