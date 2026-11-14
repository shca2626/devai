package R0;

import android.media.MediaCodec;
import android.os.Bundle;

/* loaded from: classes.dex */
public class W implements InterfaceC0584v {

    /* renamed from: a, reason: collision with root package name */
    public final MediaCodec f7789a;

    public W(MediaCodec mediaCodec) {
        this.f7789a = mediaCodec;
    }

    @Override // R0.InterfaceC0584v
    public void a(int i7, int i8, H0.c cVar, long j7, int i9) throws MediaCodec.CryptoException {
        this.f7789a.queueSecureInputBuffer(i7, i8, cVar.a(), j7, i9);
    }

    @Override // R0.InterfaceC0584v
    public void queueInputBuffer(int i7, int i8, int i9, long j7, int i10) throws MediaCodec.CryptoException {
        this.f7789a.queueInputBuffer(i7, i8, i9, j7, i10);
    }

    @Override // R0.InterfaceC0584v
    public void setParameters(Bundle bundle) {
        this.f7789a.setParameters(bundle);
    }

    @Override // R0.InterfaceC0584v
    public void b() {
    }

    @Override // R0.InterfaceC0584v
    public void flush() {
    }

    @Override // R0.InterfaceC0584v
    public void shutdown() {
    }

    @Override // R0.InterfaceC0584v
    public void start() {
    }
}
