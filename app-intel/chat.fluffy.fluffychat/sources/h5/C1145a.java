package h5;

import h5.b;
import java.nio.ByteBuffer;

/* renamed from: h5.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1145a {

    /* renamed from: a, reason: collision with root package name */
    public final h5.b f16871a;

    /* renamed from: b, reason: collision with root package name */
    public final String f16872b;

    /* renamed from: c, reason: collision with root package name */
    public final h f16873c;

    /* renamed from: d, reason: collision with root package name */
    public final b.c f16874d;

    /* renamed from: h5.a$b */
    public final class b implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final d f16875a;

        /* renamed from: h5.a$b$a, reason: collision with other inner class name */
        public class C0192a implements e {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b.InterfaceC0193b f16877a;

            public C0192a(b.InterfaceC0193b interfaceC0193b) {
                this.f16877a = interfaceC0193b;
            }

            @Override // h5.C1145a.e
            public void a(Object obj) {
                this.f16877a.a(C1145a.this.f16873c.a(obj));
            }
        }

        @Override // h5.b.a
        public void a(ByteBuffer byteBuffer, b.InterfaceC0193b interfaceC0193b) {
            try {
                this.f16875a.a(C1145a.this.f16873c.b(byteBuffer), new C0192a(interfaceC0193b));
            } catch (RuntimeException e7) {
                U4.b.c("BasicMessageChannel#" + C1145a.this.f16872b, "Failed to handle message", e7);
                interfaceC0193b.a(null);
            }
        }

        public b(d dVar) {
            this.f16875a = dVar;
        }
    }

    /* renamed from: h5.a$c */
    public final class c implements b.InterfaceC0193b {

        /* renamed from: a, reason: collision with root package name */
        public final e f16879a;

        @Override // h5.b.InterfaceC0193b
        public void a(ByteBuffer byteBuffer) {
            try {
                this.f16879a.a(C1145a.this.f16873c.b(byteBuffer));
            } catch (RuntimeException e7) {
                U4.b.c("BasicMessageChannel#" + C1145a.this.f16872b, "Failed to handle message reply", e7);
            }
        }

        public c(e eVar) {
            this.f16879a = eVar;
        }
    }

    /* renamed from: h5.a$d */
    public interface d {
        void a(Object obj, e eVar);
    }

    /* renamed from: h5.a$e */
    public interface e {
        void a(Object obj);
    }

    public C1145a(h5.b bVar, String str, h hVar) {
        this(bVar, str, hVar, null);
    }

    public void c(Object obj) {
        d(obj, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void d(Object obj, e eVar) {
        this.f16871a.d(this.f16872b, this.f16873c.a(obj), eVar != null ? new c(eVar) : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [h5.b] */
    /* JADX WARN: Type inference failed for: r1v0, types: [h5.a$a] */
    /* JADX WARN: Type inference failed for: r1v1, types: [h5.b$a] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public void e(d dVar) {
        if (this.f16874d != null) {
            this.f16871a.f(this.f16872b, dVar != null ? new b(dVar) : null, this.f16874d);
        } else {
            this.f16871a.b(this.f16872b, dVar != null ? new b(dVar) : 0);
        }
    }

    public C1145a(h5.b bVar, String str, h hVar, b.c cVar) {
        this.f16871a = bVar;
        this.f16872b = str;
        this.f16873c = hVar;
        this.f16874d = cVar;
    }
}
