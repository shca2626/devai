package androidx.work;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final Set<a> f11994a = new HashSet();

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Uri f11995a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f11996b;

        a(Uri uri, boolean z12) {
            this.f11995a = uri;
            this.f11996b = z12;
        }

        public Uri a() {
            return this.f11995a;
        }

        public boolean b() {
            return this.f11996b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f11996b == aVar.f11996b && this.f11995a.equals(aVar.f11995a);
        }

        public int hashCode() {
            return (this.f11995a.hashCode() * 31) + (this.f11996b ? 1 : 0);
        }
    }

    public void a(Uri uri, boolean z12) {
        this.f11994a.add(new a(uri, z12));
    }

    public Set<a> b() {
        return this.f11994a;
    }

    public int c() {
        return this.f11994a.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        return this.f11994a.equals(((d) obj).f11994a);
    }

    public int hashCode() {
        return this.f11994a.hashCode();
    }
}
