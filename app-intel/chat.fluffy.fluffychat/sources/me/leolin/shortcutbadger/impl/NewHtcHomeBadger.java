package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import g6.a;
import g6.b;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class NewHtcHomeBadger implements a {
    @Override // g6.a
    public List a() {
        return Collections.singletonList("com.htc.launcher");
    }

    @Override // g6.a
    public void b(Context context, ComponentName componentName, int i7) throws b {
        boolean z7;
        Intent intent = new Intent("com.htc.launcher.action.SET_NOTIFICATION");
        intent.putExtra("com.htc.launcher.extra.COMPONENT", componentName.flattenToShortString());
        intent.putExtra("com.htc.launcher.extra.COUNT", i7);
        Intent intent2 = new Intent("com.htc.launcher.action.UPDATE_SHORTCUT");
        intent2.putExtra("packagename", componentName.getPackageName());
        intent2.putExtra("count", i7);
        boolean z8 = false;
        try {
            i6.a.c(context, intent);
            z7 = true;
        } catch (b unused) {
            z7 = false;
        }
        try {
            i6.a.c(context, intent2);
            z8 = true;
        } catch (b unused2) {
        }
        if (z7 || z8) {
            return;
        }
        throw new b("unable to resolve intent: " + intent2.toString());
    }
}
