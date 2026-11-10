package f6;

import b6.AbstractC0849B;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes.dex */
public final class m extends AbstractC0849B {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f15909e;

    public m(long j7, m mVar, int i7) {
        super(j7, mVar, i7);
        this.f15909e = new AtomicReferenceArray(l.f15908f);
    }

    @Override // b6.AbstractC0849B
    public int r() {
        return l.f15908f;
    }

    @Override // b6.AbstractC0849B
    public void s(int i7, Throwable th, C5.i iVar) {
        v().set(i7, l.f15907e);
        t();
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.f13758c + ", hashCode=" + hashCode() + ']';
    }

    public final /* synthetic */ AtomicReferenceArray v() {
        return this.f15909e;
    }
}
