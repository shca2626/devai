package h5;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface b {

    public interface a {
        void a(ByteBuffer byteBuffer, InterfaceC0193b interfaceC0193b);
    }

    /* renamed from: h5.b$b, reason: collision with other inner class name */
    public interface InterfaceC0193b {
        void a(ByteBuffer byteBuffer);
    }

    public interface c {
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public boolean f16881a = true;

        public boolean a() {
            return this.f16881a;
        }
    }

    c a(d dVar);

    void b(String str, a aVar);

    default c c() {
        return a(new d());
    }

    void d(String str, ByteBuffer byteBuffer, InterfaceC0193b interfaceC0193b);

    void e(String str, ByteBuffer byteBuffer);

    void f(String str, a aVar, c cVar);
}
