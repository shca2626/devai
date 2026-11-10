package D4;

import M5.m;
import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final C0016a f1770b = new C0016a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f1771a;

    /* renamed from: D4.a$a, reason: collision with other inner class name */
    public static final class C0016a {
        public /* synthetic */ C0016a(M5.g gVar) {
            this();
        }

        public final a a(Context context) {
            m.e(context, "context");
            String string = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.FOREGROUND_SERVICE_STATUS", 0).getString("foregroundServiceAction", null);
            if (string == null) {
                string = "com.pravera.flutter_foreground_task.action.api_stop";
            }
            return new a(string);
        }

        public final void b(Context context, String str) {
            m.e(context, "context");
            m.e(str, "action");
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.FOREGROUND_SERVICE_STATUS", 0).edit();
            editorEdit.putString("foregroundServiceAction", str);
            editorEdit.commit();
        }

        public C0016a() {
        }
    }

    public a(String str) {
        m.e(str, "action");
        this.f1771a = str;
    }

    public final String a() {
        return this.f1771a;
    }

    public final boolean b() {
        return m.a(this.f1771a, "com.pravera.flutter_foreground_task.action.api_stop");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && m.a(this.f1771a, ((a) obj).f1771a);
    }

    public int hashCode() {
        return this.f1771a.hashCode();
    }

    public String toString() {
        return "ForegroundServiceStatus(action=" + this.f1771a + ")";
    }
}
