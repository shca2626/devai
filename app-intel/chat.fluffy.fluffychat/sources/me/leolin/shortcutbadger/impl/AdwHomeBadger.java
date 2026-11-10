package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import g6.a;
import g6.b;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class AdwHomeBadger implements a {
    @Override // g6.a
    public List a() {
        return Arrays.asList("org.adw.launcher", "org.adwfreak.launcher");
    }

    @Override // g6.a
    public void b(Context context, ComponentName componentName, int i7) throws b {
        Intent intent = new Intent("org.adw.launcher.counter.SEND");
        intent.putExtra("PNAME", componentName.getPackageName());
        intent.putExtra("CNAME", componentName.getClassName());
        intent.putExtra("COUNT", i7);
        i6.a.c(context, intent);
    }
}
