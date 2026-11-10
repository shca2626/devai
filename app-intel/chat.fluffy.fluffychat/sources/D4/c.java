package D4;

import M5.m;
import V5.v;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public static final a f1774b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Long f1775a;

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

        public final c b(Context context) {
            m.e(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.FOREGROUND_TASK_OPTIONS", 0);
            return new c(sharedPreferences.contains("callbackHandle") ? Long.valueOf(sharedPreferences.getLong("callbackHandle", 0L)) : null);
        }

        public final void c(Context context, Map map) {
            m.e(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.FOREGROUND_TASK_OPTIONS", 0);
            Long lN = v.n(String.valueOf(map != null ? map.get("callbackHandle") : null));
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.remove("callbackHandle");
            if (lN != null) {
                editorEdit.putLong("callbackHandle", lN.longValue());
            }
            editorEdit.commit();
        }

        public final void d(Context context, Map map) {
            m.e(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.FOREGROUND_TASK_OPTIONS", 0);
            Long lN = v.n(String.valueOf(map != null ? map.get("callbackHandle") : null));
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (lN != null) {
                editorEdit.putLong("callbackHandle", lN.longValue());
            }
            editorEdit.commit();
        }

        public a() {
        }
    }

    public c(Long l7) {
        this.f1775a = l7;
    }

    public final Long a() {
        return this.f1775a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && m.a(this.f1775a, ((c) obj).f1775a);
    }

    public int hashCode() {
        Long l7 = this.f1775a;
        if (l7 == null) {
            return 0;
        }
        return l7.hashCode();
    }

    public String toString() {
        return "ForegroundTaskData(callbackHandle=" + this.f1775a + ")";
    }
}
