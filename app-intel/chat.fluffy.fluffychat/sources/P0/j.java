package P0;

import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class j implements T0.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f7455a;

    /* renamed from: b, reason: collision with root package name */
    public final List f7456b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f7457c;

    public j(String str, List list, boolean z7) {
        this.f7455a = str;
        this.f7456b = Collections.unmodifiableList(list);
        this.f7457c = z7;
    }
}
