package Z1;

import android.view.View;
import android.view.WindowId;

/* loaded from: classes.dex */
public class O implements P {

    /* renamed from: a, reason: collision with root package name */
    public final WindowId f10207a;

    public O(View view) {
        this.f10207a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof O) && ((O) obj).f10207a.equals(this.f10207a);
    }

    public int hashCode() {
        return this.f10207a.hashCode();
    }
}
