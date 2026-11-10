package v6;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public static final w f23230a = new w();

    /* renamed from: b, reason: collision with root package name */
    public static final int f23231b = 65536;

    /* renamed from: c, reason: collision with root package name */
    public static final v f23232c = new v(new byte[0], 0, 0, false, false);

    /* renamed from: d, reason: collision with root package name */
    public static final int f23233d;

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicReference[] f23234e;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f23233d = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i7 = 0; i7 < iHighestOneBit; i7++) {
            atomicReferenceArr[i7] = new AtomicReference();
        }
        f23234e = atomicReferenceArr;
    }

    public static final void b(v vVar) {
        M5.m.e(vVar, "segment");
        if (vVar.f23228f != null || vVar.f23229g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (vVar.f23226d) {
            return;
        }
        AtomicReference atomicReferenceA = f23230a.a();
        v vVar2 = f23232c;
        v vVar3 = (v) atomicReferenceA.getAndSet(vVar2);
        if (vVar3 == vVar2) {
            return;
        }
        int i7 = vVar3 != null ? vVar3.f23225c : 0;
        if (i7 >= f23231b) {
            atomicReferenceA.set(vVar3);
            return;
        }
        vVar.f23228f = vVar3;
        vVar.f23224b = 0;
        vVar.f23225c = i7 + 8192;
        atomicReferenceA.set(vVar);
    }

    public static final v c() {
        AtomicReference atomicReferenceA = f23230a.a();
        v vVar = f23232c;
        v vVar2 = (v) atomicReferenceA.getAndSet(vVar);
        if (vVar2 == vVar) {
            return new v();
        }
        if (vVar2 == null) {
            atomicReferenceA.set(null);
            return new v();
        }
        atomicReferenceA.set(vVar2.f23228f);
        vVar2.f23228f = null;
        vVar2.f23225c = 0;
        return vVar2;
    }

    public final AtomicReference a() {
        return f23234e[(int) (Thread.currentThread().getId() & (f23233d - 1))];
    }
}
