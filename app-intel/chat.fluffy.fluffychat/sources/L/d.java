package L;

import Y.h;
import android.content.LocusId;
import android.os.Build;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f5424a;

    /* renamed from: b, reason: collision with root package name */
    public final LocusId f5425b;

    public static class a {
        public static LocusId a(String str) {
            return new LocusId(str);
        }

        public static String b(LocusId locusId) {
            return locusId.getId();
        }
    }

    public d(String str) {
        this.f5424a = (String) h.m(str, "id cannot be empty");
        if (Build.VERSION.SDK_INT >= 29) {
            this.f5425b = a.a(str);
        } else {
            this.f5425b = null;
        }
    }

    public static d d(LocusId locusId) {
        h.k(locusId, "locusId cannot be null");
        return new d((String) h.m(a.b(locusId), "id cannot be empty"));
    }

    public String a() {
        return this.f5424a;
    }

    public final String b() {
        return this.f5424a.length() + "_chars";
    }

    public LocusId c() {
        return this.f5425b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.f5424a;
        return str == null ? dVar.f5424a == null : str.equals(dVar.f5424a);
    }

    public int hashCode() {
        String str = this.f5424a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "LocusIdCompat[" + b() + "]";
    }
}
