package K;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class y implements Iterable {

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f5008l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    public final Context f5009m;

    public interface a {
        Intent B();
    }

    public y(Context context) {
        this.f5009m = context;
    }

    public static y i(Context context) {
        return new y(context);
    }

    public y f(Intent intent) {
        this.f5008l.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y g(Activity activity) {
        Intent intentB = activity instanceof a ? ((a) activity).B() : null;
        if (intentB == null) {
            intentB = i.a(activity);
        }
        if (intentB != null) {
            ComponentName component = intentB.getComponent();
            if (component == null) {
                component = intentB.resolveActivity(this.f5009m.getPackageManager());
            }
            h(component);
            f(intentB);
        }
        return this;
    }

    public y h(ComponentName componentName) {
        int size = this.f5008l.size();
        try {
            Intent intentB = i.b(this.f5009m, componentName);
            while (intentB != null) {
                this.f5008l.add(size, intentB);
                intentB = i.b(this.f5009m, intentB.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e7) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e7);
        }
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f5008l.iterator();
    }

    public void j() {
        k(null);
    }

    public void k(Bundle bundle) {
        if (this.f5008l.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f5008l.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (L.b.l(this.f5009m, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.f5009m.startActivity(intent);
    }
}
