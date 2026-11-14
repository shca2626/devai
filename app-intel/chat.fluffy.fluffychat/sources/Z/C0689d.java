package Z;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Objects;

/* renamed from: Z.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0689d {

    /* renamed from: a, reason: collision with root package name */
    public final f f10000a;

    /* renamed from: Z.d$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final c f10001a;

        public a(ClipData clipData, int i7) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f10001a = new b(clipData, i7);
            } else {
                this.f10001a = new C0085d(clipData, i7);
            }
        }

        public C0689d a() {
            return this.f10001a.build();
        }

        public a b(Bundle bundle) {
            this.f10001a.setExtras(bundle);
            return this;
        }

        public a c(int i7) {
            this.f10001a.a(i7);
            return this;
        }

        public a d(Uri uri) {
            this.f10001a.b(uri);
            return this;
        }
    }

    /* renamed from: Z.d$b */
    public static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        public final ContentInfo.Builder f10002a;

        public b(ClipData clipData, int i7) {
            this.f10002a = AbstractC0695g.a(clipData, i7);
        }

        @Override // Z.C0689d.c
        public void a(int i7) {
            this.f10002a.setFlags(i7);
        }

        @Override // Z.C0689d.c
        public void b(Uri uri) {
            this.f10002a.setLinkUri(uri);
        }

        @Override // Z.C0689d.c
        public C0689d build() {
            return new C0689d(new e(this.f10002a.build()));
        }

        @Override // Z.C0689d.c
        public void setExtras(Bundle bundle) {
            this.f10002a.setExtras(bundle);
        }
    }

    /* renamed from: Z.d$c */
    public interface c {
        void a(int i7);

        void b(Uri uri);

        C0689d build();

        void setExtras(Bundle bundle);
    }

    /* renamed from: Z.d$d, reason: collision with other inner class name */
    public static final class C0085d implements c {

        /* renamed from: a, reason: collision with root package name */
        public ClipData f10003a;

        /* renamed from: b, reason: collision with root package name */
        public int f10004b;

        /* renamed from: c, reason: collision with root package name */
        public int f10005c;

        /* renamed from: d, reason: collision with root package name */
        public Uri f10006d;

        /* renamed from: e, reason: collision with root package name */
        public Bundle f10007e;

        public C0085d(ClipData clipData, int i7) {
            this.f10003a = clipData;
            this.f10004b = i7;
        }

        @Override // Z.C0689d.c
        public void a(int i7) {
            this.f10005c = i7;
        }

        @Override // Z.C0689d.c
        public void b(Uri uri) {
            this.f10006d = uri;
        }

        @Override // Z.C0689d.c
        public C0689d build() {
            return new C0689d(new g(this));
        }

        @Override // Z.C0689d.c
        public void setExtras(Bundle bundle) {
            this.f10007e = bundle;
        }
    }

    /* renamed from: Z.d$e */
    public static final class e implements f {

        /* renamed from: a, reason: collision with root package name */
        public final ContentInfo f10008a;

        public e(ContentInfo contentInfo) {
            this.f10008a = AbstractC0687c.a(Y.h.j(contentInfo));
        }

        @Override // Z.C0689d.f
        public ClipData a() {
            return this.f10008a.getClip();
        }

        @Override // Z.C0689d.f
        public int b() {
            return this.f10008a.getFlags();
        }

        @Override // Z.C0689d.f
        public ContentInfo c() {
            return this.f10008a;
        }

        @Override // Z.C0689d.f
        public int d() {
            return this.f10008a.getSource();
        }

        public String toString() {
            return "ContentInfoCompat{" + this.f10008a + "}";
        }
    }

    /* renamed from: Z.d$f */
    public interface f {
        ClipData a();

        int b();

        ContentInfo c();

        int d();
    }

    /* renamed from: Z.d$g */
    public static final class g implements f {

        /* renamed from: a, reason: collision with root package name */
        public final ClipData f10009a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10010b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10011c;

        /* renamed from: d, reason: collision with root package name */
        public final Uri f10012d;

        /* renamed from: e, reason: collision with root package name */
        public final Bundle f10013e;

        public g(C0085d c0085d) {
            this.f10009a = (ClipData) Y.h.j(c0085d.f10003a);
            this.f10010b = Y.h.e(c0085d.f10004b, 0, 5, "source");
            this.f10011c = Y.h.i(c0085d.f10005c, 1);
            this.f10012d = c0085d.f10006d;
            this.f10013e = c0085d.f10007e;
        }

        @Override // Z.C0689d.f
        public ClipData a() {
            return this.f10009a;
        }

        @Override // Z.C0689d.f
        public int b() {
            return this.f10011c;
        }

        @Override // Z.C0689d.f
        public ContentInfo c() {
            return null;
        }

        @Override // Z.C0689d.f
        public int d() {
            return this.f10010b;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("ContentInfoCompat{clip=");
            sb.append(this.f10009a.getDescription());
            sb.append(", source=");
            sb.append(C0689d.e(this.f10010b));
            sb.append(", flags=");
            sb.append(C0689d.a(this.f10011c));
            if (this.f10012d == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + this.f10012d.toString().length() + ")";
            }
            sb.append(str);
            sb.append(this.f10013e != null ? ", hasExtras" : "");
            sb.append("}");
            return sb.toString();
        }
    }

    public C0689d(f fVar) {
        this.f10000a = fVar;
    }

    public static String a(int i7) {
        return (i7 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i7);
    }

    public static String e(int i7) {
        return i7 != 0 ? i7 != 1 ? i7 != 2 ? i7 != 3 ? i7 != 4 ? i7 != 5 ? String.valueOf(i7) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    public static C0689d g(ContentInfo contentInfo) {
        return new C0689d(new e(contentInfo));
    }

    public ClipData b() {
        return this.f10000a.a();
    }

    public int c() {
        return this.f10000a.b();
    }

    public int d() {
        return this.f10000a.d();
    }

    public ContentInfo f() {
        ContentInfo contentInfoC = this.f10000a.c();
        Objects.requireNonNull(contentInfoC);
        return AbstractC0687c.a(contentInfoC);
    }

    public String toString() {
        return this.f10000a.toString();
    }
}
