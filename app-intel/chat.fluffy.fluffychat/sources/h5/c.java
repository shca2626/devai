package h5;

import h5.b;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final h5.b f16882a;

    /* renamed from: b, reason: collision with root package name */
    public final String f16883b;

    /* renamed from: c, reason: collision with root package name */
    public final k f16884c;

    /* renamed from: d, reason: collision with root package name */
    public final b.c f16885d;

    public interface b {
        void endOfStream();

        void error(String str, String str2, Object obj);

        void success(Object obj);
    }

    /* renamed from: h5.c$c, reason: collision with other inner class name */
    public final class C0194c implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final d f16886a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicReference f16887b = new AtomicReference(null);

        /* renamed from: h5.c$c$a */
        public final class a implements b {

            /* renamed from: a, reason: collision with root package name */
            public final AtomicBoolean f16889a;

            public a() {
                this.f16889a = new AtomicBoolean(false);
            }

            @Override // h5.c.b
            public void endOfStream() {
                if (this.f16889a.getAndSet(true) || C0194c.this.f16887b.get() != this) {
                    return;
                }
                c.this.f16882a.e(c.this.f16883b, null);
            }

            @Override // h5.c.b
            public void error(String str, String str2, Object obj) {
                if (this.f16889a.get() || C0194c.this.f16887b.get() != this) {
                    return;
                }
                c.this.f16882a.e(c.this.f16883b, c.this.f16884c.e(str, str2, obj));
            }

            @Override // h5.c.b
            public void success(Object obj) {
                if (this.f16889a.get() || C0194c.this.f16887b.get() != this) {
                    return;
                }
                c.this.f16882a.e(c.this.f16883b, c.this.f16884c.c(obj));
            }
        }

        public C0194c(d dVar) {
            this.f16886a = dVar;
        }

        @Override // h5.b.a
        public void a(ByteBuffer byteBuffer, b.InterfaceC0193b interfaceC0193b) {
            i iVarB = c.this.f16884c.b(byteBuffer);
            if (iVarB.f16895a.equals("listen")) {
                d(iVarB.f16896b, interfaceC0193b);
            } else if (iVarB.f16895a.equals("cancel")) {
                c(iVarB.f16896b, interfaceC0193b);
            } else {
                interfaceC0193b.a(null);
            }
        }

        public final void c(Object obj, b.InterfaceC0193b interfaceC0193b) {
            if (((b) this.f16887b.getAndSet(null)) == null) {
                interfaceC0193b.a(c.this.f16884c.e("error", "No active stream to cancel", null));
                return;
            }
            try {
                this.f16886a.onCancel(obj);
                interfaceC0193b.a(c.this.f16884c.c(null));
            } catch (RuntimeException e7) {
                U4.b.c("EventChannel#" + c.this.f16883b, "Failed to close event stream", e7);
                interfaceC0193b.a(c.this.f16884c.e("error", e7.getMessage(), null));
            }
        }

        public final void d(Object obj, b.InterfaceC0193b interfaceC0193b) {
            a aVar = new a();
            if (((b) this.f16887b.getAndSet(aVar)) != null) {
                try {
                    this.f16886a.onCancel(null);
                } catch (RuntimeException e7) {
                    U4.b.c("EventChannel#" + c.this.f16883b, "Failed to close existing event stream", e7);
                }
            }
            try {
                this.f16886a.onListen(obj, aVar);
                interfaceC0193b.a(c.this.f16884c.c(null));
            } catch (RuntimeException e8) {
                this.f16887b.set(null);
                U4.b.c("EventChannel#" + c.this.f16883b, "Failed to open event stream", e8);
                interfaceC0193b.a(c.this.f16884c.e("error", e8.getMessage(), null));
            }
        }
    }

    public interface d {
        void onCancel(Object obj);

        void onListen(Object obj, b bVar);
    }

    public c(h5.b bVar, String str) {
        this(bVar, str, p.f16910b);
    }

    public void d(d dVar) {
        if (this.f16885d != null) {
            this.f16882a.f(this.f16883b, dVar != null ? new C0194c(dVar) : null, this.f16885d);
        } else {
            this.f16882a.b(this.f16883b, dVar != null ? new C0194c(dVar) : null);
        }
    }

    public c(h5.b bVar, String str, k kVar) {
        this(bVar, str, kVar, null);
    }

    public c(h5.b bVar, String str, k kVar, b.c cVar) {
        this.f16882a = bVar;
        this.f16883b = str;
        this.f16884c = kVar;
        this.f16885d = cVar;
    }
}
