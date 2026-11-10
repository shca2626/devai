package androidx.media3.exoplayer.audio;

import android.media.AudioTimestamp;
import android.media.AudioTrack;

/* loaded from: classes7.dex */
final class f {

    /* renamed from: a, reason: collision with root package name */
    private final a f8560a;

    /* renamed from: b, reason: collision with root package name */
    private int f8561b;

    /* renamed from: c, reason: collision with root package name */
    private long f8562c;

    /* renamed from: d, reason: collision with root package name */
    private long f8563d;

    /* renamed from: e, reason: collision with root package name */
    private long f8564e;

    /* renamed from: f, reason: collision with root package name */
    private long f8565f;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final AudioTrack f8566a;

        /* renamed from: b, reason: collision with root package name */
        private final AudioTimestamp f8567b = new AudioTimestamp();

        /* renamed from: c, reason: collision with root package name */
        private long f8568c;

        /* renamed from: d, reason: collision with root package name */
        private long f8569d;

        /* renamed from: e, reason: collision with root package name */
        private long f8570e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f8571f;

        /* renamed from: g, reason: collision with root package name */
        private long f8572g;

        public a(AudioTrack audioTrack) {
            this.f8566a = audioTrack;
        }

        public void a() {
            this.f8571f = true;
        }

        public long b() {
            return this.f8570e;
        }

        public long c() {
            return this.f8567b.nanoTime / 1000;
        }

        public boolean d() {
            boolean timestamp = this.f8566a.getTimestamp(this.f8567b);
            if (timestamp) {
                long j12 = this.f8567b.framePosition;
                long j13 = this.f8569d;
                if (j13 > j12) {
                    if (this.f8571f) {
                        this.f8572g += j13;
                        this.f8571f = false;
                    } else {
                        this.f8568c++;
                    }
                }
                this.f8569d = j12;
                this.f8570e = j12 + this.f8572g + (this.f8568c << 32);
            }
            return timestamp;
        }
    }

    public f(AudioTrack audioTrack) {
        this.f8560a = new a(audioTrack);
        h();
    }

    private void i(int i12) {
        this.f8561b = i12;
        if (i12 == 0) {
            this.f8564e = 0L;
            this.f8565f = -1L;
            this.f8562c = System.nanoTime() / 1000;
            this.f8563d = 10000L;
            return;
        }
        if (i12 == 1) {
            this.f8563d = 10000L;
            return;
        }
        if (i12 == 2 || i12 == 3) {
            this.f8563d = 10000000L;
        } else {
            if (i12 != 4) {
                throw new IllegalStateException();
            }
            this.f8563d = 500000L;
        }
    }

    public void a() {
        if (this.f8561b == 4) {
            h();
        }
    }

    public void b() {
        a aVar = this.f8560a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public long c() {
        a aVar = this.f8560a;
        if (aVar != null) {
            return aVar.b();
        }
        return -1L;
    }

    public long d() {
        a aVar = this.f8560a;
        if (aVar != null) {
            return aVar.c();
        }
        return -9223372036854775807L;
    }

    public boolean e() {
        return this.f8561b == 2;
    }

    public boolean f(long j12) {
        a aVar = this.f8560a;
        if (aVar == null || j12 - this.f8564e < this.f8563d) {
            return false;
        }
        this.f8564e = j12;
        boolean zD = aVar.d();
        int i12 = this.f8561b;
        if (i12 != 0) {
            if (i12 != 1) {
                if (i12 != 2) {
                    if (i12 != 3) {
                        if (i12 != 4) {
                            throw new IllegalStateException();
                        }
                    } else if (zD) {
                        h();
                    }
                } else if (!zD) {
                    h();
                }
            } else if (!zD) {
                h();
            } else if (this.f8560a.b() > this.f8565f) {
                i(2);
            }
        } else if (zD) {
            if (this.f8560a.c() < this.f8562c) {
                return false;
            }
            this.f8565f = this.f8560a.b();
            i(1);
        } else if (j12 - this.f8562c > 500000) {
            i(3);
        }
        return zD;
    }

    public void g() {
        i(4);
    }

    public void h() {
        if (this.f8560a != null) {
            i(0);
        }
    }
}
