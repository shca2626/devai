package h6;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class b implements g6.a {
    @Override // g6.a
    public List a() {
        return Arrays.asList("me.everything.launcher");
    }

    @Override // g6.a
    public void b(Context context, ComponentName componentName, int i7) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("package_name", componentName.getPackageName());
        contentValues.put("activity_name", componentName.getClassName());
        contentValues.put("count", Integer.valueOf(i7));
        context.getContentResolver().insert(Uri.parse("content://me.everything.badger/apps"), contentValues);
    }
}
