package j$.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* renamed from: j$.time.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1198a extends AbstractC1199b implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final C1198a f18204b;
    private static final long serialVersionUID = 6740630888130243051L;

    /* renamed from: a, reason: collision with root package name */
    public final ZoneId f18205a;

    public C1198a(ZoneId zoneId) {
        this.f18205a = zoneId;
    }

    static {
        System.currentTimeMillis();
        f18204b = new C1198a(z.f18422f);
    }

    public final Instant c() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Instant instant = Instant.f18193c;
        long j7 = 1000;
        return Instant.s(Math.floorDiv(jCurrentTimeMillis, j7), ((int) Math.floorMod(jCurrentTimeMillis, j7)) * 1000000);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1198a) {
            return this.f18205a.equals(((C1198a) obj).f18205a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f18205a.hashCode() + 1;
    }

    public final String toString() {
        return "SystemClock[" + this.f18205a + "]";
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
    }
}
