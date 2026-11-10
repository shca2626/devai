package g5;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public final int f16399a;

    /* renamed from: b, reason: collision with root package name */
    public final String f16400b;

    /* renamed from: c, reason: collision with root package name */
    public final double f16401c;

    /* renamed from: d, reason: collision with root package name */
    public final double f16402d;

    /* renamed from: e, reason: collision with root package name */
    public final double f16403e;

    /* renamed from: f, reason: collision with root package name */
    public final double f16404f;

    /* renamed from: g, reason: collision with root package name */
    public final int f16405g;

    /* renamed from: h, reason: collision with root package name */
    public final a f16406h;

    /* renamed from: i, reason: collision with root package name */
    public final ByteBuffer f16407i;

    public enum a {
        TEXTURE_WITH_VIRTUAL_FALLBACK,
        TEXTURE_WITH_HYBRID_FALLBACK,
        HYBRID_ONLY
    }

    public l(int i7, String str, double d7, double d8, double d9, double d10, int i8, a aVar, ByteBuffer byteBuffer) {
        this.f16399a = i7;
        this.f16400b = str;
        this.f16403e = d7;
        this.f16404f = d8;
        this.f16401c = d9;
        this.f16402d = d10;
        this.f16405g = i8;
        this.f16406h = aVar;
        this.f16407i = byteBuffer;
    }

    public static l a(int i7, String str, int i8, ByteBuffer byteBuffer) {
        return new l(i7, str, 0.0d, 0.0d, 0.0d, 0.0d, i8, null, byteBuffer);
    }

    public static l b(int i7, String str, int i8, ByteBuffer byteBuffer) {
        return new l(i7, str, 0.0d, 0.0d, 0.0d, 0.0d, i8, a.HYBRID_ONLY, byteBuffer);
    }

    public static l c(int i7, String str, double d7, double d8, double d9, double d10, int i8, boolean z7, ByteBuffer byteBuffer) {
        return new l(i7, str, d7, d8, d9, d10, i8, z7 ? a.TEXTURE_WITH_HYBRID_FALLBACK : a.TEXTURE_WITH_VIRTUAL_FALLBACK, byteBuffer);
    }
}
