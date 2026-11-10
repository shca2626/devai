package K;

import android.content.res.Configuration;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f4827a;

    /* renamed from: b, reason: collision with root package name */
    public Configuration f4828b;

    public h(boolean z7) {
        this.f4827a = z7;
    }

    public final boolean a() {
        return this.f4827a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(boolean z7, Configuration configuration) {
        this(z7);
        M5.m.e(configuration, "newConfig");
        this.f4828b = configuration;
    }
}
