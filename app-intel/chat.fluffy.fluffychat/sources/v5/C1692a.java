package v5;

/* renamed from: v5.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1692a {

    /* renamed from: a, reason: collision with root package name */
    public final int f23072a;

    /* renamed from: b, reason: collision with root package name */
    public final int f23073b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23074c;

    public C1692a(int i7, int i8, int i9) {
        this.f23072a = i7;
        this.f23073b = i8;
        this.f23074c = i9;
    }

    public final int a() {
        return this.f23072a;
    }

    public final int b() {
        return this.f23074c;
    }

    public final int c() {
        return this.f23073b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1692a)) {
            return false;
        }
        C1692a c1692a = (C1692a) obj;
        return this.f23072a == c1692a.f23072a && this.f23073b == c1692a.f23073b && this.f23074c == c1692a.f23074c;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f23072a) * 31) + Integer.hashCode(this.f23073b)) * 31) + Integer.hashCode(this.f23074c);
    }

    public String toString() {
        return "AudioFormat(bitsPerSample=" + this.f23072a + ", sampleRate=" + this.f23073b + ", numberOfChannels=" + this.f23074c + ')';
    }
}
