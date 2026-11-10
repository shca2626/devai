package g;

import M5.m;
import android.content.Context;
import android.content.Intent;
import f.C1037a;

/* loaded from: classes.dex */
public final class l extends AbstractC1065a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15923a = new a(null);

    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public a() {
        }
    }

    @Override // g.AbstractC1065a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, Intent intent) {
        m.e(context, "context");
        m.e(intent, "input");
        return intent;
    }

    @Override // g.AbstractC1065a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C1037a c(int i7, Intent intent) {
        return new C1037a(i7, intent);
    }
}
