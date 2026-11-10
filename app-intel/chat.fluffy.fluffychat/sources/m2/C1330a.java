package m2;

import M5.m;
import android.content.Context;
import android.content.SharedPreferences;
import c5.InterfaceC0910a;
import g6.c;
import h5.i;
import h5.j;

/* renamed from: m2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1330a implements InterfaceC0910a, j.c {

    /* renamed from: l, reason: collision with root package name */
    public j f19728l;

    /* renamed from: m, reason: collision with root package name */
    public Context f19729m;

    /* renamed from: n, reason: collision with root package name */
    public final String f19730n = "flutter_new_badger_prefs";

    /* renamed from: o, reason: collision with root package name */
    public final String f19731o = "badge_count";

    public final void a(int i7, j.d dVar) {
        try {
            Context context = this.f19729m;
            if (context == null) {
                m.o("context");
                context = null;
            }
            c.a(context, i7);
            e(i7);
            dVar.success(null);
        } catch (Exception e7) {
            dVar.error("BADGE_ERROR", "Failed to set badge: " + e7.getLocalizedMessage(), null);
        }
    }

    public final void b(j.d dVar) {
        try {
            dVar.success(Integer.valueOf(c()));
        } catch (Exception e7) {
            dVar.error("BADGE_ERROR", "Failed to get badge count: " + e7.getLocalizedMessage(), null);
        }
    }

    public final int c() {
        Context context = this.f19729m;
        if (context == null) {
            m.o("context");
            context = null;
        }
        return context.getSharedPreferences(this.f19730n, 0).getInt(this.f19731o, 0);
    }

    public final void d(j.d dVar) {
        try {
            Context context = this.f19729m;
            if (context == null) {
                m.o("context");
                context = null;
            }
            c.d(context);
            e(0);
            dVar.success(null);
        } catch (Exception e7) {
            dVar.error("BADGE_ERROR", "Failed to remove badge: " + e7.getLocalizedMessage(), null);
        }
    }

    public final void e(int i7) {
        Context context = this.f19729m;
        if (context == null) {
            m.o("context");
            context = null;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(this.f19730n, 0).edit();
        editorEdit.putInt(this.f19731o, i7);
        editorEdit.apply();
    }

    @Override // c5.InterfaceC0910a
    public void onAttachedToEngine(InterfaceC0910a.b bVar) {
        m.e(bVar, "flutterPluginBinding");
        j jVar = new j(bVar.b(), "flutter_new_badger");
        this.f19728l = jVar;
        jVar.e(this);
        Context contextA = bVar.a();
        m.d(contextA, "getApplicationContext(...)");
        this.f19729m = contextA;
    }

    @Override // c5.InterfaceC0910a
    public void onDetachedFromEngine(InterfaceC0910a.b bVar) {
        m.e(bVar, "binding");
        j jVar = this.f19728l;
        if (jVar == null) {
            m.o("channel");
            jVar = null;
        }
        jVar.e(null);
    }

    @Override // h5.j.c
    public void onMethodCall(i iVar, j.d dVar) {
        m.e(iVar, "call");
        m.e(dVar, "result");
        String str = iVar.f16895a;
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -320903809) {
                if (iHashCode != 1388207201) {
                    if (iHashCode == 1949319661 && str.equals("getBadge")) {
                        b(dVar);
                        return;
                    }
                } else if (str.equals("setBadge")) {
                    Integer num = (Integer) iVar.a("count");
                    if (num == null || num.intValue() < 0) {
                        dVar.error("BAD_ARGS", "Invalid badge count. 'count' must be a non-negative integer.", null);
                        return;
                    } else {
                        a(num.intValue(), dVar);
                        return;
                    }
                }
            } else if (str.equals("removeBadge")) {
                d(dVar);
                return;
            }
        }
        dVar.notImplemented();
    }
}
