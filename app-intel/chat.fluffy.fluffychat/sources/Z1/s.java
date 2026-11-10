package Z1;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class s {

    /* renamed from: b, reason: collision with root package name */
    public View f10334b;

    /* renamed from: a, reason: collision with root package name */
    public final Map f10333a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f10335c = new ArrayList();

    @Deprecated
    public s() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f10334b == sVar.f10334b && this.f10333a.equals(sVar.f10333a);
    }

    public int hashCode() {
        return (this.f10334b.hashCode() * 31) + this.f10333a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f10334b + "\n") + "    values:";
        for (String str2 : this.f10333a.keySet()) {
            str = str + "    " + str2 + ": " + this.f10333a.get(str2) + "\n";
        }
        return str;
    }

    public s(View view) {
        this.f10334b = view;
    }
}
