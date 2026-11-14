package g1;

import D1.s;
import android.net.Uri;
import java.util.Map;

/* renamed from: g1.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC1092v {

    /* renamed from: a, reason: collision with root package name */
    public static final InterfaceC1092v f16148a = new InterfaceC1092v() { // from class: g1.u
        @Override // g1.InterfaceC1092v
        public final InterfaceC1088q[] d() {
            return InterfaceC1092v.b();
        }
    };

    static /* synthetic */ InterfaceC1088q[] b() {
        return new InterfaceC1088q[0];
    }

    InterfaceC1088q[] d();

    default InterfaceC1088q[] f(Uri uri, Map map) {
        return d();
    }

    default InterfaceC1092v a(s.a aVar) {
        return this;
    }

    default InterfaceC1092v c(int i7) {
        return this;
    }

    default InterfaceC1092v e(boolean z7) {
        return this;
    }
}
