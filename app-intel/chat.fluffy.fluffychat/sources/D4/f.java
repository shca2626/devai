package D4;

import M5.m;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: h, reason: collision with root package name */
    public static final a f1786h = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final d f1787a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1788b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f1789c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f1790d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f1791e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f1792f;

    /* renamed from: g, reason: collision with root package name */
    public final Boolean f1793g;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final void a(Context context) {
            m.e(context, "context");
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.FOREGROUND_TASK_OPTIONS", 0).edit();
            editorEdit.clear();
            editorEdit.commit();
        }

        public final f b(Context context) {
            d dVar;
            m.e(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.FOREGROUND_TASK_OPTIONS", 0);
            String string = sharedPreferences.getString("taskEventAction", null);
            if (string != null) {
                dVar = d.f1776c.a(string);
            } else {
                boolean z7 = sharedPreferences.getBoolean("isOnceEvent", false);
                long j7 = sharedPreferences.getLong("interval", 5000L);
                dVar = z7 ? new d(e.f1781o, j7) : new d(e.f1782p, j7);
            }
            return new f(dVar, sharedPreferences.getBoolean("autoRunOnBoot", false), sharedPreferences.getBoolean("autoRunOnMyPackageReplaced", false), sharedPreferences.getBoolean("allowWakeLock", true), sharedPreferences.getBoolean("allowWifiLock", false), sharedPreferences.getBoolean("allowAutoRestart", false), sharedPreferences.contains("stopWithTask") ? Boolean.valueOf(sharedPreferences.getBoolean("stopWithTask", false)) : null);
        }

        public final void c(Context context, Map map) {
            m.e(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.FOREGROUND_TASK_OPTIONS", 0);
            Object obj = map != null ? map.get("taskEventAction") : null;
            Map map2 = obj instanceof Map ? (Map) obj : null;
            String string = map2 != null ? new JSONObject(map2).toString() : null;
            Object obj2 = map != null ? map.get("autoRunOnBoot") : null;
            Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
            boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
            Object obj3 = map != null ? map.get("autoRunOnMyPackageReplaced") : null;
            Boolean bool2 = obj3 instanceof Boolean ? (Boolean) obj3 : null;
            boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : false;
            Object obj4 = map != null ? map.get("allowWakeLock") : null;
            Boolean bool3 = obj4 instanceof Boolean ? (Boolean) obj4 : null;
            boolean zBooleanValue3 = bool3 != null ? bool3.booleanValue() : true;
            Object obj5 = map != null ? map.get("allowWifiLock") : null;
            Boolean bool4 = obj5 instanceof Boolean ? (Boolean) obj5 : null;
            boolean zBooleanValue4 = bool4 != null ? bool4.booleanValue() : false;
            Object obj6 = map != null ? map.get("allowAutoRestart") : null;
            Boolean bool5 = obj6 instanceof Boolean ? (Boolean) obj6 : null;
            boolean zBooleanValue5 = bool5 != null ? bool5.booleanValue() : false;
            Object obj7 = map != null ? map.get("stopWithTask") : null;
            Boolean bool6 = obj7 instanceof Boolean ? (Boolean) obj7 : null;
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("taskEventAction", string);
            editorEdit.putBoolean("autoRunOnBoot", zBooleanValue);
            editorEdit.putBoolean("autoRunOnMyPackageReplaced", zBooleanValue2);
            editorEdit.putBoolean("allowWakeLock", zBooleanValue3);
            editorEdit.putBoolean("allowWifiLock", zBooleanValue4);
            editorEdit.putBoolean("allowAutoRestart", zBooleanValue5);
            if (bool6 == null || editorEdit.putBoolean("stopWithTask", bool6.booleanValue()) == null) {
                editorEdit.remove("stopWithTask");
            }
            editorEdit.commit();
        }

        public final void d(Context context, Map map) {
            m.e(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.FOREGROUND_TASK_OPTIONS", 0);
            Object obj = map != null ? map.get("taskEventAction") : null;
            Map map2 = obj instanceof Map ? (Map) obj : null;
            String string = map2 != null ? new JSONObject(map2).toString() : null;
            Object obj2 = map != null ? map.get("autoRunOnBoot") : null;
            Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
            Object obj3 = map != null ? map.get("autoRunOnMyPackageReplaced") : null;
            Boolean bool2 = obj3 instanceof Boolean ? (Boolean) obj3 : null;
            Object obj4 = map != null ? map.get("allowWakeLock") : null;
            Boolean bool3 = obj4 instanceof Boolean ? (Boolean) obj4 : null;
            Object obj5 = map != null ? map.get("allowWifiLock") : null;
            Boolean bool4 = obj5 instanceof Boolean ? (Boolean) obj5 : null;
            Object obj6 = map != null ? map.get("allowAutoRestart") : null;
            Boolean bool5 = obj6 instanceof Boolean ? (Boolean) obj6 : null;
            Object obj7 = map != null ? map.get("stopWithTask") : null;
            Boolean bool6 = obj7 instanceof Boolean ? (Boolean) obj7 : null;
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (string != null) {
                editorEdit.putString("taskEventAction", string);
            }
            if (bool != null) {
                editorEdit.putBoolean("autoRunOnBoot", bool.booleanValue());
            }
            if (bool2 != null) {
                editorEdit.putBoolean("autoRunOnMyPackageReplaced", bool2.booleanValue());
            }
            if (bool3 != null) {
                editorEdit.putBoolean("allowWakeLock", bool3.booleanValue());
            }
            if (bool4 != null) {
                editorEdit.putBoolean("allowWifiLock", bool4.booleanValue());
            }
            if (bool5 != null) {
                editorEdit.putBoolean("allowAutoRestart", bool5.booleanValue());
            }
            if (bool6 == null || editorEdit.putBoolean("stopWithTask", bool6.booleanValue()) == null) {
                editorEdit.remove("stopWithTask");
            }
            editorEdit.commit();
        }

        public a() {
        }
    }

    public f(d dVar, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, Boolean bool) {
        m.e(dVar, "eventAction");
        this.f1787a = dVar;
        this.f1788b = z7;
        this.f1789c = z8;
        this.f1790d = z9;
        this.f1791e = z10;
        this.f1792f = z11;
        this.f1793g = bool;
    }

    public final boolean a() {
        return this.f1792f;
    }

    public final boolean b() {
        return this.f1790d;
    }

    public final boolean c() {
        return this.f1791e;
    }

    public final boolean d() {
        return this.f1788b;
    }

    public final boolean e() {
        return this.f1789c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return m.a(this.f1787a, fVar.f1787a) && this.f1788b == fVar.f1788b && this.f1789c == fVar.f1789c && this.f1790d == fVar.f1790d && this.f1791e == fVar.f1791e && this.f1792f == fVar.f1792f && m.a(this.f1793g, fVar.f1793g);
    }

    public final d f() {
        return this.f1787a;
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.f1787a.hashCode() * 31) + Boolean.hashCode(this.f1788b)) * 31) + Boolean.hashCode(this.f1789c)) * 31) + Boolean.hashCode(this.f1790d)) * 31) + Boolean.hashCode(this.f1791e)) * 31) + Boolean.hashCode(this.f1792f)) * 31;
        Boolean bool = this.f1793g;
        return iHashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "ForegroundTaskOptions(eventAction=" + this.f1787a + ", autoRunOnBoot=" + this.f1788b + ", autoRunOnMyPackageReplaced=" + this.f1789c + ", allowWakeLock=" + this.f1790d + ", allowWifiLock=" + this.f1791e + ", allowAutoRestart=" + this.f1792f + ", stopWithTask=" + this.f1793g + ")";
    }
}
