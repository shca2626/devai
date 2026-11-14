package z4;

import android.net.Uri;
import java.util.HashMap;
import y5.C1812h;
import z5.C1866G;

/* renamed from: z4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1844a {

    /* renamed from: a, reason: collision with root package name */
    public final String f24103a;

    /* renamed from: b, reason: collision with root package name */
    public final String f24104b;

    /* renamed from: c, reason: collision with root package name */
    public final Uri f24105c;

    /* renamed from: d, reason: collision with root package name */
    public final long f24106d;

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f24107e;

    /* renamed from: z4.a$a, reason: collision with other inner class name */
    public static final class C0296a {

        /* renamed from: a, reason: collision with root package name */
        public String f24108a;

        /* renamed from: b, reason: collision with root package name */
        public String f24109b;

        /* renamed from: c, reason: collision with root package name */
        public Uri f24110c;

        /* renamed from: d, reason: collision with root package name */
        public long f24111d;

        /* renamed from: e, reason: collision with root package name */
        public HashMap f24112e;

        public final C1844a a() {
            return new C1844a(this.f24108a, this.f24109b, this.f24110c, this.f24111d, this.f24112e);
        }

        public final C0296a b(String str) {
            this.f24109b = str;
            return this;
        }

        public final C0296a c(String str) {
            this.f24108a = str;
            return this;
        }

        public final C0296a d(HashMap map) {
            this.f24112e = map;
            return this;
        }

        public final C0296a e(long j7) {
            this.f24111d = j7;
            return this;
        }

        public final C0296a f(Uri uri) {
            this.f24110c = uri;
            return this;
        }
    }

    public C1844a(String str, String str2, Uri uri, long j7, HashMap map) {
        this.f24103a = str;
        this.f24104b = str2;
        this.f24105c = uri;
        this.f24106d = j7;
        this.f24107e = map;
    }

    public final HashMap a() {
        return C1866G.j(new C1812h("path", this.f24103a), new C1812h("name", this.f24104b), new C1812h("size", Long.valueOf(this.f24106d)), new C1812h("identifier", String.valueOf(this.f24105c)), new C1812h("safHandle", this.f24107e));
    }
}
