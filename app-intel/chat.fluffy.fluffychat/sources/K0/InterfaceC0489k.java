package K0;

import J0.G1;
import android.media.AudioDeviceInfo;
import java.nio.ByteBuffer;

/* renamed from: K0.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0489k {

    /* renamed from: K0.k$a */
    public interface a {
        void a(long j7);

        void b();

        void c();

        void d();

        void e();
    }

    /* renamed from: K0.k$b */
    public static final class b extends Exception {

        /* renamed from: l, reason: collision with root package name */
        public final int f5168l;

        /* renamed from: m, reason: collision with root package name */
        public final boolean f5169m;

        public b(int i7, boolean z7) {
            super("AudioOutput write failed: " + i7);
            this.f5169m = z7;
            this.f5168l = i7;
        }
    }

    void a();

    void c(B0.C c7);

    void e();

    B0.C f();

    void g(float f7);

    void h(int i7, int i8);

    long i();

    void j(G1 g12);

    int k();

    void l(float f7);

    boolean m();

    void n(a aVar);

    boolean o();

    int p();

    long q();

    void r(int i7);

    void release();

    void s();

    void setPreferredDevice(AudioDeviceInfo audioDeviceInfo);

    void stop();

    boolean t(ByteBuffer byteBuffer, int i7, long j7);
}
