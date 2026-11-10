package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import g6.a;
import g6.b;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class DefaultBadger implements a {
    @Override // g6.a
    public List a() {
        return Arrays.asList("fr.neamar.kiss", "com.quaap.launchtime", "com.quaap.launchtime_official");
    }

    @Override // g6.a
    public void b(Context context, ComponentName componentName, int i7) throws b {
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", i7);
        intent.putExtra("badge_count_package_name", componentName.getPackageName());
        intent.putExtra("badge_count_class_name", componentName.getClassName());
        i6.a.b(context, intent);
    }

    public boolean c(Context context) {
        if (i6.a.a(context, new Intent("android.intent.action.BADGE_COUNT_UPDATE")).size() <= 0) {
            return Build.VERSION.SDK_INT >= 26 && i6.a.a(context, new Intent("me.leolin.shortcutbadger.BADGE_COUNT_UPDATE")).size() > 0;
        }
        return true;
    }
}
