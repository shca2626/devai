package N4;

import java.util.List;
import z5.C1881o;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: c, reason: collision with root package name */
    public static final a f6443c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final n f6444a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6445b;

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final o a(List list) {
            M5.m.e(list, "pigeonVar_list");
            Object obj = list.get(0);
            M5.m.c(obj, "null cannot be cast to non-null type dev.flutter.packages.file_selector_android.FileSelectorExceptionCode");
            Object obj2 = list.get(1);
            M5.m.c(obj2, "null cannot be cast to non-null type kotlin.String");
            return new o((n) obj, (String) obj2);
        }

        public a() {
        }
    }

    public o(n nVar, String str) {
        M5.m.e(nVar, "fileSelectorExceptionCode");
        M5.m.e(str, "message");
        this.f6444a = nVar;
        this.f6445b = str;
    }

    public final List a() {
        return C1881o.l(this.f6444a, this.f6445b);
    }

    public boolean equals(Object obj) {
        if (obj != null && M5.m.a(obj.getClass(), o.class)) {
            if (this == obj) {
                return true;
            }
            o oVar = (o) obj;
            s sVar = s.f6449a;
            if (sVar.a(this.f6444a, oVar.f6444a) && sVar.a(this.f6445b, oVar.f6445b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = o.class.hashCode() * 31;
        s sVar = s.f6449a;
        return ((iHashCode + sVar.b(this.f6444a)) * 31) + sVar.b(this.f6445b);
    }

    public String toString() {
        return "FileSelectorNativeException(fileSelectorExceptionCode=" + this.f6444a + ", message=" + this.f6445b + ")";
    }
}
