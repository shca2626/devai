package B0;

import java.io.IOException;

/* loaded from: classes.dex */
public class A extends IOException {

    /* renamed from: l, reason: collision with root package name */
    public final boolean f326l;

    /* renamed from: m, reason: collision with root package name */
    public final int f327m;

    public A(String str, Throwable th, boolean z7, int i7) {
        super(str, th);
        this.f326l = z7;
        this.f327m = i7;
    }

    public static A a(String str, Throwable th) {
        return new A(str, th, true, 1);
    }

    public static A b(String str, Throwable th) {
        return new A(str, th, true, 0);
    }

    public static A c(String str, Throwable th) {
        return new A(str, th, true, 4);
    }

    public static A d(String str, Throwable th) {
        return new A(str, th, false, 4);
    }

    public static A e(String str) {
        return new A(str, null, false, 1);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String str;
        String message = super.getMessage();
        StringBuilder sb = new StringBuilder();
        if (message != null) {
            str = message + " ";
        } else {
            str = "";
        }
        sb.append(str);
        sb.append("{contentIsMalformed=");
        sb.append(this.f326l);
        sb.append(", dataType=");
        sb.append(this.f327m);
        sb.append("}");
        return sb.toString();
    }
}
