package D0;

import E0.U;
import android.os.Bundle;
import j3.o;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    public static final String f1599c = U.A0(0);

    /* renamed from: d, reason: collision with root package name */
    public static final String f1600d = U.A0(1);

    /* renamed from: a, reason: collision with root package name */
    public final String f1601a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1602b;

    public f(String str, int i7) {
        this.f1601a = str;
        this.f1602b = i7;
    }

    public static f a(Bundle bundle) {
        return new f((String) o.q(bundle.getString(f1599c)), bundle.getInt(f1600d));
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putString(f1599c, this.f1601a);
        bundle.putInt(f1600d, this.f1602b);
        return bundle;
    }
}
