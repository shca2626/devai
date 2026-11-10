package Q5;

import M5.m;
import java.util.Random;

/* loaded from: classes.dex */
public final class b extends Q5.a {

    /* renamed from: n, reason: collision with root package name */
    public final a f7684n = new a();

    public static final class a extends ThreadLocal {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // Q5.a
    public Random f() {
        Object obj = this.f7684n.get();
        m.d(obj, "get(...)");
        return (Random) obj;
    }
}
