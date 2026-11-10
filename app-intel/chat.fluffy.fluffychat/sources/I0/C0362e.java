package I0;

/* renamed from: I0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0362e {

    /* renamed from: a, reason: collision with root package name */
    public int f3956a;

    /* renamed from: b, reason: collision with root package name */
    public int f3957b;

    /* renamed from: c, reason: collision with root package name */
    public int f3958c;

    /* renamed from: d, reason: collision with root package name */
    public int f3959d;

    /* renamed from: e, reason: collision with root package name */
    public int f3960e;

    /* renamed from: f, reason: collision with root package name */
    public int f3961f;

    /* renamed from: g, reason: collision with root package name */
    public int f3962g;

    /* renamed from: h, reason: collision with root package name */
    public int f3963h;

    /* renamed from: i, reason: collision with root package name */
    public int f3964i;

    /* renamed from: j, reason: collision with root package name */
    public int f3965j;

    /* renamed from: k, reason: collision with root package name */
    public long f3966k;

    /* renamed from: l, reason: collision with root package name */
    public int f3967l;

    public void a(long j7) {
        b(j7, 1);
    }

    public final void b(long j7, int i7) {
        this.f3966k += j7;
        this.f3967l += i7;
    }

    public synchronized void c() {
    }

    public String toString() {
        return E0.U.G("DecoderCounters {\n decoderInits=%s,\n decoderReleases=%s\n queuedInputBuffers=%s\n skippedInputBuffers=%s\n renderedOutputBuffers=%s\n skippedOutputBuffers=%s\n droppedBuffers=%s\n droppedInputBuffers=%s\n maxConsecutiveDroppedBuffers=%s\n droppedToKeyframeEvents=%s\n totalVideoFrameProcessingOffsetUs=%s\n videoFrameProcessingOffsetCount=%s\n}", Integer.valueOf(this.f3956a), Integer.valueOf(this.f3957b), Integer.valueOf(this.f3958c), Integer.valueOf(this.f3959d), Integer.valueOf(this.f3960e), Integer.valueOf(this.f3961f), Integer.valueOf(this.f3962g), Integer.valueOf(this.f3963h), Integer.valueOf(this.f3964i), Integer.valueOf(this.f3965j), Long.valueOf(this.f3966k), Integer.valueOf(this.f3967l));
    }
}
