package h0;

/* renamed from: h0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1131f extends AbstractC1121D {

    /* renamed from: b, reason: collision with root package name */
    public final Object f16578b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16579c;

    public C1131f(Object obj, int i7, int i8) {
        super(i8, null);
        this.f16578b = obj;
        this.f16579c = i7;
    }

    public final void b() {
        Object obj = this.f16578b;
        if ((obj != null ? obj.hashCode() : 0) != this.f16579c) {
            throw new IllegalStateException("Data in DataStore was mutated but DataStore is only compatible with Immutable types.");
        }
    }

    public final Object c() {
        return this.f16578b;
    }
}
