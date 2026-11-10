package j6;

import M5.m;
import android.content.Context;
import h5.o;
import io.flutter.plugin.platform.AbstractC1180l;
import io.flutter.plugin.platform.InterfaceC1179k;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class f extends AbstractC1180l {

    /* renamed from: b, reason: collision with root package name */
    public final h5.b f18802b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(h5.b bVar) {
        super(o.f16907a);
        m.e(bVar, "messenger");
        this.f18802b = bVar;
    }

    @Override // io.flutter.plugin.platform.AbstractC1180l
    public InterfaceC1179k a(Context context, int i7, Object obj) {
        m.c(obj, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
        HashMap map = (HashMap) obj;
        if (context != null) {
            return new e(context, this.f18802b, i7, map);
        }
        throw new IllegalArgumentException("Required value was null.");
    }
}
