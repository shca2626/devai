package W5;

/* renamed from: W5.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0631l extends K0 {

    /* renamed from: W5.l$a */
    public static final class a implements InterfaceC0631l {

        /* renamed from: a, reason: collision with root package name */
        public final L5.l f9161a;

        public a(L5.l lVar) {
            this.f9161a = lVar;
        }

        @Override // W5.InterfaceC0631l
        public void a(Throwable th) {
            this.f9161a.a(th);
        }

        public String toString() {
            return "CancelHandler.UserSupplied[" + Q.a(this.f9161a) + '@' + Q.b(this) + ']';
        }
    }

    void a(Throwable th);
}
