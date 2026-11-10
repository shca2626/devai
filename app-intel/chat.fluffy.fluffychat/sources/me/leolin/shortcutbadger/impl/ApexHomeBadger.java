package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import g6.a;
import g6.b;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class ApexHomeBadger implements a {
    @Override // g6.a
    public List a() {
        return Arrays.asList("com.anddoes.launcher");
    }

    @Override // g6.a
    public void b(Context context, ComponentName componentName, int i7) throws b {
        Intent intent = new Intent("com.anddoes.launcher.COUNTER_CHANGED");
        intent.putExtra("package", componentName.getPackageName());
        intent.putExtra("count", i7);
        intent.putExtra("class", componentName.getClassName());
        i6.a.c(context, intent);
    }
}
