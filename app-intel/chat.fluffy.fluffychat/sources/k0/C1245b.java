package k0;

import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: k0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1245b {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f18810a;

    public C1245b(boolean z7) {
        this.f18810a = new AtomicBoolean(z7);
    }

    public final boolean a() {
        return this.f18810a.get();
    }

    public final void b(boolean z7) {
        this.f18810a.set(z7);
    }
}
