package A1;

import E0.U;
import g1.S;

/* renamed from: A1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0299a implements S {

    /* renamed from: a, reason: collision with root package name */
    public final int f33a;

    /* renamed from: b, reason: collision with root package name */
    public final long f34b;

    /* renamed from: c, reason: collision with root package name */
    public final int f35c;

    public C0299a(int i7, long j7, int i8) {
        this.f33a = i7;
        this.f34b = j7;
        this.f35c = i8;
    }

    public String toString() {
        return "AtomSizeTooSmall{type=" + U.o1(this.f33a) + ", size=" + this.f34b + ", minHeaderSize=" + this.f35c + "}";
    }
}
