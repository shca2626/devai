package j0;

import M5.m;
import androidx.datastore.preferences.protobuf.C0790v;
import h0.C1128d;
import java.io.InputStream;

/* renamed from: j0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1220d {

    /* renamed from: a, reason: collision with root package name */
    public static final a f18669a = new a(null);

    /* renamed from: j0.d$a */
    public static final class a {
        public /* synthetic */ a(M5.g gVar) {
            this();
        }

        public final C1222f a(InputStream inputStream) throws C1128d {
            m.e(inputStream, "input");
            try {
                C1222f c1222fY = C1222f.Y(inputStream);
                m.d(c1222fY, "{\n                Prefer…From(input)\n            }");
                return c1222fY;
            } catch (C0790v e7) {
                throw new C1128d("Unable to parse preferences proto.", e7);
            }
        }

        public a() {
        }
    }
}
