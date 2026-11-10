package k0;

import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: k0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1246b {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f18811a;

    public C1246b(boolean z7) {
        this.f18811a = new AtomicBoolean(z7);
    }

    public final boolean a() {
        return this.f18811a.get();
    }

    public final void b(boolean z7) {
        this.f18811a.set(z7);
    }
}
