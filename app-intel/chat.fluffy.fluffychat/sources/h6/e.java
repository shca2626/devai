package h6;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.impl.DefaultBadger;

/* loaded from: classes3.dex */
public class e implements g6.a {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f16915b = {"_id", "class"};

    /* renamed from: a, reason: collision with root package name */
    public DefaultBadger f16916a = new DefaultBadger();

    @Override // g6.a
    public List a() {
        return Arrays.asList("com.sec.android.app.launcher", "com.sec.android.app.twlauncher");
    }

    @Override // g6.a
    public void b(Context context, ComponentName componentName, int i7) throws g6.b {
        DefaultBadger defaultBadger = this.f16916a;
        if (defaultBadger != null && defaultBadger.c(context)) {
            this.f16916a.b(context, componentName, i7);
            return;
        }
        Uri uri = Uri.parse("content://com.sec.badge/apps?notify=true");
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorQuery = null;
        try {
            cursorQuery = contentResolver.query(uri, f16915b, "package=?", new String[]{componentName.getPackageName()}, null);
            if (cursorQuery != null) {
                String className = componentName.getClassName();
                boolean z7 = false;
                while (cursorQuery.moveToNext()) {
                    contentResolver.update(uri, c(componentName, i7, false), "_id=?", new String[]{String.valueOf(cursorQuery.getInt(0))});
                    if (className.equals(cursorQuery.getString(cursorQuery.getColumnIndex("class")))) {
                        z7 = true;
                    }
                }
                if (!z7) {
                    contentResolver.insert(uri, c(componentName, i7, true));
                }
            }
            i6.b.a(cursorQuery);
        } catch (Throwable th) {
            i6.b.a(cursorQuery);
            throw th;
        }
    }

    public final ContentValues c(ComponentName componentName, int i7, boolean z7) {
        ContentValues contentValues = new ContentValues();
        if (z7) {
            contentValues.put("package", componentName.getPackageName());
            contentValues.put("class", componentName.getClassName());
        }
        contentValues.put("badgecount", Integer.valueOf(i7));
        return contentValues;
    }
}
