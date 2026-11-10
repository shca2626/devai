package h5;

import h5.b;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public final h5.b f16897a;

    /* renamed from: b, reason: collision with root package name */
    public final String f16898b;

    /* renamed from: c, reason: collision with root package name */
    public final k f16899c;

    /* renamed from: d, reason: collision with root package name */
    public final b.c f16900d;

    public final class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final c f16901a;

        /* renamed from: h5.j$a$a, reason: collision with other inner class name */
        public class C0195a implements d {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b.InterfaceC0193b f16903a;

            public C0195a(b.InterfaceC0193b interfaceC0193b) {
                this.f16903a = interfaceC0193b;
            }

            @Override // h5.j.d
            public void error(String str, String str2, Object obj) {
                this.f16903a.a(j.this.f16899c.e(str, str2, obj));
            }

            @Override // h5.j.d
            public void notImplemented() {
                this.f16903a.a(null);
            }

            @Override // h5.j.d
            public void success(Object obj) {
                this.f16903a.a(j.this.f16899c.c(obj));
            }
        }

        public a(c cVar) {
            this.f16901a = cVar;
        }

        @Override // h5.b.a
        public void a(ByteBuffer byteBuffer, b.InterfaceC0193b interfaceC0193b) {
            try {
                this.f16901a.onMethodCall(j.this.f16899c.b(byteBuffer), new C0195a(interfaceC0193b));
            } catch (RuntimeException e7) {
                U4.b.c("MethodChannel#" + j.this.f16898b, "Failed to handle method call", e7);
                interfaceC0193b.a(j.this.f16899c.d("error", e7.getMessage(), null, U4.b.d(e7)));
            }
        }
    }

    public final class b implements b.InterfaceC0193b {

        /* renamed from: a, reason: collision with root package name */
        public final d f16905a;

        public b(d dVar) {
            this.f16905a = dVar;
        }

        @Override // h5.b.InterfaceC0193b
        public void a(ByteBuffer byteBuffer) {
            try {
                if (byteBuffer == null) {
                    this.f16905a.notImplemented();
                } else {
                    try {
                        this.f16905a.success(j.this.f16899c.f(byteBuffer));
                    } catch (h5.d e7) {
                        this.f16905a.error(e7.f16891l, e7.getMessage(), e7.f16892m);
                    }
                }
            } catch (RuntimeException e8) {
                U4.b.c("MethodChannel#" + j.this.f16898b, "Failed to handle method call result", e8);
            }
        }
    }

    public interface c {
        void onMethodCall(i iVar, d dVar);
    }

    public interface d {
        void error(String str, String str2, Object obj);

        void notImplemented();

        void success(Object obj);
    }

    public j(h5.b bVar, String str) {
        this(bVar, str, p.f16910b);
    }

    public void c(String str, Object obj) {
        d(str, obj, null);
    }

    public void d(String str, Object obj, d dVar) {
        this.f16897a.d(this.f16898b, this.f16899c.a(new i(str, obj)), dVar == null ? null : new b(dVar));
    }

    public void e(c cVar) {
        if (this.f16900d != null) {
            this.f16897a.f(this.f16898b, cVar != null ? new a(cVar) : null, this.f16900d);
        } else {
            this.f16897a.b(this.f16898b, cVar != null ? new a(cVar) : null);
        }
    }

    public j(h5.b bVar, String str, k kVar) {
        this(bVar, str, kVar, null);
    }

    public j(h5.b bVar, String str, k kVar, b.c cVar) {
        this.f16897a = bVar;
        this.f16898b = str;
        this.f16899c = kVar;
        this.f16900d = cVar;
    }
}
