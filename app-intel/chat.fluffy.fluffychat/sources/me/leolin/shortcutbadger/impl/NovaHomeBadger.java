package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import g6.a;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class NovaHomeBadger implements a {
    @Override // g6.a
    public List a() {
        return Arrays.asList("com.teslacoilsw.launcher");
    }

    @Override // g6.a
    public void b(Context context, ComponentName componentName, int i7) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("tag", componentName.getPackageName() + "/" + componentName.getClassName());
        contentValues.put("count", Integer.valueOf(i7));
        context.getContentResolver().insert(Uri.parse("content://com.teslacoilsw.notifier/unread_count"), contentValues);
    }
}
