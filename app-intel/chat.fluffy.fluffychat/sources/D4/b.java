package D4;

import M5.m;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final a f1772b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final int f1773a;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final void a(Context context) {
            m.e(context, "context");
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.FOREGROUND_SERVICE_TYPES", 0).edit();
            editorEdit.clear();
            editorEdit.commit();
        }

        public final b b(Context context) {
            m.e(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.FOREGROUND_SERVICE_TYPES", 0);
            return new b(Build.VERSION.SDK_INT >= 29 ? sharedPreferences.getInt("serviceTypes", -1) : sharedPreferences.getInt("serviceTypes", 0));
        }

        public final Integer c(Object obj) {
            return m.a(obj, 0) ? Build.VERSION.SDK_INT >= 30 ? 64 : null : m.a(obj, 1) ? Build.VERSION.SDK_INT >= 29 ? 16 : null : m.a(obj, 2) ? Build.VERSION.SDK_INT >= 29 ? 1 : null : m.a(obj, 3) ? Build.VERSION.SDK_INT >= 34 ? 256 : null : m.a(obj, 4) ? Build.VERSION.SDK_INT >= 29 ? 8 : null : m.a(obj, 5) ? Build.VERSION.SDK_INT >= 29 ? 2 : null : m.a(obj, 6) ? Build.VERSION.SDK_INT >= 29 ? 32 : null : m.a(obj, 7) ? Build.VERSION.SDK_INT >= 30 ? 128 : null : m.a(obj, 8) ? Build.VERSION.SDK_INT >= 29 ? 4 : null : m.a(obj, 9) ? Build.VERSION.SDK_INT >= 34 ? 512 : null : m.a(obj, 10) ? Build.VERSION.SDK_INT >= 34 ? 2048 : null : m.a(obj, 11) ? Build.VERSION.SDK_INT >= 34 ? 1073741824 : null : m.a(obj, 12) ? Build.VERSION.SDK_INT >= 34 ? 1024 : null : (!m.a(obj, 13) || Build.VERSION.SDK_INT < 35) ? null : 8192;
        }

        public final void d(Context context, Map map) {
            m.e(context, "context");
            int iIntValue = 0;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.FOREGROUND_SERVICE_TYPES", 0);
            if (Build.VERSION.SDK_INT >= 29) {
                Object obj = map != null ? map.get("serviceTypes") : null;
                List list = obj instanceof List ? (List) obj : null;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        Integer numC = c(it.next());
                        if (numC != null) {
                            iIntValue |= numC.intValue();
                        }
                    }
                }
            }
            if (iIntValue > 0) {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putInt("serviceTypes", iIntValue);
                editorEdit.commit();
            }
        }

        public a() {
        }
    }

    public b(int i7) {
        this.f1773a = i7;
    }

    public final int a() {
        return this.f1773a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && this.f1773a == ((b) obj).f1773a;
    }

    public int hashCode() {
        return Integer.hashCode(this.f1773a);
    }

    public String toString() {
        return "ForegroundServiceTypes(value=" + this.f1773a + ")";
    }
}
