package H0;

import android.media.MediaCodec;
import j3.o;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f3316a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f3317b;

    /* renamed from: c, reason: collision with root package name */
    public int f3318c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f3319d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f3320e;

    /* renamed from: f, reason: collision with root package name */
    public int f3321f;

    /* renamed from: g, reason: collision with root package name */
    public int f3322g;

    /* renamed from: h, reason: collision with root package name */
    public int f3323h;

    /* renamed from: i, reason: collision with root package name */
    public final MediaCodec.CryptoInfo f3324i;

    /* renamed from: j, reason: collision with root package name */
    public final b f3325j;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final MediaCodec.CryptoInfo f3326a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaCodec.CryptoInfo.Pattern f3327b;

        public final void b(int i7, int i8) {
            this.f3327b.set(i7, i8);
            this.f3326a.setPattern(this.f3327b);
        }

        public b(MediaCodec.CryptoInfo cryptoInfo) {
            this.f3326a = cryptoInfo;
            this.f3327b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }
    }

    public c() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f3324i = cryptoInfo;
        this.f3325j = new b(cryptoInfo);
    }

    public MediaCodec.CryptoInfo a() {
        return this.f3324i;
    }

    public void b(int i7) {
        if (i7 == 0) {
            return;
        }
        if (this.f3319d == null) {
            int[] iArr = new int[1];
            this.f3319d = iArr;
            this.f3324i.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.f3319d;
        iArr2[0] = iArr2[0] + i7;
    }

    public void c(int i7, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i8, int i9, int i10) {
        this.f3321f = i7;
        this.f3319d = iArr;
        this.f3320e = iArr2;
        this.f3317b = bArr;
        this.f3316a = bArr2;
        this.f3318c = i8;
        this.f3322g = i9;
        this.f3323h = i10;
        MediaCodec.CryptoInfo cryptoInfo = this.f3324i;
        cryptoInfo.numSubSamples = i7;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i8;
        ((b) o.q(this.f3325j)).b(i9, i10);
    }
}
