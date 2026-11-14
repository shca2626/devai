package me.leolin.shortcutbadger.impl;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import g6.a;
import g6.b;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public class XiaomiHomeBadger implements a {

    /* renamed from: a, reason: collision with root package name */
    public ResolveInfo f19831a;

    @Override // g6.a
    public List a() {
        return Arrays.asList("com.miui.miuilite", "com.miui.home", "com.miui.miuihome", "com.miui.miuihome2", "com.miui.mihome", "com.miui.mihome2", "com.i.miui.launcher");
    }

    @Override // g6.a
    public void b(Context context, ComponentName componentName, int i7) throws IllegalAccessException, NoSuchFieldException, InstantiationException, SecurityException, IllegalArgumentException, b, InvocationTargetException {
        Object objValueOf;
        try {
            Object objNewInstance = Class.forName("android.app.MiuiNotification").newInstance();
            Field declaredField = objNewInstance.getClass().getDeclaredField("messageCount");
            declaredField.setAccessible(true);
            if (i7 == 0) {
                objValueOf = "";
            } else {
                try {
                    objValueOf = Integer.valueOf(i7);
                } catch (Exception unused) {
                    declaredField.set(objNewInstance, Integer.valueOf(i7));
                }
            }
            declaredField.set(objNewInstance, String.valueOf(objValueOf));
        } catch (Exception unused2) {
            Intent intent = new Intent("android.intent.action.APPLICATION_MESSAGE_UPDATE");
            intent.putExtra("android.intent.extra.update_application_component_name", componentName.getPackageName() + "/" + componentName.getClassName());
            intent.putExtra("android.intent.extra.update_application_message_text", String.valueOf(i7 != 0 ? Integer.valueOf(i7) : ""));
            try {
                i6.a.c(context, intent);
            } catch (b unused3) {
            }
        }
        if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
            c(context, i7);
        }
    }

    public final void c(Context context, int i7) throws IllegalAccessException, IllegalArgumentException, b, InvocationTargetException {
        if (this.f19831a == null) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            this.f19831a = context.getPackageManager().resolveActivity(intent, 65536);
        }
        if (this.f19831a != null) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            Notification notificationBuild = new Notification.Builder(context).setContentTitle("").setContentText("").setSmallIcon(this.f19831a.getIconResource()).build();
            try {
                Object obj = notificationBuild.getClass().getDeclaredField("extraNotification").get(notificationBuild);
                obj.getClass().getDeclaredMethod("setMessageCount", Integer.TYPE).invoke(obj, Integer.valueOf(i7));
                notificationManager.notify(0, notificationBuild);
            } catch (Exception e7) {
                throw new b("not able to set badge", e7);
            }
        }
    }
}
