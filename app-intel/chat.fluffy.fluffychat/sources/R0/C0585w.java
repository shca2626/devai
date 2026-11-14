package R0;

import android.media.MediaCodec;

/* renamed from: R0.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0585w extends H0.e {

    /* renamed from: l, reason: collision with root package name */
    public final x f7856l;

    /* renamed from: m, reason: collision with root package name */
    public final String f7857m;

    /* renamed from: n, reason: collision with root package name */
    public final int f7858n;

    public C0585w(Throwable th, x xVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("Decoder failed: ");
        sb.append(xVar == null ? null : xVar.f7859a);
        super(sb.toString(), th);
        this.f7856l = xVar;
        this.f7857m = th instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException) th).getDiagnosticInfo() : null;
        this.f7858n = a(th);
    }

    public static int a(Throwable th) {
        if (th instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) th).getErrorCode();
        }
        return 0;
    }
}
