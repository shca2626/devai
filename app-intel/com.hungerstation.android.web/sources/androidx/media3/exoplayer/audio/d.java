package androidx.media3.exoplayer.audio;

/* loaded from: classes7.dex */
public final class d {

    /* renamed from: d, reason: collision with root package name */
    public static final d f8551d = new b().d();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f8552a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8553b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f8554c;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private boolean f8555a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f8556b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f8557c;

        public d d() {
            if (this.f8555a || !(this.f8556b || this.f8557c)) {
                return new d(this);
            }
            throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
        }

        public b e(boolean z12) {
            this.f8555a = z12;
            return this;
        }

        public b f(boolean z12) {
            this.f8556b = z12;
            return this;
        }

        public b g(boolean z12) {
            this.f8557c = z12;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f8552a == dVar.f8552a && this.f8553b == dVar.f8553b && this.f8554c == dVar.f8554c;
    }

    public int hashCode() {
        return ((this.f8552a ? 1 : 0) << 2) + ((this.f8553b ? 1 : 0) << 1) + (this.f8554c ? 1 : 0);
    }

    private d(b bVar) {
        this.f8552a = bVar.f8555a;
        this.f8553b = bVar.f8556b;
        this.f8554c = bVar.f8557c;
    }
}
