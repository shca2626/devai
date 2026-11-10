package com.pravera.flutter_foreground_task.service;

import C4.d;
import C4.e;
import D4.c;
import D4.f;
import D4.h;
import D4.j;
import L.b;
import M5.m;
import android.content.Context;
import android.content.Intent;
import java.util.Map;

/* loaded from: classes.dex */
public final class a {
    public final boolean a() {
        return ((Boolean) ForegroundService.f14978z.b().getValue()).booleanValue();
    }

    public final void b(Context context) throws e {
        m.e(context, "context");
        if (!a()) {
            throw new e();
        }
        Intent intent = new Intent(context, (Class<?>) ForegroundService.class);
        D4.a.f1770b.b(context, "com.pravera.flutter_foreground_task.action.api_restart");
        b.n(context, intent);
    }

    public final void c(Object obj) {
        if (obj != null) {
            ForegroundService.f14978z.c(obj);
        }
    }

    public final void d(Context context, Object obj) throws d {
        m.e(context, "context");
        if (a()) {
            throw new d();
        }
        Intent intent = new Intent(context, (Class<?>) ForegroundService.class);
        Map map = obj instanceof Map ? (Map) obj : null;
        D4.a.f1770b.b(context, "com.pravera.flutter_foreground_task.action.api_start");
        D4.b.f1772b.d(context, map);
        j.f1807m.c(context, map);
        f.f1786h.c(context, map);
        c.f1774b.c(context, map);
        h.f1798f.c(context, map);
        b.n(context, intent);
    }

    public final void e(Context context) throws e {
        m.e(context, "context");
        if (!a()) {
            throw new e();
        }
        Intent intent = new Intent(context, (Class<?>) ForegroundService.class);
        D4.a.f1770b.b(context, "com.pravera.flutter_foreground_task.action.api_stop");
        D4.b.f1772b.a(context);
        j.f1807m.a(context);
        f.f1786h.a(context);
        c.f1774b.a(context);
        h.f1798f.a(context);
        context.startService(intent);
    }

    public final void f(Context context, Object obj) throws e {
        m.e(context, "context");
        if (!a()) {
            throw new e();
        }
        Intent intent = new Intent(context, (Class<?>) ForegroundService.class);
        Map map = obj instanceof Map ? (Map) obj : null;
        D4.a.f1770b.b(context, "com.pravera.flutter_foreground_task.action.api_update");
        f.f1786h.d(context, map);
        c.f1774b.d(context, map);
        h.f1798f.d(context, map);
        context.startService(intent);
    }
}
