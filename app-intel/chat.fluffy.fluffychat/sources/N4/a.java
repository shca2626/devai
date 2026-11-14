package N4;

import java.util.Arrays;
import java.util.List;
import z5.C1884o;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name */
    public static final C0056a f6405g = new C0056a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f6406a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6407b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6408c;

    /* renamed from: d, reason: collision with root package name */
    public final long f6409d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f6410e;

    /* renamed from: f, reason: collision with root package name */
    public final o f6411f;

    /* renamed from: N4.a$a, reason: collision with other inner class name */
    public static final class C0056a {
        public /* synthetic */ C0056a(M5.g gVar) {
            this();
        }

        public final a a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj;
            String str2 = (String) list.get(1);
            String str3 = (String) list.get(2);
            Object obj2 = list.get(3);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.Long");
            long jLongValue = ((Long) obj2).longValue();
            Object obj3 = list.get(4);
            M5.m.c(obj3, "null cannot be cast to non-null type kotlin.ByteArray");
            return new a(str, str2, str3, jLongValue, (byte[]) obj3, (o) list.get(5));
        }

        public C0056a() {
        }
    }

    public a(String str, String str2, String str3, long j7, byte[] bArr, o oVar) {
        M5.m.e(str, "path");
        M5.m.e(bArr, "bytes");
        this.f6406a = str;
        this.f6407b = str2;
        this.f6408c = str3;
        this.f6409d = j7;
        this.f6410e = bArr;
        this.f6411f = oVar;
    }

    public final List a() {
        return C1884o.l(this.f6406a, this.f6407b, this.f6408c, Long.valueOf(this.f6409d), this.f6410e, this.f6411f);
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), a.class)) {
            if (this == obj) {
                return true;
            }
            a aVar = (a) obj;
            s sVar = s.f6449a;
            if (sVar.a(this.f6406a, aVar.f6406a) && sVar.a(this.f6407b, aVar.f6407b) && sVar.a(this.f6408c, aVar.f6408c) && sVar.a(Long.valueOf(this.f6409d), Long.valueOf(aVar.f6409d)) && sVar.a(this.f6410e, aVar.f6410e) && sVar.a(this.f6411f, aVar.f6411f)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = a.class.hashCode() * 31;
        s sVar = s.f6449a;
        return ((((((((((iHashCode + sVar.b(this.f6406a)) * 31) + sVar.b(this.f6407b)) * 31) + sVar.b(this.f6408c)) * 31) + sVar.b(Long.valueOf(this.f6409d))) * 31) + sVar.b(this.f6410e)) * 31) + sVar.b(this.f6411f);
    }

    public String toString() {
        return "FileResponse(path=" + this.f6406a + ", mimeType=" + this.f6407b + ", name=" + this.f6408c + ", size=" + this.f6409d + ", bytes=" + Arrays.toString(this.f6410e) + ", fileSelectorNativeException=" + this.f6411f + ")";
    }
}
