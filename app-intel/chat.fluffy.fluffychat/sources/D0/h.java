package D0;

import E0.U;
import android.os.Bundle;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: d, reason: collision with root package name */
    public static final String f1603d = U.A0(0);

    /* renamed from: e, reason: collision with root package name */
    public static final String f1604e = U.A0(1);

    /* renamed from: f, reason: collision with root package name */
    public static final String f1605f = U.A0(2);

    /* renamed from: a, reason: collision with root package name */
    public int f1606a;

    /* renamed from: b, reason: collision with root package name */
    public int f1607b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1608c;

    public h(int i7, int i8, int i9) {
        this.f1606a = i7;
        this.f1607b = i8;
        this.f1608c = i9;
    }

    public static h a(Bundle bundle) {
        return new h(bundle.getInt(f1603d), bundle.getInt(f1604e), bundle.getInt(f1605f));
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putInt(f1603d, this.f1606a);
        bundle.putInt(f1604e, this.f1607b);
        bundle.putInt(f1605f, this.f1608c);
        return bundle;
    }
}
