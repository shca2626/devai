package me.leolin.shortcutbadger.impl;

import android.content.AsyncQueryHandler;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class SonyHomeBadger implements g6.a {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f19829a = Uri.parse("content://com.sonymobile.home.resourceprovider/badge");

    /* renamed from: b, reason: collision with root package name */
    public AsyncQueryHandler f19830b;

    public class a extends AsyncQueryHandler {
        public a(ContentResolver contentResolver) {
            super(contentResolver);
        }
    }

    private static void d(Context context, ComponentName componentName, int i7) {
        Intent intent = new Intent("com.sonyericsson.home.action.UPDATE_BADGE");
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", componentName.getPackageName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", componentName.getClassName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf(i7));
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", i7 > 0);
        context.sendBroadcast(intent);
    }

    public static boolean h(Context context) {
        return context.getPackageManager().resolveContentProvider("com.sonymobile.home.resourceprovider", 0) != null;
    }

    @Override // g6.a
    public List a() {
        return Arrays.asList("com.sonyericsson.home", "com.sonymobile.home");
    }

    @Override // g6.a
    public void b(Context context, ComponentName componentName, int i7) {
        if (h(context)) {
            e(context, componentName, i7);
        } else {
            d(context, componentName, i7);
        }
    }

    public final ContentValues c(int i7, ComponentName componentName) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("badge_count", Integer.valueOf(i7));
        contentValues.put("package_name", componentName.getPackageName());
        contentValues.put("activity_name", componentName.getClassName());
        return contentValues;
    }

    public final void e(Context context, ComponentName componentName, int i7) {
        if (i7 < 0) {
            return;
        }
        ContentValues contentValuesC = c(i7, componentName);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            g(context, contentValuesC);
            return;
        }
        if (this.f19830b == null) {
            this.f19830b = new a(context.getApplicationContext().getContentResolver());
        }
        f(contentValuesC);
    }

    public final void f(ContentValues contentValues) {
        this.f19830b.startInsert(0, null, this.f19829a, contentValues);
    }

    public final void g(Context context, ContentValues contentValues) {
        context.getApplicationContext().getContentResolver().insert(this.f19829a, contentValues);
    }
}
