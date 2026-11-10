package Y0;

import android.net.Uri;
import java.util.List;
import k3.AbstractC1279v;

/* loaded from: classes.dex */
public class r0 extends B0.A {

    /* renamed from: n, reason: collision with root package name */
    public final Uri f9803n;

    /* renamed from: o, reason: collision with root package name */
    public final AbstractC1279v f9804o;

    public r0(String str, Uri uri, List list) {
        super(str, null, false, 1);
        this.f9803n = uri;
        this.f9804o = AbstractC1279v.r(list);
    }

    @Override // B0.A, java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (this.f9804o.isEmpty()) {
            return message;
        }
        return message + "\nsniff failures: " + this.f9804o;
    }
}
