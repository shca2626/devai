package B0;

import E0.U;
import android.os.Bundle;

/* loaded from: classes.dex */
public abstract class B extends Exception {

    /* renamed from: o, reason: collision with root package name */
    public static final String f328o = U.A0(0);

    /* renamed from: p, reason: collision with root package name */
    public static final String f329p = U.A0(1);

    /* renamed from: q, reason: collision with root package name */
    public static final String f330q = U.A0(2);

    /* renamed from: r, reason: collision with root package name */
    public static final String f331r = U.A0(3);

    /* renamed from: s, reason: collision with root package name */
    public static final String f332s = U.A0(4);

    /* renamed from: t, reason: collision with root package name */
    public static final String f333t = U.A0(5);

    /* renamed from: l, reason: collision with root package name */
    public final int f334l;

    /* renamed from: m, reason: collision with root package name */
    public final long f335m;

    /* renamed from: n, reason: collision with root package name */
    public final Bundle f336n;

    public B(String str, Throwable th, int i7, Bundle bundle, long j7) {
        super(str, th);
        this.f334l = i7;
        this.f336n = bundle;
        this.f335m = j7;
    }
}
