package T0;

import android.net.Uri;
import c1.o;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes.dex */
public final class b implements o.a {

    /* renamed from: a, reason: collision with root package name */
    public final o.a f8214a;

    /* renamed from: b, reason: collision with root package name */
    public final List f8215b;

    public b(o.a aVar, List list) {
        this.f8214a = aVar;
        this.f8215b = list;
    }

    @Override // c1.o.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a a(Uri uri, InputStream inputStream) {
        a aVar = (a) this.f8214a.a(uri, inputStream);
        List list = this.f8215b;
        return (list == null || list.isEmpty()) ? aVar : (a) aVar.a(this.f8215b);
    }
}
