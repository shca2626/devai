package h6;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class d implements g6.a {

    /* renamed from: a, reason: collision with root package name */
    public int f16914a = -1;

    @Override // g6.a
    public List a() {
        return Collections.singletonList("com.oppo.launcher");
    }

    @Override // g6.a
    public void b(Context context, ComponentName componentName, int i7) {
        if (this.f16914a == i7) {
            return;
        }
        this.f16914a = i7;
        c(context, i7);
    }

    public final void c(Context context, int i7) {
        Bundle bundle = new Bundle();
        bundle.putInt("app_badge_count", i7);
        context.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (String) null, bundle);
    }
}
