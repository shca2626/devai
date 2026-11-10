package W;

import O.s;
import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class i {
    public static Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr) {
        return s.b(context, cancellationSignal, bVarArr, 0);
    }

    public static a b(Context context, CancellationSignal cancellationSignal, e eVar) {
        return d.e(context, g.a(new Object[]{eVar}), cancellationSignal);
    }

    public static Typeface c(Context context, List list, int i7, boolean z7, int i8, Handler handler, c cVar) {
        W.a aVar = new W.a(cVar, j.b(handler));
        if (!z7) {
            return h.d(context, list, i7, null, aVar);
        }
        if (list.size() <= 1) {
            return h.e(context, (e) list.get(0), aVar, i7, i8);
        }
        throw new IllegalArgumentException("Fallbacks with blocking fetches are not supported for performance reasons");
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f8927a;

        /* renamed from: b, reason: collision with root package name */
        public final List f8928b;

        public a(int i7, b[] bVarArr) {
            this.f8927a = i7;
            this.f8928b = Collections.singletonList(bVarArr);
        }

        public static a a(int i7, List list) {
            return new a(i7, list);
        }

        public static a b(int i7, b[] bVarArr) {
            return new a(i7, bVarArr);
        }

        public b[] c() {
            return (b[]) this.f8928b.get(0);
        }

        public List d() {
            return this.f8928b;
        }

        public int e() {
            return this.f8927a;
        }

        public boolean f() {
            return this.f8928b.size() > 1;
        }

        public a(int i7, List list) {
            this.f8927a = i7;
            this.f8928b = list;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f8929a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8930b;

        /* renamed from: c, reason: collision with root package name */
        public final int f8931c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f8932d;

        /* renamed from: e, reason: collision with root package name */
        public final String f8933e;

        /* renamed from: f, reason: collision with root package name */
        public final int f8934f;

        public b(Uri uri, int i7, int i8, boolean z7, String str, int i9) {
            this.f8929a = (Uri) Y.h.j(uri);
            this.f8930b = i7;
            this.f8931c = i8;
            this.f8932d = z7;
            this.f8933e = str;
            this.f8934f = i9;
        }

        public int a() {
            return this.f8934f;
        }

        public String b() {
            if (h()) {
                return this.f8929a.getAuthority();
            }
            return null;
        }

        public int c() {
            return this.f8930b;
        }

        public Uri d() {
            return this.f8929a;
        }

        public String e() {
            return this.f8933e;
        }

        public int f() {
            return this.f8931c;
        }

        public boolean g() {
            return this.f8932d;
        }

        public boolean h() {
            return Objects.equals(this.f8929a.getScheme(), "systemfont");
        }

        public b(String str, String str2) {
            this.f8929a = new Uri.Builder().scheme("systemfont").authority(str).build();
            this.f8930b = 0;
            this.f8931c = 400;
            this.f8932d = false;
            this.f8933e = str2;
            this.f8934f = 0;
        }
    }

    public static class c {
        public void a(int i7) {
        }

        public void b(Typeface typeface) {
        }
    }
}
