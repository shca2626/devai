package D1;

import java.util.List;
import k3.AbstractC1278v;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC1278v f1611a;

    /* renamed from: b, reason: collision with root package name */
    public final long f1612b;

    /* renamed from: c, reason: collision with root package name */
    public final long f1613c;

    /* renamed from: d, reason: collision with root package name */
    public final long f1614d;

    public e(List list, long j7, long j8) {
        this.f1611a = AbstractC1278v.r(list);
        this.f1612b = j7;
        this.f1613c = j8;
        long j9 = -9223372036854775807L;
        if (j7 != -9223372036854775807L && j8 != -9223372036854775807L) {
            j9 = j7 + j8;
        }
        this.f1614d = j9;
    }
}
