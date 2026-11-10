package R0;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: R0.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0582u {

    /* renamed from: R0.u$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final x f7849a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaFormat f7850b;

        /* renamed from: c, reason: collision with root package name */
        public final B0.s f7851c;

        /* renamed from: d, reason: collision with root package name */
        public final Surface f7852d;

        /* renamed from: e, reason: collision with root package name */
        public final MediaCrypto f7853e;

        /* renamed from: f, reason: collision with root package name */
        public final C0580s f7854f;

        public a(x xVar, MediaFormat mediaFormat, B0.s sVar, Surface surface, MediaCrypto mediaCrypto, C0580s c0580s) {
            this.f7849a = xVar;
            this.f7850b = mediaFormat;
            this.f7851c = sVar;
            this.f7852d = surface;
            this.f7853e = mediaCrypto;
            this.f7854f = c0580s;
        }

        public static a a(x xVar, MediaFormat mediaFormat, B0.s sVar, MediaCrypto mediaCrypto, C0580s c0580s) {
            return new a(xVar, mediaFormat, sVar, null, mediaCrypto, c0580s);
        }

        public static a b(x xVar, MediaFormat mediaFormat, B0.s sVar, Surface surface, MediaCrypto mediaCrypto) {
            return new a(xVar, mediaFormat, sVar, surface, mediaCrypto, null);
        }
    }

    /* renamed from: R0.u$b */
    public interface b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f7855a = new C0576n();

        static b a(Context context) {
            return new C0576n(context);
        }

        InterfaceC0582u b(a aVar);
    }

    /* renamed from: R0.u$c */
    public interface c {
        void a();

        void b();
    }

    /* renamed from: R0.u$d */
    public interface d {
        void a(InterfaceC0582u interfaceC0582u, long j7, long j8);
    }

    void a(int i7, int i8, H0.c cVar, long j7, int i9);

    boolean b();

    void c(List list);

    default void d(Runnable runnable) {
        runnable.run();
    }

    void e();

    void f(List list);

    void flush();

    void g(d dVar, Handler handler);

    ByteBuffer getInputBuffer(int i7);

    ByteBuffer getOutputBuffer(int i7);

    MediaFormat getOutputFormat();

    void h(int i7, long j7);

    int i();

    int j(MediaCodec.BufferInfo bufferInfo);

    void k(int i7);

    default boolean l(c cVar) {
        return false;
    }

    void m(Surface surface);

    void queueInputBuffer(int i7, int i8, int i9, long j7, int i10);

    void release();

    void releaseOutputBuffer(int i7, boolean z7);

    void setParameters(Bundle bundle);
}
