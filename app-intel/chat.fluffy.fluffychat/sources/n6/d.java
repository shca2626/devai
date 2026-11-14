package n6;

import java.util.LinkedHashSet;
import java.util.Set;
import k6.C;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Set f20211a = new LinkedHashSet();

    public synchronized void a(C c7) {
        this.f20211a.remove(c7);
    }

    public synchronized void b(C c7) {
        this.f20211a.add(c7);
    }

    public synchronized boolean c(C c7) {
        return this.f20211a.contains(c7);
    }
}
