package v5;

/* renamed from: v5.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1693a {

    /* renamed from: a, reason: collision with root package name */
    public final int f23066a;

    /* renamed from: b, reason: collision with root package name */
    public final int f23067b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23068c;

    public C1693a(int i7, int i8, int i9) {
        this.f23066a = i7;
        this.f23067b = i8;
        this.f23068c = i9;
    }

    public final int a() {
        return this.f23066a;
    }

    public final int b() {
        return this.f23068c;
    }

    public final int c() {
        return this.f23067b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1693a)) {
            return false;
        }
        C1693a c1693a = (C1693a) obj;
        return this.f23066a == c1693a.f23066a && this.f23067b == c1693a.f23067b && this.f23068c == c1693a.f23068c;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f23066a) * 31) + Integer.hashCode(this.f23067b)) * 31) + Integer.hashCode(this.f23068c);
    }

    public String toString() {
        return "AudioFormat(bitsPerSample=" + this.f23066a + ", sampleRate=" + this.f23067b + ", numberOfChannels=" + this.f23068c + ')';
    }
}
