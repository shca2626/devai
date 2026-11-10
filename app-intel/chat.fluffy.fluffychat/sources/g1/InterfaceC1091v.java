package g1;

import D1.s;
import android.net.Uri;
import java.util.Map;

/* renamed from: g1.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC1091v {

    /* renamed from: a, reason: collision with root package name */
    public static final InterfaceC1091v f16148a = new InterfaceC1091v() { // from class: g1.u
        @Override // g1.InterfaceC1091v
        public final InterfaceC1087q[] d() {
            return InterfaceC1091v.b();
        }
    };

    static /* synthetic */ InterfaceC1087q[] b() {
        return new InterfaceC1087q[0];
    }

    InterfaceC1087q[] d();

    default InterfaceC1087q[] f(Uri uri, Map map) {
        return d();
    }

    default InterfaceC1091v a(s.a aVar) {
        return this;
    }

    default InterfaceC1091v c(int i7) {
        return this;
    }

    default InterfaceC1091v e(boolean z7) {
        return this;
    }
}
