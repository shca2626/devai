package d1;

import E0.InterfaceC0325k;
import java.util.concurrent.Executor;

/* renamed from: d1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceExecutorC0975a extends Executor {

    /* renamed from: d1.a$a, reason: collision with other inner class name */
    public class C0152a implements InterfaceExecutorC0975a {

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ Executor f15107l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0325k f15108m;

        public C0152a(Executor executor, InterfaceC0325k interfaceC0325k) {
            this.f15107l = executor;
            this.f15108m = interfaceC0325k;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f15107l.execute(runnable);
        }

        @Override // d1.InterfaceExecutorC0975a
        public void release() {
            this.f15108m.accept(this.f15107l);
        }
    }

    static InterfaceExecutorC0975a y(Executor executor, InterfaceC0325k interfaceC0325k) {
        return new C0152a(executor, interfaceC0325k);
    }

    void release();
}
