package N0;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes.dex */
public final class O extends IOException {

    /* renamed from: l, reason: collision with root package name */
    public final G0.j f5810l;

    /* renamed from: m, reason: collision with root package name */
    public final Uri f5811m;

    /* renamed from: n, reason: collision with root package name */
    public final Map f5812n;

    /* renamed from: o, reason: collision with root package name */
    public final long f5813o;

    public O(G0.j jVar, Uri uri, Map map, long j7, Throwable th) {
        super(th);
        this.f5810l = jVar;
        this.f5811m = uri;
        this.f5812n = map;
        this.f5813o = j7;
    }
}
