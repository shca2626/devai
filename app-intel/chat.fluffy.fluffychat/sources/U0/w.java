package U0;

import E0.U;
import android.net.Uri;
import java.util.HashMap;
import java.util.Objects;
import k3.AbstractC1278v;
import k3.AbstractC1280x;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC1280x f8389a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC1278v f8390b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8391c;

    /* renamed from: d, reason: collision with root package name */
    public final String f8392d;

    /* renamed from: e, reason: collision with root package name */
    public final String f8393e;

    /* renamed from: f, reason: collision with root package name */
    public final int f8394f;

    /* renamed from: g, reason: collision with root package name */
    public final Uri f8395g;

    /* renamed from: h, reason: collision with root package name */
    public final String f8396h;

    /* renamed from: i, reason: collision with root package name */
    public final String f8397i;

    /* renamed from: j, reason: collision with root package name */
    public final String f8398j;

    /* renamed from: k, reason: collision with root package name */
    public final String f8399k;

    /* renamed from: l, reason: collision with root package name */
    public final String f8400l;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final HashMap f8401a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public final AbstractC1278v.a f8402b = new AbstractC1278v.a();

        /* renamed from: c, reason: collision with root package name */
        public int f8403c = -1;

        /* renamed from: d, reason: collision with root package name */
        public String f8404d;

        /* renamed from: e, reason: collision with root package name */
        public String f8405e;

        /* renamed from: f, reason: collision with root package name */
        public String f8406f;

        /* renamed from: g, reason: collision with root package name */
        public Uri f8407g;

        /* renamed from: h, reason: collision with root package name */
        public String f8408h;

        /* renamed from: i, reason: collision with root package name */
        public String f8409i;

        /* renamed from: j, reason: collision with root package name */
        public String f8410j;

        /* renamed from: k, reason: collision with root package name */
        public String f8411k;

        /* renamed from: l, reason: collision with root package name */
        public String f8412l;

        public b m(String str, String str2) {
            this.f8401a.put(str, str2);
            return this;
        }

        public b n(U0.a aVar) {
            this.f8402b.a(aVar);
            return this;
        }

        public w o() {
            return new w(this);
        }

        public b p(int i7) {
            this.f8403c = i7;
            return this;
        }

        public b q(String str) {
            this.f8408h = str;
            return this;
        }

        public b r(String str) {
            this.f8411k = str;
            return this;
        }

        public b s(String str) {
            this.f8409i = str;
            return this;
        }

        public b t(String str) {
            this.f8405e = str;
            return this;
        }

        public b u(String str) {
            this.f8412l = str;
            return this;
        }

        public b v(String str) {
            this.f8410j = str;
            return this;
        }

        public b w(String str) {
            this.f8404d = str;
            return this;
        }

        public b x(String str) {
            this.f8406f = str;
            return this;
        }

        public b y(Uri uri) {
            this.f8407g = uri;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && w.class == obj.getClass()) {
            w wVar = (w) obj;
            if (this.f8394f == wVar.f8394f && this.f8389a.equals(wVar.f8389a) && this.f8390b.equals(wVar.f8390b) && Objects.equals(this.f8392d, wVar.f8392d) && Objects.equals(this.f8391c, wVar.f8391c) && Objects.equals(this.f8393e, wVar.f8393e) && Objects.equals(this.f8400l, wVar.f8400l) && Objects.equals(this.f8395g, wVar.f8395g) && Objects.equals(this.f8398j, wVar.f8398j) && Objects.equals(this.f8399k, wVar.f8399k) && Objects.equals(this.f8396h, wVar.f8396h) && Objects.equals(this.f8397i, wVar.f8397i)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((217 + this.f8389a.hashCode()) * 31) + this.f8390b.hashCode()) * 31;
        String str = this.f8392d;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f8391c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f8393e;
        int iHashCode4 = (((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f8394f) * 31;
        String str4 = this.f8400l;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Uri uri = this.f8395g;
        int iHashCode6 = (iHashCode5 + (uri == null ? 0 : uri.hashCode())) * 31;
        String str5 = this.f8398j;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f8399k;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f8396h;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.f8397i;
        return iHashCode9 + (str8 != null ? str8.hashCode() : 0);
    }

    public w(b bVar) {
        this.f8389a = AbstractC1280x.c(bVar.f8401a);
        this.f8390b = bVar.f8402b.k();
        this.f8391c = (String) U.i(bVar.f8404d);
        this.f8392d = (String) U.i(bVar.f8405e);
        this.f8393e = (String) U.i(bVar.f8406f);
        this.f8395g = bVar.f8407g;
        this.f8396h = bVar.f8408h;
        this.f8394f = bVar.f8403c;
        this.f8397i = bVar.f8409i;
        this.f8398j = bVar.f8411k;
        this.f8399k = bVar.f8412l;
        this.f8400l = bVar.f8410j;
    }
}
