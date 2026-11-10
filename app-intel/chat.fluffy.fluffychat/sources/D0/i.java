package D0;

import E0.U;
import android.os.Bundle;
import j3.o;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    public static final String f1609b = U.A0(0);

    /* renamed from: a, reason: collision with root package name */
    public final String f1610a;

    public i(String str) {
        this.f1610a = str;
    }

    public static i a(Bundle bundle) {
        return new i((String) o.q(bundle.getString(f1609b)));
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putString(f1609b, this.f1610a);
        return bundle;
    }
}
