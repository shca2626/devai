package i4;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* loaded from: classes.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f17551a;

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f17552b;

    public y(Context context, String str) {
        this.f17551a = context.getSharedPreferences(d(str), 0);
        this.f17552b = context.getSharedPreferences("FlutterSecureStorageConfiguration", 0);
    }

    public static String d(String str) {
        return "FlutterSecureStorageConfiguration:" + str;
    }

    public boolean a(String str) {
        return this.f17551a.contains(str) || this.f17552b.contains(str);
    }

    public SharedPreferences.Editor b() {
        return this.f17551a.edit();
    }

    public Map c() {
        return this.f17551a.getAll();
    }

    public String e(String str, String str2) {
        String string = this.f17551a.getString(str, null);
        return string != null ? string : this.f17552b.getString(str, str2);
    }
}
