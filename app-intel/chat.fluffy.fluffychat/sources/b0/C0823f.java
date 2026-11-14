package b0;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;

/* renamed from: b0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0823f {

    /* renamed from: a, reason: collision with root package name */
    public final c f13506a;

    /* renamed from: b0.f$c */
    public interface c {
        Uri a();

        void b();

        Uri c();

        ClipDescription d();

        Object e();
    }

    public C0823f(Uri uri, ClipDescription clipDescription, Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.f13506a = new a(uri, clipDescription, uri2);
        } else {
            this.f13506a = new b(uri, clipDescription, uri2);
        }
    }

    public static C0823f f(Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new C0823f(new a(obj));
        }
        return null;
    }

    public Uri a() {
        return this.f13506a.a();
    }

    public ClipDescription b() {
        return this.f13506a.d();
    }

    public Uri c() {
        return this.f13506a.c();
    }

    public void d() {
        this.f13506a.b();
    }

    public Object e() {
        return this.f13506a.e();
    }

    /* renamed from: b0.f$a */
    public static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        public final InputContentInfo f13507a;

        public a(Object obj) {
            this.f13507a = (InputContentInfo) obj;
        }

        @Override // b0.C0823f.c
        public Uri a() {
            return this.f13507a.getContentUri();
        }

        @Override // b0.C0823f.c
        public void b() {
            this.f13507a.requestPermission();
        }

        @Override // b0.C0823f.c
        public Uri c() {
            return this.f13507a.getLinkUri();
        }

        @Override // b0.C0823f.c
        public ClipDescription d() {
            return this.f13507a.getDescription();
        }

        @Override // b0.C0823f.c
        public Object e() {
            return this.f13507a;
        }

        public a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f13507a = new InputContentInfo(uri, clipDescription, uri2);
        }
    }

    public C0823f(c cVar) {
        this.f13506a = cVar;
    }

    /* renamed from: b0.f$b */
    public static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f13508a;

        /* renamed from: b, reason: collision with root package name */
        public final ClipDescription f13509b;

        /* renamed from: c, reason: collision with root package name */
        public final Uri f13510c;

        public b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f13508a = uri;
            this.f13509b = clipDescription;
            this.f13510c = uri2;
        }

        @Override // b0.C0823f.c
        public Uri a() {
            return this.f13508a;
        }

        @Override // b0.C0823f.c
        public Uri c() {
            return this.f13510c;
        }

        @Override // b0.C0823f.c
        public ClipDescription d() {
            return this.f13509b;
        }

        @Override // b0.C0823f.c
        public Object e() {
            return null;
        }

        @Override // b0.C0823f.c
        public void b() {
        }
    }
}
