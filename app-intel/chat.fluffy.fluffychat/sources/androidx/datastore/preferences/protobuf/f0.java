package androidx.datastore.preferences.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public class f0 extends RuntimeException {

    /* renamed from: l, reason: collision with root package name */
    public final List f12037l;

    public f0(K k7) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.f12037l = null;
    }

    public C0791v a() {
        return new C0791v(getMessage());
    }
}
