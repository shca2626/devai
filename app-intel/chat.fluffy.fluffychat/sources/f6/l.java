package f6;

import b6.AbstractC0856H;
import b6.C0853E;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final int f15903a = AbstractC0856H.e("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);

    /* renamed from: b, reason: collision with root package name */
    public static final C0853E f15904b = new C0853E("PERMIT");

    /* renamed from: c, reason: collision with root package name */
    public static final C0853E f15905c = new C0853E("TAKEN");

    /* renamed from: d, reason: collision with root package name */
    public static final C0853E f15906d = new C0853E("BROKEN");

    /* renamed from: e, reason: collision with root package name */
    public static final C0853E f15907e = new C0853E("CANCELLED");

    /* renamed from: f, reason: collision with root package name */
    public static final int f15908f = AbstractC0856H.e("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);

    public static final h a(int i7, int i8) {
        return new k(i7, i8);
    }

    public static /* synthetic */ h b(int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 0;
        }
        return a(i7, i8);
    }

    public static final m j(long j7, m mVar) {
        return new m(j7, mVar, 0);
    }
}
