package G0;

import android.net.Uri;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f3143a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3144b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3145c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f3146d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f3147e;

    /* renamed from: f, reason: collision with root package name */
    public final long f3148f;

    /* renamed from: g, reason: collision with root package name */
    public final long f3149g;

    /* renamed from: h, reason: collision with root package name */
    public final long f3150h;

    /* renamed from: i, reason: collision with root package name */
    public final String f3151i;

    /* renamed from: j, reason: collision with root package name */
    public final int f3152j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f3153k;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public Uri f3154a;

        /* renamed from: b, reason: collision with root package name */
        public long f3155b;

        /* renamed from: c, reason: collision with root package name */
        public int f3156c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f3157d;

        /* renamed from: e, reason: collision with root package name */
        public Map f3158e;

        /* renamed from: f, reason: collision with root package name */
        public long f3159f;

        /* renamed from: g, reason: collision with root package name */
        public long f3160g;

        /* renamed from: h, reason: collision with root package name */
        public String f3161h;

        /* renamed from: i, reason: collision with root package name */
        public int f3162i;

        /* renamed from: j, reason: collision with root package name */
        public Object f3163j;

        public j a() {
            j3.o.r(this.f3154a, "The uri must be set.");
            return new j(this.f3154a, this.f3155b, this.f3156c, this.f3157d, this.f3158e, this.f3159f, this.f3160g, this.f3161h, this.f3162i, this.f3163j);
        }

        public b b(int i7) {
            this.f3162i = i7;
            return this;
        }

        public b c(byte[] bArr) {
            this.f3157d = bArr;
            return this;
        }

        public b d(int i7) {
            this.f3156c = i7;
            return this;
        }

        public b e(Map map) {
            this.f3158e = map;
            return this;
        }

        public b f(String str) {
            this.f3161h = str;
            return this;
        }

        public b g(long j7) {
            this.f3160g = j7;
            return this;
        }

        public b h(long j7) {
            this.f3159f = j7;
            return this;
        }

        public b i(Uri uri) {
            this.f3154a = uri;
            return this;
        }

        public b j(String str) {
            this.f3154a = Uri.parse(str);
            return this;
        }

        public b() {
            this.f3156c = 1;
            this.f3158e = Collections.EMPTY_MAP;
            this.f3160g = -1L;
        }

        public b(j jVar) {
            this.f3154a = jVar.f3143a;
            this.f3155b = jVar.f3144b;
            this.f3156c = jVar.f3145c;
            this.f3157d = jVar.f3146d;
            this.f3158e = jVar.f3147e;
            this.f3159f = jVar.f3149g;
            this.f3160g = jVar.f3150h;
            this.f3161h = jVar.f3151i;
            this.f3162i = jVar.f3152j;
            this.f3163j = jVar.f3153k;
        }
    }

    static {
        B0.w.a("media3.datasource");
    }

    public static String c(int i7) {
        if (i7 == 1) {
            return "GET";
        }
        if (i7 == 2) {
            return "POST";
        }
        if (i7 == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }

    public b a() {
        return new b();
    }

    public final String b() {
        return c(this.f3145c);
    }

    public boolean d(int i7) {
        return (this.f3152j & i7) == i7;
    }

    public j e(long j7) {
        long j8 = this.f3150h;
        return f(j7, j8 != -1 ? j8 - j7 : -1L);
    }

    public j f(long j7, long j8) {
        return (j7 == 0 && this.f3150h == j8) ? this : new j(this.f3143a, this.f3144b, this.f3145c, this.f3146d, this.f3147e, this.f3149g + j7, j8, this.f3151i, this.f3152j, this.f3153k);
    }

    public String toString() {
        return "DataSpec[" + b() + " " + this.f3143a + ", " + this.f3149g + ", " + this.f3150h + ", " + this.f3151i + ", " + this.f3152j + "]";
    }

    public j(Uri uri) {
        this(uri, 0L, -1L);
    }

    public j(Uri uri, long j7, long j8) {
        this(uri, j7, j8, null);
    }

    public j(Uri uri, long j7, long j8, String str) {
        this(uri, 0L, 1, null, Collections.EMPTY_MAP, j7, j8, str, 0, null);
    }

    public j(Uri uri, long j7, int i7, byte[] bArr, Map map, long j8, long j9, String str, int i8, Object obj) {
        byte[] bArr2 = bArr;
        long j10 = j7 + j8;
        j3.o.d(j10 >= 0);
        j3.o.d(j8 >= 0);
        j3.o.d(j9 > 0 || j9 == -1);
        this.f3143a = (Uri) j3.o.q(uri);
        this.f3144b = j7;
        this.f3145c = i7;
        this.f3146d = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.f3147e = Collections.unmodifiableMap(new HashMap(map));
        this.f3149g = j8;
        this.f3148f = j10;
        this.f3150h = j9;
        this.f3151i = str;
        this.f3152j = i8;
        this.f3153k = obj;
    }
}
