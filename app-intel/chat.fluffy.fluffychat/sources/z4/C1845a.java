package z4;

import android.net.Uri;
import java.util.HashMap;
import y5.C1813h;
import z5.C1863G;

/* renamed from: z4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1845a {

    /* renamed from: a, reason: collision with root package name */
    public final String f24097a;

    /* renamed from: b, reason: collision with root package name */
    public final String f24098b;

    /* renamed from: c, reason: collision with root package name */
    public final Uri f24099c;

    /* renamed from: d, reason: collision with root package name */
    public final long f24100d;

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f24101e;

    /* renamed from: z4.a$a, reason: collision with other inner class name */
    public static final class C0296a {

        /* renamed from: a, reason: collision with root package name */
        public String f24102a;

        /* renamed from: b, reason: collision with root package name */
        public String f24103b;

        /* renamed from: c, reason: collision with root package name */
        public Uri f24104c;

        /* renamed from: d, reason: collision with root package name */
        public long f24105d;

        /* renamed from: e, reason: collision with root package name */
        public HashMap f24106e;

        public final C1845a a() {
            return new C1845a(this.f24102a, this.f24103b, this.f24104c, this.f24105d, this.f24106e);
        }

        public final C0296a b(String str) {
            this.f24103b = str;
            return this;
        }

        public final C0296a c(String str) {
            this.f24102a = str;
            return this;
        }

        public final C0296a d(HashMap map) {
            this.f24106e = map;
            return this;
        }

        public final C0296a e(long j7) {
            this.f24105d = j7;
            return this;
        }

        public final C0296a f(Uri uri) {
            this.f24104c = uri;
            return this;
        }
    }

    public C1845a(String str, String str2, Uri uri, long j7, HashMap map) {
        this.f24097a = str;
        this.f24098b = str2;
        this.f24099c = uri;
        this.f24100d = j7;
        this.f24101e = map;
    }

    public final HashMap a() {
        return C1863G.j(new C1813h("path", this.f24097a), new C1813h("name", this.f24098b), new C1813h("size", Long.valueOf(this.f24100d)), new C1813h("identifier", String.valueOf(this.f24099c)), new C1813h("safHandle", this.f24101e));
    }
}
